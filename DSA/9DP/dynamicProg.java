import java.util.ArrayList;

public class dynamicProg{    

    public static void printInc(int n){
        if(n==0){
            return ;
        }
        printInc(n-1);
        System.out.println(n);
    }
    
    public static void printDec(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printDec(n-1);
    }

    public static void printDecInc(int x){
        if(x==0){
            return ;
        }
        System.out.println(x);
        printDecInc(x-1);
        System.out.println(x);
    }

    public static void printEvenOdd(int a , int b){
        if(a>b){
            return;
        }
        if(a%2==0){
            System.out.println(a);
        }
        printEvenOdd(a+1, b);
        if(a%2==1){
            System.out.println(a);
        }

    }

    public static int factorial(int x , int ans){
        if(x ==0 ){
            return 1;
        }
        ans = x * factorial(x-1, ans);
        return ans ;
    }

    public static int power(int x , int n){
        if(n==0){
            return 1;
        }
        int ans = x * power(x , n-1);
        return ans ;
    }
    
    public static int powerLog(int x , int n){
        if(n==0){
            return 1;
        }
        int ans = powerLog(x, n/2) * powerLog(x , n/2);
       
        if(n%2==1){
            ans = ans * x;
        }
        return ans;
    }

    public static void printArr(int [] arr , int i ){
        if(i==arr.length){
            return;
        }
        System.out.println(arr[i++]);
        printArr(arr, i);
    }
    
    public static void printArrRev(int [] arr, int i ){
        if(i == arr.length ){
            return;
        }
        printArrRev(arr, i+1);
        System.out.println(arr[i]);
        
    }

    public static int maxOfArray(int [] arr , int i , int max){
        if(i==arr.length){
            return max;
        }
        max = Math.max(arr[i], max);
        max = maxOfArray(arr, i+1, max);
        return max;
    }

    public static int minOfArray(int []arr ,int i ,  int min){
        if(i == arr.length ){
            return min;
        }
        min = Math.min(min , arr[i]);
        min = minOfArray(arr, i+1, min);
        return min ;
    }

    public static int findData(int arr [] , int data , int i ){
        if(i==arr.length){
            return i;
        }

        if(arr[i] == data){
            return i;
        }

        int index = findData(arr, data, i+1);
        return index;
    }

    public static int firstIndex(int [] arr , int i  , int data){
        if(i==arr.length){
            return -1;
        }
        if(arr[i] == data ){
            return i ;
        }
        int pos  = firstIndex(arr, i+1, data);
        return pos;
    }

    public static int lastIndex(int [] arr , int i , int data , int ind){
        if(i == arr.length){
            return ind ;
        }
        if(arr[i] == data){
            ind = i;
        }
        int pos = lastIndex(arr, i+1, data, ind);
        return pos;
    }
    
    // subsequence of a string
    public static ArrayList<String> subsequence (String str , int idx){
        if(idx == str.length()){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch= str.charAt(idx);
        // str = str.substring(1);
        ArrayList <String> anslist = subsequence(str, idx+1);
        ArrayList <String> myAns = new ArrayList<>(anslist);
        for(String word : anslist){
            myAns.add(ch+word);
        }
        return myAns;

    }
    // count subsequence 
    public static int countSubSeq(String str , int idx , String asf , ArrayList<String>ans){
        if(idx == str.length()){
            ans.add(asf);
            return 1;
        }
        int count = 0 ; 
        count += countSubSeq(str, idx+1, asf, ans);
        count += countSubSeq(str, idx+1, asf+str.charAt(idx), ans);
        return count ;
    }

    // print keypad code
    public static String [] keys = {";","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> printKeypadCode(String str){
        if(str.length()==0){
           ArrayList<String> base = new ArrayList<>();
           base.add("");
           return base;
        }   

        char ch = str.charAt(0);
        String code = keys[ch -'0'];
        ArrayList<String>rres = printKeypadCode(str.substring(1));
        ArrayList<String>mres = new ArrayList<>();

        for(int i = 0 ; i < code.length() ;i++){
            for(String onecode:rres){
                mres.add(code.charAt(i)+ onecode);
            }
        }
        return mres;
    }

    public static ArrayList<String>decodeWays(String str){
        if(str.length()==0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        if(str.charAt(0)=='0'){
            return new ArrayList<>();
        }
        char ch1 = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String>rres = decodeWays(ros);
        ArrayList<String>mres = new ArrayList<>();
        for(String word : rres){
            mres.add((char)('A' + ch1 - '1') + word);
        }
        if(str.length()>1){
            int num = (ch1-'0') * 10 + (str.charAt(1)-'0');
           
            if(num<=26){
                ArrayList<String> rres2 = decodeWays(str.substring(2));
                // ArrayList<String> mres = new ArrayList<>();
                for (String word : rres2) {
                    mres.add((char)('A' + num - 1) + word);
                }
            }
        }
        return mres;
    }
    public static void subsequencePrinting(String str, String asf){
        if(str.length()==0){
            System.out.println(asf);
            return;
        }


        char ch = str.charAt(0);
        String ros = str.substring(1);
        
        subsequencePrinting(ros, asf);
        subsequencePrinting(ros, asf+ch);

    }

    // count stair path and print stair path
    public static int stairPath(int n , String ans){ // bottom to top approach 
        if(n==0){
            System.out.println(ans);
            return 1 ;
        }

        int count = 0 ; 
        for(int jump =1 ; jump <= 3 && (n - jump >=0); jump++ ){
            count += stairPath(n-jump , ans+" "+jump);
        }
        return count ;
    }
    //// top to bottom approach 
    public static ArrayList<String> stairPath(int n){
        if(n==0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base ;
        }
        ArrayList<String>myAns = new ArrayList<>();
        for(int jump = 1; jump<= 3 &&(n - jump >= 0 );jump++){
            ArrayList<String> ans = stairPath(n-jump);
            for(String s : ans){
                myAns.add(jump + s);
            }
        }
        return myAns;
    }

    // board Path
    static int num = 0 ;
    public static int boardPath(int n , String ans){
        if(n==0){
            ++num;
            System.out.println(num+" "+ans);
            return 1;
        }
        int count = 0 ; 
        for(int dice = 1; dice <= 6 && (n- dice >= 0 );dice++){
            count += boardPath(n-dice, ans+" "+dice);
        }
        return count ;
    }

    public static int mazePathHVD(int sr , int sc , int er , int ec){
        if(sr==er && er==ec){
            return 1;
        }
        int count = 0; 
        if(sc+1<= ec){
            count+= mazePathHVD(sr, sc+1, er, ec);
        }
        if(sr+1<= er && sc+1 <=ec){
            count+=mazePathHVD(sr+1, sc+1, er, ec)
        }
        if(sr+1 <= er){
            count+=mazePathHVD(sr+1, sc, er, ec);
        }
        return count;
    }

    public static int printMazePath(int sr , int sc , int er , int ec , String ans){
        if(sr== er && sc == ec){
            System.out.println(ans);
            return 1;
        }
        int count = 0 ; 
        if(sr+1<=er){
            count+=printMazePath(sr+1, sc, er, ec, ans+"v");
        }
        if(sc+1<=ec){
            count+=printMazePath(sr, sc+1, er, ec, ans+"h");
        }
        if(sr+1<=er && sc + 1 <= ec){
            count+=printMazePath(sr+1, sc+1, er, ec, ans+"d");
        }
        return count;
    }

    


    public static void main(String[] args){
        // printDec(7);
        int x = 9;

        // printInc(x);
        // printDecInc(x);
        // printEvenOdd(2, 9);
        // System.out.println(factorial(5 , 0)); // 120 correct
        // System.out.println(power(2 , 4)); 
        // System.out.println(powerLog(3, 17));

        int arr [] ={1,2,3,4,5,6,7,8,9,10} ;
        // printArr(arr ,0 );
        // printArrRev(arr , 0);
        // System.out.println(maxOfArray(arr , 0 ,Integer.MIN_VALUE));
        // System.out.println(minOfArray(arr , 0 , Integer.MAX_VALUE));
        // int pos = findData(arr,-11, 0);
        // System.out.println(pos == arr.length ? "Data Not Found" : pos);
        int arr2[] ={1,2,2,3,3,4,4,4,4,5,5,6,6,7,7,3,8,9,20}; 
        // System.out.println(firstIndex(arr2 , 0 , 3));
        // System.out.println(lastIndex(arr2 , 0 , 20, -1));
        String str = "abc";
        // ArrayList <String> ans = subsequence(str,0);
        // for(String s : ans){
        //     System.out.println(s);
        // }
        // ArrayList<String>subsAns = new ArrayList<>();
        // System.out.println(countSubSeq(str,0,"", subsAns));
        // ArrayList<String> ans = printKeypadCode("456");
        // int i = 0 ; 
        // for(String s : ans){
        //     System.out.println(++i +" " +s); // 36 different possible string  combination
        // }
        char ch1 = '1' , ch2 = '2';
        char ch3 = (char) (ch1 +ch2);
        // System.out.println();// 99 i.e '1'(49) + '2'(50)
        // char ch4 = 'A';
        // char ch5 = 'Z';
        // System.out.println(ch4<ch5?"yes":"no"); // yes
        
        // ArrayList<String> ans3 = decodeWays("11208");
        // int i = 0 ;
        // for(String s : ans3){
        //     System.out.println(++i +" " +s);
        // }

        // subsequencePrinting("abc","");
        // System.out.println(stairPath(5,""));
        System.out.println(boardPath(10,""));
        
    }

}