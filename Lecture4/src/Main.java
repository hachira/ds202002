import java.util.Scanner;

public class Main {
	//	1부터 n까지의 숫자중 소수인 숫자의 개수를 반환한다.
	static int pi(int n) {
		//	소수인 숫자를 세기위한 변수를 선언하고 0으로 초기화한다.
		int pcount = 0;
		for(int p = 1; p <= n; p++) {
			//	p가 소수이면 pcount를 1 증가시키도록 합니다.
			//	p가 5로 나뉘는가를 알아내는 것은 나머지 연산자(%)를 사용합니다.
			//	p%5 는 p를 5로 나누었을 때 나머지를 반환하는 연산자입니다.
			//	나머지가 0이라면 p는 5로 나누어 떨어지는 수라고 합니다.
			//	if(p%5 == 0) --> 이 뜻은 p는 5로 나누어 떨어지는가를 뜻하게 됩니다.
			//	약수의 개수를 저장할 변수 dcount를 선언하고 0으로 초기화합니다.
			int dcount = 0;
			//	d를 1부터 p까지 반복해서, p가 d로 나누어 떨어진다면, 약수의 개수를 1 증가시킨다.
			for(int d = 1; d <= p; d++) {
				if(p%d == 0) dcount++;
			}
			//	약수의 개수가 2라면, 소수이므로 소수 개수를 증가시킵니다.
			if(dcount == 2) pcount++;
		}
		//	여기서 return 명령어를 이용해서 소수의 개수를 반환합니다.
		return pcount;
	}
	static int pi1(int n) {
		int pcount = 0;
		for(int p = 2; p <= n; p++) {
			//	소수인가 여부를 isPrime 변수에 저장하고, for 루프를 돌기전에 true로 초기화합니다.
			boolean isPrime = true;
			//	1과 자기자신의 숫자가 아닌 숫자로 나뉠경우에는 소수가 아니게 되므로,
			//	그런 경우에는 빠져나오도록 합니다.
			for(int d = 2; d < p; d++) {
				//	p가 d로 나누어떨어지면, 소수가 아니므로 isPrime을 false로 설정하고
				//	break문을 통해 for루프를 빠져나옵니다.
				if(p%d == 0) {
					isPrime = false;
					break;
				}
			}
			//	소수라면(isPrime == true) 소수의 개수를 증가시킵니다.
			if(isPrime) pcount++;
		}
		return pcount;
	}
	static int pi2(int n) {
		//	n이 2보다 작으면 소수의 개수는 0
		if(n<2) return 0;
		//	n이 2라면 소수의 개수는 1
		if(n==2) return 1;
		//	n이 2보다 크다면, 소수의개수는 1 + 홀수 소수의 개수
		int pcount = 1;
		//	p는 3이상 홀수만 검사하도록 합니다.
		for(int p = 3; p <= n; p+=2) {
			//	소수인가 여부를 isPrime 변수에 저장하고, for 루프를 돌기전에 true로 초기화합니다.
			boolean isPrime = true;
			//	1과 자기자신의 숫자가 아닌 숫자로 나뉠경우에는 소수가 아니게 되므로,
			//	그런 경우에는 빠져나오도록 합니다.
			//	나누어지는지 검사는 최대 sqrt(p)까지만 하면 되므로, 소수인 경우 소수보다 작은 수 모두를
			//	할 필요가 없습니다.
			for(int d = 3; d*d <= p; d+=2) {
				//	p가 d로 나누어떨어지면, 소수가 아니므로 isPrime을 false로 설정하고
				//	break문을 통해 for루프를 빠져나옵니다.
				if(p%d == 0) {
					isPrime = false;
					break;
				}
			}
			//	소수라면(isPrime == true) 소수의 개수를 증가시킵니다.
			if(isPrime) pcount++;
		}
		return pcount;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("소수의 개수를 구할 숫자를 입력하세요 : ");
		int n = scan.nextInt();
		
		long t1 = System.currentTimeMillis();
		System.out.println("pi("+n+")="+pi2(n));
		long t2 = System.currentTimeMillis();
		System.out.println("Elasped time is "+(t2-t1)+"ms.");
	}
}
