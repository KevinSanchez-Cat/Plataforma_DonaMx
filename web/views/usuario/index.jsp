<%-- 
    Document   : index
    Created on : 10/04/2022, 11:59:30 PM
    Author     : por_s
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
        <!--    <link href="css/lib/bootstrap.min.css" rel="stylesheet" type="text/css"/>
                <link href="css/bootstrap/bootstrap-5.0.2-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="css/lib/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/lib/bootstrap-datepicker.css" rel="stylesheet" type="text/css"/>
        <link href="css/generado/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="css/lib/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <link href="css/tablas/tablas_styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="datagrid">
            <table>
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Nombre</th>
                        <th>Imagen</th>
                        <th></th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <td colspan="4">
                            <div id="paging"><ul><li><a href="#"><span>Previous</span></a></li><li><a href="#" class="active"><span>1</span></a></li><li><a href="#"><span>2</span></a></li><li><a href="#"><span>3</span></a></li><li><a href="#"><span>4</span></a></li><li><a href="#"><span>5</span></a></li><li><a href="#"><span>Next</span></a></li></ul>
                            </div>
                    </tr>
                </tfoot>
                <tbody>
                    <tr>

                        </td>
                        <td>
                            <a id="mostrar" href="ControllerImagen?action=insert&id=">
                                <img src="../../../Imagen/nuevo.png" title="Nuevo registro"/>
                            </a>-
                            <a href="ControllerImagen?action=edit&id="> 
                                <img src="../Imagen/editar.png" title="Modificar"/>
                            </a>-
                            <a href="ControllerImagen?action=delete&id="> 
                                <img src="../Imagen/delete.png" title="Eliminar"/>
                            </a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <form name="formimg" action="ControllerImagen" method="post" enctype="multipart/form-data">
            <div class="datagrid">
                <table>
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Campo</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <td colspan="2">

                            </td>
                        </tr>
                    </tfoot>
                    <tbody>
                        <tr>
                            <td><label for="id">Nombre del archivo: </label>
                            </td>  
                            <td>
                                <input type="text" name="txtname" value="<c:out value="${row.nombreimg}" />"/>
                            </td>
                        </tr>
                        <tr class="alt">
                            <td>
                                <label for="id">Seleccionar Imagen: *</label> 
                            </td>  
                            <td>
                                <input type="file" name="fichero" value="" id="btn" class="btn" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" style="text-align: center"><input type="submit" value="Enviar Archivo" name="submit" id="btn" class="btn"/></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </form>
        <a href="Pagina1.jsp">Regresar</a>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
</html>
