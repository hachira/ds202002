//	Lecture 14 Hash Table
//	�ؽ����̺��� �Է¿� ���Ͽ� ��°��� �������ִ� ������ �մϴ�.
//	�̹� �ǽ�������,
//	���� �ܾ�� �׿� �´� ���ڰ��� �������ִ� �׽�Ʈ�� �� ���Դϴ�.
//	"one" -> 1, "two" -> 2
//	������ ������ �ϴ� ������.
//	HashTable �̶�� ���ø� ����� Ŭ������ ����� ����ϵ��� �մϴ�.
import java.util.Scanner;
class HashTable<K, V> {
	K[] keys;			//	Ű���� ������ �迭 ����
	V[] values;			//	������ ������ �迭 ����
	int size;			//	�迭 �ڷ� ������ ũ��
	//	������
	//	�Է� m : �ؽ� ���̺��� ũ��
	HashTable(int m) {
		//	Ű ������ �� ������ �����մϴ�.
		keys = (K[])new Object[m];
		values = (V[])new Object[m];
		size = m;
	}
	//	�־��� Ű�� ���ؼ� �ؽð��� ��ȯ���ش�.
	int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % size;
	}
	int hash2(K key) {
		return ((key.hashCode() & 0x7fffffff) % 7)+1;
	}
	//	�־��� Ű�� �� ���� �����մϴ�.
	void put(K key, V value) {
		//	�������� ������� �����͸� �߰��մϴ�.
		int h = hash(key);
		//	h�� �ش��ϴ� ���� key���� ������� �ʴ��� ��� �����մϴ�.
		while(keys[h]!=null) {
			//	1�� ���� ��������� �մϴ�.
			h = (h+1)%size;
		}
		//	����ִ� ���� ã������ key�� value���� �ش� �迭�� �����մϴ�.
		keys[h] = key;
		values[h] = value;
	}
	//	�־��� Ű�� ���ؼ� ���ε� ���� ��ȯ�մϴ�.  �ش� Ű�� �������� �ʴ� ��� null ��ȯ
	V get(K key) {
		int h = hash(key);
		//	h���� �ش��ϴ� ���� �ڷᰡ ���ٸ� �װ��� �ش��ϴ� Ű�� �� ã�Ҵٴ� ���Դϴ�.
		while(values[h]!=null) {
			//	h���� �ش��ϴ� key�� �־��� key�� ���ٸ� �ùٸ��� ã�� ���̴� �� ��ȯ
			if(key.equals(keys[h])) return values[h];
			//	�ڷ�� ������, ���ϴ� �ڷᰡ �ƴϴ� ���� �ڷ�� h���� �̵��մϴ�.
			h = (h+1)%size;
		}
		return null;
	}
	//	�־��� Ű�� �����ϴ��� �˻��մϴ�.
	boolean contain(K key) {
		return get(key)!=null;
	}
}
public class Main {
	public static void main(String[] args) {
		//	�ؽ� ���̺��� �����ϰ� 1���� 10������ �ڷḦ �ֽ��ϴ�.
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
		//	���ڿ��� �Է¹ް�, �ش� ���ڿ��� ���� �ڷḦ ����մϴ�.
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
