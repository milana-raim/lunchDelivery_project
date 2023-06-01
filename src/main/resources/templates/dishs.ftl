<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>YayLunch</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        function addToBasket(dishId) {
            $.ajax('/basket/addDish', {
                method: 'GET',
                data: {
                    'dishId': dishId
                },
                success: function (result) {
                    console.log("The product was added to basket")
                }
            })
            const elem = document.getElementById('add' + dishId);
            elem.classList.remove('btn-primary')
            elem.classList.add('btn-success')


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
                                    <button class="btn btn-lg btn-primary btn-block" type="submit"
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

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>