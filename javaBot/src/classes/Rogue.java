package classes;

import java.util.ArrayList;

import character.Proficiencies;

public class Rogue implements Classes {

	private final Proficiencies[] saves = {Proficiencies.DEXTERITY, Proficiencies.INTELLIGENCE};
	private ArrayList<Proficiencies> skills, armor, weapons;
	private ArrayList<String> features;
	private int level;
	private Rogue_Type type;
	
	private enum Rogue_Type
	{
		ASSASSIN, THIEF, ARCANE_TRICKSTER
	}
	
	public Rogue(int g_level, Character_Classes c_class)
	{
		skills = new ArrayList<Proficiencies>();
		armor = new ArrayList<Proficiencies>();
		weapons = new ArrayList<Proficiencies>();
		level = g_level;
		features = new ArrayList<String>();
		switch(c_class)
		{
			case THIEF_ROGUE: type = Rogue_Type.THIEF;
		default:
			break;
		}
		
		this.Initialize_As_Rogue();
	}
	
	private void Initialize_As_Rogue()
	{
		armor.add(Proficiencies.LIGHT_ARMOR);
		weapons.add(Proficiencies.SIMPLE_WEAPONS);
		weapons.add(Proficiencies.HAND_CROSSBOW);
		weapons.add(Proficiencies.LONGSWORD);
		weapons.add(Proficiencies.RAPIER);
		weapons.add(Proficiencies.SHORTSWORD);
		skills.add(Proficiencies.THEIEVES_TOOLS);
		
		if(level >= 1)
		{
			features.add("Expertise");
			features.add("Sneak Attack");
			features.add("Thieves Cant");
		}
		if(level >= 2)
		{
			features.add("Cunning Action");
			
		}
		if(level >= 3)
		{
			switch(type)
			{
				case THIEF: this.Initialize_As_Thief();
				case ARCANE_TRICKSTER: break;
				case ASSASSIN: break;
				default: break;
			}
		}
		if(level >= 5)
		{
			features.add("Uncanny Dodge");
		}
	}
	
	private void Initialize_As_Thief()
	{
		if(level >= 3)
		{
			features.add("Fast Hands");
			features.add("Second-Story Work");
		}
	}
	
	public Proficiencies[] Get_Saving_Throws()
	{
		return saves;
	}
	public ArrayList<Proficiencies> Get_Skills() {
		return skills;
	}
	public String Get_Class_Name() {
		return "THIEF";
	}
	public boolean Has_Spells() {
		return false;
	}
	public ArrayList<Spell> Get_Spell_List() {
		return null;
	}
	public int[] Get_Spell_Slots() {
		return null;
	}
	public int Get_Hit_Dice() {
		return 8;
	}
	public ArrayList<Proficiencies> Get_Weapon_Profs() {
		return weapons;
	}
	public ArrayList<Proficiencies> Get_Armor_Profs() {
		return weapons;
	}
	public ArrayList<String> Get_Class_Features() {
		return features;
	}

}
