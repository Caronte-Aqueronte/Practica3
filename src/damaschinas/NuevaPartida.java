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
            System.out.println("\nIngrese el id del primer jugador");
            idPrimerJugador = scanner.nextInt();
            System.out.println("\nIngrese el id del segundo jugador");
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
            System.out.println(nombrePrimero + " elige una pieza valida \n1) X\n2) O");
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
        int idGanador = 0;
        int idPerdedor = 0;
        while (idGanador == 0) {
            if (turno % 2 != 0) {
                id = idPrimero;
                pieza = piezaPrimero;
            } else {
                id = idSegundo;
                pieza = piezaSegundo;
            }
            repetirHastaQueIngresePosicionConPiezaDelJugador(id, pieza);
            //turno++;
            idGanador = tablero.verPiezaGanadora(idPrimero, idSegundo, piezaPrimero, piezaSegundo);
            if(idGanador == idPrimero){
                idPerdedor = idSegundo;
            }else if(idGanador == idSegundo){
                idPerdedor = idPrimero;
            }
        }
        System.out.println("El ganador es "+vectorJugador.getNombrePorId(idGanador));
        vectorJugador.sumarVIsctorias(idGanador);
        vectorJugador.sumarDerrotas(idPerdedor);
    }

    public void repetirHastaQueIngresePosicionConPiezaDelJugador(int id, int pieza) {
        int x = 0;
        int y = 0;
        boolean bandera = false;
        tablero.imprimirTablero();
        while (bandera == false) {
            while (bandera == false) {
                System.out.println("\n" + vectorJugador.getNombrePorId(id) + " elija la pieza que movera");
                System.out.print("\nX: ");
                x = scanner.nextInt();
                System.out.print("Y: ");
                y = scanner.nextInt();
                if ((x - 1) >= 0 && (x - 1) <= 7 && (y - 1) >= 0 && (y - 1) <= 7) {
                    bandera = tablero.saberSiTienePiezaDelJugador((x - 1), (y - 1), pieza);
                } else {
                    System.out.println("\nPosicion inexistente");
                }
            }
            bandera = moverPieza(x, y, pieza);
        }
    }

    public boolean moverPieza(int posPiezaX, int posPiezaY, int pieza) {
        int x;
        int y;
        boolean bandera = false;
        while (bandera == false) {
            tablero.imprimirTablero();
            System.out.println("\nIngrese la posicion a donde movera su pieza\t-1)Cambiar de pieza");
            System.out.print("\nX: ");
            x = scanner.nextInt();
            System.out.print("Y: ");
            y = scanner.nextInt();
            if (x == -1) {
                return false;
            }
            if ((x - 1) >= 0 && (x - 1) <= 7 && (y - 1) >= 0 && (y - 1) <= 7) {
                if ((y == (posPiezaY + 1) && (x == (posPiezaX + 1) || x == (posPiezaX - 1))) || (y == (posPiezaY - 1) && (x == (posPiezaX - 1) || x == (posPiezaX + 1)))) {
                    bandera = tablero.moverPieza(posPiezaX - 1, posPiezaY - 1, x - 1, y - 1, pieza);
                } else {
                    System.out.println("No se puede mover a esta poscion");
                }
            } else {
                System.out.println("\nPosicion inexistente");
            }
        }
        return true;
    }
    public void verGanador(){
        
    }
}
