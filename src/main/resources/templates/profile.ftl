<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>YayLunch</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">YayLunch</a>
        <a class="navbar-brand" href="/account">
            ${user.firstName} ${user.lastName}
        </a>



        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link" aria-current="page" href="/basket">Корзина</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/organizations">Рестораны</a>
            </li>

        </ul>


        <form class="d-flex" action="/logout" method="post">
            <button class="btn btn-outline-success" type="submit">Выйти</button>
        </form>
    </div>
    </div>
</nav>

<br>

<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
    <h1 class="display-4">Ваш личный кабинет</h1>
    <p class="lead">Здесь вы можете редактировать свои данные</p>
</div>

<br>

<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">

<#--    <#if user.role == "USER">
        <p class="lead">Выбрать роль</p>

        <form class="form-center-content" action="/signOut" method="post">
            <div>
                <input type="radio" class="btn-check" name="options" id="option1" autocomplete="off" checked>
                <label class="btn btn-secondary" for="option1">Представитель образовательного учреждения</label>

                <input type="radio" class="btn-check" name="options" id="option2" autocomplete="off">
                <label class="btn btn-secondary" for="option2">Представитель ресторана общественного питания</label>
            </div>

            <br>
            <br>

        <input class="btn " type="submit"></input>
        </form>
    <#else>
        <p class="lead">Ваша роль:</p>

        <input type="radio" class="btn-check" name="options" id="option1" autocomplete="off" checked>
        <label class="btn btn-secondary" for="option1">${user.role}</label>
    </#if>-->
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>