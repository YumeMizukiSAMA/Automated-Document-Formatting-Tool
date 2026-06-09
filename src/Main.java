public class Main {
    public static void main(String[] args) {
        boolean running = true;
        DocumentFormatter formatter = new DocumentFormatter();
        System.out.println("———————————————————————————————");
        System.out.println("欢迎使用文档自动排挡工具");

        while (running){
            MenuController.showMenu();
            switch (MenuController.handleChoice()){
                case 1 -> formatter.loadDocument();
                case 2 -> formatter.formatDocument();
                case 3 -> formatter.saveDucument();
                case 4 -> {
                    System.out.println("感谢使用！");
                    running = false;
                }
                default -> System.out.println("无效选项！请重新输入！" + "\n");
            }
        }
        System.out.println("系统已退出");
    }
}
