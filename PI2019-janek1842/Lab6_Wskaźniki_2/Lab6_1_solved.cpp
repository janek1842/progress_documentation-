#include <iostream>

using namespace std;


int main()

{

	int a=5;

	int b =8;

	int *c=&a;

	int*d=&b;



	cout<<(*d-*c)<<endl; //Wykorzystanie wskaznika

	cout<<*d-a<<endl;//Wykorzystanie wskaznika i liczby a












	return 0;
}
