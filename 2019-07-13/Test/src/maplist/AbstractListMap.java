package maplist;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeSet;

public abstract class AbstractListMap<K extends Comparable<? super K>,V> {

	Map<K, TreeSet<V>> map;
	
	public AbstractListMap(Map<K, TreeSet<V>> map) {
		super();
		this.map = map;
	}

	public TreeSet<V> get(K key) {
		TreeSet<V> result = map.get(key); 
		return result == null ? new TreeSet<V>() : result;
	}
	
	public boolean add(K key, V data) {
		TreeSet<V> destination = map.get(key);
		if (destination == null) destination = new TreeSet<V>();
		boolean result = destination.add(data);
		map.put(key, destination);
		return result;
	}
	
	public boolean remove(K key, V data) {
		TreeSet<V> destination = map.get(key);
		if (destination == null) return false;
		return destination.remove(data);
	}
	
	public LinkedHashSet<V> getAll(){
		LinkedHashSet<V> result = new LinkedHashSet<>();
		for (TreeSet<V> tree : map.values())result.addAll(result);
		return result;
	}
	
	abstract LinkedHashSet<V> getInRange(K min, K max);

		
}
