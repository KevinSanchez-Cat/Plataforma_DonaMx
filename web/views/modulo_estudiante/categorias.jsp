<%-- 
    Document   : categorias
    Created on : 3/05/2022, 07:02:16 AM
    Author     : por_s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:templete_user title="Catalogo">
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
                    <a class="nav-link "  href="estudiante?page=catalogo">
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
                    <a class="nav-link collapsed" href="estudiante?page=notificaciones">
                        <i class="bi bi-bell-fill"></i>
                        <span>Notificaciones</span>
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
                            <li class="breadcrumb-item active"><a href="estudiante?page=catalogo">Catalogo</a></li>
                        </ol>
                    </nav>
                </div>
                <section class="section">
                    <div class="row row-cols-1 row-cols-md-4 g-4">
                        <div class="col ">
                            <a href="estudiante?page=catalogo?cat=accesorios-computacionales">
                                <div class="card text-white bg-azul text-center">
                                    <img src="assets/img/dona_hero.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title">Accesorios computacionales</h5>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col">
                            <a href="estudiante?page=catalogo?cat=aplicaciones">
                                <div class="card text-white bg-azul text-center">
                                    <img src="assets/img/dona_hero.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title">Aplicaciones</h5>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col ">
                            <a href="estudiante?page=catalogo?cat=antivirus">
                                <div class="card text-white bg-azul text-center">
                                    <img src="assets/img/dona_hero.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title">Antivirus</h5>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col">
                            <a href="estudiante?page=catalogo?cat=camaras-fotograficas">
                                <div class="card text-white bg-azul text-center">
                                    <img src="assets/img/dona_hero.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title">Cámaras fotográficas</h5>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col ">
                            <a href="estudiante?page=catalogo?cat=celulares">
                                <div class="card text-white bg-azul text-center">
                                    <img src="assets/img/dona_hero.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title">Celulares</h5>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col">
                            <a href="estudiante?page=catalogo?cat=equipos-computacionales">
                                <div class="card text-white bg-azul text-center">
                                    <img src="assets/img/dona_hero.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title">Equipos computacionales</h5>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col">
                            <a href="estudiante?page=catalogo?cat=equipos-computacionales-remunerados">
                                <div class="card text-white bg-azul text-center">
                                    <img src="assets/img/dona_hero.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title">Equipos computacionales con remuneración</h5>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="col ">
                            <a href="estudiante?page=catalogo?cat=libros-digitales">
                                <div class="card text-white bg-azul text-center">
                                    <img src="assets/img/dona_hero.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title">Libros digitales</h5>
                                    </div>
                                </div>
                            </a>
                        </div>
                         <div class="col">
                            <a href="estudiante?page=catalogo?cat=licencias">
                                <div class="card text-white bg-azul text-center">
                                    <img src="assets/img/dona_hero.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title">Licencias</h5>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>

                </section>
            </section>
        </main>
    </jsp:attribute>
</template:templete_user>