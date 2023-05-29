<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link href="/resources/css/sign-in.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">YayLunch</a>
    </div>
</nav>

<br>

<div class="container">

    <div class="row justify-content-center">
        <div class="col-5">
            <div class="text-center">
                <form class="form-signin" method="post" action="/sign-up">
                    <h1 class="h3 mb-3 font-weight-normal">Регистрация</h1>
                    <input type="text" id = "firstName"name="firstName" class="form-control" placeholder="Имя" required autofocus>
                    <br>
                    <input type="text" id="lastName" name="lastName" class="form-control" placeholder="Фамилия" required autofocus>
                    <br>
                    <input type="text" id="email" name="email" class="form-control" placeholder="Email address" required autofocus>
                    <br>
                    <input type="text" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
                    <br>
                    <input type="text" name="phoneNumber" class="form-control" placeholder="Phone" required>
                    <br>
                        <p>Выберите, кем Вы являеетесь</p>
                        <input type="radio" id="role" name="role" value="USER" placeholder="Пользователь" checked required > Пользователь
                        <br>
                        <input type="radio" id="role" name="role" value="SCHOOL" placeholder="Представитель учебного заведения" required > Представитель учебного заведения
                        <br>
                        <input type="radio" id="role" name="role" value="RESTAURANT" placeholder="Представитель ресторана общественного питания" required > Представитель ресторана общественного питания
                    <br>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
                </form>
                <br>
                <a href="/sign-in" class="text">Войти</a>
            </div>
        </div>
    </div>

</div>





<#--<div class="container">-->
<#--<form action="/sign-up" method="post" class="form-center-content">-->
<#--    <div class="h3 mb fw-normal">Sign Up</div>-->
<#--    <div class = "form-floating">-->

<#--        <label for="firstName">First name</label>-->
<#--        <input id = "firstName"name="firstName" type="text" class="form-control">-->
<#--        </div>-->
<#--    <div class = "form-floating">-->
<#--        <label for="lastName">Last name</label>-->
<#--        <input id="lastName" name="lastName" type="text" class="form-control">-->
<#--    </div>-->
<#--    <div class = "form-floating">-->
<#--    <label for="email">Email</label>-->
<#--        <input id="email" name="email" type="email" class="form-control">-->
<#--    </div>-->
<#--    <div class = "form-floating">-->
<#--    <label for="password">Password</label>-->
<#--        <input id="password" name="password" type="password" class="form-control">-->
<#--    </div>-->
<#--    <div class = "form-floating">-->
<#--        <label for="phoneNumber">PhoneNumber</label>-->
<#--        <input id="phoneNumber" name="phoneNumber" type="text" class="form-control">-->
<#--    </div>-->
<#--    <input class="login-button" type="submit" value="Sign up">-->
<#--</form>-->
<#--    <a href="/sign-in" class="login-button">Sign In</a>-->
<#--</div>-->
</body>
</html>