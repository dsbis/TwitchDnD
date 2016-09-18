package classes;

public class Spell
{
	private String name;
	private int level;
	
	public Spell(String given_name, int given_level)
	{
		name = given_name;
		level = given_level;
	}
	
	public int Get_Spell_Level()
	{
		return level;
	}
	
	public String Get_Spell_Name()
	{
		return name;
	}
}
