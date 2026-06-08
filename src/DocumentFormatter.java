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
    public void formatDocument(){
        if(this.content == null){
            System.out.println("错误！请先读取文档");
            return;
        }
        unifyNewlines();       // 1. 统一换行符
        removeTrailingSpaces();// 2. 去除行尾空格
        mergeBlankLines();     // 3. 合并连续空行
        System.out.println("基础格式排版完成。");
    }
    private void unifyNewlines(){
        this.content = this.content.replaceAll("\n{3,}", "\n\n")
    }
    private void removeTrailingSpaces(){
        this.content = this.content.replaceAll("[ \t]+\n", "\n");
    }
    private void mergeBlankLines() {
        this.content = this.content.replaceAll("\n{3,}", "\n\n");
    }

}
