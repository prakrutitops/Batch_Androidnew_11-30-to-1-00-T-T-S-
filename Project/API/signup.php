<?php

    include('connection.php');
    
    $firstname=$_POST["firstname"];
    $lastname=$_POST["lastname"];
    $email=$_POST["email"];
    $phone=$_POST["phone"];
    $gender=$_POST["gender"];
    $password=$_POST["password"];
  
   
    
    if($firstname=="" && $lastname=="" && $email=="" && $phone=="" && $password=="" && $gender="")
    {
        
        echo '0';
    }
    else
    {
        
        $sql="insert into gift_signup(firstname,lastname,gender,email,phone,password) values('$firstname','$lastname','$gender','$email','$phone','$password')";
        $ex=mysqli_query($con,$sql);
        mysqli_close($con);
        
    }
    

?>