//	Lecture 14
//	분할정복을 이용하여 히스토그램에서 가장 큰 넓이의 직사강형 넓이 구하기
//	입력
//	처음에 히스토그램의 샘플 갯수 N이 입력됩니다.
//	다음에 각 샘플들의 도수들이 N개 입력됩니다.
//	예를 들어서 { 3, 2, 6, 7 }의 도수를 가지는 4개의 샘플이 있는 히스토그램은
//	4 3 2 6 7
//	로 입력이 주어집니다.
//	이에 대한 답변을 직사각형의 넓이를 출력하면 됩니다.
//	12
import java.util.Scanner;
public class Main {
	//	분할정복을 위한 함수
	//	배열 v에서 범위 (a, b) 구간에서 최대 크기의 직사각형 넓이 반환
	static int histo(int[] v, int a, int b) {
		return 0;
	}
	//	히스토그램에서 최대의 직사각형 넓이를 계산해서 출력하는 함수
	//	v : 히스토그램의 샘플들의 도수들의 배열 (0 이상의 자연수)
	//	n : 샘플의 갯수
	static int histo(int[] v, int n) {
		//	v[0..n-1] 구간의 넓이를 구해서 그 값을 반환합니다.
		return histo(v, 0, n-1);
	}
	public static void main(String[] args) {
		//	입력을 위해서 스캐너 오브젝트 생성
		Scanner scan = new Scanner(System.in);
		//	샘플 갯수 N을 입력
		int n = scan.nextInt();
		//	n개의 공간을 갖는 배열을 생성
		int[] v = new int[n];
		//	n개의 배열 공간에 입력된 값을 넣는다.
		for(int i = 0; i < n; i++) {
			v[i] = scan.nextInt();
		}
		//	histo() 함수를 호출해서 그 결과 저장
		int r = histo(v, n);
		//	결과 출력
		System.out.println(r);
	}
}
