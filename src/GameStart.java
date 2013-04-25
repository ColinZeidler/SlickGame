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
		p2Char.draw((float)player2.getX(), (float)player2.getY());
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
		if(input.isKeyDown(Input.KEY_W) && !player1.inAir()) {
			//p1 Jump
			player1.startJump();
			player1.setYSpeed(10);
			player1.setY(player1.getY() - 1);
		}
		
		if(input.isKeyDown(Input.KEY_LEFT)) {
			//p2 move left
			player2.setX(player2.getX() - 0.4 * delta);
		}
		if(input.isKeyDown(Input.KEY_RIGHT)) {
			//p2 move right
			player2.setX(player2.getX() + 0.4 * delta);
		}
		if(input.isKeyDown(Input.KEY_UP) && !player2.inAir()) {
			//p2 jump
			player2.startJump();
			player2.setYSpeed(10);
			player2.setY(player2.getY() - 1);
		}
		
		if(player1.getY() < 500) {
			System.out.println(player1.getYSpeed());
			player1.setY(player1.getY() - player1.getYSpeed());		//move the player by their jump speed
			player1.setYSpeed(player1.getYSpeed() - 0.016*delta);	//apply the force of gravity on the player 9.8m/s / 60fps = 0.16
		} else { 
			player1.setYSpeed(0);
			player1.endJump();
		}
		
		if(player2.getY() < 500) {
			player2.setY(player2.getY() - player2.getYSpeed());		//move the player by their jump speed
			player2.setYSpeed(player2.getYSpeed() - 0.016*delta);	//apply the force of gravity on the player 9.8m/s / 60fps = 0.16
		} else {
			player2.setYSpeed(0);
			player2.endJump();
		}
	}

}
