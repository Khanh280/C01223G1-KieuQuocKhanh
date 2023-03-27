package test_lap;

import java.io.*;

public class Main {
    private static final String ABC = "src/test_lap/abc.txt";

    private static void copyFileUsingStream() throws IOException {
        File file = new File(ABC);
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            String str = "Khanh";
            byte[] bytes = str.getBytes();
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void abc() {
        File file = new File(ABC);
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            StringBuilder str = new StringBuilder();
            int c;
            while ((c = bufferedInputStream.read()) != -1) {
                str.append((char) c);
            }
            String result = str.toString();
            System.out.println(result);
            bufferedInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            copyFileUsingStream();
            abc();
        } catch (IOException ioe) {
            System.out.printf("Can't copy that file");
            System.out.printf(ioe.getMessage());
        }
    }
}
