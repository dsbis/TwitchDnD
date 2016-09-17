package javaBot;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BotControlWindow {
	
	BotClass bot;
	JFrame frame;

	
	public BotControlWindow(BotClass b) {
		this.bot = b;
		frame = new JFrame("Vote Control");
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("12\r\n");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 36));
		lblNewLabel.setVisible(false);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("End Vote");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				lblNewLabel.setText(Integer.toString(bot.getWinner()));
				lblNewLabel.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Reset Vote");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				bot.reset();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(114)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
					.addGap(61))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(55))
		);
		frame.getContentPane().setLayout(groupLayout);
	
		
		
		}
}