package br.com.scienceblog.mapper;

import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.List;


public class Mapper {
    private DozerBeanMapper dozerMapper = new DozerBeanMapper();

    //This strange thing being used in type return of the method is called "generics"
    public <O,D> D parseObject(O origin, Class<D> destination) {
        return dozerMapper.map(origin, destination);
    }

    public <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        List<D> destinationObjects  = new ArrayList<D>();
        for(O obj : origin) {
            destinationObjects.add(dozerMapper.map(obj, destination));
        }
        return destinationObjects;
    }
}
