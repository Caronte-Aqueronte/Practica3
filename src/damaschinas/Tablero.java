package src.damaschinas;

public class Tablero {

    private Casilla[][] tablero = new Casilla[8][8];

    public Tablero(int piezaQueComienza) {
        int piezaSecundaria;
        if(piezaQueComienza == 1){
            piezaSecundaria = 2;
        }else{
            piezaSecundaria = 1;
        }
        llenarTablero(piezaQueComienza,piezaSecundaria);
    }

    public void llenarTablero(int piezaQueComienza, int piezSecundaria) {
        for (int x = 0; x < tablero.length; x++) {
            for (int y = 0; y < tablero[x].length; y++) {
                if (x >= 0 && x <= 2) {
                    if ((x + 1) % 2 == 0) {
                        if ((y + 1) % 2 == 0) {
                            tablero[x][y] = new Casilla(false, false, 0);
                        } else {
                            tablero[x][y] = new Casilla(true, true, piezSecundaria);
                        }
                    } else {
                        if ((y + 1) % 2 == 0) {
                            tablero[x][y] = new Casilla(true, true, piezSecundaria);
                        } else {
                            tablero[x][y] = new Casilla(false, false, 0);
                        }
                    }
                } else if (x >= 5 && x <= 7) {
                    if ((x + 1) % 2 == 0) {
                        if ((y + 1) % 2 == 0) {
                            tablero[x][y] = new Casilla(false, false, 0);
                        } else {
                            tablero[x][y] = new Casilla(true, true, piezaQueComienza);
                        }
                    } else {
                        if ((y + 1) % 2 == 0) {
                            tablero[x][y] = new Casilla(true, true, piezaQueComienza);
                        } else {
                            tablero[x][y] = new Casilla(false, false, 0);
                        }
                    }
                } else if ((x + 1) % 2 == 0) {
                    if ((y + 1) % 2 == 0) {
                        tablero[x][y] = new Casilla(false, false, 0);
                    } else {
                        tablero[x][y] = new Casilla(true, false, 0);
                    }
                } else {
                    if ((y + 1) % 2 == 0) {
                        tablero[x][y] = new Casilla(true, false, 0);
                    } else {
                        tablero[x][y] = new Casilla(false, false, 0);
                    }
                }
            }
        }
    }

    public void imprimirTablero() {
        for (int x = 0; x < tablero.length; x++) {
            for (int y = 0; y < tablero[x].length; y++) {
                System.out.print(tablero[x][y].getPieza());
            }
            System.out.println("");
        }
    }
}
