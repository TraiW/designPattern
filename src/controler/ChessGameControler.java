package controler;

import model.ChessGame;
import model.Coord;
import model.Couleur;

public class ChessGameControler implements ChessGameControlers {
    private ChessGame chessGame;

    public ChessGameControler(ChessGame chessGame) {
        this.chessGame = chessGame;
    }

    @Override
    public boolean move(Coord initCoord, Coord finalCoord) {
        return chessGame.move(initCoord.x, initCoord.y, finalCoord.x, finalCoord.y);
    }

    @Override
    public String getMessage() {
        return chessGame.getMessage();
    }

    @Override
    public boolean isEnd() {
        return chessGame.isEnd();
    }

    @Override
    public boolean isPlayerOK(Coord initCoord) {
        Couleur pieceColor = chessGame.getPieceColor(initCoord.x, initCoord.y);
        Couleur playerColor = chessGame.getColorCurrentPlayer();
        return pieceColor == playerColor;
    }

    @Override
    public String toString() {
        return chessGame.toString();
    }
}
