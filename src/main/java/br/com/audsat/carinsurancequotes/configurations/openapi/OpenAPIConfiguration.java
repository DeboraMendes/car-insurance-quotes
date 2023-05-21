package br.com.audsat.carinsurancequotes.configurations.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class OpenAPIConfiguration {

    private final OpenAPIConfigurationProperties openAPIConfigurationProperties;

    @Bean
    public OpenAPI openAPI() {
        final Server server = new Server();
        server.setUrl(openAPIConfigurationProperties.getServer().getUrl());
        server.setDescription(openAPIConfigurationProperties.getServer().getDescription());

        final Contact contact = new Contact();
        contact.setEmail(openAPIConfigurationProperties.getContact().getEmail());
        contact.setName(openAPIConfigurationProperties.getContact().getName());
        contact.setUrl(openAPIConfigurationProperties.getContact().getUrl());

        final Info info = new Info()
                .title(openAPIConfigurationProperties.getInfo().getTitle())
                .version(openAPIConfigurationProperties.getInfo().getVersion())
                .description(openAPIConfigurationProperties.getInfo().getDescription())
                .contact(contact);

        return new OpenAPI()
                .info(info)
                .servers(List.of(server));
    }
}