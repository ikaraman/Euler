package com.problems.Problem11;
import com.problems.Problem11.FileReader;

public class Problem11 {
    public static void main(String[] args) {
        String pathToFile = "c:/javafile.txt";
        String stringToArray;
        stringToArray = FileReader.readAndReturn(pathToFile);
        int[][] fieldResult = convertFileIntoArray.convert(stringToArray);
        int highest = 0;
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                System.out.print(fieldResult[i][j] + " ");
                if(highest < compare.comparison(i, j, fieldResult)){
                    highest = compare.comparison(i, j, fieldResult);
                }
            }
            System.out.println("");
        }
        System.out.println("Highest multiplication is: " +highest);
    }
}

class generator{
    //not used in Main.Java
    //used if you want to generate random field of 2-digit numbers
    public static int[][] generateField(){
        int[][] field = new int[20][20];
        //System.out.println("test1");
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                //System.out.println("test2");
                field[i][j] = (int)(Math.random()*100);
                //System.out.println(field[i][j]);
            }
        }
        return field;
    }
}
class multiply{
    public static int multiplyRight(int i, int j, int[][] array) {
        int result = 0;
        if (i >= 0 && i < 20 && j >= 0 && j <= 16) {
            result = array[i][j] * array[i][j + 1] * array[i][j + 2] * array[i][j + 3];
        }
        return result;
    }
    public static int multiplyDiagLeftDownToTheRight(int i, int j, int[][] array) {
        int result = 0;
        if (i >= 0 && i <= 16 && j >= 0 && j <= 16) {
            result = array[i][j] * array[i + 1][j + 1] * array[i + 2][j + 2] * array[i + 3][j + 3];
        }
        return result;
    }
    public static int multiplyDiagLeftUpToTheRight(int i, int j, int[][] array) {
        int result = 0;
        if (i >= 3 && i < 20 && j >= 0 && j <= 16) {
            result = array[i][j] * array[i - 1][j + 1] * array[i - 2][j + 2] * array[i - 3][j + 3];
        }
        return result;
    }
    public static int multiplyBot(int i, int j, int[][] array) {
        int result = 0;
        if (i >= 0 && i <= 16 && j >= 0 && j < 20) {
            result = array[i][j] * array[i + 1][j] * array[i + 2][j] * array[i + 3][j];
        }
        return result;
    }
}
class compare{
    public static int comparison(int i, int j, int[][] array){
        int result = 0;
        if( i >= 0 && i <= 16 && j >= 0 && j < 20){
            if (result < multiply.multiplyBot(i,j,array)){
                result = multiply.multiplyBot(i,j,array);
            }
        }
        if( i >= 0 && i <= 16 && j >= 0 && j <= 16){
            if (result < multiply.multiplyDiagLeftDownToTheRight(i, j, array)){
                result = multiply.multiplyDiagLeftDownToTheRight(i, j, array);
            }
        }
        if( i >= 0 && i <= 16 && j >= 0 && j <= 16){
            if (result < multiply.multiplyDiagLeftUpToTheRight(i, j, array)){
                result = multiply.multiplyDiagLeftUpToTheRight(i, j, array);
            }
        }
        if( i >= 0 && i < 20 && j >= 0 && j <= 16){
            if (result < multiply.multiplyRight(i, j, array)){
                result = multiply.multiplyRight(i, j, array);
            }
        }
        return result;
    }
}
class convertFileIntoArray{
    public static int[][] convert(String filePath) {
        int[][] array = new int[20][20];
        String filePath2 = filePath.substring(0, 1199);
        //System.out.println(filePath2);
        int howManyLetters = filePath2.length();
        //System.out.println("There are " + howManyLetters + " letters in the string.");
        for (int k = 0; k <= 1196;){
            for (int i = 0; i < 20;) {
                for (int j = 0 ; j < 20;) {
                    //System.out.println(i);
                    //System.out.println(j);
                    //System.out.println(k);
                    if (Integer.valueOf(filePath.charAt(k)) == 0){
                        array[j][i] = Integer.valueOf(filePath2.charAt(k + 1));
                    } else {
                        array[j][i] = Integer.valueOf(String.valueOf(filePath2.charAt(k)) + String.valueOf(filePath2.charAt(k + 1)));
                    }
                    //System.out.println(array[j][i] + "<--array element");
                    if ( k == 57 ) {
                        j++;
                        i = 0;
                    } else if ( k > 60 && k <= 1197 && ((k + 3) % 60 == 0) && j < 19) {
                        j++;
                        i = 0;
                    } else if (i < 19) {
                        i++;
                    }
                    if (k <= 1196) {
                        k = k + 3;
                    } else return array;
                }
            }
        }
        return array;
    }
}
