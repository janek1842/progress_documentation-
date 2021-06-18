#include <iostream>


using namespace std;


int main()

{

	char tab[]={'a','b','c','d','e','f','g','h','i','j'};

	size_t s =sizeof(tab)/sizeof(tab[0]);

	cout<<"Co drugi:"<<endl;

	char *wsk=tab;

	for(int i=0;i<s;i=i+2)
	{
		
		
	cout<<*(wsk+i)<<endl;


	}
cout<<".............................................................."<<endl;
	
	int a=0; 
	int k=0;


	for(int j=0;j<s;j++)

	{
		

		if(j==k+a)
		
		{
		 
			cout<<wsk[j]<<endl;
	
			a=j;		
	
			k++;

		}

	}

	return 0;
}
