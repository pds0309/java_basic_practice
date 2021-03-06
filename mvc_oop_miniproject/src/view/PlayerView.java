package game.view;

import java.util.List;
import java.util.Scanner;
import game.controller.CharactersController;
import game.dto.Characters;
import game.dto.Monster;
import game.dto.Player;
import game.dto.Skill;

public class PlayerView {
  public static void playerView(Player player, List<Characters> monsterList) {
    CharactersController controller = CharactersController.getInstance();
    while (true) {
      Scanner gameInput = new Scanner(System.in);
      printPlayerMenu();
      switch (gameInput.nextLine()) {
        case "1":
          System.out.println(player);
          break;
        case "2":
          printRequestMonsterId();
          String subInput2 = new Scanner(System.in).nextLine();
          for (Characters monster : monsterList) {
            if (subInput2.equals(monster.getCharId() + "")) {
              gameView(player, (Monster) monster);
              break;
            }
          }
          break;
        case "3":
          Skill skill = SkillView.skillView(player);
          if (skill != null) {
            controller.updatePlayerSkill(player, skill);
          }
          break;
        case "4":
          return;
        default:
          StartView.printWrongInput();
          break;
      }
    }
  }

  private static void gameView(Player player, Monster monster) {
    CharactersController controller = CharactersController.getInstance();
    List<Skill> skillList = player.getSkillList();
    Player tempPlayer = new Player(player);
    Monster tempMonster = new Monster(monster);
    while (true) {
      Scanner gameInput = new Scanner(System.in);
      printGameMenu();
      printStatus(tempPlayer);
      printStatus(tempMonster);
      StartView.printRequestNum();
      if (tempPlayer.getHealth() <= 0) {
        controller.requestResponseDead(monster, player);
        return;
      }
      switch (gameInput.nextLine()) {
        case "1":
          printAvailableSkillList(skillList);
          String spellName = gameInput.nextLine();
          Skill skill = null;
          for (int i = 0; i < skillList.size(); i++) {
            if (spellName.equals(skillList.get(i).getName())) {
              skill = skillList.get(i);
              break;
            }
          }
          boolean isValid = controller.requestResponseAttack(tempPlayer, tempMonster, skill);
          if (!isValid) {
            break;
          }
          if (tempMonster.getHealth() <= 0) {
            controller.requestResponseDead(player, monster);
            return;
          }
          controller.requestResponseAttack(tempMonster, tempPlayer, null);
          break;
        case "2":
          // zzz
          controller.requestResponseHeal(player.getHealth(), tempPlayer);
          controller.requestResponseAttack(tempMonster, tempPlayer, null);
          break;
        case "3":
          controller.requestResponseRunAway(player);
          return;
        default:
          StartView.printWrongInput();
          break;
      }
    }
  }


  private static void printPlayerMenu() {
    System.out.println("========PLAYER MENU=======");
    System.out.println(" 1. ??? ????????? ??????");
    System.out.println(" 2. ?????? ??????");
    System.out.println(" 3. ?????? ??????");
    System.out.println(" 4. ?????? ????????? ??????");
    System.out.println("========================");
    StartView.printRequestNum();
  }

  private static void printGameMenu() {
    System.out.println("========GAME MENU========");
    System.out.println(" 1. ????????????");
    System.out.println(" 2. ??????");
    System.out.println(" 3. ????????????");
    System.out.println("========================");
  }

  private static void printRequestMonsterId() {
    System.out.print("????????? ????????? ???????????? ?????????????????? : ");
  }

  private static void printStatus(Characters c) {
    System.out.print("[(" + c.getName() + ") ");
    System.out.print("??????: " + c.getHealth() + ", ?????????: " + c.getDamage());
    if (c instanceof Player) {
      System.out.print(", ??????: " + ((Player) c).getMana());
    }
    System.out.println("]");
  }

  private static void printAvailableSkillList(List<Skill> list) {
    System.out.println("-----------????????? ?????? ??????--------------");
    System.out.println(" " + list);
    System.out.println("------------------------------------");
    System.out.println("?????? ????????? ????????? ????????? ???????????????!, ????????? ????????? ??????????????? ?????????.");
    System.out.print("???????????? ?????? : ");

  }
}
