package textView;

import java.util.Scanner;

import control.CHwewonDeungrok;
import control.CLogin;
import valueObject.OHwewon;
import valueObject.OLogin;

public class VLogin {
	
	private Scanner scanner;
	private CLogin cLogin;
	private VInitial vInitial;
	
	public VLogin(Scanner scanner) {
		this.scanner=scanner;
		this.cLogin = new CLogin();
	}

	public OHwewon show() {
		System.out.println("���̵�� ��й�ȣ �Է� �ϼ���. �ڷΰ���(0)");
		OLogin oLogin = new OLogin();
		
		System.out.println("���̵�:");
		String id = scanner.next();
		if(id.equals("0")) {
			vInitial = new VInitial(this.scanner);
			vInitial.show();
		}
		oLogin.setId(id);
		
		System.out.println("��й�ȣ:");
		String password = scanner.next();
		oLogin.setPassword(password);
		
		OHwewon oHwewon = this.cLogin.validate(oLogin); 
		if (oHwewon != null) {
			return oHwewon;
		}else {
			System.out.println("���̵�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
			show();
			return null;
		}
	}
}
