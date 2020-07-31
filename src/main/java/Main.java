import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.json.JSONObject;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
        Map<String, Map<String, String>> flowMap = new HashMap<>();
        for (CSVRecord r : recordList) {
            beans.add(new Bean(r.get(0), r.get(1), r.get(2), r.get(3), r.get(4), r.get(5), r.get(6), r.get(7), r.get(8)));

            Map<String, String> map = new HashMap<>();
            map.put("pId", r.get(2));
            map.put("type", r.get(3));
            flowMap.put(r.get(0), map);
        }
        Response r = new Response();
        r.setNodes(makeNodes(beans));
        r.setLinks(makeLinks(beans));
        r.setCircuits(makeCircuits(beans));
        r.setFlows(makeFlows(flowMap));

        path = path.substring(0, path.lastIndexOf("\\"));
        writeJson(r, path);

        parser.close();
        fileReader.close();
    }

    public static List<Node> makeNodes(List<Bean> beans) {
        List<Node> nodes = new ArrayList<>();
        for(Bean b: beans) {
            nodes.add(new Node(b.getID(), b.getName(), b.getType(), b.getCid(), b.getParent_v_ID()));
        }

        return nodes;
    }

    public static List<Link> makeLinks(List<Bean> beans) {
        List<Link> links = new ArrayList<>();
        for(Bean b: beans) {
            links.add(new Link(b.getParent_ID(), b.getID(), b.getLength(), b.getDiameter()));
        }
        return links;
    }

    public static List<Circuit> makeCircuits(List<Bean> beans) {
        List<Circuit> circuits = new ArrayList<>();
        for(Bean b: beans) {
            if(null != b.getCircuit() && !"".equals(b.getCircuit()))
            circuits.add(new Circuit(b.getID(), b.getCircuit().split("/")));
        }
        return circuits;
    }

    public static Map<String, String[]> makeFlows(Map<String, Map<String, String>> flowMap) {
        Map<String, String[]> resMap = new HashMap<>();
        for(Map.Entry<String, Map<String, String>> entry: flowMap.entrySet()) {
            List<String> list = new ArrayList<>();
            Map<String, String> body = entry.getValue();
            if(body.get("type").equals("type")) {
                list.add(entry.getKey());
                for(;;) {
                    if(body.get("type").equals("S")) {
                        break;
                    }else {
                        body = flowMap.get("pId");
                    }
                    list.add(body.get("pId"));
                }
            }
            resMap.put(entry.getKey(), (String[]) list.toArray());
        }

        return resMap;
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

    public static void writeJson(Response response, String path) {
        try {
            File file = new File(path + "\\result.json");
            if (file.exists()) {
                file.delete();
            } else {
                file.createNewFile();
            }

            PrintWriter printWriter = new PrintWriter(file);
            JSONObject jsonObject = new JSONObject(response);
            printWriter.write(jsonObject.toString());

            printWriter.flush();
            printWriter.close();
        }catch (Exception e) {
            start();
        }
    }
}
