package nirvana.gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.util.Vector;

import nirvana.gui.frame.FrameContainer;

public class SidebarViewPanel extends FrameContainer {
	
	protected final Panel panel;
	
	protected final Vector<Panel> sidebars;
	
	public SidebarViewPanel(Panel panel) {
		
		super(new GridBagLayout());
		this.panel = panel;
		this.sidebars = new Vector<Panel>();
		
		panel.setPreferredSize(panel.getMinimumSize());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = GridBagConstraints.REMAINDER;
		gbc.weightx = 0.8;
		gbc.weighty = 1.0;
		
		this.addNode(panel, gbc);
		
	}
	
	public Panel getPanel() {
		return this.panel;
	}
	
	public int getSidebarCount() {
		return this.sidebars.size();
	}
	
	public Panel getSidebar(int index) {
		return this.sidebars.get(index);
	}
	
	public Panel[] getSidebars() {
		return (Panel[])this.sidebars.toArray();
	}
	
	public void addSidebar(DialogPanel panel, int index, double weight) {
		if(index == -1) index = this.sidebars.size();
		panel.setPreferredSize(panel.getMinimumSize());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.weightx = 0.2;
		gbc.weighty = weight;
		this.addNode(panel, gbc, index + 1);
		this.sidebars.add(index, panel);
	}
	public void addSidebar(DialogPanel panel, double weight) {
		this.addSidebar(panel, -1, weight);
	}
	
	public void removeSidebar(int index) {
		this.removeNode(index + 1);
		this.sidebars.remove(index);
	}
	public void removeSidebar(Component comp) {
		if(comp != this.panel) this.removeNode(comp);
		this.sidebars.remove(comp);
	}
	
	public void removeAllSidebars() {
		this.removeAllNodes();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = GridBagConstraints.REMAINDER;
		gbc.weightx = 0.8;
		gbc.weighty = 1.0;
		this.addNode(this.panel, gbc);
		this.sidebars.clear();
	}
	
}
