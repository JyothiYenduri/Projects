<%@ taglib prefix="c" uri="jakarta.tags.core" %>

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


<div class="bodypart">

<div class="bodypart1">
<img src="<c:url value="/images/diary.jpg"/>">
</div>

<div class="bodypart2">
<h1>REGISTRATION FORM</h1><br/><br/><br/>
<form action="./saveuser" method="POST">
<label>username</label> <input type="text" name="username" class="formcontrol"><br/><br/>
<label>password</label> <input type="password" name="password" class="formcontrol"><br/><br/><br/>
<button type="submit">REGISTER</button>

</form>
<br/><br/>

Existing User? <a href="./home">Login</a> here
</div>




</div>

</body>
</html>