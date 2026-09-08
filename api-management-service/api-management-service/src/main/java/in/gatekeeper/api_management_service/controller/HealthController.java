package in.gatekeeper.api_management_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    private final String serviceName;
    private final String serviceDescription;

    public HealthController(@Value("${info.app.name}") String serviceName,
                            @Value("${info.app.description}") String serviceDescription) {
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        String body = serviceName + " is healthy. " + serviceDescription;
        return ResponseEntity.ok(body);
    }
}
