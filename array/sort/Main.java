package array.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    /**
     * @Author Linjj
     * @Date 2019/12/26 10:36
     * @Description 排序测试
     */
    public static void main(String[] args) {
        List<int[]> arrayList = new ArrayList<>();
        int[] array1 = new int[]{5,1,2,3,4};
        int[] array2 = new int[]{3,2,1,9,5,6,2,8,4,7};
        int[] array3 = new int[]{};
        arrayList.add(array1);
        arrayList.add(array2);
        arrayList.add(array3);

        for (int[] needSortArray : arrayList) {
            QuickSort.QuickSort(needSortArray, 0, needSortArray.length - 1);
        }
        System.out.println("快速排序：");
        print(arrayList);
    }

    public static void print(List<int[]> arrayList) {
        for (int[] array : arrayList) {
            String str = "[]";
            if (array != null) {
                str = Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(",", "[", "]"));
            }
            System.out.println(str);
        }
    }
}