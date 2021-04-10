/**
 * FirebaseConfig -- initializes base firebase for authentication process
 */
package com.atticsft.demomwi.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

/**
 * @author michaelbedry
 *
 */
@Configuration
public class FirebaseConfig {

	@Primary
	@Bean
	public void initialize() throws IOException {
	
		File resource = new ClassPathResource("serviceAccount.json").getFile();
		
		InputStream serviceAccount = new FileInputStream(resource);
	
		FirebaseOptions options = new FirebaseOptions.Builder().
				setCredentials(GoogleCredentials.fromStream(serviceAccount)).
				setDatabaseUrl("https://exman1-ca28d.firebaseio.com").build();
				
				
		if (FirebaseApp.getApps().isEmpty()) {
		FirebaseApp.initializeApp(options);
		}
	}
	
	public Firestore getFirebase() {
		return FirestoreClient.getFirestore();
	}

}
