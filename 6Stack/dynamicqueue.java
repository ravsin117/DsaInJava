public class dynamicqueue extends queue {

    public dynamicqueue(){
        super();
    }
    public dynamicqueue(int size){
        super(size);
    }
    // this-> bcz of this compiler first finds functionlity in this class and then in its parent class 
    // super -> directly goes to parent class and finds the functionlity 
    @Override
    public void add(int data) throws Exception{
        if(super.size()==super.maxSize()){
            int []temp = new int [super.size()];
            int idx =0 ;
            while(super.size()!=0){
                temp[idx++]= super.remove();
            }

            super.intialize(super.maxSize()*2);
            
            for(int ele:temp){
                super.add(ele);
            }
        }
        super.add(data); // if queue was not full
    }
    
}
