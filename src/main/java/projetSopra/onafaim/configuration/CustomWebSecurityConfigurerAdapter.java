package projetSopra.onafaim.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource datasource; 
	
	protected void configure(HttpSecurity http) throws Exception {
		
	}
	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
