<html>
    <body>
        <h1>${task.myName}</h1>
        <g:if test="${task.myOwner != null}">
            <p>by <g:link controller="user" action="show" id="${task.myOwner.id}">${task.myOwner.myName}</g:link></p>
        </g:if>
        <p><g:link action="edit" id="${task.id}">edit</g:link> |
           <g:link action="delete" id="${task.id}">delete</g:link></p>
    </body>
</html>
