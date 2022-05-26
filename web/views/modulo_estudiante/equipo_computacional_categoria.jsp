

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta charset="utf-8"/>
        <meta content="width=device-width, initial-scale=1.0" name="viewport"/>

        <title>Equipo de computo</title>
        <meta content="Plataforma dedicada a unir a fundaciones y estudiantes para donaciones
              de tipo tecnologico, de manera en que los estudiantes de escasos recursos 
              logren continuar con sus estudios, además de ser un lugar en donde se pueda conseguir 
              apoyo o subsidios de productos en materia de tecnologia" name="description"/>
        <meta content="tecnologia, computadoras, licencias, donaciones, estudiantes, educiacion, progreso" name="keywords"/>

        <link href="assets/img/imagenes/Logo_1.png" rel="icon"/>
        <link href="assets/img/imagenes/Logo_1.png" rel="apple-touch-icon"/>

        <link href="https://fonts.gstatic.com" rel="preconnect"/>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet"/>

        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet"/>
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet"/>
        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet"/>
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet"/>
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet"/>
        <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet"/>
        <!-- Template Main CSS File -->
        <link href="assets/css/style_panel_admin.css" rel="stylesheet"/>

    </head>
    <body>

        <%
            //HttpSession session2 = request.getSession(false);
            java.util.List<model.Deseo> lstDeseos = new java.util.ArrayList<>();

            java.util.List<model.Donacion> lstDonaciones = (java.util.List<model.Donacion>) request.getAttribute("lstDonaciones");
            model.Estudiante estudiante = (model.Estudiante) session.getAttribute("estudiante");
            java.util.List<model.Notificacion> lstNotificaciones2 = (java.util.ArrayList<model.Notificacion>) request.getAttribute("lstNotificaciones");

            if (estudiante != null) {
                lstDeseos = (java.util.List<model.Deseo>) request.getAttribute("lstDeseos");
            }
            int numDeseos = lstDeseos.size();
            int numDonaciones = lstDonaciones.size();
            int numNotificaciones = lstNotificaciones2.size();
            model.Usuario usuario = (model.Usuario) session.getAttribute("user");
        %>
        <header id="header" class="header fixed-top d-flex align-items-center">
            <div class="d-flex align-items-center justify-content-between">
                <a href="estudiante" class="logo d-flex align-items-center">
                    <img src="assets/img/imagenes/Logo_1.png" alt="">
                        <span class="d-none d-lg-block">DonaMx</span>
                </a>
                <i class="bi bi-list toggle-sidebar-btn"></i>
            </div>
            <nav class="header-nav ms-auto">
                <ul class="d-flex align-items-center">

                    <li class="nav-item dropdown">
                        <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                            <i>
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" style="fill: #6c757d;transform: scaleX(-1);msFilter:progid:DXImageTransform.Microsoft.BasicImage(rotation=0, mirror=1);"><path d="M16 15a1 1 0 0 0-1-1H9c-.551 0-1 .448-1 1v2h8v-2zm-8 4h8v3H8z"></path><path d="M21 12c0-2.967-2.167-5.432-5-5.91V5c0-1.654-1.346-3-3-3h-2C9.346 2 8 3.346 8 5v1.09C5.167 6.568 3 9.033 3 12v8c0 1.103.897 2 2 2h1v-7c0-1.654 1.346-3 3-3h6c1.654 0 3 1.346 3 3v7h1c1.103 0 2-.897 2-2v-8zM10 5c0-.552.449-1 1-1h2a1 1 0 0 1 1 1v1h-4V5z"></path></svg>
                            </i>
                            <span class="badge bg-success rounded-pill badge-number"><%= numDonaciones%></span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
                            <li class="dropdown-header">
                                Tienes  <%= numDonaciones%> donaciones
                                <a href="estudiante?page=mi_mochila"><span class="badge rounded-pill bg-success p-2 ms-2">Ver todas</span></a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                            <i >
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" style="fill: #6c757d;transform: scaleX(-1);msFilter:progid:DXImageTransform.Microsoft.BasicImage(rotation=0, mirror=1);"><path d="M20.205 4.791a5.938 5.938 0 0 0-4.209-1.754A5.906 5.906 0 0 0 12 4.595a5.904 5.904 0 0 0-3.996-1.558 5.942 5.942 0 0 0-4.213 1.758c-2.353 2.363-2.352 6.059.002 8.412L12 21.414l8.207-8.207c2.354-2.353 2.355-6.049-.002-8.416z"></path></svg>
                            </i>
                            <span class="badge bg-danger rounded-pill badge-number"><%= numDeseos%></span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
                            <li class="dropdown-header">Tienes <%= numDeseos%> deseos
                                <a href="estudiante?page=deseos"><span class="badge rounded-pill bg-danger p-2 ms-2">Ver todas</span></a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                            <i>
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" style="fill: #6c757d;transform: scaleX(-1);msFilter:progid:DXImageTransform.Microsoft.BasicImage(rotation=0, mirror=1);"><path d="M12 22a2.98 2.98 0 0 0 2.818-2H9.182A2.98 2.98 0 0 0 12 22zm7-7.414V10c0-3.217-2.185-5.927-5.145-6.742C13.562 2.52 12.846 2 12 2s-1.562.52-1.855 1.258C7.185 4.074 5 6.783 5 10v4.586l-1.707 1.707A.996.996 0 0 0 3 17v1a1 1 0 0 0 1 1h16a1 1 0 0 0 1-1v-1a.996.996 0 0 0-.293-.707L19 14.586z"></path></svg>
                            </i>
                            <span class="badge bg-primary rounded-pill badge-number"><%= numNotificaciones%></span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
                            <li class="dropdown-header">
                                Tienes  <%= numNotificaciones%> notificaciones
                                <a href="estudiante?page=notificaciones"><span class="badge rounded-pill bg-primary p-2 ms-2">Ver todas</span></a>
                            </li>

                            <c:forEach var="notificacion" items="${lstNotificaciones}">
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li class="notification-item">
                                    <i class="bi bi-info-circle text-primary"></i>
                                    <div>
                                        <h4> </h4>
                                        <p>${notificacion.mensaje}</p>
                                        <p>${notificacion.fechaNotificacion}</p>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                    <li class="nav-item dropdown pe-3">

                        <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                            <img src="assets/img/user_default.png" alt="Profile" width="50%" class="rounded-circle">
                                <span class="d-none d-md-block dropdown-toggle ps-2">  <%= session.getAttribute("username")%></span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                            <li class="dropdown-header">
                                <h6><%= session.getAttribute("username")%> </h6>
                                <span><%= session.getAttribute("rol")%></span>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li>
                                <a class="dropdown-item d-flex align-items-center" href="estudiante?page=perfil">
                                    <i class="bi bi-person"></i>
                                    <span>Mi perfil</span>
                                </a>
                            </li>

                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li>
                                <a class="dropdown-item d-flex align-items-center" href="estudiante?page=cerrar_sesion">
                                    <i class="bi bi-box-arrow-right"></i>
                                    <span>Cerrar sessión</span>
                                </a>
                            </li>

                        </ul>
                    </li>
                </ul>
            </nav>
        </header>
        <aside id="sidebar" class="sidebar">
            <ul class="sidebar-nav" id="sidebar-nav">
                <li class="nav-item">
                    <a class="nav-link collapsed" href="estudiante">
                        <i class="bi bi-grid"></i>
                        <span>Bienvenida</span>
                    </a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link "  href="estudiante?page=catalogo">
                        <i class="bi bi-card-list"></i><span>Catálogo</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#equipos-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-laptop"></i><span>Equipos computacionales </span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="equipos-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="estudiante?page=equipos_remunerados">
                                <i class="bi bi-circle"></i><span>Remunerados</span>
                            </a>
                        </li>
                        <li>
                            <a href="estudiante?page=equipos_donados">
                                <i class="bi bi-circle"></i><span>Donados</span>
                            </a>
                        </li>                      
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#informacion-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-person-badge"></i><span>Mi información</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="informacion-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="estudiante?page=informacion_personal">
                                <i class="bi bi-circle"></i><span>Información personal</span>
                            </a>
                        </li>
                        <li>
                            <a href="estudiante?page=informacion_escolar">
                                <i class="bi bi-circle"></i><span>Información escolar</span>
                            </a>
                        </li>
                        <li>
                            <a href="estudiante?page=informacion_domiciliaria">
                                <i class="bi bi-circle"></i><span>Información domiciliaria</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="estudiante?page=mi_mochila">
                        <i class="bi bi-briefcase"></i><span>Mi mochila</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="estudiante?page=deseos">
                        <i class="bi bi-heart"></i><span>Lista de deseos</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link collapsed"  href="estudiante?page=solicitudes">
                        <i class="bi bi-book"></i><span>Solictudes</span>
                    </a>
                </li>
                <li class="nav-heading"><hr></li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="estudiante?page=perfil">
                        <i class="bi bi-person"></i>
                        <span>Perfil</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link collapsed" href="estudiante?page=notificaciones">
                        <i class="bi bi-bell-fill"></i>
                        <span>Notificaciones</span>
                    </a>
                </li> 
                <li class="nav-item">
                    <a class="nav-link collapsed" href="estudiante?page=cambiar_contrasenia">
                        <i class="bi bi-key"></i>
                        <span>Cambiar contraseña</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="estudiante?page=cerrar_sesion">
                        <i class="bi bi-box-arrow-in-right"></i>
                        <span>Cerrar sesión</span>
                    </a>
                </li>
            </ul>
        </aside>
        <main id="main" class="main">
            <section class="section dashboard">
                <div class="pagetitle">
                    <h1>Catálogo</h1>
                    <nav>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item active"><a href="estudiante">Inicio</a></li>
                            <li class="breadcrumb-item "><a href="estudiante?page=catalogo">Catálogo</a></li>
                            <li class="breadcrumb-item"><a href="estudiante?page=catalogo&id_categoria=${id_categoria}&nombre_categoria=${nombre_categoria}">${nombre_categoria}</a></li>
                            <li class="breadcrumb-item active">${recurso_tecnologico.getNombreRecursoTecnologico()}</li>
                        </ol>
                    </nav>
                </div>
                <section class="section">
                    <c:choose>
                        <c:when test="${not empty recurso_tecnologico}">
                            <section class="section">
                                <div class="card">
                                    <div class="card-title hstack me-3 justify-content-end">
                                        <span class="badge bg-primary-light text-primary"><i class="bi bi-check-circle me-1"></i>Certifiado por DonaMx</span>
                                    </div>
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col col-5">
                                                <img src="assets/img/dona_hero.jpg" class="d-block w-100" alt="...">
                                            </div>
                                            <div class="col col-7">
                                                <h4><b>Nombre del Recurso tecnologico</b></h4>
                                                <p class="text-secondary"><b>Categoría: </b>Categoria<br/>
                                                    <b>Marca: </b>Marca<br/>
                                                    <b>Tipo: </b>Donado<br/>
                                                    <b>Donado por: </b>SoftecMx<br/>
                                                    <b>Precio: </b>No aplica <span class="badge bg-green-light text-success"><i class="bi bi-truck me-1"></i>Incluye costo de envío</span></p>

                                                <div class="d-grid gap-2 ">
                                                    <a href="#" class=" btn btn-primary-flaty rounded-pill ">
                                                        <i class="bx bx-paper-plane"></i>
                                                        Solicitar
                                                    </a>
                                                    <a href="#" class="btn btn-outline-primary-flaty rounded-pill">
                                                        <i class="bx bx-heart"></i>
                                                        Añadir a mi lista de deseos
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                        <hr/>
                                        <div>
                                            <ul class="nav nav-tabs nav-tabs-bordered" id="borderedTab" role="tablist">
                                                <li class="nav-item" role="presentation">
                                                    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#bordered-home" type="button" role="tab" aria-controls="home" aria-selected="true">Especificaciones</button>
                                                </li>
                                                <li class="nav-item" role="presentation">
                                                    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#bordered-profile" type="button" role="tab" aria-controls="profile" aria-selected="false">Detalles de la convocatoria</button>
                                                </li>
                                            </ul>
                                            <div class="tab-content pt-2" id="borderedTabContent">
                                                <div class="tab-pane fade show active" id="bordered-home" role="tabpanel" aria-labelledby="home-tab">

                                                    <div class="row">
                                                        <div class="col col-12 col-sm-12 col-md-6 position-relative">
                                                            <div class=" text-center ">
                                                                <div class="card-title ">
                                                                    General
                                                                </div>
                                                                <div class="card-body">
                                                                    <table class="table table-sm table-bordered border-light rounded-pill table-striped">
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Estado del equipo
                                                                            </th>
                                                                            <td>
                                                                                Seminuevo
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Marca
                                                                            </th>
                                                                            <td>
                                                                                marca
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Modelo
                                                                            </th>
                                                                            <td>
                                                                                Modelo
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Color
                                                                            </th>
                                                                            <td>
                                                                                Color
                                                                            </td>
                                                                        </tr>

                                                                    </table>
                                                                </div>
                                                            </div>
                                                            <div class=" text-center ">
                                                                <div class="card-title ">
                                                                    Almacenamiento
                                                                </div>
                                                                <div class="card-body">
                                                                    <table class="table table-sm table-bordered border-light rounded-pill table-striped">
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Capacidad de Disco Duro
                                                                            </th>
                                                                            <td>
                                                                                Capacidad de Disco Duro
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Interface de disco duro
                                                                            </th>
                                                                            <td>
                                                                                Interface de disco duro
                                                                            </td>
                                                                        </tr>

                                                                    </table>
                                                                </div>
                                                            </div>
                                                            <div class=" text-center ">
                                                                <div class="card-title ">
                                                                    Sistema operativo
                                                                </div>
                                                                <div class="card-body">
                                                                    <table class="table table-sm table-bordered border-light rounded-pill table-striped">
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Sistema operativo
                                                                            </th>
                                                                            <td>
                                                                                Sistema operativo
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Versión
                                                                            </th>
                                                                            <td>
                                                                                Versión
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Eición
                                                                            </th>
                                                                            <td>
                                                                                Eición
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                            <div class=" text-center ">
                                                                <div class="card-title ">
                                                                    Conectividad
                                                                </div>
                                                                <div class="card-body">
                                                                    <table class="table table-sm table-bordered border-light rounded-pill table-striped">
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Puertos de video
                                                                            </th>
                                                                            <td>
                                                                                Puertos de video
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Puertos USB
                                                                            </th>
                                                                            <td>
                                                                                Puertos USB
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Cantidad total de puertos USB
                                                                            </th>
                                                                            <td>
                                                                                Cantidad total de puertos USB
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Con USB
                                                                            </th>
                                                                            <td>
                                                                                Con USB
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Con Wifi
                                                                            </th>
                                                                            <td>
                                                                                Con Wifi
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Con HDMI
                                                                            </th>
                                                                            <td>
                                                                                Con HDMI
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Con VGA
                                                                            </th>
                                                                            <td>
                                                                                Con VGA
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Con bluetooth
                                                                            </th>
                                                                            <td>
                                                                                Con bluetooth
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Con salida a audifonos
                                                                            </th>
                                                                            <td>
                                                                                Con salida a audifonos
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Con microfono
                                                                            </th>
                                                                            <td>
                                                                                Con microfono
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Con camara web
                                                                            </th>
                                                                            <td>
                                                                                Con camara web
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Con puerto ethernet
                                                                            </th>
                                                                            <td>
                                                                                Con puerto ethernet
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Con lector de tarjeta de memoria SD
                                                                            </th>
                                                                            <td>
                                                                                Con lector de tarjeta de memoria SD
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Cantidad de parlantes
                                                                            </th>
                                                                            <td>
                                                                                Cantidad de parlantes
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Modo del sonido
                                                                            </th>
                                                                            <td>
                                                                                Modo del sonido
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col col-12 col-sm-12 col-md-6 position-relative">
                                                            <div class=" text-center ">
                                                                <div class="card-title ">
                                                                    Memoria
                                                                </div>
                                                                <div class="card-body">
                                                                    <table class="table table-sm table-bordered border-light rounded-pill table-striped">
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Memoria RAM
                                                                            </th>
                                                                            <td>
                                                                                Memoria RAM
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Tipo de memoria RAM
                                                                            </th>
                                                                            <td>
                                                                                Tipo de memoria RAM
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Velocidad de memoria RAM MHz
                                                                            </th>
                                                                            <td>
                                                                                Velocidad de memoria RAM MHz
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Capacidad maxima soportada de memoria RAM
                                                                            </th>
                                                                            <td>
                                                                                Cap Max GB
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Cantidad de Ranuras RAM
                                                                            </th>
                                                                            <td>
                                                                                Cantidad de Ranuras RAM
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                            <div class=" text-center ">
                                                                <div class="card-title ">
                                                                    Pantalla
                                                                </div>
                                                                <div class="card-body">
                                                                    <table class="table table-sm table-bordered border-light rounded-pill table-striped">
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Tipo de resolución 
                                                                            </th>
                                                                            <td>
                                                                                Tipo de resolución 
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Resolución de la pantalla
                                                                            </th>
                                                                            <td>
                                                                                Resolución de la pantalla
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Tipo de pantalla
                                                                            </th>
                                                                            <td>
                                                                                Tipo de pantalla
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Tamaño de la pantalla
                                                                            </th>
                                                                            <td>
                                                                                Tamaño de la pantalla
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Relación de aspecto
                                                                            </th>
                                                                            <td>
                                                                                Relación de aspecto
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Con pantalla antireflejo
                                                                            </th>
                                                                            <td>
                                                                                Con pantalla antireflejo
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                            <div class="  text-center ">
                                                                <div class="card-title ">
                                                                    Procesador
                                                                </div>
                                                                <div class="card-body">
                                                                    <table class="table table-sm table-bordered border-light rounded-pill table-striped">
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Tarjeta grafica
                                                                            </th>
                                                                            <td>
                                                                                Tarjeta grafica
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Marca del procesador
                                                                            </th>
                                                                            <td>
                                                                                Marca del procesador
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Cantidad de nucleos
                                                                            </th>
                                                                            <td>
                                                                                Cantidad de nucleos
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Velocidad de procesador   
                                                                            </th>
                                                                            <td>
                                                                                Velocidad de procesador
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                            <div class="  text-center ">
                                                                <div class="card-title ">
                                                                    Peso y dimensiones
                                                                </div>
                                                                <div class="card-body">
                                                                    <table class="table table-sm table-bordered border-light rounded-pill  table-striped">
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Peso
                                                                            </th>
                                                                            <td>
                                                                                Peso
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Ancho
                                                                            </th>
                                                                            <td>
                                                                                Ancho
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Profundidad
                                                                            </th>
                                                                            <td>
                                                                                Profundidad
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Altura
                                                                            </th>
                                                                            <td>
                                                                                Altura
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                            <div class="  text-center ">
                                                                <div class="card-title ">
                                                                    Bateria
                                                                </div>
                                                                <div class="card-body">
                                                                    <table class="table table-sm table-bordered border-light rounded-pill table-striped">
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Tipo de bateria
                                                                            </th>
                                                                            <td>
                                                                                Tipo de bateria
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Duración de la bateria
                                                                            </th>
                                                                            <td>
                                                                                Duración de la bateria h
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="tab-pane fade" id="bordered-profile" role="tabpanel" aria-labelledby="profile-tab">

                                                    <div class="card-title">
                                                        Estado de la convocatoria: 
                                                        <span class="badge bg-success text-light">  Abierta</span>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col col-12 col-sm-12 col-md-6 position-relative">
                                                            <div class=" text-center ">
                                                                <div class="card-title ">
                                                                    Requisitos 
                                                                </div>
                                                                <div class="card-body">
                                                                    <table class="table table-sm table-bordered border-light rounded-pill table-striped">
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Dirigido a
                                                                            </th>
                                                                            <td>
                                                                                Estudiantes
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Edad mínima
                                                                            </th>
                                                                            <td>
                                                                                Edad mínima
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Edad máxima
                                                                            </th>
                                                                            <td>
                                                                                Edad máxima
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Detalle de donación
                                                                            </th>
                                                                            <td>
                                                                                Detalle de donación
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col col-12 col-sm-12 col-md-6 position-relative">
                                                            <div class=" text-center ">
                                                                <div class="card-title ">
                                                                    Información del envio 
                                                                </div>
                                                                <div class="card-body">
                                                                    <table class="table table-sm table-bordered border-light rounded-pill table-striped">
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Incluye costo de envio
                                                                            </th>
                                                                            <td>
                                                                                No
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Costo aproximado del envio
                                                                            </th>
                                                                            <td>
                                                                                Costo aproximado del envio
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th scope="row">
                                                                                Detalle del envio
                                                                            </th>
                                                                            <td>
                                                                                Detalle del envio
                                                                            </td>
                                                                        </tr>

                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col col-12 col-sm-12 col-md-12 ">
                                                            <div class="card-title">
                                                                Otros detalles
                                                            </div>
                                                            <div>
                                                                Otros detalles
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </section>
                        </c:when>
                        <c:otherwise>
                            <br>
                            <div class="alert alert-warning">Error: No se encuntra el recurso tecnologico</div>
                        </c:otherwise>
                    </c:choose>

                </section>
            </section>
        </main>
       <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/quill/quill.min.js"></script>
        <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="assets/vendor/tinymce/tinymce.min.js"></script>
        <script src="assets/js/main_panel_admin.js"></script>
        <script src="assets/js/script_perfil.js"></script>
        <script src="assets/js/funciones_donatario.js"></script>


    </body>
</html>

