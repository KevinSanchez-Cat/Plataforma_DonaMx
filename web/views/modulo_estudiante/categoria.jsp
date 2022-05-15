
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                            <li class="breadcrumb-item "><a href="estudiante?page=catalogo">Catalogo</a></li>
                            <li class="breadcrumb-item active">${categoria}</li>
                        </ol>
                    </nav>
                </div>
                <section class="section">
                    <c:choose>
                        <c:when test="${not empty lstRecursosTecnologicos}">
                            <div class="row row-cols-1 row-cols-md-4 g-4">
                                <c:forEach var="recursos" items="${lstRecursosTecnologicos}">
                                    <div class="col ">
                                        <a href="estudiante?page=catalogo&categoria=${recursos.getIdRecursoTecnologico()}">
                                            <div class="card text-white bg-azul text-center">
                                                <img src="assets/img/dona_hero.jpg" class="card-img-top" alt="...">
                                                <div class="card-body">
                                                    <h5 class="card-title">${recursos.getNombreCategoria()}</h5>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <br>
                            <!--  <div class="alert alert-info">Aún no hay recursos tecnologicos asociados a esta categoría</div>-->
                        </c:otherwise>
                    </c:choose>
                </section>
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
            </section>
        </main>
    </jsp:attribute>
</template:templete_user>