package com.astontech.hr.services;

import com.astontech.hr.domain.ElementType;

import java.util.List;

/**
 * Created by jonagill1 on 6/20/2016.
 */
public interface ElementTypeService {
    Iterable<ElementType> listAllElementTypes();

    ElementType getElementTypeById(Integer id);

    ElementType saveElementType(ElementType elementType);

    Iterable<ElementType> saveElementTypeList(Iterable<ElementType> elementTypeIterable);

    void deleteElementType(Integer id);

    /////custom list

    ElementType findByElementTypeName(String elementTypeName);

    List<ElementType> findAllByElementTypeName(String elementTypeName);

    //lab

    List<ElementType> findFirst2ByElementTypeName(String elementTypeName);

    ElementType findByElementTypeNameContaining(String elementTypeName);

    ElementType findByElementTypeNameStartingWith(String elementTypeName);

    ElementType findByElementTypeNameEndingWith(String elementTypeName);

    List<ElementType> findLast3ByElementTypeName(String elementTypeName);
}
