package javaBot;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BotControlWindow2 implements ActionListener {
	
	BotClass bot;
	JLabel label;
	JFrame frame;
	JPanel panel, panel2;
	JButton endVote, resetVote;
	
	public BotControlWindow2(BotClass b) {
		this.bot = b;
		frame = new JFrame("Vote Control");
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		panel = new JPanel();
		
		
		endVote = new JButton("End Vote");
		panel.add(endVote);
		endVote.setActionCommand("end");
		
		resetVote = new JButton("Reset Vote");
		panel.add(resetVote);
		resetVote.setActionCommand("reset");
		
		label = new JLabel("",JLabel.CENTER);
		label.setAlignmentX(0);
		label.setAlignmentY(0);
		label.setFont(new Font("Serif", Font.PLAIN, 36));
		panel.add(label);
		
		frame.add(panel);
		
		endVote.addActionListener(this);
		resetVote.addActionListener(this);
		}
	
	public void actionPerformed(ActionEvent e) {
		if ("end".equals(e.getActionCommand())) {
			label.setText(Integer.toString(bot.getWinner()));
		} else if ("reset".equals(e.getActionCommand())) {
			bot.reset();
		}
	}
}