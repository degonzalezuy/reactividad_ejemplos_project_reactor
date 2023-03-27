package operadordeFiltrado;

import com.diego.demoreactor.model.Actividad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filtrado {
    private static final Logger Log = LoggerFactory.getLogger(Filtrado.class);

    public void filter(){
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(2, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo nuevo"));

        Flux.fromIterable(lista)
                .filter(a -> a.getId() < 2)
                .subscribe(a -> Log.info(a.toString()));
    }

    public void distinct(){
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo nuevo"));

        Flux.fromIterable(lista)
                .distinct()
                .subscribe(a -> Log.info(a.toString()));
    }

    public void take(){
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo nuevo"));

        Flux.fromIterable(lista)
                .take(1)
                .subscribe(a -> Log.info(a.toString()));
    }

    public void takeLast(){
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo nuevo"));

        Flux.fromIterable(lista)
                .takeLast(1)
                .subscribe(a -> Log.info(a.toString()));
    }

    public void skip(){
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo nuevo"));

        Flux.fromIterable(lista)
                .skip(1)
                .subscribe(a -> Log.info(a.toString()));
    }

    public void skipLast(){
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo nuevo"));

        Flux.fromIterable(lista)
                .skipLast(1)
                .subscribe(a -> Log.info(a.toString()));
    }
}
