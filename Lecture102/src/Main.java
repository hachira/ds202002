import java.util.Scanner;
///	�似Ǫ�� ���� Ǯ��
public class Main {
	//	n, k�� �Է����� �似Ǫ�� ������ ����ϴ� ���α׷��� �ۼ��մϴ�.
	static void Josepus(int n, int k) {
		//	Queue�� ������ int �迭�� �����մϴ�.
		int[] queue = new int[n*2];
		//	Queue�� ���ۺκ�(front)�� ���κ�(tail)�� ���� ������ �����մϴ�.
		int head=0, tail=0;
		//	���� �ڷᱸ���� �̿��ϸ�, ������ ���� ���α׷������ν�, ť Ŭ������ �ۼ����� �ʰ� �� �� �ֽ��ϴ�.
		//	add)
		//	queue[tail] = v;  tail = (tail+1)%(n*2);
		//	remove)
		//	head = (head+1)%(n*2);
		//	peek)
		//	queue[head]
		//	empty)
		//	head == tail ?
		
		//	1. 1..n�� �����͸� ť�� �ֽ��ϴ�.
		for(int i = 1; i<=n; i++) {
			queue[tail] = i;
			tail = (tail+1)%(n*2);
		}
		
		int count = 0;
		//	2. ť�� �� ������ �۾��� �����մϴ�.
		while( head != tail ) {
			//	2-1. k-1 �� �����͸� ����, �ٽ� ť�� �ֽ��ϴ�.
			for( int i = 1; i <= k-1; i++ ) {
				int tmp = queue[head];			//	PEEK
				head = (head+1)%(n*2);			//	REMOVE
				queue[tail] = tmp;				//	ADD
				tail = (tail+1)%(n*2);
				count++;
			}
			//	2-2. ������ �ϳ��� ���� ����� �մϴ�.
			int v = queue[head];				//	PEEK
			head = (head+1)%(n*2);				//	REMOVE
			System.out.println(v);
			count++;
		}
		System.out.println("count = "+count);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("n�� �Է��ϼ��� : ");
		int n = scan.nextInt();
		System.out.print("k�� �Է��ϼ��� : ");
		int k = scan.nextInt();
		Josepus(n, k);
	}
}
