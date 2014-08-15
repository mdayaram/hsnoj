<html>
<head>
<meta http-equiv='refresh' content='0;URL=index.php?name=Guest Book&page=gb/index.html'>
</head>
<body bgcolor=black text=white link=green>
<?php

$file = fopen("index.html", "a"); 
$name = $_POST["name"];  
$message = $_POST["message"];

$quote = '<br>"<br>';
$quote = strip_tags($quote);

$bslash = "<br>\<br>";
$bslash = strip_tags($bslash);

$name = eregi_replace("Manoj", "n00b",$name);
$name = eregi_replace("Nojy", "n00b",$name);
$name = eregi_replace("Noj", "n00b",$name);

$name = str_replace("\\'", "'",$name);
$message = str_replace("\\'", "'",$message);
$name = str_replace("\\$quote", "&quot;",$name);
$message = str_replace("\\$quote", "$quote",$message);
$name = str_replace("\\$bslash", "$bslash",$name);
$message = str_replace("\\$bslash", "$bslash",$message);
$message = str_replace("\n","<br>",$message);

$hour = date("H")+3;
if($hour>23){
	$hour=$hour-24;
}

$time = "<i>".date("M dS, Y @ $hour:i")."</i><br>" ;

fwrite($file, "$time<b>$name</b> says...<br>$message<hr>\n\n"); 

echo "<center>Ok, you can go back now.  If you're not redirected in a few seconds, just click link below.";
echo '<br><br>[<a href="index.php?name=Guest Book&page=gb/index.html">back</a>]';

?>
</body>
</html>
