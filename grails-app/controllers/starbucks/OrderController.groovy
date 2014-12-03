package starbucks

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.OK

import org.apache.commons.lang.NotImplementedException

class OrderController {

    static responseFormats = ['json']
    static allowedMethods = [save: 'POST', update: 'PUT', delete: 'DELETE']

    def orderService

    def show() {
        respond orderService.show(params.id as long)
    }

    def save() {
        def newOrder = bindParams(new Order())
        respond orderService.save(newOrder), [status: CREATED]
    }

    def update() {
        def order = orderService.get(params.id as long)
        respond orderService.update(bindParams(order)), [status: OK]
    }

    def delete() {
        throw new NotImplementedException(msg)
    }

    private bindParams(order) {
        bindData(order, params, [exclude: ['totalPrice', 'class']])
    }
}
