<?php
include "db_config.php";

$sql = "SELECT * FROM stock";
$result = $conn->query($sql);

$stock = [];

if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        $stock[] = $row;
    }
    echo json_encode(["status" => "success", "stock" => $stock]);
} else {
    echo json_encode(["status" => "error", "message" => "No stock found"]);
}
?>
