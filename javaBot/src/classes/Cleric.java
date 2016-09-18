package classes;

import java.util.ArrayList;

import character.Proficiencies;

public class Cleric implements Classes
{
	private ArrayList<Spell> spellList; 
	private final Proficiencies[]  saves = {Proficiencies.WISDOM, Proficiencies.CHARISMA};
	private ArrayList<Proficiencies> skills, armor, weapons;
	private ArrayList<String> features;
	private int level;
	private Cleric_Type type;
	private int[] spellSlots;
	
	private enum Cleric_Type
	{
		LIFE, WAR, TEMPEST, LIGHT, KNOWLEDGE
	}
	public Cleric(int given_level, Character_Classes given_type)
	{
		spellList = new ArrayList<Spell>();
		spellSlots = new int[9];
		skills = new ArrayList<Proficiencies>();
		armor = new ArrayList<Proficiencies>();
		weapons = new ArrayList<Proficiencies>();
		features = new ArrayList<String>();
		
		switch(given_type)
		{
			default: throw new RuntimeException("Wrong Class");
			case LIFE_CLERIC: type = Cleric_Type.LIFE;
		}
		
		level = given_level;
		this.Initialize_As_Cleric();
		
		if(type == Cleric_Type.LIFE)
		{
			this.Initialize_As_Life();
		}
	}
	
	private void Initialize_As_Cleric()
	{

		armor.add(Proficiencies.LIGHT_ARMOR);
		armor.add(Proficiencies.MEDIUM_ARMOR);
		armor.add(Proficiencies.SHIELDS);
		weapons.add(Proficiencies.SIMPLE_WEAPONS);
		
		if(level >= 1)
		{
			spellSlots[0] = 2;
		}
		if(level >= 2)
		{
			spellSlots[0] += 1;
			features.add("Channel Divinity: Turn Undead");
		}
		if(level >= 3)
		{
			spellSlots[0] += 1;
			spellSlots[1] = 2;
		}
		if(level >= 4)
		{
			spellSlots[1] += 1;
		}
		if(level >= 5)
		{
			spellSlots[2] = 2;
			features.add("Turn Undead: Destroy Undead (CR 1/2)");
		}
	}
	
	private void Initialize_As_Life()
	{
		armor.add(Proficiencies.HEAVY_ARMOR);
		spellList.add(new Spell("Light", 0));
		spellList.add(new Spell("Mending", 0));
		spellList.add(new Spell("Thamaturgy", 0));
		
		if(level >= 1)
		{
			Spell bless = new Spell("Bless", 1);
			Spell curewounds = new Spell("Cure Wounds", 1);
			spellList.add(bless);
			spellList.add(curewounds);
			features.add("Disciple of List");
		}
		if(level >= 2)
		{
			features.add("Channel Divinity: Preserve Life");
		}
		if(level >= 3)
		{
			Spell lesser = new Spell("Lesser Restoration", 2);
			Spell spiritual = new Spell("Spiritual Weapon", 2);
			spellList.add(lesser);
			spellList.add(spiritual);
		}
		if(level >= 5)
		{
			Spell beacon = new Spell("Beacon of Hope", 3);
			Spell revivify = new Spell("Revivify", 3);
			spellList.add(beacon);
			spellList.add(revivify);
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
		return "Cleric";
	}

	
	public boolean Has_Spells() {
		return true;
	}

	
	public int Get_Hit_Dice() {
		return 8;
	}

	
	public ArrayList<Proficiencies> Get_Weapon_Profs() {
		return weapons;
	}

	
	public ArrayList<Proficiencies> Get_Armor_Profs() {
		return armor;
	}

	
	public ArrayList<String> Get_Class_Features()
	{
		return features;
	}

	public ArrayList<Spell> Get_Spell_List()
	{
		return spellList;
	}

	public int[] Get_Spell_Slots()
	{
		return spellSlots;
	}

}