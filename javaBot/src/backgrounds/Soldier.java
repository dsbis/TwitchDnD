package backgrounds;

import character.Proficiencies;

public class Soldier implements Backgrounds {

	private final Proficiencies[]  profs = {Proficiencies.ATHLETICS, Proficiencies.INTIMIDATION};
	
	public Soldier()
	{
		//No need
	}
	
	public Proficiencies[] Get_Background_Proficiencies() {
		return profs;
	}

	
	public String Get_Background_Name() {
		return "Soldier";
	}

	
	public String Get_Background_Feature() {
		return "Military Rank";
	}

}
