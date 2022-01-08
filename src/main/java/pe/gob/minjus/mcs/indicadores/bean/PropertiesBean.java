package pe.gob.minjus.mcs.indicadores.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@PropertySource(value = { "classpath:mcs-actualiza-indicadores.properties" })
public class PropertiesBean {
	
	@Value("${dia.hstinicio}")
	private Integer diaHstInicio;
	
	@Value("${dia.hstcierre}")
	private Integer diaHstCierre;
	
	@Value("${dia.indiinicio}")
	private Integer diaIndiInicio;

}
