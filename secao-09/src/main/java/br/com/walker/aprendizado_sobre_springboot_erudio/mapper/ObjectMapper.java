package br.com.walker.aprendizado_sobre_springboot_erudio.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapper {
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault(); //Instanciando um objeto mapper padrão

    public static <Origin, Destination> Destination convertObject(Origin origin, Class<Destination> destination) { //Método genérico para converter um objeto em outro
        return mapper.map(origin, destination);
    }

    public static <Origin, Destination> List<Destination> convertListObjects(List<Origin> origin, Class<Destination> destination) { //Método genérico para converter um objeto em outro
        List<Destination> destinationObjectsList = new ArrayList<Destination>();
        for (Object object: origin) {
            destinationObjectsList.add(mapper.map(origin, destination));
        }
        return destinationObjectsList;
    }
}
