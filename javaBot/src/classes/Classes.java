package classes;

import java.util.ArrayList;

import character.Proficiencies;

public interface Classes
{
	public Proficiencies[] Get_Saving_Throws();
	public ArrayList<Proficiencies> Get_Skills();
	public String Get_Class_Name();
	public boolean Has_Spells();
	public ArrayList<Spell> Get_Spell_List();
	public int[] Get_Spell_Slots();
	public int Get_Hit_Dice();
	public ArrayList<Proficiencies> Get_Weapon_Profs();
	public ArrayList<Proficiencies> Get_Armor_Profs();
	public ArrayList<String> Get_Class_Features();
}
