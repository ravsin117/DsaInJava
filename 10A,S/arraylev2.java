public class arraylev2{


    // faulty keyboard
    public static boolean isPossible(String name , String typed){
        if(name.length()> typed.length())
        return false;
        int i = 0 ; 
        int j = 0 ;
        while(i<name.length() && j< typed.length){
            if(name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }else if(i>0 && name.charAT(i-1)==typed.charAt(j)){
                j++;
            }else{
                return false;
            }
        }
        if(j<typed.length()){
            if(name.charAT(i-1)==typed.charAT(j))
            j++;
        }
        return i<name.length()? false :true; 
    }

    //range addition
    public static int [] rangeSum(int length , int queries[][]){
        int res [] = new int [length];
        for(int i = 0 ; i< queries.length;i++){ // O(q)+O(N)
            int si  = queries[i][0];
            int ei = queries[i][1];
            int val = queries[i][2];
            res[si]+=val;
            if(ei+1<length){
                res[ei+1] = val;
            }
        }
        // prefix sum ;
        int sum = 0 ;
        for(int i = 0 ; i < res.length ;i++){
            sum+=res[i];
            res[i]+=sum;
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
            int h = Math.min(heights[i],height[j]);
            water = Math.max(water , h*w);
            if(height[i]<=height[j]){
                i++;
            }
            else{
                j--;
            }
        }

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
    
    // maj elem -2
    public static ArrayList<Integer> majorityElem(int []arr){

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
    public static int[] rotate(int [] arr, int k){
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

        returns nums;
    }

    //segregate -ve and positive numbers
    public static void seg_1(int []nums){
        int i = 0 , j = nums.length-1;
        while(i<=j){
            if(nums[i]>0 && nums[j]<0){
                swap(nums[i],nums[j]);
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
   // seg pos neg is similar to seg 0,1
    public static segPOsneg_2(int[] nums){
        int neg_ptr =-1;
        int ptr =0;
        int size = nums.length;
        while(ptr<size){
            if(arr[ptr]<0){
                swap(nums[++neg_ptr],nums[ptr]);
            }
            ptr++;
        }
    }

    // seg 0,1,2
    public static void seg012(int nums[]){
        int i = 0 , j = 0 , k = nums.length-1;
        while(j<=k){
            if(nums[j]==0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
                i++;
            }else if(nums[j]==1){
                j++;
            }else{
                swap(nums[j],nums[k]);
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
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
        int max = c_sum;
        for(int i  = 1; i < n ;i++){
            int nsum = csum -total_sum + n*nums[i-1];
            csum = nsum;
            max = Math.max(max,csum);
        }
        return max;
    }

    // container with most water 
    // -done

    // length of longest substring with unique characters
    public static int longestSubstring(String s){
        int si = 0 ; 
        int ei  =0 ;
        itn count =0 ;
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

                if(freq[s.charAt(si)]==2){
                    count--;
                }
                freq[s.charAT(si)]--;
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
                if(freq[s.charAt(si)]==1)
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
        while(ei<n){
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
            len = Math.max(len , ei-si);
        }
        return len;
    }

    //minimum window substring
    public static string minimumWindowSubs(String s, String t){

    }
}
