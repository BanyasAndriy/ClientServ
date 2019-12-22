package ua.kiev.prog;

import java.util.Scanner;

public class ConsoleMenu {

    private static  ConsoleMenu consoleMenu = new ConsoleMenu();
    private ConsoleMenu(){

    }

    public static ConsoleMenu getInstanse(){
        return consoleMenu;
    }


    public void showMainMenu(User user){
        Scanner in = new Scanner(System.in);


        int chosen;
        System.out.println("____________Меню____________");
        System.out.println("|Input number :             |");
        System.out.println("|1 - sign in                |");
        System.out.println("|2 - create account         |");
        System.out.println("|3 - sign out               |");
        System.out.println("_____________________________");
        chosen=in.nextInt();
        while(true) {

            if (chosen == 1) {
                user.signIn();
                user.privateRoom();
                break;
            } else if (chosen == 2) {
                user.createAccount();
                System.out.println("For sign in input 1");
                chosen=in.nextInt();}
                else if (chosen == 3) {
                  System.exit(0);

            } else System.out.println("Try again!");{
                break;
            }
        }

    }

}
