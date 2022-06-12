package adapters;
import java.util.LinkedList;
public class stackUsingQueuePush{
    LinkedList <Integer> q = new LinkedList<>();
    LinkedList <Integer> temp = new LinkedList<>();

    int topElem = 0;

    public stackUsingQueuePush(){

    }
    public void push(int x){
        topElem = x;
        q.addLast(x);
    }

    public int pop(){
        while(q.size()>1){
            temp.addLast(q.removeFirst());
        }
        int rElem = q.removeFirst();
        
        while(temp.size()!=0) push(temp.removeFirst());
        return rElem;
    }
    public int size(){
        return q.size();
    }
    public int top(){
        return topElem;
    }
    public boolean empty(){
        return q.size()==0;
    }


}