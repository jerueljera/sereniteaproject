<?php
header("Content-Type: application/json");

// Database credentials
$host = "localhost";
$user = "root"; // XAMPP default user
$password = ""; // Default is empty
$database = "serenitea_db"; // Ensure this matches your actual database name

// Establish database connection
$conn = new mysqli($host, $user, $password, $database);

// Check for connection errors
if ($conn->connect_error) {
    echo json_encode(["status" => "error", "message" => "Database connection failed: " . $conn->connect_error]);
    exit();
}

// Set UTF-8 encoding for proper data handling
$conn->set_charset("utf8");
?>
