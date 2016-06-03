import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Shot extends GameObject {

	Handler handler;

	public Shot(int x, int y, ID id, int width, int height, Handler handler) {
		super(x, y, id, width, height);
		this.handler = handler;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		shoot();
	}

	public void shoot() {
		
		System.out.println("hi");
//		for (int i = 0; i < handler.object.size(); i++) {
//			GameObject tempObject = handler.object.get(i);
//
//			if (tempObject.getId() == ID.Player) {
//				if (tempObject.x < this.x)
//					x -= 2.0;
//				if (tempObject.x > this.x)
//					x += 2.0;
//				if (tempObject.y < this.y)
//					y -= 2.0;
//				if (tempObject.y > this.y)
//					y += 2.0;
//			}
//		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

}
