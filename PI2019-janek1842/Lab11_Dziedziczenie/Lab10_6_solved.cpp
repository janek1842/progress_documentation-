#include <iostream>
#include <string.h>

using namespace std;

class Vector{
	public:
		double *data_;
		int la;

		Vector(int l){

		data_=new double [l];
		la=l;
		for(int i=0;i<l;i++)
		{
			
			data_[i]=i+1;
		}

		}
		~Vector() {delete [] data_;}
		
		Vector(const Vector &copy){
			la=copy.la;
			data_ = new double [la];
			memcpy(data_, copy.data_,sizeof(double)*la);
		}

		void add(Vector arg){
		for(int i=0;i<la;i++)
                {
                        data_[i]+=arg.data_[i];
			cout<<data_[i]<<endl;
			
                }
		 	
		}
};

int main()
{
	int l=10;
	
	Vector a(l);

	Vector b(l);

	a.add(b);

	return 0;
}
