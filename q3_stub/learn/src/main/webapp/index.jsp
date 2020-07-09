<html>
<body>
    <!--
    TODO 1: Create a login form as shown in the problem statement.
    -->
    <div class="form_wrapper">
        <form action="login" method="post" id="login_form">
            <div id="email_div">
                <label for="emailId">User Email</label>
                <input type="text" placeholder="example@email.com" name="emailId" id="emailId"/>
            </div>
            <div id="password_div">
                <label for="password">Password</label>
                <input type="password"  placeholder="********" name="password" id="password"/>
            </div>
            <input type="submit" value="Submit" name="actionTypeSignIn"/>
            <div class="error">
            </div>
        </form>
        </div>
</body>
</html>
