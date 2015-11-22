package com.springsecurityblog.config;


/**
 * Author: Ramakrishna Panni
 * Class: CustomAuthenticationProvider
 * Details: It is used to get credentials and authorize the request with roles
 */

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.stereotype.Component;

import com.springsecurityblog.model.Employee;
import com.springsecurityblog.model.Role;
import com.springsecurityblog.service.AccountService;

@Component("AuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {
 
	 @Autowired
	 private AccountService accountService;
	
	 public Authentication authenticate(Authentication authentication) 
    	      throws AuthenticationException {
    	
		 		String username = authentication.getName();
		 		String password = (String) authentication.getCredentials();
	    	  
    	        Employee member = accountService.findAccountByUsername(username);
    	       //For username not valid 
               if (member == null || !member.getEmployeeUserName().equalsIgnoreCase(username)) {
                    throw new BadCredentialsException("Username not found.");
                }
               //For password not valid
                if (!password.equals(member.getPassword())) {
                    throw new BadCredentialsException("Wrong password.");
                }
                Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
                //Employee can have many roles
                for (Role  employeeRole : member.getEmpRoles()) {
        			setAuths.add(new SimpleGrantedAuthority(employeeRole.getAuthority()));
        		}
                return new UsernamePasswordAuthenticationToken(member, password, setAuths); 
    	    }
	 
		public boolean supports(Class<?> authentication) {
			     return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
		   
			}

}