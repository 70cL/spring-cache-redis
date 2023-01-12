package cl.td.cache.config;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@EnableCaching
@Configuration
@RequiredArgsConstructor
public class RedisConfiguration implements CachingConfigurer {
    private final RedisConnectionFactory redisConnectionFactory;

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        String KEY_SEPERATOR = "#";
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

    //add if you want to save as json to redis
    @Bean
    public CacheManager redisCacheManager() {
        RedisSerializationContext.SerializationPair<Object> jsonSerializer =
                RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());

        return RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(redisConnectionFactory)
                .cacheDefaults(
                        RedisCacheConfiguration.defaultCacheConfig()
                                .serializeValuesWith(jsonSerializer)
                )
                .build();
    }
}
