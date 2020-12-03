//	Lecture 14 Hash Table
//	해시테이블은 입력에 대하여 출력값을 매핑해주는 역할을 합니다.
//	이번 실습에서는,
//	영어 단어와 그에 맞는 숫자값을 매핑해주는 테스트를 할 것입니다.
//	"one" -> 1, "two" -> 2
//	형태의 매핑을 하는 것이죠.
//	HashTable 이라는 템플릿 기반의 클래스를 만들어 사용하도록 합니다.
import java.util.Scanner;
class HashTable<K, V> {
	K[] keys;			//	키들을 저장할 배열 공간
	V[] values;			//	값들을 저장할 배열 공간
	int size;			//	배열 자료 공간의 크기
	//	생성자
	//	입력 m : 해시 테이블의 크기
	HashTable(int m) {
		//	키 공간과 값 공간을 생성합니다.
		keys = (K[])new Object[m];
		values = (V[])new Object[m];
		size = m;
	}
	//	주어진 키에 대해서 해시값을 반환해준다.
	int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % size;
	}
	int hash2(K key) {
		return ((key.hashCode() & 0x7fffffff) % 7)+1;
	}
	//	주어진 키와 값 쌍을 저장합니다.
	void put(K key, V value) {
		//	선형조사 방식으로 데이터를 추가합니다.
		int h = hash(key);
		//	h에 해당하는 값에 key값이 비어있지 않는한 계속 조사합니다.
		while(keys[h]!=null) {
			//	1차 선형 조사법으로 합니다.
			h = (h+1)%size;
		}
		//	비어있는 곳을 찾았으니 key와 value값을 해당 배열에 저장합니다.
		keys[h] = key;
		values[h] = value;
	}
	//	주어진 키에 대해서 매핑된 값을 반환합니다.  해당 키가 존재하지 않는 경우 null 반환
	V get(K key) {
		int h = hash(key);
		//	h값에 해당하는 곳에 자료가 없다면 그것은 해당하는 키를 못 찾았다는 뜻입니다.
		while(values[h]!=null) {
			//	h값에 해당하는 key가 주어진 key와 같다면 올바르게 찾은 것이니 값 반환
			if(key.equals(keys[h])) return values[h];
			//	자료는 있지만, 원하는 자료가 아니니 다음 자료로 h값을 이동합니다.
			h = (h+1)%size;
		}
		return null;
	}
	//	주어진 키가 존재하는지 검사합니다.
	boolean contain(K key) {
		return get(key)!=null;
	}
}
public class Main {
	public static void main(String[] args) {
		//	해시 테이블을 생성하고 1부터 10까지의 자료를 넣습니다.
		HashTable<String, Integer> map = new HashTable(13);
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		map.put("five", 5);
		map.put("six", 6);
		map.put("seven", 7);
		map.put("eight", 8);
		map.put("nine", 9);
		map.put("ten", 10);
		//	문자열을 입력받고, 해당 문자열에 대한 자료를 출력합니다.
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("Input Key : ");
			String key = scan.next();
			if(key.equals("quit")) break;
			if(map.contain(key)) {
				System.out.println(key+" is "+map.get(key));
			}
			else {
				System.out.println(key+" is not exist");
			}
		}
	}
}
