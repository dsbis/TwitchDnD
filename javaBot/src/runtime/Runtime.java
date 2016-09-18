package runtime;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Timer;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

import backgrounds.Backgrounds;
import backgrounds.Criminal;
import backgrounds.Sage;
import backgrounds.Soldier;

import javax.swing.SwingConstants;

import character.Twitch_Character;
import classes.Character_Classes;
import classes.Classes;
import classes.Cleric;
import classes.Fighter;
import classes.Rogue;
import javaBot.BotClass;
import javaBot.VoteCounter;
import races.Hill_Dwarf;
import races.Human;
import races.Lightfoot_Halfling;
import races.Race;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;

public class Runtime {
	

	public static void main(String[] args) {
		
		String[][] options = { {"CLERIC","ROGUE","FIGHTER","RANDOM"},
							   {"DWARF","HUMAN","HALFLING","RANDOM"},
							   {"CRIMINAL","SAGE","SOLDIER","RANDOM"},
							   {"LAWFUL","NEUTRAL","CHAOTIC","RANDOM"},
							   {"GOOD","NEUTRAL","EVIL","RANDOM"}};

		int playerLvl = 1;
		int delay = 1000;
		final AtomicReference<Race> race = new AtomicReference<Race>();
		final AtomicReference<Classes> classes = new AtomicReference<Classes>();
		final AtomicReference<Backgrounds> background = new AtomicReference<Backgrounds>();
		OptionIndex index = new OptionIndex();
		Dice d = new Dice();
		BotClass bot = new BotClass("CrowdSourcedDnD");
		bot.setVerbose(true);
		// bot will attempt to join the server
		try{
			bot.connect("irc.twitch.tv",6667,"oauth:08knnc7qeykflcofr6i1xh1kl19edg");
		} catch (NickAlreadyInUseException e) {
			System.err.println("Name already in use.");
		} catch (IrcException e) {
			System.err.println("Server did not accept request.");
		} catch (IOException e) {
			System.err.println("Could not connect to server.");
		}
		
		// bot will join targeted channel
		bot.joinChannel("#crowdsourceddnd");
		
		JFrame frame = new JFrame("Twitch Plays Dungeons and Dragons");
		frame.setVisible(true);
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblWinnerChoice = new JLabel("A");
		lblWinnerChoice.setFont(new Font("Dialog", Font.BOLD, 56));
		lblWinnerChoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinnerChoice.setVisible(false);
		
		JLabel lblCurrentlyVotingOn = new JLabel("Currently Voting On: ");
		lblCurrentlyVotingOn.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblInsertTest = new JLabel("CLASS");
		lblInsertTest.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		/**
		 * Here are the options changing 
		 */
		JLabel lblOptionA = new JLabel(options[index.getIndex()][0]);
		JLabel lblOptionB = new JLabel(options[index.getIndex()][1]);
		JLabel lblOptionC = new JLabel(options[index.getIndex()][2]);
		
		
		
		JLabel lblStrength = new JLabel("STRENGTH");
		lblStrength.setHorizontalAlignment(SwingConstants.CENTER);
		lblStrength.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblStrengthScore = new JLabel("00");
		lblStrengthScore.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblStrengthMod = new JLabel("0");
		lblStrengthMod.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblDexterity = new JLabel("DEXTERITY");
		lblDexterity.setHorizontalAlignment(SwingConstants.CENTER);
		lblDexterity.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblDexScore = new JLabel("00");
		lblDexScore.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblDexMod = new JLabel("0");
		lblDexMod.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblConstitution = new JLabel("CONSTITUTION");
		lblConstitution.setHorizontalAlignment(SwingConstants.CENTER);
		lblConstitution.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblConstScore = new JLabel("00");
		lblConstScore.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblConstMod = new JLabel("0");
		lblConstMod.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblIntelligence = new JLabel("INTELLIGENCE");
		lblIntelligence.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntelligence.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblIntlScore = new JLabel("00");
		lblIntlScore.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblIntlMod = new JLabel("0");
		lblIntlMod.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblWisdom = new JLabel("WISDOM");
		lblWisdom.setHorizontalAlignment(SwingConstants.CENTER);
		lblWisdom.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblWsdmScore = new JLabel("00");
		lblWsdmScore.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblWsdmMod = new JLabel("0");
		lblWsdmMod.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCharisma = new JLabel("CHARISMA");
		lblCharisma.setHorizontalAlignment(SwingConstants.CENTER);
		lblCharisma.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblCrsmScore = new JLabel("00");
		lblCrsmScore.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCrsmMod = new JLabel("0");
		lblCrsmMod.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblWinner = new JLabel("WINNER");
		lblWinner.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblName = new JLabel("NAME: Twitch");
		lblName.setFont(new Font("Dialog", Font.BOLD, 20));
		
		JLabel lblClass = new JLabel("Class:");
		
		JLabel lblRace = new JLabel("Race:");
		
		JLabel lblBackground = new JLabel("Background:");
		
		JLabel lblAlignment = new JLabel("Alignment:");
		
		JLabel lblInsertClass = new JLabel("INSERT CLASS");
		lblInsertClass.setVisible(false);
		
		JLabel lblInsertRace = new JLabel("INSERT RACE");
		lblInsertRace.setVisible(false);
		
		JLabel lblInsertBkgd = new JLabel("INSERT BKGD");
		lblInsertBkgd.setVisible(false);
		
		JLabel lblInsertAlignment = new JLabel("INSERT ALIGNMENT");
		lblInsertAlignment.setVisible(false);
		
		JLabel lblA = new JLabel("1:");
		
		JLabel lblB = new JLabel("2:");
		
		JLabel lblC = new JLabel("3:");
		
		JLabel lblTwitchPlaysDungeons = new JLabel("TWITCH PLAYS DUNGEONS AND DRAGONS");
		lblTwitchPlaysDungeons.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblDiceRoll = new JLabel("100");
		lblDiceRoll.setFont(new Font("Dialog", Font.BOLD, 32));
		lblDiceRoll.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiceRoll.setVisible(false);
		
		JButton btnD_5 = new JButton("D4");
		btnD_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblDiceRoll.setText(String.valueOf(d.rollDice(4)));
				lblDiceRoll.setVisible(true);
			}
		});
		
		JButton btnNewButton = new JButton("D6");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblDiceRoll.setText(String.valueOf(d.rollDice(6)));
				lblDiceRoll.setVisible(true);
			}
		});
		
		JButton btnD_4 = new JButton("D8");
		btnD_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblDiceRoll.setText(String.valueOf(d.rollDice(8)));
				lblDiceRoll.setVisible(true);
			}
		});
		
		JButton btnD_3 = new JButton("D10");
		btnD_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblDiceRoll.setText(String.valueOf(d.rollDice(10)));
				lblDiceRoll.setVisible(true);
			}
		});
	
		JButton btnD_2 = new JButton("D12\r\n");
		btnD_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblDiceRoll.setText(String.valueOf(d.rollDice(12)));
				lblDiceRoll.setVisible(true);
			}
		});
		
		JButton btnD_1 = new JButton("D20\r\n");
		btnD_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblDiceRoll.setText(String.valueOf(d.rollDice(20)));
				lblDiceRoll.setVisible(true);
			}
		});
		
		JButton btnD = new JButton("D100");
		btnD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblDiceRoll.setText(String.valueOf(d.rollDice(100)));
				lblDiceRoll.setVisible(true);
			}
		});
		
		/**
		 * Close Vote Button
		 */
		JButton btnCloseVote = new JButton("Close Vote");
		btnCloseVote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCloseVote.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblWinnerChoice.setVisible(true);
				lblWinnerChoice.setText(Integer.toString(bot.getWinner()));
				switch (index.getIndex()) {
					case 0: int selector1 = bot.getWinner();
							classlabel:
							switch(selector1) {
							case 1: classes.set(new Cleric(playerLvl, Character_Classes.LIFE_CLERIC));
									break;
							case 2: classes.set(new Rogue(playerLvl, Character_Classes.THIEF_ROGUE));
									break;
							case 3: classes.set(new Fighter(playerLvl, Character_Classes.CHAMPION_FIGHTER));
									break;
							}
							lblInsertClass.setText(options[index.getIndex()][selector1-1]);
							lblInsertClass.setVisible(true); // This case statement is for classes
							break;
					case 1: int selector2 = bot.getWinner();
							racelabel:
							switch(selector2) {
								case 1: race.set(new Hill_Dwarf());
										break;
								case 2: race.set(new Human());
										break;
								case 3: race.set(new Lightfoot_Halfling());
										break;
								}
							lblInsertRace.setText(options[index.getIndex()][selector2-1]);
							lblInsertRace.setVisible(true); // This case statement is for races
							break;
					case 2: int selector3 = bot.getWinner();
							backgroundlabel:
							switch(selector3) {
								case 1: background.set(new Criminal());
										break;
								case 2: background.set(new Sage());
										break;
								case 3: background.set(new Soldier());
										break;
							}
							lblInsertBkgd.setText(options[index.getIndex()][selector3-1]);
							lblInsertBkgd.setVisible(true); // This case statement is for backgrounds
							break;
					case 3: lblInsertAlignment.setText(options[index.getIndex()][bot.getWinner()-1]);
							lblInsertAlignment.setVisible(true); // This case statement is for alignments
							index.setTempAlignment(options[index.getIndex()][bot.getWinner()-1]);
							break;
					case 4: lblInsertAlignment.setText(index.getTempAlignment() + " " + options[index.getIndex()][bot.getWinner()-1]);
							Twitch_Character twitch = new Twitch_Character(playerLvl, race.get(), classes.get(), background.get(), d.rollDice(20),d.rollDice(20),
																			d.rollDice(20), d.rollDice(20), d.rollDice(20), d.rollDice(20));
							lblStrengthScore.setText(String.valueOf(twitch.Get_Strength()));
							lblStrengthMod.setText(String.valueOf(twitch.Get_Strength_Mod()));
							lblDexScore.setText(String.valueOf(twitch.Get_Dexterity()));
							lblDexMod.setText(String.valueOf(twitch.Get_Dexterity_Mod()));
							lblConstScore.setText(String.valueOf(twitch.Get_Constitution()));
							lblConstMod.setText(String.valueOf(twitch.Get_Constitution_Mod()));
							lblIntlScore.setText(String.valueOf(twitch.Get_Intelligence()));
							lblIntlMod.setText(String.valueOf(twitch.Get_Intelligence_Mod()));
							lblWsdmScore.setText(String.valueOf(twitch.Get_Wisdom()));
							lblWsdmMod.setText(String.valueOf(twitch.Get_Wisdom_Mod()));
							lblCrsmScore.setText(String.valueOf(twitch.Get_Charisma()));
							lblCrsmMod.setText(String.valueOf(twitch.Get_Charisma_Mod()));
							
							break; // This case statement is for alignments
				}
			}
		});
		
		/**
		 * Reset Button
		 */
		JButton btnResetVote = new JButton("Reset Vote");
		btnResetVote.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index.incrementIndex();
				switch(index.getIndex()) {
				case 1: lblInsertTest.setText("RACE");
					break;
				case 2: lblInsertTest.setText("BACKGROUND");
					break;
				case 3: lblInsertTest.setText("ALIGNMENT");
					break;
				case 4:
				}
				bot.reset();
				lblWinnerChoice.setVisible(false);
				
				
				lblOptionA.setText(options[index.getIndex()][0]);
				lblOptionB.setText(options[index.getIndex()][1]);
				lblOptionC.setText(options[index.getIndex()][2]);
				if (index.getIndex() == 0) {
					lblInsertClass.setText("");
					lblInsertRace.setText("");
					lblInsertBkgd.setText("");
					lblInsertAlignment.setText("");
					lblStrengthScore.setText(String.valueOf(00));
					lblStrengthMod.setText(String.valueOf(0));
					lblDexScore.setText(String.valueOf(00));
					lblDexMod.setText(String.valueOf(0));
					lblConstScore.setText(String.valueOf(00));
					lblConstMod.setText(String.valueOf(0));
					lblIntlScore.setText(String.valueOf(00));
					lblIntlMod.setText(String.valueOf(0));
					lblWsdmScore.setText(String.valueOf(00));
					lblWsdmMod.setText(String.valueOf(0));
					lblCrsmScore.setText(String.valueOf(00));
					lblCrsmMod.setText(String.valueOf(0));
				}
			}
		});
		
		JLabel lbl1Count = new JLabel("0");
		lbl1Count.setFont(new Font("Dialog", Font.BOLD, 20));
		lbl1Count.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbl2Count = new JLabel("0");
		lbl2Count.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2Count.setFont(new Font("Dialog", Font.BOLD, 20));

		
		JLabel lbl3Count = new JLabel("0");
		lbl3Count.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3Count.setFont(new Font("Dialog", Font.BOLD, 20));
		ActionListener task1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1Count.setText(String.valueOf(bot.getCount(1)));
				lbl2Count.setText(String.valueOf(bot.getCount(2)));
				lbl3Count.setText(String.valueOf(bot.getCount(3)));
			}
		};
		new Timer(delay,task1).start();
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(20)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblStrength, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
									.addComponent(lblStrengthScore, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblConstitution, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblConstScore, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
									.addComponent(lblConstMod, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
									.addComponent(lblIntelligence, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
									.addComponent(lblIntlScore, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
									.addComponent(lblIntlMod, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
									.addComponent(lblWisdom, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
									.addComponent(lblWsdmScore, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
									.addComponent(lblWsdmMod, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
									.addComponent(lblCrsmScore, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
									.addComponent(lblDexScore, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
									.addComponent(lblDexMod, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
									.addComponent(lblCharisma, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
									.addComponent(lblCrsmMod, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
									.addComponent(lblDexterity, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
								.addGap(115))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(69)
								.addComponent(lblName)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addComponent(lblStrengthMod)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(144)
							.addComponent(lbl2Count, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
							.addGap(79)
							.addComponent(lbl3Count, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnD, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnD_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnD_2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblDiceRoll, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(37)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(btnResetVote, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnCloseVote, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblCurrentlyVotingOn)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblInsertTest, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
										.addComponent(lblTwitchPlaysDungeons)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(11)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(34)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblRace)
												.addComponent(lblClass))
											.addGap(25)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblInsertClass)
												.addComponent(lblInsertRace))
											.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblAlignment)
												.addComponent(lblBackground)))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(6)
											.addComponent(lblA)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(12)
													.addComponent(lbl1Count))
												.addGroup(groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblC, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
														.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
															.addComponent(lblOptionA, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
															.addGap(18)
															.addComponent(lblB, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(ComponentPlacement.RELATED)
															.addComponent(lblOptionB, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(lblOptionC, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
											.addGap(16)))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblInsertBkgd)
									.addComponent(lblInsertAlignment))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnD_3, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnD_4, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnD_5, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
									.addComponent(lblWinner, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblWinnerChoice)
									.addGap(48)))))
					.addGap(60))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(196)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOptionA)
						.addComponent(lblA)
						.addComponent(lblB)
						.addComponent(lblOptionB)
						.addComponent(lblC)
						.addComponent(lblOptionC))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lbl3Count, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addComponent(lbl2Count, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbl1Count)
							.addContainerGap())))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(168)
							.addComponent(lblDexterity)
							.addGap(292))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblClass)
								.addComponent(lblInsertClass)
								.addComponent(lblInsertBkgd)
								.addComponent(lblBackground))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblName)
								.addComponent(lblRace)
								.addComponent(lblInsertRace)
								.addComponent(lblInsertAlignment)
								.addComponent(lblAlignment))
							.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblStrength)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblStrengthScore)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblStrengthMod)
									.addGap(22))
								.addComponent(lblDiceRoll))
							.addGap(18)
							.addComponent(lblDexScore)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnD)
								.addComponent(lblDexMod))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnD_2)
										.addComponent(btnD_1))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnD_3)
										.addComponent(btnD_4))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnD_5)
										.addComponent(btnNewButton))
									.addGap(18)
									.addComponent(lblWinner)
									.addGap(18)
									.addComponent(lblWinnerChoice))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblConstitution)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblConstScore)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblConstMod)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblIntelligence)
										.addComponent(lblTwitchPlaysDungeons))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblIntlScore)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(23)
											.addComponent(btnCloseVote))
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblIntlMod)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblWisdom)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblWsdmScore)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblWsdmMod))
										.addComponent(btnResetVote))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblCharisma)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblCurrentlyVotingOn)
												.addComponent(lblInsertTest))
											.addGap(2)))))
							.addGap(1)))
					.addComponent(lblCrsmScore)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCrsmMod)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		
	}
}
