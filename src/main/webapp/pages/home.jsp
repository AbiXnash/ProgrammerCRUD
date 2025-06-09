<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> Home </title>
</head>
<body>

<main>
    <h3> Add Programmer </h3>
    <form action="addProgrammer">
        <label for="id"> ID: </label>
        <input type="text" name="id" /> <br/>

        <label for="name"> Name: </label>
        <input type="text" name="name" /> <br/>

        <input type="submit" value="Submit" />
    </form>

    ${addMsg}
    
    <h3> Search Programmer </h3>

    <form action="getProgrammer">
        <input type="text" name="id" /> <br />
        <input type="submit" value="Search" />
    </form>

    ${searchMsg}

    <h3> Delete Programmer </h3>

    <form action="deleteProgrammer">
        <input type="text" name="id" /> <br />
        <input type="submit" value="Delete" />
    </form>

    ${deleteMsg}

    <h3> Update Programmer </h3>
    <form action="updateProgrammer">

        <label for="newId"> ID: </label>
        <input type="text" name="id" value="${programmer.id}"/> <br/>

        <input type="submit" value="Submit" />
    </form>
</main>

</body>
</html>
