package example.myramen;

public class 진라면 extends 라면 implements 계라너블 {

    private boolean request계란;

    public 진라면(boolean request계란) {
        super();
        this.request계란 = request계란;
    }

    @Override
    // 진라면은 싱거워서 물을 정량보다 적게 넣기로 했다.
    protected int 물넣기() {
        return 물 - 30;
    }

    @Override
    protected int 스프넣기() {
        return 스프;
    }

    @Override
    protected int 면넣기() {
        return 면;
    }

    @Override
    public void 조리하기() {
        물넣기();
        스프넣기();
        면넣기();
        System.out.print("[개 맛있는 진라면 완성!");
        if (request계란) {
            계란넣기();
        }
        System.out.println("]");
    }

    @Override
    public int 계란넣기() {
        if (request계란) {
            System.out.print("(계란을 반만 풀어서 함유!)");
            return 1;
        }
        return 0;
    }
}
