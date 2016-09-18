package character;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import backgrounds.Backgrounds;
import classes.Classes;
import races.Race;

public class Twitch_Character
{
	private int health, cur_health, move, armor_class, str, dex, con, intl, wis, cha, init, lvl, prof;
	private int str_mod, dex_mod, con_mod, intl_mod, wis_mod, cha_mod;
	private Alignment align;
	private Backgrounds background;
	private Race race;
	private TreeSet<Proficiencies> profs;
	private ArrayList<String> features;
	private Classes twitchClass;
	
	public Twitch_Character(int given_level, Race given_race, 
			Classes given_class, Backgrounds given_background, int given_str, int given_dex,
			int given_con, int given_intl, int given_wis, int given_cha)
	{
		lvl = given_level;
		race = given_race;
		twitchClass = given_class;
		background = given_background;
		features = new ArrayList<String>();
		
		//move = race.Get_Speed();
		
		this.Set_Strength(given_str);
		this.Set_Dexterity(given_dex);
		this.Set_Constitution(given_con);
		this.Set_Intelligence(given_intl);
		this.Set_Wisdom(given_wis);
		this.Set_Charisma(given_cha);
				
		switch(race.Get_Name())
		{
			case "Lightfoot_Halfling": this.Set_Dexterity(dex + race.Primary_Bonus().Get_Bonus()); this.Set_Charisma(cha + race.Secondary_Bonus().Get_Bonus()); move = race.Get_Speed();
			case "Hill Dwarf": this.Set_Constitution(con + race.Primary_Bonus().Get_Bonus()); this.Set_Wisdom(wis + race.Secondary_Bonus().Get_Bonus()); move = race.Get_Speed();
			case "Human": move = 30; this.Set_Strength(str+1); this.Set_Dexterity(dex+1); this.Set_Constitution(con+1); this.Set_Intelligence(intl+1); this.Set_Wisdom(wis+1); this.Set_Charisma(cha+1);
		}
		
		switch(lvl)
		{
			case 1:
			case 2:
			case 3:
			case 4: prof = 2;
			case 5: prof = 3;
		}
		
		twitchClass = given_class;
		
//		profs = new TreeSet<Proficiencies>();
//		profs.addAll(twitchClass.Get_Armor_Profs());
//		profs.addAll(twitchClass.Get_Skills());
//		profs.addAll(twitchClass.Get_Weapon_Profs());
//		profs.add(twitchClass.Get_Saving_Throws()[0]);
//		profs.add(twitchClass.Get_Saving_Throws()[1]);
//		profs.add(background.Get_Background_Proficiencies()[0]);
//		profs.add(background.Get_Background_Proficiencies()[1]);
//		features.addAll(twitchClass.Get_Class_Features());
//		features.addAll(race.Racial_Feats());
//		features.add(background.Get_Background_Feature());
		
	}
	
	private int Mod_Value(int stat)
	{ // Determines modifier values for stats
		switch(stat)
		{
		case 1: return -5;
		case 2:
		case 3: return -4;
		case 4:
		case 5: return -3;
		case 6:
		case 7: return -2;
		case 8:
		case 9: return -1;
		case 10:
		case 11: return 0;
		case 12:
		case 13: return 1;
		case 14:
		case 15: return 2;
		case 16:
		case 17: return 3;
		case 18:
		case 19: return 4;
		case 20: return 5;
		}
		return -6;
	}
	public int Get_Level()
	{
		return lvl;
	}
	public void Set_Health(int hp)
	{
		health = hp;
		cur_health = hp;
	}
	public int Get_Max_Health()
	{
		return health;
	}
	public int Get_Cur_Health()
	{
		return cur_health;
	}
	public void Set_Move(int g_move)
	{
		move = g_move;
	}
	public int Get_Max_Move()
	{
		return move;
	}
	public void Set_Armor_Class(int armor)
	{
		armor_class = armor;
	}
	public int Get_Armor_Class()
	{
		return armor_class;
	}
	public void Set_Strength(int g_str)
	{
		str = g_str;
		str_mod = Mod_Value(str);
	}
	public int Get_Strength()
	{
		if(str>20){
			str_mod = 5;
			return 20;
		} else
		return str;
	}
	public int Get_Strength_Mod()
	{
		return str_mod;
	}
	public void Set_Dexterity(int g_dex)
	{
		dex = g_dex;
		dex_mod = Mod_Value(dex);
		init = dex_mod;
	}
	public int Get_Initiative()
	{
		return init;
	}
	public int Get_Dexterity()
	{
		if(dex>20){
			dex_mod = 5;
			return 20;
		} else
		return dex;
	}
	public int Get_Dexterity_Mod()
	{
		return dex_mod;
	}
	public void Set_Constitution(int g_con)
	{
		con = g_con;
		con_mod = Mod_Value(con);
	}	
	public int Get_Constitution()
	{
		if(con>20){
			con_mod = 5;
			return 20;
		} else
		return con;
	}
	public int Get_Constitution_Mod()
	{
		return con_mod;
	}
	public void Set_Intelligence(int g_intl)
	{
		intl = g_intl;
		intl_mod = Mod_Value(intl);
	}
	public int Get_Intelligence()
	{
		if(intl>20){
			intl_mod = 5;
			return 20;
		} else
		return intl;
	}
	public int Get_Intelligence_Mod()
	{
		return intl_mod;
	}
	public void Set_Wisdom(int g_wis)
	{
		wis = g_wis;
		wis_mod = Mod_Value(wis);
	}
	public int Get_Wisdom()
	{
		if(wis>20){
			wis_mod = 5;
			return 20;
		} else
		return wis;
	}
	public int Get_Wisdom_Mod()
	{
		return wis_mod;
	}
	public void Set_Charisma(int g_cha)
	{
		cha = g_cha;
		cha_mod = Mod_Value(cha);
	}
	public int Get_Charisma()
	{
		if(cha>20){
			cha_mod = 5;
			return 20;
		} else
		return cha;
	}
	public int Get_Charisma_Mod()
	{
		return cha_mod;
	}
	public void Set_Race(Race given_race)
	{
		race = given_race;
	}
	public Race Get_Race()
	{
		return race;
	}
	public void Set_Background(Backgrounds back)
	{
		background = back;
		
	}
	public Backgrounds Get_Background()
	{
		return background;
	}
	public void Set_Class(Classes given_class)
	{
		twitchClass = given_class;
	}
	public Classes Get_Class()
	{
		return twitchClass;
	}
	public int Get_Proficiency_Bonus()
	{
		return prof;
	}
	public void Set_Alignment(Alignment given_align)
	{
		align = given_align;
	}
	public Alignment Get_Alignment()
	{
		return align;
	}
	public ArrayList<String> Get_Features()
	{
		return features;
	}
	public Set<Proficiencies> Get_Proficiencies()
	{
		return profs;
	}
}
