<%-- 
    Document   : index
    Created on : 11/04/2022, 01:34:08 AM
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
    </head>
    <body>
        <header id="header" class="fixed-top">
            <div class="container-fluid d-flex align-items-lg-start">
                <a href="index.jsp" class="logo me-auto"><img src="assets/img/imagenes/logotipodonamx_1.png" alt="" class="img-fluid"></a>
                <nav id="navbar" class="navbar order-last order-lg-0">
                    <ul>
                        <li>
                            <a class="nav-link scrollto active " href="index.jsp">
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
                                <i class="bi bi-heart">
                                </i>
                                Dona
                            </a>
                        </li>
                       
                        <li>
                            <a class="nav-link scrollto" href="conocenos.jsp">
                                <i class="bi bi-building">
                                </i>
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
                <a  class="appointment-btn scrollto d-flex align-items-center" href="registrarse.jsp" >
                    <i>
                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-person-circle" fill="currentColor"
                             xmlns="http://www.w3.org/2000/svg">
                        <path d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z" />
                        <path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
                        <path fill-rule="evenodd"
                              d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z" />
                        </svg>
                    </i>
                    Registrate
                </a>
            </div>
        </header>
        <section id="hero" class="d-flex align-items-center" style="margin-top:40px ">
            <div class="container">
                <h1>Bienvenid@  a  DonaMx</h1>
                <h2>Una oportunidad en tecnología para el talento mexicano</h2>
            </div>
        </section>
        <main id="main">
            <section id="why-us" class="why-us">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 d-flex align-items-stretch">
                            <div class="content">
                                <h3>¿Por qué donar?</h3>
                                <p>
                                    A través de una serie de estudios, 
                                    se ha demostrado que la pobreza límita los recursos 
                                    educativos disponibles y está directamente relacionada 
                                    con la integridad académica. Con los estudiantes más 
                                    vulnerables en mente, este proyecto busca ayudar a 
                                    avanzar a las personas que arriesgan su futuro para 
                                    mejorar su propia vida y la de su comunidad.
                                </p>
                                <div class="text-center">
                                    <a href="dona.jsp" class="more-btn">¿Contamos contigo? <i class="bx bx-chevron-right"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-8 d-flex align-items-stretch">
                            <div class="icon-boxes d-flex flex-column justify-content-center">
                                <div class="row">
                                    <div class="col-xl-4 d-flex align-items-stretch">
                                        <div class="icon-box mt-4 mt-xl-0">
                                            <i class="bx bx-user-pin"></i>
                                            <h4>Conviértete en voluntario</h4>
                                            <p>Unasé al grupo de agentes de cambio, 
                                                una red lo suficientemente fuerte como para impactar un 
                                                cambio positivo en la vida de los niños y jovenes. 
                                            </p>
                                            <div class="text-center">
                                                <a href="registrarse.jsp" class="more-btn"> Registrese ahora!</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xl-4 d-flex align-items-stretch">
                                        <div class="icon-box mt-4 mt-xl-0">
                                            <i class="bx bx-heart"></i>
                                            <h4>Una acción altruista</h4>
                                            <p>
                                                Su donación puede ayudar a lograrlo.
                                                Al mismo tiempo, usted otorgará a estos niños la esperanza 
                                                de un futuro más brillante.
                                            </p>
                                        </div>
                                    </div>
                                    <div class="col-xl-4 d-flex align-items-stretch">
                                        <div class="icon-box mt-4 mt-xl-0">
                                            <i class="bx bx-globe"></i>
                                            <h4>Brecha tecnologica</h4>
                                            <p>
                                                La tecnología ha evolucionado en todo el mundo y 
                                                la globalización ha animado a todos a aprender y
                                                desarrollar nuevas tecnologías de la información. 
                                                Es hora de que México reduzca esa brecha tecnológica 
                                                con el resto del mundo.
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section id="about" class="about">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-xl-5 col-lg-6 video-box d-flex justify-content-center align-items-stretch position-relative">
                            <a href="https://youtu.be/Y_A8fOufDKI" class="glightbox play-btn mb-4"></a>
                        </div>
                        <div class="col-xl-7 col-lg-6 icon-boxes d-flex flex-column align-items-stretch justify-content-center py-5 px-lg-5">
                            <h3>Recicla, Reusa, Dona</h3>
                            <p>En atención a la contaminación del medio ambiente por desechos electrónicos y eléctricos, 
                                se enfatizan 3 posibles soluciones, para reducir su impacto y así reducir la brecha tecnológica que existe en México.
                            </p>
                            <div class="icon-box">
                                <div class="icon"><i class="bx bx-recycle"></i></div>
                                <h4 class="title"><a href="">Recicla</a></h4>
                                <p class="description">Los desechos electrónicos y eléctricos causan una 
                                    contaminación severa tanto en el medio ambiente como en los seres vivos,
                                    un uso correcto del fin del ciclo de vida útil de un aparato electrónico puede evitar enfermedades.</p>
                            </div>
                            <div class="icon-box">
                                <div class="icon"><i class="bx bx-reset"></i></div>
                                <h4 class="title"><a href="">Reacondiciona</a></h4>
                                <p class="description">La idea es que hay ciertos aparatos que, aunque parezcan obsoletos, 
                                    se les puede alargar su vida útil añadiendo nuevas características o adaptándolos a las nuevas tecnologías.
                                </p>
                            </div>
                            <div class="icon-box">
                                <div class="icon"><i class="bx bx-devices"></i></div>
                                <h4 class="title"><a href="">Dona</a></h4>
                                <p class="description">Usted también puede donar un computador que ya no use,
                                    y nosotros prometemos que este equipo será adecuadamente seleccionado para 
                                    cumplir con la misión. Su colaboración será muy apreciada.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section id="counts" class="counts">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-md-6">
                            <div class="count-box">
                                <i class="fas fa-user-circle"></i>
                                <span data-purecounter-start="0" data-purecounter-end="20" data-purecounter-duration="1" class="purecounter"></span>
                                <p>Donadores</p>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-6 mt-5 mt-md-0">
                            <div class="count-box">
                                <i class="fas fa-desktop"></i>
                                <span data-purecounter-start="0" data-purecounter-end="100" data-purecounter-duration="1" class="purecounter"></span>
                                <p>Equipos computacionales</p>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-6 mt-5 mt-lg-0">
                            <div class="count-box">
                                <i class="fas fa-building"></i>
                                <span data-purecounter-start="0" data-purecounter-end="10" data-purecounter-duration="1" class="purecounter"></span>
                                <p>Talleres de reacondicionamiento</p>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-6 mt-5 mt-lg-0">
                            <div class="count-box">
                                <i class="fas fa-heart"></i>
                                <span data-purecounter-start="0" data-purecounter-end="50" data-purecounter-duration="1" class="purecounter"></span>
                                <p>Donaciones</p>
                            </div>
                        </div>

                    </div>

                </div>
            </section>
            <section id="services" class="services" >
                <div class="container">

                    <div class="section-title">
                        <h2>Dona tecnología</h2>
                        <p>¡Haga una donación para brindar a los niños y jóvenes mejores oportunidades!<br>
                            Este es el catálogo de recursos tecnológicos dispoibles para donar. Da clic sobre uno para ver los requerimientos mínimos.
                        </p>
                    </div>

                    <div class="row">
                        <div class="col-lg-4 col-md-6 align-items-stretch mt-4 mt-md-0" id="Cat01" data-bs-toggle="modal" data-bs-target="#modalComputadorasEscritorio">
                            <div class="icon-box">
                                <div class="icon"><i class="fas fa-laptop-house"></i></div>
                                <h4>Computadoras de escritorio</h4>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 align-items-stretch mt-4 mt-md-0" id="Cat02" data-bs-toggle="modal" data-bs-target="#modalComputadorasPortatiles">
                            <div class="icon-box">
                                <div class="icon"><i class="fas fa-laptop"></i></div>
                                <h4>Computadoras portátiles</h4>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 align-items-stretch mt-4 mt-lg-0" id="Cat03" data-bs-toggle="modal" data-bs-target="#modalTablets">
                            <div class="icon-box">
                                <div class="icon"><i class="fas fa-tablet-alt"></i></div>
                                <h4>Tablets</h4>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 align-items-stretch mt-4" id="Cat04" data-bs-toggle="modal" data-bs-target="#modalLicencias">
                            <div class="icon-box">
                                <div class="icon"><i class="fas fa-link"></i></div>
                                <h4>Licencias de software</h4>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 align-items-stretch mt-4" id="Cat05" data-bs-toggle="modal" data-bs-target="#modalImpresoras">
                            <div class="icon-box">
                                <div class="icon"><i class="fas fa-print"></i></div>
                                <h4>Impresoras</h4>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 align-items-stretch mt-4" id="Cat06" data-bs-toggle="modal" data-bs-target="#modalMonitores">
                            <div class="icon-box">
                                <div class="icon"><i class="fas fa-desktop"></i></div>
                                <h4>Monitores</h4>
                            </div>
                        </div>

                    </div>

                </div>
            </section>

            <section id="faq" class="faq section-bg">
                <div class="container">

                    <div class="section-title">
                        <h2>Preguntas frecuentes</h2>
                        <p></p>
                    </div>

                    <div class="faq-list">
                        <ul>
                            <li data-aos="fade-up" data-aos-delay="100">
                                <i class="bx bx-help-circle icon-help"></i> 
                                <a data-bs-toggle="collapse" class="collapsed" data-bs-target="#faq-list-1">
                                    ¿Puedo donar una computadora usada?
                                    <i class="bx bx-chevron-down icon-show"></i>
                                    <i class="bx bx-chevron-up icon-close"></i>
                                </a>
                                <div id="faq-list-1" class="collapse" data-bs-parent=".faq-list">
                                    <p>
                                        Totalmente, gracias a nuestro control de calidad, toda computadora es sometida a una inspección 
                                        cuidadosa para validar su condición, de seminueva, usada u obsoleta, con el fin de que el usuario 
                                        beneficiado tenga todas las posibilidades de usarla sin complicación alguna. 
                                        Por ello se accede a reacondicionar si hace falta, o reciclarla.
                                    </p>
                                </div>
                            </li>

                            <li data-aos="fade-up" data-aos-delay="100">
                                <i class="bx bx-help-circle icon-help"></i> 
                                <a data-bs-toggle="collapse" data-bs-target="#faq-list-2" class="collapsed">
                                    ¿Cuentan con registro deducible de impuestos? 
                                    <i class="bx bx-chevron-down icon-show"></i>
                                    <i class="bx bx-chevron-up icon-close"></i>
                                </a>
                                <div id="faq-list-2" class="collapse" data-bs-parent=".faq-list">
                                    <p>
                                        Por supuesto!, Una de la gran ventaja de donar es la deducción de impuestos por donación.
                                        Las donaciones en especie como los equipos computacionales, 
                                        tabletas, celulares cuentan como donaciones, y son deducibles solo con el valor estimado.
                                        Acercate con nosotros, con gusto te atenderemos.
                                    </p>
                                </div>
                            </li>

                            <li data-aos="fade-up" data-aos-delay="200">
                                <i class="bx bx-help-circle icon-help"></i> 
                                <a data-bs-toggle="collapse" data-bs-target="#faq-list-3" class="collapsed">
                                    Tengo una computadora que ya no uso, pero esta casi obsoleta. ¿La puedo donar?
                                    <i class="bx bx-chevron-down icon-show"></i>
                                    <i class="bx bx-chevron-up icon-close"></i>
                                </a>
                                <div id="faq-list-3" class="collapse" data-bs-parent=".faq-list">
                                    <p>
                                        Nosotros la recibimos y verificamos el estado de la computadora, si ya no tiene reparación se
                                        envía a uno de nuestros centros de reciclaje, o si hay alguna pieza recuperable se almacena para un
                                        posterior uso.
                                    </p>
                                </div>
                            </li>

                            <li data-aos="fade-up" data-aos-delay="300">
                                <i class="bx bx-help-circle icon-help"></i> 
                                <a data-bs-toggle="collapse" data-bs-target="#faq-list-4" class="collapsed">
                                    ¿Hay que pagar el envio de la donación?
                                    <i class="bx bx-chevron-down icon-show"></i>
                                    <i class="bx bx-chevron-up icon-close"></i>
                                </a>
                                <div id="faq-list-4" class="collapse" data-bs-parent=".faq-list">
                                    <p>
                                        Solo hay que pagar una pequeña cuota que dependerá de la distancia del lugar en donde se recoga y se envié.
                                    </p>
                                </div>
                            </li>
                            <li data-aos="fade-up" data-aos-delay="300">
                                <i class="bx bx-help-circle icon-help"></i> 
                                <a data-bs-toggle="collapse" data-bs-target="#faq-list-5" class="collapsed">
                                    ¿Cuál es el rango de edad para recibir una donación?
                                    <i class="bx bx-chevron-down icon-show"></i>
                                    <i class="bx bx-chevron-up icon-close"></i>
                                </a>
                                <div id="faq-list-5" class="collapse" data-bs-parent=".faq-list">
                                    <p>
                                        La plataforma esta enfocada en atender a estudiantes de 10 a 23 años.
                                    </p>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </section>
            <section id="testimonials" class="testimonials">
                <div class="container">
                    <div class="section-title">
                        <h2>Comentarios valiosos</h2>
                        <p>Sabemos cuan es importante su experiencia del proyecto, por eso la compartimos al mundo. ¡Gracias por confiar en nosotros!</p>
                    </div>
                    <div class="testimonials-slider swiper" data-aos="fade-up" data-aos-delay="100">
                        <div class="swiper-wrapper">
                            <div class="swiper-slide">
                                <div class="testimonial-wrap">
                                    <div class="testimonial-item">
                                        <img src="assets/img/testimonials/persona1.jpg" class="testimonial-img" alt="">
                                        <h3>Anayelly Contreras</h3>
                                        <h4>Estudiante</h4>
                                        <p>
                                            <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                                            Adentrarse al mundo de la tecnologia siempre fue un lugar desconocido, hasta que me regalarón una computadora. 
                                            Me ayudo bastante en mis estudios, ahora tengo un equipo con el que puedo estudiar. Gracias!
                                            <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div class="swiper-slide">
                                <div class="testimonial-wrap">
                                    <div class="testimonial-item">
                                        <img src="assets/img/testimonials/persona2.jpg" class="testimonial-img" alt="">
                                        <h3>Cristian Velez</h3>
                                        <h4>Estudiante</h4>
                                        <p>
                                            <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                                            No puedo expresar la emoción que sentí cuando recibi mi primer computador!, una maravilla...
                                            <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div class="swiper-slide">
                                <div class="testimonial-wrap">
                                    <div class="testimonial-item">
                                        <img src="assets/img/testimonials/persona3.jpg" class="testimonial-img" alt="">
                                        <h3>Giselle Quesada</h3>
                                        <h4>Docente</h4>
                                        <p>
                                            <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                                            Me parece que es una excelente iniciativa para promover el interes en la ciencia y tecnología.
                                            <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div class="swiper-slide">
                                <div class="testimonial-wrap">
                                    <div class="testimonial-item">
                                        <img src="assets/img/testimonials/persona4.jpg" class="testimonial-img" alt="">
                                        <h3>Vero Rivera</h3>
                                        <h4>Voluntario</h4>
                                        <p>
                                            <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                                            Estoy encantado de poder ayudar a más jovenes, me ayuda a pensar que puede haber un
                                            talento escondido en cada entrega.
                                            <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div class="swiper-slide">
                                <div class="testimonial-wrap">
                                    <div class="testimonial-item">
                                        <img src="assets/img/testimonials/testimonials-5.jpg" class="testimonial-img" alt="">
                                        <h3>Juan Contreras</h3>
                                        <h4>Donador civil</h4>
                                        <p>
                                            <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                                            Tenía una computadora casi nueva que ya no ocupaba, ahora 
                                            sé que alguien más la esta ocupando,  solo espero que la este aprovechando tanto como
                                            yo...
                                            <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="swiper-pagination"></div>
                    </div>

                </div>
            </section>
            <section id="gallery" class="gallery section-bg">
                <div class="container">

                    <div class="section-title">
                        <h2>Galeria</h2>
                        <p>Conoce nuestra galería, donde encontrarás algunas fotos de sorpresa de los beneficiarios.</p>
                    </div>
                </div>

                <div class="container-fluid">
                    <div class="row g-0">

                        <div class="col-lg-3 col-md-4">
                            <div class="gallery-item">
                                <a href="assets/img/gallery/galeria_1.jpg" class="galelry-lightbox">
                                    <img src="assets/img/gallery/galeria_1.jpg" alt="" class="img-fluid">
                                </a>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-4">
                            <div class="gallery-item">
                                <a href="assets/img/gallery/galeria_2.jpg" class="galelry-lightbox">
                                    <img src="assets/img/gallery/galeria_2.jpg" alt="" class="img-fluid">
                                </a>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-4">
                            <div class="gallery-item">
                                <a href="assets/img/gallery/galeria_3.jpg" class="galelry-lightbox">
                                    <img src="assets/img/gallery/galeria_3.jpg" alt="" class="img-fluid">
                                </a>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-4">
                            <div class="gallery-item">
                                <a href="assets/img/gallery/galeria_4.jpg" class="galelry-lightbox">
                                    <img src="assets/img/gallery/galeria_4.jpg" alt="" class="img-fluid">
                                </a>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-4">
                            <div class="gallery-item">
                                <a href="assets/img/gallery/galeria_5.jpg" class="galelry-lightbox">
                                    <img src="assets/img/gallery/galeria_5.jpg" alt="" class="img-fluid">
                                </a>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-4">
                            <div class="gallery-item">
                                <a href="assets/img/gallery/galeria_6.jpg" class="galelry-lightbox">
                                    <img src="assets/img/gallery/galeria_6.jpg" alt="" class="img-fluid">
                                </a>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-4">
                            <div class="gallery-item">
                                <a href="assets/img/gallery/galeria_7.jpg" class="galelry-lightbox">
                                    <img src="assets/img/gallery/galeria_7.jpg" alt="" class="img-fluid">
                                </a>
                            </div>
                        </div>

                        <div class="col-lg-3 col-md-4">
                            <div class="gallery-item">
                                <a href="assets/img/gallery/galeria_8.jpg" class="galelry-lightbox">
                                    <img src="assets/img/gallery/galeria_8.jpg" alt="" class="img-fluid">
                                </a>
                            </div>
                        </div>

                    </div>

                </div>
            </section>
            <div class="modal fade" id="modalComputadorasEscritorio">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Requisitos mínimos para computadoras de escritorio</h4>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>
                        <div class="modal-body">
                            <ul>
                                <li>Procesador: Intel Core Duo o superior, AMD </li>
                            <li>Memoria RAM: 2GB</li>
                            <li>Disco duro: 160GB </li>
                            <li>Multimedia: DVD-ROM o DVD-RW o superior </li>
                            <li>Entradas para USB, VGA o HDMI </li>
                            <li>(Recomendable)Entrada para Mouse, Teclado, audifonos y bocinas</li>
                            <li>Red: Tarjeta de red 10/100 ó tarjeta inalámbrica de 54 Mbps</li>   
                            </ul>
                            
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="modalComputadorasPortatiles">
                <div class="modal-dialog modal-dialog-centered ">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Requisitos mínimos para computadoras portátiles</h4>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>
                        <div class="modal-body">
                            <ul>
                                <li>Procesador: Intel Core 2 duo o superior, o sus equivalentes en otras tecnologías</li>
                            <li>Memoria RAM: 4 GB</li>
                            <li>Disco duro: 160 GB</li>
                            <li>Fuente de energía: Cargador y bateria funcional</li>
                            </ul>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="modalImpresoras">
                <div class="modal-dialog modal-dialog-centered ">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Requisitos mínimos para impresoras</h4>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>
                        <div class="modal-body">
                            <ul>
                                <li>
                                    Chorros de tinta
                                </li>
                                <li>
                                   Sencilla (Solo para imprimir) 
                                </li>
                            </ul>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="modalMonitores">
                <div class="modal-dialog modal-dialog-centered ">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Requisitos mínimos para monitores</h4>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>
                        <div class="modal-body">
                            <ul>
                                <li>
                                    Tamaño: 14 o 15 pulgadas
                                </li>
                                <li>
                                    Resolución: 1024 x 768 pixeles
                                </li>
                                <li>
                                    De LED o LCD
                                </li>
                                <li>
                                    Conectividad: VGA, HDMI
                                </li>
                            </ul>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="modalLicencias">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Requisitos mínimos para licencias de software</h4>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>
                        <div class="modal-body">
                            <ul>
                                <li> Licencias válidas</li>
                                <li>Duración por 6 meis meses</li>
                            </ul>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="modalTablets">
                <div class="modal-dialog modal-dialog-centered ">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Requisitos para tablets</h4>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>
                        <div class="modal-body">
                            <ul>
                                <li>
                                   Tamaño de pantalla: 10 pulgadas o más  
                                </li>
                                <li>
                                     Pantalla: HD, HD+ o superiores
                                </li>
                                <li>
                                     Almacenamiento: 64GB
                                </li>
                                <li>
                                    Memoria RAM: 3GB
                                </li>
                                <li>
                                    Conectividad: Wifi, Bluetooth, USB
                                </li>
                                <li>
                                    Bateria: 7.000 mAh
                                </li>
                            </ul>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div>
            <%@include  file="views/templates/footer/footer_principal.jsp" %>

            <div id="preloader"></div>
            <a href="#" class="back-to-top d-flex align-items-center justify-content-center">
                <i class="bi bi-arrow-up-short"></i>
            </a>

            <!-- Vendor JS Files -->
            <script src="assets/vendor/purecounter/purecounter.js"></script>
            <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
            <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
            <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>

            <!-- Template Main JS File -->
            <script src="assets/js/main.js"></script>

    </body>
</html>
