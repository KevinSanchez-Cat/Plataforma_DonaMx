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
                                Dona
                            </a>
                        </li>
                        <li>
                            <a class="nav-link scrollto" href="comoFunciona.jsp"> 
                                <i>
                                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-grid-3x3-gap"
                                         fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd"
                                          d="M4 2H2v2h2V2zm1 12v-2a1 1 0 0 0-1-1H2a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1zm0-5V7a1 1 0 0 0-1-1H2a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1zm0-5V2a1 1 0 0 0-1-1H2a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1zm5 10v-2a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1zm0-5V7a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1zm0-5V2a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1zM9 2H7v2h2V2zm5 0h-2v2h2V2zM4 7H2v2h2V7zm5 0H7v2h2V7zm5 0h-2v2h2V7zM4 12H2v2h2v-2zm5 0H7v2h2v-2zm5 0h-2v2h2v-2zM12 1a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1h-2zm-1 6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1V7zm1 4a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1h-2z" />
                                    </svg>
                                </i>
                                ¿Cómo funciona?
                            </a>
                        </li>
                        <li>
                            <a class="nav-link scrollto active" href="conocenos.jsp">
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
                        <li>
                            <a class="nav-link scrollto" href="contacto.jsp">
                                <i>
                                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-building"
                                         fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd"
                                          d="M14.763.075A.5.5 0 0 1 15 .5v15a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5V14h-1v1.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V10a.5.5 0 0 1 .342-.474L6 7.64V4.5a.5.5 0 0 1 .276-.447l8-4a.5.5 0 0 1 .487.022zM6 8.694L1 10.36V15h5V8.694zM7 15h2v-1.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 .5.5V15h2V1.309l-7 3.5V15z" />
                                    <path d="M2 11h1v1H2v-1zm2 0h1v1H4v-1zm-2 2h1v1H2v-1zm2 0h1v1H4v-1zm4-4h1v1H8V9zm2 0h1v1h-1V9zm-2 2h1v1H8v-1zm2 0h1v1h-1v-1zm2-2h1v1h-1V9zm0 2h1v1h-1v-1zM8 7h1v1H8V7zm2 0h1v1h-1V7zm2 0h1v1h-1V7zM8 5h1v1H8V5zm2 0h1v1h-1V5zm2 0h1v1h-1V5zm0-2h1v1h-1V3z" />
                                    </svg>
                                </i>
                                Contacto
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
            <!-- ======= Doctors Section ======= -->
            <section id="doctors" class="doctors">
                <div class="container">
                    <div class="section-title">
                        <h2>Conócenos</h2>

                    </div>
                    <p>Somos una organización sin fines de lucro que brinda tecnología, 
                        capacitación y educación a jóvenes necesitados. Su donación ayudará 
                        a equipar a los niños y adultos jóvenes con los recursos que necesitan 
                        para tener éxito, al tiempo que ofrece la promesa de un futuro mejor. 
                        Al mismo tiempo que está ayudando, también podrá aprovechar nuestras 
                        desgravaciones fiscales para las donaciones que pueda recibir.
                    </p>
                    <!-- ======= Counts Section ======= -->
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
                                            experiencia de usuario única a través de nuestro servicio de asesoría y 
                                            tecnología en favor a esta iniciativa que esta mejorando y conectado
                                            cada vez más al mundo.
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
                                        <h4 class="section-title">Solucion directa</h4>
                                        <p>Quien usa DonaMx concentra sus esfuerzos 
                                            en solucionar un problema de su entorno y 
                                            tiene la oportunidad de hacer un cambio directo 
                                            en su comunidad.
                                        </p>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </section><!-- End Counts Section -->
                    <br>
                    <div class="badge-base LI-profile-badge" data-locale="es_ES" data-size="medium" 
                         data-theme="light" data-type="VERTICAL" data-vanity="kevin-ivan-sanchez-valdin-b82a15206" 
                         data-version="v1"><a class="badge-base__link LI-simple-link"
                                         href="https://mx.linkedin.com/in/kevin-ivan-sanchez-valdin-b82a15206?trk=profile-badge">
                          </a></div>

                    <!--<section id="doctors" class="doctors">
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
                                            <span>Freelance Analista de sistemas</span>
                                            <p>
                                                Estudiante de la carrera de Ingenieria en Sistemas Computacionales
                                            </p>
                                            <div class="social">
                                                <a href="https://twitter.com/SKevin_Ivan" target="_blank" rel="noopener noreferrer"><i class="ri-twitter-fill"></i></a>
                                                <a href="https://www.facebook.com/SKevinIvan/" target="_blank" rel="noopener noreferrer"><i class="ri-facebook-fill"></i></a>
                                                <a href="https://github.com/KevinSanchez-Cat" target="_blank" rel="noopener noreferrer"><i class="ri-github-fill"></i></a>
                                                <a href="https://l.facebook.com/l.php?u=https%3A%2F%2Fwww.instagram.com%2FS.Kevin_ivan%3Ffbclid%3DIwAR0MrrMkItZyYCtxMxNei5O3cNk1JSYuToQrieuBkzApvJLdMlrGY7uo4wQ&h=AT1-4I12f0Xr_gMslP6xRqlGGZS6Fgg_FxoI2RShw-QSoPH2chFlMLpV359sXYebSao6WWE-AwmnwkADDP8TGRIB1xMYthTuzLl5qoG8K9OvII2WBUBWgGTavAbHKjVq4cQy" target="_blank" rel="noopener noreferrer"><i class="ri-instagram-fill"></i></a>
                                                <a href="https://www.linkedin.com/in/kevin-ivan-sanchez-valdin-b82a15206/" target="_blank" rel="noopener noreferrer"> <i class="ri-linkedin-box-fill"></i> </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>--!>

                    <!--
                    <div class="col-lg-6 mt-4 mt-lg-0">
                        <div class="member d-flex align-items-start">
                            <div class="pic"><img src="assets/img/team/team_5.jpg" class="img-fluid" alt=""></div>
                            <div class="member-info">
                                <h4>Lizeth Villana</h4>
                                <span>Gerente de entrega</span>
                                <p></p>
                                <div class="social">
                                    <a href=""><i class="ri-twitter-fill"></i></a>
                                    <a href=""><i class="ri-facebook-fill"></i></a>
                                    <a href=""><i class="ri-instagram-fill"></i></a>
                                    <a href=""> <i class="ri-linkedin-box-fill"></i> </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 mt-4">
                        <div class="member d-flex align-items-start">
                            <div class="pic"><img src="assets/img/team/team_4.jpg" class="img-fluid" alt=""></div>
                            <div class="member-info">
                                <h4>Hugo De la O</h4>
                                <span>Controlador de calidad</span>
                                <p></p>
                                <div class="social">
                                    <a href=""><i class="ri-twitter-fill"></i></a>
                                    <a href=""><i class="ri-facebook-fill"></i></a>
                                    <a href=""><i class="ri-instagram-fill"></i></a>
                                    <a href=""> <i class="ri-linkedin-box-fill"></i> </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 mt-4">
                        <div class="member d-flex align-items-start">
                            <div class="pic"><img src="assets/img/team/team_1.jpg" class="img-fluid" alt=""></div>
                            <div class="member-info">
                                <h4>Gabriela Jimenez</h4>
                                <span>Asistente de programa</span>
                                <p></p>
                                <div class="social">
                                    <a href=""><i class="ri-twitter-fill"></i></a>
                                    <a href=""><i class="ri-facebook-fill"></i></a>
                                    <a href=""><i class="ri-instagram-fill"></i></a>
                                    <a href=""> <i class="ri-linkedin-box-fill"></i> </a>
                                </div>
                            </div>
                        </div>
                    </div>-->

                </div>
            </section><!-- End Doctors Section -->
        </main>
        <%@include  file="views/templates/footer/footer_principal.jsp" %>
        <div id="preloader"></div>
        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <!-- Vendor JS Files -->
        <script src="assets/vendor/purecounter/purecounter.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
        <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>
        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>
    </body>
</html>
