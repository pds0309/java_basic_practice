package example.myramen;

public class 신라면 extends 라면 implements 계라너블 {
    private boolean requested계란;

    public 신라면(boolean requested계란) {
        super();
        this.requested계란 = requested계란;
    }

    @Override
    protected int 물넣기() {
        return 물;
    }

    // 신라면은 매워서 스프를 다 안 넣기
    @Override
    protected int 스프넣기() {
        return 스프 - 30;
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
        System.out.print("[넘무 맛있는 신라면 완성!");
        if (requested계란) {
            계란넣기();
        }
        System.out.println("]");
    }

    @Override
    public int 계란넣기() {
        System.out.print("계란 2개를 모두 풀어서 함유!");
        return 2;
    }
}
