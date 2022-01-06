package game.dto;

import game.utils.Balance;

/**
 * 
 * @author PDS
 * 
 *
 */

public class Characters {

  // 고유 id
  private static long id = 1000L;
  private long charId;
  // 이름
  private String name;
  // 체력
  private int health;
  // 레벨
  private int level;
  // 공격력
  private int damage;
  // 경험치
  private int exp;

  public Characters() {
    //
  };

  public Characters(String name, int level, int damage) {
    id++;
    this.charId = id;
    this.name = name;
    this.level = level;
    this.damage = damage;
  }

  public Characters(Characters characters) {
    this.charId = characters.charId;
    this.name = characters.name;
    this.health = characters.health;
    this.level = characters.level;
    this.damage = characters.damage;
    this.exp = characters.exp;
  }

  public long getCharId() {
    return charId;
  }

  public String getName() {
    return name;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth() {
    this.health = this.level * Balance.HEALTH_BALANCE;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = this.level + level;
  }

  public int getDamage() {
    return damage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public int getExp() {
    return exp;
  }

  public void setExp(int exp) {
    this.exp = exp;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[아이디 : ");
    builder.append(charId);
    builder.append(", 이름 : ");
    builder.append(name);
    builder.append(", 레벨 : ");
    builder.append(level);
    builder.append(", 데미지 : ");
    builder.append(damage);
    builder.append(", 체력 : ");
    builder.append(health);
    builder.append(", 경험치: ");
    builder.append(exp);
    return builder.toString();
  }

  // 자식 객체를 가진 Characters type 에서 사용가능
  public void setDead() {}
}
