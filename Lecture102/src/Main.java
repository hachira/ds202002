import java.util.Scanner;
///	요세푸스 문제 풀이
public class Main {
	//	n, k를 입력으로 요세푸스 수열을 출력하는 프로그램을 작성합니다.
	static void Josepus(int n, int k) {
		//	Queue를 저장할 int 배열을 선언합니다.
		int[] queue = new int[n*2];
		//	Queue의 시작부분(front)과 끝부분(tail)을 위한 변수를 선언합니다.
		int head=0, tail=0;
		//	위의 자료구조를 이용하면, 다음과 같이 프로그램함으로써, 큐 클래스를 작성하지 않고 할 수 있습니다.
		//	add)
		//	queue[tail] = v;  tail = (tail+1)%(n*2);
		//	remove)
		//	head = (head+1)%(n*2);
		//	peek)
		//	queue[head]
		//	empty)
		//	head == tail ?
		
		//	1. 1..n의 데이터를 큐에 넣습니다.
		for(int i = 1; i<=n; i++) {
			queue[tail] = i;
			tail = (tail+1)%(n*2);
		}
		
		int count = 0;
		//	2. 큐가 빌 때까지 작업을 수행합니다.
		while( head != tail ) {
			//	2-1. k-1 번 데이터를 빼고, 다시 큐에 넣습니다.
			for( int i = 1; i <= k-1; i++ ) {
				int tmp = queue[head];			//	PEEK
				head = (head+1)%(n*2);			//	REMOVE
				queue[tail] = tmp;				//	ADD
				tail = (tail+1)%(n*2);
				count++;
			}
			//	2-2. 데이터 하나를 빼서 출력을 합니다.
			int v = queue[head];				//	PEEK
			head = (head+1)%(n*2);				//	REMOVE
			System.out.println(v);
			count++;
		}
		System.out.println("count = "+count);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("n을 입력하세요 : ");
		int n = scan.nextInt();
		System.out.print("k를 입력하세요 : ");
		int k = scan.nextInt();
		Josepus(n, k);
	}
}
