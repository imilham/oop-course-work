class Customer{

    protected String surName;
    protected String firstName;
    protected int quantityOFP = 0;
    protected int quantityOFQ = 0;
    Item P;
    Item Q;

    //Parameterized constructor - only one product
    public Customer(String surName, String firstName, int quantityOFP){     // only one product
        this.surName = surName;
        this.firstName = firstName;
        this.quantityOFP = quantityOFP;
    }
    //Parameterized constructor -  Two product
    public Customer(String surName, String firstName, int quantityOFP, int quantityOFQ){ // two products
        this.surName = surName;
        this.firstName = firstName;
        this.quantityOFP = quantityOFP;
        this.quantityOFQ = quantityOFQ;
    }
    //Getters
        public String getValueSurName(){
            return this.surName;
        }
        public String getValueFirstName(){
            return this.firstName;
        }
        public int getValuequantityOFP(){
            return this.quantityOFP;
        }
        public int getValuequantityOFQ(){
            return this.quantityOFQ;
        }

    //Member function
    public int findBillAmount(){

        return quantityOFQ == 0 ? (quantityOFP * 100)
            : (quantityOFP * 100) + (quantityOFQ * 200);
    }
}

class LocalCustomer extends Customer{

    protected int discountRate;
    protected Item pItem;
    protected Item qItem;
    
    //Parameterized constructor - only one product
    public LocalCustomer(String surName, String firstName, int quantityOFP, int discountRate, Item pItem) {
        super(surName, firstName, quantityOFP);
        this.discountRate = discountRate;
        this.pItem = pItem;
    }
    //Parameterized constructor -  Two product
    public LocalCustomer(String surName, String firstName, int quantityOFP, int quantityOFQ, int discountRate,Item pItem, Item qItem) {
        super(surName, firstName, quantityOFP,quantityOFQ);
        this.discountRate = discountRate;
        this.pItem = pItem;
        this.qItem = qItem;
    }

    //Getters 
    public int getValueLocalCustomerDiscountRate(){
        return this.discountRate;
    }

    //Member functions
    public int findBillAmount(){
        //System.out.println(super.findBillAmount());
        return quantityOFQ == 0 ? (quantityOFP * pItem.getValueItemUnitprice()) - ((quantityOFP * pItem.getValueItemUnitprice()) * discountRate) / 100
            : ((quantityOFP * pItem.getValueItemUnitprice()) - ((quantityOFQ * qItem.getValueItemUnitprice()) * discountRate) / 100) + ((quantityOFQ * pItem.getValueItemUnitprice()) - ((quantityOFP * qItem.getValueItemUnitprice()) * discountRate) / 100);
    }
    
}

class ForeignCustomer extends Customer{

    protected int taxRate;
    protected Item pItem;
    protected Item qItem;
    

     //Parameterized constructor - only one product
     public ForeignCustomer(String surName, String firstName, int quantityOFQ, int taxRate, Item qItem) {
        super(surName, firstName, quantityOFQ);
        this.qItem = qItem;
        this.taxRate = taxRate;
    }
    //Parameterized constructor -  Two product
    public ForeignCustomer(String surName, String firstName, int quantityOFP, int quantityOFQ, int taxRate, Item pItem, Item qItem) {
        super(surName, firstName, quantityOFP,quantityOFQ);
        this.pItem = pItem;
        this.qItem = qItem;
        this.taxRate = taxRate;
    }

    // Member functions
    public int findBillAmount(){
        return quantityOFP == 0 ? (quantityOFP * pItem.getValueItemUnitprice()) - ((quantityOFP * pItem.getValueItemUnitprice()) * taxRate) / 100
        : ((quantityOFQ * qItem.getValueItemUnitprice()) - ((quantityOFQ * qItem.getValueItemUnitprice()) * taxRate) / 100) + ((quantityOFP * pItem.getValueItemUnitprice()) - ((quantityOFP * pItem.getValueItemUnitprice()) * taxRate) / 100);
    }
}

class Item{
    protected int unitPrice;

    //Parameterize Constructor
    public Item(int unitPrice){
        this.unitPrice = unitPrice;
    }

    //Getters
        public int getValueItemUnitprice(){
            return this.unitPrice;
        }
}


class Main{
    public static void main(String[] args) {

        Item P = new Item(100);
        Item Q = new Item(150);

        //Customer p = new Customer("Ilham", "Mohamed", 5,10);
        //System.out.println("Total of p is" + p.findBillAmount() );
        
        LocalCustomer A = new LocalCustomer("Mohamed", "Ilham", 10,5, P);
        System.out.println("Customer first name is : " + A.getValueFirstName());
        System.out.println("Customer sur name is : " + A.getValueSurName());
        System.out.println("The total bill is : " + A.findBillAmount());
        System.out.printf("\n\n");

        ForeignCustomer B = new ForeignCustomer("Mohamed", "Ilham", 25, 2, Q);

        System.out.println("Customer first name is : " + B.getValueFirstName());
        System.out.println("Customer sur name is : " + B.getValueSurName());
        System.out.println("The total bill is : " + B.findBillAmount());

    }
}