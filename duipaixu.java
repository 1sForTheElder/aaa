package test;

import java.util.Scanner;

public class duipaixu {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] sort = new int[10];
        inputArr(sort);
        // 调用堆排序方法
        heapSort(sort);
        System.out.println("排序后的序列为：");
        printArr(sort);
    }

    // 堆排序开始
    public static void heapSort(int[] sort) {
        for (int i = 0; i < sort.length; i++) {
            createMaxHeap(sort, sort.length - 1 - i);
            Swap(sort, 0, sort.length - 1 - i);
        }
    }

    // 建立大根堆
    public static void createMaxHeap(int[] sort, int lastIndex) {
        // 从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // k保存正在判断的节点
            int k = i;
            // 如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                // k节点的左子节点的索引
                int leftChild = 2 * k + 1;
                // 如果leftChild小于lastIndex，即leftChild+1代表的k节点的右子节点存在
                if (leftChild < lastIndex) {
                    // 若右子节点的值较大
                    if (sort[leftChild] < sort[leftChild + 1]) {
                        // leftChild总是指向较大子节点的索引
                        leftChild++;
                    }
                }
                // 如果k节点的值小于其较大的子节点的值
                if (sort[k] < sort[leftChild]) {
                    // 交换他们
                    Swap(sort, k, leftChild);
                } 
                else {
                    break;
                }
            }
        }
    }

    // 交换两个值
    public static void Swap(int[] sort, int i, int j) {
        int temp = sort[i];
        sort[i] = sort[j];
        sort[j] = temp;
    }

    // 从键盘输入数据
    public static void inputArr(int[] sort) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入待排序序列：");
        for (int i = 0; i < sort.length; i++) {
            sort[i] = sc.nextInt();
        }
    }

    // 输出数组
    public static void printArr(int[] sort) {
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i] + "  ");
        }
        System.out.println();
    }

}