package org.example;

public class CuentaCorriente extends Cuenta {
    private float sobregiro = 0;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
    }

    @Override
    public void retirar(float monto) {
        if (monto > 0) {
            if (monto <= saldo) {
                super.retirar(monto);
            } else {
                sobregiro += (monto - saldo);
                saldo = 0;
                numRetiros++;
            }
        }
    }

    @Override
    public void consignar(float monto) {
        if (sobregiro > 0) {
            if (monto >= sobregiro) {
                monto -= sobregiro;
                sobregiro = 0;
            } else {
                sobregiro -= monto;
                monto = 0;
            }
        }
        super.consignar(monto);
    }

    @Override
    public String imprimir() {
        return super.imprimir() + ", Sobregiro: " + sobregiro;
    }

    public float getSobregiro() {
        return sobregiro;
    }

    public void setSobregiro(float sobregiro) {
        this.sobregiro = sobregiro;
    }

    public void consignarReducirSobregiro(double v) {
    }
}
