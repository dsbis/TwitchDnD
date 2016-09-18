package races;

import java.util.ArrayList;

import character.Ability;
import character.Ability_Bonus;

public class Human implements Race
{
	private final Ability_Bonus primary = new Ability_Bonus(Ability.STR, 2);
	private final Ability_Bonus secondary = new Ability_Bonus(Ability.INTL, 1);
	private final String name = "Human";
	private final int speed = 30;
	private ArrayList<String> feats;

	public Human()
	{
		feats = new ArrayList<String>();
		
		
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
