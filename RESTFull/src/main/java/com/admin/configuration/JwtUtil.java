package com.admin.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import static java.util.Collections.emptyList;

public class JwtUtil {

	static void addAuthentication(HttpServletResponse response, String username) {
		String token = Jwts.builder()
				.setSubject(username)
				// Hash con el que firmaremos la clave
				.signWith(SignatureAlgorithm.HS512, "P@tit0")
				.compact();
		
		// agregamos el encabezado el token
		response.addHeader("Authorization", "Bearer " + token);
	}
	
	// Metodo para validar el token enviado por el cliente
	static Authentication getAuthentication(HttpServletRequest request) {
		
		// si hay un token que viene en ele encabezado lo validamos
		String token = request.getHeader("Authorization");
		
		// si hay un token presente, entonces lo validamos		
		if (token != null) {
			String user = Jwts.parser()
					.setSigningKey("P@tit0")
					.parseClaimsJws(token.replace("Bearer", "")) // este metodo es el que valida
					.getBody()
					.getSubject();
			
			// Recordamos que para las demas peticiones que no sean /login
			// no requerimos una autenticacion por username/password
			// por este motivo podemos devolver un UsernamePasswordAuthenticationToken sin password
			return user != null ?
					new UsernamePasswordAuthenticationToken(user, null, emptyList()) :
					null;
		}
		
		return null;
	}
}
