package textView;

import java.util.Scanner;

import control.CHwewonDeungrok;
import valueObject.OHwewon;

public class VHwewonDeungrok {
	
	private Scanner scanner;
	private CHwewonDeungrok cHwewonDeungrok;
	
	public VHwewonDeungrok(Scanner scanner) {
		this.scanner=scanner;
		this.cHwewonDeungrok = new CHwewonDeungrok();
	}

	public void show() {
		
		System.out.println("회원정보를 입력 하세요");
		OHwewon oHwewon = new OHwewon();
		
		System.out.println("아이디:");
		String id = scanner.next();
		oHwewon.setId(id);
		
		System.out.println("비밀번호:");
		String password = scanner.next();
		oHwewon.setPassword(password);
		
		System.out.println("이름:");
		String name = scanner.next();
		oHwewon.setName(name);
		
		System.out.println("주소:");
		String address = scanner.next();
		oHwewon.setAddress(address);
		
		System.out.println("학과:");
		String hwakgwa = scanner.next();
		oHwewon.setHwakgwa(hwakgwa);
		
		this.cHwewonDeungrok.saveHwewon(oHwewon);
	}
}
