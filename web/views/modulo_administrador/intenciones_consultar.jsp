
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<template:templete_administrador title="Intenciones">
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
                    <a class="nav-link " data-bs-target="#intenciones-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-lightbulb"></i><span>Intenciones</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="intenciones-nav" class="nav-content collapse show" data-bs-parent="#sidebar-nav">
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
                            <a href="administrador?page=intenciones&accion=consultar" class="active">
                                <i class="bi bi-circle"></i><span>Ver todas</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="administrador?page=estadisticas">
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
                <h1>Consultar intenciones</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="administrador">Incio</a></li>
                        <li class="breadcrumb-item ">Intención</li>
                        <li class="breadcrumb-item active">Consultar</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->

            <section class="section dashboard">
                <c:choose>
                    <c:when test="${not empty lstNotificaciones}">   
                        <div class="col-12">
                            <div class="card recent-sales overflow-auto">

                                <div class="filter">
                                    <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                                    <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                        <li class="dropdown-header text-start">
                                            <h6>Filtrar</h6>
                                        </li>

                                        <li><a class="dropdown-item" href="#">De hoy</a></li>
                                        <li><a class="dropdown-item" href="#">De una semana</a></li>
                                        <li><a class="dropdown-item" href="#">De un mes</a></li>
                                    </ul>
                                </div>

                                <div class="card-body">
                                    <h5 class="card-title">Notificaciones <span>| Hoy</span></h5>

                                    <table class="table table-responsive table-bordered table-hover datatable">
                                        <thead >
                                            <tr class="table-primary "> 
                                                <th scope="col">ID</th>
                                                <th scope="col">Fecha</th>
                                                <th scope="col">Prioridad</th>
                                                <th scope="col">Mensaje</th>

                                                <th scope="col">Estado</th>
                                                <th scope="col">Acción</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <c:forEach var="notificacion" items="${lstNotificaciones}">
                                                <tr> 
                                                    <th>22/01/2022</th>
                                                    <td><span class="badge bg-info text-dark"><i class="bi bi-info-square me-1"></i> Baja</span></td>
                                                    <td>La organización ha solicitado su autorizacion</td> 
                                                    <td> <span class="badge bg-success text-light"><i class="bi bi-eye-fill me-1"></i> Visto</span></td>
                                                    <td>
                                                        <button type="button" class="btn btn-primary"><i class="bi bi-eye-fill"></i></button>
                                                        <button type="button" class="btn btn-danger"><i class="bi bi-trash"></i></button>
                                                    </td>
                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>

                                </div>

                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <br>
                        <div class="alert alert-info">Usted no tiene notificaciones</div>
                    </c:otherwise>
                </c:choose>

                <div class="col-12">
                    <div class="card recent-sales overflow-auto">

                        <div class="filter">
                            <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                            <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                                <li class="dropdown-header text-start">
                                    <h6>Filtrar</h6>
                                </li>

                                <li><a class="dropdown-item" href="#">De hoy</a></li>
                                <li><a class="dropdown-item" href="#">De una semana</a></li>
                                <li><a class="dropdown-item" href="#">De un mes</a></li>
                            </ul>
                        </div>

                        <div class="card-body">
                            <h5 class="card-title">Intenciones <span>| Hoy</span></h5>

                            <table class="table table-responsive table-bordered table-hover datatable">
                                <thead >
                                    <tr class="table-primary "> 
                                        <th scope="col">ID</th>
                                        <th scope="col">Titulo</th>
                                        <th scope="col">Usuario</th>
                                        <th scope="col">Fecha de intencion</th>
                                        <th scope="col">Fecha de respuesta</th>
                                        <th scope="col">Estado</th>
                                        <th scope="col">Acción</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <tr> 
                                        <th>#9868</th>
                                        <td>Mouses</td>
                                        <td><a href="#" class="text-flaty-primary"><b>Uriel</b></a></td>
                                        <td>12/23/1221</td>
                                        <td>12/23/1221</td>
                                        <td><span class="badge bg-flaty-warning text-light"><i class="bi bi-pin me-1"></i>Pendiente</span>
                                            <span class="badge bg-primary text-light"><i class="bi bi-check-circle me-1"></i>Revisado</span>
                                            <span class="badge bg-success text-light"><i class="bi bi-hand-thumbs-up me-1"></i>Aceptado</span>
                                            <span class="badge bg-danger text-light"><i class="bi bi-hand-thumbs-down me-1"></i>Rechazado</span>
                                        </td>
                                        <td>
                                            <button type="button" class="btn btn-primary"><i class="bi bi-info-circle"></i></button>
                                            <button type="button" class="btn btn-success"><i class="bi bi-reply"></i></button>
                                            <button type="button" class="btn btn-danger"><i class="bi bi-trash"></i></button>
                                        </td>
                                    </tr>

                                </tbody>
                            </table>

                        </div>

                    </div>
                </div>
            </section>
        </main>

    </jsp:attribute>
</template:templete_administrador>