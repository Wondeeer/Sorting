package Sorting;

import java.util.*;

public class SortingAlg {

    public static void insertionSort(List < Map.Entry < String, Integer >> array) {
        Map.Entry<String, Integer>[] entries = array.toArray(new Map.Entry[0]);
        for (int i = 1; i < array.size(); i++) {
            int j = i;
            Map.Entry<String, Integer> tmp = entries[i];


            while (j > 0 && tmp.getValue() > entries[j - 1].getValue()) {
                entries[j] = entries[j - 1];
                j--;
            }
            entries[j] = tmp;
        }
        array.clear();
        Collections.addAll(array, entries);
    }

    public static void quicksort (List < Map.Entry < String, Integer >> array,int left, int right){
        if (left < right) {
            int boundary = left;
            Map.Entry<String, Integer> pivotEntry = array.get(left);

            for (int i = left + 1; i < right; i++) {
                if (compareEntries(array.get(i), pivotEntry) > 0) {
                    boundary++;
                    swap(array, i, boundary);
                }
            }
            swap(array, left, boundary);
            quicksort(array, left, boundary);
            quicksort(array, boundary + 1, right);
        }
    }


    private static void swap (List < Map.Entry < String, Integer >> list,int left, int right){
        Map.Entry<String, Integer> tmp = list.get(right);
        list.set(right, list.get(left));
        list.set(left, tmp);
    }

    private static int compareEntries (Map.Entry < String, Integer > entry1, Map.Entry < String, Integer > entry2){
        return Integer.compare(entry1.getValue(), entry2.getValue());
    }
}


//    public static void selectionSort(ArrayList<Match> matchList) {
//        for (int i = 0; i < matchList.size() - 1; i++) {
//            int maxIndex = i;
//
//            for (int j = i + 1; j < matchList.size(); j++) {
//                if (matchList.get(j) > matchList.get(maxIndex))
//                    maxIndex = j;
//            }
//            int tmp = matchList.get(i);
//            matchList.get(i) = matchList.get(maxIndex);
//            matchList.get(maxIndex) = tmp;
//        }
//    }
//
//    public static void bubbleSort(ArrayList<Match> matchList) {
//        for (int i = 0; i < matchList.size() - 1; i++) {
//            for (int j = 0; j < matchList.size() - i - 1; j++) {
//                if (matchList.get(j) < matchList.get(j+1)){
//
//                    int tmp = matchList.get(j);
//                    matchList.get(j) = matchList.get(j+1);
//                    matchList.get(j+1) = tmp;
//                }
//            }
//        }
//    }







