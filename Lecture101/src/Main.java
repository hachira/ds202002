//	Linked List�� ���� Node Ŭ����
class Node<E> {
	public E value;				//	�����͸� �����ϴ� ����
	public Node<E> prev, next;	//	��ũ�帮��Ʈ�� Previous, Next ���۷��� ����
}
//	Queue Ŭ����
class Queue<E> {
	Node<E> head;				//	dummy ��带 ���۷����ϴ� ����
	//	������.
	//	���� ��带 �����ϰ� ��ũ ������ �մϴ�.
	Queue() {
		head = new Node();
		head.prev = head;
		head.next = head;
	}
	//	add() : ť�� �����͸� �߰��մϴ�.
	//	head ����� next �����̿� ���ο� ��带 �߰��մϴ�.
	public void add(E v) {
		//	1. ���ο� ��带 �����մϴ�.
		Node<E> newNode = new Node();
		newNode.value = v;
		//	2. ���ο� ��忡 ��ũ�� �����մϴ�.
		newNode.prev = head;
		newNode.next = head.next;
		//	3. head ����� next ����� prev ��ũ�� newNode�� �����մϴ�.
		head.next.prev = newNode;
		//	4. head ����� next ��ũ�� newNode�� �����մϴ�.
		head.next = newNode;
	}
	//	remove() : ť���� �����͸� �ϳ� �����մϴ�.
	//	head ����� prev ��带 �����մϴ�.
	public void remove() {
		//	1. head�� prev ��带 �ӽ� ������ �����մϴ�.
		Node<E> tmp = head.prev;
		//	2. tmp ����� prev ����� next�� head�� �����մϴ�.
		tmp.prev.next = head;
		//	3. head ����� prev ���� tmp ����� prev ������ �����մϴ�.
		head.prev = tmp.prev;
	}
	//	peek() : ť�� �� �տ� �ִ� �����͸� ��ȯ�մϴ�.
	//	head ����� prev ����� value�� ��ȯ�մϴ�.
	public E peek() {
		//	1. head�� prev ����� value �� ��ȯ.
		return head.prev.value;
	}
	//	empty() : ť�� ����ִٸ� true�� �׷��� �ʴٸ� false�� ��ȯ�մϴ�.
	public boolean empty() {
		//	1. head�� prev ���� �ڱ� �ڽ� head�̸� ����ִ� ���̹Ƿ�,
		//	head.prev �� head�� ������ �˻��� ����� ��ȯ�Ѵ�.
		return head.prev == head;
	}
}
public class Main {
	public static void main(String[] args) {
		//	ť Ŭ������ �����մϴ�.
		Queue<String> que = new Queue();
		//	ť�� �����͸� �ֽ��ϴ�.
		que.add("��");
		que.add("��");
		que.add("ȣ����");
		System.out.println("Front : "+que.peek());
		System.out.println("Empty?  "+que.empty());
		//	�����͸� ����ϴ�.
		que.remove();
		que.remove();
		System.out.println("Front : "+que.peek());
		System.out.println("Empty?  "+que.empty());
		que.add("�䳢");
		que.add("��");
		System.out.println("Front : "+que.peek());
		System.out.println("Empty?  "+que.empty());
		que.remove();
		que.remove();
		que.remove();
		System.out.println("Front : "+que.peek());
		System.out.println("Empty?  "+que.empty());
	}
}




