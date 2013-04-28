
import org.newdawn.slick.*;

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
	
	private Image [] abilityParticle = new Image[3];
	
	
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getDamage() {
		return damage;
	}


	public void setDamage(int damage) {
		this.damage = damage;
	}


	public int getRange() {
		return range;
	}


	public void setRange(int range) {
		this.range = range;
	}


	public int getManaCost() {
		return manaCost;
	}


	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}


	public double getChargeTime() {
		return chargeTime;
	}


	public void setChargeTime(double chargeTime) {
		this.chargeTime = chargeTime;
	}


	public boolean isStun() {
		return stun;
	}


	public void setStun(boolean stun) {
		this.stun = stun;
	}


	public boolean isDash() {
		return dash;
	}


	public void setDash(boolean dash) {
		this.dash = dash;
	}


	public boolean isKnockback() {
		return knockback;
	}


	public void setKnockback(boolean knockback) {
		this.knockback = knockback;
	}


	public boolean isHeal() {
		return heal;
	}


	public void setHeal(boolean heal) {
		this.heal = heal;
	}


	public Image[] getAbilityParticle() {
		return abilityParticle;
	}


	public void setAbilityParticle(Image[] abilityParticle) {
		this.abilityParticle = abilityParticle;
	}
}
