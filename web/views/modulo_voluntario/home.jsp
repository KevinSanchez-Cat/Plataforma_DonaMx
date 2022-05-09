
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:templete_voluntario title="Bienvenida">
    <jsp:attribute name="content">
        <aside id="sidebar" class="sidebar">
            <ul class="sidebar-nav" id="sidebar-nav">

                <li class="nav-item">
                    <a class="nav-link " href="voluntario">
                        <i class="bi bi-grid"></i>
                        <span>Bienvenida</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#organizaciones-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-building"></i><span>Organizacion</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="organizaciones-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="voluntario?page=organizacion&accion=consultar">
                                <i class="bi bi-circle"></i><span>Consultar</span>
                            </a>
                        </li>
                        <li>
                            <a href="voluntario?page=organizacion&accion=registrar">
                                <i class="bi bi-circle"></i><span>Registrar</span>
                            </a>
                        </li>
                        <li>
                            <a href="voluntario?page=organizacion&accion=editar">
                                <i class="bi bi-circle"></i><span>Editar</span>
                            </a>
                        </li>
                        <li>
                            <a href="voluntario?page=organizacion&accion=eliminar">
                                <i class="bi bi-circle"></i><span>Eliminar</span>
                            </a>
                        </li>
                    </ul>
                </li>             
                <li class="nav-item">
                    <a class="nav-link collapsed" href="voluntario?page=categorias">
                        <i class="bi bi-card-list"></i><span>Categorías</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link collapsed" href="voluntario?page=estadisticas">
                        <i class="bi bi-graph-up"></i><span>Estadisticas</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#paqueteria-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-truck"></i><span>Paqueteria</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="paqueteria-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="voluntario?page=paqueteria&accion=recoger">
                                <i class="bi bi-circle"></i><span>Recoger</span>
                            </a>
                        </li>
                        <li>
                            <a href="voluntario?page=paqueteria&accion=trasladar">
                                <i class="bi bi-circle"></i><span>Trasladar</span>
                            </a>
                        </li>
                        <li>
                            <a href="voluntario?page=paqueteria&accion=enviar">
                                <i class="bi bi-circle"></i><span>Enviar</span>
                            </a>
                        </li>
                        <li>
                            <a href="voluntario?page=paqueteria&accion=directo">
                                <i class="bi bi-circle"></i><span>Directo</span>
                            </a>
                        </li>
                        <li>
                            <a href="voluntario?page=paqueteria&accion=buscar_serial">
                                <i class="bi bi-circle"></i><span>Buscar no. de serie</span>
                            </a>
                        </li>
                        <li>
                            <a href="voluntario?page=paqueteria&accion=consultar">
                                <i class="bi bi-circle"></i><span>Ver todas</span>
                            </a>
                        </li>
                    </ul>
                </li>
             
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#donaciones-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-heart"></i><span>Donaciones</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="donaciones-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="voluntario?page=donaciones&accion=donacion_economica">
                                <i class="bi bi-circle"></i><span>Donación economica</span>
                            </a>
                        </li>
                        <li>
                            <a href="voluntario?page=donaciones&accion=consultar">
                                <i class="bi bi-circle"></i><span>Ver todas las donaciones</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#intenciones-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-chat-quote"></i><span>Peticiones</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="intenciones-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="voluntario?page=peticion&accion=crear">
                                <i class="bi bi-circle"></i><span>Crear</span>
                            </a>
                        </li>
                        <li>
                            <a href="voluntario?page=peticion&accion=consultar">
                                <i class="bi bi-circle"></i><span>Consultar</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-heading">Paginas</li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="voluntario?page=perfil">
                        <i class="bi bi-person"></i>
                        <span>Perfil</span>
                    </a>
                </li><!-- End Profile Page Nav -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="voluntario?page=contacto">
                        <i class="bi bi-envelope"></i>
                        <span>Contacto</span>
                    </a>
                </li><!-- End Contact Page Nav -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="voluntario?page=notificaciones">
                        <i class="bi bi-bell-fill"></i>
                        <span>Notificaciones</span>
                    </a>
                </li><!-- End Contact Page Nav -->
            </ul>
        </aside><!-- End Sidebar-->

        <main id="main" class="main">

            <div class="pagetitle">
                <h1>Bienvenida</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="voluntario">Incio</a></li>
                        <li class="breadcrumb-item active">Bienvenida</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->

            <section class="section dashboard">
                <div class="row">

                </div>
            </section>
            <%@include  file="/views/localidad/index.jsp" %>
        </main>

    </jsp:attribute>
</template:templete_voluntario>