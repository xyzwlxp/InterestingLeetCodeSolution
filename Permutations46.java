import java.util.LinkedList;
import java.util.List;

class Permutations46 {

	public List<List<Integer>> permute(int[] nums) {
		/*-
		 * Referring to https://stackoverflow.com/questions/1506078/fast-permutation-number-permutation-mapping-algorithms/1506337#1506337
		 * Convert integer value from 0 to 119 to format of increment as the n - index 
		 * 0 -> {0,0,0,0,0}
		 * 1 -> {0,0,0,1,0}
		 * 119 -> {4,3,2,1,0}
		 * 
		 */
		int n = nums.length;
		List<List<Integer>> listlist = new LinkedList<List<Integer>>();
		int[] arr = new int[n];
		arr[0] = 1;
		for (int i = 1; i < n; i++) {
			int h = i + 1;
			arr[i] = h * arr[i - 1];
		}
		for (int i = 0; i < arr[n - 1]; i++) {
			int[] resultArr = new int[n];
			int value = i;
			for (int j = n - 2; j >= 0; j--) {
				resultArr[n - j - 2] = value / arr[j];
				value -= resultArr[n - j - 2] * arr[j];
			}
			boolean[] set = new boolean[n];
			int[] permuted = new int[n];

			List<Integer> list = new LinkedList<>();
      /*
      * Converting the previous mentioned type of values towards the correct format. 
      */
      
			for (int j = 0; j < n; j++) {
				int s = resultArr[j];
				int remainingPosition = 0;
				int index;
        
        // Find the s'th position in the permuted list that has not been set yet.
				for (index = 0; index < n; index++) {
					if (!set[index]) {
						if (remainingPosition == s)
							break;

						remainingPosition++;
					}
				}
				permuted[index] = j;
				set[index] = true;
			}
			for (int val : permuted) {
				list.add(nums[val]);
			}
			listlist.add(list);
		}
		return listlist;
	}

	public static void main(String[] args) {
		Permutations46 so = new Permutations46();
		System.out.println(so.permute(new int[] { 1, 2, 3, 4, 5 }));
	}
}
