package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:src/test/java/config/${env}.properties" // mention the property file name
})
public interface Environment extends Config {

    String url();

    @Key("db.hostname")
    String getDBHostname();

    @Key("db.port")
    int getDBPort();

    @Key("db.username")
    String getDBUsername();

    @Key("db.password")
    String getDBPassword();

}
