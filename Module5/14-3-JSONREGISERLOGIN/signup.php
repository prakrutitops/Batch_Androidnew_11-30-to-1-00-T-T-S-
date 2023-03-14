<?php

    include('connection.php');
    
    $firstname=$_POST["firstname"];
    $lastname=$_POST["lastname"];
    $email=$_POST["email"];
    $phone=$_POST["phone"];
    $password=$_POST["password"];
  
   
    
    if($firstname=="" && $lastname=="" && $email=="" && $phone=="" && $password=="")
    {
        
        echo '0';
    }
    else
    {
        
        $sql="insert into greetings_signup(firstname,lastname,email,phone,password) values('$firstname','$lastname','$email','$phone','$password')";
        $ex=mysqli_query($con,$sql);
        mysqli_close($con);
        
    }
    

?>