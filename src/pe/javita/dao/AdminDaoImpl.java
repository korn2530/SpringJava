package pe.javita.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import pe.javita.pojo.Admin;

@Component("adminDao")
public class AdminDaoImpl implements AdminDao{

	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private void setDataSource(DataSource dataSource) {
		
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		
	}
	
	@Override
	public boolean save(Admin admin) {
		
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		paramMap.addValue("nombre", admin.getNombre());
		paramMap.addValue("cargo", admin.getCargo());
		paramMap.addValue("fechaCreacion", admin.getFechaCreacion());
		
		return jdbcTemplate.update("insert into Admin(nombre,cargo,fechaCreacion) values ( :nombre, :cargo, :fechaCreacion) ", paramMap)==1;
	}

}
