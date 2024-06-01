package Javabasics;

public class ChildClass extends ParentClass {

    int a =20;

    public static void main(String[] args) {

        ParentClass childClass =new ChildClass();
        System.out.println(childClass.a);
    }
}
