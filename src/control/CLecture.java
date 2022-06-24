package control;

import java.util.Vector;

import dataAccessObject.DLecture;
import valueObject.OLecture;

public class CLecture {
	
	private DLecture dLecture;
	public CLecture() {
		this.dLecture=new DLecture();
	}

	public Vector<OLecture> getAll(String fileName) {
		Vector<OLecture> lectures = this.dLecture.readAll(fileName);
		return lectures;
	}

	public Vector<OLecture> getAllList(String fileName) {
		Vector<OLecture> lectures = this.dLecture.readList(fileName);
		return lectures;
	}

	public Vector<OLecture> delete(String filename, String deleteId) {
		Vector<OLecture> modify = this.dLecture.readAElement(filename, deleteId);
		return modify;
	}

	public Vector<OLecture> sincheong(String filename, String sincheongId) {
		Vector<OLecture> sincheong = this.dLecture.readAElement2(filename, sincheongId);
		return sincheong;
	}



}
