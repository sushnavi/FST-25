class Car:
    'This class represents a car'

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " has started moving")

    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped moving")

car1 = Car("BMW", "X1", "2025", "Automatic", "Black")
car2 = Car("Tesla", "Y", "2024", "Manual", "White")
car3 = Car("Hyundai", "Creta", "2021", "Automatic", "Midnight Green")

car1.accelerate()
car1.stop()

car2.accelerate()
car2.stop()

car3.accelerate()
car3.stop()