package array.flatten;

import java.util.ArrayList;
import java.util.List;

public class FlatArray {
	
	public List<Integer> flattenArray(List<Object> entryArrayList) {
		List<Integer> resultArrayList = new ArrayList<Integer>();
		
		for (Object object : entryArrayList) {
			if (object instanceof Integer) {
				Integer integerObject = ((Integer) object).intValue();
				resultArrayList.add(integerObject);
			} else if( object instanceof Integer[]) {
				Integer[] arrayIntegerObject = (Integer[]) object;
				
				for (Integer arrayItem : arrayIntegerObject) {
					resultArrayList.add(arrayItem);
				}
			}
		}
		
		return resultArrayList;
	}	
	
}
