package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.repositories.ElementRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


/**
 * Created by jonagill1 on 6/20/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ElementRepositoryTest {

    @Autowired
    private ElementRepository elementRepository;

//    @Test
//    public void testSaveElement(){
//        //setup element
//        Element element = new Element();
//        element.setElementName("Phone");
//
//        //save element, verify it has an ID after the save
//        assertNull(element.getId());
//        elementRepository.save(element);
//        assertNotNull(element.getId());
//
//        //fetch
//        Element fetchedElement = elementRepository.findOne(element.getId());
//        assertNotNull(fetchedElement);
//        assertEquals(element.getId(), fetchedElement.getId());
//
//        //update
//        fetchedElement.setElementName("Email");
//        elementRepository.save(fetchedElement);
//
//        Element updatedElement = elementRepository.findOne(fetchedElement.getId());
//        assertEquals(updatedElement.getElementName(), "Email");
//    }
//
//    @Test
//    public void testSaveElementList(){
//        List<Element> elementList = new ArrayList<>();
//
//        elementList.add(new Element("Phone"));
//        elementList.add(new Element("Email"));
//        elementList.add(new Element("Laptop"));
//        elementList.add(new Element("PayRate"));
//
//        elementRepository.save(elementList);
//
//        Iterable<Element> fetchedElementList = elementRepository.findAll();
//
//        int count = 0;
//        for(Element element : fetchedElementList){
//            count++;
//        }
//
//       // assertEquals(5, count);
//    }
//
//    @Test
//    public void testFindByName(){
//        Element element = new Element("FindTest11");
//        elementRepository.save(element);
//
//        Element foundByName = elementRepository.findByElementName("FindTest11");
//
//        assertEquals(element.getId(), foundByName.getId());
//    }
//
//    @Test
//    public void testFindAllByName(){
//        Element element1 = new Element("FindTest");
//        elementRepository.save(element1);
//        Element element2 = new Element("FindTest");
//        elementRepository.save(element2);
//        Element element3 = new Element("FindTest");
//        elementRepository.save(element3);
//
//        List<Element> foundAllByName = elementRepository.findAllByElementName("FindTest");
//
//        assertEquals(4, foundAllByName.size());
//    }
///////////lab
//    @Test
//    public void testFindFirst2ByName() {
//        Element element11 = new Element("FindTest");
//        elementRepository.save(element11);
//        Element element22 = new Element("FindTest1");
//        elementRepository.save(element22);
//        Element element33 = new Element("FindTest1");
//        elementRepository.save(element33);
//        Element element44 = new Element("FindTest1");
//        elementRepository.save(element44);
//
//        List<Element> found2 = elementRepository.findFirst2ByElementName("FindTest1");
//
//        assertEquals(2, found2.size());
//    }
//
//    @Test
//    public void testFindNameContaining(){
//        Element element111 = new Element("Phone");
//        elementRepository.save(element111);
//        Element element222 = new Element("Email");
//        elementRepository.save(element222);
//        Element element333 = new Element("Laptop");
//        elementRepository.save(element333);
//
//        Element checkedElement = elementRepository.findByElementNameContaining("%m%");
//
//        assertEquals(checkedElement.getElementName(), "Email");
//    }

//    @Test
//    public void testFindNameStartingWith(){
//        Element element111 = new Element("Phone");
//        elementRepository.save(element111);
//        Element element222 = new Element("Email");
//        elementRepository.save(element222);
//        Element element333 = new Element("Laptop");
//        elementRepository.save(element333);
//
//        Element checkedElement = elementRepository.findByElementNameStartingWith("P%");
//
//        assertEquals(checkedElement.getElementName(), "Phone");
//    }
//    @Test
//    public void testFindNameEndingWith(){
//        Element element111 = new Element("Phone");
//        elementRepository.save(element111);
//        Element element222 = new Element("Email");
//        elementRepository.save(element222);
//        Element element333 = new Element("Laptop");
//        elementRepository.save(element333);
//
//        Element checkedElement = elementRepository.findByElementNameEndingWith("%e");
//
//        assertEquals(checkedElement.getElementName(), "Phone");
//    }

    @Test
    public void testFindLast3ByName() {
        Element element11 = new Element("FindTest");
        elementRepository.save(element11);
        Element element22 = new Element("FindTest1");
        elementRepository.save(element22);
        Element element33 = new Element("FindTest1");
        elementRepository.save(element33);
        Element element44 = new Element("FindTest1");
        elementRepository.save(element44);
        Element element55 = new Element("FindTest");
        elementRepository.save(element55);
        Element element66 = new Element("FindTest");
        elementRepository.save(element66);

        List<Element> found3 = elementRepository.findLast3ByElementName("FindTest");

        assertEquals(3, found3.size());
    }
}
