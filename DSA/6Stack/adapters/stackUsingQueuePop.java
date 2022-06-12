package adapters;

import java.util.LinkedList;

public class stackUsingQueuePop{

    LinkedList<Integer> q = new LinkedList<>();
    LinkedList<Integer> t = new LinkedList<>();

    int topElem = 0 ;

    // default constructor
    public stackUsingQueuePop(){

    }

    private void transfer(LinkedList<Integer> st1, LinkedList<Integer> st2) {
        while (st1.size() != 0) {
            st2.addLast(st1.removeFirst());
        }
    }

    public void push(int data){
        t.addLast(data);
        transfer(q,t);
        LinkedList <Integer>temp = q;
        q = t;
        t = temp;

    }

    public int pop(){
        return q.removeFirst();
    }
    public int top(){
        return q.getFirst();
    }
    



}