import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        DocumentFormatter formatter = new DocumentFormatter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("———————————————————————————————");
        System.out.println("欢迎使用文档自动排挡工具");

        while (running){
            MenuController.showMenu();
            switch (MenuController.handleChoice()){
                case 1 -> formatter.loadDocument();
                case 2 -> formatter.formatDocument();
                case 3 -> formatter.applyStandardFormat();
                case 4 -> formatter.saveDocument();
                case 5 -> {
                    System.out.print("是否保存排版后的文档再退出（Y/N）?：");
                    String confirm = scanner.nextLine();
                    if(confirm.equalsIgnoreCase("Y")){
                        formatter.saveDocument();
                        System.out.println("文件保存成功！");
                    }
                    else{
                        System.out.println("修改后的文件未保存");
                    }
                    System.out.println("感谢使用！");
                    running = false;
                }
                default -> System.out.println("无效选项！请重新输入！" + "\n");
            }
        }
        System.out.println("系统已退出");
    }
}
