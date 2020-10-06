//	�ܺ� Ŭ���� Stack�� �����ϵ��� �մϴ�.
//	�ܺ� Ŭ������ Main Ŭ�������� ������Ʈ�� �����ؼ� ����� ���� Ŭ���� �����Դϴ�.
class Example {
	//	Ŭ���� �ȿ��� �� Ŭ���� ������Ʈ�� ����� �� �ִ� ������ �������� �� �ֽ��ϴ�.
	int t;
	//	Ŭ���� �̸��� ���� �Լ��� ����ϸ�, ������ �Լ��� ������Ʈ�� ������ �� �ڵ� ȣ��˴ϴ�.
	Example() {
		System.out.println("�����ڰ� ȣ��Ǿ����ϴ�.");
		t = 0;
	}
	void Set(int k, int n) {
		t = k*n;
	}
	void Print() {
		System.out.println("���� ���� "+t+"�Դϴ�.");
	}
}
//	Ŭ������ <E> ���·� �ڿ� �ٴ� ��찡 �ִµ�, �̰��� ���ø� Ŭ������, Ŭ���� ���ǽ� �ȿ��� ����ϴ�
//	Ư�� ����Ÿ���� E�� ��ġ�� �� �ֽ��ϴ�.
class Stack<E> {
	//	������ �ڷ����� �迭�� �� ��� �迭�� �����ϴ� ���� <����Ÿ��>[] ���·� ����Ÿ�Կ� ���ȣ�� �ٿ���
	//	����մϴ�.  ���� �� int �迭 �����̶�� int[] array; ���·� ������ �������� �� �ֽ��ϴ�.
	E[] data;			//	�迭 �����͸� ������ ���� ����
	int top;			//	���� ���� �����͸� ����ų ���� top ����
	//	�����ڸ� �����մϴ�.  ���� �����ڿ����� data �迭�� �����ϰ�, top ������ �ʱ�ȭ�մϴ�.
	Stack() {
		//	data�� �迭�� �Ҵ��մϴ�.
		data = (E[])new Object[1024];
		top = -1;
	}
	public void push(E v) {
		//	1. top���� 1 ������Ų��.
		top++;		//	top = top+1;
		//	2.	top�� �ش��ϴ� �迭�� v ���� �����Ѵ�.
		data[top] = v;
	}
	public void pop() {
		//	0. ���� ������ ����� ���� �����߰ڴٰ� �����Ѵٸ�, �ش� �迭���� null�� �ٲپ��ֽø� �˴ϴ�.
		//	null�� �������ָ�, �ش� �����͸� �����ϴ� �Ͱ� �����ϴ�.
		data[top] = null;
		//	1. top���� 1 ���ҽ�ŵ�ϴ�.
		top--;
	}
	public E top() {
		//	1. top�� ����Ű�� �迭���� ��ȯ��ŵ�ϴ�.
		return data[top];
	}
	public boolean empty() {
		//	1. top�� �ʱⰪ�� -1�̸� ������ ����ֽ��ϴ�.
		return top == -1;
	}
	public int size() {
		//	1. ������� �� top�� -1�̹Ƿ� 1�������Ѽ� ��ȯ�մϴ�.
		return top+1;
	}
}
//	���Ḯ��Ʈ�� �̿��ϴ� ��쿡�� ����� Ŭ������ ������ �ʿ��մϴ�.
class Node<E> {
	E value;			//	���� ������ ����
	Node<E> next;		//	���� ��带 ����ų ����
	//	������
	Node(E v) {
		value = v;
		next = null;
	}
	//	������ �� ��带 ������ �Լ�
	public void setNext(Node<E> n) {
		next = n;
	}
	//	������ �ִ� ��尪�� ��ȯ�ϴ� �Լ�
	public Node<E> getNext() { return next; }
	//	���� ���� �Լ�
	public E getValue() { return value; } 
}
//	���Ḯ��Ʈ�� �̿��� ������ �����մϴ�.  ���ǻ� StackL �̶� Ŭ���� �̸��� ������ �ϰڽ��ϴ�.
class StackL<E> {
	Node<E> head;		//	���Ḯ��Ʈ�� ���� ���� ����ų ����
	int size;			//	���Ḯ��Ʈ�� ��� ���� ����(�Ϲ������� ���Ḯ��Ʈ�� ��쿡�� ��� �� ��)
	//	������
	StackL() {
		head = null;
		size = 0;
	}
	//	push �Լ�
	public void push(E v) {
		//	1. ��带 �ϳ� �����մϴ�.
		Node<E> newNode = new Node(v);
		//	2. ������ ����� ���� ��带 head������ ��ġ�մϴ�.
		newNode.setNext(head);
		//	3. head���� ���� ������ ���� ��ġ�մϴ�.
		head = newNode;
		//	Extra. size �� ����
		size++;
	}
	//	pop �Լ�
	public void pop() {
		//	1. head�� ����Ű�� ����� ���� ��尪�� �����ɴϴ�.
		head = head.getNext();
		//	Extra. size �� ����
		size--;
	}
	//	top �Լ�
	public E top() {
		//	1. head�� ����Ű�� ����� ���� ��ȯ�մϴ�.
		return head.getValue();
	}
	//	empty �Լ�
	public boolean empty() {
		return head == null;
	}
	//	size �Լ� (���Ḯ��Ʈ������ �� ������� ������, ������ �����մϴ�.)
	public int size() { return size; }
}
public class Main {

	public static void main(String[] args) {
		//	Ŭ���� ������Ʈ�� �����ϱ� ���ؼ��� new ��� Ű���带 ����մϴ�.
		//	<Ŭ����> <������Ʈ �̸�> = new <Ŭ����>();
		Example obj = new Example();
		//	������Ʈ�� �ִ� �Լ��� ����� ������ <������Ʈ �̸�>.<�Լ� �̸�>(<�Ķ���͵�>);
		obj.Print();
		obj.Set(3, 5);
		obj.Print();
		//	�ٸ� ������Ʈ�� ������ ���, ������ ������Ʈ�� ������ ���� �ʽ��ϴ�.
		Example obj1 = new Example();
		obj.Print();
		obj1.Print();
		//	���ø� Ŭ�������� ����� ����Ÿ���� ���ڿ�(String)���� �ϰ��� �� �� ������ ���� ������ ��
		//	�ֽ��ϴ�.
		StackL<String> stack = new StackL();
		stack.push("���");
		stack.push("������");
		System.out.println("���� �� ���� ���� "+stack.top()+"�Դϴ�.");
		stack.push("����");
		System.out.println("���� �� ���� ���� "+stack.top()+"�Դϴ�.");
		System.out.println("���� ���ÿ� �� �ִ� �ڷ��� ������ "+stack.size()+"�Դϴ�.");
		stack.pop();
		System.out.println("���� �� ���� ���� "+stack.top()+"�Դϴ�.");
		System.out.println("���� ���ÿ� �� �ִ� �ڷ��� ������ "+stack.size()+"�Դϴ�.");
		stack.pop();
		System.out.println("���� �� ���� ���� "+stack.top()+"�Դϴ�.");
		System.out.println("���� ���ÿ� �� �ִ� �ڷ��� ������ "+stack.size()+"�Դϴ�.");
		stack.push("���");
		System.out.println("���� �� ���� ���� "+stack.top()+"�Դϴ�.");
		System.out.println("���� ���ÿ� �� �ִ� �ڷ��� ������ "+stack.size()+"�Դϴ�.");
	}

}
