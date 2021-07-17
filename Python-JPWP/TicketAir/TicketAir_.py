import sqlite3
import HomePage
import sys
from PyQt5 import QtCore, QtGui, QtWidgets


class Flight:
    def __init__(self):
        self.origin = ''
        self.destination = ''
        self.flightNumber = ''
        self.airplane = None
        self.date = None
        self.price = 0
        self.time = 0

    def __init__(self, origin, destination, flightNumber, plane, date, price, time, sold=0):
        self.origin = origin
        self.destination = destination
        self.flightNumber = flightNumber
        if isinstance(plane, str):
            plane = DataBase().getPlane(plane)
        self.plane = plane
        self.date = date
        self.price = price
        self.time = time
        self.sold = sold

    def values(self):
        return f'("{self.origin}", "{self.destination}", "{self.flightNumber}", "{self.plane.tailNumber}",' \
               f' "{self.date}", {self.price}, {self.time}, {self.plane.capacity}, {self.sold})'



class Plane:
    def __init__(self):
        self.yearOfProduction = 0
        self.flightMiles = 0
        self.capacity = 0
        self.tailNumber = ''

    def __init__(self, yearOfProduction, flightMiles, capacity, tailNumber):
        self.yearOfProduction = yearOfProduction
        self.flightMiles = flightMiles
        self.capacity = capacity
        self.tailNumber = tailNumber

    def values(self):
        return f'("{self.tailNumber}", "{self.yearOfProduction}", "{self.flightMiles}", "{self.capacity}")'


class Ticket:
    def __init__(self):
        self.flight = None
        self.price = 0
        self.places = 0
        self.luggageID = 0

    def __init__(self, flight, price, places, luggageID):
        self.flight = flight
        self.price = price
        self.places = places
        self.luggageID = luggageID

    def buyTicket(self, passenger):
        passenger.tickets.append(self)


class Passenger:
    def __init__(self):
        self.name = None
        self.tickets = None
        self.address = None
        self.password = None
        self.login = None

    def __init__(self, name, tickets, address, password, login):
        self.name = name
        self.tickets = tickets
        self.address = address
        self.password = password
        self.login = login

    def values(self):
        isAdmin = int(isinstance(self, Admin))
        return f'("ID", "{self.name}", "{self.tickets}", "{isAdmin}", "{self.password}", "{self.login}")'


class Admin(Passenger):
    def __init__(self):
        super().__init__()

    def __init__(self, name, tickets, address, password, login):
        self.name = name
        self.tickets = tickets
        self.address = address
        self.password = password
        self.login = login

    def addFlight(self, flight):
        flight.add(self)

    def addPlane(self, plane):
        plane.add(self)

    def cancelFlight(self, flight):
        flight.cancel(self)

    def removePlane(self, plane):
        plane.remove(self)


class DataBase:
    def createTables(self):
        con = sqlite3.connect('ticketair.db')
        cur = con.cursor()
        try:
            cur.execute('''CREATE TABLE flights
                            (origin text, destination text, flightNumber text, planeTailNumber text, price real, time real, capacity integer, sold integer)
                        ''')
        except sqlite3.OperationalError:
            pass
        try:
            #ZADANIE 1:
            #Zmodyfikuj funkcję w ten sposób, aby została również stworzona tabela samolotów.
            cur.execute('''CREATE TABLE flights
                                        (origin text, destination text, flightNumber text, planeTailNumber text, price real, time real, capacity integer, sold integer)
                                    ''')
        except sqlite3.OperationalError:
            pass
        try:
            cur.execute('''CREATE TABLE users
                            (userID text, name text, ticketsIDs text, isAdmin integer, password text, login text)
                        ''')
        except sqlite3.OperationalError:
            pass
        try:
            cur.execute('''CREATE TABLE tickets
                            (flightNumber text, price real, places integer, luggageID integer)
                        ''')
        except sqlite3.OperationalError:
            pass
        con.commit()
        con.close()

    def addFlight(self, flight):
        con = sqlite3.connect('ticketair.db')
        cur = con.cursor()
        cur.execute('INSERT INTO flights VALUES ' + flight.values())
        con.commit()
        con.close()

    def addPlane(self, plane):
        #ZADANIE 2:
        #uzupełnij funkcję tak, aby dodawała do tabeli nowy wiersz z odpowiednimi wartościami samolotu.


    def addUser(self, user):
        con = sqlite3.connect('ticketair.db')
        cur = con.cursor()
        cur.execute('INSERT INTO users VALUES ' + user.values())
        con.commit()
        con.close()

    def getPlane(self, tailNumber):
        con = sqlite3.connect('ticketair.db')
        cur = con.cursor()
        cur.execute(f'SELECT * FROM planes WHERE tailNumber = "{tailNumber}"')
        tailNumber, year, flightMiles, capacity = cur.fetchone()
        con.close()
        return Plane(year, flightMiles, capacity, tailNumber)

    def getDestinations(self, origin=None):
        con = sqlite3.connect('ticketair.db')
        cur = con.cursor()
        if origin == None or origin == '':
            cur.execute(f'SELECT DISTINCT destination FROM flights')
        else:
            cur.execute(f'SELECT DISTINCT destination FROM flights WHERE origin="{origin}"')
        destinations = []
        for dest, in cur.fetchall():
            destinations.append(str(dest))
        return destinations

    def getOrigins(self, destination=None):
        con = sqlite3.connect('ticketair.db')
        cur = con.cursor()
        if destination == None or destination == '':
            cur.execute(f'SELECT DISTINCT origin FROM flights')
        else:
            cur.execute(f'SELECT DISTINCT origin FROM flights WHERE destination="{destination}"')
        origins = []
        for origin, in cur.fetchall():
            origins.append(str(origin))
        return origins

    def login(self, login, password):
        con = sqlite3.connect('ticketair.db')
        cur = con.cursor()
        cur.execute(f'SELECT * FROM users WHERE login="{login}"')

        userID, name, ticketsIDs, isAdmin, passwordData, loginData = cur.fetchone()
        con.close()
        if passwordData == password:
            if isAdmin == 0:
                return Passenger(name, ticketsIDs, "", password, loginData)
            else:
                return Admin(name, ticketsIDs, "", password, loginData)
        else:
            return None

    def cancelFlight(self, flightNumber):
        con = sqlite3.connect('ticketair.db')
        cur = con.cursor()
        cur.execute(f"DELETE FROM flights WHERE flightNumber='{flightNumber}'")
        deleted = cur.rowcount
        con.commit()
        con.close()
        return deleted >= 1

    def removePlane(self, tailNumber):
        con = sqlite3.connect('ticketair.db')
        cur = con.cursor()
        cur.execute(f"DELETE FROM planes WHERE tailNumber='{tailNumber}'")
        deleted = cur.rowcount
        cur.execute(f"DELETE FROM flights WHERE planeTailNumber='{tailNumber}'")
        con.commit()
        con.close()
        return deleted >= 1

    def nickTaken(self, nick):
        con = sqlite3.connect('ticketair.db')
        cur = con.cursor()
        cur.execute(f'SELECT 1 FROM users WHERE login="{nick}"')
        if cur.fetchone():
            return True
        else:
            return False

    def getFlight(self, flightNumber):
        con = sqlite3.connect('ticketair.db')
        cur = con.cursor()
        try:
            cur.execute(f'SELECT * FROM flights WHERE flightNumber = "{flightNumber}"')
            origin, destination, flightNumber, tailNumber, date, price, time, capacity, sold = cur.fetchone()
            flight = Flight(origin, destination, flightNumber, tailNumber, date, price, time, sold)
            con.close()
        except:
            flight = None
        return flight

    def getFlightfromBox(self, origin, destination):
        con = sqlite3.connect('ticketair.db')
        cur = con.cursor()
        cur.execute(f'SELECT * FROM flights WHERE origin = "{origin}" AND destination = "{destination}"')
        origin, destination, flightNumber, tailNumber, date, price, time, capacity, sold = cur.fetchone()
        con.close()
        return Flight(origin, destination, flightNumber, tailNumber, date, price, time, sold)

    def addTicket(self, user, ticket):
        con = sqlite3.connect('ticketair.db')
        cur = con.cursor()
        cur.execute(f"INSERT INTO tickets VALUES ('{ticket.flight.flightNumber}', {ticket.price}, {ticket.places}, {ticket.luggageID})")
        con.commit()
        cur.execute(f"UPDATE users SET ticketsIDs = ticketsIDs || '{cur.lastrowid}' || '|' WHERE login = '{user}'")
        con.commit()
        cur.execute(f"UPDATE flights SET sold = sold + {ticket.places} WHERE flightNumber = '{ticket.flight.flightNumber}'")
        con.commit()
        con.close()

    def get3RandomFlights(self):
        import random
        con = sqlite3.connect('ticketair.db')
        cur = con.cursor()
        cur.execute('SELECT COUNT(*) FROM flights')
        flightCount = cur.fetchone()[0]
        flightsN = random.sample(range(1, flightCount+1), 3)
        flights = []
        for n in flightsN:
            cur.execute(f'SELECT * FROM flights LIMIT {n-1},1')
            origin, destination, flightNumber, tailNumber, date, price, time, capacity, sold = cur.fetchone()
            flights.append(Flight(origin, destination, flightNumber, tailNumber, date, price, time, sold))
        return flights


if __name__ == '__main__':
    db = DataBase()
    db.createTables()
    app = QtWidgets.QApplication(sys.argv)
    MainWindow = QtWidgets.QMainWindow()
    ui = HomePage.Ui_MainWindow()
    ui.setupUi(MainWindow)
    ui.setOrigins()
    ui.callThisFunctionEvery15Secs()
    MainWindow.show()
    sys.exit(app.exec_())