package pe.gob.minjus.mcs.indicadores.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class GenericBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;
	private String data;

	public GenericBean() {

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "GenericBean [code=" + code + ", data=" + data + "]";
	}

}
