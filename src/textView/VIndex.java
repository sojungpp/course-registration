package textView;

import java.util.Scanner;
import java.util.Vector;

import control.CIndex;
import valueObject.OIndex;

public class VIndex {

	private CIndex cIndex;
	private Scanner scanner;
	
	public VIndex(Scanner scanner) {
		this.scanner = scanner;
		this.cIndex = new CIndex();
	}
	
	public String show(String fileName, String message) {
		System.out.println(message+" ���� �ϼ���.");
		Vector<OIndex> indices = new Vector<OIndex>();
		indices = cIndex.getAll(fileName);
		for(OIndex index: indices) {
			System.out.println(index.getId() + " " + index.getName());
		}
		String id = this.scanner.next();
		for (OIndex index: indices) {
			if (index.getId().equals(id)) {
				return index.getFileName();
			}
		}
		return null;
	}

}
