import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DocumentFormatter {
    private String content;
    public DocumentFormatter(){

    }
    public void loadDocument(){
        Scanner input = new Scanner(System.in);
        boolean success = false;
        while(!success){
            try{
                System.out.print("请输入文件路径：");
                String path = input.nextLine();
                if(path.endsWith(".txt")|| path.endsWith(".md")){
                    this.content = readTextFile(path);
                    success = true;
                    System.out.println("读取成功！");
                }
                else {
                    System.out.println("暂不支持除txt、md格式外的文件");
                }
            }catch (IOException e){
                System.out.println("操作失败" + e.getMessage());
            }
        }
    }
    private String readTextFile(String path) throws IOException{
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;
            while((line = reader.readLine()) != null){
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }

}
