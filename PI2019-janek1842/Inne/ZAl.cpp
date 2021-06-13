#include <iostream>

#include <math.h>

using namespace std;

int main()


{

	int tab[]={13,3,4,9,12,4,16};

	size_t t=sizeof(tab)/sizeof(tab[0]);

	for(int i=0;i<=t;i++)
	{

		for(int j=0;j<=t;j++)
		{

			if((sqrt(tab[i])==tab[j]))
			{
				cout<<tab[j]<<"jest pierwiastkiem z "<<tab[i]<<endl;
				exit(0);
			}

		}

	}

	return 0;
}
