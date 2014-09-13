package self.production.util;

import java.util.HashSet;
import java.util.Iterator;

public class CollectionHelper {
	/**
	 * 获取交集
	 * @param setA
	 * @param setB
	 * @return
	 */
	public static HashSet<String> intersectionSet(HashSet<String> setA, HashSet<String> setB) {
		HashSet<String> intersectionSet = new HashSet<String>();
		Iterator<String> iterA = setA.iterator();
		while (iterA.hasNext()) {
			String tempInner = iterA.next();
			if (setB.contains(tempInner)) {
				intersectionSet.add(tempInner);
			}
		}
		return intersectionSet;
	}
	
	/**
	 * 将带逗号分割符的文本转换成hashset
	 * @param str
	 * @return
	 */
	public static HashSet<String> stringToHashSet(String str) {
		HashSet<String> hs = new HashSet<String>();
		if (str.equals("") || str == null)
			return null;
		if (!str.contains(","))
			hs.add(str);
		else {
			String [] arr = str.split(",");
			for (String s : arr)
				hs.add(s);
		}
		return hs;
			
	}
	
	
	
}