package ejercicio9_3;

import java.util.Date;

public class Permisos {

    public String obtenerRole(String usuario, String pass){
        boolean verificar= VerificarUsuario.verificar(usuario,pass);
        if(verificar){
            String rol= ObtenerRole.rol(usuario);
            Date objDate=new Date();
            return "PERMISSION ROLE : "+rol+" "+ objDate.toString();
        }else {
            return "Incorrect USER and PWD";
        }
    }
}
