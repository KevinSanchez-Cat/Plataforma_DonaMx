<%-- 
    Document   : solicitudes
    Created on : 3/05/2022, 07:01:43 AM
    Author     : por_s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<template:templete_user title="Notificaciones">
    <jsp:attribute name="content">
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
                        <i class="bi bi-card-list"></i><span>Catalogo</span>
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
                    <a class="nav-link" href="estudiante?page=notificaciones">
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
                    <h1>Notificaciones</h1>
                    <nav>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item active"><a href="estudiante">Inicio</a></li>
                            <li class="breadcrumb-item active">Notificaciones</li>
                        </ol>
                    </nav>
                </div>
                <section class="section">
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
                                        <h5 class="card-title">Notificaciones <span>| Hoy</span></h5>

                                        <table class="table table-responsive table-bordered table-hover datatable">
                                            <thead >
                                                <tr class="table-primary "> 
                                                    <th scope="col">Fecha</th>
                                                    <th scope="col">Prioridad</th>
                                                    <th scope="col">Mensaje</th>

                                                    <th scope="col">Estado</th>
                                                    <th scope="col">Acción</th>
                                                </tr>
                                            </thead>
                                            <tbody>

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

                                            </tbody>
                                        </table>

                                    </div>

                                </div>
                            </div>
                </section>
            </section>
        </main>
    </jsp:attribute>
</template:templete_user>
<!-- End Recent Sales  <tr> 
                                        <th>22/01/2022</th>
                                        <td><span class="badge bg-primary text-light"><i class="bi bi-info-circle me-1"></i> Normal</span></td>
                                        <td>La organización ha solicitado su autorizacion</td> 
                                        <td> <span class="badge bg-success text-light"><i class="bi bi-eye-fill me-1"></i> Visto</span></td>
                                        <td>
                                            <button type="button" class="btn btn-primary"><i class="bi bi-eye-fill"></i></button>
                                            <button type="button" class="btn btn-danger"><i class="bi bi-trash"></i></button>
                                        </td>
                                    </tr>
                                    <tr> 
                                        <th>22/01/2022</th>
                                        <td><span class="badge bg-warning text-dark"><i class="bi bi-exclamation-triangle me-1"></i> Importante</span></td>
                                        <td>La organización ha solicitado su autorizacion</td> 
                                        <td> <span class="badge bg-dark text-light"><i class="bi bi-eye-slash-fill me-1"></i>No visto</span></td>
                                        <td>
                                            <button type="button" class="btn btn-primary"><i class="bi bi-eye-fill"></i></button>
                                            <button type="button" class="btn btn-danger"><i class="bi bi-trash"></i></button>
                                        </td>
                                    </tr>
                                    <tr> 
                                        <th>22/01/2022</th>
                                        <td><span class="badge bg-danger text-light"><i class="bi bi-exclamation-octagon me-1"></i> Urgente</span></td>
                                        <td>La organización ha solicitado su autorizacion</td> 
                                        <td> <span class="badge bg-dark text-light"><i class="bi bi-eye-slash-fill me-1"></i>No visto</span></td>
                                        <td>
                                            <button type="button" class="btn btn-primary"><i class="bi bi-eye-fill"></i></button>
                                            <button type="button" class="btn btn-danger"><i class="bi bi-trash"></i></button>
                                        </td>
                                    </tr>-->