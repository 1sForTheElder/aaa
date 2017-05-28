package test;

import java.util.Scanner;

public class duipaixu {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] sort = new int[10];
        inputArr(sort);
        // ���ö����򷽷�
        heapSort(sort);
        System.out.println("����������Ϊ��");
        printArr(sort);
    }

    // ������ʼ
    public static void heapSort(int[] sort) {
        for (int i = 0; i < sort.length; i++) {
            createMaxHeap(sort, sort.length - 1 - i);
            Swap(sort, 0, sort.length - 1 - i);
        }
    }

    // ���������
    public static void createMaxHeap(int[] sort, int lastIndex) {
        // ��lastIndex���ڵ㣨���һ���ڵ㣩�ĸ��ڵ㿪ʼ
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // k���������жϵĽڵ�
            int k = i;
            // �����ǰk�ڵ���ӽڵ����
            while (k * 2 + 1 <= lastIndex) {
                // k�ڵ�����ӽڵ������
                int leftChild = 2 * k + 1;
                // ���leftChildС��lastIndex����leftChild+1�����k�ڵ�����ӽڵ����
                if (leftChild < lastIndex) {
                    // �����ӽڵ��ֵ�ϴ�
                    if (sort[leftChild] < sort[leftChild + 1]) {
                        // leftChild����ָ��ϴ��ӽڵ������
                        leftChild++;
                    }
                }
                // ���k�ڵ��ֵС����ϴ���ӽڵ��ֵ
                if (sort[k] < sort[leftChild]) {
                    // ��������
                    Swap(sort, k, leftChild);
                } 
                else {
                    break;
                }
            }
        }
    }

    // ��������ֵ
    public static void Swap(int[] sort, int i, int j) {
        int temp = sort[i];
        sort[i] = sort[j];
        sort[j] = temp;
    }

    // �Ӽ�����������
    public static void inputArr(int[] sort) {
        Scanner sc = new Scanner(System.in);
        System.out.println("��������������У�");
        for (int i = 0; i < sort.length; i++) {
            sort[i] = sc.nextInt();
        }
    }

    // �������
    public static void printArr(int[] sort) {
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i] + "  ");
        }
        System.out.println();
    }

}