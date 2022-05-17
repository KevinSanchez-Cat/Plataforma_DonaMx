<%-- 
    Document   : e ce
    Created on : 13/05/2022, 12:16:42 PM
    Author     : por_s
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<template:templete_user title="Informacion escolar">
    <jsp:attribute name="content">
    
        <main id="main" class="main">
            <section class="section dashboard">
                <div class="pagetitle">
                    <h1>Encuesta</h1>
                </div>
                <section class="section">

                    <div class="card ">
                     
                        <div class="card-header hstack gap-3 bg-flaty-blue text-white">
                            Información escolar
                            <button class="btn btn-light ms-auto">
                                Editar
                            </button>
                        </div>
                        <div class="card-body">
                            <br>
                            <form action="" method="POST" class=" needs-validation" novalidate>
                                <div class="col-md-3 position-relative">
                                    <label for="validationTooltip02" class="form-label">Nivel educativo</label>
                                    <div class="input-group has-validation">
                                        <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                        <div class="valid-tooltip">
                                            Se mira bien!
                                        </div>
                                    </div>
                                </div>
                                <div class="row g-3">
                                    <div class="col-md-4 position-relative">
                                        <label for="nombre_usuario" class="form-label">Nombre de la institución</label>
                                        <div class="input-group has-validation">
                                            <input type="text" readonly="tue" class="form-control" id="nombre_usuario" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 position-relative">
                                        <label for="validationTooltip02" class="form-label">Matricula de la institución</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 position-relative">
                                        <label for="validationTooltip02" class="form-label">Tipo de escuela</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div> 
                                    <div class="col-md-4 position-relative">
                                        <label for="validationTooltip02" class="form-label">Tipo de periodo</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-2 position-relative">
                                        <label for="validationTooltip02" class="form-label">Total de periodos</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>  
                                    <div class="col-md-2 position-relative">
                                        <label for="validationTooltip02" class="form-label">Periodo actual</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 position-relative">
                                        <label for="validationTooltip02" class="form-label">Nombre del periodo</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4 position-relative">
                                        <label for="validationTooltip02" class="form-label">Matricula del estudiante</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div> 

                                    <div class="col-md-4 position-relative">
                                        <label for="validationTooltip02" class="form-label">Estatus escolar</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-2 position-relative">
                                        <label for="validationTooltip02" class="form-label">Regular</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3 position-relative">
                                        <label for="validationTooltip02" class="form-label">Promedio anterior</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3 position-relative">
                                        <label for="validationTooltip02" class="form-label">Promedio general</label>
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control" id="validationTooltip02" value="" required>
                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
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
                                        <label for="formFile" class="form-label">Certificado de estudios</label>
                                        <div class="input-group has-validation">
                                            <input class="form-control" type="file" id="formFile" required>

                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mb-3 position-relative">
                                        <label for="formFile" class="form-label">Cardex</label>
                                        <div class="input-group has-validation">
                                            <input class="form-control" type="file" id="formFile" required>

                                            <div class="valid-tooltip">
                                                Se mira bien!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mb-3 position-relative">
                                        <label for="formFile" class="form-label">Credencial escolar</label>
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