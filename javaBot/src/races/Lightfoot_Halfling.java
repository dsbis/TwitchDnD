package races;

import java.util.ArrayList;

import character.Ability;
import character.Ability_Bonus;

public class Lightfoot_Halfling implements Race
{

	private final Ability_Bonus primary = new Ability_Bonus(Ability.DEX, 2);
	private final Ability_Bonus secondary = new Ability_Bonus(Ability.CHA, 1);
	private final int speed = 25;
	private final String name = "Lightfoot Halfling";
	private ArrayList<String> feats;
	
	public Lightfoot_Halfling()
	{
		feats = new ArrayList<String>();
		feats.add("Lucky");
		feats.add("Brave");
		feats.add("Halfling Nimbleness");
		feats.add("Naturally Stealthy");
		
	}
	
	public Ability_Bonus Primary_Bonus() {
		return primary;
	}

	
	public Ability_Bonus Secondary_Bonus() {
		return secondary;
	}

	
	public ArrayList<String> Racial_Feats() {
		return feats;
	}

	
	public String Get_Name() {
		return name;
	}

	
	public int Get_Speed() {
		return speed;
	}

	
}
