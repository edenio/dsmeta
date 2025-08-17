package com.devsuperior.ds_meta_be.infrastructure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties
public class Properties {

    private DataSource spring = new DataSource(); // Mapeia spring.datasource
    private Twilio twilio = new Twilio();        // Mapeia twilio

    @Getter
    @Setter
    public static class DataSource {
        private String url;
        private String username;
        private String password;
        private String driverClassName;
    }

    @Getter
    @Setter
    public static class Twilio {
        private String sid;
        private String key;
        private Phone phone = new Phone(); // Subclasse para o "phone" do YAML

        @Getter
        @Setter
        public static class Phone {
            private String from;
            private String to;
        }
    }
}
