<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>YayLunch</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">YayLunch</a>


        <#if user.role == "USER">
            <a class="navbar-brand" href="/profile">
                ${user.firstName} ${user.lastName}
            </a>
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/basket">Корзина</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/organizations">Рестораны</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/order/account">Прошлые заказы</a>
                </li>

            </ul>
        <#elseif user.role == "SCHOOL">
            <a class="navbar-brand" href="/profile">
                ${user.name}
            </a>
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/order/account">Заказы на получение</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/clients">Список учеников</a>
                </li>

            </ul>
        <#elseif user.role == "RESTAURANT">
            <a class="navbar-brand" href="/profile">
                ${user.name}
            </a>
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/order/account">Заказы на приготовление</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/dish">Список блюд</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/dish/new">Добавить новое блюдо</a>
                </li>

            </ul>
        </#if>
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
<div class="container">
    <div class="row justify-content-center">
        <div class="col-6">
            <#if user.role == "USER">
                <form class="form-center-content" method="post" action="/profile">
                    Имя:
                    <br>
                    <input type="text" name="firstName" id="firstName" class="form-control"
                           placeholder=${user.firstName}>
                    <br>
                    Фамилия:
                    <br>
                    <input type="text" name="lastName" id="lastName" class="form-control" placeholder=${user.lastName}>
                    <br>
                    Email:
                    <br>
                    <input type="text" name="email" id="email" class="form-control" placeholder=${user.email}>
                    <br>
                    Телефон:
                    <br>
                    <input type="text" name="phone" id="phone" class="form-control" placeholder=${user.phone}>
                    <br>
                    Школа:
                    <br>
                    <select id="clientSchoolId" name="clientSchoolId" class="form-select"
                            aria-label="Default select example"
                            style="background-color: #f0f0f0" required>

                        <option value= <#if user.clientSchoolId??>${user.clientSchoolId}</#if> selected><#if user.clientSchoolName??>"${user.clientSchoolName?html}"</#if></option>
                        <#list schools as school>
                            <option value=${school.id}>${school.name}
                            <#if school.country??>${school.country}</#if>
                            <#if school.city??>${school.city}</#if>
                            <#if school.street??> ${school.street}</#if>
                            <#if school.house??> ${school.house}</option></#if>
                        </#list>
                    </select>
                    <br>
                    Класс/курс:
                    <br>
                    <input type="text" name="grade" id="grade" class="form-control"
                           placeholder=<#if user.grade??>${user.grade}</#if>>
                    <br>
                    Буква класса/номер группы:
                    <br>
                    <input type="text" name="className" id="className" class="form-control"
                           placeholder=<#if user.className??>${user.className}</#if>>
                    <br>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Отправить изменения</button>

                </form>

            <#elseif user.role == "SCHOOL">
                <form class="form-center-content" method="post" action="/profile">
                    Название:
                    <br>
                    <input type="text" name="name" id="name" class="form-control" placeholder="${user.name?html}"<#t>>
                    <br>
                    Email:
                    <br>
                    <input type="text" name="email" id="email" class="form-control" placeholder=${user.email}>
                    <br>
                    Телефон:
                    <br>
                    <input type="text" name="phone" id="phone" class="form-control" placeholder=${user.phone}>
                    <br>
                    Страна:
                    <br>
                    <input type="text" name="country" id="country" class="form-control"
                           <#if user.country??><#else>required</#if>
                           placeholder=<#if user.country??>${user.country}</#if>>
                    <br>
                    Город:
                    <br>
                    <input type="text" name="city" id="city" class="form-control" <#if user.city??><#else>required</#if>
                           placeholder=<#if user.city??>${user.city}</#if>>
                    <br>
                    Улица:
                    <br>
                    <input type="text" name="street" id="street" class="form-control"
                           <#if user.street??><#else>required</#if>
                           placeholder=<#if user.street??>${user.street}</#if>>
                    <br>
                    Дом:
                    <br>
                    <input type="text" name="house" id="house" class="form-control"
                           <#if user.house??><#else>required</#if>
                           placeholder=<#if user.house??>${user.house}</#if>>
                    <br>
                    Индекс:
                    <br>
                    <input type="text" name="postalCode" id="postalCode" class="form-control"
                           <#if user.postalCode??><#else>required</#if>
                           placeholder=<#if user.postalCode??>${user.postalCode}</#if>>
                    <br>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Отправить изменения</button>

                </form>
            <#elseif user.role == "RESTAURANT">
                <form class="form-center-content" method="post" action="/profile">
                    Название:
                    <br>
                    <input type="text" name="name" id="name" class="form-control" placeholder="${user.name?html}"<#t>>
                    <br>
                    Email:
                    <br>
                    <input type="text" name="email" id="email" class="form-control" placeholder=${user.email}>
                    <br>
                    Телефон:
                    <br>
                    <input type="text" name="phone" id="phone" class="form-control" placeholder=${user.phone}>
                    <br>
                    Информация о ресторане:
                    <br>
                    <input type="text" name="content" id="content" class="form-control"
                           <#if user.content??><#else>required</#if>
                           placeholder=<#if user.content??>"${user.content?html}"</#if>>
                    <br>
                    Страна:
                    <br>
                    <input type="text" name="country" id="country" class="form-control"
                           <#if user.country??><#else>required</#if>
                           placeholder=<#if user.country??>${user.country}</#if>>
                    <br>
                    Город:
                    <br>
                    <input type="text" name="city" id="city" class="form-control" <#if user.city??><#else>required</#if>
                           placeholder=<#if user.city??>${user.city}</#if>>
                    <br>
                    Улица:
                    <br>
                    <input type="text" name="street" id="street" class="form-control"
                           <#if user.street??><#else>required</#if>
                           placeholder=<#if user.street??>${user.street}</#if>>
                    <br>
                    Дом:
                    <br>
                    <input type="text" name="house" id="house" class="form-control"
                           <#if user.house??><#else>required</#if>
                           placeholder=<#if user.house??>${user.house}</#if>>
                    <br>
                    Индекс:
                    <br>
                    <input type="text" name="postalCode" id="postalCode" class="form-control"
                           <#if user.postalCode??><#else>required</#if>
                           placeholder=<#if user.postalCode??>${user.postalCode}</#if>>
                    <br>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Отправить изменения</button>
                </form>
            </#if>

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
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>