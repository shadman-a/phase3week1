<!DOCTYPE html>
<html>

<head>
    <title>Welcome</title>
</head>

<body>
<H1>Welcome</H1>
<div>
    <p1>Username: ${user.name}</p1>
    <Br/>
    <p1>Password: ${user.password}</p1>
</div>
<h3>Update Details</h3>
<form method="post">
    Username : <input type="text" name="name">
    Password : <input type="password" name="password">
    <input type="submit" />
</form>
</body>
</html>