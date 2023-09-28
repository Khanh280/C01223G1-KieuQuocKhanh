package resentation;

public class DemoString {
    public static void main(String[] args) {
//        String str = "hello";
//        String newStr = new String("hello");
//        System.out.println(newStr == str);
//        System.out.println(str.equals(newStr));

//        StringBuffer
//        StringBuffer buffer = new StringBuffer("Hello");
//        buffer.append("Word");
//        System.out.println(buffer);
//
////        StringBuilder
//        StringBuịlder buider = new StringBuilder("Hello");
//        buider.append("Word");
//        System.out.println(buider);

        //Demo
        long startTime = System.currentTimeMillis();
        StringBuffer buffer = new StringBuffer("Hello");
        for (int i=0; i<100000; i++){
            buffer.append("Word");
        }
        System.out.println("StringBuffer is: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        StringBuilder buider = new StringBuilder("Hello");
        for (int i=0; i<100000; i++){
            buider.append("Word");
        }
        System.out.println("StringBuilder is: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
