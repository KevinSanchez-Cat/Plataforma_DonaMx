
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:templete_administrador title="Estadisticas">
    <jsp:attribute name="content">
        <aside id="sidebar" class="sidebar">
            <ul class="sidebar-nav" id="sidebar-nav">

                <li class="nav-item">
                    <a class="nav-link collapsed" href="administrador">
                        <i class="bi bi-grid"></i>
                        <span>Bienvenida</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#roles-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-person-rolodex"></i><span>Roles</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="roles-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="administrador?page=roles&accion=agregar">
                                <i class="bi bi-circle"></i><span>Agregar</span>
                            </a>
                        </li>

                        <li>
                            <a href="administrador?page=roles&accion=buscar">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=roles&accion=consultar">
                                <i class="bi bi-circle"></i><span>Consultar</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#organizaciones-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-building"></i><span>Donadores</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="organizaciones-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="administrador?page=donadores&accion=registrar">
                                <i class="bi bi-circle"></i><span>Registrar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=donadores&accion=buscar">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=donadores&accion=autorizacion">
                                <i class="bi bi-circle"></i><span>Autorización</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=donadores&accion=bloquear_desbloquear">
                                <i class="bi bi-circle"></i><span>Bloquear/Desbloquear</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=donadores&accion=consultar">
                                <i class="bi bi-circle"></i><span>Consultar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=donadores&accion=lista_negra">
                                <i class="bi bi-circle"></i><span>Consultar lista negra</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#voluntarios-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-people"></i><span>Voluntarios</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="voluntarios-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="administrador?page=voluntarios&accion=registrar">
                                <i class="bi bi-circle"></i><span>Registrar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=voluntarios&accion=buscar">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=voluntarios&accion=bloquear_desbloquear">
                                <i class="bi bi-circle"></i><span>Bloquear/Desbloquear</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=voluntarios&accion=consultar">
                                <i class="bi bi-circle"></i><span>Consultar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=voluntarios&accion=lista_negra">
                                <i class="bi bi-circle"></i><span>Consultar lista negra</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#estudiantes-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-person-badge"></i><span>Donatarios</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="estudiantes-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="administrador?page=donatarios&accion=registrar">
                                <i class="bi bi-circle"></i><span>Registrar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=donatarios&accion=buscar">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=donatarios&accion=bloquear_desbloquear">
                                <i class="bi bi-circle"></i><span>Bloquear/Desbloquear</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=donatarios&accion=consultar">
                                <i class="bi bi-circle"></i><span>Consultar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=donatarios&accion=lista_negra">
                                <i class="bi bi-circle"></i><span>Consultar lista negra</span>
                            </a>
                        </li>
                    </ul>
                </li>


                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#estados-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-globe"></i><span>Estados</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="estados-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="administrador?page=estados&accion=agregar">
                                <i class="bi bi-circle"></i><span>Agregar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=estados&accion=buscar">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>

                        <li>
                            <a href="administrador?page=estados&accion=consultar">
                                <i class="bi bi-circle"></i><span>Consultar</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#municipios-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-pin-map"></i><span>Municipios</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="municipios-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="administrador?page=municipios&accion=agregar">
                                <i class="bi bi-circle"></i><span>Agregar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=municipios&accion=buscar">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=municipios&accion=consultar">
                                <i class="bi bi-circle"></i><span>Consultar</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#localidades-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-pin"></i><span>Localidades</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="localidades-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="administrador?page=localidades&accion=agregar">
                                <i class="bi bi-circle"></i><span>Agregar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=localidades&accion=buscar">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=localidades&accion=consultar">
                                <i class="bi bi-circle"></i><span>Consultar</span>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#categorias-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-card-list"></i><span>Categorías</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="categorias-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="administrador?page=categorias&accion=agregar">
                                <i class="bi bi-circle"></i><span>Agregar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=categorias&accion=buscar">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=categorias&accion=consultar">
                                <i class="bi bi-circle"></i><span>Consultar</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#sistemasoperativos-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-cpu"></i><span>Sistemas operativos</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="sistemasoperativos-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="administrador?page=sistemas_operativos&accion=agregar">
                                <i class="bi bi-circle"></i><span>Agregar</span>
                            </a>
                        </li> 
                        <li>
                            <a href="administrador?page=sistemas_operativos&accion=buscar">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=sistemas_operativos&accion=consultar">
                                <i class="bi bi-circle"></i><span>Ver todos</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#recursos-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-menu-button-wide"></i><span>Recursos Tecnologicos</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="recursos-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="administrador?page=recursos_tecnologicos&accion=registrar">
                                <i class="bi bi-circle"></i><span>Registrar</span>
                            </a>
                        </li> 
                        <li>
                            <a href="administrador?page=recursos_tecnologicos&accion=buscar">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=recursos_tecnologicos&accion=consultar_donador">
                                <i class="bi bi-circle"></i><span>Consultar por donador</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=recursos_tecnologicos&accion=consultar_categoria">
                                <i class="bi bi-circle"></i><span>Consultar por categoría</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=recursos_tecnologicos&accion=consultar">
                                <i class="bi bi-circle"></i><span>Ver todos</span>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#equiposcomputacionales-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-laptop"></i><span>Equipos computacionales</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="equiposcomputacionales-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="administrador?page=equipos_computacionales&accion=registrar">
                                <i class="bi bi-circle"></i><span>Registrar</span>
                            </a>
                        </li> 
                        <li>
                            <a href="administrador?page=equipos_computacionales&accion=buscar">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=equipos_computacionales&accion=consultar_donados">
                                <i class="bi bi-circle"></i><span>Consultar donados</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=equipos_computacionales&accion=consultar_remunerados">
                                <i class="bi bi-circle"></i><span>Consultar remunerados</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#solicitudes-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-book-half"></i><span>Solicitudes</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="solicitudes-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="administrador?page=solicitudes&accion=buscar">
                                <i class="bi bi-circle"></i><span>Buscar solicitud</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=solicitudes&accion=consultar_donador">
                                <i class="bi bi-circle"></i><span>Consultar por donador</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=solicitudes&accion=consultar_donatario">
                                <i class="bi bi-circle"></i><span>Consultar por donatario</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=solicitudes&accion=consultar">
                                <i class="bi bi-circle"></i><span>Ver todas</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#donaciones-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-gift"></i><span>Donaciones</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="donaciones-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="administrador?page=donaciones&accion=registrar">
                                <i class="bi bi-circle"></i><span>Registrar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=donaciones&accion=buscar">
                                <i class="bi bi-circle"></i><span>Buscar donación</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=donaciones&accion=consultar_donatario">
                                <i class="bi bi-circle"></i><span>Consultar por donatario</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=donaciones&accion=consultar_donador">
                                <i class="bi bi-circle"></i><span>Consultar por donador</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=donaciones&accion=consultar_en_especie">
                                <i class="bi bi-circle"></i><span>Donaciones en especie</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=donaciones&accion=consultar_economicas">
                                <i class="bi bi-circle"></i><span>Donaciones economicas</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=donaciones&accion=consultar">
                                <i class="bi bi-circle"></i><span>Ver todas</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#intenciones-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-lightbulb"></i><span>Intenciones</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="intenciones-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="administrador?page=intenciones&accion=registrar">
                                <i class="bi bi-circle"></i><span>Registrar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=intenciones&accion=buscar">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=intenciones&accion=consultar">
                                <i class="bi bi-circle"></i><span>Ver todas</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="administrador?page=estadisticas">
                        <i class="bi bi-graph-up"></i><span>Estadisticas</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#paqueteria-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-truck"></i><span>Paqueteria</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="paqueteria-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="administrador?page=paqueteria&accion=recoger">
                                <i class="bi bi-circle"></i><span>Recoger</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=paqueteria&accion=trasladar">
                                <i class="bi bi-circle"></i><span>Trasladar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=paqueteria&accion=enviar">
                                <i class="bi bi-circle"></i><span>Enviar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=paqueteria&accion=directo">
                                <i class="bi bi-circle"></i><span>Directo</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=paqueteria&accion=buscar_serial">
                                <i class="bi bi-circle"></i><span>Buscar no. de serie</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=paqueteria&accion=consultar">
                                <i class="bi bi-circle"></i><span>Ver todas</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" data-bs-target="#notificaciones-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-chat-quote"></i><span>Notificaciones DonaMx</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="notificaciones-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="administrador?page=notificaciones&accion=crear">
                                <i class="bi bi-circle"></i><span>Crear</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=notificaciones&accion=buscar">
                                <i class="bi bi-circle"></i><span>Buscar</span>
                            </a>
                        </li>
                        <li>
                            <a href="administrador?page=notificaciones&accion=consultar">
                                <i class="bi bi-circle"></i><span>Ver todas</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="administrador?page=servidor">
                        <i class="bi bi-server"></i><span>Servidor</span>
                    </a>
                </li>

                <li class="nav-heading">Paginas</li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="administrador?page=perfil">
                        <i class="bi bi-person"></i>
                        <span>Perfil</span>
                    </a>
                </li><!-- End Profile Page Nav -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="administrador?page=contacto">
                        <i class="bi bi-envelope"></i>
                        <span>Contacto</span>
                    </a>
                </li><!-- End Contact Page Nav -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="administrador?page=mis_notificaciones">
                        <i class="bi bi-bell-fill"></i>
                        <span>Notificaciones</span>
                    </a>
                </li><!-- End Contact Page Nav -->
            </ul>
        </aside><!-- End Sidebar-->

        <main id="main" class="main">

            <div class="pagetitle">
                <h1>Estadisticas</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="administrador">Incio</a></li>
                        <li class="breadcrumb-item active">Estadisticas</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->

            <section class="section dashboard">

                <section class="section">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">Cantidad de donaciones por estado</h5>

                                    <!-- Bar Chart -->
                                    <canvas id="barChart" style="max-height: 400px;"></canvas>
                                    <script>
                                        document.addEventListener("DOMContentLoaded", () => {
                                            new Chart(document.querySelector('#barChart'), {
                                                type: 'bar',
                                                data: {
                                                    labels: ['Aguascalientes', 'Baja California', 'Baja California Sur', 'Campeche', 'Durango'],
                                                    datasets: [{
                                                            label: 'Bar Chart',
                                                            data: [65, 59, 80, 81, 56],
                                                            backgroundColor: [
                                                                'rgb(0, 29, 120,0.2)',
                                                                'rgb(121, 218, 232,0.2)',
                                                                'rgb(10, 161, 221,0.2)',
                                                                'rgb(33, 85, 205,0.2)',
                                                                'rgb(0, 29, 110,0.2)'
                                                            ],
                                                            borderColor: [
                                                                'rgb(0, 29, 120)',
                                                                'rgb(121, 218, 232)',
                                                                'rgb(10, 161, 221)',
                                                                'rgb(33, 85, 205)',
                                                                'rgb(0, 29, 110)'
                                                            ],
                                                            borderWidth: 1
                                                        }]
                                                },
                                                options: {
                                                    scales: {
                                                        y: {
                                                            beginAtZero: true
                                                        }
                                                    }
                                                }
                                            });
                                        });
                                    </script>
                                    <!-- End Bar CHart -->

                                </div>
                            </div>
                        </div>

                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">% De los recursos tecnologicos donados por categoría</h5>

                                    <!-- Pie Chart -->
                                    <canvas id="pieChart" style="max-height: 400px;"></canvas>
                                    <script>
                                        document.addEventListener("DOMContentLoaded", () => {
                                            new Chart(document.querySelector('#pieChart'), {
                                                type: 'pie',
                                                data: {
                                                    labels: [
                                                        'Categoria 1',
                                                        'Cateogoria 2',
                                                        'Cateogoria 6',
                                                        'Cateogoria 5',
                                                        'Categoría 3'
                                                    ],
                                                    datasets: [{
                                                            label: 'My First Dataset',
                                                            data: [300, 50, 100, 32, 51],
                                                            backgroundColor: [
                                                                'rgb(0, 29, 120)',
                                                                'rgb(121, 218, 232)',
                                                                'rgb(10, 161, 221)',
                                                                'rgb(33, 85, 205)',
                                                                'rgb(0, 29, 110)'
                                                            ],
                                                            hoverOffset: 4
                                                        }]
                                                }
                                            });
                                        });
                                    </script>
                                    <!-- End Pie CHart -->

                                </div>
                            </div>
                        </div>

                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">% de los recursos tecnologicos por categoría</h5>

                                    <!-- Doughnut Chart -->
                                    <canvas id="doughnutChart" style="max-height: 400px;"></canvas>
                                    <script>
                                        document.addEventListener("DOMContentLoaded", () => {
                                            new Chart(document.querySelector('#doughnutChart'), {
                                                type: 'doughnut',
                                                data: {
                                                    labels: [
                                                        'Categoria 1',
                                                        'Cateogoria 2',
                                                        'Cateogoria 6',
                                                        'Cateogoria 5',
                                                        'Categoría 3'
                                                    ],
                                                    datasets: [{
                                                            label: 'My First Dataset',
                                                            data: [300, 50, 100, 32, 51],
                                                            backgroundColor: [
                                                                'rgb(0, 29, 110)',
                                                                'rgb(121, 218, 232)',
                                                                'rgb(10, 161, 221)',
                                                                'rgb(33, 85, 205)',
                                                                'rgb(0, 29, 110)'
                                                            ],
                                                            hoverOffset: 4
                                                        }]
                                                }
                                            });
                                        });
                                    </script>
                                    <!-- End Doughnut CHart -->

                                </div>
                            </div>
                        </div>

                    </div>
                </section>

            </section>

        </main>

    </jsp:attribute>
</template:templete_administrador>