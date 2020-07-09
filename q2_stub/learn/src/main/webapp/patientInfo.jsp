<%@ page import="java.io.PrintWriter" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!--
    TODO 4: Fetch the data inserted into the index.jsp page and display them as
    shown in the problem statement
    -->
    <title>Patient</title>
    </head>
    <body>
    <form action="index.jsp" method="post">
        <table style="with: 50%">

            <tr>
                <td>Patient Name</td>
                <td><input type="text" name="patientname" value="<%=request.getParameter("Name")%>"/></td>
            </tr>
            <tr>
                <td>Age</td>
                <td><input type="text" name="age" value="<%=request.getParameter("Age")%>"/></td>
            </tr>
            <tr>
                <td>Phone Number</td>
                <td><input type="text" name="phno" value="<%=request.getParameter("phone")%>"/></td>
            </tr>
        </table>
        </form>

    </body>
</html>
