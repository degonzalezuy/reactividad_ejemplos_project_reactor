package operadorCombinacion;

import com.diego.demoreactor.model.Actividad;
import com.diego.demoreactor.model.Dispositivo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Combinacion {
    private static final Logger Log = LoggerFactory.getLogger(Combinacion.class);

    public void merge(){
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo nuevo"));

        List<Actividad> lista2 = new ArrayList<>();
        lista2.add(new Actividad(4, "Reparación", "Se cambia gps"));
        lista2.add(new Actividad(5, "Reparación", "Reinstalación por mal estado"));
        lista2.add(new Actividad(6, "Desinstalación", "Se retira equipo"));

        List<Dispositivo> lista3 = new ArrayList<>();
        lista3.add(new Dispositivo(7, "GPS", "123456789"));
        lista3.add(new Dispositivo(8, "GPS", "987654321"));
        lista3.add(new Dispositivo(9, "Chip", "159357753"));

        Flux<Actividad> fx1 = Flux.fromIterable(lista);
        Flux<Actividad> fx2 = Flux.fromIterable(lista2);
        Flux<Dispositivo> fx3 = Flux.fromIterable(lista3);


        Flux.merge(fx1, fx2, fx3)
                .subscribe(a -> Log.info(a.toString()));
    }

    public void zip(){
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo nuevo"));

        List<Actividad> lista2 = new ArrayList<>();
        lista2.add(new Actividad(4, "Reparación", "Se cambia gps"));
        lista2.add(new Actividad(5, "Reparación", "Reinstalación por mal estado"));
        lista2.add(new Actividad(6, "Desinstalación", "Se retira equipo"));

        List<Dispositivo> lista3 = new ArrayList<>();
        lista3.add(new Dispositivo(7, "GPS", "123456789"));
        lista3.add(new Dispositivo(8, "GPS", "987654321"));
        lista3.add(new Dispositivo(9, "Chip", "159357753"));

        Flux<Actividad> fx1 = Flux.fromIterable(lista);
        Flux<Actividad> fx2 = Flux.fromIterable(lista2);
        Flux<Dispositivo> fx3 = Flux.fromIterable(lista3);

        Flux.zip(fx1, fx2, (a1, a2) -> String.format("Flux1: %s, Flux2: %s", a1, a2))
                .subscribe(x -> Log.info(x));
        //Otro ejemplo
        /**
           Flux.zip(fx1, fx2, fx3)
         .subscribe(x -> Log.info(x.toString()));
        * */
    }

    public void zipWith(){
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad(1, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(2, "Instalación", "Instalando equipo nuevo"));
        lista.add(new Actividad(3, "Instalación", "Instalando equipo nuevo"));

        List<Actividad> lista2 = new ArrayList<>();
        lista2.add(new Actividad(4, "Reparación", "Se cambia gps"));
        lista2.add(new Actividad(5, "Reparación", "Reinstalación por mal estado"));
        lista2.add(new Actividad(6, "Desinstalación", "Se retira equipo"));

        List<Dispositivo> lista3 = new ArrayList<>();
        lista3.add(new Dispositivo(7, "GPS", "123456789"));
        lista3.add(new Dispositivo(8, "GPS", "987654321"));
        lista3.add(new Dispositivo(9, "Chip", "159357753"));

        Flux<Actividad> fx1 = Flux.fromIterable(lista);
        Flux<Actividad> fx2 = Flux.fromIterable(lista2);
        Flux<Dispositivo> fx3 = Flux.fromIterable(lista3);

        fx1.zipWith(fx2, (a1, a2) -> String.format("Flux1: %s, Flux2: %s", a1, a2))
                .subscribe(x -> Log.info(x.toString()));

    }
}
