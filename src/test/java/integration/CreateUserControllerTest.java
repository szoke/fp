package integration;

import com.aszoke.flashparty.Application;
import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"server.port:0", "spring.datasource.url:jdbc:h2:mem:flashparty;DB_CLOSE_ON_EXIT=FALSE"})
public class CreateUserControllerTest {

    @Value("${local.server.port}")
    private int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void testCreate() throws Exception {
        given()
                .header("Content-Type", "application/json")
                .body("{\"latitude\":\"1\", \"longitude\":\"2\"}")
         .when()
                .post("/users")
         .then()
                .assertThat()
                    .statusCode(201)
                    .body("id", is(1)).and()
                    .body("geoLocation.latitude", is(1)).and()
                    .body("geoLocation.longitude", is(2));
    }

}