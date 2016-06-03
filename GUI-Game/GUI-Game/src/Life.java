import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Life extends GameObject {

	Handler handler;

	public Life(int x, int y, int width, int height, ID id, Handler handler) {
		super(x, y, id, width, height);

		this.handler = handler;
	}

	@Override
	public void tick() {
		for (int i = 0; i < handler.object.size(); i++) {

			GameObject tempObject = handler.object.get(i);

			if (handler.object.size() > 3) {
				if (tempObject.getId() == ID.Life) {
					if (Player.health <= 0) {
						Player.health = 300;
						handler.object.removeFirst();
					}
				}
			} else{
				Game.gameOver();
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

}
