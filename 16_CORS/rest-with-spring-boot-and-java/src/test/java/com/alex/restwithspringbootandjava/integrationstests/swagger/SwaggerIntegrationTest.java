package com.alex.restwithspringbootandjava.integrationstests.swagger;

import static io.restassured.RestAssured.given;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.alex.restwithspringbootandjava.configs.TestConfigs;
import com.alex.restwithspringbootandjava.integrationstests.testcontainers.AbstractIntegrationTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerIntegrationTest extends AbstractIntegrationTest {

	@Test
	public void shouldDisplaySwaggerUiPage() {
		String content = given().basePath("/swagger-ui/index.html").port(TestConfigs.SERVER_PORT).when().get().then()
				.statusCode(200).extract().body().asString();
		assertTrue(content.contains("Swagger UI"));
	}

}
