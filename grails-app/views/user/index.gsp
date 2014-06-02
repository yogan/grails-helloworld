<html>
    <body>
        <h2>Users</h2>
        <ul>
        <% users.each { user -> %>
            <li><g:link action="show" id="${user.id}">${user.login} (${user.name})</g:link></li>
        <%}%>
        </ul>
    </body>
</html>
