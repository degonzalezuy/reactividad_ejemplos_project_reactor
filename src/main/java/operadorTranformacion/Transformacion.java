package operadorTranformacion;

import com.diego.demoreactor.model.Actividad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Transformacion {
    private static final Logger Log = LoggerFactory.getLogger(Transformacion.class);

    //Método MAP
    public void map(){
        /*List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad( 1, "Act1", "pp"));
        lista.add(new Actividad( 2, "Act1", "pp"));
        lista.add(new Actividad( 3, "Act1", "pp"));

        Flux.fromIterable(lista)
                .map(p -> {
                    p.setId(p.getId()+10);
                    return p;
                })
                .subscribe(p -> Log.info(p.toString()));*/
        Flux<Integer> fx = Flux.range(0, 10);
        Flux<Integer> fx2 = fx.map(x -> x + 10);
        //fx.map(x -> x + 10);
        fx2.subscribe(x -> Log.info("X : " + x));

    }

    //Método flatMap
    public void flatMap(){
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad( 1, "Act1", "pp"));
        lista.add(new Actividad( 2, "Act1", "pp"));
        lista.add(new Actividad( 3, "Act1", "pp"));

        Flux.fromIterable(lista)
                .flatMap(a -> {
                    a.setId(a.getId() + 10);
                    a.setDescripcion(a.getDescripcion() + 2);
                    return Mono.just(a);
                })
                .subscribe(a -> Log.info(a.toString()));
    }

    //Método groupBy

    public void groupBy(){
        List<Actividad> lista = new ArrayList<>();
        lista.add(new Actividad( 1, "Act1", "pp"));
        lista.add(new Actividad( 2, "Act1", "pp"));
        lista.add(new Actividad( 3, "Act1", "pp"));

        Flux.fromIterable(lista)
                .groupBy(Actividad::getTipoActividad)
                .flatMap(tipoflux -> tipoflux.collectList())
                .subscribe(x -> Log.info(x.toString()));
    }
}
