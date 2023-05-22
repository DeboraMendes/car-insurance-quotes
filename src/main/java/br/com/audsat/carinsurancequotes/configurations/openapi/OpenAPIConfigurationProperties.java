package br.com.audsat.carinsurancequotes.configurations.openapi;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "open-api")
public class OpenAPIConfigurationProperties {

    private Server server = new Server();
    private Contact contact = new Contact();
    private Info info = new Info();

    @Getter
    @Setter
    public static class Server {
        private String url;
        private String description;
    }

    @Getter
    @Setter
    public static class Contact {
        private String email;
        private String name;
        private String url;
    }

    @Getter
    @Setter
    public static class Info {
        private String title;
        private String version;
        private String description;
    }

}
