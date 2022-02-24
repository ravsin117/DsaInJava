package adapters;
import java.util.LinkedList;
public class queueUsingStackPop {
    LinkedList<Integer>st = new LinkedList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    // O(N)
    public void push(int data) {
        transfer(st, temp);
        st.addFirst(data);
        transfer(temp,st);
    }

    private void transfer(LinkedList<Integer> st1, LinkedList<Integer> st2) {
        while (st1.size() != 0) {
            st2.addFirst(st1.removeFirst());
        }
    }

    // O(1)
    public int pop() {
        return st.removeFirst(); // poped elem
    }

    public int peek() {
        return st.getFirst();
    }

    public boolean empty() {
        return st.size() == 0;
    }

}
