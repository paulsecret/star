package starbucks

import groovy.transform.ToString

@ToString(includeNames=true, includeFields=true)
class Ingredient {

    String name
    double price

    static constraints = {
        name blank: false
        price min: 0d
    }
}
