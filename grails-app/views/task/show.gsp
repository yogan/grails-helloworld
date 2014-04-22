<html>
    <body>
        <h1>${task.myName}</h1>
        <g:if test="${task.myOwner != null}">
        <p>by ${task.myOwner.myName}</p>
        </g:if>
    </body>
</html>
