package nirvana.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Label;
import java.util.HashMap;
import java.util.Vector;

import nirvana.gui.frame.FrameContainer;
import nirvana.gui.frame.Icon;

public class TabbedPanel extends FrameContainer {
	
	protected static final class HeaderPanel extends FrameContainer {
		
		private static final long serialVersionUID = 5779846301834319224L;
		
		final HashMap<InnerDialog, HeaderLabel> hmap;
		
		protected HeaderPanel() {
			
			super(new FlowLayout(FlowLayout.LEFT, 0, 0));
			this.hmap = new HashMap<InnerDialog, HeaderLabel>();
			
			this.setMinimumSize(new Dimension(160, 24));
			this.setPreferredSize(new Dimension(240, 24));
			this.setBackground(Colors.BACKGROUND_TRAY);
			this.setForeground(Colors.FOREGROUND);
			
		}
		
		public void addLabel(InnerDialog dialog) {
			HeaderLabel lbl = new HeaderLabel(dialog);
			this.addNode(lbl);
			this.hmap.put(dialog, lbl);
		}
		
		protected void removeLabel(InnerDialog dialog) {
			this.removeNode(dialog);
			this.hmap.remove(dialog);
		}
		
		protected void removeAllLabels() {
			this.removeAllNodes();
			this.hmap.clear();
		}
		
		@Override
		public final void paint(Graphics g) {
			super.paint(g);
			g.setColor(Colors.BORDER);
			int h = this.getHeight();
			g.drawLine(0, h - 1, this.getWidth() - 1, h - 1);
		}
		
	}
	
	protected static final class HeaderLabel extends FrameContainer {
		
		private static final long serialVersionUID = -1031383067980566434L;
		
		protected final Icon icon;
		protected final Label header;
		protected final Button cross;
		
		protected final InnerDialog dialog;
		
		protected boolean active = false;
		
		protected HeaderLabel(InnerDialog dialog) {
			
			super(new BorderLayout());
			this.dialog = dialog;
			
			this.setMinimumSize(new Dimension(40, 20));
			this.setPreferredSize(new Dimension(80, 20));
			this.setBackground(Colors.BACKGROUND);
			this.setForeground(Colors.FOREGROUND);
			
			this.icon = new Icon(dialog.icon);
			this.header = new Label(dialog.title, Label.LEFT);
			this.cross = new Button("×");
			this.cross.setVisible(false);
			
			this.addNode(this.icon, BorderLayout.WEST);
			this.addNode(this.header, BorderLayout.CENTER);
			this.addNode(this.cross, BorderLayout.EAST);
			
		}
		
		@Override
		public final void paint(Graphics g) {
			if(this.icon.getIcon() != this.dialog.icon)
				this.icon.setIcon(this.dialog.icon);
			if(!this.header.getText().equals(this.dialog.title))
				this.header.setText(this.dialog.title);
			if(this.cross.isVisible() ^ this.active)
				this.cross.setVisible(this.active);
			super.paint(g);
		}
		
	}
	
	protected final HeaderPanel header;
	
	protected final Vector<InnerDialog> dialogs;
	
	protected InnerDialog current = null;
	
	public TabbedPanel() {
		
		super(new BorderLayout());
		this.dialogs = new Vector<InnerDialog>();
		
		this.setMinimumSize(new Dimension(160, 100));
		this.setBackground(Colors.BACKGROUND_DISABLED);
		
		this.header = new HeaderPanel();
		
		this.addNode(this.header, BorderLayout.NORTH);
		
	}
	
	public final int getDialogCount() {
		return this.dialogs.size();
	}
	
	public final InnerDialog getDialog(int index) {
		return this.dialogs.get(index);
	}
	
	public final InnerDialog[] getDialogs() {
		InnerDialog[] arr = new InnerDialog[this.dialogs.size()];
		this.dialogs.toArray(arr);
		return arr;
	} 
	
	public final InnerDialog getCurrent() {
		return this.current;
	}
	
	public final void addDialog(InnerDialog dialog, int index) {
		if(index == -1) index = this.dialogs.size();
		this.header.addLabel(dialog);
		this.dialogs.add(index, dialog);
		if(this.current == null) this.addNode(dialog);
	}
	public final void addDialog(InnerDialog dialog) {
		this.addDialog(dialog, -1);
	}
	
	public final void removeDialog(int index) {
		this.removeDialog(this.dialogs.get(index));
	}
	public final void removeDialog(InnerDialog dialog) {
		this.header.removeLabel(dialog);
		this.dialogs.remove(dialog);
		if(this.current == dialog) {
			this.removeNode(dialog);
			this.current = null;
		}
	}
	
	public final void removeAllDialogs() {
		this.header.removeAllLabels();
		this.dialogs.clear();
		this.removeNode(this.current);
		this.current = null;
	}
	
	public final void setCurrent(int index) {
		if(this.current != null) this.removeNode(this.current);
		this.current = this.dialogs.get(index);
		this.addNode(this.current);
	}
	public final void setCurrent(InnerDialog dialog) {
		if(this.current != null) this.removeNode(this.current);
		this.current = this.dialogs.get(this.dialogs.indexOf(dialog));
		this.addNode(dialog);
	}
	
	public final void previous() {
		int index = this.dialogs.indexOf(this.current) - 1;
		if(index < 0) index = this.dialogs.size() - 1;
		this.setCurrent(index);
	}
	
	public final void next() {
		int index = this.dialogs.indexOf(this.current) + 1;
		if(index >= this.dialogs.size()) index = 0;
		this.setCurrent(index);
	}
	
}
