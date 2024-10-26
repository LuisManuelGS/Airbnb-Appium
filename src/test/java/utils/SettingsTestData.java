package utils;

import aquality.appium.mobile.application.AqualityServices;
import com.google.gson.Gson;
import lombok.experimental.UtilityClass;
import models.Coordinates;
import java.io.FileNotFoundException;
import java.io.FileReader;

@UtilityClass
public class SettingsTestData {

    public final String RESOURCE_FILE_PATH = "src/test/resources/";
    private final String COORDINATES_FILE_PATH = RESOURCE_FILE_PATH + "coordinates.json";
    private final String ERROR_MSG = "File with coordinates settings not found or incorrect";
    private final Gson GSON = new Gson();

    public Coordinates getCoordinates() {
        try {
            return GSON.fromJson(new FileReader(COORDINATES_FILE_PATH), Coordinates.class);
        }
        catch (FileNotFoundException e) {
            AqualityServices.getLogger().error(ERROR_MSG);
            throw new RuntimeException(ERROR_MSG);
        }
    }
}
