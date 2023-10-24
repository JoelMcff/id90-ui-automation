package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ConvertJson {

    private static Gson gson;

    private static Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder().create();
        }
        return gson;
    }
    public static ConvertJsonBuilder fromPath(String path) {
        return new ConvertJsonBuilder(path);
    }

    public static class ConvertJsonBuilder {
        private final String path;

        private ConvertJsonBuilder(String path) {
            this.path = path;
        }

        public <T> T toObject(Class<T> classOfT) {
            Gson gson = getGson();
            try (FileReader reader = new FileReader(path)) {
                return gson.fromJson(reader, classOfT);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException("Error converting JSON to object.", e);
            }
        }
    }
}
