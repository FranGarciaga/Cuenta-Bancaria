package org.example;

public class Cuenta {
    protected float saldo;
    protected int numConsignaciones = 0;
    protected int numRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;

    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    public Cuenta() {

    }

    public void consignar(float monto) {
        if (monto > 0) {
            saldo += monto;
            numConsignaciones++;
        }
    }

    public void retirar(float monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            numRetiros++;
        }
    }

    public double calcularInteresMensual(double principal, double tasaInteresAnual) {
        double tasaMensual = tasaInteresAnual / 12 / 100;
        System.out.println("Tasa mensual: " + tasaMensual); // Verifica la tasa mensual
        double resultado = principal * (1 + tasaMensual);
        System.out.println("Resultado: " + resultado); // Verifica el resultado calculado
        return resultado;
    }
    
    public void generarExtractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
    }

    private void calcularInteresMensual() {
    }

    public String imprimir() {
        return "Saldo: " + saldo + ", Comisión mensual: " + comisionMensual +
                ", Transacciones: " + (numConsignaciones + numRetiros);
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getNumConsignaciones() {
        return numConsignaciones;
    }

    public void setNumConsignaciones(int numConsignaciones) {
        this.numConsignaciones = numConsignaciones;
    }

    public int getNumRetiros() {
        return numRetiros;
    }

    public void setNumRetiros(int numRetiros) {
        this.numRetiros = numRetiros;
    }

    public float getTasaAnual() {
        return tasaAnual;
    }

    public void setTasaAnual(float tasaAnual) {
        this.tasaAnual = tasaAnual;
    }

    public float getComisionMensual() {
        return comisionMensual;
    }

    public void setComisionMensual(float comisionMensual) {
        this.comisionMensual = comisionMensual;
    }
}
