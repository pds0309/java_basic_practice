package game.view;

import java.util.List;
import java.util.Scanner;
import game.controller.CharactersController;
import game.dto.Characters;
import game.dto.Monster;
import game.dto.Player;

public class StartView {


  public static void main(String[] args) {

    CharactersController controller = CharactersController.getInstance();

    while (true) {
      printMainMenu();
      Scanner mainInput = new Scanner(System.in);
      switch (mainInput.nextLine()) {
        case "1":
          printSelectWhatCharacters("조회");
          Scanner subInput1 = new Scanner(System.in);
          String input1 = subInput1.nextLine();
          if ("1".equals(input1)) {
            controller.showAllCharacters('P');
          } else if ("2".equals(input1)) {
            controller.showAllCharacters('M');
          } else {
            printWrongInput();
          }
          break;
        case "2":
          printSelectWhatCharacters("생성");
          Scanner subInput2 = new Scanner(System.in);
          String input2 = subInput2.nextLine();
          if ("1".equals(input2)) {
            printInsertCharactersValue();
            Player player = (Player) makeCharactersByUser(true, subInput2.nextLine(),
                subInput2.nextLine(), subInput2.nextLine());
            controller.insertCharacters(player);
          } else if ("2".equals(input2)) {
            printInsertCharactersValue();
            Monster monster = (Monster) makeCharactersByUser(false, subInput2.nextLine(),
                subInput2.nextLine(), subInput2.nextLine());
            controller.insertCharacters(monster);
          } else {
            printWrongInput();
          }
          break;
        case "3":
          printRequestCharId();
          Scanner subInput3 = new Scanner(System.in);
          Player player = controller.selectOnePlayer(subInput3.nextLine());
          if (player != null) {
            printAlertGameStart(player);
            PlayerView.playerView(player, controller.showAllCharacters('M'));
          }
          break;
        case "4":
          printRequestCharId();
          Scanner subInput4 = new Scanner(System.in);
          controller.deleteCharacters(subInput4.nextLine());
          break;
        case "5":
          System.out.println("시스템 종료");
          return;
        default:
          printWrongInput();
          break;
      }
    }
  }

  private static void printMainMenu() {
    System.out.println("==========MENU==========");
    System.out.println(" 1. 캐릭터 조회");
    System.out.println(" 2. 캐릭터 생성");
    System.out.println(" 3. 캐릭터 선택(플레이어로 게임 시작 가능)");
    System.out.println(" 4. 캐릭터 삭제");
    System.out.println(" 5. 시스템 종료");
    System.out.println("========================");
    printRequestNum();
  }

  private static void printSelectWhatCharacters(String msg) {
    System.out.println(" == 어떤 캐릭터를 " + msg + "하시겠습니까??");
    System.out.println(" 1. 플레이어");
    System.out.println(" 2. 몬스터");
    printRequestNum();
  }


  private static void printInsertCharactersValue() {
    System.out.println("== 캐릭터 특성을 차례대로 입력해주세요!");
    System.out.println(" <이름>\n <레벨>\n <데미지>");
  }

  private static Characters makeCharactersByUser(boolean isPlayer, String name, String level,
      String damage) {
    try {
      int levl = Integer.parseInt(level);
      int dmg = Integer.parseInt(damage);
      if (isPlayer) {
        return new Player(name, levl, dmg, null);
      }
      return new Monster(name, levl, dmg);
    } catch (NumberFormatException e) {
      System.out.println("형식이 올바르지 않은 입력입니다.");
    }
    return null;
  }

  private static void printAlertGameStart(Player player) {
    System.out.println("==== " + player.getName() + " 플레이어로 게임을 진행합니다.====");
    System.out.println("====== 상대 가능한 몬스터 목록입니다. ======");
  }

  public static void printRequestNum() {
    System.out.print("번호입력:");
  }

  public static void printWrongInput() {
    System.out.println("- 잘못 입력했습니다. 다시 입력해주세요");
  }

  public static void printRequestCharId() {
    System.out.print("캐릭터 아이디 입력 : ");
  }
}
