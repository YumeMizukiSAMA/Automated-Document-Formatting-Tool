import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuController {
    public static void showMenu() {
        System.out.println("———————————————————————————————");
        System.out.println("欢迎使用文档自动排挡工具");
        System.out.println("——————————————————————————————");
        System.out.println("1.读取文档文件");
        System.out.println("2.基础格式排版（默认格式、冗余清理）");
        System.out.println("3.保存排版后文档");
        System.out.println("4.退出系统");
    }

    public static int handleChoice() {
        boolean validInput = false;
        int choice = 0;
        Scanner input = new Scanner(System.in);
        while (!validInput) {
            try {
                System.out.print("请选择操作：");
                choice = input.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("输入类型不正确！请重试！");
                input.nextLine();
            }
        }
        return choice;
    }
}
