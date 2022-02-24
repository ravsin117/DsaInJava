public class queue {
    private int arr[];
    private int maxSize;
    private int size;
    private int front ;
    private int back;

    private void intialize(int len){
        this.arr = new int[len];
        this.maxSize = len;
        this.size=0;
        this.front =
        this.back=0;

    }
    
    public queue(){
        intialize(5);
    }

    public queue(int size){
        intialize(size);
    }

    public int size(){

        return this.size;
    }
    public boolean isEmpty(){
        
        return this.size==0;

    }

    private void queueIsEmptyException() throws Exception {
        // throw exception-> shows this function is infected
        // java has its own inbuilt exception
        // my exceptions are not known to all and if we write throws exception in front
        // of function so a third person understands that the function can throw
        // exception that i have built myself
        // exception is recursive , top function os also infected

        if (this.size == 0) {
            throw new Exception("queueIsEmptyException: -1");
        }
    }

    private void queueOverFlowException() throws Exception {
        if (this.size == this.maxSize)
            throw new Exception("queueOverFlowEception: -1");
    }

    private void add_(int data){
        this.arr[this.back]= data;
        this.back = (this.back+1) % this.maxSize;
        this.size++;
    }
    public void add(int data)throws Exception{
        queueOverFlowException(); 
        add_(data);
    }

    public int peek()throws Exception{
        queueIsEmptyException();
        return this.arr[this.front];
    }
    
    private int remove_(){
        int rv =this.arr[this.front];
        this.arr[this.front]=0;
        this.front = (this.front+1) % this.maxSize;
        this.size++;
        return rv;
    }
    public int remove() throws Exception{
        queueIsEmptyException();
        int rv = remove_();
        return rv;

    }

}
