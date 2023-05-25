<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign In</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
<nav class="navbar navbar-light bg-blue">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">YayLunch</a>
    </div>
</nav>

<br>

<div class="container">

    <div class="row justify-content-center">
        <div class="col-5">
            <div class="text-center">
                <form class="form-signin" method="post" action="/sign-in">
                    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
                    <input type="email" name="email" aria-describedby="emailHelp" id="exampleInputEmail1" class="form-control" placeholder="Email address" required autofocus>
                    <br>
                    <input type="password" name="password" id = "password" class="form-control" placeholder="Password" required>
                    <br>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </form>

                <br>
                <a href="/sign-up" class="text">Зарегистрироваться</a>
            </div>
        </div>
    </div>

</div>
</body>
</html>