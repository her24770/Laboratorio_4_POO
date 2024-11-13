import java.util.Date;

/**
 * La clase Registro representa un registro de cambios realizados en el sistema de
 * climatización. Cada registro incluye el detalle del cambio y la fecha en la que se realizó.
 */
public class Registro {
    String cambio;
    Date fechaCambio;

    /**
     * Constructor Personalizado.
     *
     * @param cambio Descripción del cambio realizado.
     * @param fechaCambio Fecha en la que se realizó el cambio.
     */
    public Registro(String cambio, Date fechaCambio) {
        this.cambio = cambio;
        this.fechaCambio = fechaCambio;
    }

    /** Constructor Vacio
     */
    public Registro() {
    }

    /**
     * @return Descripcion del cambio realizado
     */
    public String getCambio() {
        return cambio;
    }

    /**
     *
     * @param cambio realizado
     */
    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    /**
     * @return fecha en la que se realizo el cambio
     */
    public Date getFechaCambio() {
        return fechaCambio;
    }

    /**
     *
     * @param fechaCambio fecha del cambio realizado
     */
    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    /**
     *
     * @return estado del objeto
     */
    @Override
    public String toString() {
        return "Registro [cambio=" + cambio + ", fechaCambio=" + fechaCambio + "]";
    }
}