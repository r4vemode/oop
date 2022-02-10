import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Auth auth = new Auth();
        System.out.print("login: ");
        String login = input.next();
        auth.fillLogin(login);
        System.out.print("code: ");
        String code = input.next();
        if (auth.checkCode(code)) {
            System.out.println("Auth");
        } else {
            System.out.println("Not Auth");
        }
    }
}

class Coder {
    int maxLength = 6;
    private String code;
    private static Random rnd = new Random();
    public void sendCode() {
        char nextChar;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 7; i++) {
            nextChar = (char) (rnd.nextInt(26) + 97);
            sb.append(nextChar);
            if ((i + 1) % 6 == 0 && i != 6);
        }
        this.code = sb.toString();
        writeToFile(this.code);
    }
    static void writeToFile(String str) {
        try
        {
            FileWriter writer = new FileWriter("code.txt", false);
            writer.write(str);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    boolean checkCode(String code) {
        return (code.length() == this.maxLength && this.code.equals(code));
    }
}
class Auth {
    String phone;
    String email;
    String chekEmail = "^\\w+\\.?\\w+?@\\w+\\.\\w*\\.*\\w*";
    String checkPhone = "^[+]*[0-9]{1,4}[-\\s\\./0-9]*$";
    Coder coder = new Coder();
    void fillLogin(String login) {
        if (login.matches(this.chekEmail)) {
            this.sendCode();
            this.email = login;
        } else if (login.matches(this.checkPhone)) {
            this.phone = login;
            this.sendCode();
        } else {
            throw new IllegalArgumentException("Неверный логин");
        }
    }
    void sendCode() {
        this.coder.sendCode();
    }
    boolean checkCode(String code) {
        return this.coder.checkCode(code);
    }
}
