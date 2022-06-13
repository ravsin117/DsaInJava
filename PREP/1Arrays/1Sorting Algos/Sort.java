public class Sort{


    public static void swap(int [] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // bubble sort 
    public static void bubbleSort(int[]arr){
        int n = arr.length;
        for(int i  =0 ; i< n-1 ; i++){
            boolean swapped = false;
            for(int j = 0 ; j<n-1-i ;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                    swapped = true;
                }
            }
            if(swapped==false){
                break;
            }
        }
    }

    // insertion sort 
    public static void insertionSort(int [] arr){
        int n = arr.length ;
        for(int i = 1 ; i < n ;i++){
            int temp = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
    //selection sort algo
    public static void selectionSort(int[]arr){
        int n = arr.length ;
        for(int i = 0; i< n-1 ;i++){
            int min = i ;
            for(int j = i+1 ; j<n ;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            if(min!= i)
            swap(arr,i , min);
        }
    }
    //quick sort -> partition exchange sort 
    public static void quickSort(int [] arr , int lb , int ub){

        if(lb<ub){
            int locationOfPivot = partition(arr,lb,ub);
            quickSort(arr, lb, locationOfPivot-1);
            quickSort(arr, locationOfPivot+1, ub);
        }
    }
    public static int partition(int [] arr , int lb ,int ub){
        int pivot  = arr[lb];
        int start = lb , end = ub ;
        while(start<end){
            while(start< arr.length && arr[start]<=pivot){
                start++;
            }
            while(end>=0 && arr[end]>pivot){
                end--;
            }
            if(start<end)
            swap(arr, start, end);
        }
        swap(arr, lb , end);
        return end ; // location of pivot element 
    }

    //merge sort
    public static void mergeSort(int[]arr, int lb ,int ub){
    
        if(lb<ub){
            int mid = (lb+ub)/2;
            mergeSort(arr, lb, mid);
            mergeSort(arr, mid+1, ub);
            mergetwoSortedArray(arr,lb , mid , ub);
                   
        }
    }
    public static void mergetwoSortedArray(int [] arr , int l , int m , int r){
        int n1 = m - l+1;
        int n2 = r - m;
        int [] left = new int[n1];
        int []right = new int[n2];
        for(int i = 0; i < n1 ;i++){
            left[i] = arr[l+i];
        }
        for(int i =0; i < n2 ;i++){
            right[i] = arr[m+1+i];
        }        
        int i = 0 , j = 0 , k =l;

        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                arr[k] = left[i];
                i++;
                k++;
            }else{
                arr[k] = right[j];
                j++;
                k++;
            }

        }
        while(i<left.length){
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j<right.length){
            arr[k] = right[j];
            j++;
            k++;
        }
    
    }
    public static void main(String[]args){
        int [] arr = {15,16,6,8,5,100,45,32,45,78,46,23};
        int n = arr.length;
        // bubbleSort(arr);
        // insertionSort(arr);
        // selectionSort(arr);
        // quickSort(arr, 0, n-1);
        mergeSort(arr, 0, n-1);
        for(int i =0; i< arr.length ;i++){
            System.out.println(arr[i]);
        }
    }
}