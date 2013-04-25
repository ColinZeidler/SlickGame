
public class FighterPool {
	
	Fighter [] fighters;
	
	public FighterPool(){
		fighters = new Fighter[5];
		
		fighters[0] = fighterA();
		fighters[1] = fighterB();
		fighters[2] = fighterC();
		fighters[3] = fighterD();
		fighters[4] = fighterE();
	}
	
	public void loadFighters(){
		//code here to load fighters from a file.
	}
	
	public Fighter[] getFighters(){
		return fighters;
	}
	
	//NOTE ALL THESE ARE ARBITRARY, no numbers or names are significant yet
	private Fighter fighterA(){
		
		BasicAttack [] attacks = new BasicAttack[2];
		attacks[0] = new BasicAttack("Punch", 5, 10, 1, 1);
		attacks[1] = new BasicAttack("Kick", 15, 20, 0.5, 2);
		
		Ability [] abilities = new Ability[3];
		abilities[0] = new Ability("Blast", 30, 15, 0, true, false, false,false, 10);
		abilities[1] = new Ability("Wave", 30, 15, 0.5, false, true, true,false,40);
		abilities[2] = new Ability("Purify", 30, 15, 1, false, false, false,true,90);
		
		Block block = new Block(2,5);
		
		return new Fighter("Water", attacks, abilities, block, 1);
	}
	
	private Fighter fighterB(){
		BasicAttack [] attacks = new BasicAttack[2];
		attacks[0] = new BasicAttack("Punch", 5, 10, 1, 1);
		attacks[1] = new BasicAttack("Kick", 15, 20, 0.5, 2);
		
		Ability [] abilities = new Ability[3];
		abilities[0] = new Ability("RockSmash", 30, 15, 0, false, false, false, false,10);
		abilities[1] = new Ability("Ability 2B", 30, 15, 0.5, false, true, false, false,40);
		abilities[2] = new Ability("EarthQuake", 30, 15, 1, true, false, false, false,90);
		
		Block block = new Block(2,5);
		return new Fighter("Earth", attacks, abilities, block, 1);
	}
	
	private Fighter fighterC(){
		BasicAttack [] attacks = new BasicAttack[2];
		attacks[0] = new BasicAttack("Punch", 5, 10, 1, 1);
		attacks[1] = new BasicAttack("Kick", 15, 20, 0.5, 2);		
		
		Ability [] abilities = new Ability[3];
		abilities[0] = new Ability("Fireball", 30, 15, 0, false, false, false, false, 10);
		abilities[1] = new Ability("Heat", 30, 15, 0.5, false, false, true, false, 40);
		abilities[2] = new Ability("Erupt", 30, 15, 1, false, false, false, false,90);
		
		Block block = new Block(2,5);
		return new Fighter("Fire", attacks, abilities, block, 1);
	}
	
	private Fighter fighterD(){
		BasicAttack [] attacks = new BasicAttack[2];
		attacks[0] = new BasicAttack("Punch", 5, 10, 1, 1);
		attacks[1] = new BasicAttack("Kick", 15, 20, 0.5, 2);
		
		Ability [] abilities = new Ability[3];
		abilities[0] = new Ability("Gale", 30, 15, 0, false, false, true, false, 10);
		abilities[1] = new Ability("Gust", 30, 15, 0.5, false, true, false, false, 40);
		abilities[2] = new Ability("Tornado", 30, 15, 1, true, false, false, false, 90);
		
		Block block = new Block(2,5);
		return new Fighter("Air", attacks, abilities, block, 1);
	}
	
	private Fighter fighterE(){
		
		BasicAttack [] attacks = new BasicAttack[2];
		attacks[0] = new BasicAttack("Punch", 5, 10, 1, 1);
		attacks[1] = new BasicAttack("Kick", 15, 20, 0.5, 2);
		
		Ability [] abilities = new Ability[3];
		abilities[0] = new Ability("Ability ???", 30, 15, 0, true, false, false, false, 10);
		abilities[1] = new Ability("Ability ???", 30, 15, 0.5, false, true, false, false, 40);
		abilities[2] = new Ability("Ability ???", 30, 15, 1, false, false, true, false, 90);
		
		Block block = new Block(2,5);
		
		return new Fighter("Unknown", attacks, abilities, block, 1);
	}

}
