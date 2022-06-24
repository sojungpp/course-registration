package textView;

import java.util.Scanner;

public class VMain {
	
	private Scanner scanner;
	private VInitial initial;
	
	public VMain(Scanner scanner) {
		this.scanner = scanner;
		this.initial = new VInitial(scanner);
	}
	public void run() {
		System.out.println("<명지대학교 수강신청 프로그램>");
		this.initial.show();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		VMain main = new VMain(scanner);
		main.run();
		scanner.close();
	}
}
