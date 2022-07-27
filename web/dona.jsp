<%-- 
    Document   : dona
    Created on : 14/04/2022, 01:52:06 AM
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
                            <a class="nav-link scrollto " href="index.jsp">
                                <i class="bi bi-house-door">
                                </i>Inicio
                            </a>
                        </li>
                        <li><a class="nav-link scrollto active" href="dona.jsp">
                                <i class="bi bi-heart">
                                </i>
                                ¡Dona!
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
            <section id="services" class="services" >
                <div class="container">

                    <div class="section-title">
                        <h2>Dona un equipo computacional</h2>

                    </div>
                    <div class="row">
                        <div class="col-6">
                            <img src="assets/img/device-gd99aae8f7_1280.jpg"  width="90%" alt=""/>
                        </div>
                        <div class="col-6">
                            <p style="text-align: justify ">
                                ¡Hoy es un buen día para hacer el bien! 
                                Tu donación ayudará a equipar a los niños y 
                                adolescentes necesitados con los recursos tecnológicos 
                                que difícilmente pueden abordar con su presupuesto límitado. 
                                A través de nuestra campaña de recolección de equipos, podemos 
                                brindarles nuevas oportunidades educativas, la promesa de un futuro mejor. 
                                <br/><br/>
                                Para donar un equipo computacional, o cualquier otro recurso, primero hay que registrarse en la plataforma, 
                                elegir la opción de Donar, en seguida registrar el recurso en la plataforma como nuevo así como ingresar las 
                                características además de escoger una de las dos modalidades de 
                                donación: Convocatoria, o por Solicitud. En la plataforma se le indica en que consiste cada una.
                                Una vez validada la donación, se autoriza la publicación en la plataforma.
                                Nosotros gestionaremos el envió y entrega de la donación.
                                
                            </p>
                        </div>

                    </div>
                </div>
            </section>
            <section id="departments" class="departments">
                <div class="container">

                    <div class="section-title">
                        <h2>Dona un equipo computacional usado</h2>
                        <p>Las donaciones de equipos computacionales usados son las más preciadas, ¡Ayudas a todos! A un estudiante, al medio ambiente y
                            a ti. Es una acción de altruismo pero también de consientización por la disminución de la basura e impacto en la salud.
                            <br/>
                            Todo los aparatos tecnologícos se reciben en DonaMx, ¿Cómo identificarlos? Aquí te decimos cómo... 
                        </p>
                    </div>
                    <br>
                    <div class="row gy-4">
                        <div class="col-lg-3">
                            <ul class="nav nav-tabs flex-column">
                                <li class="nav-item">
                                    <a class="nav-link active show" data-bs-toggle="tab" href="#tab-1">Busca un aparato electrónico</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-bs-toggle="tab" href="#tab-2">Revisa sus condiciones</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-bs-toggle="tab" href="#tab-3">Registralo en la plataforma DonaMx</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-bs-toggle="tab" href="#tab-4">Entregalo al personal indicado</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-bs-toggle="tab" href="#tab-5">Dónalo</a>
                                </li>
                            </ul>
                        </div>
                        <div class="col-lg-9">
                            <div class="tab-content">
                                <div class="tab-pane active show" id="tab-1">
                                    <div class="row gy-4">
                                        <div class="col-lg-8 details order-2 order-lg-1">
                                            <h3>Busca un aparato electrónico que ya no uses</h3>
                                            <p class="fst-italic"></p>
                                            <p>
                                                Un aparato electronico, puede ser una computadora personal, computadora de escritorio,
                                                una impresora, cámara fotográfica, celular, teclado, mouse, monitores, tabletas electronicas, bocinas.
                                                <br/>
                                                Seguramente tienes una computadora que ya usaste porque te compraste una nueva,
                                                pero que aun sirve. Tómala y revisa sus condiciones físicas. 
                                                Si esta en buenas condiciones, la puedes registrar para una donación.
                                                Si no lo esta, la puedes registrar para el proceso de reciclaje.
                                            </p>
                                        </div>
                                        <div class="col-lg-4 text-center order-1 order-lg-2">
                                            <img src="assets/img/gallery/galeria_1.jpg" alt="" class="img-fluid">
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="tab-2">
                                    <div class="row gy-4">
                                        <div class="col-lg-8 details order-2 order-lg-1">
                                            <h3>Revisa sus condiciones</h3>
                                            <p class="fst-italic"></p>
                                            <p>
                                                Una vez que decidiste donarla, revisa por segunda vez si funciona.
                                                Revisa si tiene un golpe, rasguño, en el caso de una computadora revisa si le falta una tecla o el mouse,
                                                anota todos sus detalles físicos.
                                                Revisa si prende y se visualiza su sistema operativo.
                                                Si encendió, procede a recurperar toda tu información personal y después borrarla definitivamente 
                                                del equipo.<br/>
                                                Si no, trata de recuperar tu disco duro del equipo computacional. En este punto, 
                                                puedes decidir si conservar tu disco duro como unidad de almacenamiento exterior
                                                o mandarlo a reciclar.
                                            </p>
                                        </div>
                                        <div class="col-lg-4 text-center order-1 order-lg-2">
                                            <img src="assets/img/gallery/galeria_2.jpg" alt="" class="img-fluid">
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="tab-3">
                                    <div class="row gy-4">
                                        <div class="col-lg-8 details order-2 order-lg-1">
                                            <h3>Registra el aparato en la plataforma</h3>
                                            <p class="fst-italic"></p>
                                            <p>
                                                Una vez revisado, ingresa a la plataforma, registrate como donador, y registra el equipo computacional, 
                                                escribe detalles de la condición física y lógica. 
                                                Selecciona si la vas a donar o reciclar.
                                                Nosotros nos encargaremos de evaluarlo y tomar una desición, 
                                                si se reacondiciona para una donación o si se envia a uno
                                                de nuestros centros de reciclaje.
                                            </p>
                                        </div>
                                        <div class="col-lg-4 text-center order-1 order-lg-2">
                                            <img src="assets/img/gallery/galeria_3.jpg" alt="" class="img-fluid">
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="tab-4">
                                    <div class="row gy-4">
                                        <div class="col-lg-8 details order-2 order-lg-1">
                                            <h3>Entregalo al personal indicado</h3>
                                            <p class="fst-italic"></p>
                                            <p>
                                                Una vez que se registre, se te informará sobre el proceso de entrega, por ejemplo,
                                                llegará a tu puerta de tu casa el personal que recogerá el equipo, también esta la 
                                                posibilidad de dejarlo en uno de los centros de acopio registrados en la plataforma, o enviarlo por 
                                                paqueteria a una de nuestras oficinas.
                                            </p>
                                        </div>
                                        <div class="col-lg-4 text-center order-1 order-lg-2">
                                            <img src="assets/img/gallery/galeria_4.jpg" alt="" class="img-fluid">
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="tab-5">
                                    <div class="row gy-4">
                                        <div class="col-lg-8 details order-2 order-lg-1">
                                            <h3>Dónalo</h3>
                                            <p class="fst-italic"></p>
                                            <p>
                                                Una vez que lo entregaste, se enviará una confirmación de entrega.
                                                ¡Te avisaremos cuando el equipo sea donado!
                                            </p>
                                        </div>
                                        <div class="col-lg-4 text-center order-1 order-lg-2">
                                            <img src="assets/img/gallery/galeria_5.jpg" alt="" class="img-fluid">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section class="container">
                <div class="section-title">
                    <h2>  ¿Cuáles son los beneficios para los donadores?</h2>
                    
                </div>
                 <div class="row">
                        <div class="col-6">
                            <img src="assets/img/laptop-g9057edf24_1280.png"  width="90%" alt=""/>
                        </div>
                     <div class="col-6">
                         <p >
                    <ul style="text-align: justify">
                        <li>
                            Un reconocimiento y certificado de donación del equipo computacional.
                        </li>
                        <li>
                            Reconocimiento público a través de nuestras redes sociales. 
                        </li>
                        <li>
                            Uso del nombre y logo de la empresa o nombre y foto de la persona en nuestro sitio web.
                        </li>
                        <li>
                            Evitar impactos ambientales negativos por cuenta de la disposición inadecuada de desechos
                            tecnológicos y la contaminación con residuos peligrosos.
                        </li>
                        <li>
                            Contribuir a la formación de niños y jóvenes mejor capacitados y más competitivos, 
                            que en un futuro será el motor del desarrollo empresarial del país.
                        </li>
                    </ul>
                    </p>
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
