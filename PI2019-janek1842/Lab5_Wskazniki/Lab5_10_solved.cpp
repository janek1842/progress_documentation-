#include <iostream>


using namespace std;

int main()
{

    char *c;

    char tab[] = "Ala ma kota";

    c=tab;

    int d=sizeof(tab);

    cout<<"Caly napis "<<endl;

    for (int i=0;i<=d;i++)
    {

        cout<<c[i];

    }

   cout<<" " <<endl;
    

    c=&tab[4];

    d=(sizeof(tab)-4);

    cout<<"Bez slowa "<<endl;

    for (int i=0;i<=d;i++)
    {
        
        cout<<c[i];

    }

    cout<<" "<<endl;
    
  













    return 0;
}
