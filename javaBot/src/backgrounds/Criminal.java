package backgrounds;

import character.Proficiencies;

public class Criminal implements Backgrounds {

	private final Proficiencies[] profs = {Proficiencies.DECEPTION, Proficiencies.STEALTH};
	
	public Criminal()
	{
		
	}
	
	public Proficiencies[] Get_Background_Proficiencies() {
		return profs;
	}

	
	public String Get_Background_Name() {
		return "Criminal";
	}

	
	public String Get_Background_Feature() {
		return "Criminal Contacts";
	}

	
}
