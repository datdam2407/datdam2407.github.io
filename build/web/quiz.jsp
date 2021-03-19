<%-- 
    Document   : quiz
    Created on : Feb 18, 2021, 10:13:18 AM
    Author     : MSI-PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Page</title>
        <script type="text/javascript">
            var Second = ${requestScope.time};//300
            var min = Math.floor(Second / 60);//5p00s
          

            function System() {
                var count1 = document.getElementById("timeremain");
                if ((Second % 60) == 0) {
                    min = min - 1;
                }

                count1.value = (min) + "minute" + ((Second - 1) % 60) + "second";
                document.getElementById("time").value = (min) + "minute" + ((Second - 1) % 60) + "second";
                Second = Second -1;
                if ((min * 60) == 0 && Second == 0) {
                    Helicop();
                }
                setTimeout("System()", 1000);

            }
            function Helicop()
            {
                window.location.replace("Grade");// TIME OUT RES TO GRADE CONTROLLER
            }
        </script>
        <style>
            #pagenumeber {

                float: left;
                grid-gap: 20px;
                border: 2px solid #111;
                border-radius: 10px;
                display: grid;
                padding: 20px;
                width: 180px;
                height: 70px;
                background: #6d929b;
                grid-template-columns: 12px 12px 12px 12px 12px;

            }
            #pagenumeber input{
                border: 1px solid black;
                border-radius: 5px;
                height: 30px;
                width: 30px;
                color: green;
                text-align: center;

                border-color: #ccc;
                background-color: #ccc;
            }
            li a:hover {
                background-color: #111;

            }
            #box{
                border: 2px solid #111;
                border-radius: 7px;
                width: 300px;
                float: left;
                display: grid;
                grid-template-collums: 30px 30px 30px 30px 30px;
                grid-gap: 10px;
                background: activeborder;
            }
            #clock{
               
                font-size: 200%;
                border-radius: 5px;
                border-color: #60a3bc;
                background-color: #4CAF50;
                margin: 5px;
                padding: 5px;
                width: 190px;
            }
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
            #b{
                display: block;
                color: white;
                float: right;
                text-decoration: none;
            }
            #c{
                display: block;
                color: white;
                float: right;
                text-decoration: none;
                margin-top: 20px;   
                font-size: 150%;
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
               h2 {
                font-family: Verdana;
                font-weight: normal;
                color: #024457;
                text-align: left;
            }
            h2 span {
                color: #167f92;
            }
              h3 {
                font-family: Verdana;
                font-weight: normal;
                color: #024457;
                text-align: left;
            }
            h3 span {
                color: #167f92;
            }
            #Contend{
              
                border-radius: 10px;
                background-color: #60a3bc;
                width: auto;
               
            }
            #Boxxxx{
                background-color: #60a3bc;
            }
        </style>
    </head>
    <ul>
                    <li id="b">
                        <a>Student ${sessionScope.LOGIN_USER}!</a>
                    </li>  
                    <h1>QUIZ ONLINE</h1>
                </ul>
    <body onload="System()">
        <form action="UpdateQuiz" method="POST">
            <input type="hidden"  name="timeleft" id="time"/>
            <input type="hidden" name="questionID" value="${requestScope.questionID}" />    
            <input type="hidden" name="quizIndex" value="${requestScope.quizIndex}" />    
            <input type="hidden" name="contend" value="${requestScope.answercontent}" />    
                    
                <div id="Boxxxx">
                    
               
    <p id="Contend">Question ${requestScope.quizIndex + 1} : ${requestScope.content}</p>
        <div class="question-box">
                    <c:choose>
                        <c:when test="${Student eq txtAnswerA}">
                            <input type="radio" name="Student" value="${txtAnswerA}" checked="true"/>${txtAnswerA}<br/>
                            <input type="radio" name="Student" value="${txtAnswerB}"/>${txtAnswerB}<br/>
                            <input type="radio" name="Student" value="${txtAnswerC}"/>${txtAnswerC}<br/> 
                            <input type="radio" name="Student" value="${txtAnswerD}"/>${txtAnswerD}<br/>                        
                        </c:when>
                        <c:when test="${Student eq txtAnswerB}">
                            <input type="radio" name="Student" value="${txtAnswerA}"/>${txtAnswerA}<br/>
                            <input type="radio" name="Student" value="${txtAnswerB}" checked="true"/>${txtAnswerB}<br/>
                            <input type="radio" name="Student" value="${txtAnswerC}"/>${txtAnswerC}<br/> 
                            <input type="radio" name="Student" value="${txtAnswerD}"/>${txtAnswerD}<br/>                        
                        </c:when>
                        <c:when test="${Student eq txtAnswerC}">
                            <input type="radio" name="Student" value="${txtAnswerA}"/>${txtAnswerA}<br/>
                            <input type="radio" name="Student" value="${txtAnswerB}"/>${txtAnswerB}<br/>
                            <input type="radio" name="Student" value="${txtAnswerC}" checked="true"/>${txtAnswerC}<br/> 
                            <input type="radio" name="Student" value="${txtAnswerD}"/>${txtAnswerD}<br/>                        
                        </c:when>
                        <c:when test="${Student eq txtAnswerD}">
                            <input type="radio" name="Student" value="${txtAnswerA}"/>${txtAnswerA}<br/>
                            <input type="radio" name="Student" value="${txtAnswerB}"/>${txtAnswerB}<br/>
                            <input type="radio" name="Student" value="${txtAnswerC}"/>${txtAnswerC}<br/> 
                            <input type="radio" name="Student" value="${txtAnswerD}" checked="true"/>${txtAnswerD}<br/>                        
                        </c:when>
                        <c:otherwise>
                            <input type="radio" name="Student" value="${txtAnswerA}"/>${txtAnswerA}<br/>
                            <input type="radio" name="Student" value="${txtAnswerB}"/>${txtAnswerB}<br/>
                             <c:if test="${not empty requestScope.txtAnswerC}">

                            <input type="radio" name="Student" value="${txtAnswerC}"/>${txtAnswerC}<br/> 
                             </c:if>
                            <c:if test="${not empty requestScope.txtAnswerD}">
                            <input type="radio" name="Student" value="${txtAnswerD}"/>${txtAnswerD}<br/>   
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </div>
                    
                    </div>
                
                   <c:if test="${quizIndex > 0}">
                <input type="submit" name="doQuiz" value="Previous" />
            </c:if>
            <c:if test="${quizIndex + 1 < requestScope.quizsize}">
                <input type="submit" name="doQuiz" value="Next" />
            </c:if>
                <h2>Question:</h2>
<!--            <div id="pagenumeber">   
               
                <c:forEach begin="1" end="${requestScope.quizsize}" var="i"> 
-->                    <input type="submit" name="doQuiz" value="${i}" /><!--
                </c:forEach>
            </div>-->               
                 <div id="clock">
                    Time left: <input type="text" id="timeremain" disabled="" />
                </div>
                <input type="submit" value="Submit" name="doQuiz"/>
        </form>

    </body>
</html>
