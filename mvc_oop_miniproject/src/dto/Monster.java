package game.dto;

import game.utils.Balance;
import game.utils.PropertyInterface;

public class Monster extends Characters implements PropertyInterface {
  // 처치된 횟수
  private int count;


  public int getCount() {
    return this.count;
  }

  public void setCount() {
    this.count++;
  }


  public Monster(String name, int level, int damage) {
    super(name, level, damage);
    setProperty();
  }

  public Monster(Monster monster) {
    super(monster);
    this.count = monster.count;
  }


  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(super.toString());
    builder.append(", 처치된 횟수 : ");
    builder.append(count);
    builder.append(" ]\n");
    return builder.toString();
  }

  @Override
  public void setProperty() {
    this.setHealth(this.getLevel() * Balance.MONSETER_HEALTH_BALANCE);
    this.setExp(this.getLevel() * Balance.MOB_EXP_BALANCE);

  }

  // 죽었을 때
  @Override
  public void setDead() {
    // TODO Auto-generated method stub
    this.count++;
    setDamage(getDamage() + 1);
  }
}
