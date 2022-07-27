<%-- 
    Document   : conocenos
    Created on : 14/04/2022, 01:52:31 AM
    Author     : Kevin Ivan Sanchez Valdin
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
        <script src="https://platform.linkedin.com/badges/js/profile.js" async defer type="text/javascript"></script>
    </head>
    <body>
        <%@ page import="controller.inicio.Srv_contacto" %>
        <header id="header" class="fixed-top">
            <div class="container-fluid d-flex align-items-lg-start">
                <a href="index.jsp" class="logo me-auto"><img src="assets/img/imagenes/logotipodonamx_1.png" alt="" class="img-fluid"></a>

                <nav id="navbar" class="navbar order-last order-lg-0">
                    <ul>
                        <li>
                            <a class="nav-link scrollto " href="index.jsp">
                                <i class="bi bi-house">
                                </i>Inicio
                            </a>
                        </li>
                        <li><a class="nav-link scrollto" href="dona.jsp">
                                <i class="bi bi-heart"></i>
                                ¡Dona!
                            </a>
                        </li>
                        <li>
                            <a class="nav-link scrollto active" href="conocenos.jsp">
                                <i class="bi bi-building"></i>
                                Conócenos
                            </a>
                        </li>
                    </ul>
                    <i class="bi bi-list mobile-nav-toggle"></i>
                </nav
                <a class="appointment-btn scrollto" href="#appointment" ></a>

                <a class="appointment-btn scrollto d-flex align-items-center" href="iniciarSesion.jsp" >
                    <i>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
                        <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
                        </svg>
                    </i>    
                    Iniciar sesión
                </a>

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
        <main style="margin-top:40px ">
            <section id="doctors" class=" container doctors">
                <div class="">
                    <div class="section-title">
                        <h2>Conócenos</h2>

                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <img src="assets/img/network-g42a41abda_1920.jpg"  width="100%" alt=""/>
                    </div>
                    <div class="col-6">
                        <p style="text-align: justify ">
                            Somos una organización sin fines de lucro que brinda tecnología, 
                        capacitación y educación a jóvenes necesitados. 
                        Nuestros objetivos se centran en disminuir la contaminación de residuos electrónicos y eléctricos a 
                        través de la recuperación oportuna de los aparatos tecnológicos, así como el reciclaje correcto de estos.
                        Además de brindar a los estudiantes la capacidad de elegir cuales son los recursos tenológicos que necesitan en
                        su desempeño academico o continuidad profesional.
                        <br/>
                        <br/>
                        Creemos en un mundo interconectado, en un México que sea capaz de visualizar un futuro junto con la ciencia, tecnología y progreso. En el que
                        la innovación tecnologica sea una constante en la vida de una comunidad.
                        </p>
                    </div>
                </div>
            </section>
            <section id="counts" class="vision-social">
                <div class="container">
                    <div class="section-title">
                        <h2>Una visión social para el mundo</h2>
                    </div>
                    <div class="row">
                        <div class="col-lg-4 col-md-8">
                            <div class="count-box">
                                <h4 class="section-title" >Negocio con propósito</h4>
                                <p>Concentramos nuestro día a día en ofrecer una 
                                    experiencia de usuario única a través de nuestros servicios y 
                                    tecnología en favor a esta iniciativa que esta mejorando y conectado
                                    cada vez más al mundo.<br/>
                                    Nuestra intención es llevar la tecnología a cada rincón de México.
                                    
                                </p>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-8">
                            <div class="count-box">
                                <h4 class="section-title">Altos estándares de transparencia</h4>
                                <p>Creemos en una economía donde la transparencia 
                                    y la honestidad nos fortalecen a todos.
                                    Por eso ponemos en alto la transparencia que 
                                    permite el modelo de crowdfunding.
                                </p>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-8">
                            <div class="count-box">
                                <h4 class="section-title">Solución directa</h4>
                                <p>Quien usa DonaMx concentra sus esfuerzos 
                                    en solucionar un problema de su entorno y 
                                    tiene la oportunidad de hacer un cambio directo 
                                    en su comunidad.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
          <!--  <section id="doctors" class="doctors">
                <div class="container">
                    <div class="section-title">
                        <h2>
                            Contacto principal
                        </h2>
                    </div>
                    <div class="row justify-content-center ">
                        <div class="col-auto col-lg-6">
                            <div class="member d-flex align-items-start">
                                <div class="pic"><img src="assets/img/team/team_6.png" class="img-fluid" alt=""></div>
                                <div class="member-info">
                                    <h4>Kevin Sanchez</h4>
                                    <span>Director del proyecto</span>
                                    <p>
                                        Estudiante de la carrera de Ingenieria en Sistemas Computacionales en el Instituto Tecnológico de Toluca
                                    </p>
                                    <div class="social">
                                        <a href="https://twitter.com/SKevin_Ivan/" target="_blank" rel="noopener noreferrer"><i class="ri-twitter-fill"></i></a>
                                        <a href="https://www.facebook.com/SKevinIvan/" target="_blank" rel="noopener noreferrer"><i class="ri-facebook-fill"></i></a>
                                        <a href="https://github.com/KevinSanchez-Cat/" target="_blank" rel="noopener noreferrer"><i class="ri-github-fill"></i></a>
                                        <a href="https://www.instagram.com/s.kevin_ivan/" target="_blank" rel="noopener noreferrer"><i class="ri-instagram-fill"></i></a>
                                        <a href="https://www.linkedin.com/in/kevin-ivan-sanchez-valdin-b82a15206/" target="_blank" rel="noopener noreferrer"> <i class="ri-linkedin-box-fill"></i> </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>-->
            <section id="contact" class="contact">
                <div class="container">

                    <div class="section-title">
                        <h2>Contacto</h2>
                        <p>Ponte en contacto con nosotros llenando el siguiente formulario, con gusto te atenderemos. </p>
                    </div>
                </div>
                <div class="container">
                    <div class="row mt-5">
                        <div class="col-lg-4">
                            <div class="info">
                                <div class="address">
                                    <i class="bi bi-geo-alt"></i>
                                    <h4>Domicilio:</h4>
                                    <p>Av. Tecnologico, Metepec, Estado de México. </p>
                                </div>
                                <div class="email">
                                    <i class="bi bi-envelope"></i>
                                    <h4>Correo electronico:</h4>
                                    <p>dona@donamx.com</p>
                                </div>
                                <div class="phone">
                                    <i class="bi bi-phone"></i>
                                    <h4>Llamanos:</h4>
                                    <p>+52 1022 23423 23</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-8 mt-5 mt-lg-0">
                            <form action="Srv_contacto" id="form-contacto" method="post"
                                  role="form" class="php-email-form">
                                <div class="row">
                                    <div class="col-md-6 form-group">
                                        <input type="text" name="name" class="form-control" id="name" placeholder="Tu nombre" required>
                                    </div>
                                    <div class="col-md-6 form-group mt-3 mt-md-0">
                                        <input type="email" class="form-control" name="email" id="email" placeholder="Tu correo electronico" required>
                                    </div>
                                </div>
                                <div class="form-group mt-3">
                                    <input type="text" class="form-control" name="subject" id="subject" placeholder="Asunto" required>
                                </div>
                                <div class="form-group mt-3">
                                    <textarea class="form-control" name="message" rows="5" placeholder="Mensaje" required></textarea>
                                </div>
                                <div class="my-3">
                                    <div class="loading">Cargando...</div>
                                    <div class="error-message"></div>
                                    <div class="sent-message">Tu mensaje se ha enviado. ¡Gracias!</div>
                                </div>
                                <div class="text-center"><button class="btn-primary" type="submit">Enviar mensaje</button></div>
                            </form>
                        </div>
                    </div>
                </div>
            </section>

        </main>
        <%@include  file="views/templates/footer/footer_principal.jsp" %>
        <div id="preloader"></div>
        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <!-- Vendor JS Files -->
        <script src="assets/vendor/purecounter/purecounter.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
        <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>
    </body>
</html>
