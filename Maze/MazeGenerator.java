import java.util.*;

/**
 * class that has an algorithm to create a maze.
 * point start at 0, end to the last cell.
 */
public class MazeGenerator {

    //Scanner userTableSize = new Scanner(System.in);
    static int length = 40;//userTableSize.nextInt(); //columns
    static int width = 40;//userTableSize.nextInt(); //verses

    /**
     * Start - table[0][0]
     * End - table[length-1][width-1]
     * One dimension tables are used to make the calculation easier.
     * However, the length tells how much verses there are and the width tells how much columns there are. So it's like a 2D table.
     */
    static int sizeTable = length*width;
    static int[] tableOfUsedPoints = new int[sizeTable];
    static int[] tableOfConnections = new int[sizeTable];
    static int numbersInTOUP = 1; //numer mówiący ile elementów jest w Table od used points

    public static void startSettings(){
        for(int i = 0; i < sizeTable; i++){
            tableOfConnections[i] = -1;
        }

    }

    static boolean hasAchivedTheLoop = false;

    public static void loop(){
        int r;
        int cell;
        int lengthModule;
        int column;

        tableOfUsedPoints[0] = 0;
        tableOfConnections[0] = -2;

        for(int i = 0; i < sizeTable; i++) {
            hasAchivedTheLoop = false;
            r = randomized();
            cell = tableOfUsedPoints[r];
            lengthModule = tableOfUsedPoints[r] % length;
            column = cell/length;



            numbersInTOUP--;


            if (lengthModule > 0 && lengthModule < (length - 1)) {
                if (column > 0 && column < (width - 1)) {
                    Collections.shuffle(list4);
                    for(int j=0; j<4; j++){
                        draw(list4.get(j), cell);
                        if(hasAchivedTheLoop == true) break;
                    }
                } else if (column == (width - 1)) {
                    Collections.shuffle(list7);
                    for(int j=0; j<3; j++){
                        draw(list7.get(j), cell);
                        if(hasAchivedTheLoop == true) break;
                    }
                } else if (column == 0) {
                    Collections.shuffle(list1);
                    for(int j=0; j<3; j++){
                        draw(list1.get(j), cell);
                        if(hasAchivedTheLoop == true) break;
                    }
                }

            } else if (lengthModule == (length - 1)) {
                if (column > 0 && column < (width - 1)) {
                    Collections.shuffle(list5);
                    for(int j=0; j<3; j++){
                        draw(list5.get(j), cell);
                        if(hasAchivedTheLoop == true) break;
                    }
                } else if (column == (width - 1)) {
                    Collections.shuffle(list8);
                    for(int j=0; j<2; j++){
                        draw(list8.get(j), cell);
                        if(hasAchivedTheLoop == true) break;
                    }
                } else if (column == 0) {
                    Collections.shuffle(list2);
                    for(int j=0; j<2; j++){
                        draw(list2.get(j), cell);
                        if(hasAchivedTheLoop == true) break;
                    }
                }
            }

            else if(lengthModule == 0){
                if (column > 0 && column < (width - 1)) {
                    Collections.shuffle(list3);
                    for(int j=0; j<3; j++){
                        draw(list3.get(j), cell);
                        if(hasAchivedTheLoop == true) break;
                    }
                } else if (column == (width - 1)) {
                    Collections.shuffle(list6);
                    for(int j=0; j<2; j++){
                        draw(list6.get(j), cell);
                        if(hasAchivedTheLoop == true) break;
                    }
                } else if (column == 0) {
                    Collections.shuffle(list0);
                    for(int j=0; j<2; j++){
                        draw(list0.get(j), cell);
                        if(hasAchivedTheLoop == true) break;
                    }

                }
            }
            if(hasAchivedTheLoop == false){
                if(i == (sizeTable - 1)) break; //musi być, bo inaczej petla nieskonczona :(
                i--;
                tableOfUsedPoints[r] = tableOfUsedPoints[numbersInTOUP];
                numbersInTOUP--;
            }
            numbersInTOUP++;
        }

        /*for(int i = 0; i < sizeTable; i++){
            System.out.println("Dla i = " + i + " polaczenie z " + tableOfConnections[i]);
        }*/

    }


    static ArrayList<Integer> list0 = new ArrayList<Integer>();
    static ArrayList<Integer> list1 = new ArrayList<Integer>();
    static ArrayList<Integer> list2 = new ArrayList<Integer>();
    static ArrayList<Integer> list3 = new ArrayList<Integer>();
    static ArrayList<Integer> list4 = new ArrayList<Integer>();
    static ArrayList<Integer> list5 = new ArrayList<Integer>();
    static ArrayList<Integer> list6 = new ArrayList<Integer>();
    static ArrayList<Integer> list7 = new ArrayList<Integer>();
    static ArrayList<Integer> list8 = new ArrayList<Integer>();

    public static void fillingLists(){
        list0.add(1); list0.add(2);
        for(int i=0; i<3; i++) list1.add(i);
        list2.add(0); list2.add(1);
        for (int i=1; i<4; i++) list3.add(i);
        for(int i=0; i<4; i++) list4.add(i);
        list5.add(0); list5.add(1); list5.add(3);
        list6.add(2); list6.add(3);
        list7.add(0); list7.add(2); list7.add(3);
        list8.add(0); list8.add(3);
    }

    public static int randomized(){
        Random ran = new Random();
        int a = ran.nextInt(numbersInTOUP);
        if(a>0) return a-1;
        else return a;
    }

    public static void draw(int a, int cell){
        switch (a){
            case 0:
                if(tableOfConnections[cell-1] == -1){
                    hasAchivedTheLoop = true;
                    numbersInTOUP++;
                    tableOfUsedPoints[numbersInTOUP] = cell-1;
                    tableOfConnections[cell-1] = cell;
                }
                break;
            case 1:
                if(tableOfConnections[cell+width] == -1){
                    hasAchivedTheLoop = true;
                    numbersInTOUP++;
                    tableOfUsedPoints[numbersInTOUP] = cell+width;
                    tableOfConnections[cell+width] = cell;
                }
                break;
            case 2:
                if(tableOfConnections[cell+1] == -1){
                    hasAchivedTheLoop = true;
                    numbersInTOUP++;
                    tableOfUsedPoints[numbersInTOUP] = cell+1;
                    tableOfConnections[cell+1] = cell;
                }
                break;
            case 3:
                if(tableOfConnections[cell-width] == -1){
                    hasAchivedTheLoop = true;
                    numbersInTOUP++;
                    tableOfUsedPoints[numbersInTOUP] = cell-width;
                    tableOfConnections[cell-width] = cell;
                }
                break;
        }
    }

    static boolean[] up = new boolean[sizeTable];
    static boolean[] down = new boolean[sizeTable];
    static boolean[] right = new boolean[sizeTable];
    static boolean[] left = new boolean[sizeTable];


    public static void transcribePoints(){
        for(int i = 0; i < sizeTable; i++){
            if(tableOfConnections[i] == i - 1){
                up[i] = true;
                down[i - 1] = true;
            }
            if(tableOfConnections[i] == i + 1){
                down[i] = true;
                up[i + 1] = true;
            }
            if(tableOfConnections[i] == i - width){
                left[i] = true;
                right[i - width] = true;
            }
            if(tableOfConnections[i] == i + width){
                right[i] = true;
                left[i + 1] = true;
            }
        }

        /*for(int i = 0; i < sizeTable; i++){
            System.out.println("Punkt " + i + " posiada polaczenia:");
            if(up[i]) System.out.println("Up");
            if(down[i]) System.out.println("Down");
            if(right[i]) System.out.println("Right");
            if(left[i]) System.out.println("Left");

        }*/

    }


}