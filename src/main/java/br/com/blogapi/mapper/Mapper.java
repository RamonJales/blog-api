package br.com.blogapi.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;


public class Mapper {
    private final static ModelMapper modelMapper = new ModelMapper();

    //This strange thing being used in type return of the method is called "generics"
    public static <O,D> D parseObject(O origin, Class<D> destination) {
        return modelMapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        List<D> destinationObjects  = new ArrayList<D>();
        for(O obj : origin) {
            destinationObjects.add(modelMapper.map(obj, destination));
        }
        return destinationObjects;
    }
}
