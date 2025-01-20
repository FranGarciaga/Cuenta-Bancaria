import org.example.Cuenta;
import org.example.CuentaAhorros;
import org.example.CuentaCorriente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testConsignar() {
        Cuenta cuenta = new Cuenta(5000, 2);
        cuenta.consignar(2000);
        assertEquals(7000, cuenta.getSaldo());
        assertEquals(1, cuenta.getNumConsignaciones());
    }

    @Test
    void testRetirar() {
        Cuenta cuenta = new Cuenta(5000, 2);
        cuenta.retirar(3000);
        assertEquals(2000, cuenta.getSaldo());
        assertEquals(1, cuenta.getNumRetiros());
    }

    @Test
    void testInteresMensual() {

        Cuenta cuenta = new Cuenta();

        double principal = 10000.0;
        double tasaInteresAnual = 12.0;
        double esperado = 10100.0;

        double real = cuenta.calcularInteresMensual(principal, tasaInteresAnual);

        Assertions.assertEquals(esperado, real, 0.01);
    }

    private double calcularInteresMensual(double principal, double tasaInteresAnual) {
        return principal;
    }
}

class CuentaAhorrosTest {

    @Test
    void testCuentaAhorrosActiva() {
        CuentaAhorros cuenta = new CuentaAhorros(15000, 3);
        assertTrue(cuenta.imprimir().contains("Activa: true"));
    }

    @Test
    void testCuentaAhorrosRetiro() {
        CuentaAhorros cuenta = new CuentaAhorros(15000, 3);
        cuenta.retirar(5000);
        assertEquals(10000, cuenta.getSaldo());
    }
}

class CuentaCorrienteTest {

    @Test
    void testSobregiro() {
        CuentaCorriente cuenta = new CuentaCorriente(5000, 2);
        cuenta.retirar(8000);
        assertEquals(0, cuenta.getSaldo());
        assertEquals(3000, cuenta.getSobregiro());
    }

    @Test
    void testConsignarReducirSobregiro() {

        CuentaCorriente cuenta = new CuentaCorriente(0.0F, 1000.0F);

        cuenta.consignarReducirSobregiro(1000.0);

        Assertions.assertEquals(0.0, cuenta.getSobregiro(), 0.01);

        Assertions.assertEquals(0.0, cuenta.getSaldo(), 0.01);
    }
}
