package vue;

import model.ChessGame;
import model.Coord;
import controler.ChessGameControler;

import java.util.Observable;
import java.util.Observer;


/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD *
 *
 * Vue console d'un jeu d'échec
 * Cette classe est un observateur et le damier est mis à jour à chaque changement dans la classe métier
 */
public class ChessGameCmdLine implements Observer {

	ChessGameControler chessGameControler;

	public ChessGameCmdLine(ChessGameControler chessGameControler) {
		this.chessGameControler = chessGameControler;
	}


	public void go() {

		System.out.print("\n Déplacement de 3,6 vers 3,4 = ");
		chessGameControler.move(new Coord(3,6), new Coord(3, 4));	// true
		System.out.println(chessGameControler.getMessage() + "\n");

		System.out.print("\n Déplacement de 3,4 vers 3,6 = ");
		chessGameControler.move(new Coord(3,4), new Coord(3, 6));	// false
		System.out.println(chessGameControler.getMessage() + "\n");

		System.out.print("\n Déplacement de 4,1 vers 4,3 = ");
		chessGameControler.move(new Coord(4, 1), new Coord(4, 3));	// true
		System.out.println(chessGameControler.getMessage() + "\n");

		System.out.print("\n Déplacement de 3,4 vers 3,4 = ");
		chessGameControler.move(new Coord(3, 4), new Coord(3, 4));	// false
		System.out.println(chessGameControler.getMessage() + "\n");

		System.out.print("\n Déplacement de 3,4 vers 4,3 = ");
		chessGameControler.move(new Coord(3, 4), new Coord(4, 3));	// true
		System.out.println(chessGameControler.getMessage() + "\n");
	}

    @Override
    public void update(Observable o, Object arg) {
	    System.out.println(chessGameControler);
	    System.out.println("HELLO");
    }

    public static void main(String[] args) {
        ChessGame chessGame = new ChessGame();
	    ChessGameControler chessGameControler = new ChessGameControler(chessGame);
	    ChessGameCmdLine cmdLine = new ChessGameCmdLine(chessGameControler);
	    cmdLine.go();
    }
}
