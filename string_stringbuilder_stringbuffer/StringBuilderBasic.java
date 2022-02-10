package example.string;

public class StringBuilderBasic {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        //문자열 이어 붙이기
        sb.append("붙일 문자열").append("\n");
        sb.append("또 붙일래");

        sb = new StringBuilder();
        sb.append("도레미파솔라시도");
        sb.delete(1,3);
        sb.reverse();
        // 도시라솔파도
        System.out.println(sb.toString());
    }
}
