import java.util.Scanner;
public class Main {
	//	1부터 n까지 더하는 함수
	static long sum(int n) {
		long s = 0;
		for(int i=1;i<=n;i++) {
			s += i;		//	s = s + i;
		}
		return s;
	}
	//	1부터 n까지 더하는 함수(개선버전)
	static long sum1(int n) {
		long s = n;
		return s*(s+1)/2;
	}
	public static void main(String[] args) {
		//	키보드 입력을 받기위해서 Scanner 오브젝트 정의
		Scanner scan = new Scanner(System.in);

		//	측정하는 곳 바깥에서 입력을 받도록 합니다.
		System.out.print("1부터 더하고자 하는 숫자를 입력하세요 : ");
		int n = scan.nextInt();
		
		//	System.currentTimeMillis() 함수는 프로그램이 시작하면서
		//	시간을 계산해주는 함수입니다.
		//	특정날짜의 시간을 0으로 시작해서 현재의 시간을 ms(milli seconds)로
		//	나타냅니다.
		//	프로그램 모듈을 실행하기 전의 현재시간을 기록합니다.
		long t = System.currentTimeMillis();
		
		System.out.println("Sum from 1 to "+n+" is "+sum1(n)+".");
		
		//	프로그램 모듈을 실행한 후의 현재시간을 기록합니다.
		long f = System.currentTimeMillis();
		//	실행후 시간에서 실행전 시간을 빼면 경과시간이 나오며, 이를 출력합니다.
		System.out.println("Elapsed time is "+(f-t)+"ms.");
	}
}
