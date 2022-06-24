package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import model.MHwewon;
import model.MIndex;
import model.MLecture;
import valueObject.OHwewon;
import valueObject.OIndex;
import valueObject.OLecture;
import valueObject.OLogin;

public class DLecture {
	
	private static final String PATHNAME = "lectures/";
	private MLecture mLecture = new MLecture();
	public DLecture() {
	}
	
	public Vector<OLecture> readAll(String fileName) {
		Vector<OLecture> lectures = new Vector<OLecture>();
		try {
			File file = new File(PATHNAME+fileName);
			Scanner scanner = new Scanner(file);
			while(mLecture.read(scanner)) {
				OLecture oLecture = new OLecture();
				oLecture.set(mLecture);
				lectures.add(oLecture);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return lectures;
	}
	
	public Vector<OLecture> readList(String fileName) {
		Vector<OLecture> lectures = new Vector<OLecture>();
		try {
			File file = new File("user/"+fileName);
			if (file.exists()) {
			Scanner scanner = new Scanner(file);
			while(mLecture.read(scanner)) {
				OLecture oLecture = new OLecture();
				oLecture.set(mLecture);
				lectures.add(oLecture);
			} 
			scanner.close();
			} else {System.out.println("내역이 없습니다.");}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return lectures;  
	}
	
	public Vector<OLecture> readAElement(String fileName, String key) {
		Vector<OLecture> element = new Vector<OLecture>();
		try {
			File file = new File("user/"+fileName);
			Scanner scanner = new Scanner(file);
			while(mLecture.read(scanner)) {
				if(mLecture.getId().equals(key)) {
					this.delete(fileName, key);
				}
				OLecture oLecture = new OLecture();
				oLecture.set(mLecture);
				element.add(oLecture);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return element;
		
	}
	
	public MLecture delete(String filename, String deleteId) {
		this.readList(filename);
			mLecture.setId("");
			mLecture.setName("");
			mLecture.setCredit("");
			mLecture.setTime("");
			mLecture.setProfessor("");
			
			return mLecture;
		}
	
	public Vector<OLecture> readAElement2(String fileName, String key) {
		Vector<OLecture> element = new Vector<OLecture>();
		try {
			File file = new File("user/"+fileName);
			Scanner scanner = new Scanner(file);
			while(mLecture.read(scanner)) {
				if(mLecture.getId().equals(key)) {
				OLecture oLecture = new OLecture();
				oLecture.set(mLecture);
				element.add(oLecture); }
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return element;
		
	}
		
	}
