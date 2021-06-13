#include <iostream>

#include<string>

using namespace std;

class czas {
    public:
    
        int czasy;
        int godz;
        int minuta;

     czas(int minuta_)
    {
        czasy=minuta_;
    }


     czas(int godz,int minuta_)
    {
        czasy=(60*godz)+minuta_;
    }

    czas(string tab)
    {
        godz=10*((int)tab[0]-48)+((int)tab[1]-48);

        minuta=10*((int)tab[3]-48)+((int)tab[4]-48);

        czasy=(godz*60)+minuta;

    }

    void printme()
    {
        cout<<"Uplynelo "<<czasy<<" minut"<<endl;
    }



};

int main()
{
    czas time(2,0);

    time.printme();

    czas time2("01:45");

    time2.printme();

    return 0;
}
