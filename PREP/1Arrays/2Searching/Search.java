import java.util.Arrays;

public class Search{

    public static int binarySearch(int[]arr , int key ){
        
        int low = 0 , high = arr.length-1 ;
        while(low<=high){
            int mid = (low + high)/2;
            if(arr[mid] == key){
                return mid;
            }else if (arr[mid]>key){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
    public static void main(String [] args){
        int arr[] = {1,2 , 23,34,37,45,46,54,57,58,60,171,234};
        int ans = binarySearch(arr, 234);
        System.out.println(ans);
    }
}