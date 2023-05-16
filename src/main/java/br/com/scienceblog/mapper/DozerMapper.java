package br.com.scienceblog.mapper;

import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.List;


public class DozerMapper {
    private final static DozerBeanMapper mapper = new DozerBeanMapper();

    //This strange thing being used in type return of the method is called "generics"
    public static <O,D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        List<D> destinationObjects  = new ArrayList<D>();
        for(O obj : origin) {
            destinationObjects.add(mapper.map(obj, destination));
        }
        return destinationObjects;
    }
}
