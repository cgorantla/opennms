package org.opennms;

import org.apache.sshd.ClientSession;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * This class creates a window to hold the terminal emulator
 * 
 * @author lmbell
 * @author pdgrenon
 *
 */
@SuppressWarnings("serial")
public class SSHWindow extends Window {

	private SSHTerminal terminal; // The terminal emulator
	
	/**
	 * The constructor for the SSH window
	 * 
	 * @param app The main application to which this window should be attached
	 * @param session The current SSH session
	 * @param width The width of the window
	 * @param height The height of the window
	 */
	public SSHWindow(TerminalApplication app, ClientSession session, int width, int height) {
		setCaption("SSH");
		setImmediate(true);
		setResizable(false);
		this.setWidth("" + width + "px");
		this.setHeight(""+ height + "px");
		terminal = new SSHTerminal(app, this, session, 80, 24);
		VerticalLayout vPanel = new VerticalLayout();
		vPanel.setWidth("100%");
		vPanel.setHeight("100%");
		int posX = (int)(app.getMainWindow().getWidth() - this.getWidth())/2;
		int posY = (int)(app.getMainWindow().getHeight() - this.getHeight())/2;
		this.setPositionX(posX);
		this.setPositionY(posY);
		vPanel.addComponent(terminal);
		vPanel.setComponentAlignment(terminal, Alignment.TOP_CENTER);
        addComponent(vPanel);
	}
	
	/**
	 * Overrides the window close method to instead close the terminal
	 */
	@Override
	public void close(){
		terminal.close();
	}

}
