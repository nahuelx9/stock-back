package com.stock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.entity.Articulo;
import com.stock.entity.Carro;
import com.stock.service.IArticuloService;
import com.stock.service.ICarroService;

@RestController
@RequestMapping("/api")
public class CarroRestController {
	
	@Autowired
	ICarroService carroService;
	
	
	@GetMapping("/carros")
	public List<Carro> index(){
		return carroService.findAll();
	}	
	
	 @GetMapping("carro/{id}")
	    public ResponseEntity<?> show(@PathVariable Long id) {
	    	Carro carro = null;

	        Map<String, Object> response = new HashMap<>();

	        try {
	        	carro = carroService.findById(id);
	        } catch (DataAccessException e) {
	            response.put("Mensaje", "Eror al realizar la consulta");
	            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
	        }

	        if (carro == null) {
	            response.put("Mensaje",
	                    "El articulo con el id: ".concat(id.toString().concat(" no existe en la base de datos")));
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
	        }

	        return new ResponseEntity<Carro>(carro, HttpStatus.OK);

	    }

	 	
	    @PostMapping("/carro")
	    public ResponseEntity<?> create( @RequestBody Carro carro, BindingResult result) {

	    	System.out.println(carro);
	    	Carro carroNew = null;
	        Map<String, Object> response = new HashMap<>();

	        if (result.hasErrors()) {

	            /*
	             * List<String> errors = new ArrayList<>(); for(FieldError err:
	             * result.getFieldErrors()){ errors.add("El campo '" + err.getField() + "' " +
	             * err.getDefaultMessage()); }
	             */
	            List<String> errors = result.getFieldErrors().stream()
	                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
	                    .collect(Collectors.toList());

	            response.put("Error", errors);
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
	        }

	        try {
	        	carroNew = carroService.save(carro);

	        } catch (DataAccessException e) {
	            response.put("Mensaje", "Error al realizar el insert en la base de datos");
	            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	        response.put("mensaje", "El articulo ha sido creado con exito");
	        response.put("articulo", carroNew);
	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	    }

	    @PutMapping("/carro/{id}")
	    public ResponseEntity<?> update( @RequestBody Carro carro, BindingResult result, @PathVariable Long id) {

	        Map<String, Object> response = new HashMap<>();

	        if (result.hasErrors()) {

	            /*
	             * List<String> errors = new ArrayList<>(); for(FieldError err:
	             * result.getFieldErrors()){ errors.add("El campo '" + err.getField() + "' " +
	             * err.getDefaultMessage()); }
	             */
	            List<String> errors = result.getFieldErrors().stream()
	                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
	                    .collect(Collectors.toList());

	            response.put("Error", errors);
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
	        }

	    

	        try {
	        	
	        	carroService.update(id, carro);

	        } catch (DataAccessException e) {
	            response.put("Mensaje", "Eror al actualizar en la base de datos");
	            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	        response.put("mensaje", "El articulo ha sido actualizdo con exito");
	        response.put("carro", carro);
	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	    }
	    
	    @DeleteMapping("/carroDelete/{id}")	
	    public ResponseEntity<?> delete(@PathVariable Long id){
	    	
	        Map<String, Object> response = new HashMap<>();

	    	try {
	    		carroService.delete(id);
	    	}catch(DataAccessException e) {
	    		 response.put("Mensaje", "Eror al actualizar en la base de datos");
	             response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	             return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    	response.put("mensaje", "El carro ha sido Eliminadoo con exito");
	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	    }
}
