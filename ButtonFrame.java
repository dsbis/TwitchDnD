//import java.awt.event.ActionListener;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class ButtonFrame implements ActionListener{
	private static final int frameWidth = 500;
	private static final int frameHeight = 500;
	Dice d;
	JFrame frame;
	JLabel label;
	
	public ButtonFrame(Dice dice){
		this.d = dice;
		//createComponents();
		frame = new JFrame("button");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(frameWidth, frameHeight);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(192, 373, 69, 20);
		panel.add(lblNewLabel);
		JButton button = new JButton("Dice 4");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lblNewLabel.setText(Integer.toString(d.rollDice(4)));
			}
		});
		button.setBounds(26, 40, 121, 29);
		button.setActionCommand("4");
		panel.add(button);
		
		
		//ActionListener listener = new clickListener();
		
		button.addActionListener(this);
		JButton buttonA = new JButton("Dice 6");
		buttonA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lblNewLabel.setText(Integer.toString(d.rollDice(6)));
			}
		});
		buttonA.setBounds(291, 40, 108, 29);
		buttonA.setActionCommand("6");
		buttonA.setActionCommand("8");
		buttonA.setActionCommand("10");
		buttonA.setActionCommand("12");
		buttonA.setActionCommand("20");
		buttonA.setActionCommand("100");
		panel.add(buttonA);
		
		//d.rollDice20();
		
		//ActionListener listenerA = new clickListener();
		buttonA.addActionListener(this);
		JButton buttonB = new JButton("Dice 8");
		buttonB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lblNewLabel.setText(Integer.toString(d.rollDice(8)));
			}
		});
		buttonB.setBounds(26, 108, 121, 29);
		panel.add(buttonB);
		
		//ActionListener listenerB = new clickListener();
		buttonB.addActionListener(this);
		
		//ActionListener listenerC = new clickListener();
		buttonB.addActionListener(this);
		
		//ActionListener listenerD = new clickListener();
		buttonB.addActionListener(this);
		
		//ActionListener listenerF = new clickListener();
		buttonB.addActionListener(this);
		JButton buttonC = new JButton("Dice 10");
		buttonC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lblNewLabel.setText(Integer.toString(d.rollDice(10)));
			}
		});
		buttonC.setBounds(291, 108, 108, 29);
		panel.add(buttonC);
		JButton buttonD = new JButton("Dice 12");
		buttonD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lblNewLabel.setText(Integer.toString(d.rollDice(12)));
			}
		});
		buttonD.setBounds(26, 181, 121, 29);
		panel.add(buttonD);
		JButton buttonE = new JButton("Dice 20");
		buttonE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lblNewLabel.setText(Integer.toString(d.rollDice(20)));
			}
		});
		
		buttonE.setBounds(293, 181, 106, 29);
		panel.add(buttonE);
		JButton buttonF = new JButton("Dice 100");
		buttonF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lblNewLabel.setText(Integer.toString(d.rollDice(4)));
			}
		});
		
		buttonF.setBounds(166, 272, 108, 29);
		panel.add(buttonF);
		frame.getContentPane().add(panel);
		label =  new JLabel("");
		label.setBounds(0, 0, 0, 0);
		panel.add(label);
		
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */

//	public void actionPerformed(ActionEvent e) {
//		
//		switch(e.getActionCommand()){
//		case "4": 
//		lblNewLabel.setText(Integer.toString(d.rollDice(4)));
//		case "6": ;
//		label.setText(Integer.toString(d.rollDice(6)));
//		case "8": ;
//		label.setText(Integer.toString(d.rollDice(8)));
//		case "10": ;
//		label.setText(Integer.toString(d.rollDice(10)));
//		case "12": ;
//		label.setText(Integer.toString(d.rollDice(12)));
//		case "20": ;
//		label.setText(Integer.toString(d.rollDice(20)));
//		case "100": ;
//		label.setText(Integer.toString(d.rollDice(100)));
//		}
//		
	}

//	private void createComponents(){
//		
//}
