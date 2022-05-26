package pe.gob.minjus.mcs.indicadores.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import pe.gob.minjus.mcs.indicadores.bean.GenericResponse;
import pe.gob.minjus.mcs.indicadores.service.ConsultaService;

@Component
@PropertySource(value = { "classpath:mcs-actualiza-indicadores.properties" })
public class Scheduler {
		
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ConsultaService consultaService;	
	
	@Scheduled(cron="${ejecucion.hst.cerrado}", zone="America/Lima")
	public void ejecutaHstCerrado() throws Exception {
		GenericResponse hstConsultaCerradoResponse = consultaService.ejecutaHstConsultaCerrado();
		logger.debug(hstConsultaCerradoResponse.toString());
		
		GenericResponse hstDiligenciaLibreCerradoResponse = consultaService.ejecutaHstDiligenciaLibreCerrado();
		logger.debug(hstDiligenciaLibreCerradoResponse.toString());
		
		GenericResponse hstEventoCerradoResponse = consultaService.ejecutaHstEventoCerrado();
		logger.debug(hstEventoCerradoResponse.toString());
		
		GenericResponse hstProductividadPatrocinioCerradoResponse = consultaService.ejecutaHstProductividadPatrocinioCerrado();
		logger.debug(hstProductividadPatrocinioCerradoResponse.toString());
	}
	
	@Scheduled(cron="${ejecucion.indi.diario}", zone="America/Lima")
	public void ejecutaIndiDiario() throws Exception {
		GenericResponse indiConsultaDiarioResponse = consultaService.ejecutaIndiConsultaDiario();
		logger.debug(indiConsultaDiarioResponse.toString());
		
		GenericResponse indiDiligenciaLibreDiarioResponse = consultaService.ejecutaIndiDiligenciaLibreDiario();
		logger.debug(indiDiligenciaLibreDiarioResponse.toString());
		
		GenericResponse indiEventoDiarioResponse = consultaService.ejecutaIndiEventoDiario();
		logger.debug(indiEventoDiarioResponse.toString());
		
		GenericResponse indiProductividadPatrocinioDiarioResponse = consultaService.ejecutaIndiProductividadPatrocinioDiario();
		logger.debug(indiProductividadPatrocinioDiarioResponse.toString());
	}
	
	@Scheduled(cron="${ejecucion.maestro}", zone="America/Lima")
	public void ejecutaMaestro() throws Exception {
		GenericResponse cargaMaestro = consultaService.cargaMaestros();
		logger.debug(cargaMaestro.toString());		

	}
}
