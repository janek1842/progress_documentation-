#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <filesystem>
#include <sstream>
#include <ostream>
#include <cstdio>
#include <regex>

using namespace std;
void display_menu();

void back_to_menu()
{
    bool temp;
    cout << "Press ENTER to return to menu: ";
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    cin.get();
    display_menu();
}

bool validate_name_and_surname(string name){
    bool contains_non_alpha
    = !std::regex_match(name, std::regex("^[A-Za-z]+$"));

    if (contains_non_alpha){
        cout<<"Sorry but your string contains some non-alpha characters!"<<endl;
        return 0;
    }
    else{
        return 1;
    }
}

bool validate_index(string index){
    regex numberRegex("^[0-9]+$");
    ifstream file;
    file.open("student_list.csv");
    
    if(!regex_match(index, numberRegex)){
        cout<<"Sorry but your index contains non-numeric characters!\n"<<endl;
        
        file.close();
        return 0;
    }

    string line;
    while (getline(file, line))
    {
        std::istringstream stream(line);

        string element;
        vector<string> elements;

        while (getline(stream, element, ','))
        {
            elements.push_back(element);
        }

        if (!elements.empty())
        {

            string lastElement = elements.back();

            if (lastElement == index)
            {
                cout<<"Sorry, but your index is non-unique! \n"<<endl;
                
                file.close();
                return 0;
            }
        }
    }

    file.close();
    return 1;
}


void display_error_message()
{
    cout << "\nYou made it wrong! Please try again, next time type appropriate option" << endl;
    abort();
}

void display_student_list()
{
    cout << "\nPrinting student list\n"
         << endl;

    ifstream myfile;
    myfile.open("student_list.csv");

    while (myfile.peek() != EOF)
    {
        string records;
        getline(myfile, records);
        cout << records << endl;
    }

    myfile.close();
    cout << "\n"
         << endl;
    back_to_menu();
}

string enter_name(){
    string name;
    cout << "Name: " << endl;
    cin >>name;
    return name;
}

string enter_surname(){
    string surname;
    cout << "Surname: " << endl;
    cin >>surname;
    return surname;
}

string enter_index(){
    string index;
    cout << "Index: " << endl;
    cin >>index;
    return index;
}

void add_student_to_list()
{
    string file_name = "student_list.csv";
    vector<string> student_data(3);

    string name;
    do{
        name=enter_name();
    }while (!validate_name_and_surname(name));

    string surname;

    do{
        surname=enter_surname();
    }while (!validate_name_and_surname(surname));

    student_data[0]=name;
    student_data[1]=surname;

    string index; 
    do{
        index=enter_index();
    }while (!validate_index(index));

    student_data[2]=index;

    ofstream myFile;
    myFile.open(file_name, ios::app);

    for (int i = 0; i < student_data.size(); ++i)
    {
        myFile << student_data.at(i);
        if (i != student_data.size() - 1)
        {
            myFile << ",";
        }
        else
        {
            myFile << "\n";
        }
    }
    myFile.close();
    
    cout << "Student added successfully" << endl;
    back_to_menu();
}

void remove_student_list()
{
    string index;
    cout << "Provide student index for removal: ";
    cin >> index;
    bool student_captured = 0;
    cout << "\n";

    ifstream oldfile;
    oldfile.open("student_list.csv");

    ofstream newfile;
    newfile.open("new_student_list.csv");

    string line;
    while (getline(oldfile, line))
    {
        std::istringstream stream(line);

        string element;
        vector<string> elements;

        while (getline(stream, element, ','))
        {
            elements.push_back(element);
        }

        if (!elements.empty())
        {

            string lastElement = elements.back();

            if (lastElement == index)
            {
                cout << "Removing student with index: " << index << endl;
                student_captured = 1;
            }

            else
            {
                newfile << line << endl;
            }
        }
    }

    if (!student_captured)
    {
        cout << "Sorry, but there is no student with index: " << index << endl;
        cout << "\n"
             << endl;

        oldfile.close();
        newfile.close();

        remove("new_student_list.csv");
        back_to_menu();
    }
    else
    {
        cout << "Student with index " << index << " removed" << endl;
        cout << "\n"
             << endl;

        oldfile.close();
        newfile.close();

        bool ac = remove("student_list.csv");
        bool bc=rename("new_student_list.csv", "student_list.csv");

        back_to_menu();
    }
}

void display_menu()
{
    int choice;
    cout << "\n"
         << endl;
    cout << "Student List Program \n"
         << endl;
    cout << "1 - Display student list" << endl;
    cout << "2 - Add student to list" << endl;
    cout << "3 - Remove student from list" << endl;
    cout << "4 - Sort student list by surname" << endl;
    cout << "5 - Sort student list by index" << endl;
    cout << "Choose desired option: ";
    cin >> choice;

    switch (choice)
    {
    case 1:
        display_student_list();
        break;
    case 2:
        add_student_to_list();
        break;
    case 3:
        remove_student_list();
        break;
    case 4:
        display_student_list();
        break;
    case 5:
        display_student_list();
        break;
    default:
        display_error_message();
    }
}

void check_if_file_exists_or_create()
{
    remove("new_student_list.csv");
    string file_name = "student_list.csv";
    ifstream inputFile(file_name);

    if (!inputFile.good())
    {
        cout << "Student database has not been detected, creating ... \n"
             << endl;
        ofstream myFile("student_list.csv");
        vector<string> initial_data(3);

        initial_data[0] = "name,";
        initial_data[1] = "surname,";
        initial_data[2] = "index\n";

        myFile << initial_data.at(0);
        myFile << initial_data.at(1);
        myFile << initial_data.at(2);

        cout << "New student database created! \n"
             << endl;
    }
    else
    {
        cout << "Student database has been detected!\n"
             << endl;
    }
}

int main()
{
    check_if_file_exists_or_create();
    display_menu();
    return 0;
}