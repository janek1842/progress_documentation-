#include <iostream>

using namespace std;


int main()
{
	//przesuniecie bitowe

	unsigned int a=19;

	unsigned short b;

	b=a>>3;

	cout<<b<<endl;

	unsigned short c;
	
	c=a<<2;

	cout<<c<<endl;


	a=~a;

	cout<<a<<endl;






return 0;
}
