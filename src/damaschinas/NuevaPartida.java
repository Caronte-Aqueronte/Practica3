package src.damaschinas;

import java.util.Scanner;

public class NuevaPartida {

    private VectorJugador vectorJugador;
    private Tablero tablero = new Tablero();
    private Scanner scanner = new Scanner(System.in);
    private JuegoPiedraPapelTijera piedraPapel = new JuegoPiedraPapelTijera();

    public NuevaPartida(VectorJugador vectorJugador) {
        this.vectorJugador = vectorJugador;
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
        int jugarPiedraPapelYTijera = piedraPapel.jugarPiedraPapelYTijera();
    }
}
