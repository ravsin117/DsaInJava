public class classAndobj {

    public static class phone{
        String brand;
        String model;
        String color;
        int ram;
        int storage;
        int battery;

        phone(String brand, String model,String color,int ram,int storage,int battery){
            this.brand = brand; // this points to variables in phone class
            this.model = model;
            this.color=color;
            this.ram = ram +6;
            this.storage = storage;
            this.battery = battery;
            
            //  
        }
        public String display(){
            StringBuilder sb  = new StringBuilder();
            sb.append("Brand: "+ this.brand+"\n");
            sb.append("Model: "+ this.model+"\n");
            sb.append("Color: "+ this.color+"\n");
            sb.append("Ram: "+ this.ram+"\n");
            sb.append("Storge: "+ this.storage+"\n");
            sb.append("Battery: "+ this.battery+"\n");
            sb.append("\n");
            return sb.toString();
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("Brand: " + this.brand + "\n");
            sb.append("Model: " + this.model + "\n");
            sb.append("Color: " + this.color + "\n");
            sb.append("Ram: " + this.ram + "\n");
            sb.append("Storge: " + this.storage + "\n");
            sb.append("Battery: " + this.battery + "\n");
            sb.append("\n");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        
        // phone ph1 = new phone(); // calling deault constructor
        // phone ph2 = new phone();
        // ph1.brand = "samsung";
        // ph1.model ="a1";
        // ph1.color="white";
        // ph1.ram =6;
        // ph1.storage = 64;
        // ph1.battery=2400;
        // System.out.println(ph2.brand);
        phone ph3 = new phone("apple","12pro","blue",6,64,3600);
        // System.out.println(ph3);
        // System.out.println(ph3.display());

        System.out.println(ph3);

    }
}