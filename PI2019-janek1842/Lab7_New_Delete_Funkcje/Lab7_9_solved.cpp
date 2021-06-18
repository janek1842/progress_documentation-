#include <iostream>

#include<math.h>

using namespace std;


struct st{

	float a;

	float b;

	float c;



};

struct nw{

	float x1;

	float x2;

};




void liczenie (st in,nw im)
{
    if(pow(in.b,2)-4*in.a*in.c<0)
    {
        cout<<"Brak miejsc zerowych"<<endl;
    }

    if(pow(in.b,2)-4*in.a*in.c==0)
    {
        im.x1=(-in.b/(2*(in.a)));

	nw *wsk=&im;

	cout<<(wsk)->x1<<endl;
    }

    if(pow(in.b,2)-4*in.a*in.c>0)
    {

	nw *wsk=&im;	


       im.x1= ((-in.b+sqrt(pow(in.b,2)-4*in.a*in.c))/2*in.a);

       im.x2=((-in.b-sqrt(pow(in.b,2)-4*in.a*in.c))/2*in.a);

	cout<<"X1: "<<(wsk)->x1<<endl;

	cout<<"X2: "<<(wsk)->x2<<endl;

    }   
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

    st in={a,b,c};

    nw im;
   

    liczenie(in,im);







    return 0;
}
