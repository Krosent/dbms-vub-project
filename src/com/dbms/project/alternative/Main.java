package com.dbms.project.alternative;

import com.dbms.project.MultiWayMerge.Extsort;
import com.dbms.project.experiment1.*;
import com.dbms.project.experiment1.LengthReadStreamMethodOne;
import com.dbms.project.experiment2.RandomReadingExperiment;
import com.dbms.project.experiment2.RandomReadingExperimentOne;
import com.dbms.project.experiment2.RandomReadingExperimentTwo;
import com.dbms.project.streamInterfaces.ReadStreamInterface;
import com.dbms.project.streamInterfaces.WriteStreamInterface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        class Sortbyk implements Comparator<List<String>> {
            // Used for sorting in ascending order of
            // roll number
            public int compare(List<String> a, List<String> b) {
                return a.get(2).compareTo(b.get(2));
            }
        }
/*
        System.out.println("--- Write Function METHOD ONE ---");
        // Execute write function of first method
        writeStreamMethodOne();
        System.out.println("--- END ---");

 */

/*
        System.out.println("--- READ Function METHOD ONE ---");
        // Execute write function of first method
        readStreamMethodOne();
        System.out.println("--- END ---");
*/

/*
        System.out.println("--- Write Function METHOD TWO ---");
        // Execute write function of second method
        writeStreamMethodTwo();
        System.out.println("--- END ---");
 */

/*
        System.out.println("--- READ Function METHOD TWO ---");
        // Execute write function of second method
        readStreamMethodTwo();
        System.out.println("--- END ---");

 */

/*
        System.out.println("--- READ Function METHOD THREE ---");
        // Execute read function of the third method
        readStreamMethodThree();
        System.out.println("--- END ---");
 */

/*
        System.out.println("--- WRITE Function METHOD THREE ---");
        // Execute read function of the third method
        writeStreamMethodThree();
        System.out.println("--- END ---");
 */

/*
        System.out.println("--- READ Function METHOD FOURTH ---");
        // Execute read function of the fourth method
        readStreamMethodFour();
        System.out.println("--- END ---");
 */

/*
        System.out.println("--- WRITE Function METHOD FOURTH ---");
        // Execute write function of fourth method
        writeStreamMethodFour();
        System.out.println("--- END ---");
 */

        // Experiment1version4();
        Experiment1version2();

/*
        System.out.println("--- START Testing EXT SORT");
        TestExtsort();
        System.out.println("--- END OPERATION ---");

 */



        System.out.println("--- START Random Reading Experiment | ONE ---");
        randomReadExperimentOne();
        System.out.println("--- END OPERATION ---");



        /*
        System.out.println("--- START Random Reading Experiment | TWO ---");
        randomReadExperimentTwo();
        System.out.println("--- END OPERATION ---");

         */
    }

    public static void Experiment1version4() {
        String file = "comp_cast_type.csv";

        LengthReadStreamMethodFour length1 = new LengthReadStreamMethodFour(5);
        int sum = length1.calculateSum(file);
        System.out.println("sum" + sum);


    }

    public static void Experiment1version2() {
        String file = "comp_cast_type.csv";

        LengthReadStreamMethodTwo length1 = new LengthReadStreamMethodTwo();
        int sum = length1.calculateSum(file);
        System.out.println("sum" + sum);

    }



    public static void TestExtsort() {
        String file = "kind_type.csv";

        ReadStreamInterface readStreamInstance = new ReadStreamMethodOneImpl();
        WriteStreamInterface writeStreamInstance = new WriteStreamMethodOneImpl();
        Extsort srt = new Extsort(file, 2, 20, 2, readStreamInstance, writeStreamInstance);
        srt.doSort();
    }

    public static void readStreamMethodOne() {
        ReadStreamInterface readStreamInstance = new ReadStreamMethodOneImpl();
        try {
            readStreamInstance.open("src/com/dbms/project/data/comp_cast_type.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                while (!(readStreamInstance.endOfStream())) {
                    readStreamInstance.readLn();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeStreamMethodOne() {
        WriteStreamInterface writeStreamInstance = new WriteStreamMethodOneImpl();
        try {
            writeStreamInstance.create("sortedFile");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writeStreamInstance.writeLn("1, movie");
                writeStreamInstance.writeLn("5, tv mini series");
                writeStreamInstance.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Write operation succeed");
            }
        }
    }

    public static void readStreamMethodTwo() {
        ReadStreamInterface readStreamInstance = new ReadStreamMethodTwoImpl();
        try {
            readStreamInstance.open("src/com/dbms/project/alternative/readFile");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                while (!(readStreamInstance.endOfStream())) {
                    readStreamInstance.readLn();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeStreamMethodTwo() {
        WriteStreamInterface writeStreamInstance = new WriteStreamMethodTwoImpl();
        try {
            writeStreamInstance.create("newFile2");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writeStreamInstance.writeLn("Hello World!");
                writeStreamInstance.writeLn("Hello World2!");
                writeStreamInstance.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Write operation succeed");
            }
        }
    }

    public static void readStreamMethodThree() {
        ReadStreamInterface readStreamInstance = new ReadStreamMethodThreeImpl(5);
        try {
            readStreamInstance.open("src/com/dbms/project/data/comp_cast_type.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                while (!(readStreamInstance.endOfStream())) {
                    readStreamInstance.readLn();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeStreamMethodThree() {
        WriteStreamInterface writeStreamInstance = new WriteStreamMethodThreeImpl(5);
        try {
            writeStreamInstance.create("newFile3");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writeStreamInstance.writeLn("Hello World!");
                writeStreamInstance.writeLn("Hello World2!");
                writeStreamInstance.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Write operation succeed");
            }
        }
    }

    public static void readStreamMethodFour() {
        ReadStreamInterface readStreamInstance = new ReadStreamMethodFourImpl(5);
        try {
            readStreamInstance.open("src/com/dbms/project/alternative/readFile");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                int i = 2;
                while (!(readStreamInstance.endOfStream())) {
                    readStreamInstance.seek(i);
                    readStreamInstance.readLn();
                    i += 3;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeStreamMethodFour() {
        WriteStreamInterface writeStreamInstance = new WriteStreamMethodFourImpl(5);
        try {
            writeStreamInstance.create("newFile4");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writeStreamInstance.writeLn("Hello World!");
                writeStreamInstance.writeLn("Hello World2!");
                writeStreamInstance.writeLn("Hello world3!");
                writeStreamInstance.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Write operation succeed");
            }
        }
    }

    public static void randomReadExperimentOne() throws IOException {
        RandomReadingExperimentOne randomReadingExperimentOne = new RandomReadingExperimentOne();
        randomReadingExperimentOne.executeExperiment("kind_type.csv");
    }

    public static void randomReadExperimentTwo() throws IOException {
        RandomReadingExperimentTwo randomReadingExperimentTwo = new RandomReadingExperimentTwo();
        randomReadingExperimentTwo.executeExperiment("kind_type.csv");
    }
}
