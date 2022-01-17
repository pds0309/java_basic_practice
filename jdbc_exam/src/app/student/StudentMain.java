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
				System.out.print("�˻��� �л����� �Է��ϼ��� => ");
				printStudentList(service.selectByName(sc.next()));
				break;
			case 3:
				System.out.print("���� ���г⵵ �Է� =>");
				int start = sc.nextInt();
				System.out.print("�� ���г⵵ �Է� =>");
				int end = sc.nextInt();
				printStudentList(service.selectByDate(start, end));
				break;
			case 4:
				System.out.print("�˻��� �й��� �Է��ϼ��� => ");
				String nos = new Scanner(System.in).nextLine();
				printStudentList(service.selectByMulStudentNo(nos));
				break;
			case 0:
				return;
			default:
				System.out.println("�߸��� �Է�");
				break;
			}

		}

	}

	private static void printMenu() {
		System.out.println("******************************************************");
		System.out.println("                     [�л����������޴�]                    ");
		System.out.println("******************************************************");
		System.out.println("1. ��ü �л� ���");
		System.out.println("2. �л� �̸� �˻�");
		System.out.println("3. ���г⵵ ���� �˻�");
		System.out.println("4. �л� �й����� ���� �˻� (��ǥ ����)");
		System.out.println("0. ����");
		System.out.print("�޴� �Է� => ");
	}

	private static void printStudentList(List<Student> list) {
		printTemplateForStudent();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("�� �л� �� : " + list.size());
	}

	private static void printTemplateForStudent() {
		System.out.println("=======================================================");
		System.out.println("�й�       �̸�       �ֹι�ȣ                �ּ�                 ���г⵵          ����");
		System.out.println("-------------------------------------------------------");
	}

}
