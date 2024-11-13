import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Carro carro = new Carro(false, 20, 20, (short) 1, (short) 1, "Frontal", false, false);
        List<Registro> historial = new ArrayList<>();
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

            if (!carro.isEncendido() && !opMenu.equals("1")) {
                System.out.println("El sistema está apagado");
                opMenu = "10";
            }
            
            switch (opMenu) {
                case "1":
                    System.out.println(carro.encendido(carro.isEncendido()));
                    break;
                case "2":
                    System.out.println("\nAjuse de temperaura: ");
                    System.out.println("1. Aumentar");
                    System.out.println("2. Disminuir");
                    while (bucleMenu) {
                        System.out.print("Ingrese su opccion (0 para salir): ");
                        String op = sc.nextLine();
                        if (op.equals("1")) {
                            System.out.println(carro.ajusteTemperatura(true));
                        } else if ( op.equals("2")) {
                            System.out.println(carro.ajusteTemperatura(false)); 
                        }else if (op.equals("0")) {
                            bucleMenu = false;
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
                        System.out.println("\n1. Primer nivel de ventailacion");
                        System.out.println("2. Segundo nivel de ventailacion");
                        System.out.println("3. Tercero nivel de ventailacion");
                        System.out.print("Ingrese su opccion: ");
                        String cambiarNivelVentilacion = sc.nextLine();
                        System.out.println(carro.nivelVentilacion(1, Integer.parseInt(cambiarNivelVentilacion)));
                        break;
                    case "2":
                        System.out.println("\n1. Parabrisas");
                        System.out.println("2. Frontal");
                        System.out.println("3. Pies");
                        System.out.print("Ingrese su opccion: ");
                        String cambiarDireccionVentilacion = sc.nextLine();
                        System.out.println(carro.nivelVentilacion(2, Integer.parseInt(cambiarDireccionVentilacion)));
                        break;
                    case "3":
                        System.err.println(carro.nivelVentilacion(3, 0));
                        break;
                    default:
                        System.out.println("\nOpción no válida");
                        break;
                }
                    break;
                case "5":
                    
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
                    } else {
                        System.out.println("Opción no válida");
                    }
                    break;
                case "7":
                    
                    break;
                case "8":
                    
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