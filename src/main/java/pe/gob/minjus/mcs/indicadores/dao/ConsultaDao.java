package pe.gob.minjus.mcs.indicadores.dao;

import pe.gob.minjus.mcs.indicadores.bean.GenericBean;

public interface ConsultaDao {
	
	boolean existeFechaCierre(String nombreTabla, String fechaCierre)throws Exception;
	GenericBean eliminarRegistros(String nombreTabla, String fechaCierre, Integer tipoOperacion) throws Exception;

}

