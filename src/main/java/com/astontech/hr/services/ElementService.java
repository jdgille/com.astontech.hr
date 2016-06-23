package com.astontech.hr.services;

import com.astontech.hr.domain.Element;

import java.util.List;

/**
 * Created by jonagill1 on 6/20/2016.
 */
public interface ElementService {

    Iterable<Element> listAllElements();

    Element getElementById(Integer id);

    Element saveElement(Element element);

    Iterable<Element> saveElementList(Iterable<Element> elementIterable);

    void deleteElement(Integer id);

    /////custom list

    Element findByElementName(String elementName);

    List<Element> findAllByElementName(String elementName);

    //lab

    List<Element> findFirst2ByElementName(String elementName);

    Element findByElementNameContaining(String elementName);

    Element findByElementNameStartingWith(String elementName);

    Element findByElementNameEndingWith(String elementName);

    List<Element> findLast3ByElementName(String elementName);
}
