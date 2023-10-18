import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true) {
            String name = sc.nextLine();
            name = name.toLowerCase();
            int n = name.length();
            char[] ans = new char[n];
            int c = 0;
            while (c != 3) {
                System.out.println("You have "+ (3-c) +" chance to predict one character in String");
                char ch = sc.next().charAt(0);
                if (isPresent(name, ch)) {
                    place(name, ans, ch);
                    System.out.println("You have guessed one letter");
                    print(ans);
                    System.out.println();
                    c = 0;
                } else {
                    c++;
                }
                if (isWon(name, ans)) {
                    System.out.println("Congrats,You Won!!");
                    break;
                }
            }
            if(c==3)System.out.println("You Lost!!!");
            System.out.println("press N/n to Quit");
            char exit=sc.next().charAt(0);
            if(exit=='N' || exit=='n'){
                break;
            }
        }
    }
    public static boolean isPresent(String str,char c){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==c){
                return true;
            }
        }
        return false;
    }
    public static void place(String str,char[] ans,char ch){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==ch){
                ans[i]=ch;
            }
        }
    }
    public static boolean isWon(String name,char[] ans){
        for(int i=0;i<name.length();i++){
            if(name.charAt(i)!=ans[i])return false;
        }
        return true;
    }
    public static void print(char[] ans){
        for(int i=0;i<ans.length;i++){
            if(ans[i]=='\u0000'){
                System.out.print("_");
            }
            else{
                System.out.print(ans[i]);
            }
        }
    }
}