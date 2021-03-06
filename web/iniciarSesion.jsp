<%-- 
    Document   : iniciarSesion
    Created on : 14/04/2022, 01:51:33 AM
    Author     : Kevin Ivan Sanchez Valdin
--%>

<%@page import="java.util.Random"%>
<%@page import="java.awt.Color"%>
<%@page import="java.awt.Color"%>
<%@page import="java.awt.Font"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.awt.Graphics"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

        <!-- Favicons -->
        <link href="assets/img/imagenes/Logo_1.png" rel="icon">
        <link href="assets/img/imagenes/Logo_1.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
        <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">

        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    </head>
    <body>
        <%@ page import="controller.inicio.Srv_inicio_sesion" %>
        <header id="header" class="fixed-top">
            <div class="container-fluid d-flex align-items-lg-start">
                <a href="index.jsp" class="logo me-auto"><img src="assets/img/imagenes/logotipodonamx_1.png" alt="" class="img-fluid"></a>

                <nav id="navbar" class="navbar order-last order-lg-0">
                    <ul>
                        <li>
                            <a class="nav-link scrollto " href="index.jsp">
                                <i>
                                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-house-door"
                                         fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd"
                                          d="M7.646 1.146a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 .146.354v7a.5.5 0 0 1-.5.5H9.5a.5.5 0 0 1-.5-.5v-4H7v4a.5.5 0 0 1-.5.5H2a.5.5 0 0 1-.5-.5v-7a.5.5 0 0 1 .146-.354l6-6zM2.5 7.707V14H6v-4a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5v4h3.5V7.707L8 2.207l-5.5 5.5z" />
                                    </svg>
                                </i>Inicio
                            </a>
                        </li>
                        <li><a class="nav-link scrollto" href="dona.jsp">
                                <i>
                                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-card-heading"
                                         fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd"
                                          d="M14.5 3h-13a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h13a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z" />
                                    <path fill-rule="evenodd"
                                          d="M3 8.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5z" />
                                    <path d="M3 5.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5v-1z" />
                                    </svg>
                                </i>
                                ¡Dona!
                            </a>
                        </li>
                        <li>
                            <a class="nav-link scrollto" href="conocenos.jsp">
                                <i>
                                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-building"
                                         fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd"
                                          d="M14.763.075A.5.5 0 0 1 15 .5v15a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5V14h-1v1.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V10a.5.5 0 0 1 .342-.474L6 7.64V4.5a.5.5 0 0 1 .276-.447l8-4a.5.5 0 0 1 .487.022zM6 8.694L1 10.36V15h5V8.694zM7 15h2v-1.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 .5.5V15h2V1.309l-7 3.5V15z" />
                                    <path d="M2 11h1v1H2v-1zm2 0h1v1H4v-1zm-2 2h1v1H2v-1zm2 0h1v1H4v-1zm4-4h1v1H8V9zm2 0h1v1h-1V9zm-2 2h1v1H8v-1zm2 0h1v1h-1v-1zm2-2h1v1h-1V9zm0 2h1v1h-1v-1zM8 7h1v1H8V7zm2 0h1v1h-1V7zm2 0h1v1h-1V7zM8 5h1v1H8V5zm2 0h1v1h-1V5zm2 0h1v1h-1V5zm0-2h1v1h-1V3z" />
                                    </svg>
                                </i>
                                Conócenos
                            </a>
                        </li>
                    </ul>
                    <i class="bi bi-list mobile-nav-toggle"></i>
                </nav
                <a class="appointment-btn scrollto" href="#appointment" ></a>

                <a class="appointment-btn scrollto d-flex align-items-center"  href="registrarse.jsp" >
                    <i>
                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-person-circle" fill="currentColor"
                             xmlns="http://www.w3.org/2000/svg">
                        <path d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z" />
                        <path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
                        <path fill-rule="evenodd"
                              d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z" />
                        </svg>
                    </i>
                    Registrate</a>
            </div>
        </header>
        <main style="margin-top:40px; background-image: url('assets/img/laptop-g3492e56fe_1920.jpg');background-size: cover; " >
            <section  class="contact" ><!-- section register d-flex flex-column align-items-center justify-content-center py-4
                
                -->

                <div class="container">
                    <c:if test="${not empty respuesta}">

                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            ${respuesta}
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                    </c:if>
                    <div class="row justify-content-center">
                        <div class="col-lg-5 col-md-5 d-flex flex-column align-items-center justify-content-center">
                            <div class="card mb-3">
                                <div class="card-body">
                                    <div class="pt-4 pb-2">
                                        <h5 class="card-title text-center pb-0 fs-4">Ingrese a su cuenta</h5>
                                        <p class="text-center small">Ingrese su usuario y contraseña para iniciar sesión</p>
                                    </div>
                                    
                                    <form action="Srv_inicio_sesion" id="form-inicio-sesion" method="post" 
                                          class="row php-email-form g-3 needs-validation"  role="form" autocomplete="on">
                                        <div class="col-12">
                                           <!-- <label for="yourUsername" class="form-label">Correo electronico</label>-->
                                            <div class="input-group has-validation">
                                                <span class="input-group-text" id="inputGroupPrepend"><i class="bi bi-envelope-fill"></i></span>
                                                <input type="text" name="username" class="form-control" id="yourUsername" placeholder="Correo eléctronico"  required>
                                                <div class="invalid-feedback">¡Ingresa tu correo electronico!</div>
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <!--<label for="yourPassword" class="form-label">Contraseña</label>-->
                                            <div class="input-group has-validation">
                                                <span class="input-group-text" id="inputGroupPrepend"><i class="bi bi-key-fill"></i></span>
                                                <input type="password" name="password" class="form-control" placeholder="Contraseña" id="yourPassword" required>
                                                <div class="invalid-feedback">¡Ingresa tu contraseña!</div>
                                            </div>
                                        </div>
                                        <label for="inpCaptcha" style="margin-top: 20px">Código</label>
                                        <div class="col-12 d-inline-block">
                                            <img id="img_captcha" src="Captcha" width="80%" class="rounded-2">

                                            <button id="btnCaptcha" type="button" class="btn btn-primary" onclick="window.location.reload(true);" >
                                                <span class="bx bx-refresh" aria-hidden="true" ></span>
                                            </button>
                                        </div>

                                        <input id="captcha"
                                               name="captcha"
                                               type="text"
                                               class="form-control"
                                               placeholder="Ingrese el Código"
                                               required
                                               autocomplete="off">
                                        <!-- <div class="g-recaptcha" data-sitekey="6LdikOkfAAAAAIM8b3zXMWjcyeOe9iVs1I3D7KvW"></div>
                                        --> <div class="col-12">
                                            <button class="btn btn-primary w-100" type="submit">Ingresar</button>
                                        </div>
                                        <div class="col-12">
                                            <p class="small mb-0">¿No tienes una cuenta? <a href="registrarse.jsp">Crea una</a></p>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main><!-- End #main -->
        <%@include  file="views/templates/footer/footer_principal.jsp" %>
        <div id="preloader"></div>
        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>
        <script>
            //así con JS normal
            //accediendo directamente a src
            function cambiarImagenJS() {
                document.getElementById("img_captcha").src = 'Captcha';
            }

            //así con jQuery
            //haciendo uso de la función attr()
            function cambiarImagenjQ() {
                $("#img_captcha").attr("src", "Captcha");
            }
        </script>
        <!-- Vendor JS Files -->
        <script src="assets/vendor/purecounter/purecounter.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
        <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>
    </body>
</html>
