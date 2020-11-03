//	Linked List를 위한 Node 클래스
class Node<E> {
	public E value;				//	데이터를 저장하는 변수
	public Node<E> prev, next;	//	링크드리스트의 Previous, Next 레퍼런스 변수
}
//	Queue 클래스
class Queue<E> {
	Node<E> head;				//	dummy 노드를 레퍼런스하는 변수
	//	생성자.
	//	더미 노드를 생성하고 링크 연결을 합니다.
	Queue() {
		head = new Node();
		head.prev = head;
		head.next = head;
	}
	//	add() : 큐에 데이터를 추가합니다.
	//	head 노드의 next 노드사이에 새로운 노드를 추가합니다.
	public void add(E v) {
		//	1. 새로운 노드를 생성합니다.
		Node<E> newNode = new Node();
		newNode.value = v;
		//	2. 새로운 노드에 링크를 연결합니다.
		newNode.prev = head;
		newNode.next = head.next;
		//	3. head 노드의 next 노드의 prev 링크를 newNode로 연결합니다.
		head.next.prev = newNode;
		//	4. head 노드의 next 링크를 newNode로 연결합니다.
		head.next = newNode;
	}
	//	remove() : 큐에서 데이터를 하나 삭제합니다.
	//	head 노드의 prev 노드를 삭제합니다.
	public void remove() {
		//	1. head의 prev 노드를 임시 변수로 저장합니다.
		Node<E> tmp = head.prev;
		//	2. tmp 노드의 prev 노드의 next를 head로 설정합니다.
		tmp.prev.next = head;
		//	3. head 노드의 prev 값을 tmp 노드의 prev 값으로 설정합니다.
		head.prev = tmp.prev;
	}
	//	peek() : 큐에 맨 앞에 있는 데이터를 반환합니다.
	//	head 노드의 prev 노드의 value를 반환합니다.
	public E peek() {
		//	1. head의 prev 노드의 value 값 반환.
		return head.prev.value;
	}
	//	empty() : 큐가 비어있다면 true를 그렇지 않다면 false를 반환합니다.
	public boolean empty() {
		//	1. head의 prev 값이 자기 자신 head이면 비어있는 것이므로,
		//	head.prev 가 head와 같은지 검사한 결과를 반환한다.
		return head.prev == head;
	}
}
public class Main {
	public static void main(String[] args) {
		//	큐 클래스를 생성합니다.
		Queue<String> que = new Queue();
		//	큐에 데이터를 넣습니다.
		que.add("쥐");
		que.add("소");
		que.add("호랑이");
		System.out.println("Front : "+que.peek());
		System.out.println("Empty?  "+que.empty());
		//	데이터를 지웁니다.
		que.remove();
		que.remove();
		System.out.println("Front : "+que.peek());
		System.out.println("Empty?  "+que.empty());
		que.add("토끼");
		que.add("용");
		System.out.println("Front : "+que.peek());
		System.out.println("Empty?  "+que.empty());
		que.remove();
		que.remove();
		que.remove();
		System.out.println("Front : "+que.peek());
		System.out.println("Empty?  "+que.empty());
	}
}




