<!DOCTYPE html>
<html lang="en">
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
                <a class="nav-link" href="/organizations">Мои организации</a>
            </li>

        </ul>


        <form class="d-flex" action="/signOut" method="post">
            <button class="btn btn-outline-success" type="submit">Выйти</button>
        </form>
    </div>
    </div>
</nav>

<br>

<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
    <h1 class="display-4">Ваш личный кабинет</h1>
    <p class="lead">Здесь вы можете добавить организации и редактировать заказ</p>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>