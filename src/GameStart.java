import org.newdawn.slick.*;
public class GameStart extends BasicGame{
	private Fighter player1, player2;
	private Battle battle;
	private Image p1Char, p2Char, bgImage;

	public GameStart(Fighter p1, Fighter p2, Battle b) {
		super("Hello World");
		player1 = p1;
		player2 = p2;
		battle = b;
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.drawString("Hello World", 100, 100);
		g.setColor(Color.gray);
		g.fillOval((int)player1.getX(), (int)player1.getY(), 20, 80);
		g.setColor(Color.orange);
		g.fillOval((int)player2.getX(), (int)player2.getY(), 20, 80);
		
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		player1.setX(50);
		player1.setY(500);

		player2.setX(700);
		player2.setY(500);
		
		gc.setMinimumLogicUpdateInterval(16);
		gc.setMaximumLogicUpdateInterval(16);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_D)) {
			//p1 move right
			player1.setX(player1.getX() + 0.4 * delta);
		}
		if(input.isKeyDown(Input.KEY_A)) {
			//p1 move left
			player1.setX(player1.getX() - 0.4 * delta);
		}
		if(input.isKeyDown(Input.KEY_W)) {
			//p1 Jump
		}
		
		if(input.isKeyDown(Input.KEY_LEFT)) {
			//p2 move left
			player2.setX(player2.getX() - 0.4 * delta);
		}
		if(input.isKeyDown(Input.KEY_RIGHT)) {
			//p2 move right
			player2.setX(player2.getX() + 0.4 * delta);
		}
		if(input.isKeyDown(Input.KEY_UP)) {
			//p2 jump
		}
		
	}

}
