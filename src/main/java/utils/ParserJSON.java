package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.MetroMap;
import models.Station;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ParserJSON {

    public static void parseJSONFiles(List<String> paths, MetroMap metroMap) {

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> nameDepth = new HashMap<>();
        for (String path : paths) {
            List list = null;
            try {
                list = mapper.readValue(new File(path), List.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            for (Object elementList : list) {
                LinkedHashMap element = (LinkedHashMap) elementList;
                String stationName = (String) element.get("station_name");
                String depth = (String) element.get("depth");
                nameDepth.put(stationName, depth);
            }
        }
        List<Station> stations = metroMap.getListStations();
        for (Station station : stations) {
            String title = station.getName();
            String depth = nameDepth.get(title);
            if (depth != null) {
                station.setDepth(depth);
            }
        }
    }
}