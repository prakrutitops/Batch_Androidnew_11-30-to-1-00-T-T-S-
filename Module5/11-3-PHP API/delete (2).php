<?php

    include('connect.php');
    
    $id=$_POST["product_id"];
   
    
    $sql="Update Inventory_Products set product_name='$pname',product_price='$pprice',product_description='$pdes' where product_id='$id'";
    
     $sql="delete from Inventory_Products where product_id='$id'";
    
    if(mysqli_query($con,$sql))
    {
        echo 'deleted succesfully';
    }
    else
    {
        echo 'something went wrong';
    }

?>