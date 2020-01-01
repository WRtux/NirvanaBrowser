package nirvana.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import nirvana.gui.frame.Appearance;
import nirvana.gui.frame.DialogBox;
import nirvana.gui.frame.EmbedDialog;
import nirvana.gui.view.SidebarView;

public class WindowMain extends Frame {
	
	protected static class EmptyDialog extends EmbedDialog {
		
		protected EmptyDialog() {
			super(new BorderLayout());
		}
		
	}
	
	public final SidebarView workspace;
	
	public final Panel statusBar;
	
	public WindowMain() {
		
		super("Nirvana Browser");
		
		this.setLocationByPlatform(true);
		this.setSize(640, 480);
		this.setMinimumSize(new Dimension(480, 320));
		this.setLayout(new BorderLayout());
		
		this.workspace = new SidebarView(new TabbedPanel());
		((TabbedPanel)this.workspace.getMain()).addDialog(new InnerDialog("File0"));
		this.workspace.addFrame(new DialogBox(new EmptyDialog()), 0.6);
		this.workspace.addFrame(new DialogBox(new EmptyDialog()), 0.4);
		this.statusBar = new Panel(new FlowLayout(FlowLayout.LEFT));
		this.statusBar.setPreferredSize(new Dimension(0, 20));
		this.statusBar.setBackground(Appearance.BACKGROUND_TRAY);
		this.statusBar.add(new Label("Done"));
		
		this.add(this.workspace, BorderLayout.CENTER);
		this.add(this.statusBar, BorderLayout.SOUTH);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				WindowMain.this.setVisible(false);
				System.exit(0);
			}
		});
		
	}
	
}
