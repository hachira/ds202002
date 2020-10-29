///	배열을 이용한 큐(Queue) 클래스입니다.
class Queue<E> {
	int front;		//	큐의 맨 앞의 값 인덱스(데이터를 읽을 위치)
	int rear;		//	큐의 맨 뒤의 값 인덱스(데이터가 추가될 위치)
	E[] data;		//	큐의 데이터가 들어갈 배열 공간
	int size;		//	배열의 크기
	//	생성자입니다.  생성자에서는 Queue 클래스의 자료구조를 초기화하고,
	//	배열을 생성합니다.
	Queue() {
		//	1. 배열의 인덱스를 가르키는 두 변수의 값을 0으로 초기화합니다.
		front = 0;
		rear = 0;
		size = 1000;
		//	2. 배열을 1000개 할당합니다.
		data = (E[])new Object[size];
	}
	//	큐에 데이터를 추가하는 함수입니다.
	public void add(E v) {
		//	1. rear에 해당하는 배열 공간에 v값을 넣습니다.
		data[rear] = v;
		//	2. rear값을 1 증가합니다.
		//		이때 % 연산자를 이용해서 배열 인덱스가 오버플로우되지 않도록 합니다.
		rear = (rear+1)%size;
	}
	//	큐에서 데이터를 삭제하는 함수입니다.
	public void remove() {
		//	1. front에 해당하는 배열 공간에 null값을 넣습니다.
		data[front] = null;
		//	2. front값을 1 증가합니다.
		//		rear값 증가때와 마찬가지로 % 연산자를 사용합니다.
		front = (front+1)%size;
	}
	//	큐에서 데이터를 읽는 함수입니다.
	public E peek() {
		//	1. front에 있는 데이터를 반환합니다.
		return data[front];
	}
	//	큐가 비어있으면 true, 비어있지 않으면 false를 반환합니다.
	public boolean empty() {
		//	1. front와 rear값이 같으면 비어있다는 뜻이므로 해당 비교를 해서 반환합니다.
		return front==rear;
	}
	//	큐에 데이터가 얼마나 있는지 값을 반환합니다.
	public int size() {
		//	1. rear 값에서 front 값을 뺀 것을 반환합니다.
		//int s = rear - front;
		//if(s >= 0) return s;
		//return s+size;
		return (rear-front+size)%size;
	}
}
public class Main {
	public static void main(String[] args) {
		Queue<String> que = new Queue();
		que.add("사과");
		que.add("오렌지");
		System.out.println("PEEK : "+que.peek());
		System.out.println("EMPTY? "+que.empty());
		System.out.println("SIZE : "+que.size());
		que.remove();
		System.out.println("PEEK : "+que.peek());
		System.out.println("EMPTY? "+que.empty());
		System.out.println("SIZE : "+que.size());
		que.add("수박");
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


