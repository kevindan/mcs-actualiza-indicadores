package pe.gob.minjus.mcs.indicadores.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@PropertySource(value = { "classpath:mcs-actualiza-indicadores.properties" })
public class PropertiesBean {
	
	@Value("${dia.hstinicio}")
	private Integer diaHstInicio;
	
	@Value("${dia.hstcierre}")
	private Integer diaHstCierre;
	
	@Value("${dia.indiinicio}")
	private Integer diaIndiInicio;
	
	public PropertiesBean() {
		
	}

	public PropertiesBean(Integer diaHstInicio, Integer diaHstCierre, Integer diaIndiInicio) {
	
		this.diaHstInicio = diaHstInicio;
		this.diaHstCierre = diaHstCierre;
		this.diaIndiInicio = diaIndiInicio;
	}

	public Integer getDiaHstInicio() {
		return diaHstInicio;
	}

	public void setDiaHstInicio(Integer diaHstInicio) {
		this.diaHstInicio = diaHstInicio;
	}

	public Integer getDiaHstCierre() {
		return diaHstCierre;
	}

	public void setDiaHstCierre(Integer diaHstCierre) {
		this.diaHstCierre = diaHstCierre;
	}

	public Integer getDiaIndiInicio() {
		return diaIndiInicio;
	}

	public void setDiaIndiInicio(Integer diaIndiInicio) {
		this.diaIndiInicio = diaIndiInicio;
	}

	@Override
	public String toString() {
		return "PropertiesBean [diaHstInicio=" + diaHstInicio + ", diaHstCierre=" + diaHstCierre + ", diaIndiInicio="
				+ diaIndiInicio + "]";
	}
	
	

}
