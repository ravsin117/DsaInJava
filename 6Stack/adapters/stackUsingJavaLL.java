package adapters;
import java.util.LinkedList;

public class stackUsingJavaLL {
    
    public static class stack{
        private LinkedList<Integer> ll = new LinkedList<>();

        public int size(){
            return this.ll.size();
        }
        public boolean isEmpty(){
            return ll.isEmpty();
        }
        public void add(int data){
            ll.addFirst(data);
        }
        public int top(){ // just returns
            return ll.getFirst();
        }
        public int pop(){ // removes and returns
            return ll.removeFirst();
        }
    }

    public static void main(String[]args){

    }
}
