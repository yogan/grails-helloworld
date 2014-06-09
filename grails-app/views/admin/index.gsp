<head>
    <asset:stylesheet src="admin.css"/>
</head>
<body>
    <h1>Administration</h1>
    <h2>Available Users</h2>
    <ul>
    <% users.each { user -> %>
        <li><g:link controller="user" action="show" id="${user.id}">${user.login} (${user.name})</g:link></li>
    <%}%>
    </ul>
    <h2>Orphaned Taskboards</h2>
    <ul>
    <% taskboards.each { board -> %>
        <li><g:link controller="taskboard" action="show" id="${board.id}">${board.name}</g:link> <g:link controller="taskboard" action="delete" id="${board.id}">delete</g:link></li>
    <%}%>
    </ul>
</body>
