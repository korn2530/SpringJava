package pe.javita.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import pe.javita.pojo.Admin;
import pe.javita.pojo.adminRowMapper;

@Component
public class adminDaoImpl implements adminDao {

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {

		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

	}

	@Override
	public boolean save(Admin admin) {

		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("nombre", admin.getNombre());
		param.addValue("cargo", admin.getCargo());
		param.addValue("fechaCreacion", admin.getFechaCreacion());

		// BeanPropertySqlParameterSource param = new
		// BeanPropertySqlParameterSource(admin);

		return jdbcTemplate.update(
				"insert into admin (nombre,cargo,fechaCreacion)" + "values(:nombre,:cargo,:fechaCreacion)", param) == 1;
	}

	@Override
	public List<Admin> findAll() {

		return jdbcTemplate.query("select * from admin", new adminRowMapper());
	}

	@Override
	public Admin findById(int idAd) {

		return jdbcTemplate.queryForObject("select * from admin where idAd=:idAd",
				new MapSqlParameterSource("idAd", idAd), new adminRowMapper());
	}

	@Override
	public boolean delete(int id) {

		return jdbcTemplate.update("delete from admin where idAd=:idAd", new MapSqlParameterSource("idAd", id)) == 1;
	}

	@Override
	public boolean update(Admin admin) {

		return jdbcTemplate.update("update admin set nombre=:nombre,cargo=:cargo,fechaCreacion=:fechaCreacion where idAd=:idAd",new BeanPropertySqlParameterSource(admin))==1;
	}

}
