package valueObject;

import model.MHwewon;

public class OHwewon {

	private String id;
	private String password;
	private String name;
	private String address;
	private String hwakgwa;
	
	public OHwewon() {
		// TODO Auto-generated constructor stub
	}
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	public String getHwakgwa() {return hwakgwa;}
	public void setHwakgwa(String hwakgwa) {this.hwakgwa = hwakgwa;}

	public void set(MHwewon mHwewon) {
		this.id = mHwewon.getId();
		this.password = mHwewon.getPassword();
		this.name = mHwewon.getName();
		this.address = mHwewon.getAddress();
		this.hwakgwa = mHwewon.getHwakgwa();
		
	}
		
	}

