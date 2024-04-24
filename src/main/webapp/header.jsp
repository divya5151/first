<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="style.css" type="text/css" media="screen">
<style>

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
  border-right:1px solid #bbb;
}

li:last-child {
  border-right: none;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #4CAF50;
}
</style>
</head>
<body>

<ul>
  <li><a href="home.jsp">Home</a></li>
  <li><a href="addNewDonor.jsp">Add New Donor</a></li>
  <li><a href="editDeleteList.jsp">Edit,Delete & List of Donor Details</a></li>
    <li><a href="manageStock.jsp">Manage Stock</a></li>
  <li><a href="requestForBlood.jsp">Request for Blood</a></li>
  <li><a href="requestCompleted.jsp">Request Completed</a></li>
  <li style="float:right"><a href="adminLogin.jsp">Logout</a></li>
</ul>

</body>
</html>
