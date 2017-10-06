import chapter4.ex12.groovyConfiguration.Contact
import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader
import org.springframework.context.support.GenericApplicationContext

def context = new GenericApplicationContext()
def reader = new GroovyBeanDefinitionReader(context)

reader.beans {
    contact(Contact, firstName: 'Anne', lastName: 'Hall', age: 25)
}
context.refresh()
println context.getBean("contact")