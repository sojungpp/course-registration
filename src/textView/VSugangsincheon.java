package textView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Vector;
import java.io.IOException;

import control.CIndex;
import control.CLecture;
import model.MHwewon;
import model.MLecture;
import valueObject.OHwewon;
import valueObject.OIndex;
import valueObject.OLecture;

public class VSugangsincheon {

	private Scanner scanner;

	
	private VIndex vCampus;
	private VIndex vCollege;
	private VIndex vDepartment;
	private VLecture vLecture;
	private VInitial vInitial;

	public VSugangsincheon(Scanner scanner) {
		this.scanner = scanner;
		this.vCampus = new VIndex(this.scanner);
		this.vCollege = new VIndex(this.scanner);
		this.vDepartment = new VIndex(this.scanner);
		this.vLecture = new VLecture(this.scanner);
	}

	public void show(OHwewon oHwewon) {
		System.out.println("���°˻�(1), ��������Ȯ��(2), �ڷΰ���(3)");
		String input = scanner.next();
		
		if(input.equals("1")) {
			this.search(oHwewon);
		} else if (input.equals("2")) {
			this.list(oHwewon);
		} else if (input.equals("3")) {
			vInitial = new VInitial(this.scanner);
			vInitial.showafterlogin(oHwewon);
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�."); 
			show(oHwewon);
		}
	}
	
	public void search(OHwewon oHwewon) {
		System.out.println("���� ��û�� �����մϴ�.");
		System.out.println("���°˻�(1), �������°˻�(2), �ڷΰ���(3)");
		String input2 = scanner.next();
		if(input2.equals("1")) {
		
		String campusFileName = this.vCampus.show("root", "ķ�۽���");
		if (campusFileName != null) {
		String collegeFileName = this.vCollege.show(campusFileName, "������");
		if (campusFileName != null) {
		String departmentFileName = this.vDepartment.show(collegeFileName, "�а���");
		if (campusFileName != null) {
		OLecture oLecture = this.vLecture.show(departmentFileName, "���¸�");
		this.write(oLecture,oHwewon);
		}}}}
		 else if(input2.equals("2")) {
			 String HwewonHwakgwa = oHwewon.getHwakgwa();
			OLecture oLecture = this.vLecture.show(HwewonHwakgwa, oHwewon.getName()+"���� �а� "+oHwewon.getHwakgwa()+" ���¸�");
			this.write(oLecture,oHwewon);
		 }
		 else if(input2.equals("3")){
			 show(oHwewon);
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�."); 
			search(oHwewon);
		}
	}
	
	private void write(OLecture oLecture, OHwewon oHwewon) {
		FileWriter fileWriter;
		try {
			File file = new File(oHwewon.getId()+"S");
			fileWriter = new FileWriter("user/"+file,true);
			Scanner scanner = new Scanner("user/"+file);
						
			CLecture cLecture = new CLecture();
			Vector<OLecture> lectures = cLecture.getAllList(oHwewon.getId()+"S");
			int id2 = Integer.parseInt(oLecture.getId());
			for(OLecture lecture: lectures) {
				for(int i=0; i<10; i++) {
					int id1 = Integer.parseInt(lecture.getId());
					if(id1==id2) {
						System.out.println("�̹� ��û�� �����Դϴ�.");
						search(oHwewon);
					} 
					else if (lecture.getProfessor().equals(oLecture.getProfessor())) {System.out.println("���� �ð��� ���� ��û�� �� �����ϴ�.");
					search(oHwewon);}
				}  
			}
				fileWriter.write(oLecture.getId()+" "
							+oLecture.getName()+" "
							+oLecture.getCredit()+" "
							+oLecture.getTime()+" "
							+oLecture.getProfessor()+"\r\n");
			fileWriter.flush();
			System.out.println("������û �Ϸ�ƽ��ϴ�.");
			search(oHwewon);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void list(OHwewon oHwewon) {
		CLecture cLecture = new CLecture();
		Vector<OLecture> lectures = cLecture.getAllList(oHwewon.getId()+"S");
		if(lectures == null) {System.out.println("���������� �����ϴ�.");}
		System.out.println(oHwewon.getName()+"���� ��������");

		
		for(OLecture lecture: lectures) {
			System.out.println(lecture.getId() + " " + lecture.getName()+ " " + lecture.getCredit()+ " " + lecture.getTime()+ " " + lecture.getProfessor());
		}
		
		System.out.println("�����߰�(1), ���»���(2), �̸�����߰�(3), �ڷΰ���(4)");
		String input2 = this.scanner.next();
		if(input2.equals("1")) {
			this.search(oHwewon);
		} else if (input2.equals("2")) {
			System.out.println("������ ������ id�� �Է��ϼ���");
			Vector<OLecture> modify = new Vector<OLecture>();
			String deleteId = this.scanner.next();
			modify = cLecture.delete(oHwewon.getId()+"S",deleteId);
			
			
			for(OLecture lecture: modify) {
			
			FileWriter fileWriter;
			try {
				String deletename = oHwewon.getId()+"S";
				File file2 = new File("user/"+deletename);
				file2.delete();
				File file = new File(oHwewon.getId()+"S");
				fileWriter = new FileWriter("user/"+file,true);
				Scanner scanner = new Scanner("user/"+file);
					fileWriter.write(lecture.getId()+" "
								+lecture.getName()+" "
								+lecture.getCredit()+" "
								+lecture.getTime()+" "
								+lecture.getProfessor()+"\r\n");
				fileWriter.flush();
			} catch (IOException e) {
				e.printStackTrace();
				}	
			}
			System.out.println("�����ƽ��ϴ�.");
			list(oHwewon);
			System.exit(0);
		} else if (input2.equals("3")) {
			System.out.println("��û�� ������ id�� �Է��ϼ���");
			Vector<OLecture> sincheong = new Vector<OLecture>();
			String sincheongId = this.scanner.next();
			sincheong = cLecture.sincheong(oHwewon.getId()+"S",sincheongId);
			
			
			for(OLecture lecture: sincheong) {
			
			FileWriter fileWriter;
			try {
				File file = new File(oHwewon.getId()+"M");
				fileWriter = new FileWriter("user/"+file,true);
				Scanner scanner = new Scanner("user/"+file);
				
				Vector<OLecture> lectures2 = cLecture.getAllList(oHwewon.getId()+"M");
				int id2 = Integer.parseInt(sincheongId);
				for(OLecture lecture2: lectures2) {
					for(int i=0; i<10; i++) {
						int id1 = Integer.parseInt(lecture2.getId());
						if(id1==id2) {
							System.out.println("�̹� ��û�� �����Դϴ�.");
							search(oHwewon);
						} else if (lecture2.getProfessor().equals(lecture.getProfessor())) {
							System.out.println("���� �ð��� ���� ��û�� �� �����ϴ�.");
							search(oHwewon);
						}
					}
				}
				
					fileWriter.write(lecture.getId()+" "
								+lecture.getName()+" "
								+lecture.getCredit()+" "
								+lecture.getTime()+" "
								+lecture.getProfessor()+"\r\n");
				fileWriter.flush();
				System.out.println("�̸���⿡ ��û�ƽ��ϴ�.");
				list(oHwewon);
			} catch (IOException e) {
				e.printStackTrace();
				}	
		} 
		} else if (input2.equals("4")) {
			show(oHwewon);
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�."); 
			list(oHwewon);
		}
	}
}


