#include <iostream>

using namespace std;

class vector2d {

    private:

    int x1,x2;

    public:
    
    vector2d () {

     x1=10;

     x2=15;

    }

    void print2d()
        {
            cout<<"x1: "<<x1<<endl;
            cout<<"x2: "<<x2<<endl;
        }

    void add(vector2d wekt)
        {
            x1 = x1 + wekt.x1;
            x2 = x2 + wekt.x2;
        }

    int set(int x10, int x20)
    {
        x1=x10;

        x2=x20;
    }

    int get()
    
    {
            return x1+x2;
    }

  
};

int main()

{
    vector2d wekt;
    vector2d wekt2;
    
    int x10,x20;

    cin>>x10;

    cin>>x20;

    wekt.set(x10,x20);

    cout<<wekt.get()<<endl;
    
    return 0;
}
