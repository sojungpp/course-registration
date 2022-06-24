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
import valueObject.OLecture;

public class VMiridamgi {

	private Scanner scanner;
	private CIndex cIndex;
	
	private VIndex vCampus;
	private VIndex vCollege;
	private VIndex vDepartment;
	private VLecture vLecture;
	private VInitial vInitial;

	public VMiridamgi(Scanner scanner) {
		this.scanner = scanner;
		this.vCampus = new VIndex(this.scanner);
		this.vCollege = new VIndex(this.scanner);
		this.vDepartment = new VIndex(this.scanner);
		this.vLecture = new VLecture(this.scanner);
	}

	public void show(OHwewon oHwewon) {
		System.out.println(oHwewon.getName()+"님 안녕하세요");
		System.out.println("강좌검색(1), 책가방내역확인(2), 뒤로가기(3)");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		
		if(input.equals("1")) {
			this.search(oHwewon);
		} else if (input.equals("2")) {
			this.list(oHwewon);
		} else if (input.equals("3")) {
			vInitial = new VInitial(this.scanner);
			vInitial.showafterlogin(oHwewon);
		} else {
			System.out.println("잘못 입력하셨습니다.");
			show(oHwewon);
		}
	}
	
	
	public void search(OHwewon oHwewon) {
		System.out.println("미리담기를 시작합니다.");
		System.out.println("강좌검색(1), 전공강좌검색(2), 뒤로가기(3)");
		String input2 = scanner.next();
		if(input2.equals("1")) {
		
		String campusFileName = this.vCampus.show("root", "캠퍼스를");
		if (campusFileName != null) {
		String collegeFileName = this.vCollege.show(campusFileName, "대학을");
		if (campusFileName != null) {
		String departmentFileName = this.vDepartment.show(collegeFileName, "학과를");
		if (campusFileName != null) {
		OLecture oLecture = this.vLecture.show(departmentFileName, "강좌를");
		this.write(oLecture,oHwewon);
		}}}}
		 else if(input2.equals("2")) {
			 String HwewonHwakgwa = oHwewon.getHwakgwa();
			OLecture oLecture = this.vLecture.show(HwewonHwakgwa, oHwewon.getName()+"님의 학과 "+oHwewon.getHwakgwa()+" 강좌를");
			this.write(oLecture,oHwewon);
		 }
		 else if(input2.equals("3")){
			 show(oHwewon);
		} else {
			System.out.println("잘못 입력하셨습니다."); 
			search(oHwewon);
		}
	}
		
		private void write(OLecture oLecture, OHwewon oHwewon) {
		FileWriter fileWriter;
		try {
			File file = new File(oHwewon.getId()+"M");
			fileWriter = new FileWriter("user/"+file,true);
			Scanner scanner = new Scanner("user/"+file);
			
			CLecture cLecture = new CLecture();
			Vector<OLecture> lectures = cLecture.getAllList(oHwewon.getId()+"S");
			int id2 = Integer.parseInt(oLecture.getId());
			for(OLecture lecture: lectures) {
				for(int i=0; i<10; i++) {
					int id1 = Integer.parseInt(lecture.getId());
					if(id1==id2) {
						System.out.println("이미 신청한 강좌입니다.");
						search(oHwewon);
					} else if (lecture.getProfessor().equals(oLecture.getProfessor())) {
						System.out.println("강좌 시간이 같아 신청할 수 없습니다.");
						search(oHwewon);
					}
				}
			}
				fileWriter.write(oLecture.getId()+" "
							+oLecture.getName()+" "
							+oLecture.getCredit()+" "
							+oLecture.getTime()+" "
							+oLecture.getProfessor()+"\r\n");
			fileWriter.flush();
			System.out.println("미리담기 완료됐습니다.");
			show(oHwewon);
		} catch (IOException e) {
			e.printStackTrace();
			}	
		}
	
	public void list(OHwewon oHwewon) {
		System.out.println(oHwewon.getName()+"님의 미리담기내역");

		CLecture cLecture = new CLecture();
		Vector<OLecture> lectures = cLecture.getAllList(oHwewon.getId()+"M");
		for(OLecture lecture: lectures) {
			System.out.println(lecture.getId() + " " + lecture.getName()+ " " + lecture.getCredit()+ " " + lecture.getTime()+ " " + lecture.getProfessor());
		}
		
		System.out.println("강좌추가(1), 강좌삭제(2), 강좌신청(3), 뒤로가기(4)");
		String input2 = this.scanner.next();
		if(input2.equals("1")) {
			this.search(oHwewon);
		} else if (input2.equals("2")) {
			System.out.println("삭제할 강좌의 id를 입력하세요");
			Vector<OLecture> modify = new Vector<OLecture>();
			String deleteId = this.scanner.next();
			modify = cLecture.delete(oHwewon.getId()+"M",deleteId);
			
			
			for(OLecture lecture: modify) {
			FileWriter fileWriter;
			try {
				String deletename = oHwewon.getId()+"M";
				File file2 = new File("user/"+deletename);
				file2.delete();
				File file = new File(oHwewon.getId()+"M");
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
			System.out.println("삭제됐습니다.");
			list(oHwewon);
		} else if (input2.equals("3")){
			System.out.println("신청할 강좌의 id를 입력하세요");
			Vector<OLecture> sincheong = new Vector<OLecture>();
			String sincheongId = this.scanner.next();
			sincheong = cLecture.sincheong(oHwewon.getId()+"M",sincheongId);
			
			
			for(OLecture lecture: sincheong) {
			
			FileWriter fileWriter;
			try {
				File file = new File(oHwewon.getId()+"S");
				fileWriter = new FileWriter("user/"+file,true);
				Scanner scanner = new Scanner("user/"+file);
				
				Vector<OLecture> lectures2 = cLecture.getAllList(oHwewon.getId()+"S");
				int id2 = Integer.parseInt(sincheongId);
				for(OLecture lecture2: lectures2) {
					for(int i=0; i<10; i++) {
						int id1 = Integer.parseInt(lecture2.getId());
						if(id1==id2) {
							System.out.println("이미 신청한 강좌입니다.");
							search(oHwewon);
						} else if (lecture2.getProfessor().equals(lecture.getProfessor())) {System.out.println("강좌 시간이 같아 신청할 수 없습니다.");
						search(oHwewon);}
					}
				}
					fileWriter.write(lecture.getId()+" "
								+lecture.getName()+" "
								+lecture.getCredit()+" "
								+lecture.getTime()+" "
								+lecture.getProfessor()+"\r\n");
				fileWriter.flush();
				System.out.println("수강내역에 신청됐습니다.");
				list(oHwewon);
			} catch (IOException e) {
				e.printStackTrace();
				}	
			}
		} else if (input2.equals("4")) {
			show(oHwewon);
		} else {
			System.out.println("잘못 입력하셨습니다."); 
			list(oHwewon);
		}
	}
	}
	
	


