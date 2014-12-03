package starbucks

import spock.lang.Specification

class OrderServiceIntegrationSpec extends Specification {

    private order
    private milk

    def orderService

    def "should save a new order"() {
        when:
        order = orderService.save(order)

        then:
        order
        order.totalPrice == 6d
    }

    def "should update an existing order"() {
        given:
        order = order.save(flush: true, failOnError: true)

        when:
        order.extraIngredients << milk
        order.excludedIngredients = []
        order = orderService.update(order)

        then:
        order.extraIngredients.size() == 2
        !order.excludedIngredients
        order.totalPrice == 9d
    }

    def "should read an existing order"() {
        given:
        order = order.save(flush: true, failOnError: true)

        when:
        order = orderService.show(order.id)

        then:
        order
    }

    def setup() {
        def coffee = new Coffee(name: 'Black coffee with sugar', price: 5d).save()
        milk = new Ingredient(name: 'Milk', price: 2d).save()
        def sugar = new Ingredient(name: 'Sugar', price: 1d).save()
        order = new Order(coffee: coffee)
        order.extraIngredients << milk
        order.excludedIngredients << sugar
    }
}
