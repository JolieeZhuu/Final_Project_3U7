/*
 * Names: Simone Ghosh and Jolie Zhu
 * Teacher: Ms. Strelkovska
 * Course: ICS3U7-1
 * Date: January 18, 2023
 * Description: Blocks of Jeometry Dash
 */

import java.awt.*;
import javax.swing.*;

public class Platforms {
	
	protected int x, y; // declare instance variables
	protected Image img;
	

	public Platforms(int x, int y, String imgName) {
		
		this.x = x; // initialize variables
		this.y = y;
		img = new ImageIcon(imgName).getImage();

	} // end of constructor
	
	
	public void setX(int x) {
		
		this.x = x;
		
	} // end of setX
	
	
	public int getX(int x) {
		
		return x;
		
	} // end of getX
	
	
	public void setY(int y) {
		
		this.y = y;
		
	} // end of setY
	
	
	public int getY() {
		
		return y;
		
	} // end of getY
	
	
	public int getYPlatform() {
		
		return 0;
		
	} // end of getYPlatform

	
	public int getSpeed() {
		
		return 0;
		
	} // end of getSpeed
	

	public void setSpeed(int speed) {
	} // end of setSpeed
	
	
	public void setImage(String imgName) {
		
		img = new ImageIcon(imgName).getImage();
		
	} // end of setImage
	
	
	public void jump() {
	} // end of jump
	
	
	public void fall() {
	} // end of fall
	
	public void draw(Graphics g) {
		
		g.drawImage(img, x, y, 50, 50, null);
		
	} // end of draw
	
	
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, 50, 50);
		
	} // end of getBounds

} // end of Platforms class