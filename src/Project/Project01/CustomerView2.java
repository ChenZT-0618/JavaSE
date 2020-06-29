package Project.Project01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ChenZT
 * 程序主界面，用arraylist完成
 */
public class CustomerView2 {
    public static ArrayList<Customer> customers = new ArrayList<>();
    public static int SIZE = customers.size();

    public static void main(String[] args) {
        customers.add(new Customer("佟刚", "男", 45, "010-56253825", "tong@abc.com"));
        customers.add(new Customer("封捷", "女", 36, "010-56253825", "fengjie@ibm.com"));
        customers.add(new Customer("雷丰阳", "男", 32, "010-56253825", "leify@163.com"));
        SIZE = customers.size();
        CustomerView2 test = new CustomerView2();
        test.MainMenu();

    }

    public void MainMenu() {

        while (true) {
            System.out.println("-----------------客户信息管理软件-----------------");
            System.out.println("1添 加 客 户");
            System.out.println("2修 改 客 户");
            System.out.println("3删 除 客 户");
            System.out.println("4客 户 列 表");
            System.out.println("5退 出");
            System.out.println("请选择(1-5)：");

            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    addNewCustomer();
                    break;
                case 2:
                    modifyCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    printAllCustomers();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误，请重新输入（1-5）：");
            }
        }
    }

    private void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------删除客户---------------------");
        int index;
        while (true) {
            index = Integer.parseInt(scanner.nextLine());
            if (index == -1) {
                return;
            } else if (index < 0 || index > SIZE) {
                System.out.println("输入有误，请重新输入");
            } else {
                break;
            }
        }
        System.out.println("确认是否删除(Y / N)：");
        String confirm = scanner.nextLine();
        if (confirm.equals("N") || confirm.equals("n")) {
            return;
        }
        customers.remove(index);
        SIZE = customers.size();
        System.out.println("-------------------- - 删除完成---------------------");


    }

    private void addNewCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------添加客户---------------------");
        System.out.println("姓名:");
        String name = scanner.nextLine();
        System.out.println("性别:");
        String gender = scanner.nextLine();
        System.out.println("年龄:");
        String tempAge = scanner.nextLine();
        int age = Integer.parseInt(tempAge);
        System.out.println("电话:");
        String phone = scanner.nextLine();
        System.out.println("邮箱:");
        String email = scanner.nextLine();
        Customer temp = new Customer(name, gender, age, phone, email);
        System.out.println("添加的客户信息：" + temp.toString());
        System.out.println("是否确定添加：Y/N");
        if (scanner.nextLine().equalsIgnoreCase("N")) {
            System.out.println("---------------------添加失败---------------------");
            return;
        }
        customers.add(temp);

        SIZE = customers.size();
        System.out.println("---------------------添加完成---------------------");


    }

    public void modifyCustomer() {
        int size = customers.size();
        if (size == 0) {
            System.out.println("目前客户信息为0");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------修改客户信息---------------------");
        System.out.println("请选择待修改客户编号(0退出)：1-" + size);
        int index;
        // 判断是否合理
        while (true) {
            index = Integer.parseInt(scanner.nextLine());
            if (index > 0 && index < size) {
                break;
            } else if (index == 0) {
                System.out.println("退出成功");
                return;
            } else {
                System.out.println("输入的编号有误，请重新输入(0退出)：1-" + size);
            }
        }

        Customer temp = customers.get(index - 1);
        System.out.println("姓名(" + temp.getName() + "):");
        String tempName = scanner.nextLine();
        if (!(tempName.equals(""))) {
            temp.setName(tempName);
        }
        System.out.println("性别(" + temp.getGender() + "):");
        String tempGender = scanner.nextLine();
        if (!tempGender.equals("")) {
            temp.setGender(tempGender);
        }
        System.out.println("年龄(" + temp.getAge() + "):");
        String tempAge = scanner.nextLine();
        if (!tempAge.equals("")) {
            temp.setAge(Integer.parseInt(tempAge));
        }
        System.out.println("电话(" + temp.getPhone() + "):");
        String tempPhone = scanner.nextLine();
        if (!tempPhone.equals("")) {
            temp.setPhone(tempPhone);
        }
        System.out.println("邮箱(" + temp.getPhone() + "):");
        String tempEmail = scanner.nextLine();
        if (!tempEmail.equals("")) {
            temp.setEmail(tempEmail);
        }
        customers.set(index - 1, temp);
        System.out.println("---------------------修改完成---------------------");
    }

    public void printAllCustomers() {
        System.out.println("编号" + "\t" + "姓名" + "\t" + "性别" + "\t" + "年龄" + "\t" + "电话" + "\t" + "邮箱");
        for (int i = 0; i < SIZE; i++) {
            System.out.println((i + 1) + "\t\t" + customers.get(i).toString());
        }
    }


}
