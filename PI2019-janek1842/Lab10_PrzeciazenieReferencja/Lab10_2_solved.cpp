#include <iostream>

#include<cstdlib>

using namespace std;

class Vector{
	public:
	Vector(double x1){
	data = new double;
	dimension=1;
	*data=x1;
	}
	Vector (double x1,double x2)
	{
	data = new double[2];
	dimension=2;
	*(data)=x1;
	*(data++)=x2;
	}
	Vector(double x1,double x2 ,double x3)
	{
	data = new double[3];
	dimension=3;
	*data=x1;
	*(data+1)=x2;
	*(data+2)=x3;
	}
	
	~Vector(){

		switch(dimension)
		{
		case 1:
			delete data;
			
		case 2 :
			delete [] data;
			
		case 3:
			delete [] data;
		}

	}

	double abs()
	{
		switch(dimension)
	{
		case 1: 
			return 1;
			break;

		case 2: 
			return 2;
			break;

		case 3:
		       	return 3;
			break;
	
		default: 	
			return 0;
	}
	}

	
	double *data;
	size_t dimension;
};

int main()
{
	Vector r1(0.0);
	Vector r2(1.0,2.0);
	Vector r3(0.1,0.2,0.3);

	cout<< r1.abs() << endl;
	cout<< r2.abs() << endl;
	cout<< r3.abs() << endl;

	return 0;
}
