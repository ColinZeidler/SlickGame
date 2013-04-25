
public class Ability {
	
	//basic damage, name and range
	private String name;
	private int damage;
	private int range;
	private int manaCost;
	private double chargeTime;
	
	private boolean stun;
	private boolean dash;
	private boolean knockback;
	private boolean heal;
	
	
	public Ability(String n, int d, int r, double c, boolean st, boolean da, boolean kn, boolean h, int mc){
		
		//name of the ability
		name = n;
		
		//damage of the ability
		damage = d;
		
		//range
		range = r;
		
		chargeTime = c;
		//add booleans for utility???
		
		stun = st;
		dash =da;
		knockback =kn;
		heal = h;
		
		manaCost =mc;
	}
}
