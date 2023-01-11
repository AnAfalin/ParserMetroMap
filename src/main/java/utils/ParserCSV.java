package utils;

import models.MetroMap;
import models.Station;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class ParserCSV {
    public static void parseCSVFiles(List<String> paths, MetroMap metroMap) {

        HashMap<String, String> nameDateMap = new HashMap<>();

        for (String path : paths) {
            Reader in;
            try {
                in = new FileReader(path);
                List<CSVRecord> records = CSVFormat.RFC4180.parse(in).getRecords();
                for (int i = 1; i < records.size(); i++) {
                    nameDateMap.put(records.get(i).get(0), records.get(i).get(1));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        List<Station> stations = metroMap.getListStations();
        for (Station station : stations) {
            String title = station.getName();
            String data = nameDateMap.get(title);
            if (data != null) {
                station.setDate(data);
            }
        }
    }
}


