package org.zer0.pocs.caffeine.demoCaffeine.rest;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zer0.pocs.caffeine.demoCaffeine.data.Datos;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

@RestController
@RequestMapping("/caffeine")
public class CaffeineRestController {

	private static Cache<String, Datos> cache = Caffeine.newBuilder()
		    .expireAfterWrite(10, TimeUnit.MINUTES)
		    .maximumSize(10_000)
		    .build();
	
	@GetMapping("/testCacheManual")
	public String testCacheManual() {
		
			// Lookup an entry, or null if not found
			Datos dato = cache.getIfPresent("K1");
			// Lookup and compute an entry if absent, or null if not computable
			dato = cache.get("K2", k -> generateDatos(k));
			System.out.println(dato);
			// Insert or update an entry
			//cache.put(key, graph);
			// Remove an entry
			//cache.invalidate(key);
		return "";
	}
	
	private Datos generateDatos(String clave) {
		System.out.println("Generando data:" +clave +" ...");
		Datos d=new Datos(clave,"map:"+clave);
		System.out.println("Generando data:" +d +" , instancia");
		return d;
		
	}
	
}
