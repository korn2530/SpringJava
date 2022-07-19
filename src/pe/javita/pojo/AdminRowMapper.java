package pe.javita.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AdminRowMapper implements RowMapper<Admin> {
	
	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Admin admin = new Admin();

		admin.setCargo(rs.getString("cargo"));
		admin.setNombre(rs.getString("nombre"));
		admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
		admin.setIdAd(rs.getInt("idAd"));
				
		return admin;
	}
	
}
