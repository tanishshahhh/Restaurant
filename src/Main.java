import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Connection con = jdbc.getOracleConnection();
        Crud crud = new Crud();
        int mainChoice;

        do {
            System.out.println("RESTAURANT MANAGEMENT SYSTEM ");
            System.out.println("1. PRODUCT MENU");
            System.out.println("2. CUSTOMER MENU");
            System.out.println("3. ORDER MENU");
            System.out.println("4. REPORTS");
            System.out.println("5. EXIT");

            System.out.print("Select Category: ");
            mainChoice = sc.nextInt();

            switch (mainChoice) {
                case 1:
                    int productChoice;
                    do {
                        System.out.println("--- PRODUCT MENU ---");
                        System.out.println("1. INSERT PRODUCT");
                        System.out.println("2. UPDATE PRODUCT");
                        System.out.println("3. DELETE PRODUCT");
                        System.out.println("4. VIEW PRODUCTS");
                        System.out.println("5. SEARCH PRODUCT");
                        System.out.println("6. BACK");
                        System.out.print("Select Option: ");
                        productChoice = sc.nextInt();

                        switch (productChoice) {
                            case 1:
                                String addProduct;
                                do {
                                    product pInsert = new product();
                                    System.out.print("Enter Product ID: ");
                                    pInsert.setPro_id(sc.nextInt());
                                    System.out.print("Enter Product Name: ");
                                    pInsert.setPro_name(sc.nextLine());
                                    System.out.print("Enter Product Quantity: ");
                                    pInsert.setPro_qty(sc.nextInt());
                                    crud.insertProduct(con, pInsert);
                                    System.out.println("Do you want to add new product (y/n):");
                                    addProduct = sc.next();
                                } while (addProduct.equalsIgnoreCase("y"));
                                break;
                            case 2:
                                product pUpdate = new product();
                                System.out.print("Enter Product ID to Update: ");
                                pUpdate.setPro_id(sc.nextInt());
                                System.out.print("Enter New Product Name: ");
                                pUpdate.setPro_name(sc.nextLine());
                                System.out.print("Enter New Product Quantity: ");
                                pUpdate.setPro_qty(sc.nextInt());
                                crud.updateProduct(con, pUpdate);
                                break;
                            case 3:
                                System.out.print("Enter Product ID to Delete: ");
                                int deleteId = sc.nextInt();
                                crud.deleteProduct(con, deleteId);
                                break;
                            case 4:
                                crud.viewProducts(con);
                                break;
                            case 5:
                                System.out.print("Enter Product ID to Search: ");
                                int searchId = sc.nextInt();
                                crud.searchProduct(con, searchId);
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("Invalid input");
                                break;
                        }
                    } while (productChoice != 6);
                    break;

                case 2:
                    int customerChoice;
                    do {
                        System.out.println("=======================");
                        System.out.println("\t\tCUSTOMER MENU ");
                        System.out.println("=======================");
                        System.out.println("1. INSERT CUSTOMER");
                        System.out.println("2. UPDATE CUSTOMER");
                        System.out.println("3. DELETE CUSTOMER");
                        System.out.println("4. VIEW CUSTOMERS");
                        System.out.println("5. SEARCH CUSTOMER");
                        System.out.println("6. BACK");
                        System.out.println("=======================");
                        System.out.print("Select Option: ");
                        customerChoice = sc.nextInt();

                        switch (customerChoice) {
                            case 1:
                                String opt3;
                                do {
                                    customer cInsert = new customer();
                                    System.out.print("Enter Customer ID: ");
                                    cInsert.setCust_id(sc.nextInt());
                                    System.out.print("Enter Customer Name: ");
                                    cInsert.setCust_name(sc.nextLine());
                                    System.out.print("Enter Customer Number: ");
                                    cInsert.setCust_number(sc.nextInt());
                                    System.out.print("Enter Customer Address: ");
                                    cInsert.setCust_adress(sc.nextLine());
                                    crud.insertCustomer(con, cInsert);
                                    System.out.println("Do you want to continue (y/n): ");
                                    opt3 = sc.next();
                                } while (opt3.equalsIgnoreCase("y"));
                                break;
                            case 2:
                                String opt4;
                                do {
                                    customer cUpdate = new customer();
                                    System.out.print("Enter Customer ID to Update: ");
                                    cUpdate.setCust_id(sc.nextInt());
                                    System.out.print("Enter New Customer Name: ");
                                    cUpdate.setCust_name(sc.nextLine());
                                    System.out.print("Enter New Customer Number: ");
                                    cUpdate.setCust_number(sc.nextInt());
                                    System.out.print("Enter New Customer Address: ");
                                    cUpdate.setCust_adress(sc.nextLine());
                                    crud.updateCustomer(con, cUpdate);
                                    System.out.println("Updated");
                                    System.out.println("Do you want to Continue (y/n):");
                                    opt4 = sc.next();
                                } while (opt4.equalsIgnoreCase("y"));
                                break;
                            case 3:
                                System.out.print("Enter Customer ID to Delete: ");
                                int deleteId = sc.nextInt();
                                crud.deleteCustomer(con, deleteId);
                                break;
                            case 4:
                                crud.viewCustomers(con);
                                break;
                            case 5:
                                System.out.print("Enter Customer ID to Search: ");
                                int searchId = sc.nextInt();
                                crud.searchCustomer(con, searchId);
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("Invalid Input");
                                break;
                        }
                    } while (customerChoice != 6);
                    break;

                case 3:
                    int orderChoice;
                    System.out.println("=======================");
                    System.out.println("\t\tOrder Menu ");
                    System.out.println("=======================");
                    System.out.println("1. Insert Order");
                    System.out.println("2. Delete Order");
                    System.out.println("3. View Order");
                    System.out.println("4. Search Order");
                    System.out.println("5. Exit");
                    System.out.println("=======================");
                    System.out.print("Enter your input: ");
                    orderChoice = sc.nextInt();

                    switch (orderChoice) {
                        case 1:
                            order_details cdInsert = new order_details();
                            System.out.print("Enter order Id: ");
                            int oId = sc.nextInt();
                            cdInsert.setOrder_id(oId);

                            System.out.print("Enter Cust Id: ");
                            cdInsert.setCust_id(sc.nextInt());

                            System.out.print("Enter Order Date (YYYY-MM-DD): ");
                            cdInsert.setOrder_date(sc.next());

                            cdInsert.setFinal_bill(0);
                            cdInsert.setTax(0);
                            cdInsert.setDiscount(0);
                            crud.insertOrder(con, cdInsert);
                            System.out.println("Order header created. Now add items...");

                            String opt6;
                            double runningTotal = 0;

                            do {
                                order_product cpInsert = new order_product();
                                cpInsert.setOrder_id(oId);

                                crud.AddOrderProduct(con, cpInsert);

                                System.out.print("Select Product ID from list: ");
                                cpInsert.setpro_id(sc.nextInt());

                                System.out.print("Enter product quantity: ");
                                int qty = sc.nextInt();
                                cpInsert.setProduct_qty(qty);

                                System.out.print("Enter Product rate: ");
                                int rate = sc.nextInt();
                                cpInsert.setPro_rate(rate);

                                int itemPrice = qty * rate;
                                cpInsert.setPrice(itemPrice);
                                runningTotal += itemPrice;


                                crud.insertOrderProduct(con, cpInsert);

                                System.out.print("Add another product to this bill? (y/n): ");
                                opt6 = sc.next();
                            } while (opt6.equalsIgnoreCase("y"));


                            crud.updateOrderTotals(con, oId, runningTotal);
                            System.out.println("Order " + oId + " finalized with total: " + runningTotal);
                            break;

                        case 2:
                            System.out.print("Enter Order ID to Delete: ");
                            int orderIdDelete = sc.nextInt();
                            crud.deleteOrder(con, orderIdDelete);
                            break;

                        case 3:
                            crud.viewOrders(con);
                            break;

                        case 4:
                            System.out.print("Enter Order ID to Search: ");
                            int orderIdSearch = sc.nextInt();
                            crud.searchOrder(con, orderIdSearch);
                            break;

                        case 5:
                            System.out.println("Exiting Order Menu...");
                            break;

                        default:
                            System.out.println("Invalid input");
                            break;
                    }
                    break;

                case 4:
                    int reportChoice;
                    do {
                        System.out.println("=======================");
                        System.out.println("\t\tREPORTS");
                        System.out.println("=======================");
                        System.out.println("1. Daily sales");
                        System.out.println("2. Customized sales according to date");
                        System.out.println("3. Top selling items");
                        System.out.println("4. Least selling items");
                        System.out.println("5. BACK");
                        System.out.println("=======================");

                        System.out.print("Select Option: ");
                        reportChoice = sc.nextInt();

                        switch (reportChoice) {
                            case 1:
                                order_details dailyOrder = new order_details();
                                System.out.print("Enter Date (YYYY-MM-DD) for Daily Sales: ");
                                dailyOrder.setOrder_date(sc.next());
                                crud.dailySales(con, dailyOrder);
                                break;
                            case 2:
                                order_details customOrder = new order_details();
                                System.out.print("Enter Date (YYYY-MM-DD) for Sales Report: ");
                                customOrder.setOrder_date(sc.next());
                                crud.CustomizedSales(con, customOrder);
                                break;
                            case 3:
                                crud.topSellingItems(con);
                                break;
                            case 4:
                                crud.leastSellingItems(con);
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Invalid Input");
                                break;
                        }
                    } while (reportChoice != 5);
                    break;

                case 5:
                    System.out.println("Exiting Restaurant Management System...");
                    break;

                default:
                    System.out.println("Invalid Input");
                    break;
            }
        } while (mainChoice != 5);

        con.close();
    }
}