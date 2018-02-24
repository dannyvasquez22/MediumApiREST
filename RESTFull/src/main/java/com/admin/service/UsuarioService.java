package com.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.admin.entity.Usuario;
import com.admin.repository.GestorUsuario;

@Service("usuarioService")
public class UsuarioService implements UserDetailsService {

	@Autowired
	@Qualifier("gestorUsuario")
	private GestorUsuario repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = repo.findByUsuario(username);
		return new User(user.getUsuario(), user.getContraseña(), user.isActivo(), user.isActivo(), user.isActivo(), user.isActivo(), buildGranted(user.getRol()));
	}
	
	public List<GrantedAuthority> buildGranted(byte rol) {
		String[] roles = {"LECTOR", "USUARIO", "ADMINISTRADOR"};
		List<GrantedAuthority> auths = new ArrayList<>();
		
		for (int i = 0; i < rol; i++) {
			auths.add(new SimpleGrantedAuthority(roles[i]));
		}
		return auths;
	}
}
