<?php
    
    include('connection.php');
    $sql ="select * from info";
    $r=mysqli_query($con,$sql);
    $response=array();
    
    while($a = mysqli_fetch_array($r))
    {
        $b["id"]=$a["id"];
        $b["name"]=$a["name"];
        $b["image"]=$a["image"];
        $b["price"]=$a["price"];
        
        array_push($response,$b);
        
    }
    
    echo json_encode($response);
    mysqli_close($con);
    

?>