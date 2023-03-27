package operadorCondicional;

import com.diego.demoreactor.model.Actividad;
import operadordeFiltrado.Filtrado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Condicional {

    private static final Logger Log = LoggerFactory.getLogger(Condicional.class);

    public void defaultIfEmpty(){

        Mono.just(new Actividad(1, "Instalación", "Equipo nuevo"))
        //Si está vacío devuelve el valor por defecto
        //Mono.empty()
        //Flux.empty()
                .defaultIfEmpty(new Actividad(0, "tipoDefault", "desc por defecto"))
                .subscribe(x -> Log.info(x.toString()));

    }

    public void takeUntil(){
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(2, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo nuevo"));

        Flux.fromIterable(lista)
                .takeUntil(p -> p.getId()>0)
                .subscribe(x -> Log.info(x.toString()));
    }

    public void timeout() throws InterruptedException {
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(2, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo nuevo"));

        Flux.fromIterable(lista)
                .delayElements(Duration.ofSeconds(1))
                .timeout(Duration.ofSeconds(2))
                .subscribe(x -> Log.info(x.toString()));

        Thread.sleep(10000);
    }
}
