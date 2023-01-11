package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearcherFiles {
    private String pathFolder;
    private List<String> csvPaths = new ArrayList<>();
    private List<String> jsonPaths = new ArrayList<>();

    public SearcherFiles(String pathFolder) {
        this.pathFolder = pathFolder;
    }

    public void searchJsonCsvFiles(){
        searchJsonCsvFiles(pathFolder);
    }

    public void searchJsonCsvFiles(String pathFolder) {
        File[] directory = null;
        File folder = new File(pathFolder);
        if (folder.isDirectory()) {
            directory = folder.listFiles();
        }
        if (directory != null) {
            for (File file : directory) {
                String fileName = file.getName();
                if (fileName.endsWith(".json")) {
                    jsonPaths.add(file.getPath());
                } else if (fileName.endsWith(".csv")) {
                    csvPaths.add(file.getPath());
                }
                searchJsonCsvFiles(file.getPath());
            }
        }
    }


    public List<String> getCsvPaths() {
        return csvPaths;
    }

    public List<String> getJsonPaths() {
        return jsonPaths;
    }
}
