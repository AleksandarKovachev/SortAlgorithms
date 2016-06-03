import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class Mouse extends MouseAdapter {

	@Override
	public void mouseMoved(MouseEvent e) {
		super.mouseMoved(e);
		int mx = e.getX();
		int my = e.getY();

		if (mx > Game.startButton.x && mx < Game.startButton.x + Game.startButton.width && my > Game.startButton.y
				&& my < Game.startButton.y + Game.startButton.height) {
			Game.startHover = true;
		}
		if (!(mx > Game.startButton.x && mx < Game.startButton.x + Game.startButton.width && my > Game.startButton.y
				&& my < Game.startButton.y + Game.startButton.height)) {
			Game.startHover = false;
		}

		if (mx > Game.quitGame.x && mx < Game.quitGame.x + Game.quitGame.width && my > Game.quitGame.y
				&& my < Game.quitGame.y + Game.quitGame.height) {
			Game.quitHover = true;
		}

		if (!(mx > Game.quitGame.x && mx < Game.quitGame.x + Game.quitGame.width && my > Game.quitGame.y
				&& my < Game.quitGame.y + Game.quitGame.height)) {
			Game.quitHover = false;
		}

		if (!(mx > Game.startNewGame.x && mx < Game.startNewGame.x + Game.startNewGame.width && my > Game.startNewGame.y
				&& my < Game.startNewGame.y + Game.startNewGame.height)) {
			Game.startNewGameHover = false;
		}

		if ((mx > Game.startNewGame.x && mx < Game.startNewGame.x + Game.startNewGame.width && my > Game.startNewGame.y
				&& my < Game.startNewGame.y + Game.startNewGame.height)) {
			Game.startNewGameHover = true;
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);

		if (!Game.startGame) {

			int mx = e.getX();
			int my = e.getY();

			if (mx > Game.startButton.x && mx < Game.startButton.x + Game.startButton.width && my > Game.startButton.y
					&& my < Game.startButton.y + Game.startButton.height) {
				Game.startGame = true;
			}

			if (mx > Game.quitGame.x && mx < Game.quitGame.x + Game.quitGame.width && my > Game.quitGame.y
					&& my < Game.quitGame.y + Game.quitGame.height) {
				Display.frame.dispatchEvent(new WindowEvent(Display.frame, WindowEvent.WINDOW_CLOSING));
			}
		}
		if (Game.startGame) {
			int mx = e.getX();
			int my = e.getY();

			if (mx > Game.menu.x && mx < Game.menu.x + Game.menu.width && my > Game.menu.y
					&& my < Game.menu.y + Game.menu.height) {
				Game.startGame = false;
			}

			if (Game.gameOver) {
				if ((mx > Game.startNewGame.x && mx < Game.startNewGame.x + Game.startNewGame.width
						&& my > Game.startNewGame.y && my < Game.startNewGame.y + Game.startNewGame.height)) {
					Game.startGame = false;
					Game.startNewGames = true;
				}
			}
		}
	}

}
