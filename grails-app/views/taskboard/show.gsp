<html>
    <body>
    <h1>${taskboard.myName}</h1>
    <table style="float:left" border="1">
        <tr>
        <g:each var="column" in="${columns}">
            <th>${column.myName}</th>
        </g:each>
        </tr>
        <tr>
        <g:each var="column" in="${columns}">
            <td valign="top">
                <ul>
                <g:each var="task" in="${column.getTasks()}">
                    <li>
                    <g:link controller="task" action="show" id="${task.id}">${task.myName}</g:link>
                    (<g:link controller="user" action="show" id="${task.myOwner.id}">${task.myOwner.myLogin}</g:link>)
                    </li>
                </g:each>
                </ul>
            </td>
        </g:each>
        </tr>
    </table>
    </body>
</html>
