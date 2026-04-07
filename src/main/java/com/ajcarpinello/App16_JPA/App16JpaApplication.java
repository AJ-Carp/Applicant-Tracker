package com.ajcarpinello.App16_JPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App16JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(App16JpaApplication.class, args);
	}

}


// this project is best practice for common entity relationships
/*
    The best practice is to make it so that one side of the relationship (applicant) has a foreign
    key pointing to the primary key of the other side of the relationship (resume). The other
    side should not have a foreign key at all (pointing to applicant) (that would be circular). But both sides
    will have references to each other through the java properties by having the non-owning side (resume) have mappedBy.
 */

// left off: https://www.youtube.com/watch?v=HWliKlc-HiI&list=PL-bgVzzRdaPhNeXyQBtp8hMlUc14J2kRK&index=30
// 8:16


