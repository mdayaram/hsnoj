<?php
if($_POST["go"] == 104){
  $id = $_POST["id"];
  $loc = $_POST["loc"];
  $file = fopen("$loc", "a"); 
  $name = $_POST["name"];  
  $message = $_POST["message"];

  $quote = '<br>"<br>';
  $quote = strip_tags($quote);
  $bslash = "<br>\<br>";
  $bslash = strip_tags($bslash);

  if($name=="i.am.noj"){
     $name = str_replace("i.am.noj","Noj",$name);
  }else{
     $name = eregi_replace("Manoj", "n00b",$name);
     $name = eregi_replace("Nojy", "n00b",$name);
     $name = eregi_replace("Noj", "n00b",$name);
  } 
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

  echo "<meta http-equiv='refresh' content='0;http://noj.hiya-host.com/index.php?name=$id&page=http://noj.hiya-host.com/$loc'>";
}
?>