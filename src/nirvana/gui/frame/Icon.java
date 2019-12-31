package nirvana.gui.frame;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class Icon extends Component {
	
	private static final long serialVersionUID = 7073945636128358014L;
	
	protected Image icon;
	
	public Icon(Image icon) {
		
		super();
		if(icon == null) icon = Appearance.ICON_FILE;
		this.icon = icon;
		
		this.setMinimumSize(new Dimension(20, 16));
		this.setPreferredSize(new Dimension(20, 20));
		
	}
	
	public Image getIcon() {
		return this.icon;
	}
	
	public void setIcon(Image icon) {
		if(icon == null) throw new NullPointerException();
		this.icon = icon;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int dx = (this.getWidth() - 16) / 2,
			dy = (this.getHeight() - 16) / 2;
		g.drawImage(this.icon, dx, dy, 16, 16, this);
	}
	
}
