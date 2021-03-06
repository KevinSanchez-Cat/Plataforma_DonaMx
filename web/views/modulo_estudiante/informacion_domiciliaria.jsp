<%-- 
    Document   : mi_informacion
    Created on : 3/05/2022, 07:01:32 AM
    Author     : por_s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta charset="utf-8"/>
        <meta content="width=device-width, initial-scale=1.0" name="viewport"/>

        <title>Informacion domiciliaria</title>
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
            
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Expires", "0");
            response.setDateHeader("Expires", -1);

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
                            <img src="Srv_usuario?id=${id}" alt="Profile" width="50%" class="rounded-circle">
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
                    <a class="nav-link collapsed "  href="estudiante?page=catalogo">
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
                    <a class="nav-link " data-bs-target="#informacion-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-person-badge"></i><span>Mi información</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="informacion-nav" class="nav-content collapse show" data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="estudiante?page=informacion_personal" >
                                <i class="bi bi-circle"></i><span>Información personal</span>
                            </a>
                        </li>
                        <li>
                            <a href="estudiante?page=informacion_escolar" >
                                <i class="bi bi-circle"></i><span>Información escolar</span>
                            </a>
                        </li>
                        <li>
                            <a href="estudiante?page=informacion_domiciliaria" class="active">
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
                        <i class="bi bi-bell"></i>
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
                    <h1>Información domiciliaria</h1>
                    <nav>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item active"><a href="estudiante">Inicio</a></li>
                            <li class="breadcrumb-item">Mi información</li>
                            <li class="breadcrumb-item active">Información domiciliaria</li>
                        </ol>
                    </nav>
                </div>
                <section class="section">
                    <div class="card ">
                        <div class="card-header hstack gap-3 bg-flaty-blue text-white">
                            Imformación domiciliaria
                            <button class="btn btn-light ms-auto">
                                Editar
                            </button>
                        </div>
                        <div class="card-body">
                            <br>
                            <form action="estudiante" method="POST" class=" needs-validation" novalidate>
                                <input type="hidden" class="form-control"  name="form" id="form" value="FORMULARIO-INFORMACION-DOMICILIARIA" required>
                                <input type="hidden" class="form-control" id="est-infDomIdUser" value="<%if (usuario != null) {
                                        out.print(usuario.getIdUsuario());
                                    }%>" required>
                                <input type="hidden" class="form-control" id="est-infDomIdUser" value="<%if (request.getParameter("direccion_id_direccion") != null) {
                                        out.print(request.getParameter("direccion_id_direccion"));
                                    }%>" required>
                                <div class="col-md-2 position-relative">
                                    <label for="est-infDomCodigoPostal" class="form-label">Código postal</label>
                                    <div class="input-group has-validation">
                                        <input type="text" class="form-control" id="est-infDomCodigoPostal" value="<%if (request.getParameter("direccion_codigo_postal") != null) {
                                                out.print(request.getParameter("direccion_codigo_postal"));
                                            }%>" required>
                                        <div class="valid-tooltip">
                                            Se mira bien!
                                        </div>
                                    </div>
                                </div>
                                <br/>
                                <div class="row g-3">
                                    <div class="col-md-3 position-relative">
                                        <label for="est-infDomIdEstado" class="form-label">Estado federativo</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="est-infDomIdEstado" value="<%if (request.getParameter("direccion_id_estado") != null) {
                                                    out.print(request.getParameter("direccion_id_estado"));
                                                }%>" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3 position-relative">
                                        <label for="est-infDomIdMunicipio" class="form-label">Municipio</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="est-infDomIdMunicipio" value="<%if (request.getParameter("direccion_id_municipio") != null) {
                                                    out.print(request.getParameter("direccion_id_municipio"));
                                                }%>" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 position-relative">
                                        <label for="est-infDomIdocalidad" class="form-label">Localidad</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="est-infDomIdocalidad" value="<%if (request.getParameter("direccion_id_localidad") != null) {
                                                    out.print(request.getParameter("direccion_id_localidad"));
                                                }%>" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 position-relative">
                                        <label for="validationTooltip02" class="form-label">Tipo de asentamiento</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="<%if (request.getParameter("direccion_tipo_asentamiento") != null) {
                                                    out.print(request.getParameter("direccion_tipo_asentamiento"));
                                                }%>" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-8 position-relative">
                                        <label for="validationTooltip02" class="form-label">Nombre del asentamiento</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="<%if (request.getParameter("direccion_nombre_asentamiento") != null) {
                                                    out.print(request.getParameter("direccion_nombre_asentamiento"));
                                                }%>" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 position-relative">
                                        <label for="validationTooltip02" class="form-label">Calle externa y número</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="<%if (request.getParameter("direccion_calle_exterior") != null) {
                                                    out.print(request.getParameter("direccion_calle_exterior"));
                                                }%>" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 position-relative">
                                        <label for="est-infDomCalleInterna" class="form-label">Calle interna y número</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="est-infDomCalleInterna" value="<%if (request.getParameter("direccion_calle_interior") != null) {
                                                    out.print(request.getParameter("direccion_calle_interior"));
                                                }%>" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-6 position-relative">
                                        <label for="est-infDomCalleFrontal" class="form-label">Calle frontal</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="est-infDomCalleFrontal" value="<%if (request.getParameter("direccion_calle_frontal") != null) {
                                                    out.print(request.getParameter("direccion_calle_frontal"));
                                                }%>" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 position-relative">
                                        <label for="est-infDomCalleTrasera" class="form-label">Calle trasera</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="est-infDomCalleTrasera" value="<%if (request.getParameter("direccion_calle_trasera") != null) {
                                                    out.print(request.getParameter("direccion_calle_trasera"));
                                                }%>" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 position-relative">
                                        <label for="est-infDomCalleIzquierda" class="form-label">Calle de la izquierda</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="est-infDomCalleIzquierda" value="<%if (request.getParameter("direccion_calle_izquierda") != null) {
                                                    out.print(request.getParameter("direccion_calle_izquierda"));
                                                }%>" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 position-relative">
                                        <label for="est-infDomCalleDerecha" class="form-label">Calle de la derecha</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="est-infDomCalleDerecha" value="<%if (request.getParameter("direccion_calle_derecha") != null) {
                                                    out.print(request.getParameter("direccion_calle_derecha"));
                                                }%>" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 position-relative">
                                        <label for="est-infDomTipoAsentamiento" class="form-label">Tipo de asentamiento</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="est-infDomTipoAsentamiento" value="<%if (request.getParameter("direccion_tipo_asentamiento") != null) {
                                                    out.print(request.getParameter("direccion_tipo_asentamiento"));
                                                }%>" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 position-relative">
                                        <label for="est-infDomNombreAsentamiento" class="form-label">Nombre del asentamiento</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="est-infDomNombreAsentamiento" value="<%if (request.getParameter("direccion_nombre_asentamiento") != null) {
                                                    out.print(request.getParameter("direccion_nombre_asentamiento"));
                                                }%>" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12 position-relative">
                                        <label for="est-infDomReferencias" class="form-label">Referencias</label>
                                        <div class="input-group">
                                            <textarea type="text" class="form-control" id="est-infDomReferencias"
                                                      aria-describedby="validationTooltipUsernamePrepend" 
                                                      class="form-control" id="about" rows="3" cols="1">
                                                <%if (request.getParameter("direccion_referencias") != null) {
                                                        out.print(request.getParameter("direccion_referencias"));
                                                    }%>
                                            </textarea>
                                        </div>
                                    </div>
                                </div>
                                <br/>
                                <div class="col-12 text-end">
                                    <button class="btn btn-secondary" type="submit">Guardar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="card ">
                            <div class="card-header bg-flaty-blue text-white">
                                Documentos
                            </div>
                            <div class="card-body">
                                </br>
                                <form action="" method="POST" class=" needs-validation" novalidate>
                                    <div class="mb-3 position-relative">
                                        <label for="formFile" class="form-label">Comprobante domiciliario</label>
                                        <div class="input-group has-validation">
                                            <input class="form-control" type="file" id="formFile" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>

                                    <br/>
                                    <div class="col-12 text-end">
                                        <button class="btn btn-secondary" type="submit">Guardar</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
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

