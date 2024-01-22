<html>
    <head>
        <title>LOGIN PAGE</title>
    </head>
    <body>
        <div class="container"> <%-- container 중앙 정렬 --%>
            <h1>Login</h1>
            <pre>${errorMessage}</pre>
            <form method="post">
                Name: <input type="text" name="name">
                Password: <input type="password" name="password">
                <input type="submit">
            </form>
        </div>
    </body>
</html>