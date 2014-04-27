<html>
    <body>
        <h1>Create new user</h1>
        <form name="create" action="<g:createLink controller="user" />" method="post">
            Login: <input type="text" size="4" name="userlogin"></br>
            Name: <input type="text" size="4" name="username"></br>
            <input type="submit" Value="Create user">
        </form>
        
        <hr/>
        <g:link uri="/">home</g:link>
    </body>
</html>
