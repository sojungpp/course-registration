package textView;

import java.util.Scanner;

import control.CHwewonDeungrok;
import valueObject.OHwewon;

public class VHwewon {

	private Scanner scanner;
	private VInitial vInitial;
	private CHwewonDeungrok cHwewonDeungrok;

	public VHwewon(Scanner scanner) {
		this.scanner=scanner;
		this.cHwewonDeungrok = new CHwewonDeungrok();
	}

	public void show(OHwewon oHwewon) {
		System.out.println("아이디 : "+oHwewon.getId()+" / 이름 : "+oHwewon.getName()+" / 주소 : "+oHwewon.getAddress()+" / 학과 : "+oHwewon.getHwakgwa());
		System.out.println("개인정보수정(1), 뒤로가기(2)");
		String input = scanner.next();
		
		if(input.equals("1")) {
			System.out.println("비밀번호(1), 이름(2), 주소(3), 학과(4), 뒤로가기(5)");
			String input2 = scanner.next();
			String changetype = input2;
			System.out.println("수정할 사항을 입력하세요.");
			String input3 = scanner.next();
			String change = input3;
			modify(oHwewon, changetype, change);
			vInitial = new VInitial(this.scanner);
			vInitial.showafterlogin(oHwewon);
		} else if (input.equals("2")) {
			vInitial = new VInitial(this.scanner);
			vInitial.showafterlogin(oHwewon);
		} else {
			System.out.println("잘못 입력하셨습니다."); 
			show(oHwewon);
		}
	}

	private void modify(OHwewon oHwewon, String changetype, String change) {
		if (changetype.equals("1")) {
			System.out.println("원래 비밀번호를 입력해주세요.");
			String input4 = scanner.next();
			if(input4.equals(oHwewon.getPassword()))
				oHwewon.setPassword(change);
			else {System.out.println("비밀번호가 같지 않습니다.");
				  show(oHwewon);}
		} else if (changetype.equals("2")) {
			oHwewon.setName(change);
		}  else if (changetype.equals("3")) {
			oHwewon.setAddress(change);
		}  else if (changetype.equals("4")) {
			oHwewon.setHwakgwa(change);
		} 
		this.cHwewonDeungrok.saveHwewon(oHwewon);
		System.out.println("수정되었습니다!");
	}


	
	

}
