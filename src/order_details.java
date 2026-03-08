public class order_details {
    int order_id;
    int cust_id;
    String order_date;
    int total;
    int tax;
    int discount;
    int final_bill;


    public order_details(int order_id, int cust_id, String order_date, int total, int tax, int discount, int final_bill) {
        this.order_id = order_id;
        this.cust_id = cust_id;
        this.order_date = order_date;
        this.total = total;
        this.tax = tax;
        this.discount = discount;
        this.final_bill = final_bill;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public int getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getFinal_bill() {
        return final_bill;
    }

    public void setFinal_bill(int final_bill) {
        this.final_bill = final_bill;
    }
}
