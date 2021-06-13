#include <iostream>

using namespace std;


int main()
{

	int tab[]={1,2,3,4,5,6,7,8,9};

	int suma=10;

	for (int i=tab[0];i<10;i++)
		{	
			int j=0;

			for(j=tab[0];j<=9;j++)
			{

			if(i+j==suma)
				{
				cout<<"wynik to "<<i<<","<<j<<endl;
				}
			if(j>=i)
			{
				break;
			}

		}

		}
	return 0;
}
