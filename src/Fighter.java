import org.newdawn.slick.*;

public class Fighter {
	
		//attributes every fighter has.
	
		private String name;
		
		private BasicAttack [] attacks;
		
		private String description;
		private Ability [] abilities;
		private Block block;
		private int life;
		private int speed;
		private int height;
		private boolean air;
		private int width; //width of the character model.
		private double xPos, yPos;
		private double ySpeed;	//used for acceleration
		private boolean disabled; //for Character effects
		private boolean moving;
		private Image groundAttack, airAttack; 
		private Image[] charWalk, charJump, charCast1, charCast2, charCast3;
		
		//Set images
		public void setWalk(String[] src) {
			charWalk = new Image[src.length];
			for (int i = 0; i < src.length; i++) {
				try {
					charWalk[i] = new Image(src[i]);
				} catch (SlickException e) {
					System.out.println(e);
				}
			}
		}
		
		public void setJump(String[] src) {
			charJump = new Image[src.length];
			for (int i = 0; i < src.length; i++) {
				try {
					charJump[i] = new Image(src[i]);
				} catch (SlickException e) {
					System.out.println(e);
				}
			}
		}
		
		public void setCast1(String[] src) {
			charCast1 = new Image[src.length];
			for (int i = 0; i < src.length; i++) {
				try {
					charCast1[i] = new Image(src[i]);
				} catch (SlickException e) {
					System.out.println(e);
				}
			}
		}
		
		public void setCast2(String[] src) {
			charCast2 = new Image[src.length];
			for (int i = 0; i < src.length; i++) {
				try {
					charCast2[i] = new Image(src[i]);
				} catch (SlickException e) {
					System.out.println(e);
				}
			}
		}
		
		public void setCast3(String[] src) {
			charCast3 = new Image[src.length];
			for (int i = 0; i < src.length; i++) {
				try {
					charCast3[i] = new Image(src[i]);
				} catch (SlickException e) {
					System.out.println(e);
				}
			}
		}
		
		//Get Images
		public Image[] getWalk() { return charWalk; }
		public Image[] getJump() { return charJump; }
		public Image[] getCast1() { return charCast1; }
		public Image[] getCast2() { return charCast2; }
		public Image[] getCast3() { return charCast3; }
		
		
		public Image getGroundAttack() {
			return groundAttack;
		}

		public void setGroundAttack(Image groundAttack) {
			this.groundAttack = groundAttack;
		}

		public Image getAirAttack() {
			return airAttack;
		}

		public void setAirAttack(Image airAttack) {
			this.airAttack = airAttack;
		}

		//set/get methods for Xpos Ypos
		public void setX(double x){	xPos = x;	}
		public void setY(double y){	yPos = y;	}
		
		//use for player acceleration in vertical and horizontal directions
		public void setYSpeed(double y){ ySpeed = y;}	//set a speed relative to how high the player will jump
		public double getYSpeed(){	return ySpeed;	}
		public void yStop(){	ySpeed = 0;	}
		
		public double getX(){	return xPos;	}
		public double getY(){	return yPos;	}
		
		//getting the basic Attacks
		public BasicAttack getAttack(int i){	return attacks[i];	}
		
		//getting the ability
		public Ability getAbility(int i){	return abilities[i];	}
		
		//getting the block
		public Block getBlock(){	return block;	}
		
		//disabled?
		public boolean isDisabled(){	return disabled;	}
		public void lockedDown(){	disabled=true;		}
		public void free(){	disabled=false;	}
		
		//get functions for name, life and speed, height, and selected
		public String getName(){	return name;	}
		public int getLife(){	return life;	}
		public int getSpeed(){	return speed;	}
		public int getHeight(){	return height;	}
		public int getWidth() {	return width;	}
		public String getDescription() { return description; }
		
		
		//getter and setting methods for air function.
		public boolean inAir(){		return air;		}
		public void startJump(){	air = true;		}
		public void endJump(){		air = false;	}
		
		//returning whether or not the player is disabled
		
		
		public Fighter(String n, BasicAttack [] a, Ability [] ab, Block b, int s){
			
			name=n;
			attacks = a;
			abilities = ab;
			block = b;
			
			life=100;	
			speed =s;
			disabled = false;
			
			//inAir is to tell if a player is jumping in air, to add jumping abilities/fights.
			air=false;
			
			//basic pre-set up x and y positions
			xPos =-99;
			yPos=-99;
			
			//to be changed for character model height;
			height = 250;
			
			width = 75; //just for testing changed to width of image?
			
			description = "This is a test, this is a test this is a test\nThis is s new line test. Testing testing testing";
		}
		
		public void hurt(int d){
			life-=d;
		}
		public boolean isMoving() { return moving; }

}
