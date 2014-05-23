<html>
    <head>
        <style type="text/css" media="screen">
            table {
                border-collapse: collapse;
                border: 1px solid black;
            }

            table td,th {
                border: 1px solid black;
                padding: 2px 8px;
            }
        </style>
    </head>
    <body>
        <h1>${taskboard.myName}</h1>
        <table>
            <tr>
            <g:each var="column" in="${columns}">
                <th>${column.myName}
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
                        <g:link controller="task" action="show" id="${task.id}">${task.myName}</g:link>
                        <% user = taskService.getUserOfTask(task.id) %>
                        <g:if test="${user != null}">
                            (<g:link controller="user" action="show" id="${user.id}">${user.myName}</g:link>)
                        </g:if>
                        </li>
                    </g:each>
                    </ul>
                </td>
            </g:each>
            </tr>
        </table>
    </body>
</html>
