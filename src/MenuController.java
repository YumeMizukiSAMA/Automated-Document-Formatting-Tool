import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuController {
    public static void showMenu() {
        System.out.println("——————————————————————————————");
        System.out.println("1.读取文档文件");
        System.out.println("2.冗余格式清理");
        System.out.println("3. 统一格式设置（宋体小四、18磅行距）");
        System.out.println("4.保存排版后文档");
        System.out.println("5.退出系统");
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
