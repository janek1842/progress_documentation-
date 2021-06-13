#include <iostream>

using namespace std;


struct st{
	
	float s;

	char o;


};




int main()

{
	
	int tab[10]={1,2,3,4,5,6,7,8,9,10};

	int tab1[10]={1,2,3,4,5,6,7,8,9,10};

	int *d=tab1;

	int s=(sizeof(tab)/sizeof(tab[0]));

	int *c=tab;

	for(int j=0;j<s;j++)
	{
	
		c[j]=d[(s-1)-j];

		cout<<c[j]<<endl;
	}

cout<<"-------------------------------------------------------------"<<endl;

	char tab2[]={'a','b','c','d','e','f'};

	char tab3[]={'a','b','c','d','e','f'};

	char *a=tab2;

	char *b=tab3;

	for(int i=0;i<6;i++)

	{
		
		a[i]=b[5-i];

		cout<<a[i]<<endl;

	}

cout<<"--------------------------------------------------"<<endl;

st h[10];

	st *y=h;

st p[10];

	st *u=p;	

	for(int i=0;i<=9;i++)
 {

	(y+i)->s=i;

	(u+i)->s=i;
	
 }
	
	
	u=&p[9];

	for(int j=0;j<=9;j++)
{


	(y+j)->s=(u-j)->s;

	cout<<(y+j)->s<<endl;

}




	return 0;
}
