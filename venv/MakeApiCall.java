package venv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class MakeApiCall {

    public static void main(String[] args) {
        // Prepare the URI and headers for the HTTP request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jokes-by-api-ninjas.p.rapidapi.com/v1/jokes"))
                .header("X-RapidAPI-Host", "jokes-by-api-ninjas.p.rapidapi.com")
                .header("X-RapidAPI-Key", "adbc9d71e3mshb23e9dda5c16bfcp1746d2jsnecfd5e08423f") // Replace 'your_api_key_here' with your actual API key
                .GET() // This can be used instead of .method("get",
                       // HttpRequest.BodyPublishers.noBody())
                .build();

        // Create a new HttpClient with default settings
        HttpClient client = HttpClient.newHttpClient();

        try {
            // Send the request and receive a response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Check response status code and handle response
            if (response.statusCode() == 200) {
                System.out.println("Response Body:");
                System.out.println(response.body());
            } else {
                System.out.println("Failed to fetch data: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Request error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
