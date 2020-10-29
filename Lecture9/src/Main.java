///	�迭�� �̿��� ť(Queue) Ŭ�����Դϴ�.
class Queue<E> {
	int front;		//	ť�� �� ���� �� �ε���(�����͸� ���� ��ġ)
	int rear;		//	ť�� �� ���� �� �ε���(�����Ͱ� �߰��� ��ġ)
	E[] data;		//	ť�� �����Ͱ� �� �迭 ����
	int size;		//	�迭�� ũ��
	//	�������Դϴ�.  �����ڿ����� Queue Ŭ������ �ڷᱸ���� �ʱ�ȭ�ϰ�,
	//	�迭�� �����մϴ�.
	Queue() {
		//	1. �迭�� �ε����� ����Ű�� �� ������ ���� 0���� �ʱ�ȭ�մϴ�.
		front = 0;
		rear = 0;
		size = 1000;
		//	2. �迭�� 1000�� �Ҵ��մϴ�.
		data = (E[])new Object[size];
	}
	//	ť�� �����͸� �߰��ϴ� �Լ��Դϴ�.
	public void add(E v) {
		//	1. rear�� �ش��ϴ� �迭 ������ v���� �ֽ��ϴ�.
		data[rear] = v;
		//	2. rear���� 1 �����մϴ�.
		//		�̶� % �����ڸ� �̿��ؼ� �迭 �ε����� �����÷ο���� �ʵ��� �մϴ�.
		rear = (rear+1)%size;
	}
	//	ť���� �����͸� �����ϴ� �Լ��Դϴ�.
	public void remove() {
		//	1. front�� �ش��ϴ� �迭 ������ null���� �ֽ��ϴ�.
		data[front] = null;
		//	2. front���� 1 �����մϴ�.
		//		rear�� �������� ���������� % �����ڸ� ����մϴ�.
		front = (front+1)%size;
	}
	//	ť���� �����͸� �д� �Լ��Դϴ�.
	public E peek() {
		//	1. front�� �ִ� �����͸� ��ȯ�մϴ�.
		return data[front];
	}
	//	ť�� ��������� true, ������� ������ false�� ��ȯ�մϴ�.
	public boolean empty() {
		//	1. front�� rear���� ������ ����ִٴ� ���̹Ƿ� �ش� �񱳸� �ؼ� ��ȯ�մϴ�.
		return front==rear;
	}
	//	ť�� �����Ͱ� �󸶳� �ִ��� ���� ��ȯ�մϴ�.
	public int size() {
		//	1. rear ������ front ���� �� ���� ��ȯ�մϴ�.
		//int s = rear - front;
		//if(s >= 0) return s;
		//return s+size;
		return (rear-front+size)%size;
	}
}
public class Main {
	public static void main(String[] args) {
		Queue<String> que = new Queue();
		que.add("���");
		que.add("������");
		System.out.println("PEEK : "+que.peek());
		System.out.println("EMPTY? "+que.empty());
		System.out.println("SIZE : "+que.size());
		que.remove();
		System.out.println("PEEK : "+que.peek());
		System.out.println("EMPTY? "+que.empty());
		System.out.println("SIZE : "+que.size());
		que.add("����");
		System.out.println("PEEK : "+que.peek());
		System.out.println("EMPTY? "+que.empty());
		System.out.println("SIZE : "+que.size());
		que.remove();
		que.remove();
		System.out.println("PEEK : "+que.peek());
		System.out.println("EMPTY? "+que.empty());
		System.out.println("SIZE : "+que.size());
	}
}


