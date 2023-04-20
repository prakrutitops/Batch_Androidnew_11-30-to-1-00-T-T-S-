<?php

include ('connection.php');

$phone=$_REQUEST["phone"];
$pass=$_REQUEST["pass"];


$sel="select * from gift_signup where  phone='$phone' and password = '$pass'";

$ex=mysqli_query($con,$sel);


$no=mysqli_num_rows($ex);
//echo $no;


if($no>0)
{
$fet=mysqli_fetch_object($ex);
echo json_encode(['code'=>200]);
}
else
{
echo "0";
}


?>