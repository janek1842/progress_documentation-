# Lab 11

## Dynamiczna alokacja pamięci dla klas

1. Proszę poszerzyć kod z wykładu służący do dodawania wektorów (slajd 28 do 42) o wypisanie adresu wskaźników do klasy `Vector` oraz danych `data_`. Proszę dokładnie prześledzić, kiedy obiekty są tworzone i usuwane z pamięci. Rozwiązanie proszę zapisać jako plik `Lab10_4_solved.cpp` i umieść w swojej gałęzi git.
1. Proszę poszerzyć kod z wykładu o wypisywanie adresów wskaźników dla kodu poprawnie wykonującego zwalnianie pamięci z wykorzystaniem każdego z przedstawionych rozwiązań: wskaźnik, referencja i konstruktor kopiujący (slajdy 43 do 50). Rozwiązanie proszę zapisać jako plik `Lab10_5_solved.cpp` i umieść w swojej gałęzi git.
1. Proszę poszerzyć klasę wektor o możliwość przechowywania danych dla wektorów dłuższych od 1. Następnie proszę rozwiązać problem funkcji `add` z wykorzystaniem konstruktora kopiującego. Rozwiązanie proszę zapisać jako plik `Lab10_6_solved.cpp` i umieść w swojej gałęzi git.

## Dziedziczenie

1. Proszę stworzyć klasę `CD`, która posiada dane `content_` będące 10 elementową tablicą znaków oraz "świadomość" czy jest w czytniku. Dodatkowo klasa `CD` posiada metodę `read` odczytującą dane, jeżeli jest w czytniku i metodę `in_out` pozwalającą włożyć lub wyjąć czytnik z odtwarzacza. Będziemy też potrzebować konstruktor, dzięki któremu wpiszemy dane. Rozwiązanie proszę zapisać jako plik `Lab10_7_solved.cpp` i umieść w swojej gałęzi git.
1. Proszę stworzyć klasę `CDRW`, która będzie dziedziczyć po klasie `CD` i dodatkowo implementować metodę `write`. Rozwiązanie proszę zapisać jako plik `Lab10_7_solved.cpp` i umieść w swojej gałęzi git.
1. Proszę stworzyć klasę `BR`, która dziedziczy po klasie `CDRW`, ale posiada więcej miejsca na treść, tablica, zamiast dziesięcio powinna być dwudziesto elementowa. Rozwiązanie proszę zapisać jako plik `Lab10_7_solved.cpp` i umieść w swojej gałęzi git.