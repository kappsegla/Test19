import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAssuredExampleIT {

    @Test
    void checkAstronautsInSpace(){
        //Start webserver


        get("http://api.open-notify.org/astros.json").then()
                .statusCode(200)
                .contentType("application/json")
                .body("message", equalTo("success"),
                        "number", equalTo(6));
    }
}
