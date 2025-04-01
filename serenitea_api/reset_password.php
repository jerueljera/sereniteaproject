<?php
require 'db_config.php'; // Ensure this file correctly connects to your database

header("Content-Type: application/json");

// Check if the request is a POST request
if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    echo json_encode(["error" => "Invalid request method"]);
    exit;
}

// Get token and new password safely
$token = isset($_POST['token']) ? trim($_POST['token']) : null;
$newPassword = isset($_POST['password']) ? trim($_POST['password']) : null;

if (!$token || !$newPassword) {
    echo json_encode(["error" => "Token and new password are required"]);
    exit;
}

// Check if token is valid and not expired
$query = "SELECT * FROM users WHERE reset_token=? AND token_expiry > NOW()";
$stmt = mysqli_prepare($connection, $query);
mysqli_stmt_bind_param($stmt, "s", $token);
mysqli_stmt_execute($stmt);
$result = mysqli_stmt_get_result($stmt);

if (mysqli_num_rows($result) > 0) {
    // Hash the new password
    $hashedPassword = password_hash($newPassword, PASSWORD_DEFAULT);

    // Update password and clear token
    $updateQuery = "UPDATE users SET password=?, reset_token=NULL, token_expiry=NULL WHERE reset_token=?";
    $stmt = mysqli_prepare($connection, $updateQuery);
    mysqli_stmt_bind_param($stmt, "ss", $hashedPassword, $token);
    mysqli_stmt_execute($stmt);

    echo json_encode(["message" => "Password reset successful"]);
} else {
    echo json_encode(["error" => "Invalid or expired token"]);
}

mysqli_close($connection);
?>
