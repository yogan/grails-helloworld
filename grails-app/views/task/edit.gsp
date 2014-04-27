<html>
    <body>
        <h1>
            <g:if test="${task}">
                Edit Task "${task.myName}"
            </g:if>
            <g:else>
                New Task
            </g:else>
        </h1>
        <g:form name="addForm" action="save" id="${task?.id}">
            Title: <g:textField name="name" value="${task?.myName}"/><br/>
            Owner: <g:select name="owner"
                             from="${users}"
                             optionKey="id"
                             optionValue="myName"
                             value="${defaultUserId}"/>
            <g:submitButton name="save" value="Save" />
        </g:form>
    </body>
</html>
