package windowsView;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import control.CIndex;
import control.CLecture;
import valueObject.OIndex;
import valueObject.OLecture;

public class VIndex extends JTable {
	private static final long serialVersionUID = 1L;
	
	//associations
	private CIndex cIndex;
	private DefaultTableModel model;
	public VIndex() {
		super();
		//attributes
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//components
		this.model = (DefaultTableModel) this.getModel();
		model.addColumn("강좌명");
		
		//associations
		//고정적 초기화
	}

	public void initialize() {
		this.model.setNumRows(0);
	}
	public Vector<OIndex> getData(String fileName) {
		this.cIndex = new CIndex();
		Vector<OIndex> oIndices = this.cIndex.getAll(fileName);
		
		String[] row = new String[model.getColumnCount()];
		for(OIndex oIndex: oIndices) {
			row[0] = oIndex.getName();
			model.addRow(row);
		}
		this.updateUI();
		return oIndices;
		
	}

}
