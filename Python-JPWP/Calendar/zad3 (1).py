import tkinter
from tkinter import *
import re

root = Tk()

root.geometry("250x100+20+20")
insertedData = StringVar()
insertedData2 = StringVar()

label1 = Label(root, text="Pierwszy wpis ")
label1.grid(row=1, column=0)

entry1 = Entry(root, textvariable=insertedData)
entry1.grid(row=1, column=1)

label2 = Label(root, text="Drugi wpis ")
label2.grid(row=2, column=0)

entry2 = Entry(root, textvariable=insertedData2)
entry2.grid(row=2, column=1)


def gettingStrings():
    insertedData = entry1.get()


    x = re.search("^T.*R$", insertedData)

    if x:
        print("PIERWSZY SIE ZGADZA!")
    else:
        print("No match")

    insertedData2 = entry2.get()

    x = re.search("^Z.*A$", insertedData2)

    if x:
        print("DRUGI SIE ZGADZA!")
    else:
        print("No match")





button = Button(root,
                text="Pobierz",
                command=lambda: gettingStrings())
button.grid(row=3, column=0)

root.mainloop()
