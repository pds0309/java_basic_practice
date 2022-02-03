package example.myramen;

// 너구리에 계란 넣는 사람이 있을까?
public class 너구리 extends 라면 {

    private int 다시마;

    public 너구리() {
        this.다시마 = 1;
    }

    // 랜덤으로 다시마 2개 이벤트 발생
    // 이걸 끓이는 자와 먹는 자가 알 수 있을까?
    private int 다시마넣기() {
        return (int) Math.round(Math.random() + 1);
    }

    @Override
    protected int 물넣기() {
        return 물;
    }

    @Override
    protected int 스프넣기() {
        return 0;
    }

    @Override
    protected int 면넣기() {
        return 0;
    }

    // 너구리는 면이 잘 안 익어서 스프전에 면부터 넣으면 맛있다더라
    @Override
    public void 조리하기() {
        물넣기();
        면넣기();
        스프넣기();
        int dasima = 다시마넣기();
        System.out.println("[너무 맛있는 너구리 완성! - 다시마(" + dasima + ")개 함유");
    }
}
