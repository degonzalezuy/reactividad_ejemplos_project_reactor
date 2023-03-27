package operadorMatematico;

import com.diego.demoreactor.model.Actividad;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Matematico {
    private static final Logger Log = LoggerFactory.getLogger(Matematico.class);

    public void average() {
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(2, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo"));

        Flux.fromIterable(lista)
                .collect(Collectors.averagingInt(Actividad::getId))
                .subscribe(p -> Log.info(p.toString()));
    }

    public void count(){
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(2, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo"));

        Flux.fromIterable(lista)
                .count()
                .subscribe(x -> Log.info(("Cantidad: " + x)));
    }

    public void min() {
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(2, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo"));

        Flux.fromIterable(lista)
                .collect(Collectors.minBy(Comparator.comparing(Actividad::getId)))
                .subscribe(p -> Log.info(p.get().toString()));
    }

    public void sum(){
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(2, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo"));

        Flux.fromIterable(lista)
                .collect(Collectors.summingInt(Actividad::getId))
                .subscribe(x -> Log.info("Suma: " + x));
    }

    public void summarizing(){
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(2, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo"));

        Flux.fromIterable(lista)
                .collect(Collectors.summarizingInt(Actividad::getId))
                .subscribe(x -> Log.info("Resumen: " + x ));
    }
}
