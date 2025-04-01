<?php
include 'db_config.php'; // Database connection

header("Content-Type: application/json");

$query = "SELECT * FROM cart_items";
$result = mysqli_query($conn, $query);

$cartItems = array();
while ($row = mysqli_fetch_assoc($result)) {
    $cartItems[] = $row;
}

echo json_encode(["success" => true, "cart_items" => $cartItems]);
mysqli_close($conn);
?>
