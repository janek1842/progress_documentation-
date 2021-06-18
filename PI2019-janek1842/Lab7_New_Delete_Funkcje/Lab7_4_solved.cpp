#include <iostream>

#include<math.h>

using namespace std;


void pierwiastki(float a,float b,float d)
{
    if(d<0)
    {
        cout<<"Brak miejsc zerowych"<<endl;
    }

    if(d==0)
    {
        cout<<"Miejsce zerowe to: "<<(-b/2*a)<<endl;
    }

    if(d>0)
    {
        cout<<"Miejsca zerowe to: "<<((-b+sqrt(d))/2*a)<<" oraz "                    <<((-b-sqrt(d))/2*a)<<endl;
    }   
}


float delta(float a,float b,float c)
{
    return (b*b-4*a*c);
}






int main()

{

    float a,b,c;

    cout<<"Podaj a "<<endl;
    cin>>a;

    cout<<"Podaj b "<<endl;
    cin>>b;

    cout<<"Podaj c "<<endl;
    cin>>c;

    
    float d=delta(a,b,c);

    pierwiastki(a,b,d);







    return 0;
}
