#include <iostream>

using namespace std;

class CD{
	
	public:

	CD(){
		for (int i=0;i<10;i++)
		{
		cin>>content_[i];
		}
	}

	char content_[10];

	bool czytnik=0;

	void read()
	{
		if (czytnik)
		{
		for(int i=0;i<10;i++)
		{
			cout<<content_[i]<<endl;
		}
		}
	}
	void in_out()
	{
		if(czytnik)
			czytnik=false;
		else
			czytnik=true;
	}
};

class CDRW : public CD  {

	public:

	void write();
};

class BR : public CDRW{

	public:
	
	BR(){
	
	for (int i=0;i<20;i++)
                {
                cin>>content_[i];
                }	
	}

	char content_[20];	
};

int main()
{
 	CD a;

	BR b;

	cout<<sizeof(a.content_)<<endl;

	cout<<sizeof(b.content_)<<endl;



	return 0;
}
