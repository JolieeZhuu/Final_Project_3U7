/*
 * Names: Simone Ghosh and Jolie Zhu
 * Teacher: Ms. Strelkovska
 * Course: ICS3U7-1
 * Date: January 19, 2023
 * Description: Instructions panel of Jeometry Dash
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyPopupPanel extends JPanel implements ActionListener {
	
	private JPanel buttonP; // declare instance variables
	private JButton[] buttons;
	private ImageIcon[] imgs;
	
	
	public MyPopupPanel() {
		
		buttonP = new JPanel(); // initialize variables
		
		imgs = new ImageIcon[6];
		buttons = new JButton[2];
		
		imgs[0] = new ImageIcon("Images/restartButton.png"); // images
		imgs[1] = new ImageIcon("Images/backToMenu.png");
		imgs[2] = new ImageIcon("Images/bg01.png");
		imgs[3] = new ImageIcon("Images/ground01.png");
		imgs[4] = new ImageIcon("Images/popUpImg.png");
		imgs[5] = new ImageIcon("Images/lvlIncomp.png");
		
		for (int i = 0; i < 2; i++) { // buttons
			buttons[i] = new JButton(imgs[i]);
			buttons[i].setOpaque(false); // transparent format
			buttons[i].setContentAreaFilled(false);
			buttons[i].setBorderPainted(false);
			buttons[i].addActionListener(this);
			buttonP.add(buttons[i]); // add buttons to panel
		}
		
		this.setLayout(new BorderLayout(0, 0));
		this.setBackground(Color.BLUE); // set base panel to be blue
		
		this.add(buttonP, BorderLayout.CENTER);
		buttonP.setOpaque(false); // set buttonP to be transparent
		buttonP.setLayout(new BoxLayout(buttonP, BoxLayout.X_AXIS));
		
		buttonP.add(Box.createRigidArea(new Dimension(150, 0))); // format buttons in terms of x
		buttonP.add(buttons[0]);
		buttonP.add(Box.createRigidArea(new Dimension(24, 0)));
		buttonP.add(buttons[1]);
		
	} // end of constructor

	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == buttons[1]) { // go back to levels menu
			JeometryDash.cardsL.show(JeometryDash.c, "Levels");
			JeometryDash.gameP.setIsLvlComp(false);
			JeometryDash.gameP.setIsLvlIncomp(false);
			JeometryDash.player.setYs(400, 400); // set player yPlatform and y to be 400
			
		} else if (e.getSource() == buttons[0]) { // restart the game
			JeometryDash.cardsL.show(JeometryDash.c, "JeometryDash");
			JeometryDash.gameTimer.start();
			JeometryDash.gameP.setIsClicked(); // reset all variables
			JeometryDash.gameP.setIsLvlComp(false);
			JeometryDash.gameP.setIsLvlIncomp(false);
			JeometryDash.player.setYs(400, 400); // reset player yPlatform and y to be 400
			JeometryDash.gameP.setLvlName("lvl0" + (JeometryDash.lvlP.getLvl() + 1) + ".csv");
			JeometryDash.gameP.setFocusable(true); // make sure that keyListener is focused in MyGamePanel
			JeometryDash.gameP.requestFocus();
		}
		
		if (JeometryDash.gameP.getIsLvlComp()) { // title image if game is incomplete
			imgs[5] = new ImageIcon("Images/lvlComp.png");
		} else if (JeometryDash.gameP.getIsLvlIncomp()) { // title image if game is complete
			imgs[5] = new ImageIcon("Images/lvlIncomp.png");			
		}
		repaint();
		
	} // end of actionPerformed

	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.drawImage(imgs[2].getImage(), 0, 0, null); // background image
		g.drawImage(imgs[3].getImage(), 0, 450, null); // ground image
		g.drawImage(imgs[4].getImage(), 50, 50, null); // pop-up (board) image
		g.drawImage(imgs[5].getImage(), (getWidth() - imgs[5].getIconWidth()) / 2, 75, null); // title image

	} // end of paintComponent

	
} // end of MyInstPanel class