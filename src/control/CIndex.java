package control;

import java.util.Vector;

import dataAccessObject.DIndex;
import valueObject.OIndex;

public class CIndex {
	
	private DIndex dIndex;
	public CIndex() {
		this.dIndex=new DIndex();
	}

	public Vector<OIndex> getAll(String fileName) {
		Vector<OIndex> indices = this.dIndex.readAll(fileName);
		return indices;
	}

}
