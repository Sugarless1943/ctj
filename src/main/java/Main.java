import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String path;

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        path = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入文件路径：");
        open(scan.nextLine());
    }

    public static void open(String path) {
        try {
            File file = new File(path);
            if (path.endsWith(".csv")) {
                if(file.canRead()){
                    downLoad(path);
                }else {
                    start();
                }
            } else {
                File[] files = file.listFiles();
                for (File sub : files) {
                    if (sub.isFile()) {
                        System.out.println("文件:" + sub);
                    } else {
                        System.out.println("目录:" + sub);
                    }
                }
                System.out.println("请输入要打开的文件名（输入*返回上一层）：");
                Scanner scan = new Scanner(System.in);
                String order = scan.nextLine();
                if (order.equals("*")) {
                    String regex = "\\\\";
                    String[] array = path.split(regex);
                    array = Arrays.copyOf(array, array.length - 1);
                    path = "";
                    for (int i = 0; i < array.length; i++) {
                        path += array[i] + "\\";
                    }
                    open(path);
                } else {
                    path = path + "\\" + order;
                    open(path);
                }
            }
        } catch (Exception e) {
            start();
        }
    }

    public static void downLoad(String path) throws IOException {
        System.out.println("最终地址：" + path);
        FileReader fileReader = new FileReader(path);
        CSVParser parser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        List<CSVRecord> recordList = parser.getRecords();
        List<Bean> beans = new ArrayList<Bean>();
        for(CSVRecord r: recordList) {
            beans.add(new Bean(r.get(0), r.get(1), r.get(2)));
        }
        System.out.println(Arrays.toString(new List[]{beans}));
        parser.close();
        fileReader.close();
    }
}
