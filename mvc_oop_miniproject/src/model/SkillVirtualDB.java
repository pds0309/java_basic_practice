package game.model;

import java.util.ArrayList;
import java.util.List;
import game.dto.Skill;

public class SkillVirtualDB {

  private static SkillVirtualDB instance = new SkillVirtualDB();
  private List<Skill> skillList = new ArrayList<>();

  public static SkillVirtualDB getInstance() {
    return instance;
  }

  private SkillVirtualDB() {
    skillList.add(new Skill("주먹질", 1, 1, 150));
    skillList.add(new Skill("발길질", 2, 2, 220));
    skillList.add(new Skill("불꽃 던지기", 4, 3, 350));
    skillList.add(new Skill("흰머리 뽑아주기", 6, 4, 410));
    skillList.add(new Skill("볼 꼬집기", 8, 5, 580));
    skillList.add(new Skill("간지럽히기", 13, 10, 670));
  }

  public List<Skill> findAllSkill() {
    return skillList;
  }

  public Skill findSkillByName(String name) {
    for (Skill skill : skillList) {
      if (name.equals(skill.getName())) {
        return skill;
      }
    }
    return null;
  }
}
