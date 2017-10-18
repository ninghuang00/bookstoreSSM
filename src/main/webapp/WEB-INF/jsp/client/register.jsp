<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>--%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>register page</title>
</head>
<body>
<br>
<br>
<%--<form action="${pageContext.request.contextPath }/client/RegisterServlet" method="post" align="center">--%>
<%--<form action="${pageContext.request.contextPath}/Register.do" method="post" align="center">--%>
<%--
	如果html:标签发现session域中有org.apache.struts.action.TOKEN为随机数，它会自动隐藏字段
--%>
<sf:form action="${pageContext.request.contextPath}/register.action" method="post" style="align-items: center" modelAttribute="user">
    <table align="center" border="1" width="50% ">
        <tr>
            <td>username</td>
            <td>
                    <%--username:<input type="text" name="username" ><br>--%>
                <sf:input path="username"/>
            </td>
            <td>
                <sf:errors path="username"/>
            </td>
        </tr>

        <tr>
            <td>password</td>
            <td>
                    <%--password:<input type="password" name="password"><br>--%>
                <sf:password path="password"/>
            </td>
            <td>
                <sf:errors path="password"/>
            </td>
        </tr>
        <tr>
            <td>phonenumber</td>
            <td>
                    <%--phonenum:<input type="text" name="phonenumber"><br>--%>
                <sf:input path="phonenumber"/>
            </td>
            <td>
                <sf:errors path="phonenumber"/>
            </td>
        </tr>
        <tr>
            <td>address</td>
            <td>
                    <%--address :<input type="text" name="address"><br>--%>
                <sf:input path="address"/>
            </td>
            <td>
                <sf:errors path="address"/>
            </td>
        </tr>
        <tr>
            <td>email</td>
            <td>
                    <%--e-mail  :<input type="text" name="email"><br>--%>
                <sf:input path="email"/>
            </td>
            <td>
                <sf:errors path="email"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="reset" value="reset"/>
            </td>
            <td>
                <input type="submit" value="submit"/>
            </td>
        </tr>
    </table>

    <%--<input type="submit" value="submit">--%>
    <%--</form>--%>
</sf:form>
</body>
</html>