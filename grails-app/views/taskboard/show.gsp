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
                    ${task.myName}
                    (${task.myOwner.myName})
                    </li>
                </g:each>
                </ul>
            </td>
        </g:each>
        </tr>
    </table>
    </body>
</html>
