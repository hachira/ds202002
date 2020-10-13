import java.util.Scanner;

public class Main {
	//	���������� ���� �Է¹޾Ƽ� ����� ��ȯ�մϴ�.
	static int postCalc(String exp) {
		//	stack�� ���� ���� ����մϴ�.
		int[] stack = new int[1024];
		int top = -1;
		
		//	exp ���ڿ��� �ϳ��� ���ʷ� �н��ϴ�.
		for(int i = 0; i < exp.length(); i++) {
			//	1. ���ڿ��� i��° ���ڸ� �н��ϴ�.
			char ch = exp.charAt(i);
			//	2. ch ���ڰ� ������ ���
			if(ch >= '0' && ch <= '9') {
				//	ch���� ASCII �ڵ尡 ���ֱ� ������,
				//	'0' : 48, '1' : 49, .. '9' : 57
				//	ch - '0' �� ���ϸ�, �ش� ������ ���ڸ� ������ �� �ֽ��ϴ�.
				stack[++top] = ch - '0';
			}
			//	3. ch ���ڰ� �������� ���
			else {
				//	���� ���ÿ� �ִ� ������ ������ 2�� �̸��̸� ����ó���� �մϴ�.
				if(top < 1) {
					System.out.println("Error.");
					return -1;
				}
				//	���ÿ��� �ΰ��� �ǿ����ڸ� �����ɴϴ�.
				int b = stack[top--];
				int a = stack[top--];
				int r = 0;
				if(ch == '+') r = a+b;
				else if(ch == '-') r = a-b;
				else if(ch == '*') r = a*b;
				else if(ch == '/') r = a/b;
				//	����� ����� ���ÿ� push�մϴ�.
				stack[++top] = r;
			}
		}
		//	���� ���ÿ��� 1���� �����͸� �־�� �մϴ�.  �׷��� �ʴٸ� ����.
		if(top != 0) {
			System.out.println("Error.");
			return -2;
		}
		
		return stack[0];
	}

	public static void main(String[] args) {
		//	Scanner ������Ʈ�� ����
		Scanner scan = new Scanner(System.in);
		
		//	������ �о�ɴϴ�.
		System.out.print("Enter the expression : ");
		String exp = scan.next();
		
		//	���� ����� ����մϴ�.
		System.out.println(exp + " = " + postCalc(exp));
	}

}
