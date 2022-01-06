package game.dto;

import java.util.List;
import game.utils.Balance;
import game.utils.PlayeableInterface;
import game.utils.PropertyInterface;

/**
 * 
 * @see game.dto.Characters
 *
 */
public class Player extends Characters implements PropertyInterface, PlayeableInterface {
  // 회복력
  private int cure;
  // 마나
  private int mana;
  // 보유스킬목록
  private List<Skill> skillList;


  public Player() {
    //
  };

  public Player(String name, int level, int damage, List<Skill> skillList) {
    super(name, level, damage);
    setProperty();
    this.skillList = skillList;
  }

  public Player(Player player) {
    super(player);
    this.cure = player.cure;
    this.mana = player.mana;
    this.skillList = player.skillList;
  }

  public int getCure() {
    return cure;
  }

  public int getMana() {
    return mana;
  }

  public void setMana(int mana) {
    this.mana = mana;
  }

  public void setMana() {
    this.mana = this.getLevel() * Balance.MANA_BALANCE;
  }

  public void setCure() {
    this.cure = this.getLevel() * Balance.CURE_BALANCE;
  }

  public List<Skill> getSkillList() {
    return skillList;
  }

  public void setSkillList(List<Skill> skillList) {
    this.skillList = skillList;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(super.toString());
    builder.append(", 마나 : ");
    builder.append(mana);
    builder.append(", 치료능력 : ");
    builder.append(cure);
    builder.append(" ]\n");
    return builder.toString();
  }

  @Override
  public void setProperty() {
    setHealth(this.getLevel() * Balance.HEALTH_BALANCE);
    this.cure = this.getLevel() * Balance.CURE_BALANCE;
    this.mana = this.getLevel() * Balance.MANA_BALANCE;
  }

  // 죽었을 때
  @Override
  public void setDead() {
    this.setExp(0);
  }

  // 도망갔을 때 페널티 기능
  @Override
  public void runAway() {
    // TODO Auto-generated method stub
    this.setExp(0);
  }

  // 치료
  @Override
  public int heal(int health) {
    // TODO Auto-generated method stub
    int result = Math.min(getHealth() + this.cure, health);
    int healAmount = result - getHealth();
    setHealth(result);
    return healAmount;
  }

  // 레벨업 조건이 되면 레벨업 시킨다.
  @Override
  public void levelUp(int exp) {
    // TODO Auto-generated method stub
    setExp(getExp() + exp);
    setLevel(getExp() / Balance.CONDITION_OF_LEVELUP_EXP);
    setExp(getExp() % Balance.CONDITION_OF_LEVELUP_EXP);
    setCure();
    setMana();
    setHealth();
  }


}
