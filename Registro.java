import java.util.Date;

public class Registro {
    String cambio;
    Date fechaCambio;
    public Registro(String cambio, Date fechaCambio) {
        this.cambio = cambio;
        this.fechaCambio = fechaCambio;
    }
    public Registro() {
    }
    public String getCambio() {
        return cambio;
    }
    public void setCambio(String cambio) {
        this.cambio = cambio;
    }
    public Date getFechaCambio() {
        return fechaCambio;
    }
    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }
    @Override
    public String toString() {
        return "Registro [cambio=" + cambio + ", fechaCambio=" + fechaCambio + "]";
    }
}