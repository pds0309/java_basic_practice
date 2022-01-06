package game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import game.dto.Characters;
import game.dto.Monster;
import game.dto.Player;
import game.dto.Skill;

public class CharactersVirtualDB {

  private static CharactersVirtualDB instance = new CharactersVirtualDB();
  private List<Characters> charactersList = new ArrayList<>();
  private SkillVirtualDB skillData = SkillVirtualDB.getInstance();


  public static CharactersVirtualDB getInstance() {
    return instance;
  }

  private CharactersVirtualDB() {
    // Monster
    charactersList.add(new Monster("오크", 3, 6));
    charactersList.add(new Monster("고블린", 4, 8));
    charactersList.add(new Monster("슬라임", 2, 3));
    charactersList.add(new Monster("달팽이", 1, 2));
    charactersList.add(new Monster("악마", 7, 15));

    // Player
    charactersList.add(new Player("김갑환", 5, 5, skillData.findAllSkill().subList(0, 5)));
    charactersList.add(new Player("최번개", 1, 3, skillData.findAllSkill().subList(0, 1)));
  };

  public List<Characters> findAllCharacters() {
    return charactersList;
  }

  public Characters findCharactersById(long id) {
    for (Characters c : charactersList) {
      if (id == c.getCharId()) {
        return c;
      }
    }
    return null;
  }

  // insert
  public void saveCharacters(Characters c) {
    if (c instanceof Player) {
      Player player = (Player) c;
      // 스킬 테이블에서 스킬레벨이 플레이어보다 레벨이 같거나 낮은 스킬들만 잧아서 해당 플레이어의 스킬 목록으로 set 해준다.
      player.setSkillList(skillData.findAllSkill().stream()
          .filter(sk -> sk.getLevel() <= player.getLevel()).collect(Collectors.toList()));
      charactersList.add((Player) c);
    } else if (c instanceof Monster) {
      charactersList.add((Monster) c);
    }
  }

  public void deleteCharacters(Characters characters) {
    charactersList.remove(characters);
  }

  public void updatePlayerSkill(Player player, List<Skill> list) {
    player.setSkillList(list);
  }

  // public void updatePlayer(Player player, int exp) {
  // player.setLevel(exp/20);
  // player.setExp(exp%20);
  // player.setCure();
  // player.setMana();
  // player.setHealth();
  // }
  // public void updateMonster(Monster monster) {
  // monster.setCount();
  // }
  // 밑으로 변경

  public void updateCharacter(Player c, int exp) {
    c.levelUp(exp);
  }

  public void updateCharacter(Characters c) {
    c.setDead();
  }

  public void updatePlayerExpZero(Player player) {
    player.runAway();
  }
}
