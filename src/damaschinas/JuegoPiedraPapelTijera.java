package src.damaschinas;

public class JuegoPiedraPapelTijera {

    public int jugarPiedraPapelYTijera() {
        int ganador = 0;
        String armaJugador1;
        String armaJugador2;
        while (ganador == 0) {
            armaJugador1 = asignarArma();
            armaJugador2 = asignarArma();
            ganador = determinarGanador(armaJugador1, armaJugador2);
            System.out.println("Jugador 1 saca " + armaJugador1 + " jugador 2 saca " + armaJugador2);
        }
        System.out.println("El ganador de priedra papel y tijera fue " + ganador);
        return ganador;
    }

    public String asignarArma() {
        int random = (int) (Math.random() * ((3 - 1) + 1) + 1);
        switch (random) {
            case 1:
                return "piedra";
            case 2:
                return "papel";

            case 3:
                return "tijera";
        }
        return null;
    }

    public int determinarGanador(String armaJugador1, String armaJugador2) {
        if (armaJugador1.equals("piedra") && armaJugador2.equals("tijera")) {
            return 1;
        } else if (armaJugador2.equals("piedra") && armaJugador1.equals("tijera")) {
            return 2;
        } else if (armaJugador2.equals("papel") && armaJugador1.equals("piedra")) {
            return 2;
        } else if (armaJugador1.equals("papel") && armaJugador2.equals("piedra")) {
            return 1;
        } else if (armaJugador1.equals("tijera") && armaJugador2.equals("papel")) {
            return 1;
        } else if (armaJugador2.equals("tijera") && armaJugador1.equals("papel")) {
            return 2;
        }
        return 0;
    }
}
