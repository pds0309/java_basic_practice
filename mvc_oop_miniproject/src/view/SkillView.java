package game.view;

import java.util.List;
import java.util.Scanner;
import game.controller.SkillController;
import game.dto.Player;
import game.dto.Skill;

public class SkillView {

  public static Skill skillView(Player player) {
    SkillController controller = SkillController.getInstance();


    while (true) {
      System.out.println("======= 스킬 관리- 'q' 입력시 이전화면으로  ========");
      System.out.println("=========모든 스킬 목록입니다.==========");
      List<Skill> allSkillList = controller.getAllSkill();
      System.out.println();

      System.out.println("-------- 당신이 보유한 스킬 목록입니다.--------");

      printSimpleSkill(player.getSkillList());

      if (allSkillList.size() == player.getSkillList().size()) {
        System.out.println("당신은 모든 스킬을 배우셨습니다.");
        return null;
      }

      Scanner skillInput = new Scanner(System.in);
      System.out.println();
      System.out.print("새로 배우고 싶은 스킬 이름을 입력해주세요! : ");


      String skillName = skillInput.nextLine().trim();
      if ("q".equals(skillName)) {
        System.out.println("------- 스킬 관리를 종료합니다.------");
        System.out.println();
        return null;
      }

      Skill skill = controller.getSkill(skillName);
      if (skill == null) {
        continue;
      }
      if (player.getSkillList().contains(skill)) {
        System.out.println("이미 보유하고 계신 스킬입니다.");
        continue;
      }
      return skill;
    }

  }

  public static void printSimpleSkill(List<Skill> list) {
    for (Skill skill : list) {
      System.out.print("[아이디: " + skill.getSkillId() + ",이름:" + skill.getName() + "]");
    }
    System.out.println();
  }

}
