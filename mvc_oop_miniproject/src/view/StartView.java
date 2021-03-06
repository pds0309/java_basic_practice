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
          printSelectWhatCharacters("์กฐํ");
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
          printSelectWhatCharacters("์์ฑ");
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
          System.out.println("์์คํ ์ข๋ฃ");
          return;
        default:
          printWrongInput();
          break;
      }
    }
  }

  private static void printMainMenu() {
    System.out.println("==========MENU==========");
    System.out.println(" 1. ์บ๋ฆญํฐ ์กฐํ");
    System.out.println(" 2. ์บ๋ฆญํฐ ์์ฑ");
    System.out.println(" 3. ์บ๋ฆญํฐ ์?ํ(ํ๋?์ด์ด๋ก ๊ฒ์ ์์ ๊ฐ๋ฅ)");
    System.out.println(" 4. ์บ๋ฆญํฐ ์ญ์?");
    System.out.println(" 5. ์์คํ ์ข๋ฃ");
    System.out.println("========================");
    printRequestNum();
  }

  private static void printSelectWhatCharacters(String msg) {
    System.out.println(" == ์ด๋ค ์บ๋ฆญํฐ๋ฅผ " + msg + "ํ์๊ฒ?์ต๋๊น??");
    System.out.println(" 1. ํ๋?์ด์ด");
    System.out.println(" 2. ๋ชฌ์คํฐ");
    printRequestNum();
  }


  private static void printInsertCharactersValue() {
    System.out.println("== ์บ๋ฆญํฐ ํน์ฑ์ ์ฐจ๋ก๋๋ก ์๋?ฅํด์ฃผ์ธ์!");
    System.out.println(" <์ด๋ฆ>\n <๋?๋ฒจ>\n <๋ฐ๋ฏธ์ง>");
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
      System.out.println("ํ์์ด ์ฌ๋ฐ๋ฅด์ง ์์ ์๋?ฅ์๋๋ค.");
    }
    return null;
  }

  private static void printAlertGameStart(Player player) {
    System.out.println("==== " + player.getName() + " ํ๋?์ด์ด๋ก ๊ฒ์์ ์งํํฉ๋๋ค.====");
    System.out.println("====== ์๋ ๊ฐ๋ฅํ ๋ชฌ์คํฐ ๋ชฉ๋ก์๋๋ค. ======");
  }

  public static void printRequestNum() {
    System.out.print("๋ฒํธ์๋?ฅ:");
  }

  public static void printWrongInput() {
    System.out.println("- ์๋ชป ์๋?ฅํ์ต๋๋ค. ๋ค์ ์๋?ฅํด์ฃผ์ธ์");
  }

  public static void printRequestCharId() {
    System.out.print("์บ๋ฆญํฐ ์์ด๋ ์๋?ฅ : ");
  }
}
