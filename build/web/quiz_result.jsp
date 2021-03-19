<%-- 
    Document   : quiz_result
    Created on : Feb 13, 2021, 11:24:38 AM
    Author     : MSI-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grade Page</title>
    </head>
    
    <body class="abc">
         <style>
             .abc{
                 background-color: #167f92;
             }
             .bodyy{
                 text-align: center;
                border: 1px solid #fff;
                 background-color: #167f92;
                 border-radius: 15px;
                    color: #fff;
	 padding: 1em;
         width: 20%;
         
         margin-top: 10%;
         margin-left: 38%;
             }
           
        </style>
        
        <div class="bodyy">
        <h1>This is Your Result</h1>
        <h1>${sessionScope.subjectID}</h1>
        <h2>Name: ${sessionScope.LOGIN_USER}</h2>
        <h2>Your grade is: ${requestScope.correct} / 10</h2>
        <h2>Your grade is: ${requestScope.mark} / out of 10.0</h2>
        <a id="b" href="student.jsp">Back to Student Page</a>
        </div>
    </body>
</html>
