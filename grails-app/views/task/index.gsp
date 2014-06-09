<head>
    <asset:javascript src="application.js"/>
</head>
<body>
    <h1>Tasks</h1>
    <ul>
    <% tasks.each { task -> %>
        <li>
            <b><g:link action="show" id="${task.id}">${task.name}</g:link></b>
            <% user = taskService.getUserOfTask(task.id) %>
            <g:if test="${user != null}">
                by <g:link controller="user" action="show" id="${user.id}">${user.name}</g:link>
            </g:if>
            <g:link action="delete" id="${task.id}">delete</g:link>
        </li>
    <%}%>
    </ul>
    <p><g:link action="edit">new</g:link></p>
</body>
