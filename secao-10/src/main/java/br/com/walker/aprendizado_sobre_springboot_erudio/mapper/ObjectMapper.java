package br.com.walker.aprendizado_sobre_springboot_erudio.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapper {
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault(); //Instanciando um objeto mapper padrão

    //Metodo genérico para converter um objeto em outro
    public static <Origin, Destination> Destination convertObject(Origin origin, Class<Destination> destination) {
        return mapper.map(origin, destination);
    }

    //Metodo genérico para converter uma lista objetos em outra
    public static <Origin, Destination> List<Destination> convertListObjects(List<Origin> origin, Class<Destination> destination) {
        List<Destination> destinationObjectsList = new ArrayList<Destination>();
        for (Origin item : origin) {
            destinationObjectsList.add(mapper.map(item, destination));
        }
        return destinationObjectsList;
    }
}
