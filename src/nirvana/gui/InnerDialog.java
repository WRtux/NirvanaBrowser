package nirvana.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Panel;

public class InnerDialog extends Panel {
	
	private static final long serialVersionUID = -797346299368002663L;
	
	protected Image icon;
	protected String title;
	
	protected boolean active = false;
	
	public InnerDialog(Image icon, String title) {
		
		super(new BorderLayout());
		this.icon = icon;
		if(title == null) throw new NullPointerException();
		this.title = title;
		
		this.setMinimumSize(new Dimension(160, 80));
		this.setBackground(Colors.BACKGROUND);
		this.setForeground(Colors.FOREGROUND);
		
	}
	public InnerDialog(String title) {
		this(null, title);
	}
	public InnerDialog() {
		this(null, "Dialog");
	}
	
	public final Image getIcon() {
		return this.icon;
	}
	
	public final String getTitle() {
		return this.title;
	}
	
	public final boolean isActive() {
		return this.active;
	}
	
	public final void setIcon(Image icon) {
		this.icon = icon;
	}
	
	public final void setTitle(String title) {
		if(title == null) throw new NullPointerException();
		this.title = title;
	}
	
}
