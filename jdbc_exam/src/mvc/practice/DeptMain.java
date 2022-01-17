package mvc.practice;

import java.util.List;
import java.util.Scanner;

import mvc.practice.model.DeptDTO;
import mvc.practice.service.DeptService;
import mvc.practice.service.DeptServiceImpl;

/*
 * Arc
 * 
 * DeptMain <--> Service <--> DeptDAO(Repo) <--> DB
 * 
 * Service -> Interface
 * 
 */
public class DeptMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DeptService deptService = new DeptServiceImpl();
		while(true) {
			printMenu();
			Scanner sc = new Scanner(System.in);
			System.out.print("==== ��ȣ �Է� -> ");
			int n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println(deptService.selectAll().toString());
				break;
			case 2:
				System.out.print("�μ���ȣ �Է� ->");
				int inputDeptNo = sc.nextInt();
				System.out.println(deptService.selectByDeptNo(inputDeptNo));
				break;
			case 3:
				System.out.println("====�߰��� �μ� ���� �Է�====");
				System.out.print("�μ���ȣ -> ");
				int no = sc.nextInt();
				System.out.print("�μ��̸� ->");
				String name = sc.next();
				System.out.print("�μ���ġ->");
				String loc = sc.next();
				System.out.println();
				System.out.println("Status : " + deptService.insert(new DeptDTO(no,name,loc)));
				
				break;
			case 4:
				System.out.println("====������ �μ� ���� �Է�====");
				System.out.print("�μ���ȣ ->");
				int no2 = sc.nextInt();
				System.out.println("Status : " + deptService.delete(no2));
				break;
			case 5:
				System.out.println("====������ �μ� ���� �Է�====");
				System.out.print("�μ���ȣ -> ");
				int no5 = sc.nextInt();
				System.out.print("�μ��̸� ->");
				String name5 = sc.next();
				System.out.print("�μ���ġ->");
				String loc5 = sc.next();
				System.out.println();
				System.out.println("Status : " + deptService.update(new DeptDTO(no5,name5,loc5)));
				break;
			case 0:
				return;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}	
		}
	
	}
	
	
	public static void printMenu() {
		System.out.println("=======================");
		System.out.println("1) ��ü ��ȸ");
		System.out.println("2) �μ���ȣ�� ��ȸ");
		System.out.println("3) �μ� �߰��ϱ�");
		System.out.println("4) �μ� �����ϱ�");
		System.out.println("5) �μ� �����ϱ�");
	}

}
