package com.astontech.hr.repositories;

import com.astontech.hr.domain.ElementType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jonagill1 on 6/20/2016.
 */
public interface ElementTypeRepository extends CrudRepository<ElementType, Integer> {

    ElementType findByElementTypeName(String elementTypeName);

    List<ElementType> findAllByElementTypeName(String elementTypeName);

    //lab

    List<ElementType> findFirst2ByElementTypeName(String elementTypeName);

    ElementType findByElementTypeNameContaining(String elementTypeName);

    ElementType findByElementTypeNameStartingWith(String elementTypeName);

    ElementType findByElementTypeNameEndingWith(String elementTypeName);

    List<ElementType> findLast3ByElementTypeName(String elementTypeName);
}
