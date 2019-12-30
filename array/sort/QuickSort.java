package array.sort;

public class QuickSort {
    /**
     * 快速排序方法（采用分治法按基准分区排序，一侧都比基准小，一侧都比基准大）
     * @param array
     * @param start 数组起始下标
     * @param end 数组末尾下标
     * @return
     */
    public static int[] QuickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) {
            return null;
        }
        int smallIndex = partition(array, start, end);
        if (smallIndex > start) {
            QuickSort(array, start, smallIndex - 1);
        }
        if (smallIndex < end) {
            QuickSort(array, smallIndex + 1, end);
        }
        return array;
    }
    /**
     * 快速排序算法——partition（以基准，分割出左右两个分区）
     * @param array
     * @param start
     * @param end
     * @return 分割排序后的基准点下标
     */
    public static int partition(int[] array, int start, int end) {
        // 随机获取基准点
        int pivot = (int) (start + Math.random() * (end - start + 1));
        // 左右分区后，比基准点小的下标，起始于数组开头前位
        int smallIndex = start - 1;
        // 先将基准点移至末尾，避免循环比较的中途改变了基准点位置
        swap(array, pivot, end);
        // 当循环至i=end时，相当已分割完两侧分区，将末尾的基准值移至smallIndex后一位，即完成基准点的左右分割排序
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                smallIndex++;
                swap(array, i, smallIndex);
            }
        }
        return smallIndex;
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
