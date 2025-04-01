<?php
include "db_config.php"; // Ensure this file is correctly included

// Accept only POST requests
if ($_SERVER["REQUEST_METHOD"] !== "POST") {
    echo json_encode(["status" => "error", "message" => "Invalid request method"]);
    exit();
}

// Get JSON input
$data = json_decode(file_get_contents("php://input"), true);

if (!isset($data["user_id"], $data["stock_id"], $data["quantity"])) {
    echo json_encode(["status" => "error", "message" => "Missing required parameters"]);
    exit();
}

$user_id = intval($data["user_id"]);
$stock_id = intval($data["stock_id"]);
$quantity = intval($data["quantity"]);

// Validate input values
if ($user_id <= 0 || $stock_id <= 0 || $quantity <= 0) {
    echo json_encode(["status" => "error", "message" => "Invalid input values"]);
    exit();
}

// Check if the user exists
$checkUser = $conn->prepare("SELECT id FROM users WHERE id = ?");
$checkUser->bind_param("i", $user_id);
$checkUser->execute();
$userResult = $checkUser->get_result();

if ($userResult->num_rows === 0) {
    echo json_encode(["status" => "error", "message" => "User not found"]);
    exit();
}
$checkUser->close();

// Check if stock exists and get available quantity
$checkStock = $conn->prepare("SELECT quantity FROM stock WHERE id = ?");
$checkStock->bind_param("i", $stock_id);
$checkStock->execute();
$result = $checkStock->get_result();

if ($result->num_rows === 0) {
    echo json_encode(["status" => "error", "message" => "Stock item not found"]);
    exit();
}

$stockData = $result->fetch_assoc();
$available_quantity = $stockData["quantity"];
$checkStock->close();

// Check stock availability
if ($quantity > $available_quantity) {
    echo json_encode(["status" => "error", "message" => "Not enough stock available"]);
    exit();
}

// Start a database transaction
$conn->begin_transaction();

try {
    // Insert order
    $stmt = $conn->prepare("INSERT INTO orders (user_id, stock_id, quantity) VALUES (?, ?, ?)");
    $stmt->bind_param("iii", $user_id, $stock_id, $quantity);

    if (!$stmt->execute()) {
        throw new Exception("Error placing order: " . $stmt->error);
    }
    $stmt->close();

    // Reduce stock quantity
    $new_quantity = $available_quantity - $quantity;
    $updateStock = $conn->prepare("UPDATE stock SET quantity = ? WHERE id = ?");
    $updateStock->bind_param("ii", $new_quantity, $stock_id);

    if (!$updateStock->execute()) {
        throw new Exception("Error updating stock: " . $updateStock->error);
    }
    $updateStock->close();

    // Commit transaction
    $conn->commit();

    echo json_encode(["status" => "success", "message" => "Order placed successfully"]);

} catch (Exception $e) {
    $conn->rollback();
    echo json_encode(["status" => "error", "message" => $e->getMessage()]);
}

// Close database connection
$conn->close();
?>
