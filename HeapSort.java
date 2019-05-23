/**
 * 堆排序
 * 把调整堆这个功能抽离出来，通过递归调用实现堆的调整【maxHeap函数】
 */
public class HeapSort {
  	public static void heapSort(int[] data) {
		// 由原始数组构建堆
		buildHeap(data);
		// 每次将堆顶元素与当前堆的最后一个元素交换，然后缩小堆大小，并调整堆
		for(int i = 0; i < data.length; i++) {
			int temp = data[0];
			data[0] = data[data.length - 1 - i];
			data[data.length - 1 -i] = temp;
			maxHeap(0, data.length - i - 1, data);
		}
	}

	public static void buildHeap(int[] data) {
		// 从倒数第一个非叶子节点向上依次调整
		for(int i = data.length/2 - 1; i >= 0; i--){
			maxHeap(i, data.length, data);
		}
	}

	/**
	* 递归调用以调整堆
	* @param data 数据数组
	* @param heapSize 当前堆长度
	* @param curr 要调整的位置
	*/
	public static void maxHeap(int curr, int heapSize, int[] data) {
		int left = curr*2+1;
		int right = curr*2+2;
		int maxIdx = curr;
		if(left < heapSize && data[left] > data[maxIdx])
			maxIdx = left;
		if(right < heapSize && data[right] > data[maxIdx])
			maxIdx = right;
		if (maxIdx != curr) {
			int temp = data[curr];
			data[curr] = data[maxIdx];
			data[maxIdx] = temp;
			maxHeap(maxIdx, heapSize, data);
		}
	}
}
