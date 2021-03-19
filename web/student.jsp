<%-- 
    Document   : student
    Created on : Feb 10, 2021, 11:32:59 AM
    Author     : MSI-PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Page</title>
    </head>
    <body class="bodyy">
        <style>
            ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}
#d{
    display: block;
    color: white;
    margin-left: 40%;
    text-decoration: none;
    text-transform: uppercase;
    
}
#c{
    display: block;
    color: white;
    float: right;
    text-decoration: none;
    margin-top: 10px;   
}#b{
    display: block;
    color: white;
    float: right;
    text-decoration: none;
}
.responstable{
    width: auto;
    margin-left: 10%;
    margin-top: 5%;
}
.responstable tr {
	 border: 1px solid #d9e4e6;
}
 .responstable tr:nth-child(odd) {
	 background-color: #eaf3f3;
}
 .responstable th {
        width: 240px;
	 display: none;
	 border: 1px solid #fff;
	 background-color: #167f92;
	 color: #fff;
	 padding: 1em;
}
 .responstable th:first-child {
	 display: table-cell;
	 text-align: center;
}
 .responstable th:nth-child(2) {
	 display: table-cell;
}
 .responstable th:nth-child(2) span {
	 display: none;
}
 .responstable th:nth-child(2):after {
	 content: attr(data-th);
}
 @media (min-width: 480px) {
	 .responstable th:nth-child(2) span {
		 display: block;
	}
	 .responstable th:nth-child(2):after {
		 display: none;
	}
}
 .responstable td {
	 display: block;
	 word-wrap: break-word;
	 max-width: 7em;
}
 .responstable td:first-child {
	 display: table-cell;
	 text-align: center;
	 border-right: 1px solid #d9e4e6;
}
 @media (min-width: 480px) {
	 .responstable td {
		 border: 1px solid #d9e4e6;
	}
}
 .responstable th, .responstable td {
	 text-align: left;
	 margin: 0.5em 1em;
}
 @media (min-width: 480px) {
	 .responstable th, .responstable td {
		 display: table-cell;
		 padding: 1em;
	}
}
.bodyy {
background-color: #60a3bc;
}
 h1 {
	 font-family: Verdana;
	 font-weight: normal;
	 color: #024457;
         text-align: center;
}
 h1 span {
	 color: #167f92;
}




        </style>
               <ul>
            <li>
                <a href="Student">Home</a>
            </li>
             <li>
                <c:if test="${not empty sessionScope.LOGIN_USER}">
                    <a href="FirstController?btaction=goto">History</a>
                </c:if>
            </li>
           
            <li id="c">
                    <c:if test="${not empty sessionScope.LOGIN_USER}">
                    <form action="logout" method="POST">
                        <input type="submit" value="Logout" name="btAction" />
                    </form>
                </c:if>
            </li>

            <li id="b">
                <a>Hello ${sessionScope.LOGIN_USER}!</a>
            </li>  

        </ul>
<!--        <h1>hello ${sessionScope.LOGIN_USER}</h1>
   
          <form action="logout" method="POST">
           <input type="submit" value="Logout" name="btAction" />
           
          
        </form>-->
      
                <h1>Quiz Online</h1>
            
           
       <div class="body">
           <table border="1" class="responstable">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Number</th>
                    <th>Time</th>
                    <th>Action</th> 
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${applicationScope.listStudentSubject}" var="subjectDTO" varStatus="counter">
                <tr>
                    <td>${counter.count}</td>
                    <td>${subjectDTO.subjectID}</td>
                    <td>${subjectDTO.subjectname}</td>
                    <td>10</td>
                    <td>${subjectDTO.remain}</td>
                    
                    <td>
                        <form action="Quiz" method="POST">
                            <input type="hidden" name="txtsubjectname" value="${subjectDTO.subjectname}"/>
                            <input type="hidden" name="txtsubjectID" value="${subjectDTO.subjectID}"/>
                            <input type="hidden" name="NumberQ" value="${subjectDTO.quizQuestion}"/>
                            <input type="submit" value="Take Quiz now"/>
                        </form>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
       </div>
    </body>
</html>
