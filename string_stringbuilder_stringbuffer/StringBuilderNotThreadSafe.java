package example.string;

public class StringBuilderNotThreadSafe {
    public static void main(String[] args) throws InterruptedException {

        StringBuilder sb = new StringBuilder();
        MultiThread[] mtForStringBuilder = new MultiThread[10];
        String[] arr = {"11", "22", "33", "44", "55", "너와", "나의", "88", "99", "??"};
        for (int i = 0; i < arr.length; i++) {
            mtForStringBuilder[i] = new MultiThread(arr[i], sb);
        }
        for (int i = 0; i < arr.length; i++) {
            mtForStringBuilder[i].start();
        }

        for (int i = 0; i < arr.length; i++) {
            mtForStringBuilder[i].join();
        }

        System.out.println(sb.toString());
        System.out.println("예상길이: 200 / 실제길이: " + sb.length());
    }
}

class MultiThread<T> extends Thread {
    private String text;
    private T sb;

    MultiThread(String text, T sb) {
        this.sb = sb;
        this.text = text;
    }

    public void run() {
        try {
            if (sb instanceof StringBuffer) {
                for (int i = 0; i < 10; i++) {
                    ((StringBuffer) (sb)).append(text);
                }
            }
            if (sb instanceof StringBuilder) {
                for (int i = 0; i < 10; i++) {
                    ((StringBuilder) (sb)).append(text);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


