<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Scooter sharing</title>
</head>
<body>
<h1>"Welcome!"
</h1>
<br/>
<form action="controller" method="post"  >
    <input type="hidden" name="command" value="login"/>
    E-mail:<input type="text" name="e_mail" value=""/>
    <br/>
    Password: <input type="password" name="password" value=""/>
    <br/>
    <input type="submit" name="push" value="login" />
    <br/>
    ${login_msg}
</form>

<form action="${pageContext.request.contextPath}/pages/register.jsp" >
    <input type="submit" name="push" value="register">
</form>
<%--<form action="controller" >--%>
<%--    <input type="hidden" name="command"  value="register"/>--%>
<%--    <input type="submit" name="push" value="register" />--%>
<%--</form>--%>
</body>
</html>