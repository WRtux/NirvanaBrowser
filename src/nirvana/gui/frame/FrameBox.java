package nirvana.gui.frame;

import java.awt.Component;

public abstract class FrameBox<E extends Component> extends Frame {
	
	private static final long serialVersionUID = 6731337915989879113L;
	
	final E component;
	
	protected FrameBox(E comp) {
		
		super(null);
		this.component = comp;
		
		super.addNode(comp);
		
	}
	
	protected E getComponent() {
		return this.component;
	}
	
}
