#include <iostream>

using namespace std;

struct car{
	
	int displacement;

	int seats;

};




int main()
{
	car audi;

	car *wsk=new car;
	
	wsk=&audi;

	wsk->displacement=5;

	wsk->seats=4;
	

	cout<<wsk->displacement<<endl;

	cout<<wsk->seats<<endl;


	delete wsk;

	return 0;
}
