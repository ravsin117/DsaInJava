public class client {
    public static void main(String[] args) throws Exception{
        // i am using top function which throws exception so main is also infected now it can also throw exception 
        stack st = new stack();
        // System.out.println(st.top());
     
        // for(int i = 0 ;i<100 ;i++){
            // st.push(10);           // should give exception as stack size is 5 only  here , but exception wont be shown unless and untill exception handling is done   
        // }

        //correct loop
        for(int i = 0 ; i< 5 ;i++){
            st.push(10);
        }
    }
    
}
