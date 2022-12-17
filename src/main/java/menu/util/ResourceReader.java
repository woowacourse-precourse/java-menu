package menu.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResourceReader {

    public List<String> readResource(String path) {
        List<String> resources = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String resourceName = null;
            while ((resourceName = bufferedReader.readLine()) != null) {
                resources.add(resourceName);
            }
            return resources;
        } catch (IOException e) {
            return null;
        }
    }
}
