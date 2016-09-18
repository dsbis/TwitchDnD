package character;

public class Ability_Bonus
{
	private Ability ability;
	private int bonus;
	
	public Ability_Bonus(Ability given, int given_bon)
	{
		ability = given;
		bonus = given_bon;
	}
	
	public Ability Get_Ability()
	{
		return ability;
	}
	
	public int Get_Bonus()
	{
		return bonus;
	}
}
