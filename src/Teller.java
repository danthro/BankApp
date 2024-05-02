public class Teller extends Bank {
    private String tellerName;
    private String tellerId;

    public Teller(String tellerName,String tellerId){
     this.tellerId = tellerId;
     this.tellerName= tellerName;
    }
    // add
    @Override
    public String toString() {
        return "Teller Name: " + this.tellerName + "\nTeller ID: " + this.tellerId;
    }
}
