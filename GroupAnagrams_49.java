
/*
Given an array of strings, group anagrams together.

Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
An interesting Solution using Hashing.
*/

class GroupAnagrams_49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		int[] arr = new int[] { 2, 3, 5, 7, 9, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
				83, 89, 97, 101 };
		List<List<String>> StringListList = new LinkedList<>();
		Map<Long, List<String>> map = new HashMap<>();
		for (int index = 0; index < strs.length; index++) {
			long sum = 1;
			for (int i = 0; i < strs[index].length(); i++) {
				char c = strs[index].charAt(i);
				sum *= arr[c - 97];
			}
			if (map.get(sum) == null) {
				List<String> strList = new LinkedList<>();
				strList.add(strs[index]);
				map.put(sum, strList);
				StringListList.add(strList);
			} else {
				map.get(sum).add(strs[index]);
			}
		}
		return StringListList;
	}

	public static void main(String args[]) {
		Solution so = new Solution();
		System.out.println(so.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
	}
}
