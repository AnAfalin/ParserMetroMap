import models.MetroMap;
import utils.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "https://skillbox-java.github.io/";
        String pathFolder = "data";

        MetroMap metroMap = new MetroMap();

        ParserHTML parserHTML = new ParserHTML(url);
        parserHTML.parsePage(metroMap);

        SearcherFiles searcherFiles = new SearcherFiles(pathFolder);
        searcherFiles.searchJsonCsvFiles();
        List<String> jsonPaths = searcherFiles.getJsonPaths();
        List<String> csvPaths = searcherFiles.getCsvPaths();

        ParserJSON.parseJSONFiles(jsonPaths, metroMap);

        ParserCSV.parseCSVFiles(csvPaths, metroMap);

        WriterJSON.writeStationsToJSON(metroMap, "files/stations.json");
        WriterJSON.writeMapToJSON(metroMap, "files/map.json");

    }
}