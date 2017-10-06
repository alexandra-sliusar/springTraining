package chapter4.ex12_groovyConfiguration

import chapter4.ex12.groovyConfiguration.Contact

beans {
    contact(Contact, firstName: 'Anne', lastName: 'Hall', age: 24)
}