package windowsView;

import java.awt.Color;

import javax.swing.JPanel;

import constants.Config.FVMainPanel;

public class VMainPanel extends JPanel {
	//attributes
	private static final long serialVersionUID = 1L;
	//components
	
	private VsugangsincheonPanel vSungangsincheon;
	public VMainPanel() {
		super();
		//attributes
		this.setBackground(FVMainPanel.background);
		//components
		this.vSungangsincheon = new VsugangsincheonPanel();
		this.add(this.vSungangsincheon);
		
	}
	public void initialize() {
		this.vSungangsincheon.initialize();
	}
	
	
	
}
