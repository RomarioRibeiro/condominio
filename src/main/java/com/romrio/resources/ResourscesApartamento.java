package com.romrio.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.romrio.domain.Apartamento;
import com.romrio.dto.ApartamentoDto;
import com.romrio.dto.views.ApartamentoViews;
import com.romrio.service.ServiceApartamento;

@RestController
@RequestMapping(value = "/apartamento")
public class ResourscesApartamento {
	@Autowired
	private ServiceApartamento service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		ApartamentoDto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@RequestBody ApartamentoDto obj){
		 Apartamento apart = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Apartamento> update(@RequestBody ApartamentoDto obj, @PathVariable Integer id){
		Apartamento objnew =service.update(obj);
		objnew.setId(id);
		 objnew = service.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value= "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method =RequestMethod.GET)
	
	public ResponseEntity<List<ApartamentoDto>> findAll() {
		List<ApartamentoDto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	

}
