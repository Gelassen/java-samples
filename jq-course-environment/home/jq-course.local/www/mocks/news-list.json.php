<?php

//phpinfo();

//error_reporting(E_ALL);
//ini_set('display_errors', true);
//$incpath = ini_get('include_path');
//ini_set('include_path', $incpath.';'.  realpath('../libs').';d:\php-5.3.6\PEAR');
//
//require_once 'Services/Digg2.php';
 
//$sd = new Services_Digg2;
//$sd->setVersion('2.0');
// 
//$result = $sd->search->search(array(
//    'query' => 'web development',
//    'count' => 23
//));
//
//$str_res = serialize($result);
//file_put_contents('Digg_web_dev_query_obj.php', "<?php \n \$Digg_web_dev_query_obj =".$str_res."\n");
include_once 'json-header-sleep.php';
$result_n = unserialize(file_get_contents('Digg_web_dev_query_obj.php'));
echo json_encode($result_n);



?>
