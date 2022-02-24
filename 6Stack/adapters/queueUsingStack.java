package adapters;

import java.util.LinkedList;

public class queueUsingStack{
    
    LinkedList<Integer>st = new LinkedList<>();
    LinkedList<Integer>temp = new LinkedList<>();
    int peekElem =0 ; 
    // O(1)
    public void push(int data){
        if(st.size()==0) peekElem = data;
        st.addFirst(data);
    }

    private void transfer(LinkedList<Integer>st1 ,LinkedList<Integer>st2){
        while(st1.size()!=0){
            st2.addFirst(st1.removeFirst());
        }
    }

    //O(n)
    public int pop(){
        // transfering
        transfer(st, temp);
        int rElem = temp.removeFirst();
        // transfering back
        while(temp.size()!=0) this.push(temp.removeFirst());
        return rElem; // poped elem
    }

    public int peek(){
        return peekElem;
    }
    
    public boolean empty(){
        return st.size()==0;
    }



}