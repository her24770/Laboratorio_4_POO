import java.util.List;

/**
 * La interfaz Climatizacion contiene los metodos base que los diferentes modelos
 * de vehiculos llegaran a implementar
 */
public interface Climatizacion {
    /**
     * Enciende o apaga el sistema
     * @param estado Estado encendido
     * @return Mensaje con el estado del sistema
     */
    public String encendido(boolean estado);

    /**
     * Ajusta la temperatura del sistema
     * @param estado Estado de el ajuste de la temperatura del sistema
     * @return Mensaje con la temperatyra acyual del sistema
     */
    public String ajusteTemperatura(boolean estado);

    /**
     * Activa el modo automatico para que se ajuste la temperatura exterior automaticamente
     * @param temperaturaAmbiente La temperatyra exterior en ese momento
     * @return Mensaje con el ajuste automatico de temperatura
     */
    public String modoAutomatico(int temperaturaAmbiente);

    /**
     * Ajusta el nivel del sistema de ventilacion
     * @param op Nivel general de ventilacion del sistema
     * @param subOp Nivel especifico segun la clase del vehiculo
     * @return Mensaje con el nivel de ventilacion seleccionado
     */
    public String nivelVentilacion(int op, int subOp);

    /**
     * Activa el modo Calefaccion
     * @param op Opcion de calefaccion seleccionada
     * @return Mensaje con el modo de calefaccion configurado
     */
    public String modoCalefaccion(int op);

    /**
     * Ajusta la direccion hacia dond se quiere el flujo de aire (Parabrisas, frontal, pies)
     * @param op Opcion de distribucion seleccionada
     * @return Mensaje con la distribucion del aire seleccionado
     */
    public String distribucionAire(int op);

    /**
     * Activa o apaga el Desempañador
     * @param estado Estado del Desempañador
     * @return Mensaje con el estado del desempanador
     */
    public String desempanador(boolean estado);

    /**
     * Guarda el historial de mantenimiento del  sistema
     * @return Mensaje con la lista de registros de mantenimiento
     */
    public List<Registro> historialMantenimiento();
}