package Sorting;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("------------------------------");
        System.out.println("Prvních 50 týmu podle skóre");
        System.out.println("------------------------------");

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(MatchManager.getTeamScore().entrySet());
        SortingAlg.quicksort(entryList,0,entryList.size());
        for (int i = 0; i < 50; i++) {
            System.out.println(Integer.toString(i+1) + ". " + entryList.get(i));
        }

        System.out.println("--------------------------------");
        System.out.println("Seřazené mapy podle četností");
        System.out.println("--------------------------------");


        List<Map.Entry<String, Integer>> entryList2 = new ArrayList<>(MatchManager.getNumberOfMapOccurrences().entrySet());
        SortingAlg.insertionSort(entryList2);
        for (int i = 0; i < entryList2.size(); i++) {
            System.out.println(Integer.toString(i+1) + ". " + entryList2.get(i));
        }
    }
}