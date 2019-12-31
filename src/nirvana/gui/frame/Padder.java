package nirvana.gui.frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;

public class Padder<E extends Component> extends Panel {
	
	private static final long serialVersionUID = -1703397829660304275L;
	
	protected final E component;
	
	protected Insets margin;
	protected Insets border;
	
	protected Color color = Appearance.BORDER;
	
	public Padder(E comp, Insets m, Insets b) {
		
		super(null);
		this.component = comp;
		if(m == null || b == null) throw new NullPointerException();
		this.margin = m;
		this.border = b;
		
		super.addImpl(comp, null, -1);
		
		this.addHierarchyBoundsListener(new HierarchyBoundsListener() {
			public void ancestorResized(HierarchyEvent e) {
				Padder.this.updateBounds();
			}
			public void ancestorMoved(HierarchyEvent e) {
				Padder.this.updateBounds();
			}
		});
		
	}
	public Padder(E comp) {
		this(comp, new Insets(0, 0, 0, 0), new Insets(1, 1, 1, 1));
	}
	
	@Override
	@Deprecated
	public final int getComponentCount() {
		return super.getComponentCount();
	}
	
	@Override
	@Deprecated
	public final Component getComponent(int i) {
		return super.getComponent(i);
	}
	
	@Override
	@Deprecated
	public final Component[] getComponents() {
		return super.getComponents();
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
	
	@Override
	@Deprecated
	public final void remove(int i) {}
	
	@Override
	@Deprecated
	public final void remove(Component comp) {}
	
	@Override
	@Deprecated
	public final void removeAll() {}
	
	@Override
	@Deprecated
	public final void setLayout(LayoutManager mgr) {}
	
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
