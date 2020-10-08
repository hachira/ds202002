import java.util.Scanner;

public class Main {
	//	���ڿ� ���� �ùٸ��� true�� ��ȯ �׷��������� false�� ��ȯ�մϴ�.
	public static boolean isValid(String pp) {
		//	������ ���� �������� �����մϴ�.
		char[] stack = new char[1024];
		int top = -1;
		
		//	��� ���ڵ��� ���ƴٴϸ鼭, ���ð� ó���� �մϴ�.
		for(int i=0;i<pp.length();i++) {
			//	1. ���ڸ� �ϳ� �н��ϴ�.
			char ch = pp.charAt(i);
			//	2. �ش� ���ڰ� ��ȣ ���⿡ �ش��Ѵٸ�, ���ÿ� �ش� ���ڸ� �ֽ��ϴ�.
			if(ch == '(' || ch == '{' || ch == '[') {
				//	top++;
				//	stack[top] = ch;
				stack[++top] = ch;
			}
			//	3. �ش� ���ڰ� ��ȣ �ݱ⿡ �ش��Ѵٸ�, ���ÿ� ���� ���� �Ͱ� ���մϴ�.
			else if(ch == ')') {
				//	���� ������ ����ְų�(top = -1),
				//	������ �ֻ��� �������� ��ȣ ���Ⱑ �ƴ϶�� false�� ��ȯ
				if(top == -1 || stack[top] != '(') return false;
				//	pop�� �����մϴ�.  �̹� ���� ����ִ��� �˻�� ������ �߱⶧����
				top--;
			}
			else if(ch == '}') {
				//	���� ������ ����ְų�(top = -1),
				//	������ �ֻ��� �������� ��ȣ ���Ⱑ �ƴ϶�� false�� ��ȯ
				if(top == -1 || stack[top] != '{') return false;
				//	pop�� �����մϴ�.  �̹� ���� ����ִ��� �˻�� ������ �߱⶧����
				top--;
			}
			else if(ch == ']') {
				//	���� ������ ����ְų�(top = -1),
				//	������ �ֻ��� �������� ��ȣ ���Ⱑ �ƴ϶�� false�� ��ȯ
				if(top == -1 || stack[top] != '[') return false;
				//	pop�� �����մϴ�.  �̹� ���� ����ִ��� �˻�� ������ �߱⶧����
				top--;
			}
		}
		//	��� ���ڸ� �� ó���ϰ� ���� ������ ����ִٸ�, true, �ƴϸ� false ��ȯ
		return top == -1;
	}
	public static void main(String[] args) {
		//	ToDo : ������ �����ϰ�, ��ȣ�� �˻縦 �޾Ƽ� ó���ϵ��� �մϴ�.
		Scanner scan = new Scanner(System.in);
		//	���ڿ��� ������ �Է¹޽��ϴ�.
		int n = scan.nextInt();
		
		//	for������ ���鼭 ��ȣ���Է��� �ް� ����� ����մϴ�.
		for(int i = 1; i <= n; i++) {
			//	��ȣ�� �Է��� �޽��ϴ�.
			String pp = scan.next();
			
			//	isValid()�� ���̸� YES�� �����̸� NO�� ����ϰ� �Ѵ�.
			if(isValid(pp)) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
