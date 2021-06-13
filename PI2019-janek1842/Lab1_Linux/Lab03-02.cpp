#include <iostream>


using namespace std;

int main()

{
	int a=5;
	int b=10;

	if(a==5&&b==10)
		cout<<"Jest 5 i 10"<<endl;

	
	if(a!=1)
		cout<<"Nie ma jedynki"<<endl;

	if(a==5||b==6)

		cout<<"Jest OK"<<endl;

	int c=true;

		cout<<"wartosc logiczna c to"<<c<<endl;
	
	bool d;

		d=c++;
		
		cout<<d<<endl;

	int x=4;

		if(!(x<3 && x>7))

			cout<<"z na lezy od 3 do 7"<<endl;
		else
			cout<<"z nie nalezy"<<endl;








	return 0;
}
