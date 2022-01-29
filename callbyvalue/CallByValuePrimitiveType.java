public class CallByValuePrimitiveType {

    public static void main(String[] args) { 
        int num = 10; 
        plus(num); int result = num; 
        System.out.println(result); 
    } 

    static void plus(int input) { 
        input = input + 25; 
    }

}