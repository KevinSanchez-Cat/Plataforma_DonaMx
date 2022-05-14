<%-- 
    Document   : categorias
    Created on : 3/05/2022, 07:02:16 AM
    Author     : por_s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<template:templete_user title="Equipos donados">
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
                    <a class="nav-link " data-bs-target="#equipos-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-laptop"></i><span>Equipos computacionales </span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="equipos-nav" class="nav-content collapse show " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="estudiante?page=equipos_remunerados">
                                <i class="bi bi-circle"></i><span>Remunerados</span>
                            </a>
                        </li>
                        <li>
                            <a href="estudiante?page=equipos_donados" class="active">
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
                    <h1>Equipos computacionales donados</h1>
                    <nav>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item active"><a href="estudiante">Inicio</a></li>
                            <li class="breadcrumb-item">Equipos computacionales</li>
                            <li class="breadcrumb-item active">Donados</li>
                        </ol>
                    </nav>
                </div>
                <div class="d-grid gap-2 d-md-flex justify-content-md-between">
                    <div class="row">
                        <p class="col  d-flex align-items-center ">
                            Solo mostrar: 
                        </p>
                        <div class="col col-auto">
                            <select class="form-select" aria-label="Default select example">
                                <option selected>Todos</option>
                                <option value="3">Nuevos</option>
                                <option value="1">Seminuevos</option>
                                <option value="2">Reacondicionados</option>
                            </select>
                        </div>
                    </div>

                </div>
                <section class="section">
                    <c:choose>
                        <c:when test="${not empty lstEquiposDonados}">   
                            <div class="row row-cols-1 row-cols-md-4 g-4">
                                <c:forEach var="equipos" items="${lstEquiposDonados}">
                                    <div class="col ">
                                        <a href="estudiante?page=notificaciones&id_notificacion=${equipos.getId()}">
                                            <div class="card text-white bg-azul text-center">
                                                <img src="assets/img/dona_hero.jpg" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">${equipos.getMensage()}</h5>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                </c:forEach>
                            </div>

                        </c:when>
                        <c:otherwise>                         
                            <br>
                            <div class="alert alert-info">Aún no hay equipos donados</div>

                            <div class="row row-cols-2 row-cols-sm-3 row-cols-md-4 row-cols-lg-4 row-cols-xl-4 row-cols-xxl-6 "> <!--   row-cols-1 row-cols-md-4 g-4 row-cols-xl-4-->
                                <div class="col ">
                                    <div class="card">
                                        <img src="assets/img/dona_hero.jpg"  class="card-img-top" alt="...">
                                        <div class="card-body">
                                            <h6 class="card-title"><strong>Nombre del recurso</strong></h6>
                                            <div class="card-text">
                                                <div class="hstack gap-3 ">
                                                    <b class="text-success">Reacondicionado   </b>
                                                    <i class="text-success ri ri-seedling-fill"></i> 
                                                </div>

                                                <b>Precio:</b> $000.00<br/>
                                                <b>Sistema operativo:</b> Linux<br/>
                                                <b>Donado por:</b> SoftecMx
                                            </div>
                                        </div>
                                        <div class="card-footer">
                                            <div class="d-grid gap-2 d-md-flex justify-content-md-center">
                                                <a href="#" class=" btn btn-primary btn-sm">
                                                    <i class="bx bxs-backpack"></i>
                                                    Solicitar
                                                </a>

                                                <a href="#" class="btn btn-primary-flaty btn-sm ">
                                                    <i class="bx bx-info-circle "></i>
                                                    Ver
                                                </a> 
                                                <a href="#" class=" btn btn-secondary btn-sm ">
                                                    <i class="bx bx-heart"></i>
                                                    Guardar
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>  
                                <div class="col ">
                                    <div class="card">
                                        <img src="assets/img/dona_hero.jpg"  class="card-img-top" alt="...">
                                        <div class="card-body">
                                            <h6 class="card-title"><strong>Nombre del recurso</strong></h6>
                                            <p class="card-text">
                                            <div class="hstack gap-3 ">
                                                <b class="text-success">Reacondicionado   </b>
                                                <i class="text-success ri ri-seedling-fill"></i> 
                                            </div>

                                            <b>Precio:</b> $000.00<br/>
                                            <b>Sistema operativo:</b> Linux<br/>
                                            <b>Donado por:</b> SoftecMx
                                            </p>
                                        </div>
                                        <div class="card-footer">
                                            <div class="d-grid gap-2 d-md-flex justify-content-md-center">
                                                <a href="#" class=" btn btn-success btn-sm">
                                                    <i class="bx bxs-backpack"></i>
                                                    Solicitar
                                                </a>

                                                <a href="#" class="btn btn-outline-primary-flaty btn-sm">
                                                    <i class="text-warning bx bx-info-circle"></i>
                                                    Ver
                                                </a> 
                                                <a href="#" class=" btn btn-danger btn-sm ">
                                                    <i class="bx bx-heart"></i>
                                                    Guardar
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col ">
                                    <div class="card">
                                        <img src="assets/img/dona_hero.jpg"  class="card-img-top" alt="...">
                                        <div class="card-body">
                                            <h6 class="card-title"><strong>Nombre del recurso</strong></h6>
                                            <p class="card-text">
                                            <div class="hstack gap-3 ">
                                                <b class="text-success">Reacondicionado   </b>
                                                <i class="text-success ri ri-seedling-fill"></i> 
                                            </div>

                                            <b>Precio:</b> $000.00<br/>
                                            <b>Sistema operativo:</b> Linux<br/>
                                            <b>Donado por:</b> SoftecMx
                                            </p>
                                        </div>
                                        <div class="card-footer">
                                            <div class="d-grid gap-2 d-md-flex justify-content-md-center">
                                                <a href="#" class=" btn btn-success btn-sm">
                                                    <i class="bx bxs-backpack"></i>
                                                    Solicitar
                                                </a>

                                                <a href="#" class="btn btn-outline-primary-flaty btn-sm ">
                                                    <i class="text-warning bx bx-info-circle "></i>
                                                    Ver
                                                </a> 
                                                <a href="estudiante?page=encuesta_socieconomica" class=" btn btn-danger btn-sm ">
                                                    <i class="bx bx-heart"></i>
                                                    Guardar
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>  
                                <div class="col ">
                                    <div class="card">
                                        <img src="assets/img/dona_hero.jpg"  class="card-img-top" alt="...">
                                        <div class="card-body">
                                            <h6 class="card-title"><strong>Nombre del recurso</strong></h6>
                                            <p class="card-text">
                                            <div class="hstack gap-3 ">
                                                <b class="text-success">Reacondicionado   </b>
                                                <i class="text-success ri ri-seedling-fill"></i> 
                                            </div>

                                            <b>Precio:</b> $000.00<br/>
                                            <b>Sistema operativo:</b> Linux<br/>
                                            <b>Donado por:</b> SoftecMx
                                            </p>
                                        </div>
                                        <div class="card-footer">
                                            <div class="d-grid gap-2 d-md-flex justify-content-md-center">
                                                <a href="#" class=" btn btn-success btn-sm">
                                                    <i class="bx bxs-backpack"></i>
                                                    Solicitar
                                                </a>

                                                <a href="#" class="btn btn-outline-primary-flaty btn-sm">
                                                    <i class="text-warning bx bx-info-circle"></i>
                                                    Ver
                                                </a> 
                                                <a href="#" class=" btn btn-danger btn-sm ">
                                                    <i class="bx bx-heart"></i>
                                                    Guardar
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col ">
                                    <div class="card">
                                        <img src="assets/img/dona_hero.jpg"  class="card-img-top" alt="...">
                                        <div class="card-body">
                                            <h6 class="card-title"><strong>Nombre del recurso</strong></h6>
                                            <p class="card-text">
                                            <div class="hstack gap-3 ">
                                                <b class="text-success">Reacondicionado   </b>
                                                <i class="text-success ri ri-seedling-fill"></i> 
                                            </div>

                                            <b>Precio:</b> $000.00<br/>
                                            <b>Sistema operativo:</b> Linux<br/>
                                            <b>Donado por:</b> SoftecMx
                                            </p>
                                        </div>
                                        <div class="card-footer">
                                            <div class="d-grid gap-2 d-md-flex justify-content-md-center">
                                                <a href="#" class=" btn btn-success btn-sm">
                                                    <i class="bx bxs-backpack"></i>
                                                    Solicitar
                                                </a>

                                                <a href="#" class="btn btn-outline-primary-flaty btn-sm ">
                                                    <i class="text-warning bx bx-info-circle "></i>
                                                    Ver
                                                </a> 
                                                <a href="#" class=" btn btn-danger btn-sm ">
                                                    <i class="bx bx-heart"></i>
                                                    Guardar
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>  
                                <div class="col ">
                                    <div class="card">
                                        <img src="assets/img/dona_hero.jpg"  class="card-img-top" alt="...">
                                        <div class="card-body">
                                            <h6 class="card-title"><strong>Nombre del recurso</strong></h6>
                                            <p class="card-text">
                                            <div class="hstack gap-3 ">
                                                <b class="text-success">Reacondicionado   </b>
                                                <i class="text-success ri ri-seedling-fill"></i> 
                                            </div>

                                            <b>Precio:</b> $000.00<br/>
                                            <b>Sistema operativo:</b> Linux<br/>
                                            <b>Donado por:</b> SoftecMx
                                            </p>
                                        </div>
                                        <div class="card-footer">
                                            <div class="d-grid gap-2 d-md-flex justify-content-md-center">
                                                <a href="#" class=" btn btn-success btn-sm">
                                                    <i class="bx bxs-backpack"></i>
                                                    Solicitar
                                                </a>

                                                <a href="#" class="btn btn-outline-primary-flaty btn-sm">
                                                    <i class="text-warning bx bx-info-circle"></i>
                                                    Ver
                                                </a> 
                                                <a href="#" class=" btn btn-danger btn-sm ">
                                                    <i class="bx bx-heart"></i>
                                                    Guardar
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col ">
                                    <div class="card">
                                        <img src="assets/img/dona_hero.jpg"  class="card-img-top" alt="...">
                                        <div class="card-body">
                                            <h6 class="card-title"><strong>Nombre del recurso</strong></h6>
                                            <p class="card-text">
                                            <div class="hstack gap-3 ">
                                                <b class="text-success">Reacondicionado   </b>
                                                <i class="text-success ri ri-seedling-fill"></i> 
                                            </div>

                                            <b>Precio:</b> $000.00<br/>
                                            <b>Sistema operativo:</b> Linux<br/>
                                            <b>Donado por:</b> SoftecMx
                                            </p>
                                        </div>
                                        <div class="card-footer">
                                            <div class="d-grid gap-2 d-md-flex justify-content-md-center">
                                                <a href="#" class=" btn btn-success btn-sm">
                                                    <i class="bx bxs-backpack"></i>
                                                    Solicitar
                                                </a>

                                                <a href="#" class="btn btn-outline-primary-flaty btn-sm ">
                                                    <i class="text-warning bx bx-info-circle "></i>
                                                    Ver
                                                </a> 
                                                <a href="#" class=" btn btn-danger btn-sm ">
                                                    <i class="bx bx-heart"></i>
                                                    Guardar
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>  
                                <div class="col ">
                                    <div class="card">
                                        <img src="assets/img/dona_hero.jpg"  class="card-img-top" alt="...">
                                        <div class="card-body">
                                            <h6 class="card-title"><strong>Nombre del recurso</strong></h6>
                                            <p class="card-text">
                                            <div class="hstack gap-3 ">
                                                <b class="text-success">Reacondicionado   </b>
                                                <i class="text-success ri ri-seedling-fill"></i> 
                                            </div>

                                            <b>Precio:</b> $000.00<br/>
                                            <b>Sistema operativo:</b> Linux<br/>
                                            <b>Donado por:</b> SoftecMx
                                            </p>
                                        </div>
                                        <div class="card-footer">
                                            <div class="d-grid gap-2 d-md-flex justify-content-md-center">
                                                <a href="#" class=" btn btn-success btn-sm">
                                                    <i class="bx bxs-backpack"></i>
                                                    Solicitar
                                                </a>

                                                <a href="#" class="btn btn-outline-primary-flaty btn-sm">
                                                    <i class="text-warning bx bx-info-circle"></i>
                                                    Ver
                                                </a> 
                                                <a href="#" class=" btn btn-danger btn-sm ">
                                                    <i class="bx bx-heart"></i>
                                                    Guardar
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </section>
            </section>
        </main>
    </jsp:attribute>
</template:templete_user>