import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class LauncherView extends JPanel {
	private Fighter[] model;
	private JPanel playerOnePanel, playerTwoPanel;
	private JButton[] p1Character, p2Character;
	private JButton startGame, p1Ready, p2Ready;
	private JTextArea p1Desc, p1Stats, p2Desc, p2Stats;
	private JLabel p1Image, p2Image;
	
	private int[] selection;
	private boolean p1ReadyBool, p2ReadyBool;
	
	public int[] getSelection() { return selection; }
	public JButton getP1Ready() { return p1Ready; }
	public JButton getP2Ready() { return p2Ready; }
	
	public void setP1Ready(boolean ready) { 
		p1ReadyBool = ready;
	}
	public void setP2Ready(boolean ready) {
		p2ReadyBool = ready;
	}
	
	public void setSelection(int i, int sel) {
		selection[i] = sel;
	}

	public LauncherView(Fighter[] m) {
		p2ReadyBool = p1ReadyBool = false;
		
		model = m;
		selection = new int[model.length];
		// general layout stuff
		GridBagLayout generalLayout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 5, 5, 5); // default spacing
		setLayout(generalLayout);

		// Panels
		// player one
		playerOnePanel = new JPanel();
		playerOnePanel
				.setBorder(BorderFactory.createTitledBorder("Player One"));
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1;
		constraints.weighty = 1;
		generalLayout.setConstraints(playerOnePanel, constraints);
		add(playerOnePanel);

		// player two
		playerTwoPanel = new JPanel();
		playerTwoPanel
				.setBorder(BorderFactory.createTitledBorder("Player Two"));
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1;
		constraints.weighty = 1;
		generalLayout.setConstraints(playerTwoPanel, constraints);
		add(playerTwoPanel);

		// buttons
		startGame = new JButton("START!");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weightx = 0;
		constraints.weighty = 0;
		generalLayout.setConstraints(startGame, constraints);
		add(startGame);

		// p1 panel
		// p1 layout
		GridBagLayout player1Layout = new GridBagLayout();
		GridBagConstraints p1Const = new GridBagConstraints();
		p1Const.insets = new Insets(5, 5, 5, 5); // default spacing
		playerOnePanel.setLayout(player1Layout);

		// buttons
		p1Character = new JButton[model.length];
		for (int i = 0; i < p1Character.length; i++) {
			p1Character[i] = new JButton(model[i].getName());
			p1Const.gridx = i % 5;			//will reset the position to 0 every 5
			p1Const.gridy = 1 * (i / 5);	//will make a new line for buttons after each set of 5
			p1Const.gridwidth = 1;
			p1Const.gridheight = 1;
			p1Const.fill = GridBagConstraints.NONE;
			p1Const.weightx = 1;
			p1Const.weighty = 0;
			player1Layout.setConstraints(p1Character[i], p1Const);
			playerOnePanel.add(p1Character[i]);
		}
		
		p1Ready = new JButton("Ready!");
		p1Const.gridx = 0;
		p1Const.gridy = 20;
		p1Const.gridwidth = 5;
		p1Const.gridheight = 1;
		p1Const.fill = GridBagConstraints.NONE;
		p1Const.weightx = 0;
		p1Const.weighty = 0;
		player1Layout.setConstraints(p1Ready, p1Const);
		playerOnePanel.add(p1Ready);
		
		// text area
		p1Desc = new JTextArea();
		p1Const.gridx = 0;
		p1Const.gridy = 19;
		p1Const.gridwidth = 5;
		p1Const.gridheight = 1;
		p1Const.fill = GridBagConstraints.BOTH;
		p1Const.weightx = 1;
		p1Const.weighty = 1;
		player1Layout.setConstraints(p1Desc, p1Const);
		playerOnePanel.add(p1Desc);
		p1Desc.setEditable(false);
		
		p1Stats = new JTextArea();
		p1Const.gridx = 3;
		p1Const.gridy = 18;
		p1Const.gridwidth = 2;
		p1Const.gridheight = 1;
		p1Const.fill = GridBagConstraints.BOTH;
		p1Const.weightx = 0;
		p1Const.weighty = 0;
		player1Layout.setConstraints(p1Stats, p1Const);
		playerOnePanel.add(p1Stats);
		p1Stats.setEditable(false);
		
		// Label
		p1Image = new JLabel(new ImageIcon("res/portraits/unknown.png"));
		p1Const.gridx = 0;
		p1Const.gridy = 18;
		p1Const.gridwidth = 3;
		p1Const.gridheight = 1;
		p1Const.fill = GridBagConstraints.NONE;
		p1Const.weightx = 0;
		p1Const.weighty = 0;
		player1Layout.setConstraints(p1Image, p1Const);
		playerOnePanel.add(p1Image);

		// p2 panel
		// p2 layout
		GridBagLayout player2Layout = new GridBagLayout();
		GridBagConstraints p2Const = new GridBagConstraints();
		p2Const.insets = new Insets(5, 5, 5, 5); // default spacing
		playerTwoPanel.setLayout(player2Layout);

		// buttons
		p2Character = new JButton[model.length];
		for (int i = 0; i < p2Character.length; i++) {
			p2Character[i] = new JButton(model[i].getName());
			p2Const.gridx = i % 5;			//will reset the position to 0 every 5
			p2Const.gridy = 1 * (i / 5);	//will make a new line for buttons after each set of 5
			p2Const.gridwidth = 1;
			p2Const.gridheight = 1;
			p2Const.fill = GridBagConstraints.NONE;
			p2Const.weightx = 1;
			p2Const.weighty = 0;
			player2Layout.setConstraints(p2Character[i], p2Const);
			playerTwoPanel.add(p2Character[i]);
		}
		p2Ready = new JButton("Ready!");
		p2Const.gridx = 0;
		p2Const.gridy = 20;
		p2Const.gridwidth = 5;
		p2Const.gridheight = 1;
		p2Const.fill = GridBagConstraints.NONE;
		p2Const.weightx = 0;
		p2Const.weighty = 0;
		player2Layout.setConstraints(p2Ready, p2Const);
		playerTwoPanel.add(p2Ready);
		
		// text area
		p2Desc = new JTextArea();
		p2Const.gridx = 0;
		p2Const.gridy = 19;
		p2Const.gridwidth = 5;
		p2Const.gridheight = 1;
		p2Const.fill = GridBagConstraints.BOTH;
		p2Const.weightx = 1;
		p2Const.weighty = 1;
		player2Layout.setConstraints(p2Desc, p2Const);
		playerTwoPanel.add(p2Desc);
		p2Desc.setEditable(false);
		
		p2Stats = new JTextArea();
		p2Const.gridx = 3;
		p2Const.gridy = 18;
		p2Const.gridwidth = 2;
		p2Const.gridheight = 1;
		p2Const.fill = GridBagConstraints.BOTH;
		p2Const.weightx = 0;
		p2Const.weighty = 0;
		player2Layout.setConstraints(p2Stats, p2Const);
		playerTwoPanel.add(p2Stats);
		p2Stats.setEditable(false);
		
		// Label
		p2Image = new JLabel(new ImageIcon("res/portraits/unknown.png"));
		p2Const.gridx = 0;
		p2Const.gridy = 18;
		p2Const.gridwidth = 3;
		p2Const.gridheight = 1;
		p2Const.fill = GridBagConstraints.NONE;
		p2Const.weightx = 0;
		p2Const.weighty = 0;
		player2Layout.setConstraints(p2Image, p2Const);
		playerTwoPanel.add(p2Image);
		
		update();
	}
	
	public void update() {
		boolean p1ReadyE = false;
		boolean p2ReadyE = false;
		for (int i = 0; i < model.length; i++) {
			if (selection[i] == 1) {
				p1ReadyE = true;
				p1Character[i].setEnabled(false);
				p1Character[i].setBackground(Color.RED);
				p2Character[i].setEnabled(false);
				p2Character[i].setBackground(Color.RED);
				p1Stats.setText("Height: " + model[i].getHeight() + " \n" 
								+ "Speed: "+ model[i].getSpeed() + "\n" 
								+ "Life: " + model[i].getLife());
				p1Desc.setText(model[i].getDescription());
			} else if (selection[i] == 2) {
				p2ReadyE = true;
				p2Character[i].setEnabled(false);
				p2Character[i].setBackground(Color.BLUE);
				p1Character[i].setEnabled(false);
				p1Character[i].setBackground(Color.BLUE);
				p2Stats.setText("Height: " + model[i].getHeight() + " \n" 
						+ "Speed: "+ model[i].getSpeed() + "\n" 
						+ "Life: " + model[i].getLife());
				p2Desc.setText(model[i].getDescription());
			} else {
				p1Character[i].setEnabled(true);
				p2Character[i].setBackground(Color.WHITE);
				p2Character[i].setEnabled(true);
				p1Character[i].setBackground(Color.WHITE);
			}
		}
		if (p1ReadyE)
			p1Ready.setEnabled(true);
		else
			p1Ready.setEnabled(false);

		if (p2ReadyE)
			p2Ready.setEnabled(true);
		else
			p2Ready.setEnabled(false);
		
		if(p1ReadyBool)
			p1Ready.setText("Un Ready");
		else
			p1Ready.setText("Ready!");
		if(p2ReadyBool) 
			p2Ready.setText("Un Ready");
		else
			p2Ready.setText("Ready!");
		
		if(p1ReadyBool && p2ReadyBool) {
			startGame.setEnabled(true);
		} else {
			startGame.setEnabled(false);
		}
	}
	
	public JButton getStart() { return startGame; }
	public JButton[] getP1Array() { return p1Character; }
	public JButton[] getP2Array() { return p2Character; }
}
