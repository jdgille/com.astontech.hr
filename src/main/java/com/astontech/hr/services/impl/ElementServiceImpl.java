package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Element;
import com.astontech.hr.repositories.ElementRepository;
import com.astontech.hr.services.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jonagill1 on 6/20/2016.
 */
@Service
public class ElementServiceImpl implements ElementService {
    @Autowired
    private ElementRepository elementRepository;

    @Override
    public Iterable<Element> listAllElements() {
        return elementRepository.findAll();
    }

    @Override
    public Element getElementById(Integer id) {
        return elementRepository.findOne(id);
    }

    @Override
    public Element saveElement(Element element) {
        return elementRepository.save(element);
    }

    @Override
    public Iterable<Element> saveElementList(Iterable<Element> elementIterable) {
        return elementRepository.save(elementIterable);
    }

    @Override
    public void deleteElement(Integer id) {
        elementRepository.delete(id);
    }

    @Override
    public Element findByElementName(String elementName) {
        return elementRepository.findByElementName(elementName);
    }

    @Override
    public List<Element> findAllByElementName(String elementName) {
        return elementRepository.findAllByElementName(elementName);
    }

    @Override
    public List<Element> findFirst2ByElementName(String elementName) {
        return elementRepository.findFirst2ByElementName(elementName);
    }

    @Override
    public Element findByElementNameContaining(String elementName) {
        return elementRepository.findByElementNameContaining(elementName);
    }

    @Override
    public Element findByElementNameStartingWith(String elementName) {
        return elementRepository.findByElementNameStartingWith(elementName);
    }

    @Override
    public Element findByElementNameEndingWith(String elementName) {
        return elementRepository.findByElementNameEndingWith(elementName);
    }

    @Override
    public List<Element> findLast3ByElementName(String elementName) {
        return elementRepository.findLast3ByElementName(elementName);
    }
}
