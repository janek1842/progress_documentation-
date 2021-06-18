#include <iostream>

using namespace std;


    int clipping (int a)
{
    int x;

    if(a>=10&&a<=20) 
    {
        return a;
    }
        
    if(a<10)
    {
        return 10;
    }

    if(a>20)
    {
        return 20;
    }

}


int main()

{

    int a;

    cout<<"Podaj wartosc "<<endl;

    cin>>a;


    cout<<clipping(a)<<endl;























    return 0;
}
