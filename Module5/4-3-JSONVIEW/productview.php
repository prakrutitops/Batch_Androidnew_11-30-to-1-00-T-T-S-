<?php
    
    include('connect.php');
    
    $sql="select * from Inventory_Products";
    
    $r=mysqli_query($con,$sql);
    $response=array();
    
    while($row=mysqli_fetch_array($r))
    {
        
        $value["product_id"]=$row["product_id"];
        $value["product_name"]=$row["product_name"];
        $value["product_price"]=$row["product_price"];
        $value["product_description"]=$row["product_description"];
         $value["product_image"]=$row["product_image"];
        

          array_push($response, $value);
    }
    echo json_encode($response);
    mysqli_close($con);

?>