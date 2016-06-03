import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

	private Display display;
	public static Thread thread;

	private BufferStrategy bs;
	private static Graphics g;

	private Boolean isRunning = false;

	private static Handler handler;

	public static Rectangle startButton;

	public static Rectangle quitGame;

	public static Rectangle menu;

	public static Rectangle startNewGame;

	public static boolean startGame = false;
	public static boolean startHover = false;
	public static boolean quitHover = false;
	public static boolean startNewGameHover = false;

	public static boolean gameOver = false;
	public static boolean startNewGames = false;

	public static boolean moved = false;

	public static Player player;
	public static Enemy enemy;

	public static Life life1;
	public static Life life2;
	public static Life life3;

	public static int width;
	public static int height;

	public void init() {
		this.display = new Display();

		width = Display.width;
		height = Display.height;

		handler = new Handler();
		display.getCanvas().addKeyListener(new KeyInput(handler));

		handler.addObject(new Life(250 + 600, 10, 30, 30, ID.Life, handler));
		handler.addObject(new Life(200 + 600, 10, 30, 30, ID.Life, handler));
		handler.addObject(new Life(150 + 600, 10, 30, 30, ID.Life, handler));

		handler.addObject(player = new Player(50, 50, ID.Player, 50, 50, handler));

		handler.addObject(enemy = new Enemy(width / 2, height / 2, ID.Enemy, 50, 50, handler));

		display.getCanvas().addMouseListener(new Mouse());
		display.getCanvas().addMouseMotionListener(new Mouse());
	}

	private void render() {

		startButton = new Rectangle((width / 2) - 100, 100, 200, 50);

		quitGame = new Rectangle((width / 2) - 100, 200, 200, 50);

		menu = new Rectangle(width - 110, 0, 110, 50);

		startNewGame = new Rectangle((width / 2) - 100, height / 2 + 100, 200, 50);

		this.bs = this.display.getCanvas().getBufferStrategy();
		if (this.bs == null) {
			this.display.getCanvas().createBufferStrategy(2);
			return;
		}
		g = this.bs.getDrawGraphics();

		g.clearRect(0, 0, Display.width, Display.height);

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Display.width, Display.height);

		if (!startGame) {
			if (!startHover)
				g.setColor(Color.BLUE);
			else
				g.setColor(new Color(55, 117, 204));
			g.fillRect(startButton.x, startButton.y, startButton.width, startButton.height);
			g.setFont(new Font("Arial", Font.BOLD, 16));
			if (!startHover)
				g.setColor(Color.WHITE);
			else
				g.setColor(Color.BLACK);
			g.drawString("Start Game", startButton.x + 50, startButton.y + 30);
			if (!quitHover)
				g.setColor(Color.BLUE);
			else
				g.setColor(new Color(55, 117, 204));
			g.fillRect(quitGame.x, quitGame.y, quitGame.width, quitGame.height);
			g.setFont(new Font("Arial", Font.BOLD, 16));
			if (!quitHover)
				g.setColor(Color.WHITE);
			else
				g.setColor(Color.BLACK);
			g.drawString("Quit Game", quitGame.x + 55, quitGame.y + 30);
			g.setColor(Color.WHITE);

		} else {
			handler.render(g);

			/* Player Health */

			g.setColor(Color.GREEN);
			g.fillRect(50, 0, Player.health * 2, 50);

			int n = Player.health / 3;
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString(n + "%", 250, 40);

			/* LINE */

			g.drawLine(50, 50, width - 50, 50);
			g.drawLine(50, 50, 50, height - 50);
			g.drawLine(50, height - 50, width - 50, height - 50);
			g.drawLine(width - 50, 50, width - 50, height - 50);

			/* MENU */

			g.setColor(Color.BLACK);
			g.fillRect(menu.x, menu.y, menu.width, menu.height);
			g.setColor(Color.BLUE);
			g.setFont(new Font("Arial", Font.BOLD, 32));
			g.drawString("MENU", menu.x, menu.y + 35);

			/* GAME OVER */

			if (Player.health <= 0) {
				gameOver = true;
				gameOver();
			}
		}

		g.dispose();
		this.bs.show();
	}

	private void tick() {

		width = (int) ResizeListener.newSize.getWidth();
		height = (int) ResizeListener.newSize.getHeight();

		if (startGame)
			handler.tick();

		if (startNewGames) {
			moved = false;

			handler.removeObject(player);
			handler.removeObject(enemy);

			handler.addObject(new Life(250 + 600, 10, 30, 30, ID.Life, handler));
			handler.addObject(new Life(200 + 600, 10, 30, 30, ID.Life, handler));
			handler.addObject(new Life(150 + 600, 10, 30, 30, ID.Life, handler));

			handler.addObject(player = new Player(50, 50, ID.Player, 50, 50, handler));

			handler.addObject(enemy = new Enemy(width / 2, height / 2, ID.Enemy, 50, 50, handler));

			startNewGames = false;
		}
	}

	public static void gameOver() {

		if (startGame) {
			g.clearRect(0, 0, Display.width, Display.height);
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Display.width, Display.height);
			g.setColor(Color.BLUE);

			if (width == Display.width)
				g.setFont(new Font("Arial", Font.BOLD, 90));
			else
				g.setFont(new Font("Arial", Font.BOLD, 60));
			g.drawString("GAME OVER", width / 4, height / 2);

			if (!startNewGameHover)
				g.setColor(Color.BLUE);
			else
				g.setColor(new Color(55, 117, 204));
			g.fillRect(startNewGame.x, startNewGame.y, startNewGame.width, startNewGame.height);
			g.setFont(new Font("Arial", Font.BOLD, 16));
			if (!startNewGameHover)
				g.setColor(Color.WHITE);
			else
				g.setColor(Color.BLACK);
			g.drawString("Start New Game", startNewGame.x + 25, startNewGame.y + 30);
		}
	}

	@Override
	public void run() {
		this.init();

		int fps = 60;
		double timePerTick = 1000000000.0 / fps;
		double delta = 0;

		long now;
		long lastTime = System.nanoTime();

		while (isRunning) {
			now = System.nanoTime();

			delta += (now - lastTime) / timePerTick;
			lastTime = now;

			if (delta >= 1) {
				this.tick();
				this.render();
				delta--;
			}
		}
		this.stop();
	}

	public synchronized void start() {

		thread = new Thread(this);
		isRunning = true;
		thread.start();

	}

	public synchronized void stop() {
		try {
			isRunning = false;
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
