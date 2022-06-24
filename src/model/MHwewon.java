package model;

import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import valueObject.OHwewon;

public class MHwewon {

	private String id;
	private String password;
	private String name;
	private String address;
	private String hwakgwa;

	
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public boolean read(Scanner scanner) {
		if (scanner.hasNext()) {
			this.id = scanner.next();
			this.password = scanner.next();
			this.name = scanner.next();
			this.address = scanner.next();
			this.hwakgwa = scanner.next();
			return true;
		}
		return false;
	}
	
	private void set(OHwewon oHwewon) {
		this.id = oHwewon.getId();
		this.password = oHwewon.getPassword();
		this.name = oHwewon.getName();
		this.address = oHwewon.getAddress();
		this.hwakgwa = oHwewon.getHwakgwa();
	}
	
	public void save(FileWriter fileWriter, OHwewon oHwewon) {
		this.set(oHwewon);
		
		try {
			fileWriter.write(id+ "\n");
			fileWriter.write(password+ "\n");
			fileWriter.write(name+ "\n");
			fileWriter.write(address+ "\n");
			fileWriter.write(hwakgwa+ "\n");
			
			fileWriter.flush();
	} catch(IOException e) {
		e.printStackTrace();
	}
}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHwakgwa() {
		return hwakgwa;
	}

	public void setHwakgwa(String hwakgwa) {
		this.hwakgwa = hwakgwa;
	}

	public void setId(String id) {
		this.id = id;
	}


	}
