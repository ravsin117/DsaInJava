public class array {

    public static void findMinMax(int [] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length ;i++){
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println("Max is "+max+"& Min is:"+min);
    }

    public static void main(String args[]){

        int arr[] ={2,3,4,523,4,45,67,34,2,1,-1,5,0,90};
        findMinMax(arr);
    }
    
}
