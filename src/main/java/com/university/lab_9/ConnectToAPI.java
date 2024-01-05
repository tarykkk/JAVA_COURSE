package com.university.lab_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectToAPI {
    private static final String APIKEY = "43a0cef4dd3b4c818a5328154582ef5d";
    private static final String ENDPOINT = "http://api.recrm.ru/json";

    public static String getData(String endpointPath, String queryParams) throws IOException {
        URL url = buildUrl(endpointPath, queryParams);
        return doGetRequest(url);

    }
    public static String doGetRequest(URL endpointURL) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) endpointURL.openConnection();

        // Set the request method to GET
        connection.setRequestMethod("GET");

        // Get the response code
        int responseCode = connection.getResponseCode();

        // Check if the request was successful (status code 200)
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder jsonResponse = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                jsonResponse.append(line);
            }

            reader.close();

            // Close the connection
            connection.disconnect();

            return jsonResponse.toString();
        } else {
            // Close the connection
            connection.disconnect();

            throw new IOException("Error: " + responseCode);
        }
    }

    public static URL buildUrl(String path, String queryParams) throws IOException {
        String resultUrl = ENDPOINT + path + "?key=" + APIKEY;

        if (!queryParams.isEmpty()) {
            resultUrl += "&" + queryParams;
        }

        return new URL(resultUrl);
    }
}
