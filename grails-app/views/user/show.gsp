<html>
    <body>
        <h1>${user.name}</h1>
        <table>
            <tr><th>
                ${user.login}'s Taskboards
            </th></tr>
            <% taskboards.each { board -> %>
            <tr><td>
                <g:link controller="taskboard" action="show" id="${board.id}">${board.name}</g:link> <g:link controller="user" action="unfollow" id="${board.id}">unfollow</g:link> <g:link controller="taskboard" action="delete" id="${board.id}">delete</g:link> 
            </td></tr>
            <% } %>
        </table>
        
        <h1>Create new taskboard</h1>
        <form name="create" action="<g:createLink controller="taskboard" />" method="post">
            Name: <input type="text" size="4" name="name"></br>
            <input type="submit" Value="Create">
        </form>
    </body>
</html>
