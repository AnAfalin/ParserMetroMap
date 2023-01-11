package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.MetroMap;
import models.Station;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class WriterJSON {
    public static void writeStationsToJSON(MetroMap metroMap, String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(path);
        List<Station> list = metroMap.getListStations();

        try {
            objectMapper.writeValue(file, list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeMapToJSON(MetroMap metroMap, String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(path);

        HashMap<String, Object> list = metroMap.getMetroObject();
        try {
            objectMapper.writeValue(file, list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
