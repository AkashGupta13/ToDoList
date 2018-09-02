<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style type="text/css">
.inlineTable{
    display: inline-block;
    float: top;
}
</style>


<html>
    <head>
        <title>Lists</title>
    </head>
    <body>
        <center>



<c:forEach items="${lists}" var="list">
    <table border="solid" class="inlineTable">
    <th><div>
        <form action="/DeleteList" method="post">
            <input type="number" hidden="hidden" name="ListId" value="${list.getListId()}"/>
            <div> ${list.getListName()} &nbsp; &nbsp; <input type="submit" value="Delete List"> </div>
        </form>
    </div>
    </th>
        <c:forEach items="${list.getItemList()}" var="item">
               <tr><td><form action="/DeleteItem" method="post">
                    <div>
                        <input type="number" hidden="hidden" name="itemId" value="${item.getItemId()}"/>
                        ${item.getItem()}  &nbsp; &nbsp; <input type="submit" value="Delete Item">
                    </div>
                </form>
               </td>
               </tr>

            </c:forEach>

        <tr><td>

            <form action="/AddItem" method="post">
                <input type="number" hidden="hidden" name="ListId" value="${list.getListId()}"/>
                Enter new item - <input type="text" name="item"> &nbsp; &nbsp;
                <input type="submit" value="Add Item!">
            </form>
        </td></tr>

    </table>
</c:forEach>





    <br><br>
    <form action="/Lists" method="post">
        List name : <input type="text" name="listName">
        <input type="submit" value="Create List!">
    </form>

<br>

<form action="/Logout" method="post">
    <input type="submit" value="Logout!">
</form>

        </center>
    </body>
</html>
