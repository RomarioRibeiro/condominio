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
import com.romrio.domain.Seguranca;
import com.romrio.dto.SegurancaDto;
import com.romrio.dto.views.SegurancaViews;
import com.romrio.service.ServiceSeguranca;

@RestController
@RequestMapping(value = "/seguranca")
public class ResourscesSeguranca {
	@Autowired
	private ServiceSeguranca service;
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id ){
		
		SegurancaDto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert (@RequestBody Seguranca obj){
		 obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Seguranca obj, @PathVariable Integer id){
		obj.setId(id);
		obj=service.update(obj);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value= "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(method = RequestMethod.GET)
	@JsonView(SegurancaViews.Resumo1.class)
	public ResponseEntity<List <SegurancaDto>> findAll(){
		List <SegurancaDto> listDto = service.findAll();
		return ResponseEntity.ok().body(listDto);
	}
}
