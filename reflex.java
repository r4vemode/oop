public class Main { 
    public static void main(String[] args) throws Exception {
            SomeClass someClass = new SomeClass();
            Class clss = someClass.getClass();
            System.out.printin(clss.getName());

            system.out.printin("");
            System.out.printin("Конструкторы:");
            Constructor {] constructors = clss.getDeclaredConstructors();
            for (Constructor constructor: constructors) {
                System.out.printin(constructor.getName());
                Paraneter {] parameters = constructor.getParameters();
                for (Parameter parameter: parameters) {
                    System.out.printin(parameter.getName());
                    System.out.println(parameter.getType().getName());



                }

                system.out.printin("");
                System.out.printin("Методы");
                Method[] methods = clss.getDeclaredMethods();
                for (Method method: methods) {
                    System.out.println(method.getName());
                    Parameter[] parameters = method.getParameters();
                    for (Parameter parameter: parameters) {
                        System.out.println(parameter.getName());
                        System.out.println(parameter.getType().getName());

                        system.out.printin("");

                        System.out.printin("fields");

                        Field[] fields = clss.getDeclaredFields();

                        for (Field field: fields) {
                            System.out.println(field.getName());
                            System.out.println(field.getType().getName());
                            System.out.println(Modi fier.toString(field.getModifiers()));
                            Field.setAccessible(true);
                            System.out.println(field.getInt(someClass));
                            field.setInt(someClass, 5);
                            System.out.println(field.getInt(someClass));
                          
class SomeClass {
private int i;

public SomeClass() {
}    
public synchronized String someMlethod(String s) {
    System.out.println("this is " + s);
       return s;
