package starbucks

class OrderService {

    def show(Long id) {
        get(id)
    }

    def get(Long id) {
        Order.get(id)
    }

    def save(Order order) {
        saveInstance(order)
    }

    def update(Order order) {
        saveInstance(order)
    }

    private saveInstance(Order order) {
        order.save(flush: true, failOnError: true)
    }
}
