/*
 * Names: Simone Ghosh and Jolie Zhu
 * Teacher: Ms. Strelkovska
 * Course: ICS3U7-1
 * Date: January 5, 2023
 * Description: Obstacles and platforms of Jeometry Dash
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Platforms extends JPanel implements ActionListener {
	
	private ImageIcon triangle, triangle02, square, grid, rect, spike, spike02; // declare instance variables
	private int row, col, cnt, delay;
	private int[][] platforms;
	private int[][] old;
	private int[][] x;
	private int[][] y;
	private Timer timer;

	public Platforms() throws Exception {
		
		row = 9; // initialize variables
		col = 360;
		cnt = 0;
		delay = 1000/30;
		platforms = new int[row][col];
		old = new int[row][col];
		x = new int[row][col];
		y = new int[row][col];

		triangle = new ImageIcon("Images/triangleObst.png");
		triangle02 = new ImageIcon("Images/triangleObst02.png");
		square = new ImageIcon("Images/squareObst.png");
		grid = new ImageIcon("Images/gridObst.png");
		rect = new ImageIcon("Images/slabObst.png");
		spike = new ImageIcon("Images/spikeObst.png");
		spike02 = new ImageIcon("Images/spikeObst02.png");
		
		createPlatforms("lvl01.csv"); // call method
		
		this.setLayout(new BorderLayout(0, 0));	
		timer = new Timer(delay, this);
		timer.start();
		
	} // end of constructor
	
	
	private void createPlatforms(String fileName) throws Exception {
		
		Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));

		while (sc.hasNextLine()) { // read excel file to get platforms
			for (int i = 0; i < platforms.length; i++) {
				String[] line = sc.nextLine().trim().split(",");
				for (int j = 0; j < line.length; j++) {
					platforms[i][j] = Integer.parseInt(line[j]);
					old[i][j] = platforms[i][j];
				}
			}	
		}
		
	} // end of createPlatforms
	
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == timer) { // platform animations and where they are placed
			cnt++;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					x[i][j] = (j * 50) - (cnt * 15);
					y[i][j] = i * 50;
				}
			}
		}
		
	} // end of actionPerformed
	
	/*
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					x[i][j] = (j * 50) - (cnt * 15);
					y[i][j] = i * 50;
					
					if (x[i][j] < -75)
						platforms[i][j] = 0;
				}
			}
			if (cnt > 1200) {
				cnt=0;
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) 
						platforms[i][j] = old[i][j];
				}
			}
			else
				cnt++;
		}
	} // end of actionPerformed
	*/
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		for (int i = 0; i < row; i++) { // go through the 2D array and draw each platform and obstacle
			for (int j = 0; j < col; j++) {
				if (platforms[i][j] == 1) {
					g.drawImage(triangle.getImage(), x[i][j], y[i][j], null);
				} else if (platforms[i][j] == 2) {
					g.drawImage(square.getImage(), x[i][j], y[i][j], null);
				} else if (platforms[i][j] == 3) {
					g.drawImage(grid.getImage(), x[i][j], y[i][j], null);
				} else if (platforms[i][j] == 4) {
					g.drawImage(rect.getImage(), x[i][j], y[i][j], null);
				} else if (platforms[i][j] == 5) {
					g.drawImage(spike.getImage(), x[i][j], y[i][j], null);
				} else if (platforms[i][j] == 6) {
					g.drawImage(triangle02.getImage(), x[i][j], y[i][j], null);
				} else if (platforms[i][j] == 7) {
					g.drawImage(spike02.getImage(), x[i][j], y[i][j], null);
				}
			}
		}
		
	} // end of paintComponent

	
	public int[][] getPlatforms() {
		return platforms;
	} // end of getPlatforms

	public int getXs(int i, int j) {
		return x[i][j];
	} // end of getXs

	public int getYs(int i, int j) {
		return y[i][j];
	} // end of getYs
	
} // end of Platforms class