//	lecture 11 : �⺻ ���� ���α׷� �ۼ��ϱ�
import java.util.Random;
import java.util.Scanner;
public class Main {
	//	�迭 v, ũ�� n�� ���� �Լ��� �ۼ��մϴ�.(��������)
	static void sort(int[] v, int n) {
		//	1. v[0]���� v[n-2]������ ���Ͽ�
		for(int i = 0; i < n-1; i++) {
			//	2. v[i] ~ v[n-1] �迭���� ���� ���� ���� ã���ϴ�.
			//	�ϴ� �ּҰ��� v[i]��� ������ �մϴ�.
			int min = i;
			for(int j = i+1; j < n; j++) {
				//	v[min] ������ v[j] ���� �۴ٸ�, min�� j�� �ٲߴϴ�.
				if(v[j] < v[min]) min = j;
			}
			//	3. v[i] ���� v[min] ���� ���� �¹ٲߴϴ�.
			int t = v[i];
			v[i] = v[min];
			v[min] = t;
		}
	}
	//	�迭 v, ũ�� n�� ���� �Լ��� �ۼ��մϴ�.  (��������)
	static void insertionSort(int[] v, int n) {
		//	1. v[1] ���� v[n-1]������ ���ؼ�
		for(int i=1; i < n; i++) {
			//	2. v[i] �����͸� v[0]~v[i-1]�� ������ ���� ����ֱ� �մϴ�.
			//	2-1. ����ֱ��� ���� �ӽ� ������ ���縦 �մϴ�.
			int r = v[i];
			//	2-2. ������� ������ ������ �����մϴ�.
			int last = i;
			//	2-3. last > 0 �̰�, v[last-1] > r�� �����ϴ���,
			//	v[last-1]�� v[last]�� �����ϰ�, last���� ���ҽ��ѳ����ϴ�.
			while(last > 0 && v[last-1] > r) {
				v[last] = v[last-1];
				last--;
			}
			//	2-4. v[last] �� r ���� �����մϴ�.
			v[last] = r;
		}
	}
	public static void main(String[] args) {
		//	������ ���� ������������ ä��� ���ؼ� Random ������Ʈ�� ����
		Random rand = new Random(100);
		//	�迭�� ũ�⸦ Ű����κ��� �Է� �޽��ϴ�.
		Scanner scan = new Scanner(System.in);
		System.out.print("Input n : ");
		int n = scan.nextInt();
		//	�����͸� ��� ���� �迭�� �����մϴ�.
		int[] v = new int[n];
		//	�迭�� �����͸� ������������ ä��ϴ�.
		for(int i=0;i<n;i++) {
			v[i] = rand.nextInt(100000);
		}
		long t = System.currentTimeMillis();
		//	������ �մϴ�.
		insertionSort(v, n);
		//	�����ϴµ� �ɸ� �ð��� �����մϴ�.
		t = System.currentTimeMillis() - t;
		//	���� ����� Ȯ���մϴ�.
		for(int i = 0; i<100; i++) {
			System.out.print(v[i]+" ");
		}
		System.out.println("");
		System.out.println("elapsed time : "+t+"ms");
	}

}
