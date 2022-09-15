import java.util.ArrayList;

public class practise2 {
    
    // get subsequence 
    public static ArrayList<String> getss(String str , int i){
        if(i==str.length()){
            ArrayList<String>base = new ArrayList<>();
            base.add("");
            return base ;
        }
        char ch = str.charAt(i);
        ArrayList<String> ans = getss(str, i+1);
        ArrayList<String>myAns = new ArrayList<>(ans);

        for(String word : ans){
            myAns.add(ch+word);
        }
        return myAns;
    }

    //get all indexes of a key
    public static int[] getIndexes(int []arr ,int i,  int count , int key){
        if(i==arr.length){
            int [] base = new int[count];
            return base ;
        }
        if(arr[i]==key){
            count++;
        }
        int ans [] = getIndexes(arr, i+1, count, key);
        if(arr[i] == key){
            ans[count-1]= i;
        }
        return ans ; 
    }

    public static int subsequenceCount(String str ,String ans, int i){
        if(i==str.length()){
            System.out.println(ans);
            return 1;
        }
        int count = 0 ; 
        count += subsequenceCount(str, str.charAt(i) +ans , i+1);
        count+=subsequenceCount(str, ans, i+1);
        return count;
    }
    
    public static String [] keys = {";","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> getKeypadCode(String s){
        if(s.length()==0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base ;
        }
        
        char ch = s.charAt(0);
        String codes = keys[ch-'0'];
        String ros = s.substring(1);
        ArrayList<String> ans = getKeypadCode(ros);
        ArrayList<String>myAns = new ArrayList<>();
        
        for(int i =0 ; i < codes.length() ;i++){
            char letter = codes.charAt(i);
            for(String word : ans){
                myAns.add(letter+word);
            }
        }
        return myAns;

    }
    
    // decode ways 
    public static ArrayList<String> decodeWays(String s){
        if(s.length()==0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base ;
        }
        if(s.charAt(0)=='0') return new ArrayList<>();
        char ch = s.charAt(0);
        String ros = s.substring(1);
        ArrayList<String>ans = decodeWays(ros);
        ArrayList<String>myAns = new ArrayList<>();

        for(String word : ans){
            myAns.add((char)('a' + ch - '1')+word);
        }
        if(s.length()>1){
            int num = ((ch -'0') * 10) + (s.charAt(1) -'0') ;
            if(num<=26){
                String ros2 = s.substring(2);
                ArrayList<String>myAns2 = decodeWays(ros2);
                for(String word : myAns2){
                    myAns.add((char)('a' + num -1)+word);
                }
            }
        }    
        return myAns;
    }

    //subsequence printing 
    public static void subsequence(String s,String ans){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(0);
        String ros = s.substring(1);
        subsequence(ros,ans + ch);
        subsequence(ros, ans); 
    } 

    // nokia key printing
    public static void keyPrinting(String str ,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        String code = keys[ch-'0'];
        String ros = str.substring(1);
        
        for(int i =0; i < code.length() ;i++){
            keyPrinting(ros , ans + code.charAt(i));
        }
    }

    // counting ways to come down to 0th stair
    public static int countStairPath(int n){
        if(n==0){
            return 1;
        }
        int count = 0 ; 
        for(int jump = 1 ; jump<4 && n -jump>=0 ;jump++){
            count+= countStairPath(n-jump);
        }
        return count ;
    }
    
    // printing ways to come down to 0th stair
    public static int printStairPath(int n , String ans){
        if(n==0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0 ; 
        for(int jump = 1; jump < 4 && n- jump>=0 ;jump++){
            count+= printStairPath(n-jump, ans+jump);
        }
        return count;
    }

    public static int boardPathProblem(int n , String ans){
        if(n==0){
            System.out.println(ans);
            return 1;
        }

        int count = 0 ;
        for(int dice = 1 ; dice<=6 && n- dice>=0 ;dice++){
            count+=boardPathProblem(n-dice, ans+dice);
        }
        return count;
    }

    public static int countMazePath(int sr , int sc , int er , int ec){
        if(sr==er && sc==ec){
            return 1;
        }

        int count = 0 ; 
        if(sc+1<=ec){
            count+=countMazePath(sr, sc+1, er, ec);
        }
        if(sr+1<=er && sc+1<=ec){
            count+=countMazePath(sr+1, sc+1, er, ec);
        }
        if(sr+1<=er){
            count+=countMazePath(sr+1, sc, er, ec);
        }
        return count;

    }

    // count maze Path sol2 
    public static int countMazePaths2(int [][]dir , int sr , int sc , int er , int ec){
        if(sr==er && sc==ec){
            return 1;
        }

        int count = 0; 
        for(int i = 0 ; i <3 ;i++){
            int row = sr+dir[i][0];
            int col = sc+dir[i][1];
            if(row<=er && col<=ec)
            count += countMazePaths2(dir, row, col, er, ec);
        }
        return count ;
    }
    
    // for printing the maze path 
    public static void printMazePath(int sr , int sc , int er , int ec , String ans){
        if(sr==er && sc ==ec){
            System.out.println(ans);
            return ;
        }

        if(sr+1<=er){
            printMazePath(sr+1, sc, er, ec, ans+"V");
        }
        if(sr+1<=er && sc+1<=ec){
            printMazePath(sr+1, sc+1, er, ec, ans+"D");
            
        }
        if(sc+1<=ec){
            printMazePath(sr, sc+1, er, ec, ans+"H");
        }
    }
    
    //for printing maze Path sol 2
    public static void printingMazePath2(int []dir , int sr , int sc , int er , int ec, int ans){


        for(int i = 0; i< 3 ;i++){
            
        }
    }

    // maze path with jumps of 1,2,3 .. blocks allowed 
    public static int mazePathMultiJump(int sr , int sc , int er , int ec , String ans){
        if(sr==er && sc==ec){
            System.out.println(ans);
            return 1;
        }

        int count = 0 ;
        for(int jump = 1;jump + sr<=er ;jump++){
            count+= mazePathMultiJump(sr+jump, sc, er, ec, ans+"v"+jump);
        }
        for(int jump = 1;jump + sr<=er && jump + sc <=ec ;jump++){
            count+= mazePathMultiJump(sr+jump, sc+jump, er, ec, ans+"d"+jump);
        }
        for(int jump = 1;jump + sc<=ec ;jump++){
            count+= mazePathMultiJump(sr, sc + jump, er, ec, ans+"h"+jump);
        }
        return count ;
    }

    public static void main(String [] args){

        int [] arr = {2,8,8,2,8,6};
        // all indices of a key in array 
        // int [] ans = getIndexes(arr,0, 0, 8);
        // for(int i : ans){
        //     System.out.println(i);
        // }
            
        // subsequence of string - abc =>[, c, b, bc, a, ac, ab, abc]
        // System.out.println(getss("abc", 0));  

        // count subsequence
        // System.out.println(subsequenceCount("abc","" , 0));

        // print keypad code 
        // System.out.println(getKeypadCode("456"));

        // decode ways 
        // System.out.println(decodeWays("11106"));
        // System.out.println(decodeWays("11023"));

        // subsequence printing
        // subsequence("abc","");

        // keypad code printing 
        // keyPrinting("467", "");

        // count no of ways in which you can travel the stairpath with 1,2,3 jumps from a given nth stair
        // System.out.println(countStairPath(5));
        
        // stair path jumping -> printing all possible jump patterns 
        // System.out.println(printStairPath(3,""));

        // dice board path problem 
        // System.out.println(boardPathProblem(10 , ""));

        // maze path with HVD jumps 
        // total no of paths 
        // System.out.println(countMazePath(0,0,2,2));

        // printing maze Path 
        // printMazePath(0, 0 ,2, 2,"");

        int dir[][] = {{0,1},{1,0},{1,1}};
        // count no of paths 2
        // System.out.println(countMazePaths2(dir ,0,0,2,2));

        // if multiple jumps are allowed to take in maze in all directions 
        System.out.println(mazePathMultiJump(0,0,1,1,""));

            
    }
}
