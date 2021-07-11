package com.cts.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cts.service.UserService;


@Configuration
@EnableWebSecurity
public class KnoteSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	    @Autowired
	    private UserService userService;
		
	    @Autowired
	    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	    
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());
	    }
	   
	  // @Override
	  /* public void addResourceHandlers(ResourceHandlerRegistry registry) {
	       registry.addResourceHandler(
	               "/webjars/**",
	               "/image/**",
	               "/css/**",
	               "/js/**")
	               
	       .addResourceLocations(
	               "classpath:/META-INF/resources/webjars/",
	               "classpath:/static/image/",
	               "classpath:/static/css/",
	               "classpath:/static/js/");
	   }*/
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			//http.csrf().disable();
	       // http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);

	       // http.authorizeRequests().antMatchers(HttpMethod.GET, "/js/**", "/css/**", "/img/**" ,"/pressiplus", "/public/**", "/index", "/", "/login").permitAll();
	       
	        //ad end by me
			//.antMatchers("/").hasRole("ADMIN")
			//.antMatchers("/").hasRole("COE")
			http.authorizeRequests()
				.antMatchers("/").hasRole("USER")
				.antMatchers("/showDoc/**").hasRole("ADMIN")
				.antMatchers("/showDoc/**").hasRole("COE")
				.antMatchers("/showArticle/**").hasRole("ADMIN")
				.antMatchers("/showArticle/**").hasRole("USER")
				.and()
				.formLogin()
					.loginPage("/login/showMyLoginPage")
					.loginProcessingUrl("/authenticateTheUser")
					.successHandler(customAuthenticationSuccessHandler)
					.permitAll()
				.and()
				.logout().permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/access-denied");
			
		}
		
		//beans
		//bcrypt bean definition
		@Bean
		public BCryptPasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

		//authenticationProvider bean definition
		@Bean
		public DaoAuthenticationProvider authenticationProvider() {
			DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
			auth.setUserDetailsService(userService); //set the custom user details service
			auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
			return auth;
		}
		  

}

