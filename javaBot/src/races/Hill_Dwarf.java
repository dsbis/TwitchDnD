package races;

import java.util.ArrayList;

import character.Ability;
import character.Ability_Bonus;


public class Hill_Dwarf implements Race
{

	private final Ability_Bonus primary = new Ability_Bonus(Ability.CON, 2);
	private final Ability_Bonus secondary = new Ability_Bonus(Ability.WIS, 1);
	private final int speed = 25;
	private final String name = "Hill Dwarf";
	private ArrayList<String> feats;
	
	public Hill_Dwarf()
	{
		feats = new ArrayList<String>();
		feats.add("Darkvision");
		feats.add("Dwarven Resiliance");
		feats.add("Dwarven Combat Training");
		feats.add("Stonecunning");
		feats.add("Dwarven Toughness");
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