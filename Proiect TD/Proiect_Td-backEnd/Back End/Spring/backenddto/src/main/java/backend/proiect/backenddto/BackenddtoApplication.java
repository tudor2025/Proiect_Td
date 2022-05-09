package backend.proiect.backenddto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackenddtoApplication {

	public static void main(String[] args) {

		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		SpringApplication.run(BackenddtoApplication.class, args);


	}

}
