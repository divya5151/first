<%@page import="com.entity.Donor"%>
<%@page import="java.util.List"%>
<%@page import="com.connection.jdbc_conn"%>
<%@page import="com.model.Promodel"%>
<%@include file="header.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="style.css" type="text/css" media="screen">
<style>
input[type="text"], input[type="password"], input[type="email"], select,input[type="number"]
{
    border: none;
    background:silver;
    height: 50px;
    font-size: 16px;
	padding:15px;
	width:60%;	
	border-radius: 25px;
	margin-left:20%;
}
h2,h1
{	
	margin-left:20%;
}
hr
{
width:60%;	
}
</style>
</head>
<body>
<%
try{ 
	String id=request.getParameter("id");
	Promodel p=new Promodel(jdbc_conn.getConnection());
	List<Donor> li=p.updatedonor(id);	
	for(Donor d:li){


%>
<div class="container">
<form action="updateDonorAction" method="post">
<input type="hidden" value=<%=d.getId() %> name="id">
<h2>Name</h2>
<input type="text" value=<%=d.getName() %> name="name">
<hr>
<h2>Father Name</h2>
<input type="text" value=<%=d.getFather() %> name="father">
<hr>
<h2>Mother Name</h2>
<input type="text" value=<%=d.getMother() %> name="mother">
<hr>
<h2>Mobile Number</h2>
<input type="number" value=<%=d.getMobilenumber() %> name="mobilenumber">
<hr>
<h2>Gender</h2>
<select name="gender" value=<%=d.getGender() %>>
<option value="Male">Male</option>
<option value="Female">Female</option>
<option value="Others">Others</option>
</select>
<hr>
<h2>Email</h2>
<input type="email" value=<%=d.getEmail() %> name="email">
<hr>
<h2>Blood Group</h2>
<select name="bloodgroup" value=<%=d.getBloodgroup() %>>
<option value="A+">A+</option>
<option value="A-">A-</option>
<option value="B+">B+</option>
<option value="B-">B-</option>
<option value="O+">O+</option>
<option value="O-">O-</option>
<option value="AB+">AB+</option>
<option value="AB-">AB-</option>

</select>
<hr>
<h2>Address</h2>
<input type="text" value=<%=d.getAddress() %> name="address">
<br>
<center><button type="submit" class="button">Save</button></center>
</form>
</div>
<%
} }catch(Exception e){
	e.printStackTrace();
}

%>


<br>
<br>
<br>
<br>
<!-- <h3><center>All Right Reserved @ BTech Days :: 2020  </center></h3>
 -->
</body>
</html>