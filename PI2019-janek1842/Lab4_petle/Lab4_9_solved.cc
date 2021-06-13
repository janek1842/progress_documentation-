/*Do i = 1 to 100 
	set p to true
	If i is divisible by 3
		print "Fizz"
		set p to false
	If i is divisible by 5
		print "Buzz" 
		set p to falses
	If p
	print i
	print a newline*/


#include <iostream>

using namespace std;

int main()
{

   



    for(int i=1;i<=100;i++) 
    {
        bool p=true;

        if(i%3==0)
        { cout<<"Fizz"<<endl;
            p=false;
        } if(i%5==0)
        {
            cout<<"Buzz"<<endl;
            p=false;
        }

        if(p){
        cout<<i<<endl;
        }

    }












    return 0;
}


