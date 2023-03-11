<?php

    include('connect.php');
    
    $id=$_POST["product_id"];
    $pname = $_POST["product_name"];
    $pprice = $_POST["product_price"];
    $pdes = $_POST["product_description"];

    
    $sql="Update Inventory_Products set product_name='$pname',product_price='$pprice',product_description='$pdes' where product_id='$id'";
    
    if(mysqli_query($con,$sql))
    {
        echo 'updated succesfully';
    }
    else
    {
        echo 'something went wrong';
    }

?>