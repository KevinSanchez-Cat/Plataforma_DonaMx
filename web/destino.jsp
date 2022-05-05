<%-- 
    Document   : destino
    Created on : 3/05/2022, 06:49:00 PM
    Author     : por_s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>DonaMx</title>
        <meta content="Plataforma dedicada a unir a fundaciones y estudiantes para donaciones
              de tipo tecnologico, de manera en que los estudiantes de escasos recursos 
              logren continuar con sus estudios, además de ser un lugar en donde se pueda conseguir 
              apoyo o subsidios de productos en materia de tecnologia" name="description">
        <meta content="tecnologia, computadoras, licencias, donaciones, estudiantes, educiacion, progreso" name="keywords">

        <link href="assets/img/imagenes/Logo_1.png" rel="icon">
        <link href="assets/img/imagenes/Logo_1.png" rel="apple-touch-icon">

        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <link href="assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
        <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

        <link href="assets/css/style.css" rel="stylesheet">
    </head>
    <body>
        <%@ page import="controller.inicio.Srv_registro" %>
        <header id="header" class="fixed-top">
            <div class="container-fluid d-flex align-items-lg-start">
                <a href="" class="logo me-auto"><img src="assets/img/imagenes/logotipodonamx_1.png" alt="" class="img-fluid"></a>
            </div>
        </header>
        <main>
            <%@ page import="controller.inicio.Srv_registro" %>
            <div class="container">
                <h1 class="main2">
                    <b> Bienvenid@ a DonaMx</b>
                </h1>
                <section class=""><!--section register d-flex flex-column align-items-center justify-content-center py-4 -->
                    <div class="container">
                        <div class="row"> <!-- justify-content-center --> <!--para centrar horizontalmente -->
                            <div class="col-lg-6 col-md-6 d-flex flex-column align-items-center justify-content-center">
                                <img src="assets/img/network_destino.jpg" alt="" class="img-fluid">
                            </div>
                            <div class="col-lg-6 col-md-6 d-flex flex-column align-items-center justify-content-center">
                                <div class="card mb-3">
                                    <div class="card-body">
                                        <div class="pt-4 pb-2">
                                            <h5 class="card-title text-center pb-0 fs-4 padding-btn">¿Cómo quieres participar?</h5>
                                            <p class="text-center small">Escoge una de las siguientes opciones para continuar.</p>
                                        </div>

                                        <form action="Srv_registro" id="form-registro" method="get"
                                              class="row g-3 needs-validation" novalidate>
                                            <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                                                <input type="radio" class="btn-check" name="ser" id="btnDar" value="donador" autocomplete="off" checked>
                                                <label class="btn btn-outline-success padding-btn" for="btnDar">Dar donaciones</label>

                                                <input type="radio" class="btn-check" name="ser" id="btnRecibir" value="donatario" autocomplete="off">
                                                <label class="btn btn-outline-secondary padding-btn" for="btnRecibir">Recibir donaciones</label>

                                                <input type="radio" class="btn-check" name="ser" id="btnColaborar"  value="voluntario" autocomplete="off">
                                                <label class="btn btn-outline-danger padding-btn" for="btnColaborar">Colaborar en las donaciones</label>
                                            </div>
                                            <div class="col-12">
                                                <button class="btn btn-primary w-100 padding-btn-fin" type="submit">Continuar</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </main>
        <script src="assets/vendor/purecounter/purecounter.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
        <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>
        <script src="assets/js/main.js"></script>
    </body>
</html>
