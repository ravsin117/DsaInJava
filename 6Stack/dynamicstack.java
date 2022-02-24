
public class dynamicstack extends stack {
    // except private methods and properties of stack class all other funcitonlaities are inherited by dynamic stack now

    public dynamicstack(){
        super(); // calls the constructor of parent
    }

    public dynamicstack(int size){
        super(size);// calls the user defined constructor in stack class
        // super has access to all functions of parent
          
    }
    @Override
    public void push(int data)throws Exception{
        System.out.println("hi");
        // super.push(data);//till calls push in stack class
    }

    
}
