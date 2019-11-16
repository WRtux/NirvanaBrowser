package nirvana.gui.frame;

import java.awt.Component;
import java.awt.Insets;
import java.awt.LayoutManager;

public abstract class FramePadder extends Padder<FrameContainer> {
	
	private static final long serialVersionUID = -8013469567189605530L;
	
	protected FramePadder(FrameContainer cont, Insets m, Insets b) {
		super(cont, m, b);
	}
	protected FramePadder(FrameContainer cont) {
		this(cont, new Insets(0, 0, 0, 0), new Insets(1, 1, 1, 1));
	}
	
	@SuppressWarnings("serial")
	protected FramePadder(LayoutManager mgr, Insets m, Insets b) {
		this(new FrameContainer(mgr) {}, m, b);
	}
	protected FramePadder(LayoutManager mgr) {
		this(mgr, new Insets(0, 0, 0, 0), new Insets(1, 1, 1, 1));
	}
	
	@Override
	protected int getNodeCount() {
		return this.component.getNodeCount();
	}
	
	@Override
	protected Component getNode(int i) {
		return this.component.getNode(i);
	}
	
	@Override
	protected Component[] getNodes() {
		return this.component.getNodes();
	}
	
	@Override
	protected void addNode(Component comp, Object constr, int i) {
		this.component.addNode(comp, constr, i);
	}
	
	@Override
	protected void addNode(Component comp, Object constr) {
		this.component.addNode(comp, constr);
	}
	@Override
	protected void addNode(Component comp) {
		this.component.addNode(comp);
	}
	
	@Override
	protected void removeNode(int i) {
		this.component.removeNode(i);
	}
	@Override
	protected void removeNode(Component comp) {
		this.component.removeNode(comp);
	}
	
	@Override
	protected void removeAllNodes() {
		this.component.removeAllNodes();
	}
	
}
