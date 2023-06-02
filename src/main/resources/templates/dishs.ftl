<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>YayLunch</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        function addToBasket(dishId) {
            $.ajax('/basket/addDish', {
                method: 'GET',
                data: {
                    'dishId': dishId
                },
                success: function (result) {
                    const elem = document.getElementById('add' + dishId);
                    elem.classList.remove('btn-primary')
                    elem.classList.add('btn-success')
                    var toastLiveExample = document.getElementById('liveToast')
                    var toast = new bootstrap.Toast(toastLiveExample)

                    toast.show()
                    console.log("The product was added to basket")
                }, statusCode: {
                    418: function(xhr) {
                        const elem = document.getElementById('add' + dishId);
                        elem.classList.remove('btn-primary')
                        elem.classList.add('btn-danger')
                        var toastLiveExample = document.getElementById('liveToast2')
                        var toast = new bootstrap.Toast(toastLiveExample)

                        toast.show()
                        console.log("geted 100")
                    }
                }
            })

        }
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
    <div class="row justify-content-center">
        <#list dishsList as dish>

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
                                    <br>
                                    <button  class="btn btn-lg btn-primary btn-block liveToastBtn" type="submit"
                                            id="add${dish.id}"
                                            onclick="addToBasket(${dish.id})">Add to order

                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <br>
        </#list>
    </div>
    <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
        <div id="liveToast" class="toast align-items-center text-white bg-primary border-0" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="d-flex">
                <div class="toast-body">
                    Блюдо добавлено в корзину
                </div>
                <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Закрыть"></button>
            </div>
        </div>
    </div>

    <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
        <div id="liveToast2" class="toast align-items-center text-white bg-primary border-0" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="d-flex">
                <div class="toast-body">
                    Нельзя добавить блюда из разных ресторанов
                </div>
                <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Закрыть"></button>
            </div>
        </div>
    </div>

</div>


</body>
</html>