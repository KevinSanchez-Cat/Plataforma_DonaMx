/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipula;

import config.conexion.*;
import model.Usuario;
import utils.GenericResponse;

/**
 *
 * @author por_s
 */
public class ManipulaUsuario {
  public static GenericResponse<Usuario> registrar(Usuario usuario){
      GenericResponse<Usuario> response=new GenericResponse<>();
      IConexion conexionDB= ConexionFactory.getConexion("MYSQL");
      if(conexionDB.conectar()==1){
          
      }else{
          response.setStatus(0);
       response.setResponseObject(usuario);
       response.setMensaje("Error al registrar usuario");
      }
      return response;
  }  
  
  public static GenericResponse<Usuario> actualizar(Usuario usuario){
      GenericResponse<Usuario> response=new GenericResponse<>();
      
      return response;
  }  
  
  public static GenericResponse<Usuario> eliminar(Usuario usuario){
      GenericResponse<Usuario> response=new GenericResponse<>();
      
      return response;
  }  
  
  public static GenericResponse<Usuario> encontrarId(Usuario usuario){
      GenericResponse<Usuario> response=new GenericResponse<>();
      
      return response;
  }
}
