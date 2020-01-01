package nirvana.gui.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import nirvana.gui.frame.Frame;
import nirvana.gui.frame.FrameView;

public class SidebarView extends FrameView {
	
	protected final Frame main;
	
	public SidebarView(Frame main) {
		
		super(new GridBagLayout());
		this.main = main;
		
		main.setPreferredSize(main.getMinimumSize());
		
		this.addNode(main, this.createMainConstraints());
		
	}
	
	public Frame getMain() {
		return this.main;
	}
	
	protected GridBagConstraints createMainConstraints() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = GridBagConstraints.REMAINDER;
		gbc.weightx = 0.8;
		gbc.weighty = 1.0;
		return gbc;
	}
	
	protected GridBagConstraints createSidebarConstraints(double w) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.weightx = 0.2;
		gbc.weighty = w;
		return gbc;
	}
	
	@Override
	public void addFrame(Frame frm, Object w, int i) {
		double dw = ((Number)w).doubleValue();
		if(i == -1) i = this.frames.size();
		frm.setPreferredSize(frm.getMinimumSize());
		this.addNode(frm, this.createSidebarConstraints(dw), i + 1);
		super.addFrame(frm, w, i);
	}
	
	@Override
	public void removeFrame(int i) {
		this.removeNode(i + 1);
		super.removeFrame(i);
	}
	
	@Override
	public void removeFrame(Frame frm) {
		if(frm != this.main) this.removeNode(frm);
		super.removeFrame(frm);
	}
	
	@Override
	public void removeAllFrames() {
		this.removeAllNodes();
		super.removeAllFrames();
		this.addNode(this.main, this.createMainConstraints());
	}
	
}
