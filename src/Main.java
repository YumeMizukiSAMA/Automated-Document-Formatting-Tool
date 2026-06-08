public class Main {
    public static void main(String[] args) {
        boolean running = true;
        DocumentFormatter formatter = new DocumentFormatter();
        MenuController.showMenu();
        while (running){
            switch (MenuController.handleChoice()){
                case 1 -> formatter.loadDocument();
                case 2 -> formatter.formatDocument();
                case 3 -> formatter.saveDocument();
            }
        }
    }
}
