import java.util.ArrayList;
import java.util.List;

public class arrayRev1 {
    // long pressed pr faulty keyword
    public static boolean longPressed(String name , String typed){
        if(name.length()> typed.length()){
            return false;
        }
        int i = 0 , j = 0 ; 
        while(i<name.length() && j < typed.length()){
            char ch1 = name.charAt(i);
            char ch2 = name.charAt(j);
            if(i==0 && ch1!=ch2){
                return false;
            }else if(ch1!=ch2 && i>0 && name.charAt(i-1)==ch2){
                j++;
            }else{
                i++;
                j++;
            }
        }
        while(j<typed.length()){
            if(typed.charAt(j)==name.charAt(i-1)){
                j++;
            }else return false;
        }
        return i<name.length()?false:true;
    }

    public static int[] getModifiedArray(int length , int [][] queries){
        int res [] = new int[length];
        for(int i =0 ; i < queries.length ;i++){
            int si = queries[i][0];
            int ei = queries[i][1];
            int inc = queries[i][2];
            res[si]+= inc;
            if(ei<length-1){
                res[ei+1]-= inc;
            }
        }
        int sum = 0 ; 
        for(int i = 0 ; i < res.length ;i++){
            sum+=res[i];
            res[i] = sum;
        }
        return res;
    }

    // container with max water
    public static int getMaxWater(int[]heights){
        int i = 0 ; 
        int j= heights.length;
        int max = -1 ; 
        while(i<j){
            int width = i-j;
            int height = Math.min(heights[i],heights[j]);
            max = Math.max(max,(width * height));
            if(heights[i]<heights[j]){
                i++;
            }else{
                j++;
            }
        }
        return max;
    }

    // square of a sorted array
    public static int [] getSortedSqArr(int [] nums){
        int[]res = new int [nums.length];
        int i = 0 , j = nums.length , k = nums.length;
        while(i<j){
            int prod1 = nums[i]*nums[i];
            int prod2 = nums[j]*nums[j];
            if(prod1<prod2){
                res[k] = prod1;
                i++;
                k--;
            }else{
                res[k] = prod2;
                j--;
                k--;
            }
        }
        return res;
    }
    // majority element 1 
    // brute -> for every element in array run another loop and count the occurences and compare with maxcount for max occurences. if maxcount >arr.length/2 print it else no Majority element-> T.C:O(n2)
    // brute2 make freq map in hm and check which elem occurs more than n/2
    public static int getMajorityElem(int [] arr){
        int count =0 , ele = 0 ;
        for(int i =0 ; i < arr.length ;i++){
            if(count==0){
                ele = arr[i];
            }
            if(arr[i]==ele){
                count++;
            }else{
                count--;
            }
        }
        count =0 ; 
        for(int i =0 ; i< arr.length ;i++){
            if(arr[i]==ele){
                count++;
            }
        }
        if(count<=arr.length/2){
            ele =-1;
        }
        return ele;
    }

    // majority elem 2
    // brute ->make freq map and check which elem occurs more than n/3
    public static List<Integer>getMajele2(int [] arr){
        int count1 =0 , count2 = 0 , ele1 = 0 , ele2 = 0 ;
        
        for(int i = 0 ; i < arr.length;i++){
            if(ele1 == arr[i]){
                count1++;
            }else if(ele2 == arr[i]){
                count2++;
            }else if(count1==0){
                ele1 = arr[i];
                count1=1;
            }else if(count2==0){
                ele2 = arr[i];
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        List<Integer>list = new ArrayList<>();
        for(int i = 0 ;i < arr.length ;i++){
            if(arr[i]==ele1){
                count1++;
            }else if(arr[i]==ele2){
                count2++;
            }
        }
        if(count1>arr.length/3){
            list.add(ele1);
        }
        if(count1>arr.length/3){
            list.add(ele1);
        }
        return list;
    }

    // rotate an array by k
    public static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k < 0) {
            k += nums.length;
        }
        int n = nums.length;
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - k - 1);
        reverse(nums, 0, n - 1);
    }

    public static void segZeroOneTwo(int [] arr){
        int i = 0 , j = 0 , k = arr.length-1;
        while(j<=k){
            if(arr[j]==0){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
                j++;
            }else if(arr[j]==1){
                j++;
            }else{
                int temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
                k--;
            }
        }

    }
    public static int getMaxConfigSum(int[] arr){
        
        int isum = 0 , eleSum = 0 ;
        for(int i = 0 ; i < arr.length ;i++){
            isum +=arr[i] * i;
            eleSum += arr[i];
        }
        int max = 0 ; 
        max = Math.max(max , isum);
        int n = arr.length;
        for(int i = 1; i < arr.length ;i++){
            int nsum = isum - eleSum + (n * arr[i]);
            max = Math.max(max ,nsum);
            isum = nsum;
        }
        return max ;
    }

    public static 
}

