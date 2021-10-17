package com.att.algorithms;

import java.util.Arrays;

public class MergeAlgorithm {
    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 6, 4, 1, 3, 2, 6};
        System.out.println(Arrays.toString(array));
        sort(array, 1, array.length);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array, int pos, int length) {
        if (pos < length) {
            int count = (length + pos) / 2;

            sort(array, pos, count);
            sort(array, count + 1, length);
            merge(array, pos, count, length);
        }
    }

    public static void merge(int[] sourceArray, int l, int m, int r) {
        int leftArraySize = m - l + 1;
        int rightArraySize = r - m;

        // Создание массивов для сравнения
        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];

        // Заполнение массивов
        System.arraycopy(sourceArray, l - 1, leftArray, 0, leftArraySize);
        System.arraycopy(sourceArray, m, rightArray, 0, rightArraySize);

        int i = 0;
        int j = 0;

        int k = l - 1;
        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] <= rightArray[j]) {
                sourceArray[k] = leftArray[i];
                i++;
            } else {
                sourceArray[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArraySize) {
            sourceArray[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArraySize) {
            sourceArray[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
