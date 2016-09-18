package backgrounds;

import character.Proficiencies;

public class Sage implements Backgrounds {

	private final Proficiencies[] profs = {Proficiencies.ARCANA, Proficiencies.HISTORY};
	
	public Sage()
	{
		
	}
	
	public Proficiencies[] Get_Background_Proficiencies() {
		return profs;
	}

	
	public String Get_Background_Name() {
		return "Sage";
	}

	
	public String Get_Background_Feature() {
		return "Reasearcher";
	}

}
