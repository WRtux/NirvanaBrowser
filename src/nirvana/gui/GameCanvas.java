package nirvana.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class GameCanvas extends Canvas {
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(new Color(0xCCCCCC));
	}
	
}
