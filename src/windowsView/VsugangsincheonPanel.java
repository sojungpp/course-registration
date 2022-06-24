package windowsView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import constants.Config.FVMainPanel;

public class VsugangsincheonPanel extends JPanel {
		//attributes
		private static final long serialVersionUID = 1L;
		//components
		private VGangjwaSelectionPanel vGangjwaSelectionPanel;
		private VGangjwa vGangjwaSelection;
		private VGangjwa vMiridamgi;
		private VGangjwa vSincheong;
		
		
		public VsugangsincheonPanel() {
			super();
			//attributes
			this.setBackground(FVMainPanel.background);
			//components
			LayoutManager layoutManager = new BorderLayout();
			this.setLayout(layoutManager);
			
			this.vGangjwaSelectionPanel = new VGangjwaSelectionPanel();
			this.add(this.vGangjwaSelectionPanel, BorderLayout.WEST);	
		
		JPanel miriSincheongPanel = new JPanel();
		layoutManager = new BoxLayout(miriSincheongPanel, BoxLayout.Y_AXIS);
		miriSincheongPanel.setLayout(layoutManager);
			
			JScrollPane scrollPane;
			this.vMiridamgi = new VGangjwa();
			scrollPane = new JScrollPane(this.vMiridamgi);
			scrollPane.setPreferredSize(new Dimension(400,100));
			miriSincheongPanel.add(scrollPane);
			
			this.vSincheong = new VGangjwa();
			scrollPane = new JScrollPane(this.vSincheong);
			scrollPane.setPreferredSize(new Dimension(400,100));
			miriSincheongPanel.add(scrollPane);
			
		this.add(miriSincheongPanel, BorderLayout.EAST);
	}
	
	public void initialize() {
		this.vGangjwaSelectionPanel.initialize();
		this.vGangjwaSelectionPanel.getData("root");
		
		this.vMiridamgi.initialize();
		this.vMiridamgi.getData("history");
		
		this.vSincheong.initialize();
		this.vSincheong.getData("english");
	}
	
}


