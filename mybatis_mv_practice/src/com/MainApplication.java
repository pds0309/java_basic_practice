package com;


import com.service.DepartmentService;
import com.service.DepartmentServiceImpl;
import com.service.StudentService;
import com.service.StudentServiceImpl;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainApplication {
    private static final StudentService studentService = new StudentServiceImpl();

    public static void main(String[] args) {

        DepartmentService departmentService = new DepartmentServiceImpl();
        while (true) {
            printMenu();
            Scanner sc = new Scanner(System.in);
            int input0 = sc.nextInt();
            switch (input0) {
                case 1:
                    printTemplateForStudent();
                    printList(studentService.selectAll(), true);
                    break;
                case 2:
                    System.out.print("검색할 학생명을 입력하세요 => ");
                    String inputNameForSelect = sc.next();
                    printTemplateForStudent();
                    printList(studentService.selectByStudentNameContains(inputNameForSelect), true);
                    break;
                case 3:
                    try {
                        System.out.print("시작 입학년도 입력 =>");
                        int start = sc.nextInt();
                        System.out.print("끝 입학년도 입력 =>");
                        int end = sc.nextInt();
                        printTemplateForStudent();
                        printList(studentService.selectByEntranceDateBetween(start, end), true);
                    } catch (InputMismatchException e) {
                        System.out.println("숫자를 입력해주세요!!");
                        break;
                    }
                    break;
                case 4:
                    System.out.print("검색할 학번을 입력하세요 => ");
                    String inputIdsForSelect = new Scanner(System.in).nextLine();
                    printTemplateForStudent();
                    printList(studentService.selectByIdIn(Arrays.asList(inputIdsForSelect.split(","))), true);
                    break;
                case 5:
                    System.out.print("수정할 학생의 학번을 입력하세요 => ");
                    List<String> inputIdsForUpdateAbsence = Arrays.asList(new Scanner(System.in).nextLine().split(","));
                    printDMLResult(studentService.updateAbsenceYnByIdIn(inputIdsForUpdateAbsence), "휴학 정보 수정", "학생");
                    break;
                case 6:
                    printDMLResult(departmentService.updateAllCapacity(), "학과 정원 일괄 수정", "학과");
                    break;
                case 7:
                    System.out.print("검색할 학생의 학번을 입력하세요 => ");
                    String inputIdForSelectGrade = sc.next();
                    printTemplateForGrade();
                    printList(studentService.selectGradeById(inputIdForSelectGrade), false);
                    break;
                case 8:
                    System.out.print("페이지당 보여줄 레코드 개수를 입력하세요 => ");
                    viewForStudentPaging(sc.nextInt());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못된 입력");
                    break;
            } // end switch

        } // end while

    }

    private static void printMenu() {
        System.out.println("******************************************************");
        System.out.println("                     [학생정보관리메뉴]                    ");
        System.out.println("******************************************************");
        System.out.println("1. 전체 학생 목록");
        System.out.println("2. 학생 이름 검색");
        System.out.println("3. 입학년도 범위 검색 (예> 2000부터 2003년까지)");
        System.out.println("4. 학생 학번으로 다중 검색 (쉼표 구분)");
        System.out.println("5. 학생 휴학 일괄 수정 ");
        System.out.println("6. 학과 정원 일괄 수정 ");
        System.out.println("7. 학생 학점 검색 ");
        System.out.println("8. 전체 학생 목록-페이징 ");
        System.out.println("0. 종료");
        System.out.println("******************************************************");
        System.out.print("메뉴 입력 => ");
    }

    private static <T> void printList(List<T> list, boolean needSize) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        if (needSize) {
            System.out.println("총 학생 수 : " + list.size());
        }
    }

    private static void printTemplateForStudent() {
        System.out.println("============================================================");
        System.out.println("학번   이름    주민번호         주소              입학년도        휴학");
        System.out.println("------------------------------------------------------------");

    }

    private static void printTemplateForGrade() {
        System.out.println("=======================================================");
        System.out.println("학기      학번       이름     과목명          점수     학점");
        System.out.println("-------------------------------------------------------");
    }

    private static void printDMLResult(int result, String job, String obj) {
        System.out.println(" [ " + job + "성공! ]  ");
        System.out.println("총 변경된 " + obj + " 수 : " + result);
    }

    private static void viewForStudentPaging(int recordAmountPerPage) {
        Scanner scanner = new Scanner(System.in);
        int currentPage = 1;
        while (true) {
            int totalPageSize = (int) Math.ceil((double) studentService.selectAll().size() / recordAmountPerPage);
            currentPage = Math.min(currentPage , totalPageSize);
            printTemplateForStudent();
            printList(studentService.selectAll(recordAmountPerPage, currentPage - 1), false);
            printPageStatus(currentPage, totalPageSize);
            printPageHelpMenu();
            String inputPage = scanner.next().toUpperCase();
            if ("N".equals(inputPage)) {
                if (currentPage++ >= totalPageSize) {
                    System.out.println("마지막 페이지 입니다.!");
//                    currentPage = totalPageSize;
                }
                continue;
            }
            if ("B".equals(inputPage)) {
                if (currentPage-- <= 1) {
                    System.out.println("첫 페이지 입니다.!");
                    currentPage = 1;
                }
                continue;
            }
            if ("Q".equals(inputPage)) {
                break;
            }
        }
    }

    private static void printPageHelpMenu() {
        System.out.println("N: 다음페이지  B: 이전페이지 Q: 메인화면");
        System.out.print("입력 => ");
    }

    private static void printPageStatus(int current, int total) {
        System.out.println(current + "/" + total);
    }
}
