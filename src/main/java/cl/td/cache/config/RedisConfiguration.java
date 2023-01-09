package cl.td.cache.config;

import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class RedisConfiguration implements CachingConfigurer {
    private String KEY_SEPERATOR = "#";
    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {

            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getSimpleName());
            sb.append(KEY_SEPERATOR);
            sb.append(method.getName());
            sb.append(KEY_SEPERATOR);
            for(Object param : params){
                sb.append(param.toString());
                sb.append(KEY_SEPERATOR);
            }

            String str = sb.toString();

            return str.substring(0, str.length() - 1);
        };
    }
}
