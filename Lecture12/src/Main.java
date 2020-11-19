//	Lecture 12. Merge sort
//	합병정렬은 분할정복을 제일 잘 적용한 대표적인 알고리즘입니다.
import java.util.Scanner;			//	입력을 받기 위한 모듈
import java.util.Random;			//	랜덤 수를 생성하기 위한 모듈
public class Main {
	static int[] tv;				//	임시로 합병정렬 결과를 저장한 배열공간
	//	배열 v에 대해서 [a, c] 구간과 [c+1, b] 구간에 대해 정렬한 결과를 합칩니다.
	static void merge(int[] v, int a, int b, int c) {
		//	1. 변수를 세개를 지정합니다.  [a, c]구간에서 인덱스를 가르킬 변수와,
		//	[c+1, b]구간에서 인덱스를 가르킬 변수로.
		//	저장할 공간에 들어갈 인덱스 변수도.
		int i = a, j = c+1, k = a;
		
		//	2. 두개의 인덱스 변수가 가르키는 배열값을 비교하면서,
		//	작은값을 임시 저장공간에 저장합니다.
		while(i<=c && j <= b) {
			if(v[i] < v[j]) tv[k++] = v[i++];
			else tv[k++] = v[j++];
		}
		
		//	3. 남은 짜투리 값들을 임시 저장공간에 저장합니다.
		while(i<=c) tv[k++] = v[i++];
		while(j<=b) tv[k++] = v[j++];
		
		//	4. 임시저장공간의 데이터를 v 배열에 복사합니다.
		for(i=a;i<=b;i++) v[i] = tv[i];
	}
	//	선택정렬
	//	배열 v에 대해서 [a, b] 구간을 정렬합니다.
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
	
	//	합병정렬
	//	배열 v에 대해서 [a, b] 구간을 정렬합니다.
	static void mergeSort(int[] v, int a, int b) {
		//	0. 정렬할 데이터가 1개 이하이면, 정렬이 필요없으므로 수행하지 않도록 합니다.
		if(a >= b) return;
		//	1. 중간 지점을 구합니다.
		int c = (a+b)/2;
		//	2. [a, c] 구간과 [c+1, b] 구간을 각각 정렬합니다.
		mergeSort(v, a, c);
		mergeSort(v, c+1, b);
		//	3. [a, c] 구간과 [c+1, b] 구간을 정렬한 것을 합칩니다.
		merge(v, a, b, c);
	}

	public static void main(String[] args) {
		//	정렬할 배열의 크기를 얻어옵니다.
		Scanner scan = new Scanner(System.in);
		System.out.print("정렬할 배열의 크기 입력 : ");
		int n = scan.nextInt();
		
		//	랜덤 수를 생성하기 위한 Random 오브젝트를 생성합니다.
		Random rand = new Random(1000);
		
		//	대조군과 실험군을 테스트할 배열을 생성합니다.
		int[] v1 = new int[n];
		int[] v2 = new int[n];
		
		//	합병정렬에서 사용할 임시 배열 공간 할당
		tv = new int[n];
		
		//	랜덤함수를 통해서 대조군과 실험군의 배열을 채웁니다.
		for(int i=0; i < n; i++ ) {
			v1[i] = v2[i] = rand.nextInt();
		}
		
		//	대조군 정렬 시간을 계산합니다.
		long t1 = System.currentTimeMillis();
		selectionSort(v1, 0, n-1);
		t1 = System.currentTimeMillis() - t1;
		
		//	실험군 정렬 시간을 계산합니다.
		long t2 = System.currentTimeMillis();
		mergeSort(v2, 0, n-1);
		t2 = System.currentTimeMillis() - t2;
		
		System.out.println("선택정렬 : "+t1+"ms, 병합정렬 : "+t2+"ms");
		
		//	두 정렬 결과가 동일한지 검사합니다.
		boolean isValid = true;
		for(int i = 0; i < n; i++) {
			if(v1[i] != v2[i]) {
				isValid = false;
				break;
			}
		}
		System.out.println(isValid?"올바르게 동작":"잘못된 동작");
	}

}
