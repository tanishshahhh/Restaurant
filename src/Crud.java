import java.sql.*;

public class Crud {

    public void insertProduct(Connection con,product p) throws Exception {
        PreparedStatement ps =con.prepareStatement("insert into hr.PRODUCT_RESTAURANT values(?,?,?)");

        ps.setInt(1, p.getPro_id());
        ps.setString(2, p.getPro_name());
        ps.setInt(3, p.getPro_qty());

        ps.executeUpdate();
        System.out.println("Product Inserted");
    }

    public void updateProduct(Connection con,product p) throws Exception {

        PreparedStatement ps =con.prepareStatement("update hr.PRODUCT_RESTAURANT set pro_name=?, pro_qty=? where pro_id=?");

        ps.setString(1, p.getPro_name());
        ps.setInt(2, p.getPro_qty());
        ps.setInt(3, p.getPro_id());

        ps.executeUpdate();
        System.out.println("Product Updated");
    }

    public void deleteProduct(Connection con,int id) throws Exception {

        PreparedStatement ps =con.prepareStatement("delete from hr.PRODUCT_RESTAURANT where pro_id=?");

        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Product Deleted");
    }

    public void viewProducts(Connection con) throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from hr.PRODUCT_RESTAURANT");
        while (rs.next()) {

            System.out.println("Product ID: " + rs.getInt(1));
            System.out.println("Product Name: " + rs.getString(2));
            System.out.println("Product Quantity: " + rs.getInt(3));
            System.out.println("---------------------------");
        }
    }

    public void searchProduct(Connection con, int id) throws Exception {

        PreparedStatement ps =con.prepareStatement("select * from hr.PRODUCT_RESTAURANT where pro_id=?");
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

        PreparedStatement ps =con.prepareStatement("insert into hr.CUSTOMER_RESTAURANT values(?,?,?,?)");
        ps.setInt(1, c.getCust_id());
        ps.setString(2, c.getCust_name());
        ps.setInt(3, c.getCust_number());
        ps.setString(4, c.getCust_adress());
        ps.executeUpdate();
        System.out.println("Customer Inserted");
    }

    public void updateCustomer(Connection con, customer c) throws Exception {

        PreparedStatement ps =con.prepareStatement("update hr.CUSTOMER_RESTAURANT set cust_name=?, cust_number=?, cust_adress=? where cust_id=?");

        ps.setString(1, c.getCust_name());
        ps.setInt(2, c.getCust_number());
        ps.setString(3, c.getCust_adress());
        ps.setInt(4, c.getCust_id());

        ps.executeUpdate();
        System.out.println("Customer Updated");
    }

    public void deleteCustomer(Connection con, int id) throws Exception {
        PreparedStatement ps =con.prepareStatement("delete from hr.CUSTOMER_RESTAURANT where cust_id=?");

        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Customer Deleted");
    }

    public void viewCustomers(Connection con) throws Exception {

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from hr.CUSTOMER_RESTAURANT");
        while (rs.next()) {

            System.out.println("Customer ID: " + rs.getInt(1));
            System.out.println("Customer Name: " + rs.getString(2));
            System.out.println("Customer Number: " + rs.getInt(3));
            System.out.println("Customer Address: " + rs.getString(4));
            System.out.println("---------------------------");
        }
    }

    public void searchCustomer(Connection con, int id) throws Exception {
        PreparedStatement ps =con.prepareStatement("select * from hr.CUSTOMER_RESTAURANT where cust_id=?");
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
        PreparedStatement ps = con.prepareStatement("INSERT INTO hr.ORDER_DETAILS VALUES(?,?,TO_DATE(?,'YYYY-MM-DD'),?,?,?,?)");

        ps.setInt(1, o.getOrder_id());
        ps.setInt(2, o.getCust_id());
        ps.setString(3, o.getOrder_date());
        ps.setInt(4, o.getFinal_bill() + o.getDiscount() - o.getTax()); // Logical Total
        ps.setInt(5, o.getTax());
        ps.setInt(6, o.getDiscount());
        ps.setInt(7, o.getFinal_bill()); // Maps to your 'FINAL' column

        ps.executeUpdate();
        System.out.println("Main Order Recorded.");
    }

//    public void updateOrder(Connection con, order_details o) throws Exception {
//
//        PreparedStatement ps = con.prepareStatement("update hr.order_details set cust_id=?, order_date=?, total=?, tax=?, discount=?, final_bill=? where order_id=?");
//
//        ps.setInt(1, o.getCust_id());
//        ps.setString(2, o.getOrder_date());
//        ps.setInt(3, o.getTotal());
//        ps.setInt(4, o.getTax());
//        ps.setInt(5, o.getDiscount());
//        ps.setInt(6, o.getFinal_bill());
//        ps.setInt(7, o.getOrder_id());
//
//        ps.executeUpdate();
//
//        System.out.println("Order Updated");
//    }

    public void deleteOrder(Connection con, int id) throws Exception {

        PreparedStatement ps = con.prepareStatement("delete from hr.order_details where order_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Order Deleted");
    }

    public void viewOrders(Connection con) throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from hr.ORDER_DETAILS");
        while (rs.next()) {
            System.out.println("Order ID: " + rs.getInt("ORDER_ID"));
            System.out.println("Customer ID: " + rs.getInt("CUST_ID"));
            System.out.println("Order Date: " + rs.getString("ORDER_DATE"));
            System.out.println("Total Amount: " + rs.getInt("TOTAL"));
            System.out.println("Tax: " + rs.getInt("TAX"));
            System.out.println("Discount: " + rs.getInt("DISCOUNT"));
            System.out.println("Final Bill: " + rs.getInt("FINAL")); // Matches FINAL column
            System.out.println("---------------------------");
        }
    }


    public void searchOrder(Connection con, int id) throws Exception {

        PreparedStatement ps = con.prepareStatement("select * from hr.order_details where order_id=?");
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
        String sql = "INSERT INTO hr.ORDER_PRODUCT (ORDER_ID, PRO_ID, PRO_NAME, PRO_QTY, PRO_RATE, PRICE) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, op.getOrder_id());
        ps.setInt(2, op.getpro_id());
        ps.setString(3, "Product");
        ps.setInt(4, op.getProduct_qty());
        ps.setInt(5, op.getPro_rate());
        ps.setInt(6, op.getPrice());

        ps.executeUpdate();
        System.out.println("Item added to Order.");
    }

    public void AddOrderProduct(Connection con, order_product op) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT PRO_ID, PRO_NAME FROM hr.PRODUCT_RESTAURANT");
        System.out.println("--- AVAILABLE PRODUCTS ---");
        while(rs.next()) {
            System.out.println("ID: " + rs.getInt("PRO_ID") + " | Name: " + rs.getString("PRO_NAME"));
        }
    }

    public void updateOrderTotals(Connection con, int orderId, double total) throws Exception {
        double tax = total * 0.18;
        double discount = total * 0.10;
        double finalBill = total + tax - discount;

        String sql = "UPDATE hr.ORDER_DETAILS SET TOTAL=?, TAX=?, DISCOUNT=?, FINAL=? WHERE ORDER_ID=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, total);
        ps.setDouble(2, tax);
        ps.setDouble(3, discount);
        ps.setDouble(4, finalBill);
        ps.setInt(5, orderId);
        ps.executeUpdate();
    }

    // daily sales
    public void dailySales(Connection con, order_details o) throws SQLException {
        String query = "SELECT op.product_id, p.pro_name, SUM(op.product_qty) " +
                "FROM hr.order_product op " +
                "JOIN hr.order_details od ON op.order_id = od.order_id " +
                "JOIN hr.PRODUCT_RESTAURANT p ON op.product_id = p.pro_id " +
                "WHERE od.order_date = ? " +
                "GROUP BY op.product_id, p.pro_name";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, o.getOrder_date());
        ResultSet rs = ps.executeQuery();

        System.out.println("Sales for " + o.getOrder_date() + ":");
        while(rs.next()) {
            System.out.println("Item: " + rs.getString(2) + " | Qty: " + rs.getInt(3));
        }
    }

    // Customeize time period sales sales report
    public void CustomizedSales(Connection con, String startDate, String endDate) throws SQLException {
        String sql = "SELECT op.PRO_ID, op.PRO_NAME, SUM(op.PRO_QTY) as total_qty " +
                "FROM hr.ORDER_PRODUCT op " +
                "JOIN hr.ORDER_DETAILS od ON op.ORDER_ID = od.ORDER_ID " +
                "WHERE od.ORDER_DATE BETWEEN TO_DATE(?, 'YYYY-MM-DD') AND TO_DATE(?, 'YYYY-MM-DD') " +
                "GROUP BY op.PRO_ID, op.PRO_NAME";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, startDate);
        ps.setString(2, endDate);

        ResultSet rs = ps.executeQuery();
        System.out.println("--- Sales Report from " + startDate + " to " + endDate + " ---");

        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.println("Product: " + rs.getString("PRO_NAME") +
                    "-->  Total Sold: " + rs.getInt("total_qty"));
        }
        if (!found) {
            System.out.println("No sales found for this period.");
        }
    }

    // Top Selling Items
    public void topSellingItems(Connection con) throws Exception {
        String query = "SELECT p.PRO_NAME, SUM(op.PRO_QTY) as total_sold " +
                "FROM hr.ORDER_PRODUCT op JOIN hr.PRODUCT_RESTAURANT p ON op.PRO_ID = p.PRO_ID " +
                "GROUP BY p.PRO_NAME ORDER BY total_sold DESC";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        System.out.println("--- TOP SELLING ITEMS ---");
        while (rs.next()) {
            System.out.println(rs.getString(1) + " | Units Sold: " + rs.getInt(2));
        }
    }

    // Least Selling Items
    public void leastSellingItems(Connection con) throws Exception {
        String query = "SELECT p.PRO_NAME, SUM(op.PRO_QTY) as total_sold " +
                "FROM hr.ORDER_PRODUCT op JOIN hr.PRODUCT_RESTAURANT p ON op.PRO_ID = p.PRO_ID " +
                "GROUP BY p.PRO_NAME ORDER BY total_sold ASC";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        System.out.println("--- LEAST SELLING ITEMS ---");
        while (rs.next()) {
            System.out.println(rs.getString(1) + " | Units Sold: " + rs.getInt(2));
        }
    }
}
