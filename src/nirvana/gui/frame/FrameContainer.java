package nirvana.gui.frame;

import java.awt.Component;
import java.awt.LayoutManager;

@Deprecated
public class FrameContainer extends Frame {
	
	private static final long serialVersionUID = 6905585860559797638L;
	
	protected FrameContainer(LayoutManager mgr) {
		super(mgr);
	}
	
	@Override
	public int getNodeCount() {
		return super.getNodeCount();
	}
	
	@Override
	public Component getNode(int i) {
		return super.getNode(i);
	}
	
	@Override
	public Component[] getNodes() {
		return super.getNodes();
	}
	
	@Override
	public void addNode(Component comp, Object constr, int i) {
		super.addNode(comp, constr, i);
	}
	
	@Override
	public void addNode(Component comp, Object constr) {
		super.addNode(comp, constr);
	}
	@Override
	public void addNode(Component comp) {
		super.addNode(comp);
	}
	
	@Override
	public void removeNode(int i) {
		super.removeNode(i);
	}
	@Override
	public void removeNode(Component comp) {
		super.removeNode(comp);
	}
	
	@Override
	public void removeAllNodes() {
		super.removeAllNodes();
	}
	
}
