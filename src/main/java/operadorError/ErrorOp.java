package operadorError;


import com.diego.demoreactor.model.Actividad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class ErrorOp {

    private static final Logger Log = LoggerFactory.getLogger(ErrorOp.class);

    public void retry(){
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo nuevo"));

        Flux.fromIterable(lista)
                .concatWith(Flux.error(new RuntimeException("ERROR!")))
                .retry(1)
                .doOnNext(x -> Log.info(x.toString()))
                .subscribe();
    }

    public void errorReturn(){
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo nuevo"));

        Flux.fromIterable(lista)
                .concatWith(Flux.error(new RuntimeException("Otro Error")))
                .onErrorReturn(new Actividad(0, "Act error", "Desc"))
                .subscribe(x -> Log.info(x.toString()));
    }

    public void errorResume(){
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo nuevo"));

        Flux.fromIterable(lista)
                .concatWith(Flux.error(new RuntimeException("Error!!!!!")))
                .onErrorResume(e -> Mono.just(new Actividad(0, "nuevo", "99")))
                .subscribe(x -> Log.info(x.toString()));
    }

    public void errorMap(){
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo nuevo"));

        Flux.fromIterable(lista)
                .concatWith(Flux.error(new RuntimeException("Error!!!!!")))
                .onErrorMap(e -> new InterruptedException(e.getMessage()))
                .subscribe(x -> Log.info(x.toString()));
    }


}
