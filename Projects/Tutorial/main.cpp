#include<iostream>
#include "Bunny.h"
#include "BunnyList.h"
#include <string>
/*
 * main.c
 *
 *  Created on: 28.10.2015
 *      Author: Ahmad
 */
using namespace std;
int main ()
{
	BunnyList list;
	const string Sex[2] = { "Male", "Female"};
	const string Name[6] = { "THUMPER ", "OREO ", "LOLO ", "PEPPER ", "SMOKEY ", "PEANUT "};
	Bunny first;
	for (int i = 0; i < 4; i++) {
		Bunny first;
		list.addBunny(first);
		cout << "Bunny " + Name[first.getName()] + "was born!" + "\n";
	}
	Bunny* iterate = list.getHead();
	//cout << Name[iterate->getName()];
	cout << Name[iterate->getName()];
	//cout << Sex[iterate->getNext()->getNext()->getSex()];
	//cout << Sex[iterate->getNext()->getNext()->getNext()->getSex()];
	//cout << Name[iterate->getNext()->getNext()->getNext()->getNext()->getName()];


}
