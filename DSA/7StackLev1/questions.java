import java.util.LinkedList;

public class questions {
    public static boolean balancedBrackets(String str){
        LinkedList<Character>st = new LinkedList<>();
        for(int i = 0 ;i < str.length() ;i++){
            char ch = str.charAt(i);
            if(ch=='('|| ch=='['|| ch=='{')
            st.addFirst(ch);
            else if(ch==')'|| ch==']'|| ch=='}'){
                // no closing bracket
                if(st.size()==0) 
                   return false; 
                else if(ch==')'|| st.getFirst()!='(')
                   return false;
                else if(ch=='}'|| st.getFirst()!='{')
                   return false;
                else if(ch==']'|| st.getFirst()!='[')
                   return false;
                else 
                    st.removeFirst();   
            }

        }
        return st.size()==0;

    }

    public static boolean duplicatebrackets(String str){
        LinkedList<Character> st = new LinkedList<>();
        for(int i =0 ; i< str.length();i++){
            char ch = str.charAt(i);
            boolean hasLoopRun = false;
            while(st.size()!=0 && ch==')'&& st.getFirst()!='('){
                //stack's top has expression
                hasLoopRun = true;
                st.removeFirst(); // pop in terms of stack 
                
            }
            if(!hasLoopRun && ch==')') 
                return true; 
            else if(hasLoopRun) // loop ran but it stopped after   poping all arithm exp and alphabets
               st.removeFirst();
            else  // ch was alph or arithm exp or first char is '('
               st.addFirst(ch);
        }
        return false;
    }
    
    public static int[] nextGreater(int []arr){
        int n = arr.length;
        int [] ans = new int[n];
        Arrays.fill(ans,-1);
        LinkedList<Integer>st = new LinkedList<>();
        for(int i = 0; i< n;i++){

            while(st.size()!=0 && arr[st.getFirst()]<arr[i]){
                ans[st.removeFirst()]= arr[i];
            }
            st.addFirst(i); 

        }
        return ans;
    }

    public static int findCelebrity(int n){
    
        int celeb = 0;
        for(int i = 0 )

        
        return 0;

    }
}
