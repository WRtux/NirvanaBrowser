package nirvana.gui.frame;

import java.awt.Image;

public interface IHeader {
	
	public void notifyIcon(Image icon);
	
	public void notifyTitle(String title);
	
	public void notifyActive(boolean active);
	
}
