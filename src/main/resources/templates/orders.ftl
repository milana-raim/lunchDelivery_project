<!DOCTYPE html>
<html lang="en">
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

        <form class="d-flex" action="/profile" method="get">
            <button class="btn btn-outline-success" type="submit">Личный кабинет</button>
        </form>
    </div>
    </div>
</nav>

<br>

<div class="container">
    <div class="row justify-content-center">
        <#list orders as order>

            <div class="col-8">
                <div class="card-deck mb-3 text-center">
                    <div class="card mb-4 box-shadow">
                        <div class="card-header">
                            <div class="row justify-content-center">

                                <div class="col-3">
                                    <h4 class="my-0 font-weight-normal">Заказ на ${order.deliveryDate} </h4>
                                </div>

                            </div>
                        </div>

                        <div class="card-body">
                            <#list order.dishes as dish>
                                <h5 class="card-title pricing-card-title">Название ${dish.name}</h5>
                                <h5 class="card-title pricing-card-title">Цена: ${dish.price}</h5>
                            </#list>
                            <h5 class="card-title pricing-card-title">Комментарий к заказу: ${order.preference}</h5>
                            <br>
                            <#if user.role == "RESTAURANT">
                                <#if order.state != "READY" && order.state!= "DELIVERED">

                                    <a href="/order/setStatus/${order.id}?status=READY">
                                        <h5 class="card-title pricing-card-title">Готов</h5>
                                    </a>
                                </#if>

                            <#elseif user.role == "SCHOOL">
                                <#if order.state != "DELIVERED">
                                    <a href="/order/setStatus/${order.id}?status=DELIVERED">
                                        <h5 class="card-title pricing-card-title">Доставлен</h5>
                                    </a>
                                </#if>

                            </#if>
                        </div>
                    </div>
                </div>
            </div>

            <br>
        </#list>
    </div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>