package game.controller;

import java.util.List;
import game.dto.Skill;
import game.exception.NotExistException;
import game.service.SkillService;
import game.view.EndView;
import game.view.FailView;

public class SkillController {
  private static SkillController instance = new SkillController();
  private SkillService service = SkillService.getInstance();

  private SkillController() {}

  public static SkillController getInstance() {
    return instance;
  }

  public List<Skill> getAllSkill() {
    try {
      List<Skill> result = service.getAllSkill();
      EndView.printSkillList(result);
      return service.getAllSkill();
    } catch (NotExistException e) {
      FailView.failMessageView(e.getMessage());
    }
    return null;
  }

  public Skill getSkill(String name) {
    try {
      return service.getSkillByName(name);
    } catch (NotExistException e) {
      FailView.failMessageView(e.getMessage());
    }
    return null;
  }
}
