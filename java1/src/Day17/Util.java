package Day17;

public class Util {
	
	// 메소드
	public static<K,V> boolean compare(Pair<K, V>p1, Pair<K, V>p2 ) {
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare =  p2.getValue().equals(p2.getValue());
		return keyCompare && valueCompare; // 둘다 true이면 true반환 / 하나라도 false이면 false반환
	}
	
	// 메소드
	public static <T> Box<T> boxing(T t){
					// 반환타입	// (인수)
		
		Box<T> box = new Box<>();
		box.set(t);
		return box; // 반환값
	}

}
