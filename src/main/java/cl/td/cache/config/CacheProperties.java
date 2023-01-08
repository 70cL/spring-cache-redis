package cl.td.cache.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties("cache")
public class CacheProperties {

    Map<String, Long> expirations = new HashMap<>();

    public Map<String, Long> getExpirations() {
        return expirations;
    }

    public void setExpirations(Map<String, Long> expirations) {
        this.expirations = expirations;
    }
}
