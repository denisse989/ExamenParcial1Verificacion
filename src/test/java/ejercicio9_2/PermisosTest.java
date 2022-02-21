package ejercicio9_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.Date;

public class PermisosTest {
    ObtenerRole obtenerRole =Mockito.mock(ObtenerRole.class);
    VerificarUsuario verificarUsuario=Mockito.mock((VerificarUsuario.class));

    @Test
    public void verify(){
        Mockito.when(verificarUsuario.verificar("user","123")).thenReturn(true);
        Mockito.when(obtenerRole.rol("user")).thenReturn("CRUD");
        Permisos permisos=new Permisos(obtenerRole,verificarUsuario);
        String actualResult=permisos.obtenerRole("user","123");
        Date objDate=new Date();
        String expectedResult="PERMISSION ROLE : CRUD "+objDate;
        Assertions.assertEquals(expectedResult,actualResult,"Error");


    }
    @Test
    public void verify2(){
        Mockito.when(verificarUsuario.verificar("user1","123")).thenReturn(true);
        Mockito.when(obtenerRole.rol("user1")).thenReturn("C");
        Permisos permisos=new Permisos(obtenerRole,verificarUsuario);
        String actualResult=permisos.obtenerRole("user1","123");
        Date objDate=new Date();
        String expectedResult="PERMISSION ROLE : C "+objDate;
        Assertions.assertEquals(expectedResult,actualResult,"Error");


    }
    @Test
    public void verifyError(){
        Mockito.when(verificarUsuario.verificar("user","123")).thenReturn(true);
        Mockito.when(obtenerRole.rol("user")).thenReturn("CRUD");
        Permisos permisos=new Permisos(obtenerRole,verificarUsuario);
        String actualResult=permisos.obtenerRole("user","12");
        Date objDate=new Date();
        String expectedResult="Incorrect USER and PWD";
        Assertions.assertEquals(expectedResult,actualResult,"Error");


    }
}
