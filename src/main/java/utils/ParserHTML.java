package utils;

import models.Connections;
import models.Line;
import models.MetroMap;
import models.Station;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ParserHTML {
    private final String URL;

    public ParserHTML(String URL) {
        this.URL = URL;
    }

    public void parsePage(MetroMap metroMap) {
        Document document;
        try {
            document = Jsoup.connect(URL).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HashMap<String, Line> lineHashMap = new HashMap<>();
        ArrayList<Line> lines = new ArrayList<>();

        Element element = document.select(".t-text-simple").get(0);
        for (int i = 0; i < element.children().size(); i = i + 2) {
            Element elementLine = element.child(i);
            Line line = new Line();
            String titleLine = elementLine.select(".js-metro-line").html();
            String numberLine = elementLine.select(".js-metro-line").attr("data-line");
            line.setTitle(titleLine);
            line.setNumber(numberLine);
            lines.add(line);

            Elements elementStations = element.child(i + 1).select(".single-station");
            for (int k = 0; k < elementStations.size(); k++) {
                Element stationElement = elementStations.get(k);
//                String numberStation = stationElement.select(".num").html().replaceAll("[&nbsp;.]", "");
                String titleStation = stationElement.select(".name").html();
                Station station = new Station();
                station.setName(titleStation);
                station.setLine(titleLine);
//                station.setNumber(Integer.parseInt(numberStation));
                if (stationElement.select(".t-icon-metroln").size() != 0) {
                    station.setHasConnector(true);

                    for (Element connect : stationElement.select(".t-icon-metroln")) {
                        String connectLine = connect.attributes().get("class").substring(18);
                        String connectStation = connect.attributes().get("title").substring(22, connect.attributes().get("title").length() - 1);
                        metroMap.addConnections(new Connections(numberLine, titleLine, connectLine, connectStation));
                    }

                }
                line.addStation(station);
            }

            lineHashMap.put(line.getNumber(), line);
        }
        metroMap.setLineHashMap(lineHashMap);
    }
}
