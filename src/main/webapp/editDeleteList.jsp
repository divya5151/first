<%@page import="com.entity.Donor"%>
<%@page import="java.util.List"%>
<%@page import="com.connection.jdbc_conn"%>
<%@page import="com.model.Promodel"%>
<%@include file="header.jsp"%> 
<html>
<head>
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 95%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>
<br>
<%
String msg=request.getParameter("msg");
if("valid".equals(msg)){
	%>
	<center><font color="red" size="5">Successfully updated</font></center>
	<%
}
%>
<%
if("invalid".equals(msg)){
	%>
	<center><font color="red" size="5">Some thing went Wrong! Try again</font></center>
	<%
}
%>
<%
if("deleted".equals(msg)){
	%>
	<center><font color="red" size="5">Successfully deleted</font></center>
	<%
}
%>
<center>
<table id="customers">
<tr>
<th>ID</th>
<th>Name</th>
<th>Father Name</th>
<th>Mother Name</th>
<th>Mobile Number</th>
<th>Gender</th>
<th>Email</th>
<th>Blood Group</th>
<th>Address</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<tr>
<%
try{
Promodel p=new Promodel(jdbc_conn.getConnection());
List<Donor> li=p.Allrecord();
int i=0;
for(Donor d:li){
i++;
%>
<td><%=d.getId() %></td>
<td><%=d.getName() %></td>
<td><%=d.getFather() %></td>
<td><%=d.getMother() %></td>
<td><%=d.getMobilenumber() %></td>
<td><%=d.getGender() %></td>
<td><%=d.getEmail() %></td>
<td><%=d.getBloodgroup() %></td>
<td><%=d.getAddress() %></td>
<td><a href="updateDonor.jsp?id=<%=d.getId()%>">Edit</a></td>
<td><a href="deleteDonor?id=<%=d.getId()%>">Delete</a></td>
</tr>
<%
}}catch(Exception e){
	e.printStackTrace();
}


%>
</table>
</center>
<br>
<br>
<br>
<br>
<!-- <h3><center>All Right Reserved @ BTech Days :: 2020  </center></h3>
 --></body>
</html>