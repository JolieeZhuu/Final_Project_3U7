/*
 * Names: Simone Ghosh and Jolie Zhu
 * Teacher: Ms. Strelkovska
 * Course: ICS3U7-1
 * Date: December 28
 * Description: Animations of Jeometry Dash
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Arrays;
import java.util.Scanner;

public class Platforms extends JPanel implements ActionListener {
	
	private ImageIcon triangle, triangle02, square, grid, rect, spike, spike02;
	private int row, col, cnt, delay, myX, myY;
	private int[][] platforms;
	private int[][] x;
	private int[][] y;
	private Timer timer;

	public Platforms() throws Exception{
		row = 9;
		col = 360;
		cnt = 0;
		delay = 1000/30;
		platforms = new int[row][col];
		x = new int[row][col];
		y = new int[row][col];
		
		createPlatforms("lvl01.csv");
		
		triangle = new ImageIcon("Images/triangleObst.png");
		triangle02 = new ImageIcon("Images/triangleObst02.png");
		square = new ImageIcon("Images/squareObst.png");
		grid = new ImageIcon("Images/gridObst.png");
		rect = new ImageIcon("Images/slabObst.png");
		spike = new ImageIcon("Images/spikeObst.png");
		spike02 = new ImageIcon("Images/spikeObst02.png");
		
		this.setLayout(new BorderLayout(0, 0));	
		timer = new Timer(delay, this);
		timer.start();
	} // end of constructor
	
	private void createPlatforms(String fileName) throws Exception {
		Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));

		while(sc.hasNextLine()) {
			for (int i = 0; i < platforms.length; i++) {
				String[] line = sc.nextLine().trim().split(",");
				for (int j = 0; j < line.length; j++)
					platforms[i][j] = Integer.parseInt(line[j]);
			}	
		}
	}
	
	// animation 
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == timer) {
			cnt++;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					x[i][j] = (j * 50) - (cnt * 15);
					y[i][j] = i * 50;
				}
			}
		}
	} // end of actionPerformed
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (platforms[i][j] == 1) {
					g.drawImage(triangle.getImage(), x[i][j], y[i][j], null);
					myX = x[i][j];
					myY = x[i][j];
				} else if (platforms[i][j] == 2) {
					g.drawImage(square.getImage(), x[i][j], y[i][j], null);
					myX = x[i][j];
					myY = x[i][j];
				} else if (platforms[i][j] == 3) {
					g.drawImage(grid.getImage(), x[i][j], y[i][j], null);
					myX = x[i][j];
					myY = x[i][j];
				} else if (platforms[i][j] == 4) {
					g.drawImage(rect.getImage(), x[i][j], y[i][j], null);
					myX = x[i][j];
					myY = x[i][j];
				} else if (platforms[i][j] == 5) {
					g.drawImage(spike.getImage(), x[i][j], y[i][j], null);
					myX = x[i][j];
					myY = x[i][j];
				} else if (platforms[i][j] == 6) {
					g.drawImage(triangle02.getImage(), x[i][j], y[i][j], null);
					myX = x[i][j];
					myY = x[i][j];
				} else if (platforms[i][j] == 7) {
					g.drawImage(spike02.getImage(), x[i][j], y[i][j], null);
					myX = x[i][j];
					myY = x[i][j];
				}
			}
		}
	} // end of paintComponent

	public int[][] getPlatforms() {
		return platforms;
	}

	public int[][] getXs() {
		return x;
	}

	public int[][] getYs() {
		return y;
	}
	
	public int getLeft(int i, int j) {
		return x[i][j];
	}
	
	public int getRight(int i, int j) {
		return x[i][j] + 50;
	}
	
	public int getTop(int i, int j) {
		return y[i][j];
	}
	
	public int getBottom(int i, int j) {
		return y[i][j] + 50;
	}
	
} // end of MovingBG class