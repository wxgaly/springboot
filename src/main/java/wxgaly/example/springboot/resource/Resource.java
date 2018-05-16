package wxgaly.example.springboot.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName Resource
 * @Description TODO
 * @Author WXGALY
 * @Date 2018-05-15 0:58
 * @Version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "wxgaly.example.opensource")
@PropertySource(value = "classpath:resource.properties")
public class Resource {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String website;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String language;

    public Resource() {
    }

    public Resource(String name, String website, String language) {
        this.name = name;
        this.website = website;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
