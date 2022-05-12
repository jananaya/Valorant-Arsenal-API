package schema;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"file:./src/main/resources/database.config.properties"})
public interface DatabaseConfig extends Config {
    String url();
    String user();
    
    @DefaultValue("")
    String password();
}