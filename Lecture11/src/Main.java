//	lecture 11 : 기본 정렬 프로그램 작성하기
import java.util.Random;
import java.util.Scanner;
public class Main {
	//	배열 v, 크기 n인 정렬 함수를 작성합니다.(선택정렬)
	static void sort(int[] v, int n) {
		//	1. v[0]부터 v[n-2]까지에 대하여
		for(int i = 0; i < n-1; i++) {
			//	2. v[i] ~ v[n-1] 배열값중 가장 작은 값을 찾습니다.
			//	일단 최소값은 v[i]라고 설정을 합니다.
			int min = i;
			for(int j = i+1; j < n; j++) {
				//	v[min] 값보다 v[j] 값이 작다면, min을 j로 바꿉니다.
				if(v[j] < v[min]) min = j;
			}
			//	3. v[i] 값과 v[min] 값을 서로 맞바꿉니다.
			int t = v[i];
			v[i] = v[min];
			v[min] = t;
		}
	}
	//	배열 v, 크기 n인 정렬 함수를 작성합니다.  (삽입정렬)
	static void insertionSort(int[] v, int n) {
		//	1. v[1] 부터 v[n-1]까지에 대해서
		for(int i=1; i < n; i++) {
			//	2. v[i] 데이터를 v[0]~v[i-1]의 적당한 곳에 끼어넣기 합니다.
			//	2-1. 끼어넣기할 값을 임시 변수에 복사를 합니다.
			int r = v[i];
			//	2-2. 끼어넣을 공간을 변수로 선언합니다.
			int last = i;
			//	2-3. last > 0 이고, v[last-1] > r을 만족하는한,
			//	v[last-1]을 v[last]로 복사하고, last값을 감소시켜나갑니다.
			while(last > 0 && v[last-1] > r) {
				v[last] = v[last-1];
				last--;
			}
			//	2-4. v[last] 에 r 값을 복사합니다.
			v[last] = r;
		}
	}
	public static void main(String[] args) {
		//	정렬할 값을 무작위값으로 채우기 위해서 Random 오브젝트를 생성
		Random rand = new Random(100);
		//	배열의 크기를 키보드로부터 입력 받습니다.
		Scanner scan = new Scanner(System.in);
		System.out.print("Input n : ");
		int n = scan.nextInt();
		//	데이터를 담고 있을 배열을 생성합니다.
		int[] v = new int[n];
		//	배열에 데이터를 무작위값으로 채웁니다.
		for(int i=0;i<n;i++) {
			v[i] = rand.nextInt(100000);
		}
		long t = System.currentTimeMillis();
		//	정렬을 합니다.
		insertionSort(v, n);
		//	정렬하는데 걸린 시간을 측정합니다.
		t = System.currentTimeMillis() - t;
		//	정렬 결과를 확인합니다.
		for(int i = 0; i<100; i++) {
			System.out.print(v[i]+" ");
		}
		System.out.println("");
		System.out.println("elapsed time : "+t+"ms");
	}

}
