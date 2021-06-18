#include <iostream>

#include <cstring>

using namespace std;

int main(int argc,char *argv[])
{


   if (strcmp(argv[0], "-l") ==0)
    {
        cout<<"File list"<<endl;
    }

   else {
            cout<<"-l -list avaliable files"<<endl;
   }



    return 0;
}
