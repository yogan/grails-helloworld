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
