package pe.gob.minjus.mcs.indicadores.util;

import java.time.LocalDate;

public class Util {
	
	public LocalDate retornaHstFechaCierre(Integer diaHstCierre) {
		
		LocalDate fechaHoy = LocalDate.now();
		LocalDate fechaCierre = LocalDate.of(fechaHoy.getYear(), fechaHoy.getMonthValue(), diaHstCierre);
		 	
		return fechaCierre;
	}
	
	public LocalDate retornaFechaHstInicioCierre(Integer diaHstInicioCierre) {
		
		LocalDate fechaHoy = LocalDate.now();
		
		if(fechaHoy.getMonthValue() == 1) {
			LocalDate fechaCierre = LocalDate.of(fechaHoy.getYear()-1, 12, diaHstInicioCierre);			
			return fechaCierre;
		}else {
			LocalDate fechaCierre = LocalDate.of(fechaHoy.getYear(), fechaHoy.getMonthValue()-1, diaHstInicioCierre);			
			return fechaCierre;
		}
	}
	
	public LocalDate retornaIndiFechaInicio(Integer diaIndiInicio) {
		
		LocalDate fechaHoy = LocalDate.now();
		LocalDate fechaCierre = LocalDate.of(fechaHoy.getYear(), fechaHoy.getMonthValue(), diaIndiInicio);
		 	
		return fechaCierre;
	}

}
