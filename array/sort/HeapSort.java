package array.sort;

/**
 \* @Author: Linjj
 \* @Date: 2019/12/26 15:18
 \* @Description: 
 \*/
public class HeapSort {

    /**
     * 堆排序算法（完全二叉树，除了最后一层之外的其他每一层都被完全填充，并且所有结点都保持向左对齐-即从左到右）
     * @param array
     * @return
     */
    public static int[] HeapSort(int[] array) {
        // 声明全局变量，用于记录数组array剩余待排序的长度；
        int len = array.length;
        if (len < 1) {
            return array;
        }
        //1.从最后一个非叶子节点开始向上构造最大堆
        buildMaxHeap(array, len);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            // 除去已排好序的末位，使之重新调整最大堆
            adjustHeap(array, 0, len);
        }
        return array;
    }
    /**
     * 建立最大堆
     * @param array
     */
    public static void buildMaxHeap(int[] array, int len) {
        /*从最后一个非叶子节点开始向上构造最大堆
          父节点下标为N时，则左子节点：2N+1；右子节点：2N+2
          所以最后一个非叶子节点的父节点= (2N+1-1)/2  或者 (2N+2-1)/2，取整
          因是完全二叉树，所以向前遍历皆是父节点     */
        for (int i = (len - 1) / 2; i >= 0; i--) {
            adjustHeap(array, i, len);
        }
    }
    /**
     * 调整使之成为最大堆
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i, int len) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < len && array[i * 2] > array[maxIndex]) {
            maxIndex = i * 2;
        }
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex]) {
            maxIndex = i * 2 + 1;
        }
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            // 调整被交换影响到的子堆
            adjustHeap(array, maxIndex, len);
        }
    }

    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}