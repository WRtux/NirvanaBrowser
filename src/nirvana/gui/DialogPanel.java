package nirvana.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;

import nirvana.gui.frame.Appearance;
import nirvana.gui.frame.Frame;
import nirvana.gui.frame.FramePadder;
import nirvana.gui.frame.Icon;

@Deprecated
public class DialogPanel extends Frame {
	
	protected static class HeaderPanel extends FramePadder {
		
		protected final Icon icon;
		protected final Label header;
		protected final Button cross;
		
		protected final InnerDialog dialog;
		
		@SuppressWarnings("serial")
		protected HeaderPanel(InnerDialog dialog) {
			
			super(new Frame(new BorderLayout()) {}, new Insets(0, 0, 0, 0), new Insets(0, 0, 1, 0));
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
		
		@Override
		public void paint(Graphics g) {
			if(this.icon.getIcon() != this.dialog.icon)
				this.icon.setIcon(this.dialog.icon);
			if(!this.header.getText().equals(this.dialog.title))
				this.header.setText(this.dialog.title);
			super.paint(g);
		}
		
	}
	
	protected final HeaderPanel header;
	protected final InnerDialog dialog;
	
	public DialogPanel(InnerDialog dialog) {
		
		super(new BorderLayout());
		this.dialog = dialog;
		
		this.setMinimumSize(new Dimension(160, 100));
		
		this.header = new HeaderPanel(dialog);
		
		this.addNode(this.header, BorderLayout.NORTH);
		this.addNode(this.dialog, BorderLayout.CENTER);
		
	}
	
	public final InnerDialog getDialog() {
		return this.dialog;
	}
	
	public final Image getIcon() {
		return this.dialog.icon;
	}
	
	public final String getTitle() {
		return this.dialog.title;
	}
	
	public final boolean isActive() {
		return this.dialog.isActive();
	}
	
}
