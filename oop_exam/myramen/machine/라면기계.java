package example.myramen.machine;

import example.AC;
import example.myramen.*;

import java.util.List;

public class 라면기계 {
    public static void main(String[] args) {
        // 라면 ramen = new 라면();

        라면 requestedRamen1 = new 너구리();
        requestedRamen1.조리하기();

        라면 requestedRamen2 = new 진라면(false);
        requestedRamen2.조리하기();

        라면 requestedRamen3 = new 진라면(true);
        requestedRamen3.조리하기();

        라면 requestedRamen4 = new 신라면(true);
        requestedRamen4.조리하기();

        // 계라너블 너구리에_누가계란넣어 = new 너구리();
        계라너블 계란넣을수있는라면이_먹고싶어요 = new 신라면(true);
        라면 requestedEggableRamen1 = (라면) 계란넣을수있는라면이_먹고싶어요;
        requestedEggableRamen1.조리하기();

    }
}
