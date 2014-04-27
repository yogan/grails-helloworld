<html>
    <body>
        <h1>${task.myName}</h1>
        <g:form name="addForm" action="save" id="${task?.id}">
            Title: <g:textField name="name" value="${task?.myName}"/><br/>
            <g:submitButton name="save" value="Save" />
        </g:form>
        <hr/>
        <g:link uri="/">home</g:link>
    </body>
</html>
