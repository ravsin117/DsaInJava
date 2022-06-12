public class gfgcurated {

    //-> carrying a sum which is -ve will decrease sum and we want greatest sum therefore we wont consider subbarayy with -ve sum 
    // for any subbarray that gives us positive sum we consider it and make changes if it is greater than the maxsum till now 
    public static int kadane(int [] arr){
        int sum = 0 , max = arr[0];
        for(int i =0 ;i < arr.length ;i++){
            sum+=arr[i];
            if(sum>max){
                max = sum;
            }
            if(sum<0){
                sum = 0 ; 
            }
        }
        return max;
    }
}
