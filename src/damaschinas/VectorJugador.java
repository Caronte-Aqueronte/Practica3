package src.damaschinas;

import java.util.Scanner;

public class VectorJugador {

    private Jugador[] jugadores = new Jugador[10];
    private int contadorJugadores = 0;
    private Scanner scanner = new Scanner(System.in);

    public void addJugador() {
        String nombre;
        System.out.println("Ingrese el nombre del jugador");
        nombre = scanner.nextLine();
        addJugador((contadorJugadores + 1), nombre, 0, 0);
    }

    public void addJugador(int id, String nombre, int partidasGanadas, int partidasPerdidas) {
        if (contadorJugadores < 10) {
            jugadores[contadorJugadores] = new Jugador(id, nombre, partidasGanadas, partidasPerdidas);
            contadorJugadores++;
        } else {
            System.out.println("Error, maximo de jugadores alcanzado");
        }
    }

    public void mostrarReportes() {
        if (contadorJugadores > 0) {
            for (int x = 0; x < contadorJugadores; x++) {
                System.out.println("Nommbre de jugador: " + jugadores[x].getNombre() + " Partidas ganadas: " + jugadores[x].getPartidasGanadas() + " Partidas perdidas: " + jugadores[x].getPartidasPerdidas());
            }
        } else {
            System.out.println("No hay jugadores registrados");
        }
    }

    public void ordenarJugadores() {
        Jugador auxiliar;
        for (int i = 2; i < contadorJugadores; i++) {
            for (int j = 0; j < contadorJugadores - i; j++) {
                if (jugadores[j].getPartidasGanadas() > jugadores[j + 1].getPartidasGanadas()) {
                    auxiliar = jugadores[j];
                    jugadores[j] = jugadores[j + 1];
                    jugadores[j + 1] = auxiliar;
                }
            }
        }
    }

    public void mostrarJugadores() {
        if (contadorJugadores > 0) {
            for (int x = 0; x < contadorJugadores; x++) {
                System.out.println("Id del jugador: " + jugadores[x].getId() + " Nommbre de jugador: " + jugadores[x].getNombre());
            }
        } else {
            System.out.println("No hay jugadores registrados");
        }
    }

    public boolean verificarId(int id) {
        for (int x = 0; x < contadorJugadores; x++) {
            if (id == jugadores[x].getId()) {
                return true;
            }
        }
        return false;
    }

    public String getNombrePorId(int id) {
        for (int x = 0; x < contadorJugadores; x++) {
            if (id == jugadores[x].getId()) {
                return jugadores[x].getNombre();
            }
        }
        return "Jugador no registrado";
    }

    public void sumarVIsctorias(int id) {
        for (int x = 0; x < contadorJugadores; x++) {
            if (id == jugadores[x].getId()) {
                jugadores[x].setPartidasGanadas(jugadores[x].getPartidasGanadas() + 1);
            }
        }
    }

    public void sumarDerrotas(int id) {
        for (int x = 0; x < contadorJugadores; x++) {
            if (id == jugadores[x].getId()) {
                jugadores[x].setPartidasPerdidas(jugadores[x].getPartidasPerdidas() + 1);
            }
        }
    }

    public int getContadorJugadores() {
        return contadorJugadores;
    }

}
