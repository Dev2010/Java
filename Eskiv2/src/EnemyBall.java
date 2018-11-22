import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class EnemyBall extends EskivBall{

	boolean direction; //horz or vert
	boolean bounce; //which way to bounce

    public EnemyBall() {
		super((int)(Math.random()*552)+1,(int)(Math.random()*275)+1);
		int z=(int)(Math.random()*2);
		if (z>0){
			direction=true; //vertical
		} else direction=false; //horizontal
	}

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillOval(xPos, yPos, 15, 15);
    }

    public void move() {
        int y;
        int z;
        if (direction){ //horz or vert?
			y=yPos;
			z=275;
		} else{
			y=xPos;
			z=552;
		}

		if (bounce){ //change var
			if (y==0){
				bounce=false;
			} else y--;
		} else {
			if (y==z){
				bounce=true;
			} else y++;
		}

        if (direction){ //change pos
			yPos=y;
		} else xPos=y;
    }

    public void keyPressed(KeyEvent e) {
    }


    public void keyReleased(KeyEvent e) {
    }

    public Rectangle getBorder() {
        return new Rectangle(xPos, yPos, 11, 11);
    }


}