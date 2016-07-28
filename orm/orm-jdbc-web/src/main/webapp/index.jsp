<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>emoji</title>
</head>
<body>

<h3>EMOJI 表情，请在下面输入带emoji表情的内容!</h3>

<form action="/emoji" method="post">
    <div>
        <input type="text" name="content"/>
        <br/>
        <input type='submit' value="提交"/>
    </div>
</form>
</body>
</html>