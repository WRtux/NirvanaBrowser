package nirvana.gui.frame;

import java.awt.LayoutManager;
import java.util.ArrayList;

public abstract class FrameView extends Frame {
	
	protected final ArrayList<Frame> frames;
	
	protected FrameView(LayoutManager mgr) {
		super(mgr);
		this.frames = new ArrayList<Frame>();
	}
	
	public Frame[] getFrames() {
		return (Frame[])this.frames.toArray();
	}
	
	/**
	 * 在指定位置添加框架。
	 * 子类应重写此方法并实现组件的添加。
	 */
	public void addFrame(Frame frame, Object constr, int i) {
		this.frames.add(frame);
	}
	
	
	public void addFrame(Frame frame, Object constr) {
		this.addFrame(frame, constr, -1);
	}
	
}
