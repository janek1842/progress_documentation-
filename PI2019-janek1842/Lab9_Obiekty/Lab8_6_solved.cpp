#include <iostream>

using namespace std;

class vector2d {

    private:

    int *wsk;

    public:
    
    vector2d () {

    	wsk=new int [2];
	wsk[0]=1;
	wsk[1]=2;
    }

    void print2d()
        {
            cout<<"x1:"<<wsk[0]<<endl;
	    cout<<"x2:"<<wsk[1]<<endl;
	}

    void add(vector2d wekt)
        {
            wsk[0] = wsk[0] + wekt.wsk[0];
            wsk[1] = wsk[1] + wekt.wsk[1];
        }

    int set(int x10, int x20)
    {
        wsk[0]=wsk[0]+x10;
	wsk[1]=wsk[1]+x20;
    }

    int get()
    
    {
        cout<<"X1: "<<wsk[0]<<endl;
	cout<<"X2: "<<wsk[1]<<endl;
    }

   
      ~vector2d()
    {

	delete [] wsk;
    }

  
};

int main()

{
    vector2d wekt;

    int x10,x20;

    cin>>x10;

    cin>>x20;

    wekt.set(x10,x20);
	
    wekt.get();
    
    return 0;
}
