import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

	Handler handler;

	public static int health = 300;

	public Player(int x, int y, ID id, int width, int height, Handler handler) {
		super(x, y, id, width, height);

		this.handler = handler;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;

		if (x <= 50)
			x = 50;
		if (x >= Game.width - 100)
			x = Game.width - 100;
		if (y <= 50)
			y = 50;
		if (y >= Game.height - 100)
			y = Game.height - 100;

		collision();
	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {

			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Enemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					if (health >= 0) {
						health--;
					}
				}
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
		return new Rectangle(x, y, width, height);
	}
}
