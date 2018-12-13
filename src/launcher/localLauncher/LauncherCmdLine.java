package launcher.localLauncher;

import controler.ChessGameControler;
import model.ChessGame;
import vue.ChessGameCmdLine;



/**
 * @author francoise.perrin
 * Lance l'exécution d'un jeu d'échec en mode console.
 */
public class LauncherCmdLine {

	public static void main(String[] args) {
        ChessGame chessGame = new ChessGame();
        ChessGameControler chessGameControler = new ChessGameControler(chessGame);
        ChessGameCmdLine chessGameCmdLine = new ChessGameCmdLine(chessGameControler);
        chessGame.attach(chessGameCmdLine);
        chessGameCmdLine.go();
	}

}
