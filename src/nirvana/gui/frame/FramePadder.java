package nirvana.gui.frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;

import nirvana.gui.Colors;

public class FramePadder extends FrameBox<Frame> {
	
	protected Insets margin;
	protected Insets border;
	
	protected Color color = Colors.BORDER;
	
	public FramePadder(Frame cont, Insets m, Insets b) {
		
		super(cont);
		if(m == null || b == null) throw new NullPointerException();
		this.margin = m;
		this.border = b;
		
		this.addHierarchyBoundsListener(new HierarchyBoundsListener() {
			public void ancestorResized(HierarchyEvent e) {
				FramePadder.this.updateBounds();
			}
			public void ancestorMoved(HierarchyEvent e) {
				FramePadder.this.updateBounds();
			}
		});
		
	}
	public FramePadder(Frame cont) {
		this(cont, new Insets(0, 0, 0, 0), new Insets(1, 1, 1, 1));
	}
	
	@SuppressWarnings("serial")
	protected FramePadder(LayoutManager mgr, Insets m, Insets b) {
		this(new Frame(mgr) {}, m , b);
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
	public Dimension getMinimumSize() {
		if(this.isMinimumSizeSet()) return super.getMinimumSize();
		else {
			Dimension ms = this.component.getMinimumSize(), s = this.getShrink();
			ms.setSize(ms.width + s.width, ms.height + s.height);
			return ms;
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		if(this.isPreferredSizeSet()) return super.getPreferredSize();
		else {
			Dimension ps = this.component.getPreferredSize(), s = this.getShrink();
			ps.setSize(ps.width + s.width, ps.height + s.height);
			return ps;
		}
	}
	
	public Insets getMargin() {
		return this.margin;
	}
	
	public Insets getBorder() {
		return this.border;
	}
	
	public Dimension getShrink() {
		return new Dimension(
			this.margin.left + this.border.left + this.margin.right + this.border.right,
			this.margin.top + this.border.top + this.margin.bottom + this.border.bottom
		);
	}
	
	public Color getBorderColor() {
		return this.color;
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
	
	public void setMargin(Insets m) {
		if(m == null) throw new NullPointerException();
		this.margin = m;
	}
	
	public void setBorder(Insets b) {
		if(b == null) throw new NullPointerException();
		this.border = b;
	}
	
	public void setBorderColor(Color c) {
		if(c == null) throw new NullPointerException();
		this.color = c;
	}
	
	protected void updateBounds() {
		Point pos = new Point(
			this.margin.left + this.border.left, this.margin.top + this.border.top
		);
		if(!this.component.getLocation().equals(pos))
			this.component.setLocation(pos);
		pos.translate(
			this.margin.right + this.border.right, this.margin.bottom + this.border.bottom
		);
		Dimension s = this.getSize();
		s.setSize(s.width - pos.x, s.height - pos.y);
		if(!this.component.getSize().equals(s))
			this.component.setSize(s);
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(this.color);
		Dimension ss = this.getSize(), s = this.getShrink();
		ss.setSize(ss.width - s.width, ss.height - s.height);
		g.fillRect(this.margin.left, this.margin.top, ss.width, ss.height);
		super.paint(g);
	}
	
}
