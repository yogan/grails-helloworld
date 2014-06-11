<head>
</head>
<body>
    <h1>${taskboard.name}</h1>
    <table>
        <tr>
        <g:each var="column" in="${columns}">
            <th>${column.name}
            <g:if test="${column.limit > 0}">
            (${column.getTasks().size()}/${column.limit})
            </g:if>
            </th>
        </g:each>
        </tr>
        <tr>
        <g:each var="column" in="${columns}">
            <td valign="top">
                <ul>
                <g:each var="task" in="${column.getTasks()}">
                    <li>
                    <g:link controller="task" action="show" id="${task.id}">${task.name}</g:link>
                    <% user = taskService.getUserOfTask(task.id) %>
                    <g:if test="${user != null}">
                        (<g:link controller="user" action="show" id="${user.id}">${user.name}</g:link>)
                    </g:if>
                    </li>
                </g:each>
                </ul>
            </td>
        </g:each>
        </tr>
    </table>
</body>
