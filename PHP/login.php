<?php
require 'config.php';

$email = $_POST['email'];
$password = $_POST['password'];

$sql = "SELECT id, senha FROM usuarios WHERE email = ?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("s", $email);
$stmt->execute();
$result = $stmt->get_result();

if ($user = $result->fetch_assoc()) {
    if (password_verify($password, $user['senha'])) {
        session_start();
        $_SESSION['user_id'] = $user['id'];
        echo "success";
    } else {
        echo "invalid";
    }
} else {
    echo "invalid";
}
?>
