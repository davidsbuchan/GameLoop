package uk.co.ashndave.game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class DrawHelper {
	private Image dbImage = null;
	private Graphics dbg;
	private Component componentToDrawOnto;
	private int width, height;
	
	public DrawHelper(Component componentToDrawOnto) {
		this.componentToDrawOnto = componentToDrawOnto;
		width = componentToDrawOnto.getWidth();
		height = componentToDrawOnto.getHeight();
	}
	
	public boolean initRender() {
		if(dbImage == null) {
			dbImage = componentToDrawOnto.createImage(componentToDrawOnto.getWidth(), componentToDrawOnto.getHeight());
			if(dbImage == null) {
				System.out.println("dbImage is still null");
				return false;
			} else {
				dbg = dbImage.getGraphics();
			}
		}
		return true;
	}
	
	public void paintScreen() {
		Graphics g;
		try {
			g = componentToDrawOnto.getGraphics();
			if((g != null) && (dbImage != null)) {
				g.drawImage(dbImage, 0, 0, null);
			}
			Toolkit.getDefaultToolkit().sync();
			g.dispose();
		} catch(Exception ex) {
			System.out.println("Failed on paintScreen: " + ex);
		}
	}

	public Graphics getDbg() {
		return dbg;
	}
	
	public void clearScreen() {
		dbg.setColor(Color.white);
		dbg.fillRect(0, 0, width, height);
	}
}
