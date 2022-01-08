package pe.gob.minjus.mcs.indicadores.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.gob.minjus.mcs.indicadores.bean.GenericBean;
import pe.gob.minjus.mcs.indicadores.dao.ConsultaDao;

@Repository
public class ConsultaDaoImpl extends JdbcDaoSupport implements ConsultaDao {

	public ConsultaDaoImpl( DataSource datasource) {		
		this.setDataSource(datasource);		
	}

	@Override
	public boolean existeFechaCierre(String nombreTabla, String fechaCierre) throws Exception {
		boolean response = true;
		Integer count = 0;
		String query = "select count(*) as cantidad from "+nombreTabla+" where FECHA_CIERRE = '"+fechaCierre+"'";		
		try {
			count = getJdbcTemplate().queryForObject(query, Integer.class);
			if(count>0) {
				response = true;
			}else {
				response= false;				
			}		
		} catch (Exception e) {
			logger.error(":: existeFechaCierre: Tabla " +nombreTabla+" :: ==> "+e.getMessage());
			throw e;
		}
		return response;
	}

	@Override
	public GenericBean eliminarRegistros(String nombreTabla, String fechaCierre, Integer tipoOperacion) throws Exception {
		GenericBean response = new GenericBean();
		Integer numReg = 0;		
		String query = "";
		
		if(tipoOperacion==1) {
			query = "delete from "+nombreTabla+" where FECHA_CIERRE = '"+fechaCierre+"'";		
		}else {
			query = "delete from "+nombreTabla+" ";	
		}		
		try {
			numReg = getJdbcTemplate().update(query);
			response.setCode("0000");
			response.setData("Se han eliminado "+numReg+" registros");
		} catch (Exception e) {
			logger.error(":: eliminarRegistros: Tabla " +nombreTabla+" :: ==> "+e.getMessage());
			throw e;
		}
		return response;
	}	

}
