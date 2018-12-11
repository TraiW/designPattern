package model;

public class PieceIHM implements PieceIHMs {
    private Pieces piece;

    public PieceIHM(Pieces piece) {
        this.piece = piece;
    }

    @Override
    public int getX() {
        return piece.getX();
    }

    @Override
    public int getY() {
        return piece.getY();
    }

    @Override
    public Couleur getCouleur() {
        return piece.getCouleur();
    }

    @Override
    public String getNamePiece() {
        return piece.getName();
    }

    @Override
    public String toString() {
        return piece.toString();
    }
}
