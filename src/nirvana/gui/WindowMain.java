package nirvana.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;

public class WindowMain extends Frame {
	
	public final SidebarViewPanel workspace;
	
	public final Panel statusBar;
	
	public WindowMain() {
		super("Nirvana Browser");
		this.setLocationRelativeTo(null);
		this.setSize(640, 480);
		this.setMinimumSize(new Dimension(480, 320));
		this.setLayout(new BorderLayout());
		this.workspace = new SidebarViewPanel(new TabbedPanel());
		((TabbedPanel)this.workspace.panel).addDialog(new InnerDialog("File0"));
		this.workspace.addSidebar(new DialogPanel(new InnerDialog()), 0.6);
		this.workspace.addSidebar(new DialogPanel(new InnerDialog()), 0.4);
		this.statusBar = new Panel(new FlowLayout(FlowLayout.LEFT));
		this.statusBar.setPreferredSize(new Dimension(0, 20));
		this.statusBar.setBackground(Colors.BACKGROUND_TRAY);
		this.add(this.workspace, BorderLayout.CENTER);
		this.add(this.statusBar, BorderLayout.SOUTH);
	}
	
}
