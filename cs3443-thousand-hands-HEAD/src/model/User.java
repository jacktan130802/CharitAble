package model;

public class User {
   public String name;
   String Qty;
   String ItemsDonated;
    public User(String name, String donated, String qty) {
        this.name = name;
        Qty = qty;
        ItemsDonated = donated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getqty() {
        return Qty;
    }

    public void setqty(String qty) {
        this.Qty = Qty;
    }

    public String getDonated() {
        return ItemsDonated;
    }

    public void setDonated(String donated){
        this.ItemsDonated = ItemsDonated;
    }

}
