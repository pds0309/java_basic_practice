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
			System.out.print("==== 번호 입력 -> ");
			int n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println(deptService.selectAll().toString());
				break;
			case 2:
				System.out.print("부서번호 입력 ->");
				int inputDeptNo = sc.nextInt();
				System.out.println(deptService.selectByDeptNo(inputDeptNo));
				break;
			case 3:
				System.out.println("====추가할 부서 정보 입력====");
				System.out.print("부서번호 -> ");
				int no = sc.nextInt();
				System.out.print("부서이름 ->");
				String name = sc.next();
				System.out.print("부서위치->");
				String loc = sc.next();
				System.out.println();
				System.out.println("Status : " + deptService.insert(new DeptDTO(no,name,loc)));
				
				break;
			case 4:
				System.out.println("====삭제할 부서 정보 입력====");
				System.out.print("부서번호 ->");
				int no2 = sc.nextInt();
				System.out.println("Status : " + deptService.delete(no2));
				break;
			case 5:
				System.out.println("====수정할 부서 정보 입력====");
				System.out.print("부서번호 -> ");
				int no5 = sc.nextInt();
				System.out.print("부서이름 ->");
				String name5 = sc.next();
				System.out.print("부서위치->");
				String loc5 = sc.next();
				System.out.println();
				System.out.println("Status : " + deptService.update(new DeptDTO(no5,name5,loc5)));
				break;
			case 0:
				return;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}	
		}
	
	}
	
	
	public static void printMenu() {
		System.out.println("=======================");
		System.out.println("1) 전체 조회");
		System.out.println("2) 부서번호로 조회");
		System.out.println("3) 부서 추가하기");
		System.out.println("4) 부서 삭제하기");
		System.out.println("5) 부서 수정하기");
	}

}
