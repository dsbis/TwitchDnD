package races;

import java.util.ArrayList;

import character.Ability_Bonus;

public interface Race
{
	public Ability_Bonus Primary_Bonus();
	public Ability_Bonus Secondary_Bonus();
	public ArrayList<String> Racial_Feats();
	public String Get_Name();
	public int Get_Speed();
}

