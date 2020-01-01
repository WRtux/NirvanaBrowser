package nirvana.gui.frame;

import java.awt.LayoutManager;
import java.awt.Panel;

public abstract class FrameBox<E extends Panel> extends Frame {
	
	private static final long serialVersionUID = -5664189605094248400L;
	
	protected final E component;
	
	protected FrameBox(E comp, LayoutManager mgr) {
		super(mgr);
		this.component = comp;
	}
	
	protected FrameBox(E comp) {
		
		super(null);
		this.component = comp;
		
		/* 注意：由于子类可能重写方法，不能调用this.addNode(Component)。 */
		this.addImpl(comp, null, -1);
		
	}
	
	public E getComponent() {
		return this.component;
	}
	
}
