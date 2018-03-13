<?php
$host='localhost';
$user='root';
$password='';
$dbname="colleges";
$name=$email=$contact=$sql=$con="";

$con=mysqli_connect($host,$user,$password,$dbname) or die("Could not establish connection to mysql");
if($con)
{
    echo " Database connected";
}

$name=$_POST['name'];
$email=$_POST['email'];
$contact=$_POST['contact'];
$sql= "INSERT INTO `info`(`name`, `email`, `contact`) VALUES ('$name','$email','$contact')";
if(mysqli_query($con,$sql))
{
    echo "<h3>Data inserted successfully</h3>";
}
else {
    echo "Error: " . $sql . "<br>" . mysqli_error($con);
}
mysqli_close($con);
?>