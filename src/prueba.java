import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class prueba {
    public static void main(String[] args) {
        String filepath = "productos.json";

        try (FileReader a = new FileReader(filepath)) {
            Gson g = new Gson();
            Type i = new TypeToken<Map<String, Object>>() {
            }.getType();
            Map<String,Object>datos=g.fromJson(a,i);
            System.out.println(datos);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
