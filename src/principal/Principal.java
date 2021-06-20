package src.principal;

import src.damaschinas.NuevaPartida;
import src.damaschinas.VectorJugador;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Principal damas = new Principal();
    }
    
    private Scanner scanner = new Scanner(System.in);

    private VectorJugador vectorJugador = new VectorJugador();
    private NuevaPartida nuevaPartida;

    public Principal() {
        menuPrincipal();
    }

    public void menuPrincipal() {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("");
            System.out.println("***\tBIENVENIDO\t***");
            System.out.println("1) Generar Tablero\n2) Ingresar Nuevo Jugador\n3) Reportes de partidas ganadas y perdias\n4) Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    nuevaPartida = new NuevaPartida(vectorJugador);
                    break;
                case 2:
                    vectorJugador.addJugador();
                    break;
                case 3:
                    vectorJugador.mostrarReportes();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }
}
