package example.myramen;


public abstract class 라면 {
    protected int 물;
    protected int 스프;
    protected int 면;
    protected 라면() {
        물 = 500;
        스프 = 80;
        면 = 150;
    }
    protected abstract int 물넣기();
    protected abstract int 스프넣기();
    protected abstract int 면넣기();
    public abstract void 조리하기();
}
