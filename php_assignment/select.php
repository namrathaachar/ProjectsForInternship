<?php
$host='localhost';
$user='root';
$password='';
$dbname="colleges";
$name=$email=$contact=$sql=$con="";

$con=mysqli_connect($host,$user,$password,$dbname) or die("Could not establish connection to mysql");
$user_contact=$_POST['contact'];
$sql = "SELECT `name`, `email`, `contact` FROM `info` WHERE '$user_contact'=`contact`";
$result = $con->query($sql);

if ($result->num_rows > 0) {
    echo "<table border=4><tr><th>NAME</th><th>EMAIL</th><th>CONTACT</th></tr>";
    while($row = $result->fetch_assoc()) {
        echo "<tr><td>".$row["name"]."</td><td>".$row["email"]." </td><td>".$row["contact"]."</td></tr>";
    }
    echo "</table>";
} else {
    echo "0 results";
}
$con->close();
?>