import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class arraylev2{


    // faulty keyboard
    public static boolean isPossible(String name , String typed){
        if(name.length()> typed.length())
        return false;
        int i = 0 ; 
        int j = 0 ;
        while(i<name.length() && j< typed.length()){
            if(name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }else if(i>0 && name.charAt(i-1)==typed.charAt(j)){
                j++;
            }else{
                return false;
            }
        }
        if(j<typed.length()){
            if(name.charAt(i-1)==typed.charAt(j)){
                j++;
            }else if(name.charAt(i-1)!=typed.charAt(j)){
                return false;
            }
        }
        return i<name.length()? false :true; 
    }

    //range addition
    public static int[] rangeaddition(int length, int[][] queries) {
        // write your code here
        int res[] = new int[length];
        for (int i = 0; i < queries.length; i++) {
            int si = queries[i][0];
            int ei = queries[i][1];
            int val = queries[i][2];
            res[si] += val;
            if (ei+1 < length) {
                res[ei + 1] -= (val);
            }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }

    // container with most water
    public static int mostWater(int [] height){
        int i = 0 ; 
        int j = height.length -1;
           
        int water =0;
        while(i<j){
            int w = j-i;
            int h = Math.min(height[i],height[j]);
            water = Math.max(water , h*w);
            if(height[i]<=height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return water;
    }

    // squares of sorted array
    public static int [] sortedSqaures(int [] nums){
        int i = 0 , j = nums.length-1,k=j;
        int [] res = new int [nums.length];
        while(i<=j){
            int val1 = nums[i]* nums[i];
            int val2 = nums[j]* nums[j];
            if(val1>=val2){
                res[k]=val1;
                k--;
                i++;
            }
            else if(val1<val2){
                res[k]=val2;
                k--;
                j--;
            }

        }
        return res;
    }

    // majority elem

    public static int validcandidate(int [] arr){ // returns potential candidate
        int val = arr[0];
        int count =1;
        for(int i = 1; i< arr.length ;i++){
            if(val==arr[i]){ // same elem 
                count++;
            }else{ // distinct threrfore map with val
                count--;
            }
            if(count==0){
                val  =arr[i];
                count=1;
            }
        }
        return val;
    }
    public static void majElem(int [] arr){
        int potential = validcandidate(arr);
        int count=0;
        for(int i = 0; i< arr.length ;i++){
            if(arr[i]==potential)
            count++;
        }
        if(count>(arr.length/2)){
            System.out.println(potential);
        }else{
            System.out.println("NO MAJORITY ELEM EXIST");
        }

    }
    
    //striver's code for majority elem -1 (better)
    public static int majElem1(int [] arr){
        int count =0 , ele = 0;
        for(int i =0 ; i< arr.length ;i++){
            if(count==0){
                ele = arr[i];
            }
            if(ele == arr[i]){
                count++;
            }else{
                count--;
            }
        }
        return ele;
    }
    // maj elem -2
    public static ArrayList<Integer> majorityElem(int []nums){
        int num1 =-1, num2=-1,count1=0,count2=0;
        for(int i =0; i < nums.length ;i++){
            if(nums[i]==num1){
                count1++;
            }else if(nums[i]==num2){
                count2++;
            }else if(count1==0){
                num1 = nums[i];
                count1=1;
            }else if(count2==0){
                num2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        ArrayList<Integer>ans = new ArrayList<Integer>();
        count1=0;
        count2=0;
        for(int i =0 ; i < nums.length;i++){
            if(nums[i]==num1){
                count1++;
            }else if(nums[i]==num2){
                count2++;
            }
        }
        if(count1>nums.length/3){
            ans.add(num1);
        }
        if(count2>nums.length/3){
            ans.add(num2);
        }
        return ans;
    }

    // rotat an array by k 
    public static void reverse(int nums[], int i , int j ){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp ;
            i++;
            j--;
        }
    }
    public static int[] rotate(int [] nums, int k){
        int size = nums.length ;
        k = k% size;
        if(k<0){
             k= k+size;
        }
        // reversing 1st half
        reverse(nums , 0, size-k-1);
        // reverse second  half
        reverse(nums , size-k , size-1);
        // full reverse
        reverse(nums, 0 , size-1);

        return nums;
    }

    //segregate -ve and positive numbers
    public static void seg_1(int []nums){
        int i = 0 , j = nums.length-1;
        while(i<=j){
            if(nums[i]>0 && nums[j]<0){
                swap(nums,nums[i],nums[j]);
                i++;
                j--;
            }else if(nums[i]<0 && nums[j]<0){
                i++;
            }else if(nums[i]>0 && nums[j]>0){
                j--;
            }else{
                i++;
                j--;
            }  
        }
    }
    public static void swap(int [] arr,int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
   
    // seg pos neg is similar to seg 0,1
    public static void segPOsneg_2(int[] nums){
        int neg_ptr =-1;
        int ptr =0;
        int size = nums.length;
        while(ptr<size){
            if(nums[ptr]<0){
                swap(nums,nums[++neg_ptr],nums[ptr]);
            }
            ptr++;
        }
    }

    // seg 0,1,2
    public static void seg012(int nums[]){
        int i =0 , j =0 , k = nums.length-1;
        while(j<=k){
            if(nums[j]==0){
                swap(nums,i,j);
                i++;
                j++;
            }else if (nums[j]==1){
                j++;
            }else if(nums[i]==2){
                swap(nums,j,k);
                k--;
            }
        }
    }

    // max sum in configuaration-gfg
    // max sum of arr[i]* i on all rotaations possible
    public static int maxSum(int [] nums){
        int total_sum =0;
        for(int e : nums){
            total_sum+=e;
        }
        // index sum
        int csum =0;
        int max = csum;
        int n = nums.length;
        for(int i  = 1; i < n ;i++){
            int nsum = csum -total_sum + n*nums[i-1];
            csum = nsum;
            max = Math.max(max,csum);
        }
        return max;
    }

    // container with most water 
    // -done

    // length of longest substring with unique characters or no repeating characters 
    public static int longestSubstring(String s){
        int si = 0 ; 
        int ei  =0 ;
        int count =0 ;
        int n = s.length();
        int len = 0 ;
        int [] freq =  new int [128]; // contains ascii of all characters
        int rsi = 0 , rei =0;
        while(ei<n){
            if(freq[s.charAt(ei)]==1){ // has this character occured before
                count++;
            }
            freq[s.charAt(ei)]++;
            ei++;
            while(count>0){ // while there is a repeating character

                if(freq[s.charAt(si)]>1){
                    count--;
                }
                freq[s.charAt(si)]--;
                si++;
            }

            if(len>ei-si){
                len = ei-si;
                rsi = si;
                rei = ei;
            }
        }
        System.out.println(s.substring(rsi, rei));
        return len;

    }
    
    // longest substring that contains atmost 2 distict charaters
    //lintcode-928
    public static int longDistSub(String s){
        int ei = 0,si = 0,count=0;
        int n = s.length();
        int len = 0 ;
        int [] freq = new int [128];
        while(ei<n){
            if(freq[s.charAt(ei)]==0){ // if this char is distinct
                count++;                 
            }
            freq[s.charAt(ei)]++;
            ei++;
            while(count>2){
                if(freq[s.charAt(si)]==1)    // if current char is distinct
                count--;
                
                freq[s.charAt(si)]--;
                si++;
            }
            len = Math.max(len ,ei-si);
        }
        return len;
    }
    
    //lonegst substring with *ATMOST* k distinct characters
    public static int longKDistSub(String s, int k){
        int si = 0; 
        int ei= 0 , count=0; 
        int len = 0;
        int n = s.length();
        int [] freq = new int [128];
        while(ei<n) {
            if(freq[s.charAt(ei)]==0){ // if this char is occuring first time
                count++;
            }
            freq[s.charAt(ei)]++;
            ei++;
            while(count>k){ //if there are more than k distict chars
                if(freq[s.charAt(si)]==1)
                count--;

                freq[s.charAt(si)]--;
                si++;
            }
            // find length when we have count(distinct chars) =k
            if(count==k)
               len = Math.max(len , ei-si);
        } 
        return len;
    }

    //minimum window substring
    public static String minWindow(String s, String t) {
        int freq[] = new int[128], si = 0, ei = 0, need = 0, len = (int) 1e9, gsi = 0;
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i)]++;
            need++;
        }
        while (ei < s.length()) {
            if (freq[s.charAt(ei)] > 0) { // this was needed(as need is positive) & we found it now therefore need--
                need--;
            }
            freq[s.charAt(ei)]--;
            ei++;
            while (need == 0) {            // if we have all elements in our window 
                if (len > (ei - si)) { // if this window is smaller
                    len = ei - si;
                    gsi = si;
                }
                                            // shrinking window size inorder to get minimum size window 
                if (freq[s.charAt(si)] == 0) {   // this elements need is going to increase (positively)
                    need++;
                }
                freq[s.charAt(si)]++;
                si++;
            }
        }
        return len == (int) 1e9 ? "" : s.substring(gsi, gsi + len);
    }
   
    // find smallest window such that it has all unique characters of the string given atleast one time
    public static String findSubs(String s){
        int ei =0,freq[]= new int[128] , si = 0 , len = (int)1e9, need = 0 ,gsi = 0;
        for(int i =0 ; i < s.length();i++){
            if(freq[s.charAt(i)]==0){
                freq[s.charAt(i)]++;
                need++;
            }
        }
        while(ei<s.length()){
            if(freq[s.charAt(ei)]>0){
                need--;
            }
            freq[s.charAt(ei)]--;
            ei++;
            while(need==0){
                if(len>ei-si){
                    len = ei-si;
                    gsi = si;
                }
                if(freq[s.charAt(si)]==0){
                    need++;
                }
                freq[s.charAt(si)]++;
                si++;
            }
        }
        return len==(int)1e9?"":s.substring(gsi,gsi+len);
    }
   
    //leetcode-1456  max vowels in window of size k 
    public static boolean isVowel(char ch){
        return (ch=='a'|| ch=='e'||ch=='i'||ch=='o'||ch=='u');
    }
    public static int maxVowels(String s, int k){
        int si =0 , ei = 0, freq []= new int[128],count=0;
        while(k-->0){
            freq[s.charAt(ei)]++;
            if(isVowel(s.charAt(ei))){
                count++;
            }
            ei++;
        }
        int ans = count;
        while(ei<s.length()){
            ans = Math.max(ans,count);
            if(isVowel(s.charAt(ei))){
                count++;
            }
            freq[s.charAt(ei)]++;
            ei++;
            if(isVowel(s.charAt(si))){
                count--;
            }
            freq[s.charAt(si)]++;
            si++;
        }
            ans = Math.max(ans,count);
            return ans;

    }
  
    //leetcode -992 return no of good array (good array-> when number of different integers in that array is excatly k )
    // array with excatly k different integers = array with atmost k idsctinct - array with atmost k-1 distinct integers 
    public static int subWithAtmostKDistinct(int [] nums,int k){
        int si =0 , ei =0 , count =0 , ans =0 ;
        HashMap<Integer,Integer>map = new HashMap<>();
        while(ei<nums.length){
            if(map.containsKey(map.get(nums[ei]))==false){
                count++;
            }
            map.put(nums[ei],map.getOrDefault(nums[ei],0)+1);
            ei++;
            while(count>k){
                if(map.get(nums[si])==1){
                    count--;
                }
                map.put(nums[si],map.get(nums[si])-1);
                if(map.get(nums[si])==0){
                    map.remove(nums[si]);
                }
                si++;
            }
            ans+=(ei-si);
        }
        return ans ;
    }
    public static int subWithExactlyK(int[] nums , int k){
        return subWithAtmostKDistinct(nums, k)-subWithAtmostKDistinct(nums, k-1);
    }

    // leetcode -1248 -> count number of nice subarray
    // nice subarray-> if there are k Odd numbers in it 
    public static void swap2(char[] arr , int  i , int j ){
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }

    public static int maximumSwap(int num){

        char[] arr= (""+num).toCharArray();
        // prepare] last index of digits

        int [] li = new int[10];
        for(int i = 0 ; i < arr.length ;i++){
            int digit = arr[i] - '0';
            li[digit] = i;
        }

        // figuring out posotion of swapping
        boolean flag = false ;
        for(int i = 0 ; i < arr.length ;i++){
            int digit = arr[i]-'0';
            for(int j = 9 ; j > digit; j--){
                if(i < li[j]){
                    swap2(arr,i,li[j]);
                    flag = true;
                    break;
                }
            }
            if(flag==true){
                break;
            }
        }
        //prepare answer to return 
        int num2 = Integer.parseInt(String.valueOf(arr));
        return num2;   
    }

    public static int minDominoRotations(int[] top, int[] bottom) {
        int count1 =0 , count2 =0 , count3 =0 , count4=0 ; 
        int num1 = top[0] , num2 = bottom[0];
        for(int i = 0 ; i< top.length ;i++){
            //num1
            //making top num1
            if(count1!=Integer.MAX_VALUE){
                if(top[i]==num1){
                    
                }else if(bottom[i]==num1){
                    count1++;
                }else{
                    count1 = Integer.MAX_VALUE;
                }
            }
            //making bottom num1
            if(count2!=Integer.MAX_VALUE){
                if(bottom[i]==num1){
                    
                }else if(top[i]==num1){
                    count2++;
                }else{
                    count2 = Integer.MAX_VALUE;
                }
            }
            //num2 
            //making top num2
            if(count3!=Integer.MAX_VALUE){
                if(top[i]==num2){
                    
                }else if(bottom[i]==num2){
                    count3++;
                }else{
                    count3 = Integer.MAX_VALUE;
                }
            }
            //making bottom num2
            if(count4!=Integer.MAX_VALUE){
                if(bottom[i]==num2){
                    
                }else if(top[i]==num2){
                    count4++;
                }else{
                    count4 = Integer.MAX_VALUE;
                }
            }
        }
        int res =  Math.min(Math.min(count2,count1),Math.min(count3,count4));
        return res==Integer.MAX_VALUE?-1:res;
    }
    // 2 sum 
    // min boats to save people 
    // 3 sum 
    // 4 sum 
       // brute -> sort . then 3 ptre and binary search 
    public static List<List<Integer>> get4Sum(int [] nums,int target){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length==0 || nums ==null){
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length ;
        for(int i = 0 ; i< nums.length ;i++){
            for(int j = i+1; j<nums.length ;j++){
                int target2 = target - nums[i] - nums[j];
                int front = j + 1;
                int back = n - 1;
                while(front < back){
                    int tSum = nums[front] + nums[back];
                    if(tSum < target2){
                        front++;
                    }else if(tSum >target2){
                        back--;
                    }else{
                        List<Integer>sres = new ArrayList<>();
                        sres.add(nums[i]);
                        sres.add(nums[j]);
                        sres.add(nums[front]);
                        sres.add(nums[back]);
                        res.add(sres);

                        while(front<back && nums[front] == quad.get(2))
                        ++front;
                        while(front<back && nums[back] == quad.get(3))
                        --back;
                    }
                }
                while(j<n-1 && nums[j+1]==nums[j])++j;
            }
            while(i<n-1 && nums[i+1]==nums[i]) ++i;
        }
        return res;
    }
    // k sum 

    // first missing positive number leetcode 41
    public static void findmissing(int [] arr){
        
    }
}
