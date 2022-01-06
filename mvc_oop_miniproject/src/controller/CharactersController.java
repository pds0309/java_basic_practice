package game.controller;

import java.util.List;
import game.dto.Characters;
import game.dto.Player;
import game.dto.Skill;
import game.exception.InvalidRequestException;
import game.exception.NotExistException;
import game.service.CharactersService;
import game.view.EndView;
import game.view.FailView;

public class CharactersController {
  private static CharactersController instance = new CharactersController();
  private CharactersService service = CharactersService.getInstance();

  private CharactersController() {}

  public static CharactersController getInstance() {
    return instance;
  }

  public List<Characters> showAllCharacters(char charType) {
    try {
      List<Characters> charactersList = service.getAllCharacters(charType);
      EndView.printCharactersList(charactersList);
      return charactersList;
    } catch (NotExistException e) {
      FailView.failMessageView(e.getMessage());
    }
    return null;
  }

  public Player selectOnePlayer(String id) {
    try {
      return service.getPlayerById(Long.parseLong(id));
    } catch (NumberFormatException e) {
      FailView.failMessageView("캐릭터 조회 아이디 입력 오류");
    } catch (NotExistException e) {
      FailView.failMessageView(e.getMessage());
    } catch (InvalidRequestException e) {
      FailView.failMessageView(e.getMessage());
    }
    return null;
  }

  public void insertCharacters(Characters c) {
    try {
      service.insertCharacters(c);
      EndView.printSuccess("캐릭터 생성");
    } catch (InvalidRequestException e) {
      // TODO Auto-generated catch block
      FailView.failMessageView(e.getMessage());
    }
  }

  public void deleteCharacters(String id) {
    try {
      service.deleteCharacters(Long.parseLong(id));
      EndView.printSuccess("캐릭터 제거");
    } catch (NumberFormatException e) {
      FailView.failMessageView("캐릭터 삭제 아이디 입력 오류");
    } catch (NotExistException e) {
      FailView.failMessageView(e.getMessage());
    }
  }

  public void updatePlayerSkill(Player player, Skill skill) {
    try {
      service.updateSkill(player, skill);
      EndView.printSuccess("스킬 배우기");
    } catch (InvalidRequestException e) {
      FailView.failMessageView(e.getMessage());
    }
  }

  public boolean requestResponseAttack(Characters attacker, Characters defender, Skill skill) {
    try {
      EndView.printAttack(service.attack(attacker, defender, skill), attacker);
      return true;
    } catch (NotExistException e) {
      FailView.failMessageView(e.getMessage());
      return false;
    }
  }

  public void requestResponseDead(Characters kill, Characters dead) {
    service.dead(kill, dead);
    EndView.printDead(kill);
  }

  public void requestResponseRunAway(Player player) {
    service.runAway(player);
    EndView.printSuccess("도망치기");
  }

  public void requestResponseHeal(int maxHealth, Player player) {
    int result = service.heal(player, maxHealth);
    EndView.printSuccess(result + " 체력만큼 회복");
  }
}
