<%-- 
    Document   : teacher.jsp
    Created on : Feb 10, 2021, 10:47:36 AM
    Author     : MSI-PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <title>Teacher Page</title>
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
    color: #4CAF50;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}
#f{
    text-align: center;
}
#b{
    display: block;
    color: white;
    float: right;
    text-decoration: none;
    
}
#c{
    width: 30px;
    padding: 50%;
}
#alo{
    background-color: pink;
}
#pagenumber {
    
    margin-top: 100px;
    margin-left: 850px;
    grid-gap: 15px;
    border-radius: 10px;
    display: grid;
    padding: 20px;
    width: min-content;
    height: 20px;
    grid-template-columns: 10px 10px 10px 10px 10px 10px;
}
#pagenumber a{
     border: 1px solid black;
     border-radius: 5px;
     height: 30px;
     width: 20px;
     color: green;
     text-align: center;
     display: grid;
     
}
li a:hover {
    background-color: #111;

}
.responstable {
	 margin: 1em 0;
	 width: 100%;
	 overflow: hidden;
	 background: #fff;
	 color: #024457;
	 border-radius: 10px;
	 border: 1px solid #167f92;
}
 .responstable tr {
	 border: 1px solid #d9e4e6;
}
 .responstable tr:nth-child(odd) {
	 background-color: #eaf3f3;
}
 .responstable th {
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
 body {
	 padding: 0 2em;
	 font-family: Arial, sans-serif;
	 color: #024457;
	 background: #f2f2f2;
}
 h1 {
	 font-family: Verdana;
	 font-weight: normal;
	 color: #024457;
}
 h1 span {
	 color: #167f92;
}



body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
        
        </style>
        <script>
            function myFunction() {
                var txt;
                var r = confirm("Do you want to remove");
                if (r == true) {
                    return true;
                } else {
                    return false;
                }
                document.getElementById("demo").innerHTML = txt;
            }
        </script>
    </head>
    <body>
       
        <ul>
            <li>
                <a href="Teacher">Home</a>
            </li>
            <li>
                <c:if test="${not empty sessionScope.LOGIN_USER}">
                    <a href="FirstController?btaction=goto">History</a>
                </c:if>
            </li>
            <li>
                 <form action="search" method="POST">
                    Content: <input type="text" name="txtQuestionName"  style="width: 100px"/>            
                    -OR- Status <select name="cmbStatus" style="width: 100px">
                        <option></option>
<!--                        <option value="active" ${param.cmbStatus=='active'?"selected":""}>Active</option>
                        <option value="deactive" ${param.cmbStatus=='deactive'?"selected":""}>Deactive</option>-->
                        <option>Active</option>
                        <option>Deactive</option>
                        </select>
                    -OR- Subject <select name="txtSubject" size="1" style="width: 120px">
                        <c:forEach items="${requestScope.ListSubject}" var="d">
                            <option>${d.subjectname}</option>       
                        </c:forEach>
                    </select>
                    <input type="submit" value="Search" name="btaction"/> 
                    <input type="hidden" value="1" name="PageIndex"/> 
                </form>
            </li>
            <li id="b">
                <c:if test="${empty sessionScope.LOGIN_USER}">
                    <a href="FirstController?btaction=login">Login</a>
                </c:if>
               
                    <c:if test="${not empty sessionScope.LOGIN_USER}">
                    <form action="logout" method="POST">
                        <input type="submit" value="Logout" name="btAction" />
                    </form>
                </c:if>
                    

            </li>

<!--            <li id="b">
                <c:if test="${not empty sessionScope.LOGIN_USER}">
                    <a id="b" href="FirstController?btaction=view"> View cart 
                        <c:if test="${not empty sessionScope.shCart.cart}"> 
                            (${sessionScope.shCart.cart.values().size()})

                        </c:if>
                    </a>
                </c:if>
            </li>-->
            <li id="b">
                <a>Hello ${sessionScope.LOGIN_USER}!</a>
                
         
            </li>
          

        </ul>
        
               
                <h1 id="f">Quiz Online</h1>
            <div class="headera">
                <h1 id="a1">Teacher Page</h1>            
            </div>  
        </div>

        <div class="bodyy">


            <c:if test="${not empty requestScope.listQuestion && empty requestScope.searchQuestion }">
                <form action="Delete" method="POST">
                    <table class="responstable">

                        <tr>
                            <th>Question ID</th>
                            <th>Question name</th>
                            <th>Create Date</th>
                            <th>Subject ID</th>
                            <th>Status</th>
                            <th>answer correct</th>
                            <th>Question A</th>
                            <th>Question B</th>
                            <th>Question C</th>
                            <th>Question D</th>
                            <th>Edit</th>
                            <th><input id="demo" type="submit" value="Delete" name="btaction" onclick="return myFunction()"/>
                            </th>
                        </tr>
                        <c:forEach items="${requestScope.listQuestion}" var="p">
                            <tbody>
                                <tr>                  
                                    <td>${p.questionID}</td>
                                    <td>${p.contentQuestion}</td>
                                    <td>${p.createDate}</td>
                                    <td>${p.subjectID}</td>
                                    <td>${p.status}</td>
                                    <td>${p.answercontent}</td>
                                    <td>${p.questionA}</td>
                                    <td>${p.questionB}</td>
                                    <td>${p.questionC}</td>
                                    <td>${p.questionD}</td>
                                    <td>                                 
                                        <a href="edit.jsp?btaction=update&txtQuestionID=${p.questionID}
                                           &cmbSub=${p.subjectID}&txtName=${p.contentQuestion}
                                           &cmbStatus=${p.status}&txtAnsCon=${p.answercontent}&txtCorrect=${p.answercorrect}&txtA=${p.questionA}&txtB=${p.questionB}
                                           &txtC=${p.questionC}&txtD=${p.questionD}&PageIndex=${requestScope.PageIndex}&SearchString=${requestScope.Page}" class="edit" data-toggle="modal">
                                            <i class="material-icons" data-toggle="tooltip" title="Update">&#xE254;</i> </a>

                                    </td>
                                    <td>
                                        <input id="demoz" type="checkbox" name="txtQuestionID" value="${p.questionID}"/><br/>
                                    </td>

                                </tr>
                            </tbody>
                        </c:forEach>

                    </table> 
                    
                    <div id="pagenumber">     
                        <c:forEach begin="1" end="${end1}" var="i"> 
                            <a href="Teacher?PageIndex=${i}"> ${i} </a>
                        </c:forEach>
                    </div>
                </form>
            </c:if>

            <c:if test="${not empty requestScope.searchQuestion}">
                <form action="Delete" method="POST">
                    <table class="responstable">

                        <tr>
                            <th>Question ID</th>
                            <th>Question name</th>
                            <th>Create Date</th>
                            <th>Subject ID</th>
                            <th>Status</th>
                            <th>answer correct</th>
                            <th>Question A</th>
                            <th>Question B</th>
                            <th>Question C</th>
                            <th>Question D</th>
                            <th>Edit</th>
                            <th><input id="demo" type="submit" value="Delete" name="btaction" onclick="return myFunction()"/>
                            </th>
                        </tr>
                        <c:forEach items="${requestScope.searchQuestion}" var="Searchp">
                            <tbody>
                                <tr>

                                    <td>${Searchp.questionID}</td>
                                    <td>${Searchp.contentQuestion}</td>
                                    <td>${Searchp.createDate}</td>
                                    <td>${Searchp.subjectID}</td>
                                    <td>${Searchp.status}</td>   
                                    <td>${Searchp.answercontent}</td>   
                                    <td>${Searchp.questionA}</td>   
                                    <td>${Searchp.questionB}</td>   
                                    <td>${Searchp.questionC}</td>   
                                    <td>${Searchp.questionD}</td>   
                                     <td>                                 
                                        <a href="edit.jsp?btaction=update&txtQuestionID=${Searchp.questionID}
                                           &cmbSub=${Searchp.subjectID}&txtName=${Searchp.contentQuestion}
                                           &cmbStatus=${Searchp.status}&txtAnsCon=${Searchp.answercontent}
                                           &txtCorrect=${Searchp.answercorrect}&txtA=${Searchp.questionA}&txtB=${Searchp.questionB}
                                           &txtC=${Searchp.questionC}&txtD=${Searchp.questionD}
                                           &PageIndex=${requestScope.PageIndex}&SearchString=${requestScope.Page}
                                           &cmbStatus=${requestScope.status}&txtQuestionName=${requestScope.name}
                                           &txtSubject=${requestScope.txtSubject}&search=${requestScope.search}" 
                                           class="edit" data-toggle="modal">
                                            <i class="material-icons" data-toggle="tooltip" title="Update">&#xE254;</i> </a>
                                            
                                           
                                    </td>
                                    <td>
                                        <input id="demoz" type="checkbox" name="txtQuestionID" value="${Searchp.questionID}"/><br/>
                                    </td>
                                </tr>
                            </tbody>                  
                        </c:forEach>
                    </table>
            </div>
            <div id="pagenumber">
                <c:forEach begin="1" end="${end}" var="i">
                    <a href="Search?PageIndex=${i}&cmbStatus=${status}&txtQuestionName=${name}&txtSubject=${txtSubject}" >${i}</a>
                </c:forEach>
            </div>

        </c:if>
    </div>
</form>
<form action="addnew.jsp" method="post">

    <input id="id" type="submit" value="ADD NEW Question" name="btaction" onclick="return checkDuplicate()"/>
                
    <input type="hidden" name="listID" value="${requestScope.listID}"/>
    <input type="hidden" name="PageIndex" value="${requestScope.PageIndex}"/>
</form>



</body>
</html>

