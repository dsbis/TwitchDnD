package javaBot;

public class testVote {

	public static void main(String[] args) {
		
		VoteCounter election = new VoteCounter(2);
		
		for(int i=1; i <= 10; i++) {
			election.collectVote("1");
		}
		
		for(int i=1; i <= 20; i++) {
			election.collectVote("2");
		}
		
		System.out.println("Option 1 Count: " + election.getVoteCount(1));
		System.out.println("Option 2 Count: " + election.getVoteCount(2));
		
		
		System.out.println("The winner is: " + election.selectWinner());
		
		election.reset(4);
		System.out.println("Option 1 Count: " + election.getVoteCount(1));
		System.out.println("Option 2 Count: " + election.getVoteCount(2));
		System.out.println("Option 3 Count: " + election.getVoteCount(3));
		System.out.println("Option 4 Count: " + election.getVoteCount(4));

	}

}
