import java.util.Random;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Dice {
	//public static void main(String[] args){
//		Random diceSeed = new Random();
//		Random dice = new Random(diceSeed.nextInt());
//		
//		for(int counter = 1; counter <= 1; counter++){
//			int number1 = 1 + dice.nextInt(4);
//			System.out.println(number1 + " ");
//			int number2 = 1 + dice.nextInt(6);
//			System.out.println(number2 + " ");
//			int number3 = 1 + dice.nextInt(8);
//			System.out.println(number3 + " ");
//			int number4 = 1 + dice.nextInt(10);
//			System.out.println(number4 + " ");
//			int number5 = 1 + dice.nextInt(12);
//			System.out.println(number5 + " ");
//			int number6 = 1 + dice.nextInt(20);
//			System.out.println(number6 + " ");
//			int number7 = 1 + dice.nextInt(100);
//			System.out.println(number7 + " ");
//		}
	//}
		
		//private int sides;
		public Dice(){
			//sides = numberOfSides;
	}
		//private int Dice4;
		public int rollDice(int sides){
			return (int)(Math.random() * sides) + 1;
			//return Dice4;
		}
//		private int Dice6;
//		public int rollDice6(){
//			Dice6 = (int)(Math.random() * 6) + 1;
//			return Dice6;
//		}
//		private int Dice8;
//		public int rollDice8(){
//			Dice8 = (int)(Math.random() * 8) + 1;
//			return Dice8;
//		}
//		private int Dice10;
//		public int rollDice10(){
//			Dice10 = (int)(Math.random() * 10) + 1;
//			return Dice10;
//		}
//		private int Dice12;
//		public int rollDice12(){
//			Dice12 = (int)(Math.random() * 12) + 1;
//			return Dice12;
//		}
//		private int Dice20;
//		public int rollDice20(){
//			Dice20 = (int)(Math.random() * 20) + 1;
//			return Dice20;
//		}
//		private int Dice100;
//		public int rollDice100(){
//			Dice100 = (int)(Math.random() * 100) + 1;
//			return Dice100;
//		}
//		public void printLine4(){
//			//System.out.println(rollDice4());
//		}
}
