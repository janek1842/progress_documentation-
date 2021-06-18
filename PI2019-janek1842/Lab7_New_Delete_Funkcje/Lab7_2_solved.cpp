#include <iostream>

using namespace std;

int main()
{

	cout<<"Podaj rozmiar tablicy "<<endl;

	int size;

	cin>>size;

	int *p=new int[size];

	for(int j=0;j<size;j++)
	{

	 p[j]=j;	

	}

	 for(int j=0;j<size;j++)
        {

                cout<<(*p)++<<endl;

        }

	delete [] p;






	return 0;
}

