package org.example.PartialDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PartialDeserializer {
    public static void main(String[] args) {
        try {
            // Full JSON string (maybe received from API)
            String json = "{\"name\":\"Pratiksha\", \"age\":25, \"email\":\"you@example.com\"}";

            // Deserialize to DTO (only email field will be mapped)
            ObjectMapper objectMapper = new ObjectMapper();
            UserEmailDTO dto = objectMapper.readValue(json, UserEmailDTO.class);

            // Output the result
            System.out.println("Deserialized DTO:");
            System.out.println(dto);  // Output: UserEmailDTO{email='you@example.com'}

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
