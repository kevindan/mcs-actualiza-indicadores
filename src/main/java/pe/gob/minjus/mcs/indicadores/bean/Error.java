package pe.gob.minjus.mcs.indicadores.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Error implements Serializable {

	private static final long serialVersionUID = 1L;

	private String error;

	public Error() {

	}

	public Error(String error) {

		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "Error [error=" + error + "]";
	}

}
