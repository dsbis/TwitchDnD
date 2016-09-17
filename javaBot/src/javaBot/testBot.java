package javaBot;
import java.io.IOException;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

public class testBot {

	public static void main(String[] args) {
		
		BotClass bot = new BotClass("phosphorust");
		BotControlWindow control = new BotControlWindow(bot);
		
		bot.setVerbose(true);
		
		// bot will attempt to join the server
		try{
			bot.connect("irc.twitch.tv",6667,"oauth:km6pjcojitwfenmfvwv8gjuxr5if3y");
		} catch (NickAlreadyInUseException e) {
			System.err.println("Name already in use.");
		} catch (IrcException e) {
			System.err.println("Server did not accept request.");
		} catch (IOException e) {
			
			System.err.println("Could not connect to server.");
		}
		
		// bot will join targeted channel
		bot.joinChannel("#phosphorust");
		
		
		
	}
}
