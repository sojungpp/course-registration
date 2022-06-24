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
		System.out.println("���̵� : "+oHwewon.getId()+" / �̸� : "+oHwewon.getName()+" / �ּ� : "+oHwewon.getAddress()+" / �а� : "+oHwewon.getHwakgwa());
		System.out.println("������������(1), �ڷΰ���(2)");
		String input = scanner.next();
		
		if(input.equals("1")) {
			System.out.println("��й�ȣ(1), �̸�(2), �ּ�(3), �а�(4), �ڷΰ���(5)");
			String input2 = scanner.next();
			String changetype = input2;
			System.out.println("������ ������ �Է��ϼ���.");
			String input3 = scanner.next();
			String change = input3;
			modify(oHwewon, changetype, change);
			vInitial = new VInitial(this.scanner);
			vInitial.showafterlogin(oHwewon);
		} else if (input.equals("2")) {
			vInitial = new VInitial(this.scanner);
			vInitial.showafterlogin(oHwewon);
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�."); 
			show(oHwewon);
		}
	}

	private void modify(OHwewon oHwewon, String changetype, String change) {
		if (changetype.equals("1")) {
			System.out.println("���� ��й�ȣ�� �Է����ּ���.");
			String input4 = scanner.next();
			if(input4.equals(oHwewon.getPassword()))
				oHwewon.setPassword(change);
			else {System.out.println("��й�ȣ�� ���� �ʽ��ϴ�.");
				  show(oHwewon);}
		} else if (changetype.equals("2")) {
			oHwewon.setName(change);
		}  else if (changetype.equals("3")) {
			oHwewon.setAddress(change);
		}  else if (changetype.equals("4")) {
			oHwewon.setHwakgwa(change);
		} 
		this.cHwewonDeungrok.saveHwewon(oHwewon);
		System.out.println("�����Ǿ����ϴ�!");
	}


	
	

}
