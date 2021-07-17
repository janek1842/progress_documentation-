package exercises;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * TODO
 * Uporządkuj ten kod używając zasad przedstawionych podczas prezentacji, władnej kreatywności oraz logiki
 * Kod powinien być jak najbardziej czytelny i przejrzysty, przede wszystkim dla osoby widzącej go pierwszy raz
 */

/*
 * SelectionSort
 * Version modified
 * 13.04.2021
 * Copyright notice- Version modified by Jan Scg
 */


public class SelectionSort {

    public static void sort() {

        Scanner scanner = new Scanner(System.in);

        //TODO Let's use arrays of doubles to improve the program
        ArrayList<Integer> arrayForInputData = new ArrayList<>();
        ArrayList<Integer> arrayForOutputData = new ArrayList<>();

        int lengthOfElements = getSizeOfElementsFromUser(scanner);

        getElementsFromUser(arrayForInputData, lengthOfElements, scanner);

        // TODO Sorting algorithm can be optimized
        sortElements(arrayForInputData, arrayForOutputData, lengthOfElements);

        printSortedElements(lengthOfElements, arrayForOutputData);

    }

    public static void printSortedElements(int lengthOfElements, ArrayList<Integer> arrayForOutputData) {
        System.out.println("Sorted data:");
        for (int i = 0; i < lengthOfElements; i++) {
            System.out.print(arrayForOutputData.get(i) + " ");
        }
    }

    public static int findIndexOfMinRemElement(ArrayList<Integer> arrayForInputData, int indexOfMinElement) {
        for (int q = 0; q < arrayForInputData.size(); q++) {
            if (arrayForInputData.get(q) < arrayForInputData.get(indexOfMinElement)) {
                indexOfMinElement = q;
            }
        }
        return indexOfMinElement;
    }

    public static ArrayList<Integer> getElementsFromUser(ArrayList<Integer> arrayForInputData, int lengthOfElements, Scanner scanner) {
        System.out.println("Type all elements:");
        for (int i = 0; i < lengthOfElements; i++) {
            arrayForInputData.add(scanner.nextInt());
        }
        return arrayForInputData;
    }

    public static int getSizeOfElementsFromUser(Scanner scanner) {
        // Warning ! If user types a negative number, program crashes !
        System.out.print("Type table length: ");
        return scanner.nextInt();
    }

    public static void sortElements(ArrayList<Integer> arrayForInputData, ArrayList<Integer> arrayForOutputData, int lengthOfElements) {
        for (int i = 0; i < lengthOfElements; i++) {
            int indexOfMinElement = 0;
            int foundedIndexOfMinRemElement = findIndexOfMinRemElement(arrayForInputData, indexOfMinElement);
            int foundedMinElement = arrayForInputData.get(foundedIndexOfMinRemElement);
            arrayForOutputData.add(foundedMinElement);
            arrayForInputData.remove(foundedIndexOfMinRemElement);
        }
    }

    public static void main(String[] args) {
        sort();
    }
}
