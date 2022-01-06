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
    System.out.println(" 1. 내 캐릭터 조회");
    System.out.println(" 2. 전투 시작");
    System.out.println(" 3. 스킬 관리");
    System.out.println(" 4. 메인 메뉴로 가기");
    System.out.println("========================");
    StartView.printRequestNum();
  }

  private static void printGameMenu() {
    System.out.println("========GAME MENU========");
    System.out.println(" 1. 공격하기");
    System.out.println(" 2. 회복");
    System.out.println(" 3. 도망가기");
    System.out.println("========================");
  }

  private static void printRequestMonsterId() {
    System.out.print("전투할 몬스터 아이디를 입력해주세요 : ");
  }

  private static void printStatus(Characters c) {
    System.out.print("[(" + c.getName() + ") ");
    System.out.print("체력: " + c.getHealth() + ", 공격력: " + c.getDamage());
    if (c instanceof Player) {
      System.out.print(", 마나: " + ((Player) c).getMana());
    }
    System.out.println("]");
  }

  private static void printAvailableSkillList(List<Skill> list) {
    System.out.println("-----------보유한 스킬 목록--------------");
    System.out.println(" " + list);
    System.out.println("------------------------------------");
    System.out.println("스킬 이름을 입력해 스킬을 사용하세요!, 이름이 틀리면 기본공격을 합니다.");
    System.out.print("스킬이름 입력 : ");

  }
}
