package org.zer0.pocs.caffeine.demoCaffeine.rest;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zer0.pocs.caffeine.demoCaffeine.data.Datos;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

@RestController
@RequestMapping("/caffeine/manual")
public class CaffeineCacheManualRestController {

	private static Cache<String, Datos> cache = Caffeine.newBuilder()
			.expireAfterWrite(10, TimeUnit.MINUTES)	//Especifica el tiempo de expiracion desde el momento de la creacion de la entrada o desde su ultima actualizacion
			.maximumSize(10_000)					//Especifica el tamaño de la cache, en caso de alcanzarse el tope empezara a eliminar aquellas entradas que sean menos usadas.
			.build();

	@PostMapping("/load")
	public void load(@RequestBody Optional<Datos> datos) {
		// Insert or update an entry
		datos.ifPresent(d->cache.put(d.getClave(),d));
	}

	@GetMapping("/getIfPresent/{key}")
	private Datos getIfPresent(@PathVariable("key") String key) {
		// Lookup an entry, or null if not found
		return cache.getIfPresent(key);
	}
	
	@GetMapping("/getWithFunction/{key}")
	private Datos getWithFunction(@PathVariable("key") String key) {
		// Lookup and compute an entry if absent, or null if not computable
		//Si se llega a generar, este se guarda en la cache
		return cache.get(key, k -> generateDatos(k));
	}
	
	@DeleteMapping("/delete/{key}")
	private void delete(@PathVariable("key") String key) {
		// Remove an entry
		cache.invalidate(key);
	}

	private Datos generateDatos(String clave) {
		System.out.println("Generando data:" + clave + " ...");
		Datos d = new Datos(clave, "map:" + clave);
		System.out.println("Generando data:" + d + " , instancia");
		return d;

	}

}
