package nirvana.gui.frame;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;
import java.io.Serializable;

import nirvana.session.Session;
import nirvana.session.Session.SessionObject;

public class EmbedDialog implements Serializable, SessionObject {
	
	private static final long serialVersionUID = 2882521144044058827L;
	
	protected Image icon;
	protected String title;
	
	protected final Frame container;
	
	protected IHeader header;
	
	protected boolean active = false;
	
	public EmbedDialog(Image icon, String title, Frame cont) {
		
		this.icon = icon;
		if(title == null) throw new NullPointerException();
		this.title = title;
		this.container = cont;
		
		this.container.setMinimumSize(new Dimension(160, 80));
		this.container.setBackground(Appearance.BACKGROUND);
		this.container.setForeground(Appearance.FOREGROUND);
		
	}
	public EmbedDialog(String title, Frame cont) {
		this(null, title, cont);
	}
	
	protected EmbedDialog(Image icon, String title, LayoutManager mgr) {
		this(icon, title, Frame.createBare(mgr));
	}
	protected EmbedDialog(String title, LayoutManager mgr) {
		this(null, title, mgr);
	}
	protected EmbedDialog(LayoutManager mgr) {
		this(null, "Dialog", mgr);
	}
	
	public Session getSession() {
		return this.container.session;
	}
	
	public Image getIcon() {
		return this.icon;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public Frame getContainer() {
		return this.container;
	}
	
	public IHeader getHeader() {
		return this.header;
	}
	
	public boolean isActive() {
		return this.active;
	}
	
	public void setIcon(Image icon) {
		this.icon = icon;
		if(this.header != null) this.header.notifyIcon(icon);
	}
	
	public void setTitle(String title) {
		if(title == null) throw new NullPointerException();
		this.title = title;
		if(this.header != null) this.header.notifyTitle(title);
	}
	
	public void setHeader(IHeader header) {
		this.header = header;
	}
	
	public void setActive(boolean active) {
		EmbedDialog dialog = this.container.session.getActiveDialog();
		if(dialog != null && dialog != this) dialog.header.notifyActive(false);
		if(active ^ this.active) {
			this.active = active;
			if(this.header != null) this.header.notifyActive(active);
		}
	}
	
	protected int getNodeCount() {
		return this.container.getNodeCount();
	}
	
	protected Component getNode(int i) {
		return this.container.getNode(i);
	}
	
	protected Component[] getNodes() {
		return this.container.getNodes();
	}
	
	protected void addNode(Component comp, Object constr, int i) {
		this.container.addNode(comp, constr, i);
	}
	
	protected void addNode(Component comp, Object constr) {
		this.container.addNode(comp, constr);
	}
	protected void addNode(Component comp) {
		this.container.addNode(comp);
	}
	
	protected void removeNode(int i) {
		this.container.removeNode(i);
	}
	
	protected void removeNode(Component comp) {
		this.container.removeNode(comp);
	}
	
	protected void removeAllNodes() {
		this.container.removeAllNodes();
	}
	
}
