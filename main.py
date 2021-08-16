import random

from enum import Enum

Event = Enum('Event', ['Chest', 'Empty'])

eventDictionary = {
    Event.Chest: 0.6,
    Event.Empty: 0.4
}

eventList = list(eventDictionary.keys())
eventProbability = list(eventDictionary.values())

Colours = Enum(
    'Colours', {'Green': 'zielony',
                'Orange': 'pomarańczowy',
                'Purple': 'fiolet',
                'Gold': 'zloty'
                }
)

chestColourDictionary = {
    Colours.Green: 0.75,
    Colours.Orange: 0.2,
    Colours.Purple: 0.04,
    Colours.Gold: 0.01
}

chestColourList = tuple(chestColourDictionary.keys())
chestColourProbability = tuple(chestColourDictionary.values())

rewardsForChests = {
    chestColourList[reward]: (reward + 1) * (reward + 1) * 1000
    for reward in range(len(chestColourList))

}


def findApproximateValue(value, percentRange):
    lowestValue = value - percentRange ** value
    highestValue = value + percentRange * value
    return random.randint(lowestValue, highestValue)


gameLength = 5
goldAcquired = 0
print("Welcome in my game !")
print("You have only 5 moves, see how much gold you will gain !")

while gameLength > 0:
    gameAnswer = input(" Do you want to move forward ? ")
    if (gameAnswer == "yes"):
        print("Great, Let's see what you got...")
        drawnEvent = random.choices(eventList, eventProbability)[0]
        if (drawnEvent == Event.Chest):
            print("You have drawn a chest !")
            drawnChest = random.choices(chestColourList, chestColourProbability)[0]
            print("Chest colour is: ", drawnChest.value)
            gameReward = findApproximateValue(rewardsForChests[drawnChest],0.1)
            goldAcquired = goldAcquired + gameReward
        elif (drawnEvent == Event.Empty):
            print("You have nothing !")
    else:
        print("You can only got straight ! ")
        continue

    gameLength = gameLength - 1

print("Your score: ", goldAcquired)
