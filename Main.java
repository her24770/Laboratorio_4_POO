import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Carro carro = new Carro(false, 20, 20, (short) 1, (short) 1, "Frontal", false, false);
        List<Registro> historial = new ArrayList<>();
        List<Date> citas = new ArrayList<>();
        DateTimeFormatter formatoCita = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        boolean bucleMenu = true;

        while (bucleMenu) {
            System.out.println("\nMENU");
            System.out.println("1. Encender/Apagar");
            System.out.println("2. Ajustar temperatura");
            System.out.println("3. Modo automático");
            System.out.println("4. Nivel de ventilación");
            System.out.println("5. Modo calefacción");
            System.out.println("6. Distribución de aire");
            System.out.println("7. Desempañador");
            System.out.println("8. Mantenimiento");
            System.out.println("9. Salir");
            System.out.print("Ingrese su opccion: ");
            String opMenu = sc.nextLine();

            if (!carro.getEncendido() && !opMenu.equals("1")) {
                System.out.println("El sistema está apagado");
                opMenu = "10";
            }
            
            switch (opMenu) {
                case "1":
                    System.out.println(carro.encendido(carro.getEncendido()));
                    if(carro.getEncendido()){
                        historial.add(new Registro("Encendido",new Date()));
                    }
                    else {
                        historial.add(new Registro("Apagado",new Date()));
                    }
                    
                    break;
                case "2":
                    boolean bucleMenu2 = true;
                    System.out.println("\nAjuse de temperaura: ");
                    System.out.println("1. Aumentar");
                    System.out.println("2. Disminuir");
                    while (bucleMenu2) {
                        System.out.print("Ingrese su opcion (0 para salir): ");
                        String op = sc.nextLine();
                        if (op.equals("1")) {
                            System.out.println(carro.ajusteTemperatura(true));
                            historial.add(new Registro("Se aumentó (1) la temperatura", new Date()));
                        } else if ( op.equals("2")) {
                            System.out.println(carro.ajusteTemperatura(false));
                            historial.add(new Registro("Se disminuyó (1) la temperatura", new Date())); 
                        }else if (op.equals("0")) {
                            bucleMenu2 = false;
                        } 
                        else {
                            System.out.println("Opción no válida");
                        }
                    }
                    break;
                case "3":
                    System.out.print("Ingrese la temperatura ambiente: ");
                    String ventilacionAmbiente = sc.nextLine();
                    System.out.println(carro.modoAutomatico(Integer.parseInt(ventilacionAmbiente)));
                    historial.add(new Registro("Cambio automático a " + carro.getTemperaturaVentilacion() + "°C" , new Date()));
                    break;
                case "4":
                System.out.println("\nNivel de ventilación: ");
                System.out.println("1. Nivel de ventilación");
                System.out.println("2. Direccion de ventilacion");
                System.out.println("3. Modo Eco Ventilación (Ahorro de energia)");
                System.out.print("Ingrese su opccion: ");
                String opMenu4= sc.nextLine();
                switch (opMenu4) {
                    case "1":
                        System.out.println("\n1. Primer nivel de ventilacion");
                        System.out.println("2. Segundo nivel de ventilacion");
                        System.out.println("3. Tercero nivel de ventilacion");
                        System.out.print("Ingrese su opccion: ");
                        String cambiarNivelVentilacion = sc.nextLine();
                        if(cambiarNivelVentilacion.equals("1" ) || cambiarNivelVentilacion.equals("2") || cambiarNivelVentilacion.equals("3" )){
                            System.out.println(carro.nivelVentilacion(1, Integer.parseInt(cambiarNivelVentilacion)));
                            if(carro.getNivelVentilacion() == 1){
                                historial.add(new Registro("Nivel 1 de ventilación", new Date()));
                            }
                            else if (carro.getNivelVentilacion() == 2){
                                historial.add(new Registro("Nivel 2 de ventilación", new Date()));
                            }
                            else {
                                historial.add(new Registro("Nivel 3 de ventilación", new Date()));
                            }
                        }else{
                            System.out.println("Opcion invalida");
                        }
                        
                        break;
                    case "2":
                        System.out.println("\n1. Parabrisas");
                        System.out.println("2. Frontal");
                        System.out.println("3. Pies");
                        System.out.print("Ingrese su opccion: ");
                        String cambiarDireccionVentilacion = sc.nextLine();
                        System.out.println(carro.nivelVentilacion(2, Integer.parseInt(cambiarDireccionVentilacion)));
                        if(carro.getVentilacionDireccional() == "parabrisas"){
                            historial.add(new Registro("Flujo hacia parabrisas", new Date()));
                        }
                        else if(carro.getVentilacionDireccional() == "frontal"){
                            historial.add(new Registro("Flujo desde frente", new Date()));
                        }
                        else{
                            historial.add(new Registro("Flujo hacia pies", new Date()));
                        }
                        break;
                    case "3":
                        System.err.println(carro.nivelVentilacion(3, 0));
                        historial.add(new Registro("Modo ECO activo", new Date()));
                        break;
                    default:
                        System.out.println("\nOpción no válida");
                        break;
                }
                    break;
                case "5":
                    System.out.println("\nModo calefacción: ");
                    System.out.println("1. Calefaccion Rapida");
                    System.out.println("2. Calefaccion de Asientos");
                    System.out.print("Ingrese su opccion: ");
                    String cambiarModoCalefaccion = sc.nextLine();
                    if(cambiarModoCalefaccion.equals("1")) {
                        // Guardar el nivel de temperatura actual
                        int nivelActual = carro.getNivelVentilacionAsiento();
                        
                        // Cambiar a un nivel de temperatura más alto (por ejemplo, nivel 3)
                        carro.nivelVentilacion(1, 3);
                        System.out.println("Calefacción rápida activada. Nivel de ventilación de asiento: 3");
                        
                        // Crear un temporizador para volver al nivel anterior después de 5 segundos (5000 ms)
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                carro.nivelVentilacion(1, nivelActual);
                                System.out.println("Calefacción rápida desactivada. Nivel de ventilación restaurado: " + nivelActual);
                                historial.add(new Registro("Calefacción rápida desactivada", new Date()));
                            }
                        }, 5000); // 5000 ms = 5 segundos
                        
                        historial.add(new Registro("Calefacción rápida activada", new Date()));
                    }
                    if (cambiarModoCalefaccion.equals("2")) {
                        System.out.println("\n1. Primer nivel de calefaccion de asientos");
                        System.out.println("2. Segundo nivel de calefaccion de asientos");
                        System.out.println("3. Tercero nivel de calefaccion de asientos");
                        System.out.print("Ingrese su opccion: ");
                        String cambiarTemperaturaAsientos = sc.nextLine();
                        System.out.println(carro.modoCalefaccion(Integer.parseInt(cambiarTemperaturaAsientos)));
                        if(carro.getNivelVentilacionAsiento() == 1){
                            historial.add(new Registro("Nivel 1 de ventilación", new Date()));
                        }
                        else if (carro.getNivelVentilacionAsiento() == 2){
                            historial.add(new Registro("Nivel 2 de ventilación", new Date()));
                        }
                        else {
                            historial.add(new Registro("Nivel 3 de ventilación", new Date()));
                        }
                    }
                    else {
                        System.out.println("Opción no válida");
                    }

                    
                    break;
                case "6":
                    System.out.println("\nDistribución de aire: ");
                    System.out.println("\n1. Parabrisas");
                    System.out.println("2. Frontal");
                    System.out.println("3. Pies");
                    System.out.print("Ingrese su opccion: ");
                    String cambiarDireccionVentilacion = sc.nextLine();
                    if (cambiarDireccionVentilacion.equals("1") || cambiarDireccionVentilacion.equals("2") || cambiarDireccionVentilacion.equals("3")) {
                        System.out.println(carro.distribucionAire(Integer.parseInt(cambiarDireccionVentilacion)));
                        if(carro.getVentilacionDireccional() == "parabrisas"){
                            historial.add(new Registro("Flujo hacia parabrisas", new Date()));
                        }
                        else if(carro.getVentilacionDireccional() == "frontal"){
                            historial.add(new Registro("Flujo desde frente", new Date()));
                        }
                        else{
                            historial.add(new Registro("Flujo hacia pies", new Date()));
                        }
                    } else {
                        System.out.println("Opción no válida");
                    }
                    break;
                case "7":
                    System.out.println(carro.desempanador(carro.getDesempanador()));
                    if(carro.getDesempanador()){
                        historial.add(new Registro("Desempañador activado", new Date()));
                    }
                    else{
                        historial.add(new Registro("Desempañador desactivado", new Date()));
                    }
                    
                    break;
                case "8":
                    System.out.println("\nMantenimiento\n\n"+
                    "1. Historial\n" + 
                    "2. Programar Mantenimiento");
                    System.out.print("Ingrese su opcion: ");
                    String manOp = sc.nextLine();

                    if(manOp.equals("1")){
                        for(Registro dato : historial){
                            System.out.print("\n" + dato.toString());
                        }
                    }
                    else if(manOp.equals("2")){
                        System.out.println("\nProgramación de Mantenimiento\n\n"+ 
                        "1. Agendar cita\n" +
                        "2. Ver citas agendadas");
                        System.out.print("Ingrese su opcion: ");

                        switch(sc.nextLine()){
                            case "1":
                                try{
                                    System.out.print("Escriba la fecha y hora que desea agendar (dd-MM-yyyy HH:mm): ");
                                    String cita = sc.nextLine();
                                    LocalDateTime fechaHora = LocalDateTime.parse(cita, formatoCita);
        
                                    //Convertir LocalDateTime a Date
                                    Date fechaCita = Date.from(fechaHora.atZone(ZoneId.systemDefault()).toInstant());
                                    citas.add(fechaCita);
                                    System.out.println("Cita agendada con exito :)");
                                } catch(Exception e){
                                    System.out.println("Datos ingresados no válidos");
                                }
                            break;

                            case "2":
                                int i = 1;

                                if(citas.isEmpty()){
                                    System.out.println("No tienes citas agendadas");
                                }
                                for(Date cita : citas){
                                    System.out.println( i + " : " + cita);
                                    i++;
                                }
                            break;

                            default:
                                System.out.println("Opcion no valida");
                            break;
                        }
                        
                    }
                    else{
                        System.out.println("Opcion inválida");
                    }
                    break;
                case "9":
                    bucleMenu = false;
                    System.out.println("Saliendo...");
                    break;
            
                case "10":

                    break;
                default:
                System.out.println("Opción no válida");
                    break;   
            }
        }
        sc.close();
    }
}



//validacion de integer en 4
//modo calefaccion op 5