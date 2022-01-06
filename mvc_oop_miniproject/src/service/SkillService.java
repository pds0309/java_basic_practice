package game.service;

import java.util.List;
import game.dto.Skill;
import game.exception.NotExistException;
import game.model.SkillVirtualDB;

public class SkillService {
  private static SkillService instance = new SkillService();
  private SkillVirtualDB skillData = SkillVirtualDB.getInstance();

  private SkillService() {}

  public static SkillService getInstance() {
    return instance;
  }

  public List<Skill> getAllSkill() throws NotExistException {
    List<Skill> skillList = skillData.findAllSkill();
    if (skillList.size()!=0) {
      return skillList;
    }
    throw new NotExistException("게임 내에 스킬이 존재하지 않습니다.");
  }

  public Skill getSkillByName(String name) throws NotExistException {
    Skill skill = skillData.findSkillByName(name);
    if (skill != null) {
      return skill;
    }
    throw new NotExistException("요청하신 스킬은 존재하지 않습니다.");
  }
}
