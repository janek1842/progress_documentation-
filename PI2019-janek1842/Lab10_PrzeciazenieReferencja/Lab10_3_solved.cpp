#include <iostream>

using namespace std;

class Vec {
	
	public:
	
	int x,y;
/*	
	void getx(int x)
		x=x;
	
	void getY(int y)
		y=y;
*/
	Vec(){

	x=5;
	y=5;

	}

	void add_one()
	{
		x+=1;
		y+=1;	
	}
};

void funkcja1(Vec v)
{
	v.add_one();
	cout<<"F1: "<<v.x<<" "<<v.y<<endl;
}

void funkcja2(Vec *wsk1)
{
	wsk1->add_one();
	cout<<"F2: "<<wsk1->x<<" "<<wsk1->y<<endl;
}
void funkcja3(Vec &arg)
{
	arg.add_one();

	cout<<"F3: "<<arg.x<<" "<<arg.y<<endl;
}
/*
void funkcja4(const Vec &r)
{
	r.add_one();
	cout<<"F4: "<<r.x<<" "<<r.y<<endl;
}
*/
void funkcja5(Vec *wsk,int l)
{
	for (int i=0;i<l;i++)
	{
		wsk[i].add_one();
		cout<<wsk[i].x<<" "<<wsk[i].y<<endl;
	}
}

int main()
{
	Vec w1;
	cout<<"Przed wywolaniem: "<<w1.x<<" "<<w1.y<<endl;
	funkcja1(w1);

	Vec w2;
	Vec *wsk=&w2;
	cout<<"Przed wywolaniem: "<<w2.x<<" "<<w2.y<<endl;
	funkcja2(wsk);

	Vec w3;
	Vec &ref=w3;
	cout<<"Przed wywolaniem: "<<ref.x<<" "<<ref.y<<endl;
	funkcja3(ref);
//Nie dziala przekazywanie przez stala referencje, poniewaz chcemy modyfikowac 
//dane z obiektu klasy Vec ( w funkcji add_one)

/*	Vec w4;
	const Vec &c=w4;
	cout<<"Przed wywolaniem: "<<c.x<<" "<<c.y<<endl;
	funkcja4(c);
*/
	
	Vec tab[10];
	int l=10;

	Vec *wsk5=tab;

	funkcja5(wsk5,l);

	return 0;
}
