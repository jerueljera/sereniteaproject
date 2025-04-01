<?php
include "db_config.php";

// Allow JSON input
$data = json_decode(file_get_contents("php://input"), true);

// Check if data is sent via JSON or regular POST
$name = isset($_POST['name']) ? trim($_POST['name']) : (isset($data['name']) ? trim($data['name']) : null);
$email = isset($_POST['email']) ? trim($_POST['email']) : (isset($data['email']) ? trim($data['email']) : null);
$password = isset($_POST['password']) ? trim($_POST['password']) : (isset($data['password']) ? trim($data['password']) : null);

if (!$name || !$email || !$password) {
    die(json_encode(["status" => "error", "message" => "All fields are required"]));
}

$hashed_password = password_hash($password, PASSWORD_BCRYPT);

$stmt = $conn->prepare("INSERT INTO users (name, email, password) VALUES (?, ?, ?)");
$stmt->bind_param("sss", $name, $email, $hashed_password);

if ($stmt->execute()) {
    echo json_encode(["status" => "success", "message" => "User registered successfully"]);
} else {
    echo json_encode(["status" => "error", "message" => "Error registering user"]);
}

$stmt->close();
?>
