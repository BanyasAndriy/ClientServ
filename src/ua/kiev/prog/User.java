package ua.kiev.prog;

import javax.xml.bind.SchemaOutputResolver;
import java.io.Console;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class User {

   private String login;
   private String parol;

   private AtomicInteger id = new AtomicInteger();
   private  int ID;
   private String status = "";
   private Scanner scanner = new Scanner(System.in);
private ConsoleMenu consoleMenu = ConsoleMenu.getInstanse();
   private List<User> users= new ArrayList<>();
    private Map<String ,String> logAndPass = new HashMap<String,String>();


    public User(String login, String parol) {
        this.login = login;
        this.parol = parol;

    }
    public User(){
    }

    public Map<String, String> getLogAndPass() {
        return logAndPass;
    }

    public String getLogin() {
        return login;
    }

    public String getParol() {
        return parol;
    }


    public void setParol(String parol) {
        this.parol = parol;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setStatus(String status) {
//        users.get(id.intValue()-1).setStatus(status);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void createAccount(){
        users.add(registration());
    }

    public int getId() {
        return id.intValue()-1;
    }

    public int getID() {
        return ID;
    }

    private User registration(){
Scanner sc = new Scanner(System.in);
        String log;
        String pass;
        String checkPass;
        while(true) {
            System.out.println("Input login : ");
            log = sc.nextLine();

            System.out.println("input password ");
            pass = sc.nextLine();
            System.out.println("Repeat password");
            checkPass = sc.nextLine();
            if (checkPass.equals(pass)) {
                this.id.incrementAndGet();
                System.out.println("your id = " + id);
                break;
            }
            else
                System.out.println("Error.Your first password difference second!!!\nTry again!!!");

        }
            logAndPass.put(log,pass);
        return new User(log,pass);

    }



    public boolean signIn(){
        if (logAndPass.isEmpty()){
            System.out.println("Акаунтів немає,спочатку зареєструйтесь!!!!");
            createAccount();
        }
        Scanner s = new Scanner(System.in);
        String log;
        String par;
        System.out.println("Input Login ");
            log = s.nextLine();
        System.out.println("Input Password ");
            par = s.nextLine();
int i = 0 ;
        for (Map.Entry<String, String> pair: logAndPass.entrySet())
        {
            if(pair.getKey().equals(log) && pair.getValue().equals(par)){
                System.out.println("Поставте статус вашого знаходження (online or offline)");
               //users.get(this.getId()).setStatus(s.nextLine());
               if (users.get(i).getLogin().equals(log) && users.get(i).getParol().equals(par)){
                   users.get(i).setStatus(s.nextLine());

               }

                System.out.println("You entered");
            break;
            }

            if(i == logAndPass.size()-1 ){
                System.out.println("Error\nTry again");
                signIn();
            }
        i++;
        }

        this.setID(i);
       return true;
    }

    public void showUser(){

        int count  = 1;

        for (User us: users) {
            System.out.println(count +". " +us  + "("+us.getStatus()+")" );
            count++;
        }


    }

    public void privateRoom(){


        int input;
        System.out.println("Hello "  + users.get(getID()) + "\nIt's your room and there you can do some interesting thing!");
        System.out.println("________________________________");
        System.out.println("|Input 1  to  set your status  |");
        System.out.println("|Input 2 to show list of users |");
        System.out.println("|Input 3 to send message       |");
        System.out.println("|Input 3 get your ID           |");
        System.out.println("|Input 4 to sign out           |");
        System.out.println("|Input 5 to close chat         |");
        System.out.println("________________________________");


        while(true) {
            System.out.println(users.get(getID()) + ",select,please,items!!!");
            input = scanner.nextInt();


            if (input == 1) {
                System.out.println("Input your status ('online' , 'offline' ')");
                String st;
                st = scanner.nextLine();
                users.get(getID()).setStatus(scanner.nextLine());
                continue;

            } else if (input == 2) {
                this.showUser();
                continue;
            } else if (input ==3) {
                System.out.println("Your id = " + this.getId());
            }
            else if (input == 4) {
                users.get(getID()).setStatus("Offline");
                for(int clear = 0; clear < 1000; clear++) {
                    System.out.println("\b") ;
                }



                consoleMenu.showMainMenu(this);
                continue;
            } else if (input == 5) {
                System.exit(0);
            }

        }


        }



   @Override
    public String toString() {
        return    login + " "   ;
    }
}
