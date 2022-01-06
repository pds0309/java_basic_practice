package game.service;

import java.util.List;
import java.util.stream.Collectors;
import game.dto.Characters;
import game.dto.Monster;
import game.dto.Player;
import game.dto.Skill;
import game.exception.InvalidRequestException;
import game.exception.NotExistException;
import game.model.CharactersVirtualDB;

public class CharactersService {
  private static CharactersService instance = new CharactersService();
  private CharactersVirtualDB charData = CharactersVirtualDB.getInstance();

  private CharactersService() {}

  public static CharactersService getInstance() {
    return instance;
  }


  public List<Characters> getAllCharacters(char charType) throws NotExistException {
    if (charType == 'P') {
      return charData.findAllCharacters().stream().filter(ch -> ch instanceof Player)
          .collect(Collectors.toList());
    } else if (charType == 'M') {
      return charData.findAllCharacters().stream().filter(ch -> ch instanceof Monster)
          .collect(Collectors.toList());
    } else {
      throw new NotExistException("캐릭터가 존재하지 않습니다.");
    }
  }

  public Characters getCharaterById(long id) throws NotExistException {
    Characters characters = charData.findCharactersById(id);
    if (characters != null) {
      return characters;
    }
    throw new NotExistException("존재하지 않는 캐릭터입니다.");
  }

  public Player getPlayerById(long id) throws InvalidRequestException, NotExistException {
    Characters characters = getCharaterById(id);
    if (characters instanceof Player) {
      return (Player) characters;
    }
    throw new InvalidRequestException("플레이어 외의 캐릭터를 선택하셨습니다.");

  }

  public void insertCharacters(Characters characters) throws InvalidRequestException {
    if (characters != null) {
      charData.saveCharacters(characters);
      return;
    }
    throw new InvalidRequestException("잘못된 입력으로 캐릭터 생성 실패");

  }

  public void deleteCharacters(long id) throws NotExistException {
    Characters characters = getCharaterById(id);
    if (characters != null) {
      charData.deleteCharacters(characters);
    }
  }

  public void updateSkill(Player player, Skill skill) throws InvalidRequestException {
    if (player.getLevel() >= skill.getLevel()) {
      List<Skill> resultSkillList = player.getSkillList();
      resultSkillList.add(skill);
      charData.updatePlayerSkill(player, resultSkillList);
      return;
    }
    throw new InvalidRequestException("해당 스킬을 배우기에 레벨이 충분하지 않습니다");
  }

  public int attack(Characters attacker, Characters defender, Skill skill)
      throws NotExistException {
    int result = 0;
    if (skill == null) {
      result = attacker.getDamage();
      defender.setHealth(Math.max(defender.getHealth() - result, 0));
      return result;
    }
    Player player = (Player) attacker;
    if (player.getMana() >= skill.getCost()) {
      result = skill.returnDamage(player.getDamage());
      defender.setHealth(Math.max(defender.getHealth() - result, 0));
      player.setMana(player.getMana() - skill.getCost());
      return result;
    } else {
      throw new NotExistException("마나가 부족해서 스킬을 사용할 수 없습니다.");
    }

  }

  /**
   * 
   * @param kill
   * @param dead
   */
  public void dead(Characters kill, Characters dead) {
    if (kill instanceof Player) {
      charData.updateCharacter((Player) kill, dead.getExp());
      charData.updateCharacter((Monster) dead);
    } else {
      charData.updateCharacter((Player) dead);
    }
  }

  public void runAway(Player player) {
    charData.updatePlayerExpZero(player);
  }

  public int heal(Player player, int health) {
    return player.heal(health);
  }
}
