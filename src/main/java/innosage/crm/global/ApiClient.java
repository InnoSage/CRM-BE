package innosage.crm.global;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiClient {

    private final RestTemplate restTemplate;

    @Value("${ai.server.url}")
    private String BASE_URL;

    @Autowired
    public ApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Async
    public void sendGetRequest(Long organizationId, Long sheetId) {
        String url = String.format(BASE_URL + "/%d/%d", organizationId, sheetId);
        System.out.println("url = " + url);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println("Response: " + response.getBody());
    }

    public void sendDeleteRequest(Long organizationId, Long sheetId) {
        String url = String.format(BASE_URL + "/%d/%d", organizationId, sheetId);
        restTemplate.delete(url);
    }
}
