package nirvana.session;

import java.io.Serializable;
import java.util.Vector;

import nirvana.gui.frame.EmbedDialog;

public class Session implements Serializable {
	
	public static interface ISessionObject {
		
		public Session getSession();
		
	}
	
	protected static final Vector<Session> vectSession = new Vector<Session>();
	
	public EmbedDialog getActiveDialog() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
