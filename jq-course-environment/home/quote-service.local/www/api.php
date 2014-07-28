<?php

//print_r($_REQUEST);
echo $_REQUEST['var'];
var_dump(json_decode($_REQUEST['var']));
print_r ($req);
die();
// qoutes
$qts = array(
	array(
		'author' 	=> 'David Brent',
		'text'		=> 'There may be no "I" in team, but there\'s a "ME" if you look hard enough.'
	),
	array(
		'author' 	=> 'Pablo Picasso',
		'text'		=> 'Computers are useless.  They can only give you answers.'
	),array(
		'author' 	=> 'Alan Kay',
		'text'		=> 'Most software today is very much like an Egyptian pyramid with millions of bricks piled on top of each other, with no structural integrity, but just done by brute force and thousands of slaves.'
	)
);

// read query

$callbackName = isset($_REQUEST['callback']) ? $_REQUEST['callback'] : 'callback';
$qoute = $qts[rand(0,2)];
$time =rand(0, 1000000);
if ($time > 4000000){
	//die();
}
usleep($time);
//header('Content-type: application/json');
echo $callbackName.'('.json_encode($qoute).')';
//echo 'alert("ooo")';
?>