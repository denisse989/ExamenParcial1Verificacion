package ejercicio9_2;
import java.util.Date;

public class Permisos {
    ObtenerRole obtenerRole;
    VerificarUsuario verificarUsuario;

    public Permisos(ObtenerRole obtenerRoleMock, VerificarUsuario verificarUsuarioMock) {
        this.obtenerRole = obtenerRoleMock;
        this.verificarUsuario = verificarUsuarioMock;
    }

    public String obtenerRole(String usuario, String pass){
        boolean verificar=verificarUsuario.verificar(usuario,pass);
        if(verificar){
            String rol=obtenerRole.rol(usuario);
            Date objDate=new Date();
            return "PERMISSION ROLE : "+rol+" "+ objDate.toString().trim();
        }else {
            return "Incorrect USER and PWD";
        }
    }
}
