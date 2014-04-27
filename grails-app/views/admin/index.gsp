<html>
    <body>
        <h1>Awesome Admin Stuff</h1>
        <h2>Available Users</h2>
        <ul>
        <% users.each { user -> %>
            <li><g:link controller="user" action="show" id="${user.id}">${user.myLogin} (${user.myName})</g:link></li>
        <%}%>
        </ul>
        <h2>Available Taskboards</h2>
        <ul>
        <% taskboards.each { board -> %>
            <li><g:link controller="taskboard" action="show" id="${board.id}">${board.myName}</g:link></li>
        <%}%>
        </ul>
    </body>
</html>
