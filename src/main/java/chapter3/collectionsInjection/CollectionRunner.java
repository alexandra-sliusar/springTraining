package chapter3.collectionsInjection;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Oleksandra_Sliusar on 25-Sep-17.
 */
public class CollectionRunner {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("chapter3/collectionsInjection/collections-injection-context.xml");
        context.refresh();
        //CollectionKeeper keeper = (CollectionKeeper) context.getBean("collectionKeeper");
        //keeper.displayInfo();

        CollectionAnnotationKeeper annotationKeeper = (CollectionAnnotationKeeper)
                context.getBean("collectionAnnotationKeeper");
        annotationKeeper.displayInfo();
    }
}
