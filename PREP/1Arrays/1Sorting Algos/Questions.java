import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Questions {

    public static void swap(int [] arr ,int i , int j){
        int temp = arr[i];
        arr[i] = arr[j] ;
        arr[j] = temp;
    }

    //kth smallest element
    //1. sort then return arr[k-1];
    // 2. priority queue(Max type) method 
    public static int kthsmallestElement(int[] arr , int k){
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int i = 0; i< arr.length ;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.poll();
    }

    // sort 0, 1 , 2
    public static void sort012(int []arr){
        int i = 0 , j = 0 , k = arr.length-1;
        while(j<=k){
            if(arr[j]==0){
                swap(arr,i,j);
                i++;j++;
            }else if(arr[j]==1){
                j++;
            }else{
                swap(arr,j,k);
                k--;
            }
        } 
    }

    //wave array
    public static void convertToWaveArray(int[]arr){
        int i =0 , j = 1 ;
        while(i<arr.length && j<arr.length){
            swap(arr,i,j);
            i+=2;
            j+=2;
        }
    }

    // anagrams matching  : 
    // 1 . hashmap freq map of a , then decrease freq from b in same hashmap(after checking if character of b is even present in hashmap & if not return false) , then check if there is a character corresponding to which we have a freq = -1;
    // 2 . by stringBuilder method
    public static boolean isAnagram(String a , String b){
        if(a.length()!= b.length()) return false ;

        StringBuilder sb = new StringBuilder(a);
        
        for(int i = 0; i<b.length() ;i++){
            char ch = b.charAt(i);
            if(sb.indexOf(Character.toString(ch))==-1) return false;
            else{
                sb.deleteCharAt(sb.indexOf(Character.toString(ch)));
            }
        }
        return true;
    }

    // three way partitioning 
    // 1 do it with dnf algo (dutch national flag algo)
    public static void threewayPartitioning(int [] arr , int a , int b ){
        int i = 0 , j = 0 , k = arr.length-1;
        while(j<=k){
            if(arr[j]<a){
                swap(arr,j,i);
                i++;
                j++;
            }else if(arr[j]<=b){
                j++;
            }else{
                swap(arr,j,k);
                k--;
            }
        }
    }

    // count triplet
    // 1 . sort the array ->form all possible pairs and check in hashset(which has all the elements of the array) , whether or not the sum is present in it (if yes count++)
    public static int countTriplets1(int [] arr){
        Arrays.sort(arr);
        HashSet<Integer>hs = new HashSet<>();
        for(int i = 0; i< arr.length ;i++){
            hs.add(arr[i]);
        }
        int n = arr.length , count= 0;;
        for(int i = 0; i< n-2 ;i++){
            for(int j = i+1 ;j<n-1;j++){
                int sum = arr[i] + arr[j];
                if(hs.contains(sum))count++;
            }
        }
        return count ;
    }
    //2 . 3 Pointer approach 
    // fixing one pointer at a position in array(eithr first or last) then we another two pointers used in locating the pair in the array 
    public static int countTriplets(int[] arr){
        int n = arr.length , count=0 ;
        Arrays.sort(arr);
        for(int i = n-1 ;i>=0 ;i--){
            int j = 0, k = i-1;
            while(j< k ){
                if(arr[i]==arr[j]+arr[k]){
                    // System.out.println(arr[j]+" "+arr[k]+" "+arr[i]);
                    count++;
                    j++;k--;
                }else if (arr[i]>arr[j]+arr[k]){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return count ;
    } 
    
    // find triplets with sum = 0 ; 
    public static boolean findTriplet(int[]arr){
        int n = arr.length;
        for(int i = n-1 ;i>= 0 ;i--){
            int j = 0, k = i-1;
            while(j<k){
                int sum = arr[i] +arr[j] +arr[k];
                if(sum==0){
                    return true;
                }else if(sum>0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return false;
    }
    
    //minimum distance between two numbers in given array
    public static int minDistance(int [] arr , int a , int b){
        int start = -1 , end = -1, dist = 0;
        for(int i = 0; i< arr.length ;i++){
            if(arr[i] == a) start = i;
            if(arr[i] == b) end = i ;
            if(start!= -1 && end == -1){
                dist = Math.min(dist ,Math.abs(start-end));
            }
        }
        return dist;
    }
    //minimize the sum arr[i]*i; -> it is given that we can rearrange the array 
    public static int minimizesum(int arr[]){
        Arrays.sort(arr);
        int sum =0 ;
        for(int i = 0 ; i<arr.length ;i++){
            sum+=(arr[i]*i);
        }
        return sum;
    }
    
    //check if 2 arrays are equal or not 
    public static boolean isEqual(int [] arr1 , int [] arr2 ){
        HashMap<Integer,Integer>hm = new HashMap<>();

        for(int i = 0; i< arr1.length ;i++){
            hm.put(arr1[i],hm.getOrDefault(arr1[i],0)+1);
        }
        for(int i = 0; i< arr2.length ;i++){
            if(!hm.containsKey(arr2[i])) return false;
            if(hm.get(arr2[i])==1) hm.remove(arr2[i]);
            else
            hm.put(arr2[i],hm.get(arr2[i])-1);
        }
        // for(int i 0 ; i< arr1.length ;i++){
        //     for(int i )
        // }
        return false;

    }

    public static void main(String[] args){
        int arr[] = { 5, 32, 1, 7, 10, 50, 19, 21, 2 };
        // int ans = kthsmallestElement(arr, 4);
        // System.out.println(ans);
        int [] a ={1,0,0,1,2,1,0,2,1,0,1,2};
        // sort012(a);
        System.out.println(countTriplets(arr));
        // System.out.println(isAnagram("aabb","bbaa"));
        // for(int i = 0; i< a.length ;i++){
        //     System.out.println(a[i]);
        // }
    }
    
}
