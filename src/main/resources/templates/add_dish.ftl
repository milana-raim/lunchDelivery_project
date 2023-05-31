<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Добавить блюдо</title>
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
                <form enctype="multipart/form-data" class="form-add-dish" method="post" action="/dish/new">
                    <h1 class="h3 mb-3 font-weight-normal">Добавить блюдо</h1>
                    <br>
                    <input type="text" id="email" name="name" class="form-control" placeholder="Название блюда" required autofocus>
                    <br>
                    <input type="text" name="calories" id="calories" class="form-control" placeholder="Калории" required>
                    <br>
                    <input type="text" name="ingredients" class="form-control" placeholder="Ингридиенты" required>
                    <br>
                    <input type="text" name="fat" class="form-control" placeholder="Жиры" required>
                    <br>
                    <input type="text" name="protein" class="form-control" placeholder="Белки" required>
                    <br>
                    <input type="text" name="carbohydrate" class="form-control" placeholder="Углеводы" required>
                    <br>
                    <input type="text" name="protein" class="form-control" placeholder="Углеводы" required>
                    <br>
                    <input type="text" name="price" class="form-control" placeholder="Цена" required>
                    <br>
                    <input type="file" name="photo" class="form-control" required>
                    <br>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Добавить</button>
                </form>
            </div>
        </div>
    </div>

</div>
</body>
</html>