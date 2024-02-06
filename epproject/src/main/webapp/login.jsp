<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<?xml-stylesheet type="text/css" href="style.css"?>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient login page</title>
</head>
<body>
    <div align="center">
  <h1>Patient Login Form</h1>
  <form action="<%=request.getContextPath()%>/login" method="post">
   <table style="with: 100%">
    <tr>
     <td>Patient ID</td>
     <td><input type="text" name="pid" /></td>
    </tr>
    <tr>
     <td>Patient Name</td>
     <td><input type="text" name="pname" /></td>
    </tr>

   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>