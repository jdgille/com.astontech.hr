package com.astontech.hr.repositories;

import com.astontech.hr.domain.Element;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jonagill1 on 6/20/2016.
 */
public interface ElementRepository extends CrudRepository<Element, Integer> {

    Element findByElementName(String elementName);

    List<Element> findAllByElementName(String elementName);

    //lab

    List<Element> findFirst2ByElementName(String elementName);

    Element findByElementNameContaining(String elementName);

    Element findByElementNameStartingWith(String elementName);

    Element findByElementNameEndingWith(String elementName);

    List<Element> findLast3ByElementName(String elementName);


}
