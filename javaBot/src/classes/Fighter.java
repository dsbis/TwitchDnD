package classes;

import java.util.ArrayList;

import character.Proficiencies;

public class Fighter implements Classes {

	private final Proficiencies[] saves = {Proficiencies.STRENGTH, Proficiencies.CONSTITUTION};
	private ArrayList<Proficiencies> skills, weapons, armor;
	private ArrayList<String> features;
	private Fighter_Type type;
	
	private enum Fighter_Type
	{
		CHAMPION, BATTLEMASTER, ELDRITCHKNIGHT,
	};
	
	private int level;
	
	public Fighter(int g_level, Character_Classes c_class)
	{
		skills = new ArrayList<Proficiencies>();
		armor = new ArrayList<Proficiencies>();
		weapons = new ArrayList<Proficiencies>();
		level = g_level;
		features = new ArrayList<String>();
		if(c_class == Character_Classes.CHAMPION_FIGHTER)
		{
			type = Fighter_Type.CHAMPION;
		}
		this.Initialize_As_Fighter();
		
	}
	
	public void Initialize_As_Fighter()
	{
		armor.add(Proficiencies.SHIELDS);
		armor.add(Proficiencies.LIGHT_ARMOR);
		armor.add(Proficiencies.MEDIUM_ARMOR);
		armor.add(Proficiencies.HEAVY_ARMOR);
		weapons.add(Proficiencies.SIMPLE_WEAPONS);
		weapons.add(Proficiencies.MARTIAL_WEAPONS);
		
		if(level >= 1)
		{
			features.add("Fighting Style: Defense");
			features.add("Second Wind");
		}
		if(level >= 2)
		{
			features.add("Action Surge");
		}
		if(level >= 3)
		{
			switch(type)
			{
				case CHAMPION: this.Initialize_As_Champion();
				case ELDRITCHKNIGHT: ;
				case BATTLEMASTER: ;
			}
		}
		if(level >= 5)
		{
			features.add("Extra Attack");
		}
	}
	
	private void Initialize_As_Champion()
	{
		if(level >= 3)
		{
			features.add("Improved Critical");
		}
	}
	
	public Proficiencies[] Get_Saving_Throws()
	{
		return saves;
	}
	public ArrayList<Proficiencies> Get_Skills()
	{
		return skills;
	}	
	public String Get_Class_Name() {
		return "Fighter";
	}
	public boolean Has_Spells() {
		return false;
	}
	public ArrayList<Spell> Get_Spell_List() {
		return null;
	}
	public int[] Get_Spell_Slots() {
		return null;
	}	public int Get_Hit_Dice() {
		return 10;
	}
	public ArrayList<Proficiencies> Get_Weapon_Profs() {
		return weapons;
	}
	public ArrayList<Proficiencies> Get_Armor_Profs() {
		return armor;
	}
	public ArrayList<String> Get_Class_Features() {
		return features;
	}

}
