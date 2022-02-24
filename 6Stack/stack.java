public class stack{

    private int size;
    private int arr[];
    private int tos;
    private int maxSize; 
    
    //self defined constructor
    protected void initialize(int len){
        this.arr = new int[len];
        this.tos = -1; // top of stack
        this.size = 0;  
        this.maxSize=len;
    }
    
    //default constructor --> stack st = new stack();
    public stack(){
        initialize(5);
    }
    
    //constructor
    public stack(int size){
        initialize(size);
    }

    private void stackIsEmptyException() throws Exception{
        // throw exception-> shows this function is infected 
        // java has its own inbuilt exception 
        // my exceptions are not known to all and if we write throws exception  in front of function so a third person understands that the function can throw exception that i have built myself
        // exception is recursive , top function os also infected 

        if(this.size==0){
            throw new Exception("stackIsEmptyException: -1");
        }
    }

    private void stackOverFlowException() throws Exception{
        if(this.size==this.maxSize)
        throw new Exception("stackOverFlowEception: -1");
    }

    //O(1)
    public int size(){
        return this.size;
    }

    // O(1)
    public boolean isEmpty(){
        return this.size==0;
    }

    // O(1)
    private void push_(int data){
        this.arr[++this.tos]= data;
        this.size++;
    }

    public void push(int data) throws Exception{
        stackOverFlowException(); 
        push_(data);

    }

    // O(1)
    public int top() throws Exception{ // top can throw exception
        try{
            stackIsEmptyException();
        }catch(Exception e){
            System.out.println("I am being resolved");
        }

        return this.arr[this.tos];        
    }

    private int pop_(){
        int rv =this.arr[this.tos];
        this.arr[this.tos--]=0;
        this.size--;
        return rv;
    }
    // O(1)  // removes and returns
    public int pop()throws Exception{
        stackIsEmptyException();
        return pop_();
    }

    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = tos;i>=0;i--){
            sb.append(this.arr[i]);
            if(i!=0){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }




}