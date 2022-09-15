public class practise{
    public static void pppp(int a) {
        System.out.println("hi " + a);
        System.out.println("by " + a);
    }
    public static void ppp(int a) {
        System.out.println("hi " + a);
        pppp(a + 1);
        System.out.println("by " + a);
    }
    public static void pp(int a) {
        System.out.println("hi " + a);
        ppp(a + 1);
        System.out.println("by " + a);
    }
    public static void p(int a){
        System.out.println("hi "+a);
        pp(a+1);
        System.out.println("by "+a);
    }
    

    public static void printIncreasing(int b){
        if(b==0){
            return ;
        }
        printIncreasing(b-1);
        System.out.println(b);
    }

    public static void printDecreasing(int a){
        if(a==0){
            return;
        }
        System.out.println(a);
        printDecreasing(a-1);
    }
    
    public static void printDecreasingIncreasing(int a){
        if(a==0){
            System.out.println(a);
            return ;
        }
        System.out.println(a);
        printDecreasingIncreasing(a-1);
        System.out.println(a);
    }

    public static void evenOdd(int a , int b){
        if(a==b){
            System.out.println(a);
            return ;
        }
        if(a%2==0){
            System.out.println(a);
        }
        evenOdd(a+1, b);
        if(a%2!=0){
            System.out.println(a);
        }
    }

    public static int factorial(int a){
        if(a==0){
            return 1;
        }
        int ans = factorial(a-1) * a;
        return ans;
    }
    
    public static int power(int x , int n){
        if(n==0){
            return 1;
        }
        int ans = x * power(x, n-1);
        return ans ;
    }

    public static int powerLogrithmic(int x ,int n){
        if(n==0){
            return 1;
        }
        int quot = n / x ;
        // int ans = powerLogrithmic(x, quot) * powerLogrithmic(x, quot); // or (faster)
        int ans = powerLogrithmic(x, quot) ;
        ans = ans* ans;         
        if(n%x!=0){
            ans *=x;
        }
        return ans ;

    }

    public static void printArr(int [] arr , int i ){
        if(i==arr.length){
            return;
        }
        System.out.println(arr[i]);
        printArr(arr, i+1);
    }

    public static void printArrRev(int [] arr, int i){
        if(i == arr.length){
            return ;
        }
        printArrRev(arr, i+1);
        System.out.println(arr[i]);
    }
    
    public static int arrMax(int [] arr , int i){
        if(i==arr.length){
            return Integer.MIN_VALUE;
        }
        int maxElem = arrMax(arr, i+1);
        maxElem = Math.max(maxElem , arr[i]);
        return maxElem;
    }
    
    public static int arrMin(int [] arr , int i ){
        if(i==arr.length){
            return Integer.MAX_VALUE;
        }
        int min = arrMin(arr, i+1);
        min = Math.min(min , arr[i]);
        return min ;
    }

    public static int findData(int []arr,int i , int key){
        if(i== arr.length){
            return -1;
        }

        if(arr[i]== key){
            return i;
        }
        int index = findData(arr, i+1, key);

        return index;

    }
    
    public static int firstIndex(int [] arr , int i , int key){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]== key){
            return i;
        }
        int index = firstIndex(arr, i+1, key);
        return index;
    }

    public static int lastIndex(int [] arr , int i , int key,int ans){
        if(i==arr.length){
            return ans;
        }
        if(arr[i]== key){
            ans = i;
        }
        int index = lastIndex(arr, i+1, key, ans);
        return index;
    }
    public static void main(String[]args){
        
        // p(1);
        // print increasing 
        // printIncreasing( 4);

        // printDecreasing
        // printDecreasing(4);

        // increaing decreasing
        // printDecreasingIncreasing(4);

        // even and odd numbers 
        // evenOdd(2,9);

        // factorial 
        // System.out.println(factorial(4));
        
        // power calculation 
        // System.out.println(power(2, 3));
        
        // power logrithmic 
        // System.out.println(power(3, 5));

        int []arr = {2,3,4,5,6,7,8,3,4,12,2,7,8,56,4,5, 1};
        // printArr(arr,0);

        // print arr in reverse 
        // printArrRev(arr, 0);

        // max in array 
        // System.out.println(arrMax(arr, 0));
        
        // min in array 
        // System.out.println(arrMin(arr, 0));

        // find data in array 
        // System.out.println(findData(arr,0,4));

        //firstIndex 
        // System.out.println(firstIndex(arr, 0, 4));

        // last occurence
        // System.out.println(lastIndex(arr,0,4,-1));     
        
        callfunctions();
    }

}