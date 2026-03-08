import java.sql.*;

public class Crud {

    public void insertProduct(Connection con,product p) throws Exception {

        PreparedStatement ps =
                con.prepareStatement("insert into product values(?,?,?)");

        ps.setInt(1, p.getPro_id());
        ps.setString(2, p.getPro_name());
        ps.setInt(3, p.getPro_qty());

        ps.executeUpdate();
        System.out.println("Product Inserted");
    }

    public void updateProduct(Connection con,product p) throws Exception {

        PreparedStatement ps =con.prepareStatement("update product set pro_name=?, pro_qty=? where pro_id=?");

        ps.setString(1, p.getPro_name());
        ps.setInt(2, p.getPro_qty());
        ps.setInt(3, p.getPro_id());

        ps.executeUpdate();
        System.out.println("Product Updated");
    }

    public void deleteProduct(Connection con,int id) throws Exception {

        PreparedStatement ps =con.prepareStatement("delete from product where pro_id=?");

        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Product Deleted");
    }

    public void viewProducts(Connection con) throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from product");
        while (rs.next()) {

            System.out.println("Product ID: " + rs.getInt(1));
            System.out.println("Product Name: " + rs.getString(2));
            System.out.println("Product Quantity: " + rs.getInt(3));
            System.out.println("---------------------------");
        }
    }

    public void searchProduct(Connection con, int id) throws Exception {

        PreparedStatement ps =con.prepareStatement("select * from product where pro_id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("Product ID: " + rs.getInt(1));
            System.out.println("Product Name: " + rs.getString(2));
            System.out.println("Product Quantity: " + rs.getInt(3));
        }
    }

    //  CUSTOMER

    public void insertCustomer(Connection con, customer c) throws Exception {

        PreparedStatement ps =con.prepareStatement("insert into customer values(?,?,?,?)");
        ps.setInt(1, c.getCust_id());
        ps.setString(2, c.getCust_name());
        ps.setInt(3, c.getCust_number());
        ps.setString(4, c.getCust_adress());
        ps.executeUpdate();
        System.out.println("Customer Inserted");
    }

    public void updateCustomer(Connection con, customer c) throws Exception {

        PreparedStatement ps =con.prepareStatement("update customer set cust_name=?, cust_number=?, cust_adress=? where cust_id=?");

        ps.setString(1, c.getCust_name());
        ps.setInt(2, c.getCust_number());
        ps.setString(3, c.getCust_adress());
        ps.setInt(4, c.getCust_id());

        ps.executeUpdate();
        System.out.println("Customer Updated");
    }

    public void deleteCustomer(Connection con, int id) throws Exception {
        PreparedStatement ps =con.prepareStatement("delete from customer where cust_id=?");

        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Customer Deleted");
    }

    public void viewCustomers(Connection con) throws Exception {

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from customer");
        while (rs.next()) {

            System.out.println("Customer ID: " + rs.getInt(1));
            System.out.println("Customer Name: " + rs.getString(2));
            System.out.println("Customer Number: " + rs.getInt(3));
            System.out.println("Customer Address: " + rs.getString(4));
            System.out.println("---------------------------");
        }
    }

    public void searchCustomer(Connection con, int id) throws Exception {
        PreparedStatement ps =con.prepareStatement("select * from customer where cust_id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("Customer ID: " + rs.getInt(1));
            System.out.println("Customer Name: " + rs.getString(2));
            System.out.println("Customer Number: " + rs.getInt(3));
            System.out.println("Customer Address: " + rs.getString(4));
        }
    }


    // ORDER CRUD

    public void insertOrder(Connection con, order_details o) throws Exception {

        PreparedStatement ps =con.prepareStatement("insert into order_details values(?,?,?,?,?,?,?)");

        ps.setInt(1, o.getOrder_id());
        ps.setInt(2, o.getCust_id());
        ps.setInt(3, o.getOrder_date());
        ps.setInt(4, o.getTotal());
        ps.setInt(5, o.getTax());
        ps.setInt(6, o.getDiscount());
        ps.setInt(7, o.getFinal_bill());

        ps.executeUpdate();

        System.out.println("Order Inserted");
    }

    public void updateOrder(Connection con, order_details o) throws Exception {

        PreparedStatement ps = con.prepareStatement("update order_details set cust_id=?, order_date=?, total=?, tax=?, discount=?, final_bill=? where order_id=?");

        ps.setInt(1, o.getCust_id());
        ps.setInt(2, o.getOrder_date());
        ps.setInt(3, o.getTotal());
        ps.setInt(4, o.getTax());
        ps.setInt(5, o.getDiscount());
        ps.setInt(6, o.getFinal_bill());
        ps.setInt(7, o.getOrder_id());

        ps.executeUpdate();

        System.out.println("Order Updated");
    }

    public void deleteOrder(Connection con, int id) throws Exception {

        PreparedStatement ps = con.prepareStatement("delete from order_details where order_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Order Deleted");
    }

    public void viewOrders(Connection con) throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from order_details");
        while (rs.next()) {
            System.out.println("Order ID: " + rs.getInt(1));
            System.out.println("Customer ID: " + rs.getInt(2));
            System.out.println("Order Date: " + rs.getString(3));
            System.out.println("Total Amount: " + rs.getInt(4));
            System.out.println("Tax: " + rs.getInt(5));
            System.out.println("Discount: " + rs.getInt(6));
            System.out.println("Final Bill: " + rs.getInt(7));
            System.out.println("---------------------------");
        }
    }


    public void searchOrder(Connection con, int id) throws Exception {

        PreparedStatement ps = con.prepareStatement("select * from order_details where order_id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("Order ID: " + rs.getInt(1));
            System.out.println("Customer ID: " + rs.getInt(2));
            System.out.println("Order Date: " + rs.getString(3));
            System.out.println("Total Amount: " + rs.getInt(4));
            System.out.println("Tax: " + rs.getInt(5));
            System.out.println("Discount: " + rs.getInt(6));
            System.out.println("Final Bill: " + rs.getInt(7));
        }
    }

    public void insertOrderProduct(Connection con, order_product op) throws Exception {

        PreparedStatement ps = con.prepareStatement("insert into order_product values(?,?,?,?,?,?,?)");

        ps.setInt(1, op.getOrder_product());
        ps.setInt(2, op.getOrder_product_id());
        ps.setInt(3, op.getOrder_id());
        ps.setInt(4, op.getProduct_id());
        ps.setInt(5, op.getProduct_qty());
        ps.setInt(6, op.getPro_rate());
        ps.setInt(7, op.getPrice());

        ps.executeUpdate();
        System.out.println("Order Product Added");
    }

    // daily sales
    public void dailySales(Connection con,order_details o) throws SQLException {
        PreparedStatement ps= con.prepareStatement("select * from order_product where o.order_date=?");
        ps.setInt(1, o.getOrder_date());

    }

    // monthly sales report
    public void MonthlySales(Connection con,order_details o) throws SQLException {
        PreparedStatement ps= con.prepareStatement("select * from order_products where o.order_date in (?,?)");
        ps.setInt(1, o.getOrder_date());
        ps.setInt(2,o.getOrder_date());

    }

    // top selling items
    public void topSellingItems(Connection con) throws Exception {
        String query = "SELECT p.pro_name, SUM(op.product_qty) as total_sold " +
                "FROM order_product op JOIN product p ON op.product_id = p.pro_id " +
                "GROUP BY p.pro_name ORDER BY total_sold DESC";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        System.out.println("--- TOP SELLING ITEMS ---");
        while (rs.next()) {
            System.out.println(rs.getString(1) + "Units Sold: " + rs.getInt(2));
        }
    }
    // least selling items
    public void leastSellingItems(Connection con) throws Exception {
        String query = "SELECT p.pro_name, SUM(op.product_qty) as total_sold " +
                "FROM order_product op JOIN product p ON op.product_id = p.pro_id " +
                "GROUP BY p.pro_name ORDER BY total_sold ASC";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        System.out.println("--- LEAST SELLING ITEMS ---");
        while (rs.next()) {
            System.out.println(rs.getString(1) + " Units Sold: " + rs.getInt(2));
        }
    }
}
