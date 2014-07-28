<?php
include_once 'json-header-sleep.php';
$str = file_get_contents('post_search.ser.php');
$arr = unserialize($str);
echo json_encode($arr);
?>
