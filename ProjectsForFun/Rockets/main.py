from random import randint


class Rocket:
    def __init__(self, speed=1):
        self.altitude = 0
        self.width = 0
        self.speed = speed

    def moveUp(self):
        self.altitude += self.speed
        self.width += self.speed

    def __str__(self):
        return "Rakieta jest aktualnie na wysokości: " + str(self.altitude)


class RocketBoard:
    def __init__(self, amountOfRockets=5):
        self.rockets = [Rocket(randint(1, 6)) for _ in range(amountOfRockets)]

        for _ in range(10):
            rocketIndexToMove = randint(0, len(self.rockets) - 1)
            self.rockets[rocketIndexToMove].moveUp()

        for rocket in self.rockets:
            print(rocket)

    def __getitem__(self,key):
        return self.rockets[key]

    def __setitem__(self, key, value):
        self.rockets[key] = value

    def __len__(self):
        return len(self.rockets)

    @staticmethod
    def get_distance(rocket1: Rocket,rocket2: Rocket):

        return abs(pow((rocket1.altitude-rocket2.altitude),2) + pow(rocket1.width-rocket2.width,2))


