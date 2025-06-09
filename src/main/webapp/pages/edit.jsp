<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
    <head>
        <title> Edit Programmer </title>
    </head>
    <body>
        <main>
            <form action="editProgrammer">
                <input type="hidden" name="id" value="${programmer.id}" />

                <label> Edited Name of ${programmer.id}: </label>
                <input type="text" name="name" value="${programmer.name}" />

                <input type="submit" value="Edit" />
            </form>
        </main>
    </body>
</html>
