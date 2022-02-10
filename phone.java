public class Main {
    public static void main(String[] args) {
        BabushkaPhone BabushkaPhone = new BabushkaPhone();
        SmartPhone SmartPhone = new SmartPhone();
        System.out.println();
    }
}

public class Phone {
    public String serialNumber;
    public String model;
    public int weight;

    public Phone(){

        serialNumber = "+7-985-583-53-46";
        model = "Nokia";
        weight = 20;
    }
    public void receiveCall(String name){
        System.out.println(" тебе звонит " + name);
    }
    public void getNumber(){
        System.out.println(serialNumber);
    }
    void display() {
        System.out.printf("Телефон: %s\nМодель: %s\nВес %d\n", serialNumber, model, weight);
    }
}
public class BabushkaPhone extends Phone{
    public int permission;
    public String price;
    public String camera;

    public BabushkaPhone(){
        int serialNumber = 112;
    }

    @Override
    public void receiveCall(String name){
        System.out.println("тебе звонит" + name);
    }
    public void getAllData() {
        System.out.printf("permission: %d\nprice: %s\ncamera: %s\n", permission, price, camera);
    }

    public void getYouCall() {
        System.out.println("вы звоните человеку");
    }
}

public class SmartPhone extends Phone{
    public int permission;
    public String price;
    public String camera;

    public SmartPhone(){
        super.model = "IPhone 11";
        super.weight = 12;
    }

    public void sendMessage(){
        System.out.println("вы получили сообщение!");
    }
    public void getAllData() {
        System.out.printf("permission: %d\nprice: %s\ncamera: %s\n", permission, price, camera);
    }

    public void getVideo() {
        System.out.println("вы снимаете видео!");
    }
}
