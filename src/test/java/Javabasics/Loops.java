package Javabasics;

import org.testng.annotations.Test;

public class Loops {

    @Test
    public void whileEg(){

        int k=1;

        while(k<=10){
            System.out.println(k);
            k++;
        }

    }


    @Test
    public void doWhileEg(){
        int k=11;
        do{
            System.out.println(k);
            k++;
        }while(k<=10);
    }
}
