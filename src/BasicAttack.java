
public class BasicAttack {
	
	private String type;
	private int damage;
	private int range;
	private double actionsPS;
	private double actionDuration;
	
	//get methods
	public int getDamage(){	return damage;	}
	public int getRange(){	return range;	}
	public double getDPS(){	return actionsPS;	}
	public double actionDuration(){	return actionDuration;	}
	
	public BasicAttack(String t, int d, int r, double a, double ad){
		
		//name of attack
		type=t;
		
		//damage it does
		damage =d;
		
		//range it has
		range =r;
		
		//dps
		actionsPS =a;
		
		//cast time might be removed???
		actionDuration =d;
	}

}
