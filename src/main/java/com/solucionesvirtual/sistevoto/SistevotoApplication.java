package com.solucionesvirtual.sistevoto;

import com.solucionesvirtual.sistevoto.domain.Copropiedad;
import com.solucionesvirtual.sistevoto.domain.Permiso;
import com.solucionesvirtual.sistevoto.domain.Rol;
import com.solucionesvirtual.sistevoto.domain.RolEnum;
import com.solucionesvirtual.sistevoto.repository.CopropiedadRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;


@SpringBootApplication

public class SistevotoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistevotoApplication.class, args);
	}


}
