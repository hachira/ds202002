import java.util.Scanner;
public class Main {
	//	1���� n���� ���ϴ� �Լ�
	static long sum(int n) {
		long s = 0;
		for(int i=1;i<=n;i++) {
			s += i;		//	s = s + i;
		}
		return s;
	}
	//	1���� n���� ���ϴ� �Լ�(��������)
	static long sum1(int n) {
		long s = n;
		return s*(s+1)/2;
	}
	public static void main(String[] args) {
		//	Ű���� �Է��� �ޱ����ؼ� Scanner ������Ʈ ����
		Scanner scan = new Scanner(System.in);

		//	�����ϴ� �� �ٱ����� �Է��� �޵��� �մϴ�.
		System.out.print("1���� ���ϰ��� �ϴ� ���ڸ� �Է��ϼ��� : ");
		int n = scan.nextInt();
		
		//	System.currentTimeMillis() �Լ��� ���α׷��� �����ϸ鼭
		//	�ð��� ������ִ� �Լ��Դϴ�.
		//	Ư����¥�� �ð��� 0���� �����ؼ� ������ �ð��� ms(milli seconds)��
		//	��Ÿ���ϴ�.
		//	���α׷� ����� �����ϱ� ���� ����ð��� ����մϴ�.
		long t = System.currentTimeMillis();
		
		System.out.println("Sum from 1 to "+n+" is "+sum1(n)+".");
		
		//	���α׷� ����� ������ ���� ����ð��� ����մϴ�.
		long f = System.currentTimeMillis();
		//	������ �ð����� ������ �ð��� ���� ����ð��� ������, �̸� ����մϴ�.
		System.out.println("Elapsed time is "+(f-t)+"ms.");
	}
}
