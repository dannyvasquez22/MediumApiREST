package com.admin.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.admin.converter.Convertidor;
import com.admin.entity.Nota;
import com.admin.model.MNota;
import com.admin.repository.NotaRepository;

@Service("servicio")
public class NotaService {

	@Autowired
	@Qualifier("repositorio")
	private NotaRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	private static final Log logger = LogFactory.getLog(NotaService.class);
	
	public boolean crear(Nota nota) {
		logger.info("CREANDO NOTA");
		try {
			repositorio.save(nota);
			logger.info("NOTA CREADA");
			return true;
		} catch(Exception ex) {
			logger.error("HUBO UN ERROR");
			return false;
		}
	}
	
	public boolean actualizar(Nota nota) {
		logger.info("ACTUALIZANDO NOTA");
		try {
			repositorio.save(nota);	
			logger.info("NOTA ACTUALIZADA");
			return true;
		} catch(Exception ex) {
			logger.error("HUBO UN ERROR");
			return false;
		}
	}
	
	public boolean borra(String nombre, long id) {
		logger.warn("BORRANDO NOTA");
		try {
			Nota nota = repositorio.findByNombreAndId(nombre, id);			
			repositorio.delete(nota);
			logger.info("NOTA BORRADA");
			return true;
		} catch(Exception ex) {
			logger.error("HUBO UN ERROR");
			return false;
		}
	}
	
	public List<MNota> obtener() {
		logger.info("OBTENIENDO TODOS LOS ELEMENTOS");
		return convertidor.convertirLista(repositorio.findAll());
	}
	
	public MNota obtenerPorNombreTitulo(String nombre, String titulo) {
		return new MNota(repositorio.findByNombreAndTitulo(nombre, titulo));
	}
	
	public List<MNota> obtenerTitulo(String titulo) {
		return convertidor.convertirLista(repositorio.findByTitulo(titulo));
	}
	
	public MNota obtenerPorNombre(String nombre) {
		return new MNota(repositorio.findByNombre(nombre));
	}
	
	public MNota obtenerPorNombreId(String nombre, long id) {
		return new MNota(repositorio.findByNombreAndId(nombre, id));
	}
	
	public List<MNota> obtenerPorPaginacion(Pageable pageable) {
		return convertidor.convertirLista(repositorio.findAll(pageable).getContent());
	}
}
