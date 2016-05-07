package array.flatten;

import java.util.ArrayList;
import java.util.List;

public class StartApplication {

	public static void main(String[] args) {		
		FlatArray flat = new FlatArray();
		
		List<Object> arrayList = new ArrayList<Object>();
		
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(new Integer[]{4,5,6,7});
		arrayList.add(8);
		arrayList.add(new Integer[]{9,10});
		arrayList.add(new Object[]{new Integer[]{11,12},13});
		
		List<Integer> result = flat.flattenArray(arrayList);
		
		for (Integer resultItem : result) {
			System.out.println(resultItem);
		}
	}
}
