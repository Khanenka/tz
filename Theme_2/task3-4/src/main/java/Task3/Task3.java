package Task3;

import java.util.*;
import java.io.*;
import java.lang.*;


import static java.util.Arrays.asList;

public class Task3 {

    static void avg(int x,int y){
        int size=2;
        double z=(double)(x+y)/size;
        System.out.println("average="+z);
    }
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(2);
        Scanner sc = new Scanner(System.in);
        System.out.println("Input x:");
        int x = sc.nextInt();
        System.out.println("Input y:");
        int y = sc.nextInt();
        int size = list.size();
        avg(x,y);
    }
}