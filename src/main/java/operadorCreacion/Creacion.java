package operadorCreacion;

import com.diego.demoreactor.model.Actividad;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Creacion {

    private static final Logger Log = LoggerFactory.getLogger(Creacion.class);

    public void justFrom(){
        Mono.just(new Actividad(1, "pp", "AA"));
    }

    public void empty(){
        Mono.empty();
        Flux.empty();
        Observable.empty();
    }

    public void range(){
     Flux.range(0, 3)
             .doOnNext(i -> Log.info("i : " + i))
             .subscribe();
    }

    public void repeat(){
        List<Actividad>lista = new ArrayList<>();
        lista.add(new Actividad( 1, "Act1", "pp"));
        lista.add(new Actividad( 2, "Act1", "pp"));
        lista.add(new Actividad( 3, "Act1", "pp"));

        Flux.fromIterable(lista)
                .repeat(3)
                .subscribe(a -> Log.info(a.toString()));

    }
}
