import java.util.Scanner;

public class Main {
	//	후위연산자 식을 입력받아서 결과를 반환합니다.
	static int postCalc(String exp) {
		//	stack은 직접 만들어서 사용합니다.
		int[] stack = new int[1024];
		int top = -1;
		
		//	exp 문자열을 하나씩 차례로 읽습니다.
		for(int i = 0; i < exp.length(); i++) {
			//	1. 문자열중 i번째 문자를 읽습니다.
			char ch = exp.charAt(i);
			//	2. ch 문자가 숫자인 경우
			if(ch >= '0' && ch <= '9') {
				//	ch에는 ASCII 코드가 들어가있기 때문에,
				//	'0' : 48, '1' : 49, .. '9' : 57
				//	ch - '0' 을 통하면, 해당 문자의 숫자를 가져올 수 있습니다.
				stack[++top] = ch - '0';
			}
			//	3. ch 문자가 연산자인 경우
			else {
				//	현재 스택에 있는 아이템 갯수가 2개 미만이면 에러처리를 합니다.
				if(top < 1) {
					System.out.println("Error.");
					return -1;
				}
				//	스택에서 두가의 피연산자를 가져옵니다.
				int b = stack[top--];
				int a = stack[top--];
				int r = 0;
				if(ch == '+') r = a+b;
				else if(ch == '-') r = a-b;
				else if(ch == '*') r = a*b;
				else if(ch == '/') r = a/b;
				//	연산된 결과를 스택에 push합니다.
				stack[++top] = r;
			}
		}
		//	현재 스택에는 1개의 데이터만 있어야 합니다.  그렇지 않다면 에러.
		if(top != 0) {
			System.out.println("Error.");
			return -2;
		}
		
		return stack[0];
	}

	public static void main(String[] args) {
		//	Scanner 오브젝트를 생성
		Scanner scan = new Scanner(System.in);
		
		//	수식을 읽어옵니다.
		System.out.print("Enter the expression : ");
		String exp = scan.next();
		
		//	연산 결과를 출력합니다.
		System.out.println(exp + " = " + postCalc(exp));
	}

}
