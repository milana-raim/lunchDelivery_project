<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>YayLunch</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function () {
            // Обработчик события отправки формы
            $('#orderSub').submit(function (event) {
                // Отменить обычное поведение формы (перезагрузку страницы)
                event.preventDefault();

                // Получить данные из формы
                var formData = {
                    date: $('#date').val(),
                    preference: $('#preference').val()
                };

                // Отправить AJAX-запрос
                $.ajax({
                    type: 'POST', // или 'GET', в зависимости от вашего API
                    url: '/order/new',
                    data: formData,
                    success: function (response) {
                        // Обработать успешный ответ от сервера
                        console.log(response);
                        // Дополнительные действия по вашему усмотрению
                    },
                    error: function (xhr, status, error) {
                        // Обработать ошибку
                        console.log(error);
                    }
                });
                document.getElementById('mainCont').innerHTML = '<p class="lead">Ой, что-то пусто...</p>';
            });
        });
    </script>
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">YayLunch</a>

        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/organizations">Рестораны</a>
            </li>

        </ul>

        <form class="d-flex" action="/profile" method="get">
            <button class="btn btn-outline-success" type="submit">Личный кабинет</button>
        </form>
    </div>
</nav>

<br>

<div class="container">
    <div id="mainCont" class="row justify-content-center">
        <#if dishs?size != 0>
            <#list dishs as dish>

                <div class="col-8">
                    <div class="card-deck mb-3 text-center">
                        <div class="card mb-4 box-shadow">
                            <div class="card-header">
                                <div class="row justify-content-center">

                                    <div class="col-3">
                                        <h4 class="my-0 font-weight-normal">${dish.name} </h4>
                                    </div>

                                </div>
                            </div>
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-4">
                                        <#if dish.getPhoto()??>
                                            <img src="/image/${dish.photo.id}" class="img-fluid mx-auto d-block"
                                                 style=" max-height: 100px;" alt="Photo"/>
                                        </#if>
                                    </div>
                                    <div class="col-md-4">
                                        <h5 class="card-title pricing-card-title">Calories: ${dish.calories}</h5>
                                        <h5 class="card-title pricing-card-title">Ingredients: ${dish.ingredients}</h5>
                                        <h5 class="card-title pricing-card-title">Price: ${dish.price}</h5>

                                        <a href="/basket/deleteDish?dishId=${dish.id}">
                                            <h5 class="card-title pricing-card-title">Удалить</h5>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <br>
            </#list>
            <div class="row justify-content-center">
                <div class="text-center col-md-8">
                    <form class="form-signin" id="orderSub">
                        <h5 class="card-title pricing-card-title">Время доставки</h5>
                        <input type="datetime-local" id="date" name="date" class="form-control"
                               placeholder="Время доставки" required autofocus>
                        <br>
                        <h5 class="card-title pricing-card-title">Детали заказа</h5>
                        <textarea type="text" name="preference" id="preference" class="form-control"
                                  placeholder="Детали заказа" required></textarea>
                        <br>
                        <button class="btn btn-lg btn-primary btn-block" onclick="confirmOrder()" type="submit">Оформить
                            заказ
                        </button>
                        <br>
                        <br>
                    </form>
                </div>
            </div>
        <#else>
            <p class="lead">Ой, что-то пусто...</p>
        </#if>

    </div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>