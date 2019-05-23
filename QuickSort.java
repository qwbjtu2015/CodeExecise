/**
 * 快排
 * 最差时间复杂度O(N^2) 最佳时间复杂度O(NlogN) 平均时间复杂度O(NlogN)
 * 当所有数字顺序排列或逆序排列时 复杂度最大 因为树深最大（N）
 * 树深最小为logN， 因此最佳时间复杂度为O(NlogN)
 */
public class QuickSort {
	public static void qSort(int left, int right, int[] data) {
		int middle = partation(left, right, data);
		qSort(left, middle-1, data);
		qSort(middle+1, right, data);
	}

	public static int partation(int left, int right, int[] data) {
		int pivot = data[left];
		while(left < right) {
			while(left < right && data[right] >= pivot)
				right--;
			data[left] = data[right];
			while(left < right && data[left] <= pivot)
				left++;
			data[right] = data[left];
		}
		data[left] = pivot;
		return left;
	}
}
