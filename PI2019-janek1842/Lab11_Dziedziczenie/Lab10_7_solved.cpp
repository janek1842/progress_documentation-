#include <iostream>

using namespace std;



    class CD{

    public:

        CD (){

            for (int i=0;i<10;i++)
            {
                cin>>content_[i];
            }

        }

        char content_[10];

        bool czytnik;

        void read ()
        {
            if(czytnik)
            {
            for (int i=0;i<10;i++)
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

int main()
{

    

    return 0;
}
