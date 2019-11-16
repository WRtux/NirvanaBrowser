package nirvana.gui.frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;

import nirvana.gui.Colors;

public class Padder<E extends Component> extends FrameBox<E> {
	
	private static final long serialVersionUID = 9022051934582222429L;
	
	protected final Insets margin;
	protected final Insets border;
	
	protected Color color;
	
	public Padder(E comp, Insets m, Insets b) {
		
		super(comp);
		if(m == null || b == null) throw new NullPointerException();
		this.margin = m;
		this.border = b;
		this.color = Colors.BORDER;
		
		Dimension s = comp.getMinimumSize();
		this.setMinimumSize(new Dimension(
			s.width + b.left + b.right, s.height + b.top + b.bottom
		));
		s = comp.getPreferredSize();
		this.setPreferredSize(new Dimension(
			s.width + b.left + b.right, s.height + b.top + b.bottom
		));
		
	}
	public Padder(E comp) {
		this(comp, new Insets(0, 0, 0, 0), new Insets(1, 1, 1, 1));
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
		this.updateBounds();
		g.setColor(this.color);
		Dimension s = this.getSize();
		s.setSize(s.width - this.margin.right, s.height - this.margin.bottom);
		g.fillRect(
			this.margin.left, this.margin.top,
			s.width - this.margin.left, s.height - this.margin.top
		);
		super.paint(g);
	}
	
}
