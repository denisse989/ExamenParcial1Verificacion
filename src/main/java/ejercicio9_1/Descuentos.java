package ejercicio9_1;

public class Descuentos {
    public int porcentajeDescuento(int sueldo) throws Exception {
        if(sueldo<1){
            throw new Exception("Salario no valido");
        }else {
            int descuento=0;
            if(sueldo<=2000){
                return sueldo;
            }if(sueldo<(sueldo*2)){
                descuento=sueldo*5/100;
                return sueldo-descuento;
            }else {
                descuento=sueldo*15/100;
                return sueldo-descuento;
            }
        }
    }
}
