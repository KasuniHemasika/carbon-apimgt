package org.wso2.carbon.apimgt.rest.api.webserver;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

@Provider
@Produces({MediaType.APPLICATION_JSON})
public class JacksonJsonProvider extends JacksonJaxbJsonProvider {

    public JacksonJsonProvider() {

        ObjectMapper objectMapper = new ObjectMapper()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .registerModule(new JodaModule())
            .setDateFormat(new ISO8601DateFormat());

        setMapper(objectMapper);
    }
}
