package Javabasics;

import org.testng.annotations.Test;

public class PyramidEg {

    @Test
    public void numberEg1(){
       /*  1 2 3 4
           5 6 7
           8 9
           10      */
        int k=1;
        for(int i=4;i>=1;i--){

            for(int j=1;j<=i;j++){
                System.out.print(k);
                System.out.print(" ");
                k++;


            }
            System.out.println();
        }


    }

    @Test
    public void numberEg2() {
/*
        1
        2 3
        4 5 6
        7 8 9 10*/
        int k=1;
        for(int i=1;i<=4;i++){
            for(int j=1;j<=i;j++){
                System.out.print(k);
                System.out.print(" ");
                k++;
            }
            System.out.println(" ");

        }
    }
}
