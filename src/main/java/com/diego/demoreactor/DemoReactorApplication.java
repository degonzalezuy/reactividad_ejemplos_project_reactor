package com.diego.demoreactor;

import com.diego.demoreactor.model.Actividad;
import io.reactivex.Observable;
import operadorCombinacion.Combinacion;
import operadorCondicional.Condicional;
import operadorCreacion.Creacion;
import operadorError.ErrorOp;
import operadorMatematico.Matematico;
import operadorTranformacion.Transformacion;
import operadordeFiltrado.Filtrado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

	private static final Logger Log = LoggerFactory.getLogger(DemoReactorApplication.class);

	/**
	 * probando projectreactor
	 */
	public void reactor(){
		Mono.just(new Actividad(1, "Instalación", "Se instala tractor"))
                .subscribe(a -> Log.info("[Reactor] Actividad: " + a));
	}

	/**
	 * probando RXJAVA
	 */

	public void rxjava2(){

        Observable.just(new Actividad(1, "Instalación", "Se instala tractor"))
                .subscribe(a -> Log.info("[RxJava2] Actividad: " + a));
	}

	/**
	 * Probando Mono
	 */
	public void mono(){
		Mono.just(new Actividad(1, "Instalación", "Se instala tractor")).subscribe(a -> Log.info(a.toString()));
	}

	/**
	 * Probando flux
	 */
	public void flux(){
		List<Actividad> actividades = new ArrayList<>();
		actividades.add(new Actividad(1, "Instalación", "auto nuevo"));
		actividades.add(new Actividad(2, "Reparación", "Cambio degps"));
		actividades.add(new Actividad(3, "Reparación", "Antena cortada"));

		Flux.fromIterable(actividades).subscribe(a -> Log.info(a.toString()));

	}

	/**
	 *
	 * pasando de flux a mono
	 */
	public void fluxmono(){
		List<Actividad> actividades = new ArrayList<>();
		actividades.add(new Actividad(1, "Instalación", "auto nuevo"));
		actividades.add(new Actividad(2, "Reparación", "Cambio degps"));
		actividades.add(new Actividad(3, "Reparación", "Antena cortada"));

		Flux<Actividad> fx = Flux.fromIterable(actividades);
		fx.collectList().subscribe(lista -> Log.info(lista.toString()));
	}


	public static void main(String[] args) {

        SpringApplication.run(DemoReactorApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        // probando reactor y rxjava2
		//reactor();
        //rxjava2();

		//probando mono y flux
		//mono();
		//flux();

		/**
		 * pasando de flux a mono
		 */
		//fluxmono();

		//Creacion app = new Creacion();
		//app.range();;

		//Usando operadores de Transformación
		//Transformacion app = new Transformacion();
		//app.map();
		//app.flatMap();;
		//app.groupBy();

		//Usando metodos de filtrado
		//Filtrado app = new Filtrado();
		//app.filter();
		//app.distinct();
		//take
		//takeLast
		//skip
		//skiplast

		//Usando métodos de combinación(merge)
		//Combinacion app = new Combinacion();
		//app.merge();
		//app.zip();
		//app.zipWith();

		//Usando métodos de Exception
		//ErrorOp app = new ErrorOp();
		//app.errorReturn();

		//Usando métodos Condicionales
		//Condicional app = new Condicional();
		//app.timeout();

		//Usando métodos Matematicos
		Matematico app = new Matematico();
		app.summarizing();
	}
}
