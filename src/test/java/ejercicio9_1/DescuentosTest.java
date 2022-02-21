package ejercicio9_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DescuentosTest {
    @ParameterizedTest
    @CsvSource({
            "1,1",
            "2,2",
            "1999,1999",
            "2000,2000",
            "2001,1901",
            "3999,3800",
            "4000,3400",
            "4001,3401",

    })
    public void verifyDescuento(int sueldo,int expectedResult) throws Exception {
        Descuentos descuentos=new Descuentos();
        int actualResult=descuentos.porcentajeDescuento(sueldo);
        Assertions.assertEquals(expectedResult,actualResult,"Error datos incorrectos");

    }
    public void verifyDescuentoException() throws Exception {
        Descuentos descuentos=new Descuentos();
        Assertions.assertThrows(Exception.class,()->{descuentos.porcentajeDescuento(0);});

    }
}
