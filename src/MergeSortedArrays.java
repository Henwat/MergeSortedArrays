
import java.util.*;


public class MergeSortedArrays {

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> nums1 = new ArrayList<>(Arrays.asList(1,2,3,0,0,0));
        ArrayList<Integer> nums2 = new ArrayList<>(Arrays.asList(2,5,6));
        ArrayList<Integer> resultArray = new ArrayList<>();

        resultArray = mergeSorted(nums1, nums2);

        System.out.println(resultArray);


        
    }

    //list1 has trailing zeroes matching the size of list2
    public static ArrayList<Integer> mergeSorted(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        if (list1.size() == 0 || list2.size() == 0) {
            return new ArrayList<Integer>();
        }

        if (list1.size() == 1 && list2.size() == 0) {
            return list1;
        }

        if (list1.size() == 0 && list2.size() == 1) {
            return list2;
        }
        
        for(int i = 0; i < list2.size(); i++) {
            int currentIns = list2.get(i);

            for(int j = 0 ; j < list1.size(); j++){
                int currentEval = list1.get(j);
                
                if (currentEval == 0) {
                    list1.set(j, currentIns);
                    break;
                }
                if(currentIns < currentEval) {
                    list1.add(j, currentIns);
                    list1.remove(list1.size()-1);
                    break;
                } 
            }
        }
        return list1;
    }
}
