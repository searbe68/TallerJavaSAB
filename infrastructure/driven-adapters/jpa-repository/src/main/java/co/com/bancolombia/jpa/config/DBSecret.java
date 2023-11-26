package co.com.bancolombia.jpa.config;

import lombok.Builder;
import lombok.Getter;
import org.springframework.context.annotation.Bean;

@Getter
@Builder
public class DBSecret {
    private final String url;
    private final String username;
    private final String password;

}
