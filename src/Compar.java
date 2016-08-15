import java.util.Comparator;
import java.util.Map;

public class Compar implements Comparator<Map.Entry<String, Integer>> {

	@Override
	public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
		if(entry1.getValue() != entry2.getValue())
			return entry1.getValue() - entry2.getValue();
		return entry1.getKey().compareTo(entry2.getKey());	
	}

}
