package com.astontech.hr.services.impl;


import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementTypeRepository;
import com.astontech.hr.services.ElementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jonagill1 on 6/20/2016.
 */

@Service
public class ElementTypeServiceImpl implements ElementTypeService {

    @Autowired
    private ElementTypeRepository elementTypeRepository;

    @Override
    public Iterable<ElementType> listAllElementTypes() {
        return elementTypeRepository.findAll();
    }

    @Override
    public ElementType getElementTypeById(Integer id) {
        return elementTypeRepository.findOne(id);
    }

    @Override
    public ElementType saveElementType(ElementType elementType) {
        return elementTypeRepository.save(elementType);
    }

    @Override
    public Iterable<ElementType> saveElementTypeList(Iterable<ElementType> elementTypeIterable) {
        return elementTypeRepository.save(elementTypeIterable);
    }

    @Override
    public void deleteElementType(Integer id) {
        elementTypeRepository.delete(id);
    }

    @Override
    public ElementType findByElementTypeName(String elementTypeName) {
        return elementTypeRepository.findByElementTypeName(elementTypeName);
    }

    @Override
    public List<ElementType> findAllByElementTypeName(String elementTypeName) {
        return elementTypeRepository.findAllByElementTypeName(elementTypeName);
    }

    @Override
    public List<ElementType> findFirst2ByElementTypeName(String elementTypeName) {
        return elementTypeRepository.findFirst2ByElementTypeName(elementTypeName);
    }

    @Override
    public ElementType findByElementTypeNameContaining(String elementTypeName) {
        return elementTypeRepository.findByElementTypeNameContaining(elementTypeName);
    }

    @Override
    public ElementType findByElementTypeNameStartingWith(String elementTypeName) {
        return elementTypeRepository.findByElementTypeNameStartingWith(elementTypeName);
    }

    @Override
    public ElementType findByElementTypeNameEndingWith(String elementTypeName) {
        return elementTypeRepository.findByElementTypeNameEndingWith(elementTypeName);
    }

    @Override
    public List<ElementType> findLast3ByElementTypeName(String elementTypeName) {
        return elementTypeRepository.findLast3ByElementTypeName(elementTypeName);
    }
}
