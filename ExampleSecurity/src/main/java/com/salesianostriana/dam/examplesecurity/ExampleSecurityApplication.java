package com.salesianostriana.dam.examplesecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleSecurityApplication.class, args);
	}


//    @Bean
//    CommandLineRunner cmd(UserRepository repository) {
//        return args -> {
//            String secretString = "qpwioeruqpiweoruqwioruqweioruqewioruqepworuqweoruqpwoeruqweioruqewu";
//            String username = "user";
//            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretString));
//            String token = Jwts.builder()
//                    .subject(username)
//                    .issuedAt(new Date())
//                    .expiration(Date.from(Instant.now().plus(1, ChronoUnit.HOURS)))
//                    .signWith(key, SignatureAlgorithm.HS256)
//                    .compact();
//            System.out.println("Token JWT generado para el usuario '" + username + "': " + token);
//        };
//    }

}
