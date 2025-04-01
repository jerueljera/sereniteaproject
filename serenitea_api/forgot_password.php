<?php
require 'db_config.php'; // Ensure this file correctly connects to your database

header("Content-Type: application/json");

// Check if the request is a POST request
if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    echo json_encode(["error" => "Invalid request method"]);
    exit;
}

// Get the email safely
$email = isset($_POST['email']) ? trim($_POST['email']) : null;

if (!$email) {
    echo json_encode(["error" => "Email is required"]);
    exit;
}

// Check if email exists in the database
$query = "SELECT * FROM users WHERE email = ?";
$stmt = mysqli_prepare($connection, $query);
mysqli_stmt_bind_param($stmt, "s", $email);
mysqli_stmt_execute($stmt);
$result = mysqli_stmt_get_result($stmt);

if (mysqli_num_rows($result) > 0) {
    // Generate a token
    $token = bin2hex(random_bytes(16));
    $expiry = date('Y-m-d H:i:s', strtotime('+1 hour'));

    // Store the token in the database
    $updateQuery = "UPDATE users SET reset_token=?, token_expiry=? WHERE email=?";
    $stmt = mysqli_prepare($connection, $updateQuery);
    mysqli_stmt_bind_param($stmt, "sss", $token, $expiry, $email);
    mysqli_stmt_execute($stmt);

    // Send the reset link (for now, just print it)
    $resetLink = "http://yourdomain.com/reset_password.php?token=$token";
    echo json_encode(["message" => "Reset link generated", "reset_link" => $resetLink]); // For testing, display the link
} else {
    echo json_encode(["error" => "Email not found"]);
}

mysqli_close($connection);
?>
