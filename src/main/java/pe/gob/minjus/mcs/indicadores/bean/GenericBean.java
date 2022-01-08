package pe.gob.minjus.mcs.indicadores.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;
	private String data;
	
}
