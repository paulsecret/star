package starbucks

import groovy.transform.ToString

@ToString(includeNames=true, includeFields=true)
class Order {

    Coffee coffee
    List extraIngredients = []
    List excludedIngredients = []
    double totalPrice
    boolean paid = false
    boolean served = false

    static hasMany = [extraIngredients: Ingredient, excludedIngredients: Ingredient]

    static constraints = {
        coffee nullable: false
        totalPrice min: 0d
    }

    static mapping = {
        table 'single_order'
    }

    def beforeInsert() {
        updateTotalPrice()
    }

    def beforeUpdate() {
        updateTotalPrice()
    }

    private updateTotalPrice() {
        totalPrice = coffee?.price
        extraIngredients.each {
            totalPrice += it.price
        }
        excludedIngredients.each {
            totalPrice -= it.price
        }
    }
}
