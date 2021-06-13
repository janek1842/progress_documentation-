#include<iostream>

using namespace std;

int main()

	{

		int tab[]={8,8,4,4,8,8,8,8,8,4,8,4,4,4,4,4,4,4,4};
		
		int k=0;

		int y=0;

		int wynik=0;

	for(int j=0;tab[j]<19;j++)
	{

		for(int i=j;i<=19;i++)
		{
			if(tab[j]==tab[i])
			{
				
				y++;
				
				if(y>=k)
				{
					
					wynik=tab[j];
					k=y;
										
				}

			}		
		}
	
	y=0;
	}

		cout<<wynik<<endl;

		return 0;
	}



