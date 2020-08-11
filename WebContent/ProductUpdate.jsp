<%@page import="domain.ProductTest"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
font-family: arial, sans-serif; border-collapse: collapse; width: 100%;
}

td, th {
border: 1px solid #dddddd; text-align: left;
padding: 8px;
}

tr:nth-child(even) {
background-color: #dddddd;
}
</style>
</head>

<body>
<%
ProductTest pro = (ProductTest) request.getAttribute("PRO");
%>

<form action="ProductController" method="post">
<table>
<tr>
<td>Product code</td>
<td>
<%
out.println("<input type=\"text\" name=\"productcode\" readonly value=" + pro.getProductcode());
%>
</td>
</tr>

<tr>
<td>Product name</td>
<td>
<%
out.println("<input type=\"text\" name=\"productname\" value=" + pro.getProductname());
%>
</td>
</tr>

<tr>
<td>Product line</td>
<td>
<%
out.println("<input type=\"text\" name=\"productline\" value=" + pro.getProductline());
%>
</td>
</tr>

<tr>
<td>Product scale</td>
<td>
<%
out.println("<input type=\"text\" name=\"productscale\" value=" + pro.getProductscale());
%>
</td>
</tr>

<tr>
<td>Product Vendor</td>
<td>
<%
out.println("<input type=\"text\" name=\"productvendor\" value=" + pro.getProductvendor());
%>
</td>	</tr>

<tr>
<td>Product description</td>
<td>
<%
out.println("<input type=\"text\" name=\"productdescription\" value=" + pro.getProductdescription());
%>
</td>
</tr>

<tr>
<td>Quantityinstock</td>
<td>
<%
out.println("<input type=\"text\" name=\"quantityinstock\" value=" + pro.getQuantityinstock());
%>
</td>
</tr>

<tr>
<td>Buy price</td>
<td>
<%
out.println("<input type=\"text\" name=\"buyprice\" value=" + pro.getBuyprice());
%>
</td>
</tr>


<tr>
<td>Msrp</td>
<td>
<%
out.println("<input type=\"text\" name=\"msrp\" value=" + pro.getMsrp());
%>
</td>
</tr>



</form>

</table>
<input type="submit" name="UPDATE" value="UPDATE" />
<input type="submit" name="DELETE" value="DELETE" />


</body>
</html>