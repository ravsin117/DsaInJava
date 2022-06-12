
public class dynamicstack extends stack {
    // except private methods and properties of stack class all other funcitonlaities are inherited by dynamic stack now

    public dynamicstack(){
        super(); // calls the constructor of parent
    }

    public dynamicstack(int size){
        super(size);// calls the user defined constructor in stack class
        // super has access to all functions of parent
        // super doesn't inherit private members of class. 
    }
    @Override
    public void push(int data)throws Exception{
        // System.out.println("hi");
        // super.push(data);//till calls push in stack class
        
        if(this.size()==super.maxSize()){ // if st is full
            int [] temp = new int[this.size()];
            int idx = super.size()-1;
            while(super.size()!=0)
                temp[idx--] = super.pop(); // stack emptied and values shifted to array

            super.initialize(super.maxSize()*2);

            for(int ele : temp){
                super.push(ele);
            }
            // doubled the size now 
        }

        super.push(data);
        // System.out.println(super.maxSize()); // we can check here as the size doubles

    }

    
}
