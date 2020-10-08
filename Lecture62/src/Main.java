import java.util.Scanner;

public class Main {
	//	문자열 쌍이 올바르면 true를 반환 그렇지않으면 false를 반환합니다.
	public static boolean isValid(String pp) {
		//	스택을 간단 버전으로 구현합니다.
		char[] stack = new char[1024];
		int top = -1;
		
		//	모든 글자들을 돌아다니면서, 스택과 처리를 합니다.
		for(int i=0;i<pp.length();i++) {
			//	1. 문자를 하나 읽습니다.
			char ch = pp.charAt(i);
			//	2. 해당 문자가 괄호 열기에 해당한다면, 스택에 해당 문자를 넣습니다.
			if(ch == '(' || ch == '{' || ch == '[') {
				//	top++;
				//	stack[top] = ch;
				stack[++top] = ch;
			}
			//	3. 해당 문자가 괄호 닫기에 해당한다면, 스택에 가장 위의 것과 비교합니다.
			else if(ch == ')') {
				//	만약 스택이 비어있거나(top = -1),
				//	스택의 최상위 아이템이 괄호 열기가 아니라면 false를 반환
				if(top == -1 || stack[top] != '(') return false;
				//	pop을 수행합니다.  이미 스택 비어있는지 검사는 위에서 했기때문에
				top--;
			}
			else if(ch == '}') {
				//	만약 스택이 비어있거나(top = -1),
				//	스택의 최상위 아이템이 괄호 열기가 아니라면 false를 반환
				if(top == -1 || stack[top] != '{') return false;
				//	pop을 수행합니다.  이미 스택 비어있는지 검사는 위에서 했기때문에
				top--;
			}
			else if(ch == ']') {
				//	만약 스택이 비어있거나(top = -1),
				//	스택의 최상위 아이템이 괄호 열기가 아니라면 false를 반환
				if(top == -1 || stack[top] != '[') return false;
				//	pop을 수행합니다.  이미 스택 비어있는지 검사는 위에서 했기때문에
				top--;
			}
		}
		//	모든 문자를 다 처리하고 나서 스택이 비어있다면, true, 아니면 false 반환
		return top == -1;
	}
	public static void main(String[] args) {
		//	ToDo : 스택을 구현하고, 괄호쌍 검사를 받아서 처리하도록 합니다.
		Scanner scan = new Scanner(System.in);
		//	문자열의 갯수를 입력받습니다.
		int n = scan.nextInt();
		
		//	for루프를 돌면서 괄호쌍입력을 받고 결과를 출력합니다.
		for(int i = 1; i <= n; i++) {
			//	괄호쌍 입력을 받습니다.
			String pp = scan.next();
			
			//	isValid()가 참이면 YES를 거짓이면 NO를 출력하게 한다.
			if(isValid(pp)) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
