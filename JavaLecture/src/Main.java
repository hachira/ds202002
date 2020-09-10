import java.util.Scanner;

//	public은 공개되어있다는 의미로 이 파일 이외에서 해당 클래스를 사용할 수 있음을 의미
//	아무것도 붙이지 않으면 자동으로 private가 선언된 것으로 본다.
//	pirvate가 붙어있으면 외부 파일에서 해당 클래스를 사용할 수 없다.
//	class Main 은 Main이라는 클래스를 의미한다.
//	Main 클래스는 인간사회에서 보면 "학생"이라는 집합체를 규정하는 명칭이라고 보면 좋다.
public class Main {
	//	main 함수는 자바 프로젝트 실행하면 가장 먼저 실행되는 함수이다.
	//	static 이 붙은 경우에는 클래스 오브젝트와 상관없이 실행하거나 참조할 수 있음을 의미한다.
	public static void main(String[] args) {
		//	출력은 System.out.println(....)을 사용한다.
		//	줄바꿈이 필요없는 경우에는 System.out.print(....)을 사용한다.
		System.out.println("줄바꿈을 합니다.");
		System.out.print("줄바꿈을 안할거예요.");
		System.out.println("이줄은 앞에 쓴 내용과 붙어서 나올겁니다.");
		//	문자열 더하기(+)는 당신과 같이 이루어집니다.
		//	문자열+문자열도 가능하지만, 문자열+숫자 등 다양한 형태가 가능합니다.
		System.out.println("나의 나이는 "+"20살입니다.");
		System.out.println("당신의 나이는 "+20+"살입니까?");
		//	변수의 사용
		//	변수라는 것은 바뀌는 내용이 있는 것을 자바의 저장소에 저장하는 것을 의미하고,
		//	그 저장소에 이름을 붙여서 변수라고 합니다.
		//	변수는 <변수의 타입> <변수의 이름>; 형태로 정의합니다.
		//	변수의 타입 : int, long, float, double, char, String...
		int age;
		//	변수에 값을 저장할 때에는 <변수명> = <저장할 값>; 형태로 합니다.
		age = 20;
		System.out.println("나의 나이 : "+age);
		//	사용자 입력을 자바에서 처리하기 위해서는 좀 어렵습니다.
		//	간단한 프로그램 작성할 때 입력하는 방법을 패턴으로 이해하는 것이 필요합니다.
		Scanner scan = new Scanner(System.in);
		System.out.print("당신의 나이는 ? ");
		age = scan.nextInt();
		System.out.println("나의 나이는 "+age+"살입니다.");
		//	조건문은 if라는 것이 있습니다. 
		//	if - else if - else 형태로 이루어집니다.
		//	if(조건) ... 하면, 조건이 "참"인 경우 ...이 실행됩니다.
		//	else ...는 if 조건이 "거짓"인 경우 ...이 실행됩니다. 
		if(age <= 7) {
			System.out.print(""+age+" : ");
			System.out.println("저는 어린이입니다.");
		}
		else if(age <= 19) {
			System.out.print(""+age+" : ");
			System.out.println("저는 청소년입니다.");
		}
		else {
			System.out.print(""+age+" : ");
			System.out.println("저 다 컸어요.");
		}
		//	반복문은 for( ; ; ) 형태와 while( 조건문 ) 형태가 있습니다.
		//	for( 초기값 ; 조건값 ; 증감 ) 형태로 이루어져 있는데요.
		//	이해하기 편하게 하기 위해서는 다음 형태만 기억해주세요.
		//	a부터 b까지의 값을 변수 i에 주고서 명령어를 반복해서 실행하고 싶다면,
		//	for( int i = a; i <= b ; i++ ) ...
		for(int i = 1; i <= 5; i++) {
			System.out.println("출력 : "+i);
		}
		//	이중 for문은 for문이 두개 겹쳐있는 경우입니다.
		//	이경우 변수는 i, j 형태로 구성하게 됩니다.
		for(int i = 1; i <= age; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
