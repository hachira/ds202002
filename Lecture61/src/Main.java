//	외부 클래스 Stack을 선언하도록 합니다.
//	외부 클래스는 Main 클래스에서 오브젝트를 생성해서 만들기 위한 클래스 정의입니다.
class Example {
	//	클래스 안에는 이 클래스 오브젝트가 사용할 수 있는 변수를 선언해줄 수 있습니다.
	int t;
	//	클래스 이름과 같은 함수를 사용하면, 생성자 함수로 오브젝트를 생성할 때 자동 호출됩니다.
	Example() {
		System.out.println("생성자가 호출되었습니다.");
		t = 0;
	}
	void Set(int k, int n) {
		t = k*n;
	}
	void Print() {
		System.out.println("현재 값은 "+t+"입니다.");
	}
}
//	클래스에 <E> 형태로 뒤에 붙는 경우가 있는데, 이것은 템플릿 클래스로, 클래스 정의시 안에서 사용하는
//	특정 변수타입을 E로 대치할 수 있습니다.
class Stack<E> {
	//	스택의 자료형을 배열로 할 경우 배열을 선언하는 것은 <변수타입>[] 형태로 변수타입에 대괄호를 붙여서
	//	사용합니다.  예를 들어서 int 배열 선언이라면 int[] array; 형태로 변수를 선언해줄 수 있습니다.
	E[] data;			//	배열 데이터를 저장할 변수 선언
	int top;			//	가장 위의 데이터를 가르킬 변수 top 선언
	//	생성자를 제작합니다.  여기 생성자에서는 data 배열을 생성하고, top 변수를 초기화합니다.
	Stack() {
		//	data에 배열을 할당합니다.
		data = (E[])new Object[1024];
		top = -1;
	}
	public void push(E v) {
		//	1. top값을 1 증가시킨다.
		top++;		//	top = top+1;
		//	2.	top에 해당하는 배열에 v 값을 저장한다.
		data[top] = v;
	}
	public void pop() {
		//	0. 만약 기존에 저장된 값을 버려야겠다고 생각한다면, 해당 배열값을 null로 바꾸어주시면 됩니다.
		//	null을 저장해주면, 해당 데이터를 삭제하는 것과 같습니다.
		data[top] = null;
		//	1. top값을 1 감소시킵니다.
		top--;
	}
	public E top() {
		//	1. top가 가르키는 배열값을 반환시킵니다.
		return data[top];
	}
	public boolean empty() {
		//	1. top가 초기값인 -1이면 스택은 비어있습니다.
		return top == -1;
	}
	public int size() {
		//	1. 비어있을 때 top는 -1이므로 1증가시켜서 반환합니다.
		return top+1;
	}
}
//	연결리스트를 이용하는 경우에는 노드라는 클래스가 별도로 필요합니다.
class Node<E> {
	E value;			//	값을 저장할 변수
	Node<E> next;		//	다음 노드를 가르킬 변수
	//	생성자
	Node(E v) {
		value = v;
		next = null;
	}
	//	다음에 올 노드를 지정할 함수
	public void setNext(Node<E> n) {
		next = n;
	}
	//	다음에 있는 노드값을 반환하는 함수
	public Node<E> getNext() { return next; }
	//	값을 얻을 함수
	public E getValue() { return value; } 
}
//	연결리스트를 이용한 스택을 선언합니다.  편의상 StackL 이란 클래스 이름을 쓰도록 하겠습니다.
class StackL<E> {
	Node<E> head;		//	연결리스트의 가장 위를 가르킬 변수
	int size;			//	연결리스트의 노드 갯수 저장(일반적으로 연결리스트의 경우에는 사용 안 함)
	//	생성자
	StackL() {
		head = null;
		size = 0;
	}
	//	push 함수
	public void push(E v) {
		//	1. 노드를 하나 생성합니다.
		Node<E> newNode = new Node(v);
		//	2. 생성한 노드의 다음 노드를 head값으로 대치합니다.
		newNode.setNext(head);
		//	3. head값을 새로 생성한 노드로 대치합니다.
		head = newNode;
		//	Extra. size 값 증가
		size++;
	}
	//	pop 함수
	public void pop() {
		//	1. head가 가르키는 노드의 다음 노드값을 가져옵니다.
		head = head.getNext();
		//	Extra. size 값 감소
		size--;
	}
	//	top 함수
	public E top() {
		//	1. head가 가르키는 노드의 값을 반환합니다.
		return head.getValue();
	}
	//	empty 함수
	public boolean empty() {
		return head == null;
	}
	//	size 함수 (연결리스트에서는 잘 사용하지 않지만, 억지로 구현합니다.)
	public int size() { return size; }
}
public class Main {

	public static void main(String[] args) {
		//	클래스 오브젝트를 생성하기 위해서는 new 라는 키워드를 사용합니다.
		//	<클래스> <오브젝트 이름> = new <클래스>();
		Example obj = new Example();
		//	오브젝트에 있는 함수를 사용할 때에는 <오브젝트 이름>.<함수 이름>(<파라미터들>);
		obj.Print();
		obj.Set(3, 5);
		obj.Print();
		//	다른 오브젝트를 생성한 경우, 기존의 오브젝트에 영향을 주지 않습니다.
		Example obj1 = new Example();
		obj.Print();
		obj1.Print();
		//	템플릿 클래스에서 사용할 변수타입을 문자열(String)으로 하고자 할 때 다음과 같이 생성할 수
		//	있습니다.
		StackL<String> stack = new StackL();
		stack.push("사과");
		stack.push("오렌지");
		System.out.println("현재 맨 위의 값은 "+stack.top()+"입니다.");
		stack.push("수박");
		System.out.println("현재 맨 위의 값은 "+stack.top()+"입니다.");
		System.out.println("현재 스택에 들어가 있는 자료의 갯수는 "+stack.size()+"입니다.");
		stack.pop();
		System.out.println("현재 맨 위의 값은 "+stack.top()+"입니다.");
		System.out.println("현재 스택에 들어가 있는 자료의 갯수는 "+stack.size()+"입니다.");
		stack.pop();
		System.out.println("현재 맨 위의 값은 "+stack.top()+"입니다.");
		System.out.println("현재 스택에 들어가 있는 자료의 갯수는 "+stack.size()+"입니다.");
		stack.push("멜론");
		System.out.println("현재 맨 위의 값은 "+stack.top()+"입니다.");
		System.out.println("현재 스택에 들어가 있는 자료의 갯수는 "+stack.size()+"입니다.");
	}

}
