package nirvana.gui.frame;

import java.awt.Component;
import java.awt.LayoutManager;
import java.util.ArrayList;

public abstract class FrameView extends Frame {
	
	private static final long serialVersionUID = -6559248200194682207L;
	
	protected final ArrayList<Frame> frames;
	
	protected FrameView(LayoutManager mgr) {
		super(mgr);
		this.frames = new ArrayList<Frame>();
	}
	
	public int getFrameCount() {
		return this.frames.size();
	}
	
	public Component getFrame(int i) {
		return this.frames.get(i);
	}
	
	public Frame[] getFrames() {
		return (Frame[])this.frames.toArray();
	}
	
	/**
	 * 在指定位置添加框架。
	 * 子类应重写此方法并实现组件的添加。
	 */
	public void addFrame(Frame frm, Object constr, int i) {
		this.frames.add(frm);
	}
	
	public void addFrame(Frame frm, Object constr) {
		this.addFrame(frm, constr, -1);
	}
	
	/**
	 * 移除指定位置的框架。
	 * 子类应重写此方法并实现组件的移除。
	 */
	public void removeFrame(int i) {
		this.frames.remove(i);
	}
	
	/**
	 * 移除指定框架。
	 * 子类应重写此方法并实现组件的移除。
	 */
	public void removeFrame(Frame frm) {
		this.frames.remove(frm);
	}
	
	/**
	 * 移除所有框架。
	 * 子类应重写此方法并实现组件的移除。
	 */
	public void removeAllFrames() {
		this.frames.clear();
	}
	
}
