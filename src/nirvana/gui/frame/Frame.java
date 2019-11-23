package nirvana.gui.frame;

import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.Panel;

import nirvana.session.Session;
import nirvana.session.Session.ISessionObject;

public abstract class Frame extends Panel implements ISessionObject {
	
	private static final long serialVersionUID = 1948547306166606899L;
	
	protected Session session;
	
	protected Frame(LayoutManager mgr) {
		super(mgr);
	}
	
	public Session getSession() {
		return this.session;
	}
	
	protected int getNodeCount() {
		return super.getComponentCount();
	}
	
	@Override
	@Deprecated
	public final int getComponentCount() {
		return super.getComponentCount();
	}
	
	protected Component getNode(int i) {
		return super.getComponent(i);
	}
	
	@Override
	@Deprecated
	public final Component getComponent(int i) {
		return super.getComponent(i);
	}
	
	protected Component[] getNodes() {
		return super.getComponents();
	}
	
	@Override
	@Deprecated
	public final Component[] getComponents() {
		return super.getComponents();
	}
	
	protected void addNode(Component comp, Object constr, int i) {
		super.addImpl(comp, constr, i);
	}
	
	protected void addNode(Component comp, Object constr) {
		/* 注意：由于子类可能重写方法，不能调用this.addNode(Component, Object, int)。 */
		super.addImpl(comp, constr, -1);
	}
	protected void addNode(Component comp) {
		/* 注意：由于子类可能重写方法，不能调用this.addNode(Component, Object, int)。 */
		super.addImpl(comp, null, -1);
	}
	
	@Override
	@Deprecated
	protected final void addImpl(Component comp, Object constr, int i) {}
	
	@Override
	@Deprecated
	public final void add(Component comp, Object constr, int i) {}
	
	@Override
	@Deprecated
	public final void add(Component comp, Object constr) {}
	@Override
	@Deprecated
	public final Component add(Component comp) {
		return null;
	}
	
	protected void removeNode(int i) {
		super.remove(i);
	}
	protected void removeNode(Component comp) {
		super.remove(comp);
	}
	
	@Override
	@Deprecated
	public final void remove(int i) {}
	@Override
	@Deprecated
	public final void remove(Component comp) {}
	
	protected void removeAllNodes() {
		super.removeAll();
	}
	
	@Override
	@Deprecated
	public final void removeAll() {}
	
	@Override
	@Deprecated
	public final void setLayout(LayoutManager mgr) {
		super.setLayout(mgr);
	}
	
	@Override
	public void addNotify() {
		super.addNotify();
		Container cont = this.getParent();
		if(cont instanceof ISessionObject)
			this.session = ((ISessionObject)cont).getSession();
	}
	
	@Override
	public void removeNotify() {
		this.session = null;
		super.removeNotify();
	}
	
}
