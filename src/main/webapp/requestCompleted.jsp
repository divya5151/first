<%@page import="com.connection.jdbc_conn"%>
<%@page import="com.entity.Bloodrequest"%>
<%@page import="com.mysql.cj.jdbc.BlobFromLocator"%>
<%@page import="java.util.List"%>
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
<center>
<table id="customers">
<tr>
<th>ID</th>
<th>Name</th>
<th>Mobile Number</th>
<th>Email</th>
<th>Blood Group</th>
</tr>
<tr>
<%
try{
	Promodel p=new Promodel(jdbc_conn.getConnection());
	List<Bloodrequest> li=p.completerequest();
	  int i=0;
	  for(Bloodrequest b:li){
   i++;



%>
<td><%=b.getId() %></td>
<td><%=b.getName() %></td>
<td><%=b.getMobilenumber() %></td>
<td><%=b.getEmail() %></td>
<td><%=b.getBloodgroup() %></td>
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
<h3><center>All Right Reserved @ BTech Days :: 2020  </center></h3>
</body>
</html>