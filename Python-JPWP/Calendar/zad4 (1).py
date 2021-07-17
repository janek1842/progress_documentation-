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


def clearWindow():
    for child in root.winfo_children():
        child.destroy()

def nowylad(S1,S2):
    label1 = Label(root, text=S1)
    label1.grid(row=1, column=0)
    label2 = Label(root, text=S2)
    label2.grid(row=2, column=0)


def gettingStrings():
    insertedData = entry1.get()
    insertedData2 = entry2.get()
    print(insertedData)
    print(insertedData2)
    clearWindow()
    nowylad(insertedData,insertedData2)


button = Button(root,
                text="Pobierz",
                command=lambda: gettingStrings()
                )


button.grid(row=3, column=0)

root.mainloop()
