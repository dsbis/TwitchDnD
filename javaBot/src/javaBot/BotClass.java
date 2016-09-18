package javaBot;
import org.jibble.pircbot.*;

public class BotClass extends PircBot{

	VoteCounter vote;
	//BotControlWindow control;
	
	
	/**
	 * Creates the bot
	 * @param name
	 */
	public BotClass(String name) {
		setName(name);
		setLogin(name);
		vote = new VoteCounter(3);
		//control = new BotControlWindow(this, vote);
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
	
	public int getCount(int i) {
		return vote.getVoteCount(i);
	}
	
	/**
	 * Resets the votes back to zero
	 */
	public void reset() {
		vote.reset();
		//System.out.println("Success");
	}
}
