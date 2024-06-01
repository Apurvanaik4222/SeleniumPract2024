package Javabasics;

public class ArrayEgSmallestNum {


           /* 2 4 5
              3 4 7
              1 2 9  */
           public static void main(String[] args) {

    int[][] array ={{2,4,5},{3,4,0},{1,2,9}};

    int minNum =array[0][0];
    int temp;

    for(int i=0;i< array.length;i++){
        for(int j=0;j<array.length;j++){
            if(array[i][j]<minNum){
                minNum =array[i][j];


            }
        }

    }
               System.out.println(minNum);
}

}
