public class Main {
    public static void main(String[] args) {
        boolean running = true;
        MenuController.showMenu();
        while (running){
            switch (MenuController.handleChoice()){
                case 1 -> loadDocument();
                case 2 -> formatDocument();
                case 3 -> saveDocument();
            }
        }
    }
}
