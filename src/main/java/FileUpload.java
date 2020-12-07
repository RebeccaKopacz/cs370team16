import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

// help from source: https://crunchify.com/create-very-simple-jersey-rest-service-and-send-json-data-from-java-client/

public class FileUpload {
    public static void main(String[] args) {
        String string = "";
        try {

            // Step1: Let's 1st read file from fileSystem
            // Change JSONFile.txt path here
            InputStream fileInputStream = new FileInputStream("/Users/<username>/Documents/JSONFile.txt");
            InputStreamReader fileReader = new InputStreamReader(fileInputStream);
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine()) != null) {
                string += line + "\n";
            }

            JSONObject jsonObject = new JSONObject(string);
            System.out.println(jsonObject);

            // Step2: Now pass JSON File Data to REST Service
            try {
                URL url = new URL("http://localhost:8080/CrunchifyTutorials/api/crunchifyService");
                URLConnection connection = url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                out.write(jsonObject.toString());
                out.close();

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                while (in.readLine() != null) {
                }
                System.out.println("\nClient REST Service Invoked Successfully..");
                in.close();
            } catch (Exception e) {
                System.out.println("\nError while calling Client REST Service");
                System.out.println(e);
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}