public class test{

    public static int solve(String s){

        int sum = 0 , alphCount = 0 ; 
        for(int i = 0; i< s.length() ;i++){
            char ch = s.charAt(i);
            if(ch>=48 && ch<= 57){
                sum += ch-'0';
            }else if((ch >= 65 && ch <= 90 )||( ch >= 97 && ch<= 122)){
                alphCount++;
            }
        }
        // System.out.println(sum);
        // System.out.println(alphCount);
        float a = (float)sum;
        float b = (float)alphCount;
        float ansF = a/b;
        // System.out.println(ansF);
        int ansl = sum/alphCount;
        // System.out.println(ansl);
        if(ansF -0.5 <ansl){
            System.out.println(ansl);
            return 1;
        }
        System.out.println(ansl+1);
        return 1;
    }

    public static void main(String [] args){

        String str = "one number*1*";
        // solve(str);
        char ch = '3'- '2' ;
        // if(ch>=48){
            // System.out.println((int)ch);
        // }
        int ans = 32/17;
        System.out.println(ans);
    }
}