<?php

    include('connect.php');
    
    $pname = $_POST["product_name"];
    $pprice = $_POST["product_price"];
    $pdes = $_POST["product_description"];

    if($pname=="" && $pprice=="" && $pdes=="")
    {
        echo '0';
    }
    else
    {
        $sql ="Insert into Inventory_Products (product_name,product_price,product_description) values('$pname','$pprice','$pdes')";
        
        mysqli_query($con,$sql);
    }

?>