package nirvana.gui.frame;

import java.awt.Component;
import java.awt.LayoutManager;

public abstract class FrameContainer extends Frame {
	
	private static final long serialVersionUID = -8989142480788180804L;
	
	protected FrameContainer(LayoutManager mgr) {
		super(mgr);
	}
	
	@Override
	protected int getNodeCount() {
		return super.getNodeCount();
	}
	
	@Override
	protected Component getNode(int i) {
		return super.getNode(i);
	}
	
	@Override
	protected Component[] getNodes() {
		return super.getNodes();
	}
	
	@Override
	protected void addNode(Component comp, Object constr, int i) {
		super.addNode(comp, constr, i);
	}
	
	@Override
	protected void addNode(Component comp, Object constr) {
		super.addNode(comp, constr);
	}
	@Override
	protected void addNode(Component comp) {
		super.addNode(comp);
	}
	
	@Override
	protected void removeNode(int i) {
		super.removeNode(i);
	}
	@Override
	protected void removeNode(Component comp) {
		super.removeNode(comp);
	}
	
	@Override
	protected void removeAllNodes() {
		super.removeAllNodes();
	}
	
}
