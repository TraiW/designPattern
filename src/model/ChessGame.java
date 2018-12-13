package model;


import tools.Observable;
import tools.Observer;

import java.util.ArrayList;
import java.util.List;

public class ChessGame implements BoardGames, Observable {
    private Echiquier echiquier;
    private List<Observer> observers;


    public ChessGame() {
        echiquier = new Echiquier();
        observers = new ArrayList<>();
    }

    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        boolean ret = false;
        if (echiquier.isMoveOk(xInit, yInit, xFinal, yFinal)) {
            ret = echiquier.move(xInit, yInit, xFinal, yFinal);
            if (ret) {
                echiquier.switchJoueur();
            }
        }
        this.notifyObservers(echiquier.getPiecesIHM());
        return ret;
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
    public void attach(Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        }
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Object arg) {
        for (Observer o: observers) {
            o.update(this, arg);
        }
    }
}
