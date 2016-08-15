import java.util.*;
import java.util.Map.Entry;

public class MapsTestAppl {
	public static void main(String[] args) {
//		TreeMap<Integer, String> mounths = new TreeMap<>();
//		mounths.put(10,"Jun");
//		mounths.put(20,"Oct");
//		mounths.put(40,"Feb");
//		mounths.put(5,"Dec");
//		
//		displayIterable(mounths.subMap(15, 45).keySet());
//		displayIterable(mounths.values());
//		displayIterable(mounths.entrySet());
		String[] strings = {"aa","rgr","bb","aa","rgr","rgr","ghhg","ghhg","ghhg"};
		displayOccurrencies(strings);
	}

	@SuppressWarnings("rawtypes")
	private static void displayIterable(Iterable iterable) {
		for(Object obj : iterable){
			System.out.println(obj);
		}
	}
	
	public static void displayOccurrencies(String[] strings){
		Map<String,Integer> map = new HashMap<>();// key - string , value - counter
		map = createMap(strings);
		
		Set<Entry<String, Integer>> set = map.entrySet();
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(set);
		//list.sort(new Compar());
		list.sort(
					(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) -> 
					{
						if(entry1.getValue() != entry2.getValue())
							return entry1.getValue() - entry2.getValue();
						return entry1.getKey().compareTo(entry2.getKey());
					}
		);
		print(list);
	}

	private static void print(ArrayList<Map.Entry<String, Integer>> list) {
		for(Map.Entry<String, Integer> entry : list){
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
		
	}

	private static Map<String, Integer> createMap(String[] strings) {
		Map<String,Integer> map = new HashMap<>();
		for(int i = 0; i < strings.length; i++){
			Integer counter = map.get(strings[i]);
			if(counter == null) counter = 1;
			else counter++;
			map.put(strings[i], counter);
		}
		return map;
	}
}
/* Map
 * TreeMap
 * HashMap
 * LinkedHashMap
 * KVC - Key Value Coding
 * In Map comparable of key
 * no duplicate keys
 * Search in range  TreeMap O(N) = LogN
 * V = F(K)
 * Basic operation:
 * put,get,remove,containsKey,containsValue,size,empty
 * putAll,clear
 * 
 * keySet,entrySet,values
 * 
 * нап функ принимает массив строк строки могут повторяться
 * распичатать строка и кол-во повторений в порядке убывания частот
 * если частота одинакова то по алфавиту
 * displayOccurencies(String[] strings)
 */
