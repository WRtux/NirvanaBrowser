package nirvana.gui.frame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;

public class DialogBox extends FrameBox<Frame> {
	
	protected static class Header extends FramePadder implements IHeader {
		
		protected final Icon icon;
		protected final Label header;
		protected final Button cross;
		
		protected final EmbedDialog dialog;
		
		protected Header(EmbedDialog dialog) {
			
			super(new BorderLayout(), new Insets(0, 0, 0, 0), new Insets(0, 0, 1, 0));
			this.dialog = dialog;
			
			this.setMinimumSize(new Dimension(160, 20));
			this.setPreferredSize(new Dimension(160, 20));
			this.setBackground(Appearance.BACKGROUND_TRAY);
			this.setForeground(Appearance.FOREGROUND);
			
			this.icon = new Icon(dialog.icon);
			this.header = new Label(dialog.title, Label.LEFT);
			this.cross = new Button("×");
			
			this.addNode(this.icon, BorderLayout.WEST);
			this.addNode(this.header, BorderLayout.CENTER);
			this.addNode(this.cross, BorderLayout.EAST);
			
		}
		
		public void notifyIcon(Image icon) {
			this.icon.setIcon(icon);
		}
		
		public void notifyTitle(String title) {
			this.header.setText(title);
		}
		
		public void notifyActive(boolean active) {
			if(active) this.setBackground(Appearance.BACKGROUND_HIGHLIGHT);
			else this.setBackground(Appearance.BACKGROUND_TRAY);
		}
		
		@Override
		public void paint(Graphics g) {
			if(this.icon.getIcon() != this.dialog.icon)
				this.icon.setIcon(this.dialog.icon);
			if(!this.header.getText().equals(this.dialog.title))
				this.header.setText(this.dialog.title);
			super.paint(g);
		}
		
	}
	
	protected final EmbedDialog dialog;
	protected final Header header;
	
	public DialogBox(EmbedDialog dialog) {
		
		super(dialog.container, new BorderLayout());
		this.dialog = dialog;
		
		this.header = new Header(dialog);
		
		this.addNode(this.header, BorderLayout.NORTH);
		this.addNode(this.dialog.container, BorderLayout.CENTER);
		
	}
	
	public EmbedDialog getDialog() {
		return this.dialog;
	}
	
	public Image getIcon() {
		return this.dialog.icon;
	}
	
	public String getTitle() {
		return this.dialog.title;
	}
	
	public boolean isActive() {
		return this.dialog.isActive();
	}
	
}
