/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author arabtech
 */
public class Assignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter uinverse as a comma separated string");
            String universe = sc.next();
            String[] UniverseSubsets = universe.split(",");
            System.out.println("Enter number of subsets");
            int numberOfSubsets = sc.nextInt();
            List<List<String>> subsets = new ArrayList<>();
            for (int i = 0; i < numberOfSubsets; i++) {
                subsets.add(new ArrayList<>());
                System.out.println("Enter subset Size");
                int subSetSize = sc.nextInt();
                System.out.println("Enter subset as a space separated String");
                for (int j = 0; j < subSetSize; j++) {
                    subsets.get(i).add(sc.next());
                }
            }
            System.out.println("Enter the set operation\ncomplement,union,intersection");
            String operation = sc.next();
            if (operation.equals("complement")) {
                System.out.println("Enter set number");
                int set = sc.nextInt() - 1;
                complement(subsets.get(set), UniverseSubsets);
            } else if (operation.equals("union")) {
                System.out.println("Enter the two sets numbers");
                int first = sc.nextInt();
                int second = sc.nextInt();
                union(subsets.get(first), subsets.get(second));
            } else if (operation.equals("intersection")) {
                System.out.println("Enter the two sets numbers");
                int first = sc.nextInt();
                int second = sc.nextInt();
                intersection(subsets.get(first), subsets.get(second));
            }
        }
    }

    public static void union(List first, List second) {
        ArrayList<String> union = new ArrayList<>();
        for (int i = 0; i < first.size(); i++) {
            if (!union.contains(first.get(i))) {
                union.add((String) first.get(i));
            }
        }
        for (int i = 0; i < second.size(); i++) {
            if (!union.contains(second.get(i))) {
                union.add((String) second.get(i));
            }
        }
        for (int i = 0; i < union.size(); i++) {
            System.out.print(union.get(i) + " ");
        }
    }

    public static void intersection(List first, List second) {
        ArrayList<String> intersection = new ArrayList<>();
        for (int i = 0; i < first.size(); i++) {
            if (second.contains(first.get(i)) && !intersection.contains(first.get(i))) {
                intersection.add((String) first.get(i));
            }
        }
        for (int i = 0; i < intersection.size(); i++) {
            System.out.print(intersection.get(i) + " ");
        }
    }

    public static void complement(List list, String[] universe) {
        ArrayList<String> complement = new ArrayList<>();
        for (int i = 0; i < universe.length; i++) {
            if (!list.contains(universe[i])) {
                complement.add(universe[i]);
            }
        }
        for (int i = 0; i < complement.size(); i++) {
            System.out.print(complement.get(i) + " ");
        }
    }
}
