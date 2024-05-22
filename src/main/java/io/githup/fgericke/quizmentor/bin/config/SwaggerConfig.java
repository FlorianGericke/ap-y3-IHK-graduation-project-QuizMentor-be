package io.githup.fgericke.quizmentor.bin.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    // The @Info annotation provides information about the API
    info = @Info(
        title = "QuizMentor API",
        version = "v1",
        description = "API for the QuizMentor Backend",
        contact = @Contact(
            name = "Gericke Florian",
            url = "https://github.com/FlorianGericke/ap-y3-IHK-graduation-project-QuizMentor"
        )),
    // The @Server annotation provides information about the server where the API is hosted
    servers = @Server(
        description = "Local development server",
        url = "http://localhost:8080/"
    ),
    // The @SecurityRequirement annotation specifies the security requirements for the API
    security = {
        @SecurityRequirement(name = "bearerAuth")
    }
)

// todo: Uncomment When Security is implemented

//@SecurityScheme(
//    // The @SecurityScheme annotation defines the security scheme for the API
//    name = "bearerAuth",
//    description = "JWT Bearer Token Authentication",
//    type = SecuritySchemeType.HTTP,
//    bearerFormat = "JWT",
//    in = SecuritySchemeIn.HEADER,
//    scheme= "Bearer"
//)
public class SwaggerConfig {

}
