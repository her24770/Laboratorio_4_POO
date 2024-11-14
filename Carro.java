import java.util.List;

/**
 * La clase Carro implementa la interfaz Climatizacion y contiene los atributos
 * y metodos especificos para configurar el sistema de climatizacion.
 */
public class Carro implements Climatizacion{

    private boolean encendido;
    private int temperaturaVentilacion;
    private int temperaturaAsientos;
    private short nivelVentilacion;
    private short nivelVentilacionAsiento;
    private String ventilacionDireccional;
    private boolean ecoVentilacion;
    private boolean desempanador;

    /**
     * Constructor Vacio
     */
    public Carro() {
    }

    /**
     * Constructor Personalizado.
     *
     * @param encendido Estado del sistema de climatizacion
     * @param temperaturaVentilacion Temperatura del sistema en Celcius
     * @param temperaturaAsientos Temperatura en los asientos en Celcius
     * @param nivelVentilacion Nivel de ventilacion general seleccionado
     * @param nivelVentilacionAsiento Nivel de ventilacion en asientos seleccionado
     * @param ventilacionDireccional Direccion del flujo de aire seleccionado
     * @param ecoVentilacion Estado del modo de ventilacion ecologica
     * @param desempanador Estado del modo desempanador
     */
    public Carro(boolean encendido, int temperaturaVentilacion, int temperaturaAsientos, short nivelVentilacion,
            short nivelVentilacionAsiento, String ventilacionDireccional, boolean ecoVentilacion,
            boolean desempanador) {
        this.encendido = encendido;
        this.temperaturaVentilacion = temperaturaVentilacion;
        this.temperaturaAsientos = temperaturaAsientos;
        this.nivelVentilacion = nivelVentilacion;
        this.nivelVentilacionAsiento = nivelVentilacionAsiento;
        this.ventilacionDireccional = ventilacionDireccional;
        this.ecoVentilacion = ecoVentilacion;
        this.desempanador = desempanador;
    }

    /**
     *
     * @param estado Estado encendido
     * @return mensaje con el estado actual del sistema
     */
    @Override
    public String encendido(boolean estado) {
        encendido = !estado;
        return encendido ? "Sistema encendido." : "Sistema apagado.";
    }

    /**
     *
     * @param estado Estado de el ajuste de la temperatura del sistema
     * @return Mensaje con la temperatura actual
     */
    @Override
    public String ajusteTemperatura(boolean estado) {
        if (estado) {
            temperaturaVentilacion += 1;
        } else {
            temperaturaVentilacion -= 1;
        }
        return "La temperatura actual es: " + temperaturaVentilacion + "°C";
    }

    /**
     *
     * @param temperaturaAmbiente La temperatyra exterior en ese momento
     * @return Mensaje con el estado del modo automatico y la temperatura exterior
     */
    @Override
    public String modoAutomatico(int temperaturaAmbiente) {
        temperaturaVentilacion=temperaturaAmbiente;
        return "Modo automático activado. Temperatura ambiente: " + temperaturaAmbiente + "°C";
    }

    /**
     *
     * @param op Nivel general de ventilacion del sistema
     * @param subOp Nivel especifico segun la clase del vehiculo
     * @return Mensaje con el nivel de ventilacion y temperatura actual
     */
    @Override
    public String nivelVentilacion(int op, int subOp) {
        if (op==1) {
            nivelVentilacion=(short)subOp;
            if (subOp==1) {
                temperaturaVentilacion=20;
            } else if(subOp==2){
                temperaturaVentilacion=25;
            }else {
                temperaturaVentilacion=30;
            }
            return "Nivel de ventilación: " + nivelVentilacion+". Temperatura actual: "+temperaturaVentilacion;
        } else if(op==2) {
            if (subOp==1) {
                ventilacionDireccional="parabrisas";
            } else if(subOp==2){
                ventilacionDireccional="frontal";
            }else {
                ventilacionDireccional="pies";
            }
            return "Direccion de ventilaccion a: " + ventilacionDireccional;
            
        }else {
            ecoVentilacion=true;
            nivelVentilacion=(short)2;
            temperaturaVentilacion=25;
            return "Modo eco activado. Nivel de ventilación: " + nivelVentilacion+". Temperatura actual: "+temperaturaVentilacion;
        }
    }

    /**
     *
     * @param op Opcion de calefaccion seleccionada
     * @return Mensaje indicando el modo del calefaccion
     */
    @Override
    public String modoCalefaccion(int op) {
        if (op==1) {
            nivelVentilacionAsiento=(short)op;
            if (op==1) {
                temperaturaAsientos=15;
            } else if(op==2){
                temperaturaAsientos=20;
            }else {
                temperaturaAsientos=25;
            }
            return "Temperatura de Asientos actual: "+temperaturaAsientos;
        // throw new UnsupportedOperationException("Not supported yet.");
        }
        else {
            // Manejar otros casos de op
            return "Opción de calefacción no válida";
        }
    }

    /**
     *
     * @param op Opcion de distribucion seleccionada
     * @return Mensaje con la direccion de ventilacion configurado
     */
    @Override
    public String distribucionAire(int op) {
        if (op==1) {
            ventilacionDireccional="parabrisas";
        } else if(op==2){
            ventilacionDireccional="frontal";
        }else {
            ventilacionDireccional="pies";
        }
        return "Direccion de ventilaccion a: " + ventilacionDireccional;
    }

    /**
     *
     * @param estado Estado del Desempañador
     * @return Mensaje con el estado actual del desempanador
     */
    @Override
    public String desempanador(boolean estado) {
        desempanador = !estado;
        return desempanador ? "Desempañador encendido." : "Desempañador apagado.";
    }

    /**
     * Obtiene el historial de mantenimiento del sistema
     * @return Lista de registros de mantenimiento
     */
    @Override
    public List<Registro> historialMantenimiento() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @return Estado de encendido del sistema
     */
    public boolean isEncendido() {
        return encendido;
    }

    /**
     *
     * @param encendido Estado de encendido del sistema
     */
    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    /**
     *
     * @return La temperatura general en Celsius
     */
    public int getTemperaturaVentilacion() {
        return temperaturaVentilacion;
    }

    /**
     *
     * @param temperaturaVentilacion La temperatura general en Celsius
     */
    public void setTemperaturaVentilacion(int temperaturaVentilacion) {
        this.temperaturaVentilacion = temperaturaVentilacion;
    }

    /**
     *
     * @return Temperatura de los asientos
     */
    public int getTemperaturaAsientos() {
        return temperaturaAsientos;
    }

    /**
     *
     * @param temperaturaAsientos La temperatura de los asientos
     */
    public void setTemperaturaAsientos(int temperaturaAsientos) {
        this.temperaturaAsientos = temperaturaAsientos;
    }

    /**
     *
     * @return El nivel de ventilacion general del sistema
     */
    public short getNivelVentilacion() {
        return nivelVentilacion;
    }

    /**
     *
     * @param nivelVentilacion El nivel de ventilacion general del sistema
     */
    public void setNivelVentilacion(short nivelVentilacion) {
        this.nivelVentilacion = nivelVentilacion;
    }

    /**
     *
     * @return el nivel de ventilacion de los asientos
     */
    public short getNivelVentilacionAsiento() {
        return nivelVentilacionAsiento;
    }

    /**
     *
     * @param nivelVentilacionAsiento El nivel de ventilacion de los asientos
     */
    public void setNivelVentilacionAsiento(short nivelVentilacionAsiento) {
        this.nivelVentilacionAsiento = nivelVentilacionAsiento;
    }

    /**
     *
     * @return Direccion del flujo de aire seleccionado
     */
    public String getVentilacionDireccional() {
        return ventilacionDireccional;
    }

    /**
     *
     * @param ventilacionDireccional Direccion del flujo de aire seleccionado
     */
    public void setVentilacionDireccional(String ventilacionDireccional) {
        this.ventilacionDireccional = ventilacionDireccional;
    }

    /**
     *
     * @return Estado del sistema de ventilacion ecologica
     */
    public boolean isEcoVentilacion() {
        return ecoVentilacion;
    }

    /**
     *
     * @param ecoVentilacion Estado del sistema de ventilacion ecologica
     */
    public void setEcoVentilacion(boolean ecoVentilacion) {
        this.ecoVentilacion = ecoVentilacion;
    }

    /**
     *
     * @return Estado del desempanador
     */
    public boolean isDesempanador() {
        return desempanador;
    }

    /**
     *
     * @param desempanador Estado del Desempanador
     */
    public void setDesempanador(boolean desempanador) {
        this.desempanador = desempanador;
    }

    /**
     * @return Estado del objeto
     */
    @Override
    public String toString() {
        return "Carro [encendido=" + encendido + ", temperaturaVentilacion=" + temperaturaVentilacion
                + ", temperaturaAsientos=" + temperaturaAsientos + ", nivelVentilacion=" + nivelVentilacion
                + ", nivelVentilacionAsiento=" + nivelVentilacionAsiento + ", ventilacionDireccional="
                + ventilacionDireccional + ", ecoVentilacion=" + ecoVentilacion + ", desempanador=" + desempanador
                + "]";
    }
    
}