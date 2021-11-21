package defaults;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class Utils {
    public static ArrayList<String> readFromXml (String filePath, ArrayList<String> keyNames) throws Exception {
        File fXmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();

        ArrayList<String> data = new ArrayList<>();
        for (String keyName: keyNames) {
            String content = doc.getElementsByTagName(keyName).item(0).getTextContent();
            data.add(content);
        }
        return data;
    }
}
