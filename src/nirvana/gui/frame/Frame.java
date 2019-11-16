package nirvana.gui.frame;

import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Panel;

abstract class Frame extends Panel {
	
	private static final long serialVersionUID = -7272497066639669493L;
	
	protected Frame(LayoutManager mgr) {
		super(mgr);
	}
	
	int getNodeCount() {
		return super.getComponentCount();
	}
	
	@Override
	@Deprecated
	public final int getComponentCount() {
		return super.getComponentCount();
	}
	
	Component getNode(int i) {
		return super.getComponent(i);
	}
	
	@Override
	@Deprecated
	public final Component getComponent(int i) {
		return super.getComponent(i);
	}
	
	Component[] getNodes() {
		return super.getComponents();
	}
	
	@Override
	@Deprecated
	public final Component[] getComponents() {
		return super.getComponents();
	}
	
	void addNode(Component comp, Object constr, int i) {
		super.addImpl(comp, constr, i);
	}
	
	void addNode(Component comp, Object constr) {
		/* 注意：由于子类可能重写方法，不能调用this.addNode(Component, Object, int)。 */
		super.addImpl(comp, constr, -1);
	}
	void addNode(Component comp) {
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
	
	void removeNode(int i) {
		super.remove(i);
	}
	void removeNode(Component comp) {
		super.remove(comp);
	}
	
	@Override
	@Deprecated
	public final void remove(int i) {}
	@Override
	@Deprecated
	public final void remove(Component comp) {}
	
	void removeAllNodes() {
		super.removeAll();
	}
	
	@Override
	@Deprecated
	public final void removeAll() {}
	
}
