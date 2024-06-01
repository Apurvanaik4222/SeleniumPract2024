package Javabasics;

public class ArrayEgMaxNuminSmallRow {


           /* 2 4 5
              3 4 7
              1 2 9  */
           public static void main(String[] args) {

    int[][] array ={{2,4,8},{3,0,1},{1,2,7}};

    int minNum =array[0][0];
    int temp;
    int smallestRow =0;

    for(int i=0;i< array.length;i++){
        for(int j=0;j<array.length;j++){
            if(array[i][j]<minNum){
                minNum =array[i][j];
                smallestRow =j;


            }
        }

    }
               System.out.println(minNum);
               System.out.println(smallestRow);

               int k=0;
               int maxNum =0;
               while(k<=2){
                   if(array[k][smallestRow]>maxNum){
                       maxNum=array[k][smallestRow];
                   }
                   k++;
               }
               System.out.println(maxNum);
}

}
