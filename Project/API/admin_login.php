<?php

    include('connection.php');
    
    $phone = $_REQUEST["admin_phone"];
    $pass = $_REQUEST["admin_password"];
    
    $sql = "select * from admin_login_giftshop where admin_phone = '$phone' and admin_password = '$pass'";
    
    $ex = mysqli_query($con, $sql);
    
    $no = mysqli_num_rows ($ex);
    
    //echo $no;
    
    if($no>0)
    {
        $fet = mysqli_fetch_object($ex);
        echo json_encode(['code' => 200]);
    }
    else
    {
        echo '0';
    }
?>