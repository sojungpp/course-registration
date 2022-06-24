package windowsView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import valueObject.OIndex;
import valueObject.OLecture;
import windowsView.VIndex;


public class VGangjwaSelectionPanel extends JPanel {
	//attributes
	private static final long serialVersionUID = 1L;
	//components

	private VIndex vCampus;
	private VIndex vCollege;
	private VIndex vHwakgwa;
	private OLecture oLecture;
	
	private VGangjwa vGangjwa;
	public VGangjwaSelectionPanel() {
		//attributes
		//components
		super();
		
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);
		
		JPanel seceltPanel = new JPanel();
		layoutManager = new BoxLayout(seceltPanel, BoxLayout.Y_AXIS);
		seceltPanel.setLayout(layoutManager);
		
		
			JScrollPane scrollPane;
			this.vCampus = new VIndex();
			scrollPane = new JScrollPane(this.vCampus);
			scrollPane.setPreferredSize(new Dimension(100,100));
			seceltPanel.add(scrollPane);
			
			this.vCollege = new VIndex();
			scrollPane = new JScrollPane(this.vCollege);
			scrollPane.setPreferredSize(new Dimension(100,100));
			seceltPanel.add(scrollPane);
			
			this.vHwakgwa = new VIndex();
			scrollPane = new JScrollPane(this.vHwakgwa);
			scrollPane.setPreferredSize(new Dimension(100,100));
			seceltPanel.add(scrollPane);
			
			this.vGangjwa = new VGangjwa();
			scrollPane = new JScrollPane(this.vGangjwa);
			scrollPane.setPreferredSize(new Dimension(400,200));
			seceltPanel.add(scrollPane);	
			
		this.add(seceltPanel, BorderLayout.EAST);
	}
	public void initialize() {
		this.vCampus.initialize();
		this.vCollege.initialize();
		this.vHwakgwa.initialize();
		this.vGangjwa.initialize();
	}
	
	public OLecture getData(String fileName) {
		OIndex oIndex;
		this.vCampus.getData(fileName);
		this.vCollege.getData("seoul");
		this.vHwakgwa.getData("ict");
		this.vGangjwa.getData("computer");
		return oLecture;
	}

	 private class JTableMouseListener implements MouseListener{   
         public void mouseClicked(java.awt.event.MouseEvent e) {    
             
             VIndex vCampus = (VIndex)e.getSource();
             int row = vCampus.getSelectedRow();                
             int col = vCampus.getSelectedColumn();         
         
             System.out.println(vCampus.getValueAt(row, col));   
                 
         }

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	 }}

