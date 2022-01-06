package game.view;

import java.util.List;
import game.dto.Characters;
import game.dto.Player;
import game.dto.Skill;

public class EndView {
  public static void printSuccess(String msg) {
    System.out.println(msg + " 성공~!");
  }

  public static void printCharactersList(List<Characters> list) {
    System.out.println(" " + list);
  }

  public static void printAttack(int damage, Characters c) {
    System.out.print(damage + "의 데미지를 ");
    if (c instanceof Player) {
      System.out.println("입혔습니다.");
    } else {
      System.out.println("입었습니다.");
    }
  }

  public static void printDead(Characters c) {
    if (c instanceof Player) {
      System.out.println("몬스터를 처치했습니다!");
    } else {
      System.out.println("사망하였습니다.!");
    }
  }

  public static void printSkillList(List<Skill> list) {
    System.out.println(" " + list);
  }
}
