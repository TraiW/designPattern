package vue;

import model.ChessGame;
import model.Coord;
import controler.ChessGameControler;
import model.Couleur;
import model.PieceIHM;

import java.util.Iterator;
import java.util.List;

import tools.Observable;
import tools.Observer;


/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD *
 *
 * Vue console d'un jeu d'échec
 * Cette classe est un observateur et le damier est mis à jour à chaque changement dans la classe métier
 */
public class ChessGameCmdLine implements Observer {

	private ChessGameControler chessGameControler;

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

    public void update(Observable o, Object arg) {
        System.out.println(chessGameControler.getMessage() + "\n");

        List<PieceIHM> piecesIHM = (List<PieceIHM>) arg;


        String[][] damier = new String[8][8];

        // création d'un tableau 2D avec les noms des pièces
        Iterator it = piecesIHM.iterator();
        while(it.hasNext()) {
            PieceIHM next = (PieceIHM) it.next();
            Couleur color = next.getCouleur();
            String stColor = (Couleur.BLANC == color ? "B_" : "N_" );
            String type = (next.getNamePiece()).substring(0, 2);
            if (next.getX() > 0 && next.getY() > 0)
                damier[next.getX()][next.getY()] = stColor + type;
        }

        // Affichage du tableau formatté
        String st = "    0     1     2     3     4     5    6     7 \n";
        for ( int i = 0; i < 8; i++) {
            st += i + " ";
            for ( int j = 0; j < 8; j++) {
                String nomPiece = damier[i][j];
                if (nomPiece != null) {
                    st += nomPiece + "  ";
                }
                else {
                    st += "____  ";
                }
            }
            st +="\n";
        }

        System.out.println(st);
    }
}
