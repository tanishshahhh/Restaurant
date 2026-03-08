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
                                product pInsert = new product();
                                System.out.print("Enter Product ID: ");
                                pInsert.setPro_id(sc.nextInt());
                                sc.nextLine();
                                System.out.print("Enter Product Name: ");
                                pInsert.setPro_name(sc.nextLine());
                                System.out.print("Enter Product Quantity: ");
                                pInsert.setPro_qty(sc.nextInt());
                                crud.insertProduct(con, pInsert);
                                break;
                            case 2:
                                product pUpdate = new product();
                                System.out.print("Enter Product ID to Update: ");
                                pUpdate.setPro_id(sc.nextInt());
                                sc.nextLine();
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
                            default:
                                System.out.println("Invalid input");
                                break;
                        }
                    } while (productChoice != 6);
                    break;
                case 2:
                    int customerChoice;
                    do {
                        System.out.println("--- CUSTOMER MENU ---");
                        System.out.println("1. INSERT CUSTOMER");
                        System.out.println("2. UPDATE CUSTOMER");
                        System.out.println("3. DELETE CUSTOMER");
                        System.out.println("4. VIEW CUSTOMERS");
                        System.out.println("5. SEARCH CUSTOMER");
                        System.out.println("6. BACK");
                        System.out.print("Select Option: ");
                        customerChoice = sc.nextInt();

                        switch (customerChoice) {
                            case 1:
                                String opt3;
                                do {
                                    customer cInsert = new customer();
                                    System.out.print("Enter Customer ID: ");
                                    cInsert.setCust_id(sc.nextInt());
                                    sc.nextLine();
                                    System.out.print("Enter Customer Name: ");
                                    cInsert.setCust_name(sc.nextLine());
                                    System.out.print("Enter Customer Number: ");
                                    cInsert.setCust_number(sc.nextInt());
                                    sc.nextLine();
                                    System.out.print("Enter Customer Address: ");
                                    cInsert.setCust_adress(sc.nextLine());
                                    crud.insertCustomer(con, cInsert);
                                    System.out.println("Inserted");

                                    System.out.println("Do you want to continue (y/n): ");
                                    opt3= sc.next();
                                }while(opt3.equalsIgnoreCase("y"));
                                break;
                            case 2:
                                String opt4;
                                do {
                                    customer cUpdate = new customer();
                                    System.out.print("Enter Customer ID to Update: ");
                                    cUpdate.setCust_id(sc.nextInt());
                                    sc.nextLine();
                                    System.out.print("Enter New Customer Name: ");
                                    cUpdate.setCust_name(sc.nextLine());
                                    System.out.print("Enter New Customer Number: ");
                                    cUpdate.setCust_number(sc.nextInt());
                                    sc.nextLine();
                                    System.out.print("Enter New Customer Address: ");
                                    cUpdate.setCust_adress(sc.nextLine());
                                    crud.updateCustomer(con, cUpdate);
                                    System.out.println("Updated");
                                    System.out.println("Do you want to Continue (y/n):");
                                    opt4= sc.next();
                                }while(opt4.equalsIgnoreCase("y"));
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
                            default:
                                System.out.println("Invalid Input");
                                break;
                        }
                    } while (customerChoice != 6);
                    break;
                case 3:
                    int OrderChoice;
                    System.out.println("---Order Menu---");
                    System.out.println("1.Insert Order");
                    System.out.println("2.Delete Order");
                    System.out.println("3.View Order");
                    System.out.println("4.Search Order");
                    System.out.println("5.Exit");

                    System.out.println("Enter your input: ");
                    OrderChoice=sc.nextInt();

                    switch(OrderChoice){
                        case 1:
                            String opt5;
                            order_product cpInsert=new order_product();
                            order_details cdInsert=new order_details();

                            System.out.println("Enter order Id");
                            cdInsert.setOrder_id(sc.nextInt());
                            System.out.println("Enter Cust Id");
                            cdInsert.setCust_id(sc.nextInt());
                            System.out.println("Enter Order Date (YYYY-MM-DD");
                            cdInsert.setOrder_date(sc.next());
                            cdInsert.setTax((int) (cdInsert.getFinal_bill()*0.18));
                            cdInsert.setDiscount((int) (cdInsert.getFinal_bill() * 0.10));

                            String opt6;
                            int sr=1;
                            do{
                                cpInsert.setOrder_product_id(sr);
                                cdInsert.setOrder_id(cdInsert.getOrder_id());
                                System.out.println("Enter Product Id:");
                                cpInsert.setProduct_id(sc.nextInt());
                                System.out.println("Enter Product Name: ");
                                cpInsert.setOrder_product(sc.next());
                                System.out.println("Enter product quantity:");
                                cpInsert.setProduct_qty(sc.nextInt());
                                System.out.println("Enter Product rate: ");
                                cpInsert.setPro_rate(sc.nextInt());
                                cpInsert.setPrice(cpInsert.getProduct_qty()*cpInsert.getPro_rate());
                                sr++;

                                System.out.println("do you want to add new product to bill (y/n): ");
                                opt6=sc.next();

                            }while(opt6.equalsIgnoreCase("y"));
                            break;

                        case 2:
                            order_details cdDelete=new order_details();
                            System.out.println("Enter Order id: ");
                            cdDelete.setOrder_id(sc.nextInt());
                            crud.deleteOrder(con,cdDelete.order_id);
                            break;

                        case 3:
                            crud.viewOrders(con);
                            break;

                        case 4:
                            order_details odSearch=new order_details();
                            System.out.println("Enter Order Id:");
                            odSearch.setOrder_id(sc.nextInt());
                            crud.searchOrder(con,odSearch.order_id);
                            break;
                        case 5:
                            System.out.println("exiting..");
                            break;
                        default:
                            System.out.println("Invalid input");
                            break;
                    }

                case 4:
                    int reportChoice;
                    do {
                        System.out.println("--- REPORTS ---");
                        System.out.println("1. Daily sales");
                        System.out.println("2. Customized sales according to date");
                        System.out.println("3. Top selling items");
                        System.out.println("4. Least selling items");
                        System.out.println("5. BACK");

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
                                crud.MonthlySales(con, customOrder);
                                break;
                            case 3:
                                crud.topSellingItems(con);
                                break;
                            case 4:
                                crud.leastSellingItems(con);
                                break;
                            case 5:
                                System.out.println("exiting..");
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
    }
}
