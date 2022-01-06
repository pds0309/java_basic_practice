package game.dto;

public class Skill {
  private static int id = 0;
  // 스킬 id
  private int skillId;
  // 스킬 이름
  private String name;
  // 마나 비용
  private int cost;
  // 사용가능 레벨
  private int level;
  // 데미지 비율
  private int damageRatio;

  public Skill() {
    //
  }

  public Skill(String name, int cost, int level, int damageRatio) {
    id++;
    this.skillId = id;
    this.name = name;
    this.cost = cost;
    this.level = level;
    this.damageRatio = damageRatio;
  }

  public int getSkillId() {
    return skillId;
  }

  public String getName() {
    return name;
  }

  public int getCost() {
    return cost;
  }

  public int getLevel() {
    return level;
  }

  public int getDamageRatio() {
    return damageRatio;
  }

  public int returnDamage(int damage) {
    return damage * (this.damageRatio / 100);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[아이디 : ");
    builder.append(skillId);
    builder.append(", 이름 : ");
    builder.append(name);
    builder.append(", 마나소모량 : ");
    builder.append(cost);
    builder.append(", 제한레벨 : ");
    builder.append(level);
    builder.append(", 데미지 : ");
    builder.append(damageRatio);
    builder.append("% ]\n");
    return builder.toString();
  }
}
