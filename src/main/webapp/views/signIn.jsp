<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<p>${infoPassword}
${infoLogin}</p>
<p>Введите логин и пароль</p>
<form action="signIn" method="POST">
<table>
<tbody>
<tr>
<td>Login:</td>
<td><input type="text" name="login"></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="password"></td>
</tr>
</tbody>
</table>
<p><input type="submit" value="Login"></p>
</form>
</body>
</html>