import tkinter
from tkinter import *

root = Tk()

root.geometry("250x100+20+20")

label1 = Label(root, text="Pierwszy wpis ")
label1.grid(row=1, column=0)

entry = Entry(root)
entry.grid(row=1, column=1)

label2 = Label(root, text="Drugi wpis ")
label2.grid(row=2, column=0)

entry = Entry(root)
entry.grid(row=2, column=1)

root.mainloop()