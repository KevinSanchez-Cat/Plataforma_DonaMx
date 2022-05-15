<%-- 
    Document   : mi_informacion
    Created on : 3/05/2022, 07:01:32 AM
    Author     : por_s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<template:templete_user title="Informacion personal">
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
                    <a class="nav-link " data-bs-target="#informacion-nav" data-bs-toggle="collapse" href="">
                        <i class="bi bi-person-badge"></i><span>Mi información</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="informacion-nav" class="nav-content collapse show" data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="estudiante?page=informacion_personal" class="active">
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
                    <h1>Información personal</h1>
                    <nav>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item active"><a href="estudiante">Inicio</a></li>
                            <li class="breadcrumb-item">Mi información</li>
                            <li class="breadcrumb-item active">Información personal</li>
                        </ol>
                    </nav>
                </div>
                <section class="section">
                    <div class="card ">
                        <div class="card-header hstack gap-3 bg-flaty-blue text-white">
                            Información personal
                            <button class="btn btn-light ms-auto">
                                Editar
                            </button>
                        </div>
                        <div class="card-body">
                            <br>
                            <form action="" method="POST" class=" needs-validation" novalidate>
                                <div class="col-md-3 position-relative">
                                    <label for="validationTooltip02" class="form-label">CURP</label>
                                    <div class="input-group has-validation">
                                        <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                        <div class="valid-tooltip">
                                            Se mira bien!
                                        </div>
                                    </div>
                                </div>
                                <div class="row g-3">
                                    <div class="col-md-4 position-relative">
                                        <label for="nombre_usuario" class="form-label">Nombre(s)</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="nombre_usuario" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 position-relative">
                                        <label for="validationTooltip02" class="form-label">Apellido paterno</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 position-relative">
                                        <label for="validationTooltip02" class="form-label">Apellido materno</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div> 
                                    <div class="col-md-4 position-relative">
                                        <label for="validationTooltip02" class="form-label">Nacionalidad</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div> 
                                    <div class="col-md-4 position-relative">
                                        <label for="validationTooltip02" class="form-label">Lugar de nacimiento</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-4 position-relative">
                                        <label for="validationTooltip02" class="form-label">Fecha de nacimiento</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>  
                                    <div class="col-md-3 position-relative">
                                        <label for="validationTooltip02" class="form-label">Genero</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3 position-relative">
                                        <label for="validationTooltip02" class="form-label">Estado civil</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3 position-relative">
                                        <label for="validationTooltip02" class="form-label">Telefono movil</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3 position-relative">
                                        <label for="validationTooltip02" class="form-label">Telefono fijo</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 position-relative">
                                        <label for="validationTooltipUsername" class="form-label">Intereses</label>
                                        <div class="input-group">
                                            <textarea type="text" class="form-control" id="validationTooltipUsername"
                                                      aria-describedby="validationTooltipUsernamePrepend" 
                                                      class="form-control" id="about" rows="3" cols="1">

                                            </textarea>
                                        </div>
                                    </div>
                                    <div class="col-md-6 position-relative">
                                        <label for="validationTooltipUsername" class="form-label">Habilidades</label>
                                        <div class="input-group">
                                            <textarea type="text" class="form-control" id="validationTooltipUsername"
                                                      aria-describedby="validationTooltipUsernamePrepend" 
                                                      class="form-control" id="about" rows="3" cols="1">

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
                                        <label for="formFile" class="form-label">Acta de nacimiento</label>
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

    </jsp:attribute>
</template:templete_user>