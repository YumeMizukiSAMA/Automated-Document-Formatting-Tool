import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DocumentFormatter {
    private String content;
    private String originalFilePath;
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
                    this.originalFilePath = path;
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
        normalizeParagraphs();  // 4. 规范化段落结构
        System.out.println("基础格式排版完成。");
    }
    private void unifyNewlines(){
        this.content = this.content.replaceAll("\n{3,}", "\n\n");
    }
    private void removeTrailingSpaces(){
        this.content = this.content.replaceAll("[ \t]+\n", "\n");
    }
    private void mergeBlankLines() {
        this.content = this.content.replaceAll("\n{3,}", "\n\n");
    }
    private void normalizeParagraphs() {
        String[] paragraphs = this.content.split("\n\n+");
        StringBuilder sb = new StringBuilder();

        for (String para : paragraphs) {
            String trimmed = para.trim().replaceAll("\n", " ");
            if (!trimmed.isEmpty()) {
                // 用空格模拟缩进
                sb.append(trimmed).append("\n\n");
            }
        }

        this.content = sb.toString().stripTrailing() + "\n";
    }
    public void saveDucument(){
        if (this.content == null || this.content.isEmpty()){
            System.out.println("当前没有可保存的文档内容，请先读取并排版文档");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        String defaultName = "排版后文档.txt";
        if(this.originalFilePath != null){
            defaultName = this.originalFilePath.replace(".txt","_已排版.txt")
                    .replace(".md","_已排版.md");
        }
        System.out.print("请输入保存路径（直接回车使用默认：" + defaultName + ")");
        String savePath = scanner.nextLine();
        if(savePath.isEmpty()){
            savePath = defaultName;
        }

        File file = new File(savePath);
        if(file.exists()){
            System.out.print("该文件已经存在，是否覆盖（Y/N）?：");
            String confirm = scanner.nextLine();
            if (!confirm.equalsIgnoreCase("Y")){
                System.out.println("文件已取消保存。");
                return;
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(savePath))){
            writer.write(this.content);
            System.out.println("文件保存成功！");
        }catch (IOException e){
            System.out.println("保存失败：" + e.getMessage());
        }
    }
}
