/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo.administrador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manipula.ManipulaUsuario;
import model.Notificacion;
import model.Usuario;

/**
 *
 * @author Kevin Ivan Sanchez Valdin
 */
public class Modulo_Administrador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String page = request.getParameter("page");
        if (session != null) {

            if (!session.isNew()) {
                // Session is valid
                String username = (String) session.getAttribute("username");
                //  session.setMaxInactiveInterval(60);//session timeout in seconds 
                if (username != null) {
                    String rol = (String) session.getAttribute("rol");
                    if (rol != null) {
                        if (rol.equals("ADMINISTRADOR")) {

                            ManipulaUsuario mUsuario = new ManipulaUsuario();
                            int idUser = (int) session.getAttribute("idUser");
                            List<Notificacion> lstNotificaciones = mUsuario.getNotificacion(idUser);
                            if (lstNotificaciones == null) {
                                lstNotificaciones = new ArrayList<>();
                            }
                            request.setAttribute("lstNotificaciones", lstNotificaciones);

                            if (page == null) {
                                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                dispatcher.forward(request, response);
                            } else {
                                switch (page) {
                                    case "roles": {
                                        String accion = request.getParameter("accion");
                                        if (accion == null) {
                                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                            dispatcher.forward(request, response);
                                        } else {
                                            switch (accion) {
                                                case "agregar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/roles_agregar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "buscar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/roles_buscar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/roles_consultar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                default: {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                    case "donadores": {
                                        String accion = request.getParameter("accion");
                                        if (accion == null) {
                                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                            dispatcher.forward(request, response);
                                        } else {
                                            switch (accion) {
                                                case "registrar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donadores_registrar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "buscar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donadores_buscar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "autorizacion": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donadores_autorizar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "bloquear_desbloquear": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donadores_bloquear_desbloquear.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donadores_consultar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "lista_negra": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donadores_consultar_lista_negra.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                default: {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                    case "voluntarios": {
                                        String accion = request.getParameter("accion");
                                        if (accion == null) {
                                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                            dispatcher.forward(request, response);
                                        } else {
                                            switch (accion) {
                                                case "registrar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/voluntarios_registrar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "buscar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/voluntarios_buscar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "bloquear_desbloquear": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/voluntarios_bloquear_desbloquear.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/voluntarios_consultar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "lista_negra": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/voluntarios_consultar_lista_negra.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                default: {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                    case "donatarios": {
                                        String accion = request.getParameter("accion");
                                        if (accion == null) {
                                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                            dispatcher.forward(request, response);
                                        } else {
                                            switch (accion) {
                                                case "registrar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donatarios_registrar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "buscar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donatarios_buscar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "bloquear_desbloquear": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donatarios_bloquear_desbloquear.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "lista_negra": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donatarios_consultar_lista_negra.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donatarios_consultar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                default: {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                    case "estados": {
                                        String accion = request.getParameter("accion");
                                        if (accion == null) {
                                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                            dispatcher.forward(request, response);
                                        } else {
                                            switch (accion) {
                                                case "agregar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/estados_agregar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "buscar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/estados_buscar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/estados_consultar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                default: {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                    case "municipios": {
                                        String accion = request.getParameter("accion");
                                        if (accion == null) {
                                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                            dispatcher.forward(request, response);
                                        } else {
                                            switch (accion) {
                                                case "agregar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/municipios_agregar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "buscar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/municipios_buscar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/municipios_consultar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                default: {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                    case "localidades": {
                                        String accion = request.getParameter("accion");
                                        if (accion == null) {
                                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                            dispatcher.forward(request, response);
                                        } else {
                                            switch (accion) {
                                                case "agregar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/localidades_agregar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "buscar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/localidades_buscar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/localidades_consultar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                default: {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                    case "categorias": {
                                        String accion = request.getParameter("accion");
                                        if (accion == null) {
                                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                            dispatcher.forward(request, response);
                                        } else {
                                            switch (accion) {
                                                case "agregar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/categorias_agregar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "buscar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/categorias_buscar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/categorias_consultar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                default: {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                    case "sistemas_operativos": {
                                        String accion = request.getParameter("accion");
                                        if (accion == null) {
                                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                            dispatcher.forward(request, response);
                                        } else {
                                            switch (accion) {
                                                case "agregar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/sistemas_operativos_agregar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "buscar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/sistemas_operativos_buscar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/sistemas_operativos_consultar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                default: {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                    case "recursos_tecnologicos": {
                                        String accion = request.getParameter("accion");
                                        if (accion == null) {
                                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                            dispatcher.forward(request, response);
                                        } else {
                                            switch (accion) {
                                                case "registrar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/recursos_tecnologicos_registrar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "buscar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/recursos_tecnologicos_buscar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar_donador": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/recursos_tecnologicos_consultar_por_donador.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar_categoria": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/recursos_tecnologicos_consultar_por_categoria.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/recursos_tecnologicos_consultar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                default: {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                    case "equipos_computacionales": {
                                        String accion = request.getParameter("accion");
                                        if (accion == null) {
                                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                            dispatcher.forward(request, response);
                                        } else {
                                            switch (accion) {
                                                case "registrar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/equipos_computacionales_registrar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "buscar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/equipos_computacionales_buscar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar_donados": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/equipos_computacionales_consultar_donados.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar_remunerados": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/equipos_computacionales_consultar_remunerados.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                default: {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                    case "solicitudes": {
                                        String accion = request.getParameter("accion");
                                        if (accion == null) {
                                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                            dispatcher.forward(request, response);
                                        } else {
                                            switch (accion) {
                                                case "buscar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/solicitudes_buscar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar_donador": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/solicitudes_consultar_por_donador.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar_donatario": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/solicitudes_consultar_por_donatario.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/solicitudes_consultar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                default: {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                    case "donaciones": {
                                        String accion = request.getParameter("accion");
                                        if (accion == null) {
                                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                            dispatcher.forward(request, response);
                                        } else {
                                            switch (accion) {
                                                case "registrar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donaciones_registrar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "buscar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donaciones_buscar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar_donador": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donaciones_consultar_por_donador.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar_donatario": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donaciones_consultar_por_donatario.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar_en_especie": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donaciones_consultar_por_especie.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar_economicas": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donaciones_consultar_economicas.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/donaciones_consultar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                default: {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                    case "intenciones": {
                                        String accion = request.getParameter("accion");
                                        if (accion == null) {
                                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                            dispatcher.forward(request, response);
                                        } else {
                                            switch (accion) {
                                                case "registrar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/intenciones_registrar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "buscar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/intenciones_buscar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/intenciones_consultar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                default: {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                    case "paqueteria": {
                                        String accion = request.getParameter("accion");
                                        if (accion == null) {
                                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                            dispatcher.forward(request, response);
                                        } else {
                                            switch (accion) {
                                                case "recoger": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/paqueteria_recoger.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "trasladar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/paqueteria_trasladar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "enviar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/paqueteria_enviar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "directo": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/paqueteria_directo.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "buscar_serial": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/paqueteria_buscar_serial.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/paqueteria_consultar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                default: {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                    case "notificaciones": {
                                        String accion = request.getParameter("accion");
                                        if (accion == null) {
                                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                            dispatcher.forward(request, response);
                                        } else {
                                            switch (accion) {
                                                case "crear": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/notificaciones_donamx_crear.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "buscar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/notificaciones_donamx_buscar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                case "consultar": {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/notificaciones_donamx_consultar.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                                default: {
                                                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                                    dispatcher.forward(request, response);
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                    case "perfil": {
                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/perfil.jsp");
                                        dispatcher.forward(request, response);
                                    }
                                    break;
                                    case "estadisticas": {
                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/estadisticas.jsp");
                                        dispatcher.forward(request, response);
                                    }
                                    break;
                                    case "servidor": {
                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/servidor.jsp");
                                        dispatcher.forward(request, response);
                                    }
                                    break;
                                    case "contacto": {
                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/contacto.jsp");
                                        dispatcher.forward(request, response);
                                    }
                                    break;
                                    case "mis_notificaciones": {
                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/notificaciones.jsp");
                                        dispatcher.forward(request, response);
                                    }
                                    break;
                                    case "cerrar_sesion": {
                                        Usuario user = (Usuario) session.getAttribute("user");
                                        manipula.ManipulaAutenticacion.cerrarSesionUsuario(user);
                                        session.invalidate();

                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                                        dispatcher.forward(request, response);
                                    }
                                    break;
                                    default: {
                                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/modulo_administrador/home.jsp");
                                        dispatcher.forward(request, response);
                                    }
                                    break;
                                }
                            }
                        } else {
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/templates/errores/no_autorizado.jsp");
                            dispatcher.forward(request, response);
                        }
                    } else {
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/templates/errores/no_autorizado.jsp");
                        dispatcher.forward(request, response);
                    }

                } else {
                    response.sendRedirect("autenticacion");
                    //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/iniciarSesion.jsp");
                    // dispatcher.forward(request, response);
                    // System.out.println("No autenticado");
                }
            } else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/templates/errores/session_expired.jsp");
                dispatcher.forward(request, response);
                //Session has expired - redirect to login.jsp
            }

        } else {
            response.sendRedirect("autenticacion");
            // System.out.println("No autenticado");
            //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/iniciarSesion.jsp");
            //dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
