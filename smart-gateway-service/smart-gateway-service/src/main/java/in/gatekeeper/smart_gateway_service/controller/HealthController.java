package in.gatekeeper.smart_gateway_service.controller;

import in.gatekeeper.smart_gateway_service.dto.responseDto.healthResponse;
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
    public ResponseEntity<healthResponse> health() {
        healthResponse response = new healthResponse();
        response.serviceName = serviceName;
        response.serviceDescription = serviceDescription;
        response.serviceStatus = "Up";
        return ResponseEntity.ok(response);
    }
}
