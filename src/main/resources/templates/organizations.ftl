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

        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/basket">Корзина</a>
            </li>

        </ul>

        <form class="d-flex" action="/profile" method="get">
            <button class="btn btn-outline-success" type="submit">Личный кабинет</button>
        </form>
    </div>
    </div>
</nav>

<br>

<div class="container">
    <div class="row justify-content-center">
        <#list restList as rest>

            <div class="col-8">
                <div class="card-deck mb-3 text-center">
                    <div class="card mb-4 box-shadow">
                        <div class="card-header">
                            <div class="row justify-content-center">
                                <a href = "/organizations/${rest.id}">

                                    <div class="col-3">
                                        <h4 class="my-0 font-weight-normal">${rest.name} </h4>
                                    </div>
                                </a>
                            </div>
                        </div>

                        <div class="card-body">
                            <h5 class="card-title pricing-card-title"> <#if rest.content??>"${rest.content?html}"</#if></h5>
                        </div>
                    </div>
                </div>
            </div>

            <br>
        </#list>
    </div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>