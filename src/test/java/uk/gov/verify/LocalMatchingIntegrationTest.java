package uk.gov.verify;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.mashape.unirest.http.Unirest.post;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static uk.gov.verify.LocalMatchingService.DEFAULT_PORT;

public class LocalMatchingIntegrationTest {

    @BeforeClass
    public static void startApp() {
        LocalMatchingService.main(null);
    }

    @AfterClass
    public static void stopApp() {
        LocalMatchingService.shutdown();
    }

    @Test
    public void shouldReturnMatchOnMatchingRequest() throws UnirestException {
        HttpResponse<String> stringHttpResponse = post(String.format(
                "http://localhost:%d/stub-matching/matching-service/POST",
                DEFAULT_PORT)
        ).asString();

        assertThat(stringHttpResponse.getBody(), is("{\"result\":\"match\"}"));
    }

    @Test
    public void shouldReturnSuccessOnUserCreationRequest() throws UnirestException {
        HttpResponse<String> stringHttpResponse = post(String.format(
                "http://localhost:%d/stub-matching/unknown-user/POST",
                DEFAULT_PORT)
        ).asString();

        assertThat(stringHttpResponse.getBody(), is("{\"result\":\"success\"}"));
    }
}