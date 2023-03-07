package loop_java;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        System.out.println("Chon hinh muon ve");
        System.out.println("1.In hình chữ nhật\n" +
                "2.In hình tam giác vuông, có cạnh góc vuông ở botton-left\n" +
                "3.In hình tam giác vuông, có cạnh góc vuông ở top-left\n" +
                "4.In hình tam giác cân.\n" +
                "5.Exit\n");
        boolean refect= true;
        do {
            Scanner sc = new Scanner(System.in);
            int chon = sc.nextInt();
            switch (chon){
                case 1:
                    for ( int i=0; i < 3; i++){
                        for ( int j=0; j < 7; j++){
                            System.out.print(" * ");
                        }
                        System.out.println(" ");
                    }
                    break;
                case 2:
                    for ( int i=1; i <= 5; i++){
                        for ( int j=0; j < i; j++){
                            System.out.print(" * ");
                        }
                        System.out.println(" ");
                    }
                    break;
                case 3:
                    for ( int i=0; i < 5; i++){
                        for ( int j=5; j > i ; j--){
                            System.out.print(" * ");
                        }
                        System.out.println(" ");
                    }
                    break;
                case 4:
                    for ( int i=0; i < 5; i++){
                        for ( int j=5; j > i ; j-- ){
                            System.out.print(" ");
                        }
                        for ( int k=0; k < (i+1)*2-1; k++){
                            System.out.print("*");
                        }
                        System.out.println(" ");
                    }
                    break;
                case 5:
                    refect = false;
                    System.out.println("Exit...");
            }
        }while (refect);
    }
}
