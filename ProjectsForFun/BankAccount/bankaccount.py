class Result:
    def __init__(self,isSuccess,message,value=None):
        self.isSuccess = isSuccess
        self.message = message
        self.value = value
    def is_ok(self):
        return self.isSuccess

class Ok(Result):
    def __init__(self,message,value=None):
        super().__init__(message,value)
        self.isSuccess = True


class Error(Result):
    def __init__(self,message,value=None):
        super().__init__(message,value)
        self.isSuccess = False

class BankAccount:
    def __init__(self, balance=0):
        self.balance = 0

    def deposit(self,amount):
        """Sprawdz czy sa prawdziwe"""
        self.balance +=amount

    def withdraw(self,amount):
        if(self.balance > amount):
            self.balance -= amount
            print("Wypłacono",amount)
            return Ok("Wypłacono: ",amount)
        return Error("Nie wypłacono:",amount)

    def __str__(self):
        return str(self.balance)

class MinimalBalanceAccount(BankAccount):
    def __init__(self, balance=0, minimalBalance=1000):
        super(MinimalBalanceAccount, self).__init__().__init__(self, balance)
        self.minimalBalance = minimalBalance

    def deposit(self, amount):
        """Sprawdz czy sa prawdziwe"""
        self.balance += amount

    def withdraw(self, amount):
        if(self.balance - amount > self.minimalBalance):
            return super().withdraw(amount)
        else:
            return Error("Nie udało sie, zabrakło:", amount)



