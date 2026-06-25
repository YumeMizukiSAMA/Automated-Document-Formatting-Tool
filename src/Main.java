import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        DocumentFormatter formatter = new DocumentFormatter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("———————————————————————————————");
        System.out.println("欢迎使用 文档自动排版工具 v1.0");
        System.out.println("提示：本工具支持txt/md格式文档的读取、格式化与保存");
        System.out.println("———————————————————————————————");

        while (running) {
            MenuController.showMenu();
            switch (MenuController.handleChoice()) {
                case 1 -> {
                    // 优化2：添加操作反馈提示
                    System.out.println("正在加载文档...");
                    formatter.loadDocument();
                    System.out.println("文档加载完成！");
                }
                case 2 -> {
                    System.out.println("正在执行文档格式化...");
                    formatter.formatDocument();
                    System.out.println("文档格式化完成！");
                }
                case 3 -> {
                    System.out.println("正在应用标准排版格式...");
                    formatter.applyStandardFormat();
                    System.out.println("标准格式应用完成！");
                }
                case 4 -> {
                    System.out.println("正在保存文档...");
                    formatter.saveDocument();
                    System.out.println("文档保存成功！");
                }
                case 5 -> {
                    System.out.println("正在统计文档信息...");
                    formatter.showStatistics();
                }
                case 6 -> {
                    System.out.print("是否保存排版后的文档再退出（Y/N）?：");
                    String confirm = scanner.nextLine().trim();
                    if (confirm.equalsIgnoreCase("Y")) {
                        formatter.saveDocument();
                        System.out.println("文件保存成功！");
                    } else if (!confirm.equalsIgnoreCase("N")) {
                        System.out.println("输入无效，默认不保存修改");
                    } else {
                        System.out.println("修改后的文件未保存");
                    }
                    System.out.println("感谢使用文档自动排版工具！");
                    running = false;
                }
                default -> System.out.println("无效选项！请输入1-6之间的数字！\n");
            }
        }
        scanner.close(); // 补充关闭Scanner，释放资源
        System.out.println("系统已安全退出");
    }
}