<?php
include 'db_config.php';

// Get raw POST data and decode JSON
$rawData = file_get_contents("php://input");
$data = json_decode($rawData);

// Check if data was received correctly
if (!$data) {
    echo json_encode(["success" => false, "error" => "Invalid JSON input"]);
    exit;
}

// Extract values safely
$name = isset($data->name) ? mysqli_real_escape_string($conn, $data->name) : '';
$size = isset($data->size) ? mysqli_real_escape_string($conn, $data->size) : NULL;
$image_name = isset($data->image_name) ? mysqli_real_escape_string($conn, $data->image_name) : '';
$quantity = isset($data->quantity) ? (int)$data->quantity : 1; // Default to 1 if not provided

// Ensure required fields are present
if (empty($name) || empty($image_name)) {
    echo json_encode(["success" => false, "error" => "Missing required fields"]);
    exit;
}

// Use the correct column names (image_name instead of image)
$query = "INSERT INTO cart_items (name, size, image_name, quantity) VALUES ('$name', '$size', '$image_name', $quantity)";

if (mysqli_query($conn, $query)) {
    echo json_encode(["success" => true]);
} else {
    echo json_encode(["success" => false, "error" => mysqli_error($conn)]);
}

mysqli_close($conn);
?>
