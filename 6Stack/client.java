import java.util.LinkedList;

public class client {

    public static void queuetest() throws Exception{
        queue q = new queue(10);
        for(int i = 0 ; i<=10;i++){
            q.add(i*10);
        }
        while(q.size()!=0){
            System.out.println(q.remove());
        }

    }

    public static void stacktest() throws Exception{
        stack st = new stack(10);
        for(int i = 0 ; i<=10;i++){
            st.push(i*10);
        }
        while(st.size()!=0){
            System.out.println(st.pop());
        }

    }

    public static void stackBehaviourUsingLL(){
        LinkedList<Integer> st = new LinkedList<>();
        for (int i = 0; i <= 10; i++) {
            st.addFirst(i*10);
        }
        while (st.size() != 0) {
            System.out.println(st.removeFirst());
        }
    }

    public static void main(String[] args) throws Exception{
        // i am using top function which throws exception so main is also infected now it can also throw exception 
        // stack st = new stack(10);
        // System.out.println(st.top());
     
        // for(int i = 0 ;i<100 ;i++){
            // st.push(10);           // should give exception as stack size is 5 only  here , but exception wont be shown unless and untill exception handling is done   
        // }

        //correct loop
        // for(int i = 0 ; i< 5 ;i++){
        //     st.push(i*10);
        // } 
        // while(st.size()!=0){
        //     System.out.println(st.pop());
        // }

        stackBehaviourUsingLL();
    }
    
}
