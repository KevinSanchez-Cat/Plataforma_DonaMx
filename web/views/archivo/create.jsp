<%-- 
    Document   : create
    Created on : 10/04/2022, 11:58:31 PM
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

        <!-- Favicons -->
        <link href="assets/img/imagenes/Logo_1.png" rel="icon">
        <link href="assets/img/imagenes/Logo_1.png" rel="apple-touch-icon">

        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/css/style_panel_admin.css" rel="stylesheet">
    </head>
    <body>
        <header id="header" class="header fixed-top d-flex align-items-center">
            <div class="d-flex align-items-center justify-content-between">
                <a href="" class="logo d-flex align-items-center">
                    <img src="assets/img/imagenes/Logo_1.png" alt="">
                    <span class="d-none d-lg-block">DonaMx</span>
                </a>
                <i class="bi bi-list toggle-sidebar-btn"></i>
            </div>
            <!--<div class="search-bar">
                <form class="search-form d-flex align-items-center" method="POST" action="#">
                    <input type="text" name="query" placeholder="Search" title="Enter search keyword">
                    <button type="submit" title="Search"><i class="bi bi-search"></i></button>
                </form>
            </div>-->
            <nav class="header-nav ms-auto">
                <ul class="d-flex align-items-center">
                    <li class="nav-item d-block d-lg-none">
                        <a class="nav-link nav-icon search-bar-toggle " href="#">
                            <i class="bi bi-search"></i>
                        </a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                            <i class="bi bi-bell"></i>
                            <span class="badge bg-primary badge-number">4</span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
                            <li class="dropdown-header">
                                Tienes 4 notificaciones
                                <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">Ver todas</span></a>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li class="notification-item">
                                <i class="bi bi-exclamation-circle text-warning"></i>
                                <div>
                                    <h4>Lorem Ipsum</h4>
                                    <p>Quae dolorem earum veritatis oditseno</p>
                                    <p>30 min. ago</p>
                                </div>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li class="dropdown-footer">
                                <a href="#">Mostrar todas las notificaciones</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown pe-3">

                        <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                            <img src="assets/img/team/team_6.png" alt="Profile" class="rounded-circle">
                            <span class="d-none d-md-block dropdown-toggle ps-2">Kevin Sanchez</span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                            <li class="dropdown-header">
                                <h6>Kevin Sanchez </h6>
                                <span>Administrador/Project Manager</span>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li>
                                <a class="dropdown-item d-flex align-items-center" href="views/profile/perfil.jsp">
                                    <i class="bi bi-person"></i>
                                    <span>Mi perfil</span>
                                </a>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li>
                                <a class="dropdown-item d-flex align-items-center" href="views/profile/ajustes.jsp">
                                    <i class="bi bi-gear"></i>
                                    <span>Ajustes</span>
                                </a>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li>
                                <a class="dropdown-item d-flex align-items-center" href="views/profile/ayuda.jsp">
                                    <i class="bi bi-question-circle"></i>
                                    <span>Ayuda?</span>
                                </a>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li>
                                <a class="dropdown-item d-flex align-items-center" href="#">
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
                    <a class="nav-link " href="views/dashboard/index.jsp">
                        <i class="bi bi-grid"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#organizaciones-nav" data-bs-toggle="collapse" href="views/organizacion/index.jsp">
                        <i class="bi bi-building"></i><span>Organizaciones</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="organizaciones-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="views/organizacion/create.jsp">
                                <i class="bi bi-circle"></i><span>Registrar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/organizacion/edit.jsp">
                                <i class="bi bi-circle"></i><span>Editar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/organizacion/eliminar.jsp">
                                <i class="bi bi-circle"></i><span>Eliminar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/organizacion/find.jsp">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>

                        <li>
                            <a href="views/organizacion/index.jsp">
                                <i class="bi bi-circle"></i><span>Consultar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/organizacion/autorizar.jsp">
                                <i class="bi bi-circle"></i><span>Autorizar organización</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/organizacion/bloquear.jsp">
                                <i class="bi bi-circle"></i><span>Bloquear/Desbloquear</span>
                            </a>
                        </li>

                        <li>
                            <a href="views/organizacion/listanegra.jsp">
                                <i class="bi bi-circle"></i><span>Consultar lista negra</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#voluntarios-nav" data-bs-toggle="collapse" href="views/voluntarios/index.jsp">
                        <i class="bi bi-people"></i><span>Voluntarios</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="voluntarios-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="views/voluntarios/create.jsp">
                                <i class="bi bi-circle"></i><span>Registrar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/voluntarios/edit.jsp">
                                <i class="bi bi-circle"></i><span>Editar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/voluntarios/delete.jsp">
                                <i class="bi bi-circle"></i><span>Eliminar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/voluntarios/find.jsp">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/voluntarios/bloquear.jsp">
                                <i class="bi bi-circle"></i><span>Bloquear/Desbloquear</span>
                            </a>
                        </li>

                        <li>
                            <a href="views/voluntarios/listanegra.jsp">
                                <i class="bi bi-circle"></i><span>Consultar lista negra</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#estudiantes-nav" data-bs-toggle="collapse" href="views/estudiante/index.jsp">
                        <i class="bi bi-person-badge"></i><span>Estudiantes</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="estudiantes-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="views/estudiante/create.jsp">
                                <i class="bi bi-circle"></i><span>Registrar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/estudiante/edit.jsp">
                                <i class="bi bi-circle"></i><span>Editar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/estudiante/delete.jsp">
                                <i class="bi bi-circle"></i><span>Eliminar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/estudiante/find.jsp">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/estudiante/bloquear.jsp">
                                <i class="bi bi-circle"></i><span>Bloquear/Desbloquear</span>
                            </a>
                        </li>

                        <li>
                            <a href="views/estudiante/listanegra.jsp">
                                <i class="bi bi-circle"></i><span>Consultar lista negra</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#categorias-nav" data-bs-toggle="collapse" href="views/categoria/index.jsp">
                        <i class="bi bi-card-list"></i><span>Categorías</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="categorias-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="views/categoria/create.jsp">
                                <i class="bi bi-circle"></i><span>Agregar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/categoria/edit.jsp">
                                <i class="bi bi-circle"></i><span>Editar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/categoria/delete.jsp">
                                <i class="bi bi-circle"></i><span>Eliminar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/categoria/find.jsp">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>

                        <li>
                            <a href="views/categoria/index.jsp">
                                <i class="bi bi-circle"></i><span>Consultar</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#roles-nav" data-bs-toggle="collapse" href="views/rol/index.jsp">
                        <i class="bi bi-person-rolodex"></i><span>Roles</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="roles-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="views/rol/create.jsp">
                                <i class="bi bi-circle"></i><span>Agregar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/rol/edit.jsp">
                                <i class="bi bi-circle"></i><span>Editar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/rol/delete.jsp">
                                <i class="bi bi-circle"></i><span>Eliminar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/rol/find.jsp">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>

                        <li>
                            <a href="views/rol/index.jsp">
                                <i class="bi bi-circle"></i><span>Consultar</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#estados-nav" data-bs-toggle="collapse" href="views/estado/index.jsp">
                        <i class="bi bi-globe"></i><span>Estados</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="estados-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="views/estado/create.jsp">
                                <i class="bi bi-circle"></i><span>Agregar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/estado/edit.jsp">
                                <i class="bi bi-circle"></i><span>Editar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/estado/delete.jsp">
                                <i class="bi bi-circle"></i><span>Eliminar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/estado/find.jsp">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>

                        <li>
                            <a href="views/estado/index.jsp">
                                <i class="bi bi-circle"></i><span>Consultar</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#municipios-nav" data-bs-toggle="collapse" href="views/municipio/index.jsp">
                        <i class="bi bi-pin-map"></i><span>Municipios</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="municipios-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="views/municipio/create.jsp">
                                <i class="bi bi-circle"></i><span>Agregar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/municipio/edit.jsp">
                                <i class="bi bi-circle"></i><span>Editar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/municipio/delete.jsp">
                                <i class="bi bi-circle"></i><span>Eliminar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/municipio/find.jsp">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>

                        <li>
                            <a href="views/municipio/index.jsp">
                                <i class="bi bi-circle"></i><span>Consultar</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#localidades-nav" data-bs-toggle="collapse" href="views/localidad/index.jsp">
                        <i class="bi bi-pin"></i><span>Localidades</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="localidades-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="views/localidad/create.jsp">
                                <i class="bi bi-circle"></i><span>Agregar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/localidad/edit.jsp">
                                <i class="bi bi-circle"></i><span>Editar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/localidad/delete.jsp">
                                <i class="bi bi-circle"></i><span>Eliminar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/localidad/find.jsp">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>

                        <li>
                            <a href="views/localidad/index.jsp">
                                <i class="bi bi-circle"></i><span>Consultar</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#solicitudes-nav" data-bs-toggle="collapse" href="views/solicitud/index.jsp">
                        <i class="bi bi-book-half"></i><span>Solicitudes</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="solicitudes-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="views/solicitud/details.jsp">
                                <i class="bi bi-circle"></i><span>Ver solicitud</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/solicitud/find.jsp">
                                <i class="bi bi-circle"></i><span>Buscar solicitud</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/solicitud/delete.jsp">
                                <i class="bi bi-circle"></i><span>Eliminar solicitud</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/solicitud/index.jsp">
                                <i class="bi bi-circle"></i><span>Consultar solicitud</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#donaciones-nav" data-bs-toggle="collapse" href="views/donacion/index.jsp">
                        <i class="bi bi-gift"></i><span>Donaciones</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="donaciones-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="views/donacion/index.jsp">
                                <i class="bi bi-circle"></i><span>Ver donaciones</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/donacion/find.jsp">
                                <i class="bi bi-circle"></i><span>Buscar donación</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/donacion/delete.jsp">
                                <i class="bi bi-circle"></i><span>Eliminar donación</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/donacion/find.jsp">
                                <i class="bi bi-circle"></i><span>Buscar donación</span>
                            </a>
                        </li>

                        <li>
                            <a href="views/donacion/details.jsp">
                                <i class="bi bi-circle"></i><span>Consultar donación</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/donacion/autorizar.jsp">
                                <i class="bi bi-circle"></i><span>Autorizar donación</span>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#recursos-nav" data-bs-toggle="collapse" href="views/recursoTecnologico/index.jsp">
                        <i class="bi bi-menu-button-wide"></i><span>Recursos Tecnologicos</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="recursos-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="views/recursoTecnologico/create.jsp">
                                <i class="bi bi-circle"></i><span>Registrar</span>
                            </a>
                        </li> 
                        <li>
                            <a href="views/recursoTecnologico/edit.jsp">
                                <i class="bi bi-circle"></i><span>Editar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/recursoTecnologico/delete.jsp">
                                <i class="bi bi-circle"></i><span>Eliminar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/recursoTecnologico/find.jsp">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/recursoTecnologico/autorizar.jsp">
                                <i class="bi bi-circle"></i><span>Autorizar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/recursoTecnologico/index.jsp">
                                <i class="bi bi-circle"></i><span>Ver todos</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#sistemasoperativos-nav" data-bs-toggle="collapse" href="views/sistemaOperativo/index.jsp">
                        <i class="bi bi-cpu"></i><span>Sistemas operativos</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="sistemasoperativos-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="views/sistemaOperativo/create.jsp">
                                <i class="bi bi-circle"></i><span>Agregar</span>
                            </a>
                        </li> 
                        <li>
                            <a href="views/sistemaOperativo/edit.jsp">
                                <i class="bi bi-circle"></i><span>Editar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/sistemaOperativo/delete.jsp">
                                <i class="bi bi-circle"></i><span>Eliminar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/sistemaOperativo/index.jsp">
                                <i class="bi bi-circle"></i><span>Ver todos</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#equiposcomputacionales-nav" data-bs-toggle="collapse" href="views/equipoComputacional/index.jsp">
                        <i class="bi bi-laptop"></i><span>Equipos computacionales</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="equiposcomputacionales-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="views/equipoComputacional/create.jsp">
                                <i class="bi bi-circle"></i><span>Agregar</span>
                            </a>
                        </li> 
                        <li>
                            <a href="views/equipoComputacional/edit.jsp">
                                <i class="bi bi-circle"></i><span>Editar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/equipoComputacional/delete.jsp">
                                <i class="bi bi-circle"></i><span>Eliminar</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/equipoComputacional/index.jsp">
                                <i class="bi bi-circle"></i><span>Ver todos</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#intenciones-nav" data-bs-toggle="collapse" href="views/intencion/index.jsp">
                        <i class="bi bi-chat-quote"></i><span>Intenciones</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="intenciones-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="views/intencion/index.jsp">
                                <i class="bi bi-circle"></i><span>Ver todas</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/intencion/responder.jsp">
                                <i class="bi bi-circle"></i><span>Responder</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/intencion/nuevas.jsp">
                                <i class="bi bi-circle"></i><span>Nuevas</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/intencion/pendientes.jsp">
                                <i class="bi bi-circle"></i><span>Pendientes</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/intencion/aceptadas.jsp">
                                <i class="bi bi-circle"></i><span>Aceptadas</span>
                            </a>
                        </li>
                        <li>
                            <a href="views/intencion/rechazadas.jsp">
                                <i class="bi bi-circle"></i><span>Rechazadas</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-heading">Paginas</li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="views/profile/perfil.jsp">
                        <i class="bi bi-person"></i>
                        <span>Perfil</span>
                    </a>
                </li><!-- End Profile Page Nav -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="views/profile/contacto.jsp">
                        <i class="bi bi-envelope"></i>
                        <span>Contacto</span>
                    </a>
                </li><!-- End Contact Page Nav -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="views/notificacion/index.jsp">
                        <i class="bi bi-bell-fill"></i>
                        <span>Notificaciones</span>
                    </a>
                </li><!-- End Contact Page Nav -->
            </ul>
        </aside><!-- End Sidebar-->

        <main id="main" class="main">

            <div class="pagetitle">
                <h1>Dashboard</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="views/dashbboard/index.jsp">Incio</a></li>
                        <li class="breadcrumb-item active">Dashboard</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->

            <section class="section dashboard">
                <div class="row">

                    <!-- Left side columns -->
                    <div class="col-lg-8">
                        <div class="row">

                            <!-- Sales Card -->
                            <div class="col-xxl-4 col-md-6">
                                <div class="card info-card sales-card">

                                    <div class="filter">
                                        <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                            <li class="dropdown-header text-start">
                                                <h6>Filter</h6>
                                            </li>

                                            <li><a class="dropdown-item" href="#">Today</a></li>
                                            <li><a class="dropdown-item" href="#">This Month</a></li>
                                            <li><a class="dropdown-item" href="#">This Year</a></li>
                                        </ul>
                                    </div>

                                    <div class="card-body">
                                        <h5 class="card-title">Estudiantes <span>| Hoy</span></h5>

                                        <div class="d-flex align-items-center">
                                            <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                <i class="bi bi-cart"></i>
                                            </div>
                                            <div class="ps-3">
                                                <h6>14</h6>
                                                <span class="text-success small pt-1 fw-bold">7%</span> 
                                                <span class="text-muted small pt-2 ps-1">incremento</span>

                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div><!-- End Sales Card -->

                            <!-- Revenue Card -->
                            <div class="col-xxl-4 col-md-6">
                                <div class="card info-card revenue-card">

                                    <div class="filter">
                                        <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                            <li class="dropdown-header text-start">
                                                <h6>Filtrar por</h6>
                                            </li>

                                            <li><a class="dropdown-item" href="#">Hoy</a></li>
                                            <li><a class="dropdown-item" href="#">Esta semana</a></li>
                                            <li><a class="dropdown-item" href="#">Este mes</a></li>
                                        </ul>
                                    </div>

                                    <div class="card-body">
                                        <h5 class="card-title">Donaciones<span> | Este mes</span></h5>
                                        <div class="d-flex align-items-center">
                                            <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                <i class="bi bi-currency-dollar"></i>
                                            </div>
                                            <div class="ps-3">
                                                <h6>$3,264</h6>
                                                <span class="text-success small pt-1 fw-bold">8%</span> 
                                                <span class="text-muted small pt-2 ps-1">incrementó</span>

                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div><!-- End Revenue Card -->

                            <!-- Customers Card -->
                            <div class="col-xxl-4 col-xl-12">

                                <div class="card info-card customers-card">

                                    <div class="filter">
                                        <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                            <li class="dropdown-header text-start">
                                                <h6>Filtrar por</h6>
                                            </li>

                                            <li><a class="dropdown-item" href="#">Hoy</a></li>
                                            <li><a class="dropdown-item" href="#">Esta semana</a></li>
                                            <li><a class="dropdown-item" href="#">Este mes</a></li>
                                        </ul>
                                    </div>

                                    <div class="card-body">
                                        <h5 class="card-title">Ordanizaciones <span> | Este año</span></h5>

                                        <div class="d-flex align-items-center">
                                            <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                <i class="bi bi-people"></i>
                                            </div>
                                            <div class="ps-3">
                                                <h6>3</h6>
                                                <span class="text-danger small pt-1 fw-bold">1%</span> 
                                                <span class="text-muted small pt-2 ps-1">incrementó</span>
                                            </div>
                                        </div>

                                    </div>
                                </div>

                            </div><!-- End Customers Card -->

                        </div>
                    </div><!-- End Left side columns -->

                    <!-- Right side columns -->
                    <div class="col-lg-4">

                        <!-- Recent Activity -->
                        <div class="card">
                            <div class="filter">
                                <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                    <li class="dropdown-header text-start">
                                        <h6>Filtrar por</h6>
                                    </li>

                                    <li><a class="dropdown-item" href="#">Hoy</a></li>
                                    <li><a class="dropdown-item" href="#">Esta semana</a></li>
                                    <li><a class="dropdown-item" href="#">Este mes</a></li>
                                </ul>
                            </div>

                            <div class="card-body">
                                <h5 class="card-title">Actividad reciente<span> | Hoy </span></h5>

                                <div class="activity">
                                    <div class="activity-item d-flex">
                                        <div class="activite-label">1 min</div>
                                        <i class='bi bi-circle-fill activity-badge text-warning align-self-start'></i>
                                        <div class="activity-content">
                                            Se ha hecho una donación de una computadora
                                            <a href="#" class="fw-bold text-dark">
                                                se requiere autorización
                                            </a>
                                        </div>
                                    </div><!-- End activity item-->
                                </div>

                            </div>
                        </div><!-- End Recent Activity -->
                    </div><!-- End Right side columns -->

                </div>
            </section>

        </main><!-- End #main -->


        <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/quill/quill.min.js"></script>
        <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="assets/vendor/tinymce/tinymce.min.js"></script>
        <script src="assets/js/main_panel_admin.js"></script>

    </body>
</html>
