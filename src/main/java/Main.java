import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.json.JSONArray;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static String path;
    public static final String NODES = "nodes.txt";
    public static final String LINKS = "links.txt";
    public static final String CIRCUITS = "circuits.txt";
    public static final String FLOWS = "flows.txt";

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
                if (file.canRead()) {
                    downLoad(path);
                } else {
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
                    open(path.substring(0, path.lastIndexOf("\\")));
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
        List<Bean> beans = new ArrayList<>();
        for (CSVRecord r : recordList) {
            beans.add(new Bean(r.get(0), r.get(1), r.get(2), r.get(3), r.get(4), r.get(5), r.get(6), r.get(7), r.get(8)));
        }
        System.out.println(Arrays.toString(new List[]{beans}));
        String nodes = makeNodes(beans);
        String links = makeLinks(beans);
        String circuits = makeCircuits(beans);

        Map<String, byte[]> map = new HashMap<>();
        map.put(NODES, nodes.getBytes());
        map.put(LINKS, links.getBytes());
        map.put(CIRCUITS, circuits.getBytes());

//        String writePath = path.replace("\\");
        path = path.substring(0, path.lastIndexOf("\\"));
        System.out.println(path);
        writeZip(map, path);

        parser.close();
        fileReader.close();
    }

    public static String makeNodes(List<Bean> beans) {
        List<Node> nodes = new ArrayList<>();
        for(Bean b: beans) {
            nodes.add(new Node(b.getID(), b.getName(), b.getType()));
        }

        return strToJson(nodes);
    }

    public static String makeLinks(List<Bean> beans) {
        List<Link> links = new ArrayList<>();
        for(Bean b: beans) {
            links.add(new Link(b.getParent_ID(), b.getID(), b.getLength(), b.getDiameter()));
        }
        return strToJson(links);
    }

    public static String makeCircuits(List<Bean> beans) {
        List<Circuits> circuits = new ArrayList<>();
        for(Bean b: beans) {
            if(null != b.getCircuit() && !"".equals(b.getCircuit()))
            circuits.add(new Circuits(b.getID(), b.getCircuit().split("/")));
        }
        return strToJson(circuits);
    }

    public static String makeFlows(List<Bean> beans) {

        return "";
    }

    public static String strToJson(List<?> list) {
        JSONArray jsonArray = new JSONArray(list);
        return jsonArray.toString();
    }

    public static void writeZip(Map<String, byte[]> fileMap, String path) {
        try {
            File file = new File(path + "\\result.zip");
            if (file.exists()) {
                file.delete();
            } else {
                file.createNewFile();
            }

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
            for (Map.Entry<String, byte[]> e : fileMap.entrySet()) {
                ZipEntry zipEntry = new ZipEntry(e.getKey());
                zipOutputStream.putNextEntry(zipEntry);
                zipOutputStream.write(e.getValue());
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
        } catch (Exception e) {
            start();
        }
    }
}
