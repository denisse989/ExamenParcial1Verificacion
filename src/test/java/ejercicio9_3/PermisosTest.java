package ejercicio9_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Date;

public class PermisosTest {
   @BeforeAll
   public void static before(){
        MockedStatic<ObtenerRole>mokedObtener=Mockito.mockStatic(ObtenerRole.class);
        MockedStatic<VerificarUsuario>mokedVerificar=Mockito.mockStatic(VerificarUsuario.class);
        mokedVerificar.when(()->VerificarUsuario.verificar("user","123")).thenReturn(true);

    }

    @Test
    public void verify(){
        Permisos permisos=new ejercicio9_2.Permisos(obtenerRole,verificarUsuario);
        String actualResult=permisos.obtenerRole("user","123");
        Date objDate=new Date();
        String expectedResult="PERMISSION ROLE : CRUD "+objDate;
        Assertions.assertEquals(expectedResult,actualResult,"Error");


    }
    @Test
    public void verify2(){
        Mockito.when(verificarUsuario.verificar("user1","123")).thenReturn(true);
        Mockito.when(obtenerRole.rol("user1")).thenReturn("C");
        ejercicio9_2.Permisos permisos=new ejercicio9_2.Permisos(obtenerRole,verificarUsuario);
        String actualResult=permisos.obtenerRole("user1","123");
        Date objDate=new Date();
        String expectedResult="PERMISSION ROLE : C "+objDate;
        Assertions.assertEquals(expectedResult,actualResult,"Error");


    }
    @Test
    public void verifyError(){
        Mockito.when(verificarUsuario.verificar("user","123")).thenReturn(true);
        Mockito.when(obtenerRole.rol("user")).thenReturn("CRUD");
        ejercicio9_2.Permisos permisos=new Permisos(obtenerRole,verificarUsuario);
        String actualResult=permisos.obtenerRole("user","12");
        Date objDate=new Date();
        String expectedResult="Incorrect USER and PWD";
        Assertions.assertEquals(expectedResult,actualResult,"Error");


    }
}
