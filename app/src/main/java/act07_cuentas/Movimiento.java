package act07_cuentas;

import java.io.Serializable;
import java.util.*;

public class Movimiento implements Serializable {
    private String concepto;
    private double monto;

    @SuppressWarnings("unused")
    private Date fecha;
    private String tipo;

    private final Calendar calendar = Calendar.getInstance();

    /**
     * Constructor
     * 
     * @param concepto
     * @param monto
     * @param fecha
     * @param tipo
      */
    public Movimiento(String concepto, double monto, Date fecha, String tipo) {
        this.concepto = concepto;
        this.monto = monto;
        this.fecha = fecha;
        this.tipo = tipo;
        calendar.setTime(fecha);
    }

    /**
     * Getters y setters
      */
    public String getConcepto() {
        return this.concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getMonto() {
        return this.monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /**
     * Obtener fecha
      */
    public int getDay(){
        return calendar.get((Calendar.MONTH)+1);
    }

    public int getMonth(){
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getYear(){
        return calendar.get(Calendar.YEAR);
    }
    
    @Override
    public String toString() {
        return "Movimiento {" + 
            "\n\tConcepto: '" + getConcepto() + "'" +
            "\n\tMonto: " + getMonto() +
            "\n\tFecha: " + getDay() + "-" + getMonth() + "-" + getYear() +
            "\n\tTipo: " + getTipo() + 
        "\n}";
    }
}
