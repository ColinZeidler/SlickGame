
public class Battle {
	
	private Fighter firstPlayer, secondPlayer;
	
	public Fighter getFirstPlayer(){	return firstPlayer;		}
	public Fighter getSecondPlayer(){	return secondPlayer;	}
	
	public Battle(Fighter a, Fighter b){
		firstPlayer = a;
		firstPlayer = b;
	}
	
	//do we need these?
	public void startGame(){
	}
	
	public void endGame(){
	}
	
	//player attack method, calculates to see if the fighters are within range of eachother, then calculates damage.
	public void PlayerAttack(Fighter attacker, Fighter defender){
		int damage;
		if(!attacker.inAir()){ //calculating whether or not damage is done.
			if((attacker.getX()+attacker.getAttack(0).getRange() >= defender.getX()-defender.getWidth())
					&&(attacker.getY()<defender.getY()+defender.getHeight())) 
				damage=attacker.getAttack(0).getDamage();
			else
				damage=0;
		}
		else{ //exact same as first but for in air basic attack
			if((attacker.getX()+attacker.getAttack(1).getRange() >= defender.getX()-defender.getWidth())
					&&(attacker.getY()<defender.getY()+defender.getHeight())) 
				damage=attacker.getAttack(1).getDamage();
			else
				damage=0;
		}
		defender.hurt(damage);
		
	}
	
	public void PlayerMove(Fighter player) {
		if(player.isMoving()) {
			if(player.getXSpeed() < 10)
				player.xAccel();
		}
		//vertical acceleration here
		player.setY(player.getY() - player.getYSpeed());
		if (player.getY() < 600) {
			player.yFall();
		} else {
			player.yStop();
			player.endJump();
		}
		//horizontal movement
		player.setX(player.getX() + (player.getXSpeed() * player.getxDir()));
		if (player.getXSpeed() != 0) {
			player.xDecel();
		}
	}
}
