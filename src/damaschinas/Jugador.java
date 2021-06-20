
package damaschinas;

public class Jugador {
    private int id;
    private String nombre;
    private int partidasGanadas;
    private int partidasPerdidas;

    public Jugador(int id, String nombre, int partidasGanadas, int partidasPerdidas) {
        this.id = id;
        this.nombre = nombre;
        this.partidasGanadas = partidasGanadas;
        this.partidasPerdidas = partidasPerdidas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }
    
}
