package pe.gob.minjus.mcs.indicadores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class McsActualizaIndicadoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(McsActualizaIndicadoresApplication.class, args);
	}

}
