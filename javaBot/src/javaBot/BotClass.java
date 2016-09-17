package javaBot;
import org.jibble.pircbot.*;

public class BotClass extends PircBot{

	VoteCounter vote;
	
	
	/**
	 * Creates the bot
	 * @param name
	 */
	public BotClass(String name) {
		setName(name);
		setLogin(name);
		vote = new VoteCounter(4);
	}
	
	/**
	 * @param channel
	 * @param sender
	 * @param login
	 * @param hostname
	 * @param message
	 * This method will interpret all incoming messages
	 * 		Please don't be overworked.
	 */
	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		vote.collectVote(message);
		
		/*
		if(message.equals("winner")) {
			this.getWinner();
		} else if(message.equals("reset")) {
			this.reset();
		}*/
			
	}
	
	/**
	 * Returns the winner of the vote
	 * @return
	 * 		The winner of the vote
	 */
	public int getWinner() {
		//System.out.println("Success");
		return vote.selectWinner();
		
	}
	
	/**
	 * Resets the votes back to zero
	 */
	public void reset() {
		vote.reset();
		//System.out.println("Success");
	}
}
