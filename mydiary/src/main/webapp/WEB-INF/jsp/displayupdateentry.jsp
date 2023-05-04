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
<br/><br/>
<h1>welcome  <span style="color:SteelBlue">${user.username}</span></h1> 
<a href="./signout" style="color:red;float:right">Signout</a>

<div class="bodypart">

<div class="bodypart1">
<img src="<c:url value="/images/diary.jpg"/>">
</div>UPDATE ENTRY</h1><br/><br/><br/>
<form action="./processentryupdate" method="POST">
<label>Date</label> <input type="text" name="entrydate" class="formcontrol" value="<fmt:formatDate value="${entry.entrydate}" pattern="yyyy-MM-dd"/>"  readonly><br/><br/>
<label>Description</label> 
<textarea rows="10" cols="30" name="description">
 ${entry.description}
</textarea>
<input type="hidden" name="userid" value="${user.id}">
<input type="hidden" name="id" value="${entry.id}">

<br/><br/><br/>
<button type="submit">UPDATE ENTRY </button>

</form>

</div>




</div>

</body>
</html>