#include <iostream>


using namespace std;

struct numbers{

	int a;

	char c;

};

int main()
{

     int tab[10]={0,1,2,3,4,5,6,7,8,9};

 

     int *b=tab;


     for (int i=0;i<=9;i++)

     {
        
     cout<<"Wartosc "<<b[i]<<" Adres "<<&b[i]<<endl;
       
     }

     cout<<"------------------------------"<<endl;

     char tab1[10]={'a','b','c','d','e','f','g','h','i','j'};

     char *c=tab1;

     for(int i=0;i<=9;i++)

     {

    
	

     cout<<"Wartosc "<<c[i]<<" Adres "<<(void*)&c[i]<<endl;


     }   

cout<<"..................................."<<endl;

	numbers p[10];

	numbers *x=p;


	for(int i=0;i<=9;i++)
{	
	(x+i)->a=i;

	cout<<"Wartosc: "<<(x+i)->a<<endl;

	cout<<"Adres: :"<<(x+i)<<endl;
}
	
    return 0;
}
