package model;


import java.util.Observable;
import java.util.Observer;

public class ChessGame extends Observable implements BoardGames {
    private Echiquier echiquier;


    public ChessGame() {
        echiquier = new Echiquier();
    }

    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        if (echiquier.isMoveOk(xInit, yInit, xFinal, yFinal)) {
            boolean ret = echiquier.move(xInit, yInit, xFinal, yFinal);
            if (ret) {
                echiquier.switchJoueur();
            }
            return ret;
        }
        return false;
    }

    @Override
    public boolean isEnd() {
        return echiquier.isEnd();
    }

    @Override
    public String getMessage() {
        return echiquier.getMessage();
    }

    @Override
    public Couleur getColorCurrentPlayer() {
        return echiquier.getColorCurrentPlayer();
    }

    @Override
    public Couleur getPieceColor(int x, int y) {
        return echiquier.getPieceColor(x, y);
    }

    @Override
    public String toString() {
        return echiquier.toString() + this.getMessage();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        this.notifyObservers(echiquier.getPiecesIHM());
    }

    @Override
    public void notifyObservers(Object arg) {
        super.setChanged();
        super.notifyObservers(arg);
    }
}
