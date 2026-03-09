public class order_product {
    String order_product;
    int order_product_id;// (PK) bill no.
    int order_id;// (FK)
    int pro_id;// (FK)
    int pro_qty;
    int pro_rate;
    int price;

    public order_product(String order_product, int order_product_id,int order_id, int product_id,int product_qty,int pro_rate, int price) {
        this.order_product = order_product;
        this.order_product_id = order_product_id;
        this.order_id = order_id;
        this.pro_id=product_id;
        this.pro_qty=product_qty;
        this.pro_rate=pro_rate;
        this.price=price;
    }

    public order_product() {

    }

    public String getOrder_product() {
        return order_product;
    }

    public void setOrder_product(String order_product) {
        this.order_product = order_product;
    }

    public int getOrder_product_id() {
        return order_product_id;
    }

    public void setOrder_product_id(int order_product_id) {
        this.order_product_id = order_product_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getpro_id() {
        return pro_id;
    }

    public void setpro_id(int product_id) {
        this.pro_id = product_id;
    }

    public int getProduct_qty() {
        return pro_qty;
    }

    public void setProduct_qty(int product_qty) {
        this.pro_qty = product_qty;
    }

    public int getPro_rate() {
        return pro_rate;
    }

    public void setPro_rate(int pro_rate) {
        this.pro_rate = pro_rate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
