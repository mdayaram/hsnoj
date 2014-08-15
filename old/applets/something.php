<center>
<applet code="/applets/BinaryClock.class"  width="200" height="143" codebase="/applets/" height=143 width=200>
</applet>
<br><br>
Comments:<br>
<form method="POST" action="applets/something.php">
Name: <br><input type="text" name="name" size="25"><br>
Message: <br><textarea name="message"></textarea><br>
<input type="submit" value="Submit" name="B1">
<input type="hidden" name="go" value="104">
</form>
<br><br><hr>
</center>

<?php
if($_POST["go"] == 104){

  $file = fopen("something.php", "a"); 
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

  echo "<meta http-equiv='refresh' content='0'>";
}
?>
