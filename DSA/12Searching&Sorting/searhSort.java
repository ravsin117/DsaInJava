import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class searhSort {
    
    public static class Marks implements Comparable<Marks>{

        int phy ;
        int chem ;
        int maths;
        Marks(){

        }
        Marks(int phy , int chem , int maths){
            this.phy = phy;
            this.chem = chem;
            this.maths = maths;
        }
        public int compareTo(Marks o){
            if(this.phy!=o.phy)
                return this.phy - o.phy;
            
            if(this.chem!=o.chem)
                return o.chem - this.chem;
            
                return this.maths - o.maths;
            
        }
    }
    public static void customSort(int[]phy , int [] chem, int[]maths){
        
        int n = phy.length;
        Marks[] arr = new Marks[n];
        
        for(int i = 0 ; i <arr.length ;i++){
            arr[i] = new Marks(phy[i], chem[i], maths[i]);
        }
        Arrays.sort(arr);
        for(int i =0 ; i < arr.length ;i++){
            phy[i] = arr[i].phy;
            chem[i] = arr[i].chem;
            maths[i] = arr[i].maths;
        }

    }
    
    // union of two sorted array 
    public static ArrayList<Integer> findUnion(int a[], int b[], int n, int m) {
        // add your code here
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                if (list.size() > 0 && list.get(list.size() - 1) != a[i]) {
                    list.add(a[i]);
                } else if (list.size() == 0) {
                    list.add(a[i]);
                }
                i++;
                j++;
            } else if (a[i] < b[j]) {
                if (list.size() > 0 && list.get(list.size() - 1) != a[i]) {
                    list.add(a[i]);
                } else if (list.size() == 0) {
                    list.add(a[i]);
                }
                i++;
            } else {
                if (list.size() > 0 && list.get(list.size() - 1) != b[j]) {
                    list.add(b[j]);
                } else if (list.size() == 0) {
                    list.add(b[j]);
                }
                j++;
            }
        }
        while (i < a.length) {
            if (list.get(list.size() - 1) != a[i]) {
                list.add(a[i]);
            } else if (list.size() == 0) {
                list.add(a[i]);
            }
            i++;
        }
        while (j < b.length) {
            if (list.get(list.size() - 1) != b[j]) {
                list.add(b[j]);
            } else if (list.size() == 0) {
                list.add(b[j]);
            }
            j++;
        }
        return list;

    }
    // searhc in 2D matrix
    public static boolean searchMatrix(int[][]matrix,int target){
        int rowNum = searchRowNum(matrix, target);
        if(rowNum==-1){
            return false;
        }
        boolean res = binarySearch(matrix,rowNum, target);
        return res;
    }
    public static boolean binarySearch(int[][]matrix ,int r, int target){
        int lo= 0 ; 
        int hi = matrix[0].length-1;
        while(lo<=hi){
            int mid = (matrix[r][lo] + matrix[r][hi])/2;
            if(target==mid){
                return true;
            }else if(target>matrix[r][mid]){
                lo = mid+1;
            }else if(target<matrix[r][mid]){
                hi = mid-1;
            }
        }
        return false;
    }
    public static int searchRowNum(int[][] matrix,int target){
        int lo = 0 ;
        int hi = matrix.length-1;
        int lc = matrix[0].length-1;
        while(lo<=hi){
            int mid = (matrix[lo][0] + matrix[hi][0])/2;
            if(target>= matrix[mid][0] && target<= matrix[mid][0]){
                return mid;
            }else if(target>matrix[mid][0]){
                lo = mid+1;
            }else if(target<matrix[mid][0]){
                hi = mid-1;
            }
        }
        return -1;
        
    }

    // second solution
    public boolean searchMatrix2(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0 && matrix[i][j] != target) {
            if (target > matrix[i][j]) {
                i++;
            } else if (target < matrix[i][j]) {
                j--;
            }
        }
        if (i == matrix.length || j < 0) {
            return false;
        }
        return true;
    }

    // find k closest elements
    // pq -addition -> logn (n = no of elemts in pq)
    // here addition in pq of size k :. complexity -> logk
    // here addition for n times :. -> nlogk
    // second loop for sorting has comp -> klogk
    //:. total complexity -> nlogk
    public class Pair implements Comparable<Pair>{
        int val; 
        int gap ;
        Pair(){

        }
        Pair(int val , int gap){
            this.val = val;
            this.gap = gap ;
        }
        public int compareTo(Pair o){
            if(this.gap== o.gap){
                return this.val - o.val;
            }
            return this.gap-o.gap;
        }
    }
    public List<Integer> findClosestElem(int [] arr, int x , int k){
        List<Integer>list = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i =0 ; i< arr.length ;i++){
            if(pq.size()<k){
                pq.add(new Pair(arr[i],Math.abs(arr[i]-x)));
            }else{
                if(pq.peek().gap > Math.abs(arr[i]-x)){
                    pq.remove();
                    pq.add(new Pair(arr[i], Math.abs(arr[i]-x)));
                }                
            }
        }

        while(pq.size()>0){
            list.add(pq.remove().val);
        }

        Collections.sort(list);
        return list;
    }   

    //optimised approach of k closest elems 
    //T.c = > logn + klogk
    public static List<Integer> findClosestElem2(int [] arr, int x , int k ){
        int lo  =0 ; 
        int hi = arr.length-1;
        int mid = 0 ; 
        while(lo<= hi){
            mid = (lo+hi)/2;
            if(x==arr[mid]){
                break;
            }else if(arr[mid]<x){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        int l = mid-1;
        int r = mid;
        List<Integer>list = new ArrayList<Integer>();
        while(l>=0 && r<arr.length && k>0){
            if(Math.abs(arr[r]-x) <= Math.abs(arr[l]-x)){
                list.add(arr[r]);
                r++;
            }else{
                list.add(arr[l]);
                l--;
            }
            k--;
        }
        while(l>=0 && k>0){
            list.add(arr[l]);
            l--;
            k--;
        }

        while (r<arr.length && k > 0) {
            list.add(arr[r]);
            r++;
            k--;
        }
        Collections.sort(list);
        return list;
    }

    // inversions 

    // find first and last occurence of a number in sorted array
    public static int[] searchRange(int[] nums, int target) {
        int[] ans ={-1,-1};
        int lo = 0 , hi = nums.length -1;
        // for finding first index
        while(lo<=hi){
            int mid = (lo + hi )/2;
            if(nums[mid]==target){
                ans[0] = mid;
                hi = mid-1; 
            }else if(nums[mid]<target){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        
        lo =0 ; hi = nums.length-1;
        while(lo<=hi){
            int mid = (lo + hi )/2;
            if(nums[mid]==target){
                ans[1] = mid;
                lo = mid+1; 
            }else if(nums[mid]<target){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return ans;
        
    }
    //max sum in configuration

    // search in a rotated sorted array leetcode 33
    public static int search(int[] arr , int target){
        int lo = 0, hi = arr.length -1;
        while(lo<=hi){
            int mid =(lo+ hi)/2;
            if(target == arr[mid]){
                return mid;
            }else if(arr[mid]>=arr[lo]){
                if(target< arr[mid] && target>=arr[lo]){
                    hi = mid-1;
                }else{
                    lo = mid+1;
                }

            }else if(arr[mid]<=arr[hi]){
                if(target > arr[mid] && target<= arr[hi]){
                    lo = mid+1;
                }else{
                    hi = mid-1;
                }
            }
        }
        return -1;
    }

    // find minimum in rotated sorted array
    public static int findMin(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        if (arr[lo] <= arr[hi]) {
            return arr[lo];
        }
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            } else if (arr[mid] < arr[mid - 1]) {
                return arr[mid];
            } else if (arr[lo] <= arr[mid]) {
                lo = mid + 1;
            } else if (arr[mid] <= arr[hi]) {
                hi = mid - 1;
            }
        }
        return -1;
    }


    //find rotation count 
    public static int findRotationCount(int[]arr){
        int lo = 0 , hi = arr.length-1;
        if(arr[lo]<=arr[hi]){
            return 0;
        }
        while(lo<=hi){
            int mid = (lo + hi)/2;
            if(arr[mid]> arr[mid+1]){
                return mid + 1;
            }else if(arr[mid]<arr[mid-1]){
                return mid; // mid-1 +1 :.=> mid
            }else if(arr[lo]<=arr[mid]){
                lo = mid+1;
            }else if(arr[mid]<=arr[hi]){
                hi = mid-1;
            }
        }
        return 0;
    }

    //median of two sorted array
    //TC-O(m+n)
    // sc-O(m+n)
    public static double getMedian(int [] a, int[]b){
        int i =0 , j =0 , k=0;
        int []merged = new int[a.length + b.length];
        while(i<a.length && j< b.length){
            
            if(a[i]<b[j]){
                merged[k] = a[i];
                i++;
                k++;
            }else{
                merged[k] = b[j];
                j++;k++;
            }

        }
        while(i<a.length){
            merged[k] = a[i];
            i++;
            k++;
        }
        while(j<b.length){
            merged[k] = b[j];
            j++;
            k++;
        }
        double median = 0.0;
        int mid = merged.length/2;
        if(merged.length%2==1){
            median = mid;
        }else{
            median = (merged[mid]+merged[mid-1])/2.0;
        }

        return median;
    }

    //optimised - pending

    // koko eating banana leetcode 875
    public static int getMinEatingSpeed(int [] piles , int h){
        int max = Integer.MIN_VALUE;
        for(int i =0 ; i< piles.length ;i++){
            max = Math.max(max,piles[i]);
        }
        if(piles.length == h){
            return max;
        }
        int lo = 0 , hi = max , speed = Integer.MAX_VALUE;
        while(lo<=hi){
            int mid = lo + (hi - lo) / 2; // to avoid overflow of values

            if (isPossible(piles, mid, h) == true) {
                speed = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return speed;

    }
    public static boolean isPossible(int[]piles , int sp ,int h ){
        int time = 0 ; 
        for(int i = 0 ;i < piles.length ;i++){
            time+= Math.ceil ((piles[i] * 1.0)/sp);
        }
        return time<= h;
    }


    //find smallest divisor given a threshold
    public static int findSmallestDivisor(int[] arr, int h){
        return getMinEatingSpeed(arr, h);

    }

    //choclate distribution
    public static int find(int[]arr , int n , int m){
        int ans = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i =0 ; i <= n-m ;i++){
            int min = arr[i];
            int max = arr[i + m-1];
            int gap = max - min;
            if(gap<ans){
                ans = gap;
            }
        }
        return ans;
    }

    // allocate minimum number of pages 
    // logn for binary search and in binary search we are performing a task n times of checking  :. => TC= O(nlogn) , sc = O(1)
    public static int getMinpages(int [] arr , int n , int m){
        int min = Integer.MIN_VALUE, sum = 0; 
        for(int i = 0; i< arr.length ;i++){
           min = Math.min(min , arr[i]);
           sum+=arr[i];
        }
        int lo= min  , hi = sum , res = -1;
        while(lo<=hi){
            int mid = (lo+hi)>>1;
            if(isPossibleforminpages(arr,mid,m)){
                res = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return res;
    }
    
    public static boolean isPossibleforminpages(int [] arr, int mid , int m){
        int allotStud = 1 , pages = 0 ;
        for(int i = 0 ; i< arr.length ;i++){
            if(arr[i]>mid){
                return false;
            }
            if(arr[i]+pages>mid){
                pages = arr[i];
                allotStud++;

            }else{
                pages+=arr[i];
            }
        }
        return allotStud>m ? false:true;
    }



















    public static void main(String[] args) {
        
    }
    
}
