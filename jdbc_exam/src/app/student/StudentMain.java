package app.student;

import java.util.List;
import java.util.Scanner;

import app.student.dto.Student;
import app.student.service.StudentService;
import app.student.service.StudentServiceImpl;

public class StudentMain {

	public static void main(String[] args) {

		StudentService service = new StudentServiceImpl();

		while (true) {
			printMenu();
			Scanner sc = new Scanner(System.in);
			int input0 = sc.nextInt();
			switch (input0) {
			case 1:
				printStudentList(service.selectAll());
				break;
			case 2:
				System.out.print("검색할 학생명을 입력하세요 => ");
				printStudentList(service.selectByName(sc.next()));
				break;
			case 3:
				System.out.print("시작 입학년도 입력 =>");
				int start = sc.nextInt();
				System.out.print("끝 입학년도 입력 =>");
				int end = sc.nextInt();
				printStudentList(service.selectByDate(start, end));
				break;
			case 4:
				System.out.print("검색할 학번을 입력하세요 => ");
				String nos = new Scanner(System.in).nextLine();
				printStudentList(service.selectByMulStudentNo(nos));
				break;
			case 0:
				return;
			default:
				System.out.println("잘못된 입력");
				break;
			}

		}

	}

	private static void printMenu() {
		System.out.println("******************************************************");
		System.out.println("                     [학생정보관리메뉴]                    ");
		System.out.println("******************************************************");
		System.out.println("1. 전체 학생 목록");
		System.out.println("2. 학생 이름 검색");
		System.out.println("3. 입학년도 범위 검색");
		System.out.println("4. 학생 학번으로 다중 검색 (쉼표 구분)");
		System.out.println("0. 종료");
		System.out.print("메뉴 입력 => ");
	}

	private static void printStudentList(List<Student> list) {
		printTemplateForStudent();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("총 학생 수 : " + list.size());
	}

	private static void printTemplateForStudent() {
		System.out.println("=======================================================");
		System.out.println("학번       이름       주민번호                주소                 입학년도          휴학");
		System.out.println("-------------------------------------------------------");
	}

}
