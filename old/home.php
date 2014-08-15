<table width=100% cellpadding=3 cellspacing=0 border=0>
<?php

$arr=array(

"April 7, 2005",
"April 1, 2005",
"March 27, 2005",
"March 25, 2005",
"March 24, 2005",
"March 20, 2005",
"March 19, 2005",
"March 18, 2005",
"March 17, 2005"

);

foreach ($arr as $date)
{
echo '<tr><td align=center valign=center bgcolor=#66cc00><font color=black><b>';
echo $date;
echo '</b></font></td></tr><tr><td valign=top align=left>';
include("updates/$date.php");
echo '<br></td></tr>';

}

?>
</table>

