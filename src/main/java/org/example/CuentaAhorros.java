package org.example;

public class CuentaAhorros extends Cuenta {
    private boolean activa;

    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.activa = saldo >= 10000;
    }

    @Override
    public void consignar(float monto) {
        if (activa) {
            super.consignar(monto);
            activa = saldo >= 10000;
        }
    }

    @Override
    public void retirar(float monto) {
        if (activa && monto <= saldo) {
            super.retirar(monto);
            activa = saldo >= 10000;
        }
    }

    @Override
    public void generarExtractoMensual() {
        if (numRetiros > 4) {
            comisionMensual += (numRetiros - 4) * 1000;
        }
        super.generarExtractoMensual();
        activa = saldo >= 10000;
    }

    @Override
    public String imprimir() {
        return super.imprimir() + ", Activa: " + activa;
    }
}
