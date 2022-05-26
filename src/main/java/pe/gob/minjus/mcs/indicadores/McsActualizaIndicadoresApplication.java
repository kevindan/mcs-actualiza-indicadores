package pe.gob.minjus.mcs.indicadores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class McsActualizaIndicadoresApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {		
		return builder.sources(McsActualizaIndicadoresApplication.class);
	}

//	public static void main(String[] args) {
//		SpringApplication.run(McsActualizaIndicadoresApplication.class, args);
//	}

}
