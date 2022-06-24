package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.MHwewon;
import valueObject.OHwewon;

public class DHwewonDeungrok {
	private MHwewon mHwewon = new MHwewon();
	
	public DHwewonDeungrok() {		
	}
	
	public OHwewon read(String id) {
		
		try {
			File file = new File("hwewon");
			Scanner scanner = new Scanner(file);
			while(mHwewon.read(scanner)) {
				if(mHwewon.getId().equals(id)) {
					OHwewon oHwewon = new OHwewon();
					oHwewon.set(mHwewon);
					return oHwewon;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(OHwewon oHwewon) {
		try {
			File file = new File("hwewon");
			FileWriter fileWriter = new FileWriter(file,true);
			mHwewon.save(fileWriter, oHwewon);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	



}
