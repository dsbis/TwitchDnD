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
	private JTextField textField;
	
	public ButtonFrame(Dice dice){
		this.d = dice;
		//createComponents();
		frame = new JFrame("button");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(frameWidth, frameHeight);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JButton button = new JButton("Dice 4");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				label.setText(Integer.toString(d.rollDice(4)));
			}
		});
		button.setBounds(26, 40, 121, 29);
		button.setActionCommand("4");
		panel.add(button);
		
		
		//ActionListener listener = new clickListener();
		
		button.addActionListener(this);
		JButton buttonA = new JButton("Dice 6");
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
		buttonC.setBounds(291, 108, 108, 29);
		panel.add(buttonC);
		JButton buttonD = new JButton("Dice 12");
		buttonD.setBounds(26, 181, 121, 29);
		panel.add(buttonD);
		JButton buttonE = new JButton("Dice 20");
		buttonE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText(Integer.toString(d.rollDice(4)));
			}
		});
		buttonE.setBounds(293, 181, 106, 29);
		panel.add(buttonE);
		JButton buttonF = new JButton("Dice 100");
		buttonF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText(Integer.toString(d.rollDice(4)));
				
			}
		});
		buttonF.setBounds(166, 272, 108, 29);
		panel.add(buttonF);
		frame.getContentPane().add(panel);
		label =  new JLabel("");
		label.setBounds(0, 0, 0, 0);
		panel.add(label);
		
		textField = new JTextField();
		textField.setForeground(Color.RED);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(112, 352, 214, 56);
		panel.add(textField);
		textField.setColumns(10);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()){
		case "4": 
		label.setText(Integer.toString(d.rollDice(4)));
		case "6": ;
		label.setText(Integer.toString(d.rollDice(6)));
		case "8": ;
		label.setText(Integer.toString(d.rollDice(8)));
		case "10": ;
		label.setText(Integer.toString(d.rollDice(10)));
		case "12": ;
		label.setText(Integer.toString(d.rollDice(12)));
		case "20": ;
		label.setText(Integer.toString(d.rollDice(20)));
		case "100": ;
		label.setText(Integer.toString(d.rollDice(100)));
		}
		
	}
}
//	private void createComponents(){
//		
//}
