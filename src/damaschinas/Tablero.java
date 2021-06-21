package src.damaschinas;

public class Tablero {

    private Casilla[][] tablero = new Casilla[8][8];

    public Tablero(int piezaQueComienza) {
        int piezaSecundaria;
        if (piezaQueComienza == 1) {
            piezaSecundaria = 2;
        } else {
            piezaSecundaria = 1;
        }
        System.out.println(piezaQueComienza + " " + piezaSecundaria);
        llenarTablero(piezaQueComienza, piezaSecundaria);
    }
    /**
     * Aqui llenamos el tablero por primera vez en base a la pieza que elegio el usuario
     * @param piezaQueComienza
     * @param piezaSecundaria 
     */
    public void llenarTablero(int piezaQueComienza, int piezaSecundaria) {
        for (int x = 0; x < tablero.length; x++) {
            for (int y = 0; y < tablero[x].length; y++) {
                if (x >= 0 && x <= 2) {
                    if ((x + 1) % 2 == 0) {
                        if ((y + 1) % 2 == 0) {
                            tablero[x][y] = new Casilla(false, false, 0, y, x);
                        } else {
                            tablero[x][y] = new Casilla(true, true, piezaSecundaria, y, x);
                        }
                    } else {
                        if ((y + 1) % 2 == 0) {
                            tablero[x][y] = new Casilla(true, true, piezaSecundaria, y, x);
                        } else {
                            tablero[x][y] = new Casilla(false, false, 0, y, x);
                        }
                    }
                } else if (x >= 5 && x <= 7) {
                    if ((x + 1) % 2 == 0) {
                        if ((y + 1) % 2 == 0) {
                            tablero[x][y] = new Casilla(false, false, 0, y, x);
                        } else {
                            tablero[x][y] = new Casilla(true, true, piezaQueComienza, y, x);
                        }
                    } else {
                        if ((y + 1) % 2 == 0) {
                            tablero[x][y] = new Casilla(true, true, piezaQueComienza, y, x);
                        } else {
                            tablero[x][y] = new Casilla(false, false, 0, y, x);
                        }
                    }
                } else if ((x + 1) % 2 == 0) {
                    if ((y + 1) % 2 == 0) {
                        tablero[x][y] = new Casilla(false, false, 0, y, x);
                    } else {
                        tablero[x][y] = new Casilla(true, false, 0, y, x);
                    }
                } else {
                    if ((y + 1) % 2 == 0) {
                        tablero[x][y] = new Casilla(true, false, 0, y, x);
                    } else {
                        tablero[x][y] = new Casilla(false, false, 0, y, x);
                    }
                }
            }
        }
    }
    /**
     * Imprimimos el tablero
     */
    public void imprimirTablero() {
        System.out.println("");
        for (int x = 0; x < 8; x++) {
            System.out.print("  " + (x + 1) + "  ");
        }
        System.out.println("");
        for (int x = 0; x < tablero.length; x++) {
            for (int y = 0; y < tablero[x].length; y++) {
                System.out.print(tablero[x][y].getPieza());
            }
            System.out.print("  " + (x + 1));
            System.out.println("");
        }
    }
    /**
     * Aqui vemos en base a la clase casila si hay pieza en este lugar de la matriz
     * @param x
     * @param y
     * @param pieza
     * @return 
     */
    public boolean saberSiTienePiezaDelJugador(int x, int y, int pieza) {
        if (tablero[y][x].getNumPieza() == pieza) {
            return true;
        } else if (tablero[y][x].getNumPieza() == 0) {
            System.out.println("La casilla no tiene pieza");
            return false;
        }
        System.out.println("La pieza que esta en la casilla no es del jugador");
        return false;
    }
    /**
     * movemos la pieza y si no hay una ieza igual a la del jugador entonces se mueve o se come a la que esta aledaya a ella
     * @param posAntiguaX
     * @param posAntiguaY
     * @param posNuevaX
     * @param posNuevaY
     * @param pieza
     * @return 
     */
    public boolean moverPieza(int posAntiguaX, int posAntiguaY, int posNuevaX, int posNuevaY, int pieza) {
        if (tablero[posNuevaY][posNuevaX].getNumPieza() != pieza) {

            tablero[posAntiguaY][posAntiguaX].setNumPieza(0);
            tablero[posAntiguaY][posAntiguaX].setTienePieza(false);
            tablero[posAntiguaY][posAntiguaX].definirColor(0);

            tablero[posNuevaY][posNuevaX].setNumPieza(pieza);
            tablero[posNuevaY][posNuevaX].setTienePieza(true);
            tablero[posNuevaY][posNuevaX].definirColor(pieza);
            return true;

        }
        System.out.println("No se puede mover a esta pocision");
        return false;
    }
    /**
     * Aqui vemos quien es el ganador
     * @param idPrimerJugador
     * @param idSegundoJugador
     * @param pieza1
     * @param pieza2
     * @return 
     */
    public int verPiezaGanadora(int idPrimerJugador, int idSegundoJugador, int pieza1, int pieza2){
        int contadorPrimerJugador = 0;
        int contadorSegundoJugador = 0;
        for (int x = 0; x < tablero.length; x++) {
            for (int y = 0; y < tablero[x].length; y++) {
                if(tablero[x][y].getNumPieza() == pieza1){
                    contadorPrimerJugador++;
                }else if(tablero[x][y].getNumPieza() == pieza2){
                    contadorSegundoJugador++;
                }
            }  
        }
        if(contadorPrimerJugador == 0){
            return idSegundoJugador;
        }
        if(contadorSegundoJugador == 0){
            return idPrimerJugador;
        }
        return 0;
    }
}
