package pe.gob.minjus.mcs.indicadores.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.minjus.mcs.indicadores.bean.GenericResponse;
import pe.gob.minjus.mcs.indicadores.service.ConsultaService;

@RestController
@RequestMapping("/actualiza")
public class ConsultaController {
	
	@Autowired
	private ConsultaService consultaService;


	@GetMapping(value = "/hstConsultaCerrado", produces = "application/json; charset=UTF-8")
	public GenericResponse ejecutaHstConsultaCerrado() throws Exception{
		return consultaService.ejecutaHstConsultaCerrado();	
	}
	
	@GetMapping(value = "/indiConsultaDiario", produces = "application/json; charset=UTF-8")
	public GenericResponse ejecutaIndiConsultaDiario() throws Exception{
		return consultaService.ejecutaIndiConsultaDiario();
	}
	
	@GetMapping(value = "/hstDiligenciaLibreCerrado", produces = "application/json; charset=UTF-8")
	public GenericResponse ejecutaHstDiligenciaLibreCerrado() throws Exception{
		return consultaService.ejecutaHstDiligenciaLibreCerrado();
	}
	
	@GetMapping(value = "/indiDiligenciaLibreDiario", produces = "application/json; charset=UTF-8")
	public GenericResponse ejecutaIndiDiligenciaLibreDiario() throws Exception{
		return consultaService.ejecutaIndiDiligenciaLibreDiario();
	}
	
	@GetMapping(value = "/hstEventoCerrado", produces = "application/json; charset=UTF-8")
	public GenericResponse ejecutaHstEventoCerrado() throws Exception{
		return consultaService.ejecutaHstEventoCerrado();
	}
	
	@GetMapping(value = "/indiEventoDiario", produces = "application/json; charset=UTF-8")
	public GenericResponse ejecutaIndiEventoDiario() throws Exception{
		return consultaService.ejecutaIndiEventoDiario();
	}

	@GetMapping(value = "/hstPatrocinioDelitoCerrado", produces = "application/json; charset=UTF-8")
	public GenericResponse ejecutaHstPatrocinioDelitoCerrado() throws Exception{
		return consultaService.ejecutaHstPatrocinioDelitoCerrado();
	}
	
	@GetMapping(value = "/indiPatrocinioDelitoDiario", produces = "application/json; charset=UTF-8")
	public GenericResponse ejecutaIndiPatrocinioDelitoDiario() throws Exception{
		return consultaService.ejecutaIndiPatrocinioDelitoDiario();
	}
		
	@GetMapping(value = "/hstProductividadPatrocinioCerrado", produces = "application/json; charset=UTF-8")
	public GenericResponse ejecutaHstProductividadPatrocinioCerrado() throws Exception{
		return consultaService.ejecutaHstProductividadPatrocinioCerrado();
	}
	
	@GetMapping(value = "/indiProductividadPatrocinioDiario", produces = "application/json; charset=UTF-8")
	public GenericResponse ejecutaIndiProductividadPatrocinioDiario() throws Exception{
		return consultaService.ejecutaIndiProductividadPatrocinioDiario();
	}
	
	@GetMapping(value = "/cargaMaestros", produces = "application/json; charset=UTF-8")
	public GenericResponse ejecutaCargaMaestros() throws Exception{
		return consultaService.cargaMaestros();
	}
}
