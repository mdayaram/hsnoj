<html>
<head>
<title>Noj</title>

<STYLE type="text/css">
body {
color: #ffffff;
background-color : #000000;
scrollbar-face-color: #000000;
scrollbar-shadow-color: #gray;
scrollbar-darkshadow-color: #gray;
scrollbar-highlight-color: #ffffff;
scrollbar-3dlight-color: #000000;
scrollbar-track-color: #ffffff;
scrollbar-arrow-color: #66cc00;

font-size: 8pt; font-family: verdana; color: #ffffff;
}

a:link {color: #66cc00; text-decoration: none; }
a:visited {color: #66cc00; text-decoration: none; }
a:hover {color: #ffffff; text-decoration: underline; }
a:active {color: #66cc00; text-decoration: none; }

tr { font-size: 8pt; font-family: verdana; color: #ffffff; }
td { font-size: 8pt; font-family: verdana; color: #ffffff; }
li { font-size: 8pt; font-family: verdana; color: #ffffff; }

.header {
background-image: url(http://noj.hiya-host.com/images/g_header.gif);
background-repeat: no-repeat;
background-position: center; 
}
</STYLE>

</head>

<body bgcolor="#000000">

<center><table width=95% cellspacing=0 cellpadding=0 border=1 bordercolor=white bgcolor=black></center>
<tr><td width=18% valign=top><center>
<table border=0 cellpadding=10 cellspacing=5>


<tr><td bgcolor=black valign=top align=left width=100%>
<center><img src=http://noj.hiya-host.com/images/g_miniheader.gif><br><b>
Stuff!<br><br>
</b></center>

<a href="http://noj.hiya-host.com/index.php?name=Home&page=http://noj.hiya-host.com/home.php">Home</a><br>
<a href="http://noj.hiya-host.com/index.php?name=Guest Book&page=http://noj.hiya-host.com/gb/index.html">Guest Book</a><br>

</td></tr>

<tr><td bgcolor=black valign=top align=left width=100%>
<center><img src=http://noj.hiya-host.com/images/g_miniheader.gif><br><b>
Applets<br><br>
</b></center>

<a href="http://noj.hiya-host.com/index.php?id=1&name=Calculator Applet&page=http://noj.hiya-host.com/applets/calculator.php">Calculator</a><br>
<a href="http://noj.hiya-host.com/index.php?name=5 Card Draw Poker&page=http://noj.hiya-host.com/applets/poker.php">Five Card Draw</a><br>
<a href="http://noj.hiya-host.com/index.php?name=Binary Clock&page=http://noj.hiya-host.com/applets/bclock.php">Binary Clock</a><br>
<a href="http://noj.hiya-host.com/index.php?name=Number Guess Applet&page=http://noj.hiya-host.com/applets/nguess.php">Number Guessing Game</a><br>
<a href="http://noj.hiya-host.com/index.php?name=Craps Applet&page=http://noj.hiya-host.com/applets/craps.php">Craps Game</a><br>
<a href="http://noj.hiya-host.com/index.php?name=SAT Vocab Test&page=http://noj.hiya-host.com/applets/satvocab.php">Vocab Test</a><br>

</td>
</tr>
</table></center>
</td>

<td width=58% valign=top><center>
<table width=100% border=0 cellpadding=10 cellspacing=5><tr><td width=100% valign=center height=50 class="header">
<center><b><font color=black>

<?php

if(isset($_GET['name'])){
   echo $_GET['name'];
}else{
   echo 'Home';
}

echo '</b></center></font></td></tr>';
echo '<tr><td bgcolor=black width=100% valigh=top align=left>';
echo '<center><table width=90% border=0 cellpadding=0 cellspacing=0><tr><td valign=top>';

if(isset($_GET["page"])){
   include($_GET["page"]);
}else{
   include("http://noj.hiya-host.com/home.php");
}

?>

</td></tr>
<tr><td valign=bottom align=center>
<br><br><br>
<a href="http://noj.hiya-host.com/index.php?name=Copyright&page=http://noj.hiya-host.com/copyright.php">Copyright &copy; 2005.</a>
</tr></td></table></center>

</td></tr>
</table></center>
</td>

<td width=18% valign=top><center>
<table border=0 cellpadding=10 cellspacing=5><tr><td bgcolor=black width=100% height=55>
<center><img src=/images/g_miniheader.gif><br><b>
Misc.<br><br>
</b></center>





</td></tr>

<tr><td bgcolor=black valign=top width=100%>
<center><img src=/images/g_miniheader.gif><br><b>
<br><br>
</b></center>






</td></tr>


</table>
</center>

</td></tr>


</td></tr></table><br><font size=1>
[ Your Mom is my #1 Fan. ]</font>
</center>
</body>
</html>







