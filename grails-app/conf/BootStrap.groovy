import grails.util.Environment
import starbucks.Coffee
import starbucks.Ingredient
import starbucks.Order

class BootStrap {

    def init = { servletContext ->

        if (Environment.current.isDevelopmentMode()) {
            def coffee = new Coffee(name: 'Black coffee with sugar', price: 5d).save()
            def milk = new Ingredient(name: 'Milk', price: 2d).save()
            def sugar = new Ingredient(name: 'Sugar', price: 1d).save()
            def order = new Order(coffee: coffee)
            order.extraIngredients << milk
            order.excludedIngredients << sugar
            order.save()
        }
    }
    def destroy = {
    }
}
