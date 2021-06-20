package src.damaschinas;

import java.util.Scanner;

public class NuevaPartida {

    private VectorJugador vectorJugador;
    private Tablero tablero;
    private Scanner scanner = new Scanner(System.in);
    private JuegoPiedraPapelTijera piedraPapel;

    public NuevaPartida(VectorJugador vectorJugador) {
        this.vectorJugador = vectorJugador;
        piedraPapel = new JuegoPiedraPapelTijera(vectorJugador);
        pedirJugadores();
    }

    public void pedirJugadores() {
        if (vectorJugador.getContadorJugadores() >= 2) {
            int idPrimerJugador;
            int idSegundoJugador;
            vectorJugador.mostrarJugadores();
            System.out.println("Ingrese el id del primer jugador");
            idPrimerJugador = scanner.nextInt();
            System.out.println("Ingrese el id del segundo jugador");
            idSegundoJugador = scanner.nextInt();
            if (vectorJugador.verificarId(idPrimerJugador) == true && vectorJugador.verificarId(idSegundoJugador) == true) {
                if (idPrimerJugador != idSegundoJugador) {
                    decidirQuienEmpieza(idPrimerJugador, idSegundoJugador);
                } else {
                    System.out.println("No puedes jugar contra el mismo jugador");
                }
            } else {
                System.out.println("Id inexistente ingresado, verifique e intentelo mas tarde");
            }
        } else {
            System.out.println("Jugadores insuficientes para una partida");
        }
    }

    public void decidirQuienEmpieza(int idPrimerJugador, int idSegundoJugador) {

        String opcion = "";
        int primero = piedraPapel.jugarPiedraPapelYTijera(idPrimerJugador, idSegundoJugador);
        String nombrePrimero = vectorJugador.getNombrePorId(primero);
        int piezaSegundoJugador;
        int piezaPrimerJugador;

        while (!"1".equals(opcion) && !"2".equals(opcion)) {
            System.out.println(nombrePrimero + " Elige una pieza valida \n1) X\n2) O");
            opcion = scanner.next();
        }

        piezaPrimerJugador = Integer.valueOf(opcion);

        if (piezaPrimerJugador == 1) {
            piezaSegundoJugador = 2;
        } else {
            piezaSegundoJugador = 1;
        }

        tablero = new Tablero(Integer.valueOf(opcion));
        loopHastaTenerGanador(primero, idSegundoJugador, piezaPrimerJugador, piezaSegundoJugador);
    }

    public void loopHastaTenerGanador(int idPrimero, int idSegundo, int piezaPrimero, int piezaSegundo) {
        int turno = 1;
        int id;
        int pieza;
        int x;
        int y;
        boolean hayGanador = false;
        while (hayGanador == false) {
            if (turno % 2 != 0) {
                id = idPrimero;
                pieza = piezaPrimero;
            }else{
                id = idSegundo;
                pieza = piezaSegundo;
            }
            tablero.imprimirTablero();
            System.out.println(vectorJugador.getNombrePorId(id)+" elija la pieza que movera");
            System.out.print("X: ");
            x = scanner.nextInt();
            System.out.print("Y: ");
            y = scanner.nextInt(); 
            turno++;
        }

    }
}
