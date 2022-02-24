package adapters;
import java.util.LinkedList;

public class queueUsingJavaLL {

    public static class queue {
        private LinkedList<Integer> ll = new LinkedList<>();

        public int size() {
            return ll.size();
        }

        public boolean isEmpty() {
            return ll.isEmpty();
        }

        public void add(int data) {
            ll.addLast(data);
        }

        public int peek() { // just returns
            return ll.getFirst();
        }

        public int remove() { // removes and returns
            return ll.removeFirst();
        }
    }

    public static void main(String[] args) {
 
        queue q = new queue();
        q.add(10);
        q.add(20);
        // q.peek();
        q.add(30);

        while (q.size() != 0) {
            System.out.println(q.remove());
        }

    }
}
