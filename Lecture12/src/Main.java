//	Lecture 12. Merge sort
//	�պ������� ���������� ���� �� ������ ��ǥ���� �˰����Դϴ�.
import java.util.Scanner;			//	�Է��� �ޱ� ���� ���
import java.util.Random;			//	���� ���� �����ϱ� ���� ���
public class Main {
	static int[] tv;				//	�ӽ÷� �պ����� ����� ������ �迭����
	//	�迭 v�� ���ؼ� [a, c] ������ [c+1, b] ������ ���� ������ ����� ��Ĩ�ϴ�.
	static void merge(int[] v, int a, int b, int c) {
		//	1. ������ ������ �����մϴ�.  [a, c]�������� �ε����� ����ų ������,
		//	[c+1, b]�������� �ε����� ����ų ������.
		//	������ ������ �� �ε��� ������.
		int i = a, j = c+1, k = a;
		
		//	2. �ΰ��� �ε��� ������ ����Ű�� �迭���� ���ϸ鼭,
		//	�������� �ӽ� ��������� �����մϴ�.
		while(i<=c && j <= b) {
			if(v[i] < v[j]) tv[k++] = v[i++];
			else tv[k++] = v[j++];
		}
		
		//	3. ���� ¥���� ������ �ӽ� ��������� �����մϴ�.
		while(i<=c) tv[k++] = v[i++];
		while(j<=b) tv[k++] = v[j++];
		
		//	4. �ӽ���������� �����͸� v �迭�� �����մϴ�.
		for(i=a;i<=b;i++) v[i] = tv[i];
	}
	//	��������
	//	�迭 v�� ���ؼ� [a, b] ������ �����մϴ�.
	static void selectionSort(int[] v, int a, int b) {
		for(int i = a; i < b; i++) {
			int min = i;
			for(int j=i+1; j <= b; j++) {
				if(v[min] > v[j]) min = j;
			}
			int t = v[i];
			v[i] = v[min];
			v[min] = t;
		}
	}
	
	//	�պ�����
	//	�迭 v�� ���ؼ� [a, b] ������ �����մϴ�.
	static void mergeSort(int[] v, int a, int b) {
		//	0. ������ �����Ͱ� 1�� �����̸�, ������ �ʿ�����Ƿ� �������� �ʵ��� �մϴ�.
		if(a >= b) return;
		//	1. �߰� ������ ���մϴ�.
		int c = (a+b)/2;
		//	2. [a, c] ������ [c+1, b] ������ ���� �����մϴ�.
		mergeSort(v, a, c);
		mergeSort(v, c+1, b);
		//	3. [a, c] ������ [c+1, b] ������ ������ ���� ��Ĩ�ϴ�.
		merge(v, a, b, c);
	}

	public static void main(String[] args) {
		//	������ �迭�� ũ�⸦ ���ɴϴ�.
		Scanner scan = new Scanner(System.in);
		System.out.print("������ �迭�� ũ�� �Է� : ");
		int n = scan.nextInt();
		
		//	���� ���� �����ϱ� ���� Random ������Ʈ�� �����մϴ�.
		Random rand = new Random(1000);
		
		//	�������� ���豺�� �׽�Ʈ�� �迭�� �����մϴ�.
		int[] v1 = new int[n];
		int[] v2 = new int[n];
		
		//	�պ����Ŀ��� ����� �ӽ� �迭 ���� �Ҵ�
		tv = new int[n];
		
		//	�����Լ��� ���ؼ� �������� ���豺�� �迭�� ä��ϴ�.
		for(int i=0; i < n; i++ ) {
			v1[i] = v2[i] = rand.nextInt();
		}
		
		//	������ ���� �ð��� ����մϴ�.
		long t1 = System.currentTimeMillis();
		selectionSort(v1, 0, n-1);
		t1 = System.currentTimeMillis() - t1;
		
		//	���豺 ���� �ð��� ����մϴ�.
		long t2 = System.currentTimeMillis();
		mergeSort(v2, 0, n-1);
		t2 = System.currentTimeMillis() - t2;
		
		System.out.println("�������� : "+t1+"ms, �������� : "+t2+"ms");
		
		//	�� ���� ����� �������� �˻��մϴ�.
		boolean isValid = true;
		for(int i = 0; i < n; i++) {
			if(v1[i] != v2[i]) {
				isValid = false;
				break;
			}
		}
		System.out.println(isValid?"�ùٸ��� ����":"�߸��� ����");
	}

}
