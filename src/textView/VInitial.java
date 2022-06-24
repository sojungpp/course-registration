package textView;

import java.io.IOException;
import java.util.Scanner;

import valueObject.OHwewon;
import valueObject.OLecture;

public class VInitial {
	private Scanner scanner;
	private VHwewonDeungrok hwewonDeungrok;
	private VLogin login;
	private VMiridamgi vMiridamgi;
	private VSugangsincheon vSugangsincheon;
	private VHwewon vHwewon;
	
	public VInitial(Scanner scanner) {
		this.scanner=scanner;
		this.hwewonDeungrok = new VHwewonDeungrok(this.scanner);
		this.login = new VLogin(this.scanner);
		this.vHwewon = new VHwewon(this.scanner);
	}

	public void show() {
			System.out.println("다음 기능을 선택 하세요.");
			System.out.println("로그인(1), 회원등록(2), 종료(3)");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.next();
				if (input.equals("1")) {
					OHwewon oHwewon = this.login.show();
					System.out.println(oHwewon.getName()+"님 안녕하세요");
					showafterlogin(oHwewon);
			}else if (input.equals("2")) {
				this.hwewonDeungrok.show();
				show();
			} 
			else if (input.equals("3")) {
				System.exit(0);
			}
			else {
				System.out.println("잘못 입력하셨습니다.");
				show();
			}
			scanner.close();
	}
	
	void showafterlogin(OHwewon oHwewon) {
				System.out.println("수강신청(1), 책가방(2), 회원정보(3), 로그아웃(4)");
				String input2 = scanner.next();
			
				if(input2.equals("1")) {
					if(oHwewon != null) {
						this.vSugangsincheon = new VSugangsincheon(this.scanner);
						this.vSugangsincheon.show(oHwewon);}	
				} else if (input2.equals("2")) {
					this.vMiridamgi = new VMiridamgi(this.scanner);
					this.vMiridamgi.show(oHwewon);
				} else if (input2.equals("3")) {
					this.vHwewon.show(oHwewon);
					show();
				} else if (input2.equals("4")) {
					oHwewon=null;
					show();
				} else {System.out.println("잘못 입력하셨습니다.");
					show();
				}
	}
			
	}
	

