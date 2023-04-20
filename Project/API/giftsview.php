<?php
    
    include('connection.php');
    
    $sql="select * from admin_gift_category";
    
    $r=mysqli_query($con,$sql);
    $response=array();
    
    while($row=mysqli_fetch_array($r))
    {
        
        $value["id"]=$row["id"];
        $value["name"]=$row["name"];
        $value["url"]=$row["url"];
        

          array_push($response, $value);
    }
    echo json_encode($response);
    mysqli_close($con);

?>