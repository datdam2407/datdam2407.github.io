<%-- 
    Document   : history
    Created on : Feb 23, 2021, 9:05:37 AM
    Author     : MSI-PC
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History</title>
        <style><%@include file="/css/table.css"%></style>
    </head>
    <body>
        <div class="title">
            <font color="white">
                Welcome, ${sessionScope.LOGIN_USER}
            </font><br/>
            <a href="Logout">Logout</a><br/>
            <h2>FPT University</h2>
        </div>
        <form action="SearchHistory">
            <h1>Search for result</h1>
            <c:if test="${not empty sessionScope.TEACHER}">
                Student's name: <input type="text" name="txtName" value="${param.txtName}"/><br/>
            </c:if>
             Subject:   <select name="cbSubName">
                            <c:forEach items="${sessionScope.listsub}" var="ls">
                                <option>${ls.subjectName}</option>
                            </c:forEach>
                        </select><br/>
            <input type="submit" value="Search" /><br/>
            <c:if test="${not empty sessionScope.TEACHER}">
                <a href="teacher.jsp">Back to search question</a>
            </c:if>
            <c:if test="${not empty sessionScope.STUDENT}">
                <a href="student.jsp">Back to Home</a>
            </c:if>
        </form>

        <c:set value="${requestScope.listResult}" var="listR"/>
        <c:if test="${not empty listR}">
            <table border="1" style="width:1350px;height:300px">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>ID</th>
                        <th>Email</th>
                        <th>Student's name</th>
                        <th>Subject</th>
                        <th>Correct Answer</th>
                        <th>Grade</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listR}" var="lr" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${lr.resultID}</td>
                            <td>${lr.email}</td>
                            <td>${lr.name}</td>
                            <td>${lr.subjectID}</td>
                            <td>${lr.noOfCorrect}</td>
                            <td>${lr.grade}</td>
                            <td>${lr.dateOfCreate}</td>
                        </tr>
                    </c:forEach>
                    
                </tbody>
            </table>

        </c:if>
        <c:forEach begin="1" end="${requestScope.p}" var="i">
            <c:url value="SearchHistory" var="paging">
                <c:param name="index" value="${i}"/>
                <c:param name="txtName" value="${param.txtName}"/>
                <c:param name="cbSubName" value="${param.cbSubName}"/>
            </c:url>
            <a href="${paging}">${i}</a>
        </c:forEach>
    </body>
</html>