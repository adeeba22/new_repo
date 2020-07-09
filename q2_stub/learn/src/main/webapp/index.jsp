<html>
<body>
    <!--
    TODO 1: Create a form which display three text fields and one Submit button
    as shown in the problem statement
    -->
    <form action="addPatient" method="post">
        <label for="Pname">Patient Name</label>
        <input type="text" id="Pname" name="Name"/><br/>
        <label for="Age">Age</label>
        <input type="text" id="Age" name="Age" /><br/>
        <label for="Phno">Phone Number</label>
        <input type="text" id="Phno" name="phone" /><br/>
        <input type="submit" value="Add Patient" name="submit"/>
    </form>
</body>
</html>
