<%-- 
    Document   : edit.jsp
    Created on : Feb 10, 2021, 3:37:44 PM
    Author     : MSI-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <script>
            function validateForm() {
                
                var y = document.forms["myForm"]["txtName"].value;
                if (y == "") {
                    alert("Question Name must be not empty");
                    return false;
                }
                var c = document.forms["myForm"]["txtAnsCon"].value;
                if (c == "") {
                    alert("Answet must be not empty");
                    return false;
                }
                var d = document.forms["myForm"]["txtCorrect"].value;
                if (d == "") {
                    alert("CorrectAns must be not empty");
                    return false;
                }
                 var e = document.forms["myForm"]["txtA"].value;
                if (e == "") {
                    alert("A must be not empty");
                    return false;
                }
                 var f = document.forms["myForm"]["txtB"].value;
                if (f == "") {
                    alert("B must be not empty");
                    return false;
                }
                   var g = document.forms["myForm"]["txtC"].value;
                   
                    if(g == e || g==f || g==h){
                    alert("C must be match B || C || D");
                    return false;
                }
                 var h = document.forms["myForm"]["txtD"].value;
                if (h == "") {
                  
                    return true;
                }else 
                    if(h == e || h==g || h==f){
                    alert("D must be match A || C || B");
                    return false;
                }
            }
            ;
        </script>
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
    border: 1px solid black;
    margin-top: 100px;
    margin-left: 850px;
    background-color: floralwhite;
    grid-gap: 15px;
    border-radius: 10px;
    display: grid;
    padding: 20px;
    width: 100px;
    height: 20px;
    grid-template-columns: 10px 10px 10px 10px 10px 10px;
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
 .product {
    display: grid;
    grid-gap: 20px;
    grid-template-columns: 200px 200px 200px 200px 200px;
    width: 1100px;
    padding-top: 5px;
    margin-top: 20px;
    padding-left: 20px;
    border-radius: 10px;
    border: buttonshadow;
}

.bodyy > .product
{
    margin: auto;
    border: buttonshadow;

}

.aM{
    background-color: rgba(255, 255, 255, 0.8);
    border: 1px solid rgba(0, 0, 0, 0.8);
    padding: 20px;
    font-size: 20px;
    text-align: center;
    border-radius: 5px;
    border-color: aqua;

}
.product > div img{
    text-align: center;
    margin: 5px 10px;
    border: window;


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
    </head>
    <body>
        <form name="myForm" action="Edit?Page=SearchString" onsubmit="return validateForm()">
            Product ID: ${param.txtQuestionID}<br/>
                    <input type="hidden" name="txtQuestionID" value="${param.txtQuestionID}" /><br/>
            <label for="lname">Question Name</label>
            <input type="text" id="lname" name="txtName" value="${param.txtName}">

            <label for="lname">Answer Content</label><br/>
            <input  type="text" id="price" name="txtAnsCon" value="${param.txtAnsCon}"><br/>
            <label for="lname">Correct</label>
            <input type="text" id="image" name="txtCorrect" value="${param.txtCorrect}">   
            <label for="lname">Answer A </label><br/>
            <input type="text" id="Quantity" name="txtA"  value="${param.txtA}" ><br/><br/>

            <label for="lname">Answer B </label><br/>
            <input type="text" id="Quantity" name="txtB"  value="${param.txtB}" ><br/><br/>
            <label for="lname">Answer C </label><br/>
            <input type="text" id="Quantity" name="txtC"  value="${param.txtC}" ><br/><br/>
            <label for="lname">Answer D </label><br/>
            <input type="text" id="Quantity" name="txtD"  value="${param.txtD}" ><br/><br/>
            
            <label for="country">Subject</label>
            <select id="country" name="cmbSub">
                <option value="PRJ321" ${param.cmbSub=='PRJ321'?"selected":""}>Lab Web</option>
                <option value="PRJ221" ${param.cmbSub=='PRJ221'?"selected":""}>Java Web</option>
                

            </select>

            <label for="lname">Status</label> 
            <select id="country" name="cmbStatus">
            <option value="active" ${param.cmbStatus=='active'?"selected":""}>Active</option>
            <option value="deactive" ${param.cmbStatus=='deactive'?"selected":""}>Deactive</option>
             </select>

<!--            <select id="country" name="cmbStatus">
                <option value="active" >active</option> 
                <option value="deactive"${param.cmbStatus=='deactive'?"selected":""}>Deactive</option>
            </select>-->
             
            
            <input type="hidden" name="PageIndex" value="${param.PageIndex}" />
            <input type="hidden" name="cmbStatus" value="${param.cmbStatus}" />
            <input type="hidden" name="Search" value="${param.Search}" />
            
           
            <input type="hidden" name="txtQuestionName" value="${param.txtQuestionName}" />
            <input type="hidden" name="txtSubject" value="${param.txtSubject}" />
<!--            <input type="hidden" name="SearchString" value="${param.SearchString}" />-->

            <input type="submit" value="Edit">
        </form>
       
    </body>
    <form action="teacher" method="POST">
        <input type="submit" value="Back to Home Page" />
    </form>
     
</html>
