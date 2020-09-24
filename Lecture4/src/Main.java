import java.util.Scanner;

public class Main {
	//	1���� n������ ������ �Ҽ��� ������ ������ ��ȯ�Ѵ�.
	static int pi(int n) {
		//	�Ҽ��� ���ڸ� �������� ������ �����ϰ� 0���� �ʱ�ȭ�Ѵ�.
		int pcount = 0;
		for(int p = 1; p <= n; p++) {
			//	p�� �Ҽ��̸� pcount�� 1 ������Ű���� �մϴ�.
			//	p�� 5�� �����°��� �˾Ƴ��� ���� ������ ������(%)�� ����մϴ�.
			//	p%5 �� p�� 5�� �������� �� �������� ��ȯ�ϴ� �������Դϴ�.
			//	�������� 0�̶�� p�� 5�� ������ �������� ����� �մϴ�.
			//	if(p%5 == 0) --> �� ���� p�� 5�� ������ �������°��� ���ϰ� �˴ϴ�.
			//	����� ������ ������ ���� dcount�� �����ϰ� 0���� �ʱ�ȭ�մϴ�.
			int dcount = 0;
			//	d�� 1���� p���� �ݺ��ؼ�, p�� d�� ������ �������ٸ�, ����� ������ 1 ������Ų��.
			for(int d = 1; d <= p; d++) {
				if(p%d == 0) dcount++;
			}
			//	����� ������ 2���, �Ҽ��̹Ƿ� �Ҽ� ������ ������ŵ�ϴ�.
			if(dcount == 2) pcount++;
		}
		//	���⼭ return ��ɾ �̿��ؼ� �Ҽ��� ������ ��ȯ�մϴ�.
		return pcount;
	}
	static int pi1(int n) {
		int pcount = 0;
		for(int p = 2; p <= n; p++) {
			//	�Ҽ��ΰ� ���θ� isPrime ������ �����ϰ�, for ������ �������� true�� �ʱ�ȭ�մϴ�.
			boolean isPrime = true;
			//	1�� �ڱ��ڽ��� ���ڰ� �ƴ� ���ڷ� ������쿡�� �Ҽ��� �ƴϰ� �ǹǷ�,
			//	�׷� ��쿡�� ������������ �մϴ�.
			for(int d = 2; d < p; d++) {
				//	p�� d�� �����������, �Ҽ��� �ƴϹǷ� isPrime�� false�� �����ϰ�
				//	break���� ���� for������ �������ɴϴ�.
				if(p%d == 0) {
					isPrime = false;
					break;
				}
			}
			//	�Ҽ����(isPrime == true) �Ҽ��� ������ ������ŵ�ϴ�.
			if(isPrime) pcount++;
		}
		return pcount;
	}
	static int pi2(int n) {
		//	n�� 2���� ������ �Ҽ��� ������ 0
		if(n<2) return 0;
		//	n�� 2��� �Ҽ��� ������ 1
		if(n==2) return 1;
		//	n�� 2���� ũ�ٸ�, �Ҽ��ǰ����� 1 + Ȧ�� �Ҽ��� ����
		int pcount = 1;
		//	p�� 3�̻� Ȧ���� �˻��ϵ��� �մϴ�.
		for(int p = 3; p <= n; p+=2) {
			//	�Ҽ��ΰ� ���θ� isPrime ������ �����ϰ�, for ������ �������� true�� �ʱ�ȭ�մϴ�.
			boolean isPrime = true;
			//	1�� �ڱ��ڽ��� ���ڰ� �ƴ� ���ڷ� ������쿡�� �Ҽ��� �ƴϰ� �ǹǷ�,
			//	�׷� ��쿡�� ������������ �մϴ�.
			//	������������ �˻�� �ִ� sqrt(p)������ �ϸ� �ǹǷ�, �Ҽ��� ��� �Ҽ����� ���� �� ��θ�
			//	�� �ʿ䰡 �����ϴ�.
			for(int d = 3; d*d <= p; d+=2) {
				//	p�� d�� �����������, �Ҽ��� �ƴϹǷ� isPrime�� false�� �����ϰ�
				//	break���� ���� for������ �������ɴϴ�.
				if(p%d == 0) {
					isPrime = false;
					break;
				}
			}
			//	�Ҽ����(isPrime == true) �Ҽ��� ������ ������ŵ�ϴ�.
			if(isPrime) pcount++;
		}
		return pcount;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("�Ҽ��� ������ ���� ���ڸ� �Է��ϼ��� : ");
		int n = scan.nextInt();
		
		long t1 = System.currentTimeMillis();
		System.out.println("pi("+n+")="+pi2(n));
		long t2 = System.currentTimeMillis();
		System.out.println("Elasped time is "+(t2-t1)+"ms.");
	}
}
