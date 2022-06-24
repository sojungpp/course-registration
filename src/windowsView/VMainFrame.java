package windowsView;

import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JFrame;

import constants.Config.FVMainFrame;
import textView.VSugangsincheon;

public class VMainFrame extends JFrame {
	//attributes
	private static final long serialVersionUID = 1L;
	
	//components(자식)
	private VMainPanel vMainPanel;

	public VMainFrame() {
		super(); //JFrame이 가진 속성 실행하라는 뜻
		//attributes
		this.setLocation(FVMainFrame.Location);
		this.setSize(FVMainFrame.size);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//components
		this.vMainPanel = new VMainPanel();
		this.add(this.vMainPanel);
		
	}
	public void initialize() {
		//variable attributes
		
		//components initialize
		this.vMainPanel.initialize();
	}
	
	public static void main(String[] args) {
		VMainFrame vMain = new VMainFrame();
		vMain.initialize();
		
		vMain.setVisible(true);
	}

}
