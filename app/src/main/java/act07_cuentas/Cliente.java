package act07_cuentas;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Cliente {
    private final String rfc;
    private String nombre;
    private String apellidos;
    private final Boolean esPersonaFisica;
    private String email;
    private Date fechaNacimiento;

    public String getRfc() {
        return rfc;
    }

    public Boolean getEsPersonaFisica() {
        return esPersonaFisica;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public Cliente(String rfc, String nombre, String apellidos, Boolean esPersonaFisica, String email, Date fechaNacimiento) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.esPersonaFisica = esPersonaFisica;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String formattedDate = (fechaNacimiento != null) ? dateFormat.format(fechaNacimiento) : "N/A";
        return "Cliente {" + 
            "\n\tRFC: " + rfc + 
            "\n\tNombre: " + nombre + 
            ((esPersonaFisica) ? "\n\tapellido: " + apellidos : "") + 
            "\n\tTipo de persona: " + ((esPersonaFisica) ? "Fisica" : "Moral") +
            "\n\tEmail: " + email +
            "\n\t"+ ((esPersonaFisica) ? "Fecha de nacimiento: " : "Fecha de fundación: ")  + formattedDate +
        "\n}";
    }
}
