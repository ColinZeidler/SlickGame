import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
public class GameStart extends BasicGame{
	private Fighter player1, player2;
	private Battle battle;
	private Image p1Char, p2Char, bgImage;

	public GameStart(Fighter p1, Fighter p2, Battle b) throws SlickException {
		super("Hello World");
		player1 = p1;
		player2 = p2;
		battle = b;
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		bgImage.draw(0, 0);
		g.setColor(Color.orange);
		g.fillOval((int)player2.getX(), (int)player2.getY(), 20, 80);
		p1Char.draw((float)player1.getX(), (float)player1.getY());
		
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		player1.setX(50);
		player1.setY(500);

		player2.setX(700);
		player2.setY(500);
		
		gc.setMinimumLogicUpdateInterval(16);
		gc.setMaximumLogicUpdateInterval(16);

		p1Char = new Image("res/filler.png");
		p2Char = new Image("res/filler.png");
		bgImage = new Image("res/Background.png");
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
