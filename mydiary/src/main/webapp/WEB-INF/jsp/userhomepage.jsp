<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyDiary App Homepage</title>
<link rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>
<body>

<div class="header">

<div class="first">
<img src="<c:url value="/images/diary.jpg"/>" width="60" height="60">
</div>
<div class="second">MyDiary App</div>

</div>

<br/><br/>

<hr/>

<br/>


<div class="userhome">

 welcome  <span style="color:SteelBlue">${user.username}</span>       

  <a href="./signout" style="color:red;float:right">Signout</a>

<br/><br/><br/><br/>

<span class="heading">List of Past Entries</span>

<a href="./addentry"><button type="button" class="addbtn">Add Entry</button></a>

<br/><br/>
<table border="1">
<tr>
<th>Date</th>
<th colspan="3">Actions</th>
</tr>

<c:if test="${entrieslist.size()==0}">
<tr><td style="font-size:20px;color:green;text-align:center" colspan="4">User not added any Diary entries till now.</td></tr>
</c:if>

<c:forEach items="${entrieslist}" var="e">
<tr>
<td>
<fmt:formatDate value="${e.entrydate}" pattern="dd/MM/yyyy"/>

 
 
 
 </td>
<td><a href="./viewentry?id=${e.id}">View</a></td>
<td><a href="./updateentry?id=${e.id}">Update</a></td>
<td><a href="./deleteentry?id=${e.id}">Delete</a></td>
</tr>

</c:forEach>


</table>


</div>

</body>
</html>