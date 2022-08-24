package pe.gob.minjus.mcs.indicadores.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.logging.LogLevel;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.gob.minjus.mcs.indicadores.bean.Error;
import pe.gob.minjus.mcs.indicadores.bean.GenericBean;
import pe.gob.minjus.mcs.indicadores.bean.GenericResponse;
import pe.gob.minjus.mcs.indicadores.bean.PropertiesBean;
import pe.gob.minjus.mcs.indicadores.dao.ConsultaDao;
import pe.gob.minjus.mcs.indicadores.service.ConsultaService;
import pe.gob.minjus.mcs.indicadores.util.Util;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ConsultaDao consultaDao;
	
	@Autowired
	private PropertiesBean propertiesBean;

	@Override
	public GenericResponse ejecutaHstConsultaCerrado() throws Exception{
		GenericResponse response = new GenericResponse();		
		Util util = new Util();	
		try {
			GenericBean responseTranformacion = new GenericBean();
			//Verificamos la existencia de registros con la misma fecha de cierre
			LocalDate fechaCierre = util.retornaHstFechaCierre(propertiesBean.getDiaHstCierre());
			LocalDate fechaInicio = util.retornaFechaHstInicioCierre(propertiesBean.getDiaHstInicio());
			boolean existeRegistros = consultaDao.existeFechaCierre("hst_consulta_cerrado", fechaCierre.toString());
			if(existeRegistros==true) {
				// Si existe registros con la fecha de cierre, se procede a eliminar
				GenericBean	responseDelete = consultaDao.eliminarRegistros("hst_consulta_cerrado", fechaCierre.toString(),1);
				if(responseDelete.getCode().equals("0000")) {
					//Ejecuta la transformación
					responseTranformacion = this.ejecutaTransformacion("carga_hst_consulta_cerrado.ktr", fechaInicio.toString(), fechaCierre.toString(),1);
					response.setCode(responseTranformacion.getCode());
					response.setMessage(responseTranformacion.getData());
					response.setData(null);
				}else {
					response.setCode("9002");
					response.setMessage("Ha ocurrido un error al eliminar la data con fecha de cierre "+fechaCierre.toString());
					response.setData(null);
				}
			}else {
				responseTranformacion = this.ejecutaTransformacion("carga_hst_consulta_cerrado.ktr", fechaInicio.toString(), fechaCierre.toString(),1);
				response.setCode(responseTranformacion.getCode());
				response.setMessage(responseTranformacion.getData());
				response.setData(null);
			}			
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setCode("9000");
			response.setMessage(e.getMessage());
			response.setData(null);
		}
		return response;
	}

	@Override
	public GenericResponse ejecutaIndiConsultaDiario() throws Exception{
		GenericResponse response = new GenericResponse();
		Util util = new Util();	
		try {
			GenericBean responseTranformacion = new GenericBean();						
			LocalDate fechaInicio = util.retornaIndiFechaInicio(propertiesBean.getDiaIndiInicio());
			// Si existe registros con la fecha de cierre, se procede a eliminar
			GenericBean	responseDelete = consultaDao.eliminarRegistros("indi_consulta_diario", null,2);
			if(responseDelete.getCode().equals("0000")) {
				//Ejecuta la transformación
				responseTranformacion = this.ejecutaTransformacion("carga_indi_consulta_diario.ktr", fechaInicio.toString(), null, 2);
				response.setCode(responseTranformacion.getCode());
				response.setMessage(responseTranformacion.getData());
				response.setData(null);
			}else {
				response.setCode("9002");
				response.setMessage("Ha ocurrido un error al eliminar la data de la tabla indi_consulta_diario");
				response.setData(null);
			}			
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setCode("9000");
			response.setMessage(e.getMessage());
			response.setData(null);
		}
		return response;
	}

	@Override
	public GenericResponse ejecutaHstDiligenciaLibreCerrado() throws Exception{
		GenericResponse response = new GenericResponse();		
		Util util = new Util();	
		try {
			GenericBean responseTranformacion = new GenericBean();
			//Verificamos la existencia de registros con la misma fecha de cierre
			LocalDate fechaCierre = util.retornaHstFechaCierre(propertiesBean.getDiaHstCierre());
			LocalDate fechaInicio = util.retornaFechaHstInicioCierre(propertiesBean.getDiaHstInicio());
			boolean existeRegistros = consultaDao.existeFechaCierre("hst_diligencia_libre_cerrado", fechaCierre.toString());
			if(existeRegistros==true) {
				// Si existe registros con la fecha de cierre, se procede a eliminar
				GenericBean	responseDelete = consultaDao.eliminarRegistros("hst_diligencia_libre_cerrado", fechaCierre.toString(),1);
				if(responseDelete.getCode().equals("0000")) {
					//Ejecuta la transformación
					responseTranformacion = this.ejecutaTransformacion("carga_hst_diligencia_libre_cerrado.ktr", fechaInicio.toString(), fechaCierre.toString(),1);
					response.setCode(responseTranformacion.getCode());
					response.setMessage(responseTranformacion.getData());
					response.setData(null);
				}else {
					response.setCode("9002");
					response.setMessage("Ha ocurrido un error al eliminar la data con fecha de cierre "+fechaCierre.toString());
					response.setData(null);
				}
			}else {
				responseTranformacion = this.ejecutaTransformacion("carga_hst_diligencia_libre_cerrado.ktr", fechaInicio.toString(), fechaCierre.toString(),1);
				response.setCode(responseTranformacion.getCode());
				response.setMessage(responseTranformacion.getData());
				response.setData(null);
			}			
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setCode("9000");
			response.setMessage(e.getMessage());
			response.setData(null);
		}
		return response;
	}

	@Override
	public GenericResponse ejecutaIndiDiligenciaLibreDiario() throws Exception{
		GenericResponse response = new GenericResponse();
		Util util = new Util();	
		try {
			GenericBean responseTranformacion = new GenericBean();						
			LocalDate fechaInicio = util.retornaIndiFechaInicio(propertiesBean.getDiaIndiInicio());
			// Si existe registros con la fecha de cierre, se procede a eliminar
			GenericBean	responseDelete = consultaDao.eliminarRegistros("indi_diligencia_libre_diario", null,2);
			if(responseDelete.getCode().equals("0000")) {
				//Ejecuta la transformación
				responseTranformacion = this.ejecutaTransformacion("carga_indi_diligencia_libre_diario.ktr", fechaInicio.toString(), null, 2);
				response.setCode(responseTranformacion.getCode());
				response.setMessage(responseTranformacion.getData());
				response.setData(null);
			}else {
				response.setCode("9002");
				response.setMessage("Ha ocurrido un error al eliminar la data de la tabla indi_diligencia_libre_diario");
				response.setData(null);
			}			
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setCode("9000");
			response.setMessage(e.getMessage());
			response.setData(null);
		}
		return response;
	}

	@Override
	public GenericResponse ejecutaHstEventoCerrado() throws Exception{
		GenericResponse response = new GenericResponse();		
		Util util = new Util();	
		try {
			GenericBean responseTranformacion = new GenericBean();
			//Verificamos la existencia de registros con la misma fecha de cierre
			LocalDate fechaCierre = util.retornaHstFechaCierre(propertiesBean.getDiaHstCierre());
			LocalDate fechaInicio = util.retornaFechaHstInicioCierre(propertiesBean.getDiaHstInicio());
			boolean existeRegistros = consultaDao.existeFechaCierre("hst_evento_cerrado", fechaCierre.toString());
			if(existeRegistros==true) {
				// Si existe registros con la fecha de cierre, se procede a eliminar
				GenericBean	responseDelete = consultaDao.eliminarRegistros("hst_evento_cerrado", fechaCierre.toString(),1);
				if(responseDelete.getCode().equals("0000")) {
					//Ejecuta la transformación
					responseTranformacion = this.ejecutaTransformacion("carga_hst_evento_cerrado.ktr", fechaInicio.toString(), fechaCierre.toString(),1);
					response.setCode(responseTranformacion.getCode());
					response.setMessage(responseTranformacion.getData());
					response.setData(null);
				}else {
					response.setCode("9002");
					response.setMessage("Ha ocurrido un error al eliminar la data con fecha de cierre "+fechaCierre.toString());
					response.setData(null);
				}
			}else {
				responseTranformacion = this.ejecutaTransformacion("carga_hst_evento_cerrado.ktr", fechaInicio.toString(), fechaCierre.toString(),1);
				response.setCode(responseTranformacion.getCode());
				response.setMessage(responseTranformacion.getData());
				response.setData(null);
			}			
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setCode("9000");
			response.setMessage(e.getMessage());
			response.setData(null);
		}
		return response;
	}

	@Override
	public GenericResponse ejecutaIndiEventoDiario() throws Exception{
		GenericResponse response = new GenericResponse();
		Util util = new Util();	
		try {
			GenericBean responseTranformacion = new GenericBean();						
			LocalDate fechaInicio = util.retornaIndiFechaInicio(propertiesBean.getDiaIndiInicio());
			// Si existe registros con la fecha de cierre, se procede a eliminar
			GenericBean	responseDelete = consultaDao.eliminarRegistros("indi_evento_diario", null,2);
			if(responseDelete.getCode().equals("0000")) {
				//Ejecuta la transformación
				responseTranformacion = this.ejecutaTransformacion("carga_indi_evento_diario.ktr", fechaInicio.toString(), null, 2);
				response.setCode(responseTranformacion.getCode());
				response.setMessage(responseTranformacion.getData());
				response.setData(null);
			}else {
				response.setCode("9002");
				response.setMessage("Ha ocurrido un error al eliminar la data de la tabla indi_evento_diario");
				response.setData(null);
			}			
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setCode("9000");
			response.setMessage(e.getMessage());
			response.setData(null);
		}
		return response;
	}

	@Override
	public GenericResponse ejecutaHstPatrocinioDelitoCerrado() throws Exception{
		GenericResponse response = new GenericResponse();		
		Util util = new Util();	
		try {
			GenericBean responseTranformacion = new GenericBean();
			//Verificamos la existencia de registros con la misma fecha de cierre
			LocalDate fechaCierre = util.retornaHstFechaCierre(propertiesBean.getDiaHstCierre());
			LocalDate fechaInicio = util.retornaFechaHstInicioCierre(propertiesBean.getDiaHstInicio());
			boolean existeRegistros = consultaDao.existeFechaCierre("hst_patrocinio_delito_cerrado", fechaCierre.toString());
			if(existeRegistros==true) {
				// Si existe registros con la fecha de cierre, se procede a eliminar
				GenericBean	responseDelete = consultaDao.eliminarRegistros("hst_patrocinio_delito_cerrado", fechaCierre.toString(),1);
				if(responseDelete.getCode().equals("0000")) {
					//Ejecuta la transformación
					responseTranformacion = this.ejecutaTransformacion("carga_hst_patrocinio_delito_cerrado.ktr", fechaInicio.toString(), fechaCierre.toString(),1);
					response.setCode(responseTranformacion.getCode());
					response.setMessage(responseTranformacion.getData());
					response.setData(null);
				}else {
					response.setCode("9002");
					response.setMessage("Ha ocurrido un error al eliminar la data con fecha de cierre "+fechaCierre.toString());
					response.setData(null);
				}
			}else {
				responseTranformacion = this.ejecutaTransformacion("carga_hst_patrocinio_delito_cerrado.ktr", fechaInicio.toString(), fechaCierre.toString(),1);
				response.setCode(responseTranformacion.getCode());
				response.setMessage(responseTranformacion.getData());
				response.setData(null);
			}			
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setCode("9000");
			response.setMessage(e.getMessage());
			response.setData(null);
		}
		return response;
	}

	@Override
	public GenericResponse ejecutaIndiPatrocinioDelitoDiario() throws Exception{
		GenericResponse response = new GenericResponse();
		Util util = new Util();	
		try {
			GenericBean responseTranformacion = new GenericBean();						
			LocalDate fechaInicio = util.retornaIndiFechaInicio(propertiesBean.getDiaIndiInicio());
			// Si existe registros con la fecha de cierre, se procede a eliminar
			GenericBean	responseDelete = consultaDao.eliminarRegistros("indi_patrocinio_delito_diario", null,2);
			if(responseDelete.getCode().equals("0000")) {
				//Ejecuta la transformación
				responseTranformacion = this.ejecutaTransformacion("carga_indi_patrocinio_delito_diario.ktr", fechaInicio.toString(), null, 2);
				response.setCode(responseTranformacion.getCode());
				response.setMessage(responseTranformacion.getData());
				response.setData(null);
			}else {
				response.setCode("9002");
				response.setMessage("Ha ocurrido un error al eliminar la data de la tabla indi_patrocinio_delito_diario");
				response.setData(null);
			}			
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setCode("9000");
			response.setMessage(e.getMessage());
			response.setData(null);
		}
		return response;
	}

	@Override
	public GenericResponse ejecutaHstProductividadPatrocinioCerrado() throws Exception{
		GenericResponse response = new GenericResponse();		
		Util util = new Util();	
		try {
			GenericBean responseTranformacion = new GenericBean();
			//Verificamos la existencia de registros con la misma fecha de cierre
			LocalDate fechaCierre = util.retornaHstFechaCierre(propertiesBean.getDiaHstCierre());
			LocalDate fechaInicio = util.retornaFechaHstInicioCierre(propertiesBean.getDiaHstInicio());
			boolean existeRegistros = consultaDao.existeFechaCierre("hst_productividad_patrocinio_cerrado", fechaCierre.toString());
			if(existeRegistros==true) {
				// Si existe registros con la fecha de cierre, se procede a eliminar
				GenericBean	responseDelete = consultaDao.eliminarRegistros("hst_productividad_patrocinio_cerrado", fechaCierre.toString(),1);
				if(responseDelete.getCode().equals("0000")) {
					//Ejecuta la transformación
					responseTranformacion = this.ejecutaTransformacion("carga_hst_productividad_patrocinio_cerrado.ktr", fechaInicio.toString(), fechaCierre.toString(),1);
					response.setCode(responseTranformacion.getCode());
					response.setMessage(responseTranformacion.getData());
					response.setData(null);
				}else {
					response.setCode("9002");
					response.setMessage("Ha ocurrido un error al eliminar la data con fecha de cierre "+fechaCierre.toString());
					response.setData(null);
				}
			}else {
				responseTranformacion = this.ejecutaTransformacion("carga_hst_productividad_patrocinio_cerrado.ktr", fechaInicio.toString(), fechaCierre.toString(),1);
				response.setCode(responseTranformacion.getCode());
				response.setMessage(responseTranformacion.getData());
				response.setData(null);
			}			
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setCode("9000");
			response.setMessage(e.getMessage());
			response.setData(null);
		}
		return response;
	}

	@Override
	public GenericResponse ejecutaIndiProductividadPatrocinioDiario() throws Exception{
		GenericResponse response = new GenericResponse();
		Util util = new Util();	
		try {
			GenericBean responseTranformacion = new GenericBean();						
			LocalDate fechaInicio = util.retornaIndiFechaInicio(propertiesBean.getDiaIndiInicio());
			// Si existe registros con la fecha de cierre, se procede a eliminar
			GenericBean	responseDelete = consultaDao.eliminarRegistros("indi_productividad_patrocinio_diario", null, 2);
			if(responseDelete.getCode().equals("0000")) {
				//Ejecuta la transformación
				responseTranformacion = this.ejecutaTransformacion("carga_indi_productividad_patrocinio_diario.ktr", fechaInicio.toString(), null, 2);
				response.setCode(responseTranformacion.getCode());
				response.setMessage(responseTranformacion.getData());
				response.setData(null);
			}else {
				response.setCode("9002");
				response.setMessage("Ha ocurrido un error al eliminar la data de la tabla indi_productividad_patrocinio_diario");
				response.setData(null);
			}			
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setCode("9000");
			response.setMessage(e.getMessage());
			response.setData(null);
		}
		return response;
	}
	
	private GenericBean ejecutaTransformacion(String nombreTransformacion, String fechaInicio, String fechaCierre, Integer tipoOperacion) throws Exception{
		GenericBean response = new GenericBean();		
		String mensaje = "La transformación "+nombreTransformacion+" se ha ejecutado con éxito";		
		try {
			
			KettleEnvironment.init();
			
			//TransMeta transMeta = new TransMeta("C:\\transformaciones\\"+nombreTransformacion);
			TransMeta transMeta = new TransMeta("/opt/Filesystem/dgdpaj/dgdpaj/transformaciones/"+nombreTransformacion);
			//TransMeta transMeta = new TransMeta(nombreTransformacion);
			Trans trans = new Trans(transMeta);
			
			if(tipoOperacion==1) {
				trans.setParameterValue("FECHA_CIERRE", "'"+fechaCierre+"'");
				trans.setParameterValue("FECHA_INICIO", "'"+fechaInicio+"'");
				
			}else {
				trans.setParameterValue("FECHA_INICIO", "'"+fechaInicio+"'");
			}

			trans.setLogLevel(LogLevel.DEBUG);
			trans.execute(null);
			trans.waitUntilFinished();
						
			if(trans.getErrors() > 0) {
				mensaje = "Ocurrió un error al ejecutar la transformación "+nombreTransformacion;
				logger.error(mensaje);
				response.setCode("9999");
				response.setData(mensaje);
				return response;
			}
		
			logger.debug(mensaje);
			response.setCode("0000");
			response.setData(mensaje);
					
		} catch (KettleException e) {
			logger.error(e.getMessage());
			response.setCode("9001");
			response.setData(e.getMessage());
		}		
		return response;
	}
	
	private GenericBean ejecutaTransformacionMaestro(String nombreTransformacion) throws Exception{
		GenericBean response = new GenericBean();		
		String mensaje = "La transformación "+nombreTransformacion+" se ha ejecutado con éxito";		
		try {
			
			KettleEnvironment.init();
		
			//TransMeta transMeta = new TransMeta("C:\\transformaciones\\"+nombreTransformacion);
			TransMeta transMeta = new TransMeta("/opt/Filesystem/dgdpaj/dgdpaj/transformaciones/"+nombreTransformacion);
			//TransMeta transMeta = new TransMeta(nombreTransformacion);
			Trans trans = new Trans(transMeta);

			trans.setLogLevel(LogLevel.DEBUG);
			trans.execute(null);
			trans.waitUntilFinished();
						
			if(trans.getErrors() > 0) {
				mensaje = "Ocurrió un error al ejecutar la transformación "+nombreTransformacion;
				logger.error(mensaje);
				response.setCode("9999");
				response.setData(mensaje);
				return response;
			}
		
			logger.debug(mensaje);
			response.setCode("0000");
			response.setData(mensaje);
					
		} catch (KettleException e) {
			logger.error(e.getMessage());
			response.setCode("9001");
			response.setData(e.getMessage());
		}		
		return response;
	}
	
	
	
	@Override
	public GenericResponse cargaMaestros() throws Exception {
		GenericResponse response = new GenericResponse();
		GenericBean responseConsultaMateria;
		GenericBean responseDistritoJudicial;
		GenericBean responseSede;
		GenericBean responseTipoProceso;
		List<Error> errores = new ArrayList<Error>();
		try {
			responseConsultaMateria = this.ejecutaTransformacionMaestro("carga_consulta_materia_maestro.ktr");
			if(responseConsultaMateria.getCode().equals("9001") || responseConsultaMateria.getCode().equals("9000")) {
				errores.add(new Error(responseConsultaMateria.getData()));
			}
			
			responseDistritoJudicial = this.ejecutaTransformacionMaestro("carga_distritojudicial_maestro.ktr");
			if(responseDistritoJudicial.getCode().equals("9001") || responseDistritoJudicial.getCode().equals("9000")) {
				errores.add(new Error(responseDistritoJudicial.getData()));
			}
			
			responseSede = this.ejecutaTransformacionMaestro("carga_sede_maestro.ktr");
			if(responseSede.getCode().equals("9001") || responseSede.getCode().equals("9000")) {
				errores.add(new Error(responseSede.getData()));
			}
			
			responseTipoProceso = this.ejecutaTransformacionMaestro("carga_tipo_proceso_maestro.ktr");
			if(responseTipoProceso.getCode().equals("9001") || responseTipoProceso.getCode().equals("9000")) {
				errores.add(new Error(responseTipoProceso.getData()));
			}
			
			if(errores.isEmpty()) {
				response.setCode("0000");
				response.setMessage("Todas las tablas maestras han sido cargadas satisfatoriamente");
			}else {
				response.setCode("9002");
				response.setMessage("Hubo errores en la carga de alguno de las tablas maestras");
				response.setData(errores);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setCode("9000");
			response.setMessage("Hubo un error al ejecutar la carga de maestros");
			response.setData(errores);
		}
		return response;
	}

}
