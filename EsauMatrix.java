package esaumatrix;

import java.util.Random;
import java.util.Scanner;

/*
 * @author gabriele
 */
public class EsauMatrix {
    
    public static int iGuessed, jGuessed;
    
    public static boolean findNum(int[][] M, int n, int nm) {
        for (int i = 0; i < nm; i++) {
            for(int j = 0; j < nm; j++){
                if(n == M[i][j]){
                    iGuessed = i;
                    jGuessed = j;    
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        
        final int DIM = 5;
        
        System.out.println("●▬▬▬▬▬ArrayEsau▬▬▬▬▬●");

        System.out.print("Enter the maximum range: ");
        final int mr = scan.nextInt();

        int[][] matrix = new int[DIM][DIM];
        int total = 0;
        int[] nrow = new int[DIM];
        int[] ncol = new int[DIM];
        for (int i = 0; i < DIM; i++) {
            nrow[i] = 0;
            for(int j = 0; j < DIM; j++){
                if(i == 0){
                    ncol[j] = 0;
                }
                matrix[i][j] = rand.nextInt(mr);
                total += matrix[i][j];
                nrow[i] += matrix[i][j];
                ncol[j] += matrix[i][j];
                System.out.print(matrix[i][j]+ "\t");
            }
            System.out.println("");
        }

        boolean won = false;
        for (int j = 3; j >= 1 && !won; j--) {

            System.out.println("Lives " + j);
            System.out.println("Insert a number:");
            int num = scan.nextInt();

            won = findNum(matrix, num, DIM);
            if (won) {
                System.out.println(""
                        + "W	       W	   W	III	NN     N\n"
                        + " W	      W W	  W	III	N N    N\n"
                        + "  W	     W   W	 W	III	N  N   N\n"
                        + "   W	    W     W     W	III	N   N  N\n"
                        + "    W   W	   W   W	III	N    N N\n"
                        + "     W W	    W W		III	N     NN\n"
                        + "      W           W		III	N      N");
                System.out.println("Il numero vincente si trova in " + iGuessed + ", " + jGuessed);
            }else {
                System.out.println("Try again");
            }

        }
        if (!won) {
            System.out.println("YOU LOST!");
        }
        scan.nextLine();//in order to clean buffer
        System.out.println("Want to know other info?");
        String info = scan.nextLine();
            
            if (info.equalsIgnoreCase("yes")){
                
                System.out.println("The sum of all the numbers generated is: " + total);
                
                for(int r = 0; r < DIM; r++){
                    System.out.println("The sum of row " + r + " is: " + nrow[r]);
                    System.out.println("The sum of column " + r + " is: " + ncol[r]);
                }
            }else
                System.out.println("");

    }

}
