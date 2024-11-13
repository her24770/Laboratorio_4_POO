import java.util.List;

public class Carro implements Climatizacion{

    private boolean encendido;
    private int temperaturaVentilacion;
    private int temperaturaAsientos;
    private short nivelVentilacion;
    private short nivelVentilacionAsiento;
    private String ventilacionDireccional;
    private boolean ecoVentilacion;
    private boolean desempanador;
    
    public Carro() {
    }

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

    @Override
    public String encendido(boolean estado) {
        encendido = !estado;
        return encendido ? "Sistema encendido." : "Sistema apagado.";
    }

    @Override
    public String ajusteTemperatura(boolean estado) {
        if (estado) {
            temperaturaVentilacion += 1;
        } else {
            temperaturaVentilacion -= 1;
        }
        return "La temperatura actual es: " + temperaturaVentilacion + "°C";
    }

    @Override
    public String modoAutomatico(int temperaturaAmbiente) {
        temperaturaVentilacion=temperaturaAmbiente;
        return "Modo automático activado. Temperatura ambiente: " + temperaturaAmbiente + "°C";
    }

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

    @Override
    public String modoCalefaccion(int op) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

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

    @Override
    public String desempanador(boolean estado) {
        desempanador = !estado;
        return desempanador ? "Desempañador encendido." : "Desempañador apagado.";
    }

    @Override
    public List<Registro> historialMantenimiento() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public int getTemperaturaVentilacion() {
        return temperaturaVentilacion;
    }

    public void setTemperaturaVentilacion(int temperaturaVentilacion) {
        this.temperaturaVentilacion = temperaturaVentilacion;
    }

    public int getTemperaturaAsientos() {
        return temperaturaAsientos;
    }

    public void setTemperaturaAsientos(int temperaturaAsientos) {
        this.temperaturaAsientos = temperaturaAsientos;
    }

    public short getNivelVentilacion() {
        return nivelVentilacion;
    }

    public void setNivelVentilacion(short nivelVentilacion) {
        this.nivelVentilacion = nivelVentilacion;
    }

    public short getNivelVentilacionAsiento() {
        return nivelVentilacionAsiento;
    }

    public void setNivelVentilacionAsiento(short nivelVentilacionAsiento) {
        this.nivelVentilacionAsiento = nivelVentilacionAsiento;
    }

    public String getVentilacionDireccional() {
        return ventilacionDireccional;
    }

    public void setVentilacionDireccional(String ventilacionDireccional) {
        this.ventilacionDireccional = ventilacionDireccional;
    }

    public boolean isEcoVentilacion() {
        return ecoVentilacion;
    }

    public void setEcoVentilacion(boolean ecoVentilacion) {
        this.ecoVentilacion = ecoVentilacion;
    }

    public boolean isDesempanador() {
        return desempanador;
    }

    public void setDesempanador(boolean desempanador) {
        this.desempanador = desempanador;
    }

    @Override
    public String toString() {
        return "Carro [encendido=" + encendido + ", temperaturaVentilacion=" + temperaturaVentilacion
                + ", temperaturaAsientos=" + temperaturaAsientos + ", nivelVentilacion=" + nivelVentilacion
                + ", nivelVentilacionAsiento=" + nivelVentilacionAsiento + ", ventilacionDireccional="
                + ventilacionDireccional + ", ecoVentilacion=" + ecoVentilacion + ", desempanador=" + desempanador
                + "]";
    }
    
}