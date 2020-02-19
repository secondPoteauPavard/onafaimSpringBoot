package projetSopra.onafaim.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable(); 
//		http.authorizeRequests().antMatchers("/**").permitAll(); 

//		http.authorizeRequests().antMatchers("/auth/connexion/**").hasAnyRole("ADMIN")
//		.and().formLogin().loginPage("/auth/connexion")
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS).anonymous();
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/rest/auth/inscription").permitAll();
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();

		// http.authorizeRequests().antMatchers("/auth/admin/**").hasAnyRole("ADMIN")
//		.and().formLogin().loginPage("/connexion")
//		.and().authorizeRequests().antMatchers("/auth/**").authenticated()
//		.and().formLogin().loginPage("/auth/connexion").permitAll()
//		.and().logout().logoutSuccessUrl("/accueil")
//		.and().authorizeRequests().antMatchers("/**").permitAll();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("system")
				.password("system").roles("SYSTEM");

//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()); 	
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}
}
