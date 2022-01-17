package pe.gob.minjus.mcs.indicadores.service;

import pe.gob.minjus.mcs.indicadores.bean.GenericResponse;

public interface ConsultaService {

	GenericResponse ejecutaHstConsultaCerrado() throws Exception;
	GenericResponse ejecutaIndiConsultaDiario() throws Exception;
	
	GenericResponse ejecutaHstDiligenciaLibreCerrado() throws Exception;
	GenericResponse ejecutaIndiDiligenciaLibreDiario() throws Exception;
	
	GenericResponse ejecutaHstEventoCerrado() throws Exception;
	GenericResponse ejecutaIndiEventoDiario() throws Exception;

	GenericResponse ejecutaHstPatrocinioDelitoCerrado() throws Exception;
	GenericResponse ejecutaIndiPatrocinioDelitoDiario() throws Exception;
	
	GenericResponse ejecutaHstProductividadPatrocinioCerrado() throws Exception;
	GenericResponse ejecutaIndiProductividadPatrocinioDiario() throws Exception;
	
	GenericResponse cargaMaestros() throws Exception;
	
}
