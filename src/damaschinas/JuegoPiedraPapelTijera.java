package src.damaschinas;

public class JuegoPiedraPapelTijera {
    
    private VectorJugador jugadores;
    
    public JuegoPiedraPapelTijera(VectorJugador jugadores) {
        this.jugadores = jugadores;
    }
    
    public int jugarPiedraPapelYTijera(int idJugador1, int idJugador2) {
        int ganador = 0;
        String armaJugador1;
        String armaJugador2;
        while (ganador == 0) {
            armaJugador1 = asignarArma();
            armaJugador2 = asignarArma();
            ganador = determinarGanador(idJugador1, idJugador2, armaJugador1, armaJugador2);
            System.out.println(jugadores.getNombrePorId(idJugador1) + " saca " + armaJugador1 + " -vs- " + jugadores.getNombrePorId(idJugador2) + " saca " + armaJugador2);
        }
        System.out.println("El ganador de priedra papel y tijera fue " + jugadores.getNombrePorId(ganador));
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
    
    public int determinarGanador(int idJugador1, int idJugador2, String armaJugador1, String armaJugador2) {
        if (armaJugador1.equals("piedra") && armaJugador2.equals("tijera")) {
            return idJugador1;
        } else if (armaJugador2.equals("piedra") && armaJugador1.equals("tijera")) {
            return idJugador2;
        } else if (armaJugador2.equals("papel") && armaJugador1.equals("piedra")) {
            return idJugador2;
        } else if (armaJugador1.equals("papel") && armaJugador2.equals("piedra")) {
            return idJugador1;
        } else if (armaJugador1.equals("tijera") && armaJugador2.equals("papel")) {
            return idJugador1;
        } else if (armaJugador2.equals("tijera") && armaJugador1.equals("papel")) {
            return idJugador2;
        }
        return 0;
    }
}
