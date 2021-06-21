#include <iostream>
#include <string>
#include <cstdlib>

/* This is simple console application that allows you to play TicTacToe game with computer or with your partner  */

using namespace std;

class Choice{
	public:
	int row;
	int column;
				
};

class Stage{
	
	public:
		
	char space [4][4];	
			
	bool checkStatus(Choice choice,char userSign){
		int i = choice.row;
		int j = choice.column;	
		
		if(i<1 || i>3 || j<1 || j>3 ) {
			cout<<""<<endl;
			cout<<"Wrong move ! Please try again "<<endl;
			return 0;			
		}
		else if(space[i][j]=='X' || space[i][j]=='O') {
			cout<<""<<endl;
			cout<<"Wrong move ! Please try again "<<endl;	
			cout<<""<<endl;
			return 0;		
		}
		else {
			space[i][j]=userSign;
			cout<<""<<endl;
			return 1;					
		}
		
							
	}
		
	void fillStage(){
		for(int i =0;i<4;i++){
			for(int j=0;j<4;j++){
				
				if(j==0 && i==0){
					space[i][j]=' ';
				}
				else if(j==0 && i==1){
					space[i][j]='1';
				}
				else if(j==0 && i==2){
					space[i][j]='2';
				}
				else if(j==0 && i==3){
					space[i][j]='3';
				}
				else if(j==1 && i==0){
					space[i][j]='1';
				}
				else if(j==2 && i==0){
					space[i][j]='2';
				}
				else if(j==3 && i==0){
					space[i][j]='3';
				}
				else{
					space[i][j]='-';
				}
																			
			}
		}
	}
	
	void displayStage(){
		for(int i =0;i<4;i++){
			for(int j=0;j<4;j++){
				cout<<space[i][j];
		}	
		cout<<""<<endl;	
	}
	}
	
		
};



class User{
	public:
	char userSign;
	string nickname;
	bool drawCounter=true;
	
	bool checkifyouWin(Stage &stag){
		char my = userSign;
		bool win = false;
		
		
		for (int i =1;i<=3;i++){
			if(stag.space[i][1]==stag.space[i][2] && stag.space[i][2] == stag.space[i][3] &&  stag.space[i][3] != '-' &&  stag.space[i][2] !='-' &&  stag.space[i][1] !='-' ){
				win = true;				
			}
			if(stag.space[1][i]==stag.space[2][i] && stag.space[2][i]==stag.space[3][i] &&  stag.space[3][i] != '-' &&  stag.space[2][i] !='-' &&  stag.space[1][i] !='-'  ){
				win = true;				
			}
						
		}
		if(stag.space[1][1]==stag.space[2][2] && stag.space[2][2]==stag.space[3][3] &&  stag.space[3][3] !='-'  &&  stag.space[1][1] !='-'  &&  stag.space[2][2] !='-' ){
				win = true;
		}
		if(stag.space[1][3]==stag.space[2][2] && stag.space[2][2]==stag.space[3][1] &&  stag.space[3][3] !='-'  &&  stag.space[1][1] !='-'  &&  stag.space[2][2] !='-' ){
				win = true;
		}
				
		return win;		
							
}

	bool checkifdraw(Stage &stag){
		for(int i =0;i<4;i++){
			for(int j=0;j<4;j++){
				if(stag.space[i][j]=='-')
				{
					drawCounter=false;
				}
		}	
	}
	
	
	return drawCounter;
	}				
};



int main(int argc, char** argv) {
	
	cout<<"------------------------------"<<endl;
	
	cout<<""<<endl;
	
	cout<<"Welcome in Tic Tac Toe game ! \n"<<endl;
	
	cout<<"------------------------------"<<endl;
	
	cout<<""<<endl;
	
	cout<<"ENTER GAME MODE: "<<endl;
	
	cout<<"Type 1 if User vs User (X VS O)"<<endl;
	
	cout<<"Type 2 if User vs PC - WARNING ! Your player will be X"<<endl;
	
	int mode;
	
	cin>>mode;
	
	
	
	if(mode !=1 && mode !=2){
		
		cout<<""<<endl;
		cout<<"You made it wrong ! Please try again, next time type 2 or 1 "<<endl;
		
		abort();
	}
	
	Stage stage ;
			
	stage.fillStage();
	stage.displayStage();
	User current;
	current.userSign='X';
	
	int iterator;	
	bool result;
	
	system("CLS");
	
	stage.displayStage();
	
	while(true){
		
		Choice choice;
							
		cout<<""<<endl;
		
		if(mode==2 && current.userSign=='O') {	
		choice.row = rand() % 3 + 1;
		choice.column = rand() % 3 + 1;
		}
				
		if(current.userSign=='X' || mode==1){
		cout<<"Move for: "<<current.userSign<<endl;
		cout<<""<<endl;	
		cout<<"Enter a row number: "<<endl;
		cin>>choice.row;
		cout<<"Enter a column number: "<<endl;
		cin>>choice.column;
	}
		result = stage.checkStatus(choice,current.userSign);
		
		bool win = current.checkifyouWin(stage);
		bool draw = current.checkifdraw(stage);
		
		if(win){
			system("CLS");
			if(mode==1){
			cout<<" AND THE WINNDER IS: "<<current.userSign<<" !!! Congratulations !"<<endl;
		}
			else if (current.userSign=='X'&& mode==2){
			cout<<" AND THE WINNDER IS: "<<current.userSign<<" !!! Congratulations! You are better than computer !"<<endl;
		}
			else if (current.userSign=='O' && mode ==2){
			cout<<" AND THE WINNDER IS: "<<current.userSign<<" !!! PC was better this time :(  !"<<endl;
		}
		
			cout<<""<<endl;
			cout<<"FINAL STAGE "<<endl;
			cout<<""<<endl;
			stage.displayStage();
			cout<<""<<endl;
			system("pause");
			break;			
		}
		
		if(draw){
			system("CLS");
			cout<<" AND THERE IS A DRAW ! LET'S TRY AGAIN' "<<endl;
			cout<<""<<endl;
			cout<<"FINAL STAGE "<<endl;
			cout<<""<<endl;
			stage.displayStage();
			cout<<""<<endl;
			system("pause");
			break;			
		}
		
		if(result){
			if(current.userSign=='X'){
				current.userSign='O';
			}
			else{
				current.userSign='X';
			}
		}
		system("CLS");
		stage.displayStage();
																		
	}		
	return 0;
}
