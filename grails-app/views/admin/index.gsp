<html>
    <body>
        <table>
            <tr><th>User</th><th>Login</th></tr>
            <% users.each { aUser -> %>
            <tr><td>
            <g:link action="show" id="${aUser.id}">${aUser.myLogin}</g:link>
            </td></tr>
            <%}%>
        </table>
        <table>
            <tr><th>Taskboards</th></tr>
            <% taskboards.each { taskboard -> %>
            <tr><td><%="${taskboard.myName}" %></td></tr>
            <%}%>
        </table>
    </body>
</html>
