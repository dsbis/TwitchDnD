package javaBot;

import java.util.Arrays;

public class VoteCounter {

	/**
	 * This counts the votes for a given selection for chat
	 */
	private int[] voteCount;
	
	/**
	 * This determines how many options for a vote there are to choose from
	 */
	private int optionSize;
	
	/**
	 * Creates VoteCounter with initial vote stats
	 * @param numberOfOptions
	 */
	public VoteCounter(int numberOfOptions) {
		optionSize = numberOfOptions;
		voteCount = new int[optionSize];
	}
	
	/**
	 * Collects votes based on Twitch chat input
	 * @param input
	 */
	public void collectVote(String input) {
		int vote = 0;
		
		try { // This will allow code to ignore String input
			vote = Integer.parseInt(input);
		}catch (NumberFormatException e) {}
		
		try { // This will allow code to ignore input that is too large for array
			voteCount[(vote-1)] = voteCount[(vote-1)] + 1;
		} catch (ArrayIndexOutOfBoundsException e) {}
	}
	
	/**
	 * Returns vote count for given option
	 * @param option
	 * @return
	 * 		The vote count for a given option
	 */
	public int getVoteCount(int option) {
		return voteCount[option - 1];
	}
	
	/**
	 * Returns the option that had the most votes
	 * @return
	 * 		The option that had the most votes
	 */
	public int selectWinner() {
		int largestElement = 0;
		int winningVote = -1;
		
		for(int i=0; i < voteCount.length; i++) {
			if(voteCount[0] == voteCount[1] && voteCount[0] != voteCount[2]) {
				winningVote = (int) (Math.random() * 2);
			} else if (voteCount[1] == voteCount[2] && voteCount[0] != voteCount[2]) {
				winningVote = (int) (Math.random() * 2 + 1);
			} else if (voteCount[0] == voteCount[2] && voteCount[1] != voteCount[2]) {
				winningVote = (int)((Math.random() * 10) % 2) * 2;
			}else if (voteCount[0] == voteCount[1] && voteCount[0] == voteCount[2]) {
				winningVote = (int) (Math.random() * 3);
			}else if(voteCount[i] > largestElement) { 
				largestElement = voteCount[i];
				winningVote = i;
			}
		}
		
		return winningVote + 1;
	}
	
	/**
	 * Resets VoteCounter and creates new VoteCounter with a different size
	 * @param numberOfOptions
	 */
	public void reset(int numberOfOptions) {
		for(int i=0; i < voteCount.length; i++) {
				voteCount[i] = 0;
			}
		
		voteCount = Arrays.copyOf(voteCount, numberOfOptions);
		
	}
	
	/**
	 * Resets VoteCounter and maintains size
	 */
	public void reset() {
		for(int i=0; i < voteCount.length; i++) {
				voteCount[i] = 0;
		}
	}
	
	
}