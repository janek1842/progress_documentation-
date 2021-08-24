import random

with open('words.txt','r') as f:
    words = f.readlines()

word = random.choice(words)[:-1]

allowed_errors = 10

guesses = []

finish = False


while not finish:
    for letter in word:
        if letter.lower() in guesses:
            print(letter,end=" ")
        else:
            print("_",end=" ")
    print(" ")
    finish = True

    guess = input(f"Pozostalo: , {allowed_errors} prób ,Podaj kolejną literkę: ")
    guesses.append(guess.lower())

    if guess.lower() not in word.lower():
        allowed_errors = allowed_errors - 1
        if allowed_errors == 0:
            break

    finish = True

    for letter in word:
        if letter.lower() not in guesses:
            finish = False

if finish:
    print("Znalazles to ! ", word)

else:
    print("To koniec, spróbuj jeszcze raz")